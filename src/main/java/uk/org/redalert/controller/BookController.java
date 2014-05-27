package uk.org.redalert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.org.redalert.dbmapping.UserEntity;
import uk.org.redalert.userdao.UserDAO;

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
        return INDEX;
    }

    @RequestMapping(value = "/matthew_cooper", method = RequestMethod.GET)
    public String metthewController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "matthew.jsp");
        map.addAttribute("title", "Red Alert | Matthew Cooper");
        return INDEX;
    }

    @RequestMapping(value = "/book_reviews", method = RequestMethod.GET)
    public String reviewsController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "reviews.jsp");
        map.addAttribute("title", "Red Alert | Book Reviews");
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
        return INDEX;
    }

    @RequestMapping(value = "/buy_or_download", method = RequestMethod.GET)
    public String buyOrDownloadController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "buy_or_download.jsp");
        map.addAttribute("title", "Red Alert | Buy Or Download");
        return INDEX;
    }

    public void setUserDAO(UserDAO stockDAO) {
        this.userDAO = stockDAO;
    }
}
