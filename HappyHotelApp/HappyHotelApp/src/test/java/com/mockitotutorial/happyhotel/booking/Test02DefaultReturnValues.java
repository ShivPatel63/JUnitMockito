package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test02DefaultReturnValues {
	
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
		
		System.out.println("List Returned ::" +roomServiceMock.getAvailableRooms());
		System.out.println("Object Returned ::" +roomServiceMock.findAvailableRoomId(null));
		System.out.println("Primitive Returned ::" +roomServiceMock.getRoomCount());
		
	}
	

	@Test
	void should_CountAvailablePlaces() { 
		//Given 
		int expected = 0;
		 
		//When 
		int actual = bookingService.getAvailablePlaceCount();
		//then
		assertEquals(expected,actual);
		
	}

}
