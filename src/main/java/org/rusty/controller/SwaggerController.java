package org.rusty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

    @RequestMapping("/")
    public String swaggerHtml() {
        return "redirect:swagger-ui.html";
    }
}
