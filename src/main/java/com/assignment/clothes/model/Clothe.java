package com.assignment.clothes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clothe {

    public enum Brand {
        NIKE("Nike"),
        LEVIS("Levi's"),
        PUMA("Puma"),
        DIOR("Dior"),
        STONE_ISLANDS("Stone Islands"),
        BALENCIAGA("Balenciaga");

        private String name;

        private Brand(String name) {
            this.name = name;
        }

        public String getBrandName() {
            return name;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
}
