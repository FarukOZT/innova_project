package com.innova.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @NotNull(message = "Identity number can not be null!!!")
    private Long tckn;

    @NotNull(message = "Password can not be null!!!")
    private String password;
}
