package com.project.capstone.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.capstone.exceptions.UserAlreadyExistsException;
import com.project.capstone.exceptions.UserNotFoundException;
import com.project.capstone.model.User;
import com.project.capstone.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
    private UserService service;

    private String jwtToken;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try {
            User registeredUser=service.registerUser(user);
            return new ResponseEntity<User>(registeredUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email,@RequestBody User user){
        try {
            User currentUser=service.updateUser(email,user);
            return new ResponseEntity<User>(currentUser,HttpStatus.ACCEPTED);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        try {
            boolean deleteUser=service.deleteUser(email);
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserById(@PathVariable String email){
        try {
            User user=service.getUserById(email);
            return new ResponseEntity<>(user,HttpStatus.FOUND);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user, HttpSession session) throws UserAlreadyExistsException{
        boolean flag=service.validate(user.getEmail(),user.getPassword());
        if(flag){
            session.setAttribute("name",user.getEmail());
            jwtToken=generateToken(user.getEmail());
            return new ResponseEntity<String>(jwtToken, HttpStatus.OK);
        }else{
           return new ResponseEntity<>("failed to login",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser( HttpSession session){

        if((session!=null) && (session.getAttribute("name")!=null)){
            session.invalidate();
            return new ResponseEntity<String>("Logged out successfully", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("failed to logout",HttpStatus.CONFLICT);
        }
    }

    public String generateToken(String emailId){
        String token= Jwts.builder()
                .setSubject(emailId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+300000))
                .signWith(SignatureAlgorithm.HS256,"secretKey")
                .compact(); //encrypt the data
        System.out.println("Token: "+token);
        return token;
    }
	
	

}
