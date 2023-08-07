package org.cap.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.cap.demo.model.Address;
import org.cap.demo.model.Customer;
import org.cap.demo.service.IService;
import org.cap.demo.service.ServiceImpl;
import org.cap.demo.util.InSufficientOpeningbalanceException;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ServiceLayerTest {
	
	private IService service;
	
	@BeforeEach
	public void init() {
		service=new ServiceImpl();
		//System.out.println("BeforeEach Triggered.............");
	}
	
	@AfterEach
	public void cleanUp() {
		service=null;
		//System.out.println("AfterEach Triggered.............");
	}
	
	
	@Test
	void test_sumOfnumbers() {
		//service=new ServiceImpl();
		//System.out.println("TestCase - test_sumOfnumbers------------------------------");
		assertNotNull(service);
		
		int output= service.sumOfNumbers(5);
		assertEquals(15, output);
	}
	
	@Test
	void test_CreateAccountMethod_withNullCustomer() {
		
		//System.out.println("TestCase - test_CreateAccountMethod_withNullCustomer------------------------------");
		//service=new ServiceImpl();
		Customer customer=null;
		
		Exception exception= assertThrows(IllegalArgumentException.class, () -> {
			service.createAccount(customer, 2000);
		});
		
		
		assertEquals("Customer Object should not be null!", exception.getMessage());
		
	}
	
	@Test
	void test_InsufficientOpening() {
		Address address=new Address("Line1","Pune");
		Customer customer=new Customer(1, "Sachin","Tendulkar", address);
		Exception exception=assertThrows(InSufficientOpeningbalanceException.class,()->{
			service.createAccount(customer, 500);}
				);
		
		
	}
	
	@ParameterizedTest
	@MethodSource("getAllValues")
	public void testSumArray(int[] array, int output) {
		assertEquals(service.sumOfArray(array), output);
		
	}
	
	static Stream<Arguments> getAllValues(){
		
		return Stream.of(
				arguments(new int[] {1,1,1,1,1},5),
				arguments(new int[] {2,2,2},6)
				);
	}

	
	
	

}
