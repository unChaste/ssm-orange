package io.toya.dao;

import io.toya.entity.MoodPraise;
import org.apache.ibatis.annotations.Param;

public interface MoodPraiseDao {
    MoodPraise getByMoodIdAndUserId(@Param("moodId") Integer moodId, @Param("userId") Integer userId);

    int praise(MoodPraise moodPraise);

    int unpraise(@Param("moodId") Integer moodId, @Param("userId") Integer userId);
}
