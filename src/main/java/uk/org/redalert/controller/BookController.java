package uk.org.redalert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.org.redalert.dbmapping.UserEntity;
import uk.org.redalert.email.Email;
import uk.org.redalert.userdao.UserDAO;

import java.io.UnsupportedEncodingException;

@Controller
public class BookController {
    private final String INDEX = "index";
    private final String PAGE_NAME = "pageName";

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeController(ModelMap map) {
        map.addAttribute("user", new UserEntity());
        map.addAttribute("userList", userDAO.getAllUsers());
        map.addAttribute(PAGE_NAME, "home.jsp");
        map.addAttribute("title", "Red Alert | Money Laundering Cases & Materials");
        map.addAttribute("description", "his Book is intended to serve as a comprehensive source of information for money laundering professionals that wish to better understand, establish or improve their money laundering, terrorist financing, fraud, sanctions, bribery and corruption prevention frameworks (hereafter referred to as money laundering).");
        return INDEX;
    }
//
//    @RequestMapping(value = "/table_of_contents", method = RequestMethod.GET)
//    public String topicsController(ModelMap map) {
//        map.addAttribute(PAGE_NAME, "contents.jsp");
//        return INDEX;
//    }

    @RequestMapping(value = "/biography", method = RequestMethod.GET)
    public String biographyController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "biography.jsp");
        map.addAttribute("title", "Red Alert | John Cusack");
        map.addAttribute("description", "John Cusack is one of the World's longest serving Money Laundering Prevention Heads, joining UBS over 20 years ago, as a qualified English Lawyer, undertaking senior roles in both Legal and Compliance across much of the firm, including in Investment Banking, Correspondent and Commercial Banking and Retail Banking and Wealth Management.");
        
        return INDEX;
    }

    @RequestMapping(value = "/matthew_cooper", method = RequestMethod.GET)
    public String metthewController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "matthew.jsp");
        map.addAttribute("title", "Red Alert | Matthew Cooper");
        map.addAttribute("description", "Money Laundering Prevention is dedicated to the hardwork of all those involved in the money laundering prevention and in particular to one of its brightest sons, and so to the memory of MATTHEW COOPER.");

        return INDEX;
    }

    @RequestMapping(value = "/book_reviews", method = RequestMethod.GET)
    public String reviewsController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "reviews.jsp");
        map.addAttribute("title", "Red Alert | Book Reviews");
        map.addAttribute("description", "22 professional book reviews for Money Laundering Cases and Materials");
        return INDEX;
    }

    @RequestMapping(value = "/request_test", method = RequestMethod.GET)
    public String requestTestController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "request_test.jsp");
        map.addAttribute("title", "Red Alert | Request A Test");
        return INDEX;
    }

    @RequestMapping(value = "/contact_me", method = RequestMethod.GET)
    public String contactMeController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "contact_me.jsp");
        map.addAttribute("title", "Red Alert | Contact Me");
        map.addAttribute("description", "This Book has been created to encourage discussion and comment. If you have questions comments or opinions please don't hesitate to contact me. I can be contacted at Jpcusack78@gmail.com.");        
        return INDEX;
    }

    @RequestMapping(value = "/buy_or_download", method = RequestMethod.GET)
    public String buyOrDownloadController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "buy_or_download.jsp");
        map.addAttribute("title", "Red Alert | Buy Or Download");
        map.addAttribute("description", "Buy or Download Money Laundering Cases and Materials");
        return INDEX;
    }

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String email(ModelMap map) {
        new Email().send();
        return "blank";
    }

    public void setUserDAO(UserDAO stockDAO) {
        this.userDAO = stockDAO;
    }
}
