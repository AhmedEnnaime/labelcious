package com.labelvie.lablecious.backend.controllers;

import com.labelvie.lablecious.backend.models.entity.Feedback;
import com.labelvie.lablecious.backend.services.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/feedbacks")
public class FeedbackController {

    private FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) {
        return new ResponseEntity<Feedback>(feedbackService.saveFeedback(feedback), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Feedback> getFeedbacks() {
        return feedbackService.getFeedbacks();
    }

    @GetMapping("{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") long id) {
        return new ResponseEntity<Feedback>(feedbackService.getFeedbackById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable("id") long id) {
        feedbackService.deleteFeedback(id);
        return new ResponseEntity<String>("Feedback deleted successfully", HttpStatus.OK);
    }
}
