package pl.cms.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ContentValidator.class)//kalsa walidaotora
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Content {//nazwa adnotacji
	int minLength();

	String message() default "min length is 50";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
