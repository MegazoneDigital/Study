package mz.usergate.rest;

import lombok.RequiredArgsConstructor;
import mz.usergate.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/login")
@RequiredArgsConstructor
@RestController
public class UserGateController {

	private final AccountService accountService;

}
