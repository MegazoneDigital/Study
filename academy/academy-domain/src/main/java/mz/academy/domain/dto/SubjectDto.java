package mz.academy.domain.dto;

import lombok.Getter;
import lombok.Setter;
import mz.academy.domain.entity.Subject;

@Getter
@Setter
public class SubjectDto {

    private String academyId;

    private String name;

    private String subjectType;

    private String description;

    private boolean useFlag;

    private String remarks;

    public Subject toDomain() {
        return new Subject(academyId, name, subjectType, description, useFlag, remarks);
    }
}
