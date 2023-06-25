package mz.academy.domain.dto;

import lombok.Getter;
import lombok.Setter;
import mz.academy.domain.entity.Teacher;

import java.util.UUID;

@Getter
@Setter
public class TeacherDto {

    private String academyId;

    private String name;

    private String subjectType;

    private String email;

    private String phone;

    private boolean deleteFlag;

    public Teacher toDomain() {
        return new Teacher(UUID.randomUUID().toString(), academyId, name, subjectType, email, phone);
    }
}
