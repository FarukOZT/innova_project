package com.innova.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Id
    private UUID id;
    @NotNull
    private Long tckn;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String surName;
    @NotNull
    private int salary;
    @NotNull
    private Long phone;
    @NotNull
    private int creditNote;
    @NotNull
    private String status;

}
