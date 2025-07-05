package com.project.capstone.service;



import com.project.capstone.exceptions.UserAlreadyExistsException;
import com.project.capstone.exceptions.UserNotFoundException;
import com.project.capstone.model.User;

public interface UserService {
	
//  Save/add the user
  public User registerUser(User user) throws UserAlreadyExistsException;

//  update the user
  public User updateUser(String userId,User user) throws UserNotFoundException;

//  delete the user
  public boolean deleteUser(String userId) throws UserNotFoundException;
//  get user by id
  public User getUserById(String userId) throws UserNotFoundException;
//
  public boolean validate(String emailId,String password) throws UserAlreadyExistsException;

}
