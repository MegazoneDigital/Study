package mz.academy.domain.dto;

import lombok.Getter;
import lombok.Setter;
import mz.academy.domain.entity.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class StudentDto {

    private String academyId;

    private String name;

    private int grade;

    private LocalDate birthday;

    private String email;

    private String phone;

    private String parentName;

    private String parentPrimaryPhone;

    private String parentSecondaryPhone;

    private LocalDateTime registrationDate;

    private boolean registrationStatus;

    public Student toDomain() {
        return new Student(UUID.randomUUID().toString(), academyId, name, grade, birthday,
                email, phone, parentName, parentPrimaryPhone, parentSecondaryPhone,
                registrationDate, registrationStatus);
    }
}
