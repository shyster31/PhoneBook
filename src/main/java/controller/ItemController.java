package controller;

import static component.Constants.*;
import dao.ItemCache;
import entity.Item;
import entity.User;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ItemService;
import service.UserService;

@Controller
public class ItemController {

    @Autowired
    private ItemCache itemCache;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = DELETE_URL, method = RequestMethod.GET)
    public void delete(HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(name = ID, required = false) String id) throws IOException {
        if (!userService.isLoginedUser(request.getSession())) {
            response.sendRedirect(AUTHENTICATE_PAGE);
        } else {
            itemCache.delete(id);
            response.sendRedirect(MAIN_PAGE);
        }
    }

    @RequestMapping(value = EDIT_URL, method = RequestMethod.GET)
    public ModelAndView editDefaltView(HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(name = ID, required = false) String id) throws IOException {

        ModelAndView mav = new ModelAndView(EDIT);
        if (!userService.isLoginedUser(request.getSession())) {
            response.sendRedirect(AUTHENTICATE_PAGE);
        } else {
            if (id == null) {
                response.sendRedirect(MAIN_PAGE);
            }
            User user = userService.getUserFromSession(request.getSession());
            mav.addObject(USER, user);
            mav.addObject(ITEM, itemCache.getById(id));
        }
        return mav;
    }

    @RequestMapping(value = EDIT_URL, method = RequestMethod.POST)
    public void edit(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = ID) String id,
            @RequestParam(name = FIRST_NAME) String firstName,
            @RequestParam(name = LAST_NAME) String lastName,
            @RequestParam(name = PATRONYMIC) String patronymic,
            @RequestParam(name = PHONE) String phone,
            @RequestParam(name = HOME_PHONE) String homePhone,
            @RequestParam(name = EMAIL) String email,
            @RequestParam(name = ADRESS) String adress) throws IOException {

        if (!userService.isLoginedUser(request.getSession())) {
            response.sendRedirect(AUTHENTICATE_PAGE);
        }
        Item item = itemCache.getById(id);
        if (item == null || itemService.edit(item, firstName, lastName, patronymic, phone, homePhone, email, adress)) {
            response.sendRedirect(MAIN_PAGE);
        }else{
            response.sendRedirect(EDIT_PAGE+id);
        }
    }

    @RequestMapping(value = ADD_URL, method = RequestMethod.GET)
    public ModelAndView addDefaltView(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        ModelAndView mav = new ModelAndView(ADD);
        if (!userService.isLoginedUser(request.getSession())) {
            response.sendRedirect(AUTHENTICATE_PAGE);
        } else {
            User user = userService.getUserFromSession(request.getSession());
            mav.addObject(USER, user);
        }
        return mav;
    }

    @RequestMapping(value = ADD_URL, method = RequestMethod.POST)
    public void add(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = FIRST_NAME) String firstName,
            @RequestParam(name = LAST_NAME) String lastName,
            @RequestParam(name = PATRONYMIC) String patronymic,
            @RequestParam(name = PHONE) String phone,
            @RequestParam(name = HOME_PHONE) String homePhone,
            @RequestParam(name = EMAIL) String email,
            @RequestParam(name = ADRESS) String adress) throws IOException {

        if (!userService.isLoginedUser(request.getSession())) {
            response.sendRedirect(AUTHENTICATE_PAGE);
        }
        if (!itemService.add(firstName,
                lastName,
                patronymic,
                phone,
                homePhone,
                email,
                adress,
                userService.getUserFromSession(request.getSession()).getLogin())) {
            response.sendRedirect(ADD_PAGE);
        } else {
            response.sendRedirect(MAIN_PAGE);
        }
    }

}
