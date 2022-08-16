package com.coforge.training.airline.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.Model;

import com.coforge.training.airline.model.AdminContent;
import com.coforge.training.airline.repository.AdminContentRepo;
import com.coforge.training.airline.service.AdminContentService;

class AdminContentControllerTest {
	
	AdminContentController admincontroller=new AdminContentController();
	
	@Mock
	private AdminContentService service;
	
	@Mock
	private AdminContentRepo repo;
	
	@Spy
	private Model model;
	
	@Spy
	List<AdminContent> admin=new ArrayList<AdminContent>();
	
	@Spy
	HttpServletRequest req;

	@Spy
	HttpSession ses;
	

	@BeforeEach
	public void init() throws Exception 
	{
		MockitoAnnotations.openMocks(this);
		admin=setAdminContent();
	}
	
	
	private List<AdminContent> setAdminContent()
	{

		List<AdminContent> res=new ArrayList<AdminContent>();
		
		AdminContent add=new AdminContent();
		
		add.setAdminemail("vikasdhiman@gmail.com");
		res.add(add);
		
		return res;
	}


	@Test
	void testSave() {
		
		AdminContent add=new AdminContent();
		
		add.setAdminemail(admin.get(0).getAdminemail());
		
		when(service.newAdmin(admin.get(0))).thenReturn(add);
		
		AdminContent res=service.newAdmin(add);
		
		assertEquals(add, res);
		
		assertNotNull(res);

		verify(service,times(1)).newAdmin(add);
		
	}

	@Test
	void testGetAllAdmin() {
		
		List<AdminContent> res=admin;
		
		when(service.getAllAdmin()).thenReturn(res);
		
		res=service.getAllAdmin();

		assertNotNull(res);
		
		verify(service,times(1)).getAllAdmin();

	}

	@Test
	void testGetOneAdmin() {
		
		AdminContent res=new AdminContent();
		res.setAdminemail(admin.get(0).getAdminemail());
		
		when(service.getOneAdmin(admin.get(0).getAdminemail())).thenReturn(res);
		
		AdminContent addc=service.getOneAdmin(admin.get(0).getAdminemail());
		
		assertNotNull(addc.getAdminemail());
		
		verify(service,times(1)).getOneAdmin(admin.get(0).getAdminemail());	
	}

	@Test
	void testDeleteMapping() {
		
		String response = "Id is deleted";
		
		when(service.deleteAdmin(admin.get(0).getAdminemail())).thenReturn(response);

		String str=service.deleteAdmin(admin.get(0).getAdminemail());
		
		assertNotNull(str);
		
		verify(service,times(1)).deleteAdmin(admin.get(0).getAdminemail());
		
	}

}