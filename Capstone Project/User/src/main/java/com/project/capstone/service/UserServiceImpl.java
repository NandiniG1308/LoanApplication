package com.project.capstone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capstone.exceptions.UserAlreadyExistsException;
import com.project.capstone.exceptions.UserNotFoundException;
import com.project.capstone.model.User;
import com.project.capstone.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User registerUser(User user) throws UserAlreadyExistsException {
//		User savedUser = null;
		if (repository.existsById(user.getEmail())) {
			throw new UserAlreadyExistsException("User " + user.getUserName() + " already exists");
		} else {

			 User savedUser = repository.save(user);

			if (savedUser == null) {
				throw new UserAlreadyExistsException("User " + user.getUserName() + "already exists");
			}
			return savedUser;
		}

//		return savedUser;
	}

	@Override
	public User updateUser(String email, User user) throws UserNotFoundException {
		User currentUser = repository.findById(email).get();

		try {
			if(currentUser!=null) {
		
				currentUser.setUserName(user.getUserName());
				currentUser.setAddress(user.getAddress());
				currentUser.setPhoneNo(user.getPhoneNo());
				currentUser.setPassword(user.getPassword());

			repository.save(currentUser);
			}
			return currentUser;
			
		} catch (Exception e) {
			throw new UserNotFoundException("User " + user.getUserName() + " Not found");
		}

	}

	@Override
	public boolean deleteUser(String email) throws UserNotFoundException {
		boolean status = false;
		try {
			User user = repository.findById(email).get();
			if (user != null) {
				repository.delete(user);
				status = true;
			}
		} catch (Exception e) {
			throw new UserNotFoundException("User not found");
		}

		return status;
	}

	@Override
	public User getUserById(String userName) throws UserNotFoundException {
		User user = repository.findById(userName).get();
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
		return user;
	}

	@Override
	public boolean validate(String emailId, String password) throws UserAlreadyExistsException {
		try {
			User user = repository.findById(emailId).get();

			if (user != null) {

				String storedPassword = user.getPassword();

				if (password.equals(storedPassword)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

}
