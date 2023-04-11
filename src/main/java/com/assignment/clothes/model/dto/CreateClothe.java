package com.assignment.clothes.model.dto;

import com.assignment.clothes.model.Clothe;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateClothe {
    @NotBlank
    private String name;
    @Min(1)
    @Max(499)
    @NotNull
    private Double price;
    @Pattern(regexp = "^(2022-(0[3-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])|[23]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]))$", message = "Input must be in the format of yyyy-MM-dd and greater than or equal to 2022-03-03")
    private String yearOfCreation;
    @NotBlank
    private String brand;

    public Clothe toClothe() {
        return Clothe.builder()
                .name(this.getName())
                .price(this.getPrice())
                .yearOfCreation(this.getYearOfCreation())
                .brand(this.getBrand())
                .build();
    }
}
