package controller;

import static component.Constants.*;
import dao.ItemCache;
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
import service.UserService;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private ItemCache itemCache;

    @RequestMapping(name = MAIN_URL, method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = EXIT, required = false) String exit) throws IOException {

        ModelAndView mav = new ModelAndView(MAIN);
        if (!userService.isLoginedUser(request.getSession())
                || userService.buttonExitPressed(exit, request.getSession())) {
            response.sendRedirect(AUTHENTICATE_PAGE);
        } else {

            User user = userService.getUserFromSession(request.getSession());
            mav.addObject(USER, user);
            mav.addObject(ITEMS, itemCache.getByLogin(user.getLogin()));
        }
        return mav;
    }

}
