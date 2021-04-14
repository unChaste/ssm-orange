package io.toya.service.impl;

import io.toya.dao.MoodPraiseDao;
import io.toya.entity.MoodPraise;
import io.toya.service.MoodPraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoodPraiseServiceImpl implements MoodPraiseService {

    @Autowired
    private MoodPraiseDao moodPraiseDao;

    @Override
    public int praise(Integer moodId, Integer userId) {
        MoodPraise moodPraise = moodPraiseDao.getByMoodIdAndUserId(moodId, userId);
        if (moodPraise != null) {
            return 0;
        }
        moodPraise = new MoodPraise();
        moodPraise.setMoodId(moodId);
        moodPraise.setUserId(userId);
        int rows = moodPraiseDao.praise(moodPraise);
        return rows;
    }

    @Override
    public int unpraise(Integer moodId, Integer userId) {
        MoodPraise moodPraise = moodPraiseDao.getByMoodIdAndUserId(moodId, userId);
        if (moodPraise == null) {
            return 0;
        }
        int rows = moodPraiseDao.unpraise(moodId, userId);
        return rows;
    }
}
