package com.cpu_makes.folder.Controller;

import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpu_makes.folder.Entity.UserDetails;
import com.cpu_makes.folder.Repository.UserDetailsRepo;
import com.cpu_makes.folder.services.MainService;
import com.cpu_makes.folder.servicesImpl.Service_Impl;

@Controller
public class MainController {
	private UserDetailsRepo ud;
	private MainService implService;

	public MainController(UserDetailsRepo ud, MainService implService) {
		this.ud = ud;
		this.implService=implService;
	}

	@RequestMapping("/")
	String indexPage(HttpSession session) {
		if(session.getAttribute("id")==null) {
			return "Signin";
		}
		
		return "redirect:home";
	}
	
	@PostMapping("/signin")
	String RegisterPage(@ModelAttribute UserDetails userDetails) {
		ud.save(userDetails);
		return "redirect:/";
	}
	
	@GetMapping("/home")
	String home(HttpSession session, HttpServletRequest request) {
		System.out.println(session.getAttribute("id"));
		if(session.getAttribute("id")==null) {
			return "redirect:/";
		}
		return "home";
	}
	
	@PostMapping("/login")
	String LoginPage(@RequestParam("email") String mail,@RequestParam("password") String pass, HttpSession session)
	{
		Optional<UserDetails> b=implService.checkUser(mail, pass);
		if(b.isPresent()) {
			session.setAttribute("user", b.get().getUsername());
			session.setAttribute("id",session.getId());
			session.setMaxInactiveInterval(12);
			return "redirect:home";
		}
		return "redirect:/";
	}
	
	@GetMapping("/customize")
	String Customize(HttpSession session) {
		if(session.getAttribute("id")==null) {
			return "redirect:/";
		}
		return "customize";
	}
	
	@RequestMapping("/Logout")
	String logout(HttpSession session,HttpServletRequest request) {
		session=request.getSession(false);
		if(request.getSession(false)!=null) {
			System.out.println(session.getAttribute("id"));
			session.invalidate();
			
		}
		return "redirect:/";
	}
}
