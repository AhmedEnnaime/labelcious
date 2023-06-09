package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.FeedbackDto;
import com.labelvie.lablecious.backend.models.entity.Feedback;
import com.labelvie.lablecious.backend.models.entity.Plate;
import com.labelvie.lablecious.backend.models.entity.User;
import com.labelvie.lablecious.backend.repository.FeedbackRepository;
import com.labelvie.lablecious.backend.services.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }


    @Override
    public List<FeedbackDto> getFeedbacks() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return FeedbackDto.fromFeedbacks(feedbacks);
    }

    @Override
    public FeedbackDto saveFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        updateFeedbackFromDto(feedbackDto, feedback);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return FeedbackDto.fromFeedback(savedFeedback);
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

    private void updateFeedbackFromDto(FeedbackDto feedbackDto, Feedback feedback) {
        feedback.setMessage(feedbackDto.getMessage());
        User user = new User();
        user.setId(feedbackDto.getUser_id());
        feedback.setUser(user);
        Plate plate = new Plate();
        plate.setId(feedbackDto.getPlate_id());
        feedback.setPlate(plate);
    }

}

//push my branch to remote : git push -u origin my_branch