package mz.academy.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.NameValue;
import mz.common.domain.NameValueList;
import mz.common.domain.entity.DomainEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectGrade extends DomainEntity {

    private String subjectId;
    private int grade;

    public void modifyValues(NameValueList nameValues) {
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch (nameValue.getName()) {
                case "subjectId":
                    this.subjectId = value;
                    break;
                case "grade":
                    this.grade = Integer.parseInt(value);
                    break;
            }
        }
    }
}
