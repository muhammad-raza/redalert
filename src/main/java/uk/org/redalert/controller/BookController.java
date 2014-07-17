package uk.org.redalert.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uk.org.redalert.application.Months;
import uk.org.redalert.blogdao.BlogDAO;
import uk.org.redalert.commentsdao.CommentsDAO;
import uk.org.redalert.dbmapping.AdminEntity;
import uk.org.redalert.dbmapping.BlogEntity;
import uk.org.redalert.dbmapping.CommentEntity;
import uk.org.redalert.email.Email;
import uk.org.redalert.email.EmailContent;
import uk.org.redalert.admindao.AdminDAO;

import javax.print.DocFlavor;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BookController {
    private final String INDEX = "index";
    private final String PAGE_NAME = "pageName";

    @Autowired
    private AdminDAO adminDAO;
    @Autowired
    private CommentsDAO commentsDAO;
    @Autowired
    private BlogDAO blogDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "home.jsp");
        map.addAttribute("title", "Red Alert | Money Laundering Cases & Materials");
        map.addAttribute("description", "This Book is intended to serve as a comprehensive source of information for money laundering professionals that wish to better understand, establish or improve their money laundering, terrorist financing, fraud, sanctions, bribery and corruption prevention frameworks (hereafter referred to as money laundering).");
        return INDEX;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public String commentsController(ModelMap map) {
        List<CommentEntity> comments = commentsDAO.getAllComments();
        map.addAttribute("comments", comments);
        map.addAttribute(PAGE_NAME, "comments.jsp");
        map.addAttribute("title", "Red Alert | Reader's Comments");
        map.addAttribute("description", "This Book has been created to encourage discussion and comment. If you have questions comments or opinions please leave it here or send me personal message.");
        return INDEX;
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String blogController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "blog.jsp");
        List<BlogEntity> blogList = blogDAO.getAllBlog();
        if (blogList.size() > 0) {
            BlogEntity blogEntity = blogList.get(0);
            map.addAttribute("firstBlog", blogEntity);
            map.addAttribute("title", "Red Alert | " + blogEntity.getTopic());
            blogList.remove(0);
            map.addAttribute("allBlog", blogList);
        }
        return INDEX;
    }

    @RequestMapping(value = "ajax/blog/{blogId}", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String deleteBlogController(@PathVariable("blogId") String blogId) {
        blogDAO.deleteBlog(Integer.parseInt(blogId));
        return "deleted";
    }

    @RequestMapping(value = "/blog/{blogId}", method = RequestMethod.GET)
    public String blogController(@PathVariable("blogId") int blogId, ModelMap map) {
        map.addAttribute(PAGE_NAME, "blog.jsp");
        List<BlogEntity> blogList = blogDAO.getAllBlog();
        if (blogList.size() > 0) {
            Iterator<BlogEntity> iterator = blogList.iterator();
            while (iterator.hasNext()) {
                BlogEntity blog = iterator.next();
                if (blog.getId() == blogId) {
                    map.addAttribute("firstBlog", blog);
                    map.addAttribute("title", "Red Alert | " + blog.getTopic());
                    iterator.remove();
                }
            }
            map.addAttribute("allBlog", blogList);
        }
        return INDEX;
    }


    @RequestMapping(value = "ajax/addBlog", method = RequestMethod.POST, produces = "text/plain")
    public String addBlogController(
            @RequestParam(value = "topic") String topic,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "month") String month,
            @RequestParam(value = "year") int year) {

        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setTopic(topic);
        blogEntity.setDescription(description);
        String date = month + " " + year;
        blogEntity.setDate(date);
        String sortDate = year + Months.map.get(month);
        blogEntity.setSortDate(Integer.parseInt(sortDate));
        blogDAO.addBlog(blogEntity);
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

    @RequestMapping(value = "/the_book", method = RequestMethod.GET)
    public String bookController(@RequestParam(value = "file", required = false) String file,
                                 HttpSession session, ModelMap map) {
        String param = "";
        if (StringUtils.isNotBlank(file)) {
            param = "?file=" + file + "#zoom=auto";
        } else {
            if (!(session.getAttribute("loggedIn") != null && (Boolean) session.getAttribute("loggedIn"))) {
                map.addAttribute(PAGE_NAME, "book_password.jsp");
                map.addAttribute("title", "Red Alert | Secure");
                map.addAttribute("description", "Please insert valid password to view full book or contact the author.");

                return INDEX;
            }
        }
        return "redirect:/pdf/web/redalert.jsp" + param;
    }

    @RequestMapping(value = "/book_password", method = RequestMethod.POST)
    public String bookPasswordController(@RequestParam(value = "password", required = false) String password,
                                         HttpSession session, ModelMap map) {

        if (StringUtils.isBlank(password) || !password.equals("l3tm31n")) {
            map.addAttribute(PAGE_NAME, "book_password.jsp");
            map.addAttribute("status", "error");
            map.addAttribute("statusMessage", "Login Failed. Please try again");
            return INDEX;
        } else {
            session.setAttribute("loggedIn", true);
            return "redirect:/pdf/web/redalert.jsp";
        }
    }


    @RequestMapping(value = "/book_reviews", method = RequestMethod.GET)
    public String reviewsController(ModelMap map) {
        map.addAttribute(PAGE_NAME, "reviews.jsp");
        map.addAttribute("title", "Red Alert | Book Reviews");
        map.addAttribute("description", "22 professional book reviews for Money Laundering Cases and Materials");
        return INDEX;
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
        EmailContent emailContent = new EmailContent(name, email, message, "Mmail");
        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(email) &&
                StringUtils.isNotBlank(message) && name.length() < 25 &&
                email.length() < 40 && message.length() < 250) {
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
                StringUtils.isNotBlank(password) && password.length() < 40) {
            List<AdminEntity> listAdmins = adminDAO.getAdmin(username, password);
            if (listAdmins.size() > 0) {
                session.setAttribute("loggedin", true);
                session.setAttribute("logginError", false);
                return "redirect:/internal/dashboard";
            } else {
                session.setAttribute("logginError", true);
                session.setAttribute("loggedin", false);
                return "redirect:/internal/admin";
            }

        }
        return INDEX;
    }

    @RequestMapping(value = "/internal/admin", method = RequestMethod.GET)
    public String adminLogin(ModelMap map, HttpSession session) {
        if (session.getAttribute("loggedin") != null && (Boolean) session.getAttribute("loggedin")) {
            return "redirect:/internal/dashboard";
        } else if (session.getAttribute("logginError") != null && (Boolean) session.getAttribute("logginError")) {
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
        if (session.getAttribute("loggedin") == null || (session.getAttribute("loggedin") != null && !(Boolean) session.getAttribute("loggedin"))) {
            return "redirect:/internal/admin";
        }
        List<CommentEntity> comments = commentsDAO.getAllComments();
        map.addAttribute(PAGE_NAME, "dashboard.jsp");
        map.addAttribute("title", "Red Alert | Admin");
        map.addAttribute("description", "Admin dashboard");
        map.addAttribute("comments", comments);
        map.addAttribute("blog", blogDAO.getAllBlog());
        List<Integer> years = new ArrayList<Integer>();
        for (int i = Calendar.getInstance().get(Calendar.YEAR); i >= 1900; i--) {
            years.add(i);
        }
        map.addAttribute("years", years);
        return INDEX;
    }

    @RequestMapping(value = "/ajax/comment", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String homeComment(@RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("message") String message,
                              ModelMap map, HttpSession session) {
        CommentEntity comment = new CommentEntity();
        if (session.getAttribute("alreadyCommented") != null && (Boolean) session.getAttribute("alreadyCommented")) {
            return "alreadyCommented";
        }
        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(email) &&
                StringUtils.isNotBlank(message) && name.length() < 25 &&
                email.length() < 40 && message.length() < 250) {
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
        if (action.equalsIgnoreCase("delete")) {
            commentsDAO.deleteComment(commentId);
            return "deleted";
        } else if (action.equalsIgnoreCase("allow")) {
            commentsDAO.updateComment(commentId, 1);
            return "allowed";
        } else if (action.equalsIgnoreCase("disallow")) {
            commentsDAO.updateComment(commentId, 0);
            return "disallowed";
        }


        session.setAttribute("alreadyCommented", true);
        return "passed";

    }


    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public void setBlogDAO(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    public void setCommentsDAO(CommentsDAO commentsDAO) {
        this.commentsDAO = commentsDAO;
    }
}
