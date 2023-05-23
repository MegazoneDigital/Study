package mz.study.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademyDto extends AbstractDto{

    private Long academySeq;
    private String name;
    private String email;
    private String phone;
}
