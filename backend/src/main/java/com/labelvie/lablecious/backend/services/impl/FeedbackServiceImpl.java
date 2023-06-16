package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.FeedbackDto;
import com.labelvie.lablecious.backend.models.entity.Feedback;
import com.labelvie.lablecious.backend.repository.FeedbackRepository;
import com.labelvie.lablecious.backend.services.FeedbackService;
import com.labelvie.lablecious.backend.services.PlateService;
import com.labelvie.lablecious.backend.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    private final PlateService plateService;

    private final UserService userService;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, PlateService plateService, UserService userService) {
        this.feedbackRepository = feedbackRepository;
        this.plateService = plateService;
        this.userService = userService;
    }


    @Override
    public List<FeedbackDto> getFeedbacks() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return FeedbackDto.fromFeedbacks(feedbacks);
    }

    @Override
    public FeedbackDto saveFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = feedbackDto.toFeedback();
        feedback.setPlate(plateService.findOrFail(feedbackDto.getPlate_id()));
        feedback.setUser(userService.findOrFail(feedbackDto.getUser_id()));
        return FeedbackDto.fromFeedback(feedbackRepository.save(feedback));
    }

    @Override
    public void deleteFeedback(long id) {
        Optional<Feedback> optionalFeedback = feedbackRepository.findById(id);
        optionalFeedback.ifPresent(feedback -> feedbackRepository.delete(feedback));
    }

    @Override
    public FeedbackDto getFeedbackById(long id) {
        return FeedbackDto.fromFeedback(this.findOrFail(id));
    }

    @Override
    public Feedback findOrFail(long id) {
        return feedbackRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("The Feedback with id " + id + " does not exist"));
    }


}