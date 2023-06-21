package mz.course.application.rest;

import lombok.RequiredArgsConstructor;
import mz.course.application.service.CourseApplicationFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/course-applications")
@RequiredArgsConstructor
@RestController
public class CourseApplicationController implements CourseApplicationFacade {

}
