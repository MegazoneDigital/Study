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
public class Subject extends DomainEntity {

    private String academyId;

    private String name;

    private String subjectType;

    private String description;

    private boolean useFlag;

    private String remarks;

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
                case "description":
                    this.description = value;
                    break;
                case "useFlag":
                    this.useFlag = Boolean.parseBoolean(value);
                    break;
                case "remarks":
                    this.remarks = value;
                    break;
            }
        }
    }
}
