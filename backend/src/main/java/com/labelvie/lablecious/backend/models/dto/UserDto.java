package com.labelvie.lablecious.backend.models.dto;

import com.labelvie.lablecious.backend.models.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull(message = "Id is required")
    private long id;

    @NotNull(message = "First name is required")
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    private String email;

    private String job;

    private String number;

    private String image;

    @NotNull
    private int role;


    public static UserDto fromUser(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .image(user.getImage())
                .job(user.getJob())
                .role(user.getRole())
                .number(user.getNumber())
                .build();

    }
    public static List<UserDto> fromUsers(List<User> users) {

        return users.stream()
                .map(UserDto::fromUser)
                .collect(Collectors.toList());
    }

    public User toUser() {
        return User.builder()
                .id(this.getId())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .email(this.getEmail())
                .image(this.getImage())
                .job(this.getJob())
                .role(this.getRole())
                .number(this.getNumber())
                .build();
    }
}
