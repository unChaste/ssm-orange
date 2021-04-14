package io.toya.service.impl;

import io.toya.dao.MoodDao;
import io.toya.entity.Mood;
import io.toya.response.MoodListResponse;
import io.toya.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {

    @Autowired
    private MoodDao moodDao;

    @Override
    public int publishMood(Integer userId, String content) {
        Mood mood = new Mood();
        mood.setUserId(userId);
        mood.setContent(content);
        int rows = moodDao.save(mood);
        return rows;
    }

    @Override
    public List<MoodListResponse> list(Integer userId) {
        List<MoodListResponse> moodList = moodDao.list();
        for (MoodListResponse mood : moodList) {
            int countOfPraise = moodDao.countOfPraiseOfMood(mood.getMoodId());
            int countOfPraiseOfUser = moodDao.countOfPraiseOfMoodByUserId(mood.getMoodId(), userId);
            boolean hasPraised = countOfPraiseOfUser > 0 ? true : false;
            mood.setPraiseNum(countOfPraise);
            mood.setHasPraised(hasPraised);
        }
        return moodList;
    }
}
