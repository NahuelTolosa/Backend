package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.UserContextService;

@Controller
public class UserContextController {

    @Autowired
    UserContextService userContextService;

}
