package com.example.spodeliprevoz.service;

import com.example.spodeliprevoz.model.Review;

import java.util.List;

public interface ReviewService {
    Review addReviewForUser(String username, Double stars);
    Double getReviewsAverageForUser(String username);
}
