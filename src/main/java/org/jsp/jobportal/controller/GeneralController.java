package org.jsp.jobportal.controller;

import java.time.LocalDate;

import org.jsp.jobportal.dao.PortalUserDao;
import org.jsp.jobportal.dto.PortalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
@Controller
public class GeneralController {
	@Autowired
	PortalUser portalUser;
	@Autowired
	PortalUserDao userDao;
	
  @GetMapping("/")
 public String loadHome() {
	 return "home.html";
 }
  @GetMapping("/login")
  public String loadLogin() {
	  return "login.html";
  }
  @GetMapping("/signup")
  public String loadSignup(ModelMap map) {
	  map.put("portalUser", portalUser);
	  return "signup.html";
  }
  @PostMapping("/signup")
  public String signup(@Valid PortalUser portalUser,BindingResult result) {
	  if(LocalDate.now().getYear()- portalUser.getDob().getYear()<18) {
		  result.rejectValue("dob", "error.dob","Age should be greater than 18");
	  }
	  if(!portalUser.getPassword().equals(portalUser.getConfirmpassword())) {
		  result.rejectValue("confirm password", "error.confirm password","*password and Confirm Password should be matching");
	  }
	  if(userDao.existsByEmail(portalUser.getEmail())) {
		  result.rejectValue("email", "error.email","email should be Unique");
	  }
	  if(result.hasErrors()) {
		  return "signup.html";
	  }else {
		  return "login.html";
	  }
  }
}
