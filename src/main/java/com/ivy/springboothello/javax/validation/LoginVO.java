package com.ivy.springboothello.javax.validation;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginVO {

    @NotNull
    @IsMobile
    private String mail;

    @NotNull
    @Length(min = 32)
    private String password;
}
