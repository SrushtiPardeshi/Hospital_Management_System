package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Patient;
import com.nt.service.IPatientService;

@Controller
public class ShowHomeController {

	@Autowired
	private IPatientService patService;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/report")
	public String fetchAllPatient(Map<String,Object> map) {
		Iterable<Patient> it=patService.showAllPatientsRecord();
		System.out.println("ShowHomeController.fetchAllPatient()");
		map.put("patList",it);
		return "show_report";
	}
	
	@GetMapping("/register")
	public String showRegisterPatientForm(@ModelAttribute("pat") Patient pat) {
		return "pat_register_form";
	}

	
	@PostMapping("/register")
	public String addNewPatientData(@ModelAttribute("pat") Patient pat,
			                                                      RedirectAttributes map) {
		String msg=patService.addPatientData(pat);
		System.out.println("ShowHomeController.addNewPatientData()");
		map.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("id") int id,
			                                       @ModelAttribute("pat") Patient pat) {
		Patient pat1=patService.fetchPatientById(id);
		BeanUtils.copyProperties(pat1, pat);
		return "pat_edit_form";
	}
	
	@PostMapping("/edit")
	public String editPatientData(@ModelAttribute("pat") Patient pat,
			                                         RedirectAttributes attrs) {
		
		String msg=patService.ModifyPatientRecord(pat);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deletePatientInfo(@RequestParam("id") int id,
			                                                RedirectAttributes attrs) {
		String msg=patService.deletePatientById(id);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		
		return "admin_login_page";
	}
	
	@PostMapping("/adminlog")
	public String loginAdminPage(@RequestParam("username") String user,
			                         @RequestParam("password") String pass,Map<String,Object> map) {
		System.out.println(user+"::"+pass);
		System.out.println("ShowHomeController.loginAdminPage()");
		if(user.equalsIgnoreCase("admin") && pass.equals("admin")) {
			Iterable<Patient> it=patService.showAllPatientsRecord();
			List<Patient> itt=new ArrayList<>();
			it.forEach((pt)->{
				if(pt.isCoronavirus()==true) {
					itt.add(pt);
					System.out.println("c");
				}
				
			});
			map.put("patarray",itt);
       		return "admin_dashboard_page";
       	}
       	else {
       		return "admin_login_page";	
       	}
		
	
       		
	}

}
	
	

