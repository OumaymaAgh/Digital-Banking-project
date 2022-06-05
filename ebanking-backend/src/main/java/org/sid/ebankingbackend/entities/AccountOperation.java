package org.sid.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.enums.OprerationType;

import javax.persistence.*;
import java.util.Date;

@Entity

@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;
    //Enregistrer sous format String
    @Enumerated(EnumType.STRING)
    private OprerationType type;
    private String description;
    @ManyToOne
    private BankAccount bankAccount;
}
