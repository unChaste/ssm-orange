package io.toya.controller;

import io.toya.entity.User;
import io.toya.response.MoodListResponse;
import io.toya.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<MoodListResponse> moodList = moodService.list(user.getId());
        model.addAttribute("moodList", moodList);
        return "mood/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "mood/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(String content, HttpSession session) {
        User user = (User) session.getAttribute("user");
        moodService.publishMood(user.getId(), content);
        return "redirect:/mood/list";
    }
}
