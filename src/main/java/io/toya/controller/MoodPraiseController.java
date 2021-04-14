package io.toya.controller;

import io.toya.entity.User;
import io.toya.service.MoodPraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mood")
public class MoodPraiseController {

    @Autowired
    private MoodPraiseService moodPraiseService;

    @RequestMapping(value = "/praise", method = RequestMethod.GET)
    public String praise(Integer moodId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        moodPraiseService.praise(moodId, user.getId());
        return "redirect:/mood/list";
    }

    @RequestMapping(value = "/unpraise", method = RequestMethod.GET)
    public String unpraise(Integer moodId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        moodPraiseService.unpraise(moodId, user.getId());
        return "redirect:/mood/list";
    }
}
