package mz.course.application.store.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.exception.EntityNotFoundException;
import mz.course.application.store.BaseStore;
import mz.course.application.store.jpa.entity.CourseEntity;
import mz.course.application.store.jpa.repository.CourseRepository;
import mz.course.domain.entity.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CourseJpaStore implements BaseStore<Course> {

    private final CourseRepository courseRepository;

    @Override
    public String create(Course course) {

        CourseEntity courseEntity = new CourseEntity(course);
        courseRepository.save(courseEntity);
        return course.getId();
    }

    @Override
    public void update(Course course) {

        Optional<CourseEntity> optCourseEntity = courseRepository.findById(course.getId());
        if(optCourseEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        CourseEntity savingEntity = optCourseEntity.get();
        BeanUtils.copyProperties(course, this);
        courseRepository.save(savingEntity);
    }

    @Override
    public void delete(String id) {

        courseRepository.deleteById(id);
    }

    @Override
    public Course findById(String id) {

        Optional<CourseEntity> optCourseEntity = courseRepository.findById(id);
        if(optCourseEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return optCourseEntity.get().toDomain();
    }

    @Override
    public List<Course> findAll() {
        return CourseEntity.toDomains(courseRepository.findAll());
    }
}
