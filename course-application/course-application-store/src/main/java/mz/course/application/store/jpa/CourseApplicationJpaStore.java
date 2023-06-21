package mz.course.application.store.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.course.application.store.CourseApplicationStore;
import mz.course.application.store.jpa.repository.CourseApplicationRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CourseApplicationJpaStore implements CourseApplicationStore {

    private final CourseApplicationRepository courseApplicationRepository;

}
