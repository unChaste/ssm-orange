package io.toya.service;

public interface MoodPraiseService {
    int praise(Integer moodId, Integer id);

    int unpraise(Integer moodId, Integer userId);
}
