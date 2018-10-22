package com.mycompany.profile.core.domain.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HCCustomerImplTests {

	@Test
	void testLoadClassObject() {
		try {
			Class<?> clazz = Class.forName("com.mycompany.profile.core.domain.HCCustomerImpl");
			
			assertNotNull(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail("ClassNotFoundException: " + e.getMessage());
		}
	}

	@Test
	void testIsAssignableFrom() {
		try {
			Class<?> clazz = Class.forName("com.mycompany.profile.core.domain.HCCustomerImpl");
			
			Class<?> cls = Class.forName("com.mycompany.profile.core.domain.HCCustomerImpl");
			
			boolean isAssignable = clazz.isAssignableFrom(cls);
			
			assertTrue(isAssignable);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail("ClassNotFoundException: " + e.getMessage());
		}
	}
	
}
