package com.coforge.training.airline.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.enums.rolesEnums;
import com.coforge.training.airline.model.Address;
import com.coforge.training.airline.model.User;
import com.coforge.training.airline.repository.AdminContentRepo;
import com.coforge.training.airline.repository.UserRepo;
import com.coforge.training.airline.request.VerifyUserCrenditials;
import com.coforge.training.airline.response.LoginUserResponse;
import com.coforge.training.airline.response.RegisterNewUser;
import com.coforge.training.airline.response.UpdateUserPasswordResponse;
import com.coforge.training.airline.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepo repo;

	@Autowired
	private AdminContentRepo adminrepo;


	@Override
	public RegisterNewUser registerNewUser(User registerUser) {
		RegisterNewUser res=new RegisterNewUser();

		if(!repo.existsByEmail(registerUser.getEmail()))
		{
			if(adminrepo.existsById(registerUser.getEmail()))
			{

				registerUser.setRole(rolesEnums.Admin);
				registerUser.setJoindate(new Date());
				registerUser.setAvatar("https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png");
				registerUser.setCompleteprofile(false);

				String password=registerUser.getPassword();
				String encpass=encryptedPassword(password);
				registerUser.setPassword(encpass);

				User saveuser=repo.save(registerUser);
				res.setMessage("User is Register");
				res.setEmail(registerUser.getEmail());
				res.setUser(saveuser);
			}
			if(!adminrepo.existsById(registerUser.getEmail()))
			{

				registerUser.setRole(rolesEnums.Normal_User);
				registerUser.setJoindate(new Date());
				registerUser.setAvatar("https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png");
				registerUser.setCompleteprofile(false);

				String password=registerUser.getPassword();
				String encpass=encryptedPassword(password);
				registerUser.setPassword(encpass);

				User saveuser=repo.save(registerUser);
				res.setMessage("User is Register");
				res.setEmail(registerUser.getEmail());
				res.setUser(saveuser);
			}
		}
		else
		{
			res.setMessage("User is Already Exist");
			res.setEmail(registerUser.getEmail());
		}
		return res;
	}


	@Override
	public LoginUserResponse loginUser(User user) {

		LoginUserResponse res=new LoginUserResponse();

		if(repo.existsByEmail(user.getEmail()))
		{
			String password=user.getPassword();
			String encpass=encryptedPassword(password);
			user.setPassword(encpass);
			if(repo.existsByEmailAndPassword(user.getEmail(),user.getPassword()))
			{
				res.setMessage("Login Succesfully");
				res.setLogin(true);
				res.setEmail(user.getEmail());
				res.setUser(repo.findByEmail(user.getEmail()));
			}
			else
			{
				res.setMessage("User Password is wrong");
				res.setEmail(user.getEmail());
				res.setLogin(false);
			}
		}
		else
		{
			res.setMessage("User does not exist");
			res.setEmail(user.getEmail());
			res.setLogin(false);
		}


		return res;
	}


	//	Encrypt Password 
	public String encryptedPassword(String password)
	{
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = password;
		String encodedString = encoder.encodeToString(
				normalString.getBytes(StandardCharsets.UTF_8) );
		return encodedString;
	}


	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}


	@Override
	public boolean verifyEmail(String email) {
		return repo.existsByEmail(email);
	}


	@Override
	public boolean verifyUserdata(VerifyUserCrenditials verifydata) {

		boolean res=false;
		if(repo.existsByEmailAndMobileno(verifydata.getEmail(),verifydata.getPhoneno()))
		{
			res=true;
			return res;
		}
		return res;
	}


	@Override
	public UpdateUserPasswordResponse updatePassword(String email, User updateduser) {
		UpdateUserPasswordResponse res=new UpdateUserPasswordResponse();

		if(repo.existsByEmail(email))
		{
			User user=repo.findByEmail(email);

			user.setPassword(encryptedPassword(updateduser.getPassword()));

			repo.save(user);
			res.setMessage("User is Updated");
			res.setEmail(email);
		}
		else
		{
			res.setMessage("Email is not confirm");
		}


		return res;
	}


	@Override
	public User getUserById(long userid) {
		return repo.findById(userid).get();
	}


	@Override
	public User getUserByEmail(String email) {
		return repo.findByEmail(email);
	}



}
