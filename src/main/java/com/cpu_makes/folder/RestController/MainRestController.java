package com.cpu_makes.folder.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cpu_makes.folder.Entity.CustomizeCpuDetails;
import com.cpu_makes.folder.Repository.CustomizeCpuDetailsRepo;

@RestController
@RequestMapping("details")
public class MainRestController {
	private CustomizeCpuDetailsRepo custom;
	
	public MainRestController(CustomizeCpuDetailsRepo custom) {
	
		this.custom = custom;
	}

	@GetMapping("/data")
	@ResponseStatus(code = HttpStatus.OK)
	ResponseEntity<List<CustomizeCpuDetails>> getValue(){
		
		List<CustomizeCpuDetails> detl=custom.findAll();
		return new ResponseEntity<>(detl,HttpStatus.OK);
	}

}
