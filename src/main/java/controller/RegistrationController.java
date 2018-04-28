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
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public ModelAndView defaltView(HttpServletRequest request){
        ModelAndView mav = new ModelAndView(REGISTRATION);
        mav.addObject(USER, userService.getUserFromSession(request.getSession()));
        return mav;
    }
    
    @PostMapping
    public void registration(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = FIRST_NAME) String firstName,
            @RequestParam(name = LAST_NAME) String lastName,
            @RequestParam(name = PATRONYMIC) String patronymic,
            @RequestParam(name = LOGIN) String login,
            @RequestParam(name = PASSWORD1) String password1,
            @RequestParam(name = PASSWORD2) String password2) throws IOException{
        
        if(userService.registration(firstName, lastName, patronymic, login, password1, password2)){
            response.sendRedirect(AUTHENTICATE_PAGE);
        }else{
            response.sendRedirect(REGISTRATION_PAGE);
        }
    }
}
