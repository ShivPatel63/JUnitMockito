package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test01FirstMock {
	
	private BookingService bookingService;
	private PaymentService paymentServiceMock; 
	private RoomService roomServiceMock; 
	private BookingDAO bookingDAOMock;
	private MailSender mailSenderMock;
	
	@BeforeEach
	void setup() {
		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDAOMock = mock(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);
		
		this.bookingService = new BookingService(paymentServiceMock,roomServiceMock,
				bookingDAOMock, mailSenderMock);
		
	}
	

	@Test
	void should_CalculateCorrectPrice_whenCorrectInput() { 
		//Given 
		BookingRequest bookingRequest = new BookingRequest("1",LocalDate.of(2024, 01, 01),
				LocalDate.of(2024,01, 05),2,false);
		
		double expected = 4*2*50.0;
		
		//When 
		double actual = bookingService.calculatePrice(bookingRequest);
		//then
		assertEquals(expected,actual);
		
	}

}
