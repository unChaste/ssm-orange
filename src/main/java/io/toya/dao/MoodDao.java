package io.toya.dao;

import io.toya.entity.Mood;
import io.toya.response.MoodListResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoodDao {
    int save(Mood mood);

    List<MoodListResponse> list();

    int countOfPraiseOfMood(Integer moodId);

    int countOfPraiseOfMoodByUserId(@Param("moodId") Integer moodId, @Param("userId") Integer userId);
}
