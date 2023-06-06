package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.entity.Feedback;
import com.labelvie.lablecious.backend.repository.FeedbackRepository;
import com.labelvie.lablecious.backend.services.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Feedback> getFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(long id) {
        feedbackRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("The feedback with id: "+id+" does not exist"));
        feedbackRepository.deleteById(id);
    }

    @Override
    public Feedback getFeedbackById(long id) {
        return feedbackRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("The feedback with id: "+id+" does not exist"));
    }

}

//push my branch to remote : git push -u origin my_branch