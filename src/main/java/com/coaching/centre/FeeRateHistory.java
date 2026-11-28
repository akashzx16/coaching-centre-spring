package com.coaching.centre;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity 

public class FeeRateHistory {
    @Id 
    @Positive (message = "Id must be positive")
    private int id;
    @Positive(message = "Batch ID must be positive")
    private int batchId;
    @Positive(message = "Monthly Fee must be positive") 
    @NotNull (message = "Monthly fee is required")
    private BigDecimal monthlyFee;
    @NotNull (message = "Effective Date is required")
    private LocalDate effectiveFrom;

        public FeeRateHistory(){

        }
        public  FeeRateHistory(int id,int batchId, BigDecimal monthlyFee,LocalDate effectiveFrom){
            this.id=id;
            this.batchId=batchId;
            this.monthlyFee=monthlyFee;
            this.effectiveFrom=effectiveFrom;
        }
        public int getId(){
            return id;
        }
        public  int getBatchId(){
            return  batchId;
        }
        public BigDecimal getMonthlyFee(){
            return monthlyFee;
        }
        public LocalDate getEffectiveFrom(){
            return effectiveFrom;
        }
        public void setId(int id){
            this.id=id;
        }
        public void setBatchId(int batchId){
            this.batchId=batchId;
        }
        public  void setMonthlyFee(BigDecimal monthlyFee){
            this.monthlyFee=monthlyFee;

        }
        public  void setEffectiveFrom(LocalDate effectiveFrom){
            this.effectiveFrom=effectiveFrom;
        }

}
