package conference.validation.constraints;

import conference.service.schedule.Marker;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {ScheduleTimetableValidator.class}
)
public @interface ScheduleTimetableValidation {

    String message() default "Wrong time";

    @NotNull(groups = {Primary.class})
    Class<?>[] groups() default {};

    @NotNull(groups = {Secondary.class})
    Class<? extends Payload>[] payload() default {};
}
