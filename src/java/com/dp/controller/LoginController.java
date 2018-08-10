/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.controller;

import com.dp.model.LoginBean;
import com.dp.salesforce.RetrieveMetadata;
import com.dp.util.AjaxResponseBody;
import com.dp.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import static com.sforce.soap.metadata.FieldType.Date;
import java.util.Date;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Siddhrajsinh_Atodari
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        //map.addAttribute("hello", "Hello Spring from Netbeans!!");
        LoginBean loginForm = new LoginBean();
        map.put("loginForm", loginForm);
        return "login";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public String view(@ModelAttribute("loginForm") LoginBean login, ModelMap map) {
        System.out.println("Here---->" + login.getSrcusername());
        map.addAttribute("name", login.getSrcusername());
        return "view";
    }

    @RequestMapping(value = "/apex", method = RequestMethod.GET)
    public String apex(ModelMap map) {
        return "apex";
    }

    @RequestMapping(value = "/viewpage", method = RequestMethod.GET)
    public String view(ModelMap map) {
        return "view";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(ModelMap map) {
        return "profile";
    }
    
    @RequestMapping(value = "/apexClasses", method = RequestMethod.GET)
    public @ResponseBody
    String getApexClasses() {
        
        Gson gson = new Gson();
        String json = gson.toJson(RetrieveMetadata.getApexClasses());
        return json;
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "/getApex",method=RequestMethod.POST)
    public AjaxResponseBody getApex() {
        System.out.println("--i m here--");

        AjaxResponseBody result = new AjaxResponseBody();

        /*if (isValidSearchCriteria(search)) {
			List<User> users = findByUserNameOrEmail(search.getUsername(), search.getEmail());

			if (users.size() > 0) {
				result.setCode("200");
				result.setMsg("");
				result.setResult(users);
			} else {
				result.setCode("204");
				result.setMsg("No user!");
			}

		} else {
			result.setCode("400");
			result.setMsg("Search criteria is empty!");
		}*/
        //AjaxResponseBody will be converted into json format and send back to the request.
        result.setCode("204");
        result.setMsg("No user!");
        return result;

    }
}
