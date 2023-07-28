package com.nci.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {
   private Integer id     ;
   private String customerName ;
   private String email         ;
   private String phone         ;
   private String companyName  ;
   private Short country       ;
   private String message       ;
   private LocalDateTime submitTime ;
   private String empName         ;
   private Short status      ;   //1 Pending; 2 Pending
   private String remark        ;
   private LocalDateTime processingTime;
}
