
package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	 @RequestMapping(method = RequestMethod.GET)
	   public String home(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      return "default";
	   }
}