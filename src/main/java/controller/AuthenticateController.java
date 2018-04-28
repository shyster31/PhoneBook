package controller;

import static component.Constants.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping(value = "/authenticate")
public class AuthenticateController {

   
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView defaltView(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(AUTHENTICATE);
        mav.addObject(USER, userService.getUserFromSession(request.getSession()));
        return mav;
    }

    @PostMapping
    public void authenticate(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = LOGIN) String login,
            @RequestParam(name = PASSWORD) String password) throws IOException {

        if (userService.authenticate(login, password, request.getSession())) {
            response.sendRedirect(MAIN_PAGE);
        } else {
            response.sendRedirect(AUTHENTICATE_PAGE);
        }
    }
}
