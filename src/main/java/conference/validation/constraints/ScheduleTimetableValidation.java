package conference.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {ScheduleTimetableValidator.class}
)
public @interface ScheduleTimetableValidation {

    String message() default "Wrong time";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
