package org.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @RequestMapping("/")
  //@ResponseBody
  public String index() {
    /*return     "<a href='http://netgloo.com/en'>netgloo</a> :)";*/

    return "index.html";
    
     }

}
