package mz.course.application.store.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.course.application.store.CourseStore;
import mz.course.application.store.jpa.repository.CourseRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CourseJpaStore implements CourseStore {

    private final CourseRepository courseRepository;

}
