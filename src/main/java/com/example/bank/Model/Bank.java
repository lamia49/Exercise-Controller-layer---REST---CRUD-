package com.example.bank.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@AllArgsConstructor
public class Bank {
    private int ID;
    private String UserName;
    @Getter
    @Setter
    private double balance;
}
