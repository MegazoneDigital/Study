package mz.academy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.dto.TeacherDto;
import mz.academy.domain.entity.Teacher;
import mz.academy.store.BaseStore;
import mz.common.domain.NameValueList;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherService {

    private final BaseStore<Teacher> teacherStore;

    public String registerTeacher(TeacherDto teacherDto) {

        return teacherStore.create(teacherDto.toDomain());
    }

    public void modifyTeacher(String id, NameValueList nameValues) {
        Teacher teacher = teacherStore.findById(id);
        teacher.modifyValues(nameValues);
        teacherStore.update(teacher);
    }

    public void removeTeacher(String id) {

        teacherStore.delete(id);
    }

    public Teacher findTeacher(String id) {

        return teacherStore.findById(id);
    }

    public List<Teacher> findAllTeacher() {

        return teacherStore.findAll();
    }
}
