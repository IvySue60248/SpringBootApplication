package com.ivy.springboothello.javax.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {IsMobileValidator.class})
public @interface IsMobile {

    boolean required() default true;

    String message() default "mobile number invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
