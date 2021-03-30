package io.toya.controller;

import io.toya.request.HelloRestRequest;
import io.toya.response.HelloRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("message", "Hello MVC");
        return "hello";
    }

    @PostMapping("/rest")
    @ResponseBody
    public Object rest(@RequestBody HelloRestRequest restRequest) {
        LOGGER.debug("输入的姓名为：" + restRequest.getName() + ", 年龄为：" + restRequest.getAge());

        HelloRestResponse restResponse = new HelloRestResponse();
        restResponse.setName(restRequest.getName());
        restResponse.setAge(restRequest.getAge());
        return restResponse;
    }
}
