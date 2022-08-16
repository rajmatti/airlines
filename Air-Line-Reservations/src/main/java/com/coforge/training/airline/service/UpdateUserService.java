package com.coforge.training.airline.service;

import com.coforge.training.airline.model.User;
import com.coforge.training.airline.response.UpdateUserResponse;

public interface UpdateUserService {

	UpdateUserResponse updateUser(long userid, User user);

	UpdateUserResponse updatePassword(long userid, User user);

}
