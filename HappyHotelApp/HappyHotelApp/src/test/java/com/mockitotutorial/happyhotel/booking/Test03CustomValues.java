package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test03CustomValues {
	
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
	void should_CountAvailablePlaces_WhenRoomAvailable() { 
		//Given 
		when(this.roomServiceMock.getAvailableRooms())
		.thenReturn(Collections.singletonList(new Room("Room 1",5)));
		int expected = 5;
		
		//System.out.println("List Return :: " +roomServiceMock.getRoomCount());
		 
		//When 
		int actual = bookingService.getAvailablePlaceCount();
		System.out.println("List Return :: " +roomServiceMock.getRoomCount());
		//then
		assertEquals(expected,actual);
		
	}



@Test
void should_CountAvailablePlaces_WhenMultipleRoomAvailable() { 
	//Given 
	List<Room> rooms = Arrays.asList(new Room("Room 1",2), new Room("Room 2",5));
	when(this.roomServiceMock.getAvailableRooms()).thenReturn(rooms);
	
	int expected = 7;
	
	//System.out.println("List Return :: " +roomServiceMock.getRoomCount());
	 
	//When 
	int actual = bookingService.getAvailablePlaceCount();
	
	System.out.println("List Return :: " +roomServiceMock.getRoomCount());
	//then
	assertEquals(expected,actual);
	
}

}

