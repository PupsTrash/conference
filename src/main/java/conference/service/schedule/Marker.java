package conference.service.schedule;

import conference.validation.constraints.ScheduleTimetableValidation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;


public interface Marker {
    interface OnCreate {}

    interface OnUpdate {}
}
