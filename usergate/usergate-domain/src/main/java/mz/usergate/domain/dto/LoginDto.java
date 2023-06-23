package mz.usergate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.util.json.JsonSerializable;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto implements JsonSerializable, Serializable {
    //
    private String loginId;
    private String password;
}
