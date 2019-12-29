package club.mydlq.swagger.kubernetes.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 访问 “/” 路径，跳转到 /doc.html
 * To access the "/" path, jump to /doc.html
 */
@Controller
public class MvcController {

    @GetMapping("/")
    public String root() {
        return "redirect:doc.html";
    }
}
