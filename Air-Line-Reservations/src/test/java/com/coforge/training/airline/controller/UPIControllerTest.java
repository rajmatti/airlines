package com.coforge.training.airline.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.Model;

import com.coforge.training.airline.model.AdminContent;
import com.coforge.training.airline.model.UPI;
import com.coforge.training.airline.repository.AdminContentRepo;
import com.coforge.training.airline.repository.UPIRepository;
import com.coforge.training.airline.service.AdminContentService;
import com.coforge.training.airline.service.UPIService;

class UPIControllerTest {

	UPIController upicontroller=new UPIController();

	@Mock
	private UPIService service;

	@Mock
	private UPIRepository repo;

	@Spy
	private Model model;

	@Spy
	List<UPI> upilist=new ArrayList<UPI>();

	@Spy
	HttpServletRequest req;

	@Spy
	HttpSession ses;


	@BeforeEach
	public void init() throws Exception 
	{
		MockitoAnnotations.openMocks(this);
		upilist=setAdminContent();
	}

	private List<UPI> setAdminContent()
	{

		List<UPI> res=new ArrayList<UPI>();

		UPI add=new UPI();

		add.setUpiid("vikas@upi");
		add.setCode(1233);
		res.add(add);

		return res;
	}

	@Test
	void testSaveUPI() {
		UPI newupi=upilist.get(0);

		when(service.saveUPI(upilist.get(0))).thenReturn(newupi);

		UPI res=service.saveUPI(newupi);

		assertEquals(res, newupi);

		verify(service,times(1)).saveUPI(newupi);
	}

	@Test
	void testGetAllUPI() {
		List<UPI> lis=upilist;

		when(service.getAll()).thenReturn(lis);

		List<UPI> res=service.getAll();

		assertEquals(lis,res);
		assertNotNull(res);

		verify(service,times(1)).getAll();
	}

	@Test
	void testVerifyUPI() {
		Boolean check=true;

		final String upi="vikasdhiman@upi";

		when(service.verify(upi)).thenReturn(check);

		boolean res= service.verify(upi);

		assertTrue(res);
		assertEquals(res, check);

		verify(service,times(1)).verify(upi);
	}

	@Test
	void testVerifyUPIData() {
		Boolean check=true;

		when(service.verifyByUPIData(upilist.get(0))).thenReturn(check);

		boolean res= service.verifyByUPIData(upilist.get(0));

		assertTrue(res);
		assertEquals(res, check);

		verify(service,times(1)).verifyByUPIData(upilist.get(0));
	}

}
