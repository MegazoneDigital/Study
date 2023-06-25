package mz.academy.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.NameValue;
import mz.common.domain.NameValueList;
import mz.common.domain.entity.DomainEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class Student extends DomainEntity {

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

    public void modifyValues(NameValueList nameValues) {
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch (nameValue.getName()) {
                case "academyId":
                    this.academyId = value;
                    break;
                case "name":
                    this.name = value;
                    break;
                case "grade":
                    this.grade = Integer.parseInt(value);
                    break;
                case "birthday":
                    this.birthday = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    break;
                case "email":
                    this.email = value;
                    break;
                case "phone":
                    this.phone = value;
                    break;
                case "parentName":
                    this.parentName = value;
                    break;
                case "parentPrimaryPhone":
                    this.parentPrimaryPhone = value;
                    break;
                case "parentSecondaryPhone":
                    this.parentSecondaryPhone = value;
                    break;
                case "registrationDate":
                    this.registrationDate = LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    break;
                case "registrationStatus":
                    this.registrationStatus = Boolean.parseBoolean(value);
                    break;
            }
        }
    }

    public Student(String id, String academyId, String name, int grade, LocalDate birthday, String email,
                   String phone, String parentName, String parentPrimaryPhone, String parentSecondaryPhone,
                   LocalDateTime registrationDate, boolean registrationStatus) {

        super(id);
        this.academyId = academyId;
        this.name = name;
        this.grade = grade;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.parentName = parentName;
        this.parentPrimaryPhone = parentPrimaryPhone;
        this.parentSecondaryPhone = parentSecondaryPhone;
        this.registrationDate = registrationDate;
        this.registrationStatus = registrationStatus;
    }
}
