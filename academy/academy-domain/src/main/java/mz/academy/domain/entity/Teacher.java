package mz.academy.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.NameValue;
import mz.common.domain.NameValueList;
import mz.common.domain.entity.DomainEntity;

@Getter
@Setter
@NoArgsConstructor
public class Teacher extends DomainEntity {

    private String academyId;

    private String name;

    private String subjectType;

    private String email;

    private String phone;

    private boolean deleteFlag;

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
                case "subjectType":
                    this.subjectType = value;
                    break;
                case "email":
                    this.email = value;
                    break;
                case "phone":
                    this.phone = value;
                    break;
                case "deleteFlag":
                    this.deleteFlag = Boolean.parseBoolean(value);
                    break;
            }
        }
    }

    public Teacher(String id, String academyId, String name, String subjectType, String email, String phone) {
        super(id);
        this.academyId = academyId;
        this.name = name;
        this.subjectType = subjectType;
        this.email = email;
        this.phone = phone;
        this.deleteFlag = false;
    }
}
