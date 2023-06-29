package mz.academy.domain.dto;

import lombok.Getter;
import lombok.Setter;
import mz.academy.domain.entity.SubjectGrade;

@Getter
@Setter
public class SubjectGradeDto {

    private String subjectId;
    private int grade;

    public SubjectGrade toDomain() {
        return new SubjectGrade(subjectId, grade);
    }
}
