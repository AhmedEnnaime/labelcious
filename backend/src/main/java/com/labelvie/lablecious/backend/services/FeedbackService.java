package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    List<Feedback> getFeedbacks();

    Feedback saveFeedback(Feedback feedback);

    void deleteFeedback(long id);

    Feedback getFeedbackById(long id);
}
