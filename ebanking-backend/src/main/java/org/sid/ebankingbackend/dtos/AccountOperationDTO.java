package org.sid.ebankingbackend.dtos;

import lombok.Data;
import org.sid.ebankingbackend.enums.OprerationType;

import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OprerationType type;
    private String description;
}






