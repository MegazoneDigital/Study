package mz.usergate.domain.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import mz.common.util.json.JsonSerializable;

import java.io.Serializable;

@Slf4j
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto implements JsonSerializable, Serializable {
    //
    private String email;
    private String password;
}
