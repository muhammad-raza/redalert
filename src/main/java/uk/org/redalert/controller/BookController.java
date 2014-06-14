package uk.org.redalert.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uk.org.redalert.commentsdao.CommentsDAO;
import uk.org.redalert.dbmapping.AdminEntity;
import uk.org.redalert.dbmapping.CommentEntity;
import uk.org.redalert.email.Email;
import uk.org.redalert.email.EmailContent;
import uk.org.redalert.admindao.AdminDAO;

import javax.print.DocFlavor;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Controller
public class BookController {
    private final String INDEX = "index";
    private final String PAGE_NAME = "pageName";

    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private CommentsDAO commentsDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeController(ModelMap map) {
        List<CommentEntity> comments = commentsDAO.getAllComments();
        map.addAttribute("comments", comments);
        map.addAttribute(PAGE_NAME, "home.jsp");
        map.addAttribute("title", "Red Alert | Money Laundering Cases & Materials");
        map.addAttribute("description", "his Book is intended to serve as a comprehensive source of information for money laundering professionals that wish to better understand, establish or improve their money laundering, terrorist financing, fraud, sanctions, bribery and corruption prevention frameworks (hereafter referred to as money laundering).");
        return INDEX;
    }

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

    @RequestMapping(value = "/book_sample", method = RequestMethod.GET)
    public String bookSampleController(@RequestParam("page") String page, ModelMap map) {
        map.addAttribute(PAGE_NAME, "request_test.jsp");
        map.addAttribute("title", "Red Alert | Request A Test");
        map.addAttribute("pageNum", page);
        return "book_sample";
    }

    @RequestMapping(value = "/contact_me", method = RequestMethod.GET)
    public String contactMeController(@ModelAttribute("email") EmailContent emailContent,
                                      ModelMap map) {
        map.addAttribute(PAGE_NAME, "contact_me.jsp");

        map.addAttribute("title", "Red Alert | Contact Me");
        map.addAttribute("description", "This Book has been created to encourage discussion and comment. If you have questions comments or opinions please don't hesitate to contact me. I can be contacted at Jpcusack78@gmail.com.");
        if (emailContent.hasContents()) {
            if (emailContent.isStatus()) {
                map.addAttribute("statusMessage", "Message Sent !");
                map.addAttribute("status", "");
            } else {
                map.addAttribute("emailContent", emailContent);
                map.addAttribute("status", "error");
                map.addAttribute("statusMessage", "Message Failed. Please try again after some time.");
            }
        }
        return INDEX;
    }

    @RequestMapping(value = "/buy_or_download", method = RequestMethod.GET)
    public String buyOrDownloadController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "buy_or_download.jsp");
        map.addAttribute("title", "Red Alert | Buy Or Download");
        map.addAttribute("description", "Buy or Download Money Laundering Cases and Materials");
        return INDEX;
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public String email(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("message") String message,
        RedirectAttributes redirectAttributes) {

        boolean status = false;
        EmailContent emailContent = new EmailContent(name,email, message, "Mmail");
        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(email) &&
                StringUtils.isNotBlank(message) && name.length() < 25 &&
                email.length() < 40 && message.length() < 250){
            status = new Email(emailContent).send();
        }
        emailContent.setStatus(status);
        redirectAttributes.addFlashAttribute("email", emailContent);
        return "redirect:/contact_me";
    }

    @RequestMapping(value = "/internal/admin_login", method = RequestMethod.POST)
    public String adminLoginValidation(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session) {
        if (StringUtils.isNotBlank(username) && username.length() < 25 &&
                StringUtils.isNotBlank(password) && password.length() < 40){
            List<AdminEntity> listAdmins = adminDAO.getAdmin(username, password);
            if (listAdmins.size() > 0){
                session.setAttribute("loggedin", true);
                session.setAttribute("logginError", false);
                return "redirect:/internal/dashboard";
            }else{
                session.setAttribute("logginError", true);
                session.setAttribute("loggedin", false);
                return "redirect:/internal/admin";
            }

        }
        return INDEX;
    }

    @RequestMapping(value = "/internal/admin", method = RequestMethod.GET)
    public String adminLogin(ModelMap map, HttpSession session) {
        if (session.getAttribute("loggedin") != null && (Boolean)session.getAttribute("loggedin")){
            return "redirect:/internal/dashboard";
        } else if(session.getAttribute("logginError") != null &&(Boolean)session.getAttribute("logginError")){
            map.addAttribute("statusMessage", "Error Logging in. Please try again.");
            map.addAttribute("status", "error");
        }
        map.addAttribute(PAGE_NAME, "admin_login.jsp");
        map.addAttribute("title", "Red Alert | Admin");
        map.addAttribute("description", "Login to your website");
        return INDEX;
    }

    @RequestMapping(value = "/internal/dashboard", method = RequestMethod.GET)
    public String adminDashboard(ModelMap map, HttpSession session) {
        if (session.getAttribute("loggedin") == null || (session.getAttribute("loggedin") != null && !(Boolean)session.getAttribute("loggedin"))){
            return "redirect:/internal/admin";
        }
        List<CommentEntity> comments = commentsDAO.getAllComments();
        map.addAttribute(PAGE_NAME, "dashboard.jsp");
        map.addAttribute("title", "Red Alert | Admin");
        map.addAttribute("description", "Admin dashboard");
        map.addAttribute("comments", comments);
        return INDEX;
    }

    @RequestMapping(value = "/ajax/comment", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String homeComment(@RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("message") String message,
                               ModelMap map, HttpSession session) {
        CommentEntity comment = new CommentEntity();
        if (session.getAttribute("alreadyCommented") !=null && (Boolean)session.getAttribute("alreadyCommented")){
            return "alreadyCommented";
        }
        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(email) &&
                StringUtils.isNotBlank(message) && name.length() < 25 &&
                email.length() < 40 && message.length() < 250){
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm z");
            String currentTime = dateformat.format(cal.getTime());

            comment.setName(name);
            comment.setEmail(email);
            comment.setTime(currentTime);
            comment.setComment(message);
            comment.setApproved(0);
            commentsDAO.addComment(comment);
            new Email(new EmailContent(name, email, message, "Message")).send();
            session.setAttribute("alreadyCommented", true);
            return "passed";
        }
        return "failed";
    }


    @RequestMapping(value = "/ajax/comment/{id}", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String homeComment(@PathVariable("id") int commentId,
                              @RequestParam("action") String action,
                              HttpSession session) {
        if (action.equalsIgnoreCase("delete")){
            commentsDAO.deleteComment(commentId);
            return "deleted";
        } else if(action.equalsIgnoreCase("allow")){
            commentsDAO.updateComment(commentId, 1);
            return "allowed";
        } else if(action.equalsIgnoreCase("disallow")){
            commentsDAO.updateComment(commentId, 0);
            return "disallowed";
        }


        session.setAttribute("alreadyCommented", true);
        return "passed";

    }



    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public void setCommentsDAO(CommentsDAO commentsDAO) {
        this.commentsDAO = commentsDAO;
    }
}
