package uk.org.redalert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/secure/*")
public class UserController {
    private final String INDEX = "index";
    private final String PAGE_NAME = "pageName";

    @RequestMapping("signin")
    public String signInRequest(ModelMap map){
        map.addAttribute(PAGE_NAME, "reviews.jsp");
        return INDEX;
    }
}
