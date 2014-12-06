package net.level0.booksale.controller.user;

import net.level0.booksale.domain.University;
import net.level0.booksale.domain.User;
import net.level0.booksale.service.UniServiceImp;
import net.level0.booksale.service.UserServiceImp;
import net.level0.booksale.util.validator.UserValidator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created on 11/22/14 2:59 PM.
 *
 * @author: mithunshawon
 */

@WebServlet(name = "UserAddController", urlPatterns = "/adduser")
public class UserAddController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserAddController.class);
    private final String UPLOAD_DIRECTORY = "/home/devil/therap/booksale/web/uploads/users";
    List<University> uniList = getAllUniList();
    List<University> deptList = getAllDeptList();
    private User user;
    private UserServiceImp userService;

    public UserAddController() {
        userService = new UserServiceImp();
        user = new User();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("User Registration Controller is requested ");

        log.info("Uni List Size in UserAddController : {} ", uniList.size());
        log.info("Dept List Size in UserAddController : {} ", deptList.size());

        req.setAttribute("uniList", uniList);
        req.setAttribute("deptList", deptList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/user_registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.debug("Post method in UserAddController Post");
        try {
            createUserFromRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        log.debug("User name in UserAddController : {}", user.getUserName());
        boolean isValid = UserValidator.validateUserRegistration(user);

        if (isValid) {
            userService.addUser(user);
            log.debug("User is added");
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            log.debug("User is invalid");
            req.setAttribute("uniList", uniList);
            req.setAttribute("deptList", deptList);
            req.setAttribute("message", "Every fields are required");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user/user_registration.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

    private void createUserFromRequest(HttpServletRequest req) throws IOException, ServletException, FileUploadException {

        String fieldName = "";
        String value = "";
        String fileName = "";

        log.debug("file request : {}", ServletFileUpload.isMultipartContent(req));
        FileItemFactory factory = new DiskFileItemFactory();


        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> uploadItems = upload.parseRequest(req);

        for (FileItem uploadItem : uploadItems) {
            if (uploadItem.isFormField()) {
                fieldName = uploadItem.getFieldName();
                value = uploadItem.getString();
                log.debug("inside file uploader--->> {}:{}", fieldName, value);
                setProperty(fieldName, value);
            } else if (!uploadItem.isFormField()) {
                fieldName = uploadItem.getFieldName();
                value = new File(uploadItem.getName()).getName();
                log.debug("File Name --->> {}", value);

                try {
                    double tmp = Math.random() % 100;
                    fileName = tmp + value;
                    log.debug("file name final : {}", fileName);
                    log.debug("file path final : {}", UPLOAD_DIRECTORY + File.separator + fieldName);
                    uploadItem.write(new File(UPLOAD_DIRECTORY + File.separator + fileName));
                    setProperty(fieldName, fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private User setProperty(String fieldName, String value) {

        if (fieldName.equals("user_name")) {
            user.setUserName(value);
        } else if (fieldName.equals("uni_id")) {
            Integer uniId = Integer.parseInt(value);
            user.setUniId(uniId);
        } else if (fieldName.equals("dept_id")) {
            Integer deptId = Integer.parseInt(value);
            user.setDeptId(deptId);
        } else if (fieldName.equals("email")) {
            user.setEmail(value);
        } else if (fieldName.equals("password")) {
            user.setPassword(value);
        } else if (fieldName.equals("address")) {
            user.setAddress(value);
        } else if (fieldName.equals("phone")) {
            user.setPhoneNo(value);
        } else if (fieldName.equals("photo")) {
            user.setPhoto(value);
        }

        return user;
    }

    private List<University> getAllUniList() {
        return new UniServiceImp().getAllUniversity();
    }

    private List<University> getAllDeptList() {
        return new UniServiceImp().getAllDept();
    }

}
