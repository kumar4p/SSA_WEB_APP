package com.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ats.entity.CitizenEntity;
import com.ats.model.CitizenModel;
import com.ats.service.SSACitizenService;
import com.ats.service.StateService;

@Controller
public class FormController {
	@Autowired
	private StateService stateService;
	@Autowired
	private SSACitizenService ssaCtznSrvc;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String loadForm(Model model) {
		model.addAttribute("citizen",new CitizenEntity());
		model.addAttribute("states",stateService.getStatesMap())
		return "ssaForm";
	}//loadForm
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String handleSbmtBtn(@ModelAttribute("citizen") CitizenModel citizenModel, RedirectAttributes redirectAttributes) {
		boolean flag = ssaCtznSrvc.registerCitizen(citizenModel);
		if(flag)
			redirectAttributes.addAttribute("succMsg", "Successfully Registered");
		else
			redirectAttributes.addAttribute("errMsg", "Failed To Register");
		return "redirect:/";
	}//handleSbmtBtn(-,-)
}//class
