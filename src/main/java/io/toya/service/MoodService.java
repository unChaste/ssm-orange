package io.toya.service;

import io.toya.response.MoodListResponse;

import java.util.List;

public interface MoodService {
    int publishMood(Integer userId, String content);

    List<MoodListResponse> list(Integer userId);
}
