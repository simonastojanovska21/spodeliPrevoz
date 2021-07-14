package com.example.spodeliprevoz.service.impl;

import com.example.spodeliprevoz.model.Review;
import com.example.spodeliprevoz.model.User;
import com.example.spodeliprevoz.model.exceptions.InvalidUsernameException;
import com.example.spodeliprevoz.repository.ReviewRepository;
import com.example.spodeliprevoz.repository.UserRepository;
import com.example.spodeliprevoz.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public Review addReviewForUser(String username, Double stars) {
        User user=this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
        Review review=new Review(user,stars);
        return this.reviewRepository.save(review);
    }

    @Override
    public Double getReviewsAverageForUser(String username) {
        User user=this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
        return this.reviewRepository.findAll()
                .stream()
                .filter(each->each.getUser().equals(user))
                .mapToDouble(Review::getStars)
                .average()
                .getAsDouble();
    }
}
