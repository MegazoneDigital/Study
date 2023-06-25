package mz.academy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.dto.StudentDto;
import mz.academy.domain.entity.Student;
import mz.academy.store.BaseStore;
import mz.common.domain.NameValueList;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final BaseStore<Student> studentStore;

    public String registerStudent(StudentDto studentDto) {

        return studentStore.create(studentDto.toDomain());
    }

    public void modifyStudent(String id, NameValueList nameValues) {
        Student student = studentStore.findById(id);
        student.modifyValues(nameValues);
        studentStore.update(student);
    }

    public void removeStudent(String id) {

        studentStore.delete(id);
    }

    public Student findStudent(String id) {

        return studentStore.findById(id);
    }

    public List<Student> findAllStudent() {

        return studentStore.findAll();
    }
}
