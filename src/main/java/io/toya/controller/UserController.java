package io.toya.controller;

import com.alibaba.druid.util.StringUtils;
import io.toya.entity.User;
import io.toya.request.RegisterRequest;
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

    @RequestMapping(value = "/register-form", method = RequestMethod.GET)
    public String registerForm() {
        return "user/registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(RegisterRequest registerRequest, RedirectAttributes redirectAttributes) {
        if (!registerRequest.getPassword().equals(registerRequest.getPasswordTwo())) {
            redirectAttributes.addFlashAttribute("message", "两次密码不一样");
            return "redirect:/user/register-form";
        }
        if (StringUtils.isEmpty(registerRequest.getUsername())) {
            redirectAttributes.addFlashAttribute("message", "用户名为空");
            return "redirect:/user/register-form";
        }
        User user = userService.getByUsername(registerRequest.getUsername());
        if (user != null) {
            redirectAttributes.addFlashAttribute("message", "用户名已存在");
            return "redirect:/user/register-form";
        }
        user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setNickname(registerRequest.getNickname());
        user.setGender(registerRequest.getGender());
        user.setQuestion(registerRequest.getQuestion());
        user.setAnswer(registerRequest.getAnswer());
        userService.save(user);

        redirectAttributes.addFlashAttribute("message", "注册成功");

        return "redirect:/user/login-form";
    }

    @RequestMapping(value = "/edit-password", method = RequestMethod.GET)
    public String editPassword() {
        return "user/editPassword";
    }

    @RequestMapping(value = "/edit-password-two", method = RequestMethod.GET)
    public String editPasswordTwo(String username, Model model, RedirectAttributes redirectAttributes) {
        User user = userService.getByUsername(username);
        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "用户名不存在");
            return "redirect:/user/edit-password";
        }
        model.addAttribute("username", username);
        model.addAttribute("question", user.getQuestion());
        return "user/editPasswordTwo";
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    public String updatePassword(@RequestParam("username") String username,
                                 @RequestParam("question") String question,
                                 @RequestParam("answer") String answer,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("newPasswordTwo") String newPasswordTwo,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        model.addAttribute("username", username);
        model.addAttribute("question", question);
        if (!newPassword.equals(newPasswordTwo)) {
            model.addAttribute("message", "两次密码不一样");
            return "user/editPasswordTwo";
        }

        User user = userService.getByUsername(username);
        if (user == null) {
            redirectAttributes.addFlashAttribute("message", "用户名不存在");
            return "redirect:/user/editPassword";
        }
        if (!user.getAnswer().equals(answer)) {
            model.addAttribute("message", "答案不正确");
            return "user/editPasswordTwo";
        }

        user.setPassword(newPassword);
        user.setCreateTime(null);
        userService.update(user);
        redirectAttributes.addFlashAttribute("message", "密码修改成功");

        return "redirect:/user/login-form";
    }

}
