package org.marcbr8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HomeController {

    @Autowired
    Environment env;


    @RequestMapping("/")
    public RedirectView localRedirect() {
        String frontendView = env.getProperty("frontend_view_url");
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(frontendView);
        return redirectView;
    }
}
