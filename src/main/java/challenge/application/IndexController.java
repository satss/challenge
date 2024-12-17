package challenge.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"/index.html", "/index.htm", "/"})
    public String redirectToSwaggerDoc() {
        return "redirect:swagger-ui.html";
    }

}
