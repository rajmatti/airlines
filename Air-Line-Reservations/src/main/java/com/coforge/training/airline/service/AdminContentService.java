package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.AdminContent;

public interface AdminContentService {

	public AdminContent newAdmin(AdminContent admin);

	public List<AdminContent> getAllAdmin();

	public AdminContent getOneAdmin(String email);

	public String deleteAdmin(String email);

}
