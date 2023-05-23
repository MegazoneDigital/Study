package mz.study.api.controller;

import lombok.RequiredArgsConstructor;
import mz.study.service.AcademyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/study/academy")
@RequiredArgsConstructor
@RestController
public class AcademyController {
	private final AcademyService academyService;

	@GetMapping
	public ResponseEntity<Void> test() {
		academyService.test();
		return ResponseEntity.ok(null);
	}
}
