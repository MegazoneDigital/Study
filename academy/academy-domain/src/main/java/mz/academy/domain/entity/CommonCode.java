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
public class CommonCode extends DomainEntity {

    private String code;

    private String mainCode;

    private String codeName;

    private boolean useFlag;

    private String remarks;

    public void modifyValues(NameValueList nameValues) {
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch (nameValue.getName()) {
                case "code":
                    this.code = value;
                    break;
                case "mainCode":
                    this.mainCode = value;
                    break;
                case "codeName":
                    this.codeName = value;
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
