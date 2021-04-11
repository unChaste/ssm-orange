package io.toya.controller;

import io.toya.entity.User;
import io.toya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(String nickname, Model model) {
        List<User> userList = userService.listAll(nickname);
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user/view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "user/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(String id) {
        userService.deleteById(id);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        userService.update(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/login-form", method = RequestMethod.GET)
    public String loginForm() {
        return "user/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        User user = userService.getByUsername(username);

        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "用户名不存在");
            return "redirect:/user/login-form";
        }
        if (!user.getPassword().equals(password)) {
            redirectAttributes.addFlashAttribute("message", "密码错误");
            return "redirect:/user/login-form";
        }

        session.setAttribute("user", user);
        return "redirect:/test/hello";
    }

}
