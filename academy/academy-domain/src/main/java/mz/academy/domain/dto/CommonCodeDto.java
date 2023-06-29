package mz.academy.domain.dto;

import lombok.Getter;
import lombok.Setter;
import mz.academy.domain.entity.CommonCode;

@Getter
@Setter
public class CommonCodeDto {

    private String code;

    private String mainCode;

    private String codeName;

    private boolean useFlag;

    private String remarks;

    public CommonCode toDomain() {
        return new CommonCode(code, mainCode, codeName, useFlag, remarks);
    }
}
