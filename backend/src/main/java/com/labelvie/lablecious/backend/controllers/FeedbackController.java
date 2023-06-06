package com.labelvie.lablecious.backend.controllers;

import com.labelvie.lablecious.backend.models.dto.FeedbackDto;
import com.labelvie.lablecious.backend.models.entity.Feedback;
import com.labelvie.lablecious.backend.services.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<FeedbackDto> saveFeedback(@Valid @RequestBody FeedbackDto feedbackDto) {
        FeedbackDto createdFeedback = feedbackService.saveFeedback(feedbackDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedback);
    }

    @GetMapping
    public ResponseEntity<List<FeedbackDto>> getFeedbacks() {
        List<FeedbackDto> feedbacks = feedbackService.getFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("{id}")
    public ResponseEntity<FeedbackDto> getFeedbackById(@PathVariable("id") long id) {
        FeedbackDto feedback = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(feedback);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable("id") long id) {
        feedbackService.deleteFeedback(id);
        return new ResponseEntity<String>("Feedback deleted successfully", HttpStatus.OK);
    }
}
