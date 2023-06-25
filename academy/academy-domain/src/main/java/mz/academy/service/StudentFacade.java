package mz.academy.service;

import mz.academy.domain.dto.StudentDto;
import mz.academy.domain.entity.Student;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;

import java.util.List;

public interface StudentFacade {

    ApiResponse<String> registerStudent(StudentDto studentDto);

    ApiResponse<Void> modifyStudent(String id, NameValueList nameValues);

    ApiResponse<Void> removeStudent(String id);

    ApiResponse<Student> findStudent(String id);

    ApiResponse<List<Student>> findAllStudent();
}
