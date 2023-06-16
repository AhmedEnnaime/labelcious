package com.labelvie.lablecious.backend.models.dto;

import com.labelvie.lablecious.backend.models.entity.Feedback;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FeedbackDto {

    private long id;

    @NotBlank(message = "Message is required")
    private String message;

    @NotNull
    private long user_id;

    @NotNull
    private long plate_id;

    private UserDto user;  // Add UserDto field

    public static FeedbackDto fromFeedback(Feedback feedback) {
        return FeedbackDto.builder()
                .id(feedback.getId())
                .message(feedback.getMessage())
                .user_id(feedback.getUser().getId())
                .plate_id(feedback.getPlate().getId())
                .user(UserDto.fromUser(feedback.getUser()))  // Map User to UserDto
                .build();
    }

    public static List<FeedbackDto> fromFeedbacks(List<Feedback> feedbacks) {
        return feedbacks.stream()
                .map(FeedbackDto::fromFeedback)
                .collect(Collectors.toList());
    }

    public Feedback toFeedback() {
        return Feedback.builder()
                .id(this.getId())
                .message(this.getMessage())
                .build();
    }
}
