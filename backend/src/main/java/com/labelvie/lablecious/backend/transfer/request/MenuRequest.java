package com.labelvie.lablecious.backend.transfer.request;

import com.labelvie.lablecious.backend.models.entity.Menu;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuRequest {

    private long id;

    @NotBlank(message = "Date is required")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$")
    private String date;

    @NotBlank(message = "Plates is required")
    private List<MenuPlatesRequest> platesList;

    public Menu toMenu() {
        return Menu.builder()
                .id(this.getId())
                .date(this.getDate())
                .build();
    }
}


