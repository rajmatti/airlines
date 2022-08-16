package com.coforge.training.airline.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.Address;
import com.coforge.training.airline.model.Passport;
import com.coforge.training.airline.model.User;
import com.coforge.training.airline.repository.UserRepo;
import com.coforge.training.airline.response.UpdateUserResponse;
import com.coforge.training.airline.service.UpdateUserService;

@Service
public class UpdateUserServiceImpl implements UpdateUserService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public UpdateUserResponse updateUser(long userid, User user) 
	{
		UpdateUserResponse res=new UpdateUserResponse();
		
		if(repo.existsById(userid) && repo.existsByEmail(user.getEmail()))
		{
			if(user.getPassport().getPassportno()!=null)
			{
//				set in previous user
				User newuser=repo.findById(userid).get();
				newuser.setFirstname(user.getFirstname());
				newuser.setLastname(user.getLastname());
				newuser.setMobileno(user.getMobileno());
				newuser.setDob(user.getDob());
				newuser.setGender(user.getGender());
				newuser.setCompleteprofile(true);
				
//				set address
				Address newaddres=newuser.getAddress();
				if(newaddres==null)
				{
					newaddres=new Address();
				}
				newaddres.setUsercity(user.getAddress().getUsercity());
				newaddres.setUsercountry(user.getAddress().getUsercountry());
				newaddres.setUserhouseno(user.getAddress().getUserhouseno());
				newaddres.setUserid(user.getUserid());
				newaddres.setUserpincode(user.getAddress().getUserpincode());
				newaddres.setUserstate(user.getAddress().getUserstate());
				newaddres.setUserStreet(user.getAddress().getUserStreet());
				
				newuser.setAddress(newaddres);
				
//				set passport
				Passport newpassport=newuser.getPassport();
				if(newpassport==null)
				{
					newpassport=new Passport();
				}
				newpassport.setExpiredate(user.getPassport().getExpiredate());
				newpassport.setIssuedate(user.getPassport().getIssuedate());
				newpassport.setPassportno(user.getPassport().getPassportno());
				newpassport.setUserid(userid);
				
				newuser.setPassport(newpassport);
				
//				save user
				User updateuser=repo.save(newuser);
				
//				return
				res.setMessage("User is updated");
				res.setEmail(user.getEmail());
				res.setCheck(true);
				res.setUser(updateuser);	
			}
		}
		else
		{
			res.setMessage("User id is not exist");
			res.setCheck(false);
			res.setEmail(user.getEmail());
		}
		
		return res;
	}

	@Override
	public UpdateUserResponse updatePassword(long userid, User user) {
		
		UpdateUserResponse res=new UpdateUserResponse();
		User newUser=repo.findById(userid).get();
		if(repo.existsById(userid) && repo.existsByEmail(user.getEmail()))
		{
			String password=user.getPassword();
			String encpass=encryptedPassword(password);
			if(newUser.getPassword()==encpass)
			{
				res.setMessage("Do not enter your last ");
				res.setCheck(false);
				res.setEmail(user.getEmail());
				res.setUser(user);
				return res;
			}
			else
			{
				newUser.setPassword(encpass);
				User saveUser=repo.save(newUser);
				
				res.setMessage("Password is Change");
				res.setCheck(true);
				res.setEmail(user.getEmail());
				res.setUser(saveUser);
			}
		}
		else
		{
			res.setMessage("User id is not exist");
			res.setCheck(false);
			res.setEmail(user.getEmail());
		}
		return res;
	}
	
	public String encryptedPassword(String password)
	{
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = password;
		String encodedString = encoder.encodeToString(
		normalString.getBytes(StandardCharsets.UTF_8) );
		return encodedString;
	}

}
