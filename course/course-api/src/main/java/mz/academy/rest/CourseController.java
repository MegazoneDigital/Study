package mz.academy.rest;

import lombok.RequiredArgsConstructor;
import mz.course.service.CourseFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/courses")
@RequiredArgsConstructor
@RestController
public class CourseController implements CourseFacade {


}
