package com.assignment.clothes.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClotheSearchByDateDTO {
   private String name;
   private String startDate;
   private String endDate;
}