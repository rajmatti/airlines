package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.User;
import com.coforge.training.airline.request.VerifyUserCrenditials;
import com.coforge.training.airline.response.LoginUserResponse;
import com.coforge.training.airline.response.RegisterNewUser;
import com.coforge.training.airline.response.UpdateUserPasswordResponse;

public interface LoginService {

	RegisterNewUser registerNewUser(User user);

	LoginUserResponse loginUser(User user);

	List<User> getAllUser();

	boolean verifyEmail(String email);

	boolean verifyUserdata(VerifyUserCrenditials verifydata);

	UpdateUserPasswordResponse updatePassword(String email, User updateduser);

	User getUserById(long userid);

	User getUserByEmail(String email);

}
