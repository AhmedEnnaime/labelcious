package com.labelvie.lablecious.backend.services;

import com.labelvie.lablecious.backend.models.dto.FeedbackDto;
import com.labelvie.lablecious.backend.models.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    List<FeedbackDto> getFeedbacks();

    FeedbackDto saveFeedback(FeedbackDto feedbackDto);

    void deleteFeedback(long id);

    FeedbackDto getFeedbackById(long id);

    Feedback findOrFail(long id);
}
