package mz.academy.service;

import mz.academy.domain.dto.TeacherDto;
import mz.academy.domain.entity.Teacher;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;

import java.util.List;

public interface TeacherFacade {

    ApiResponse<String> registerTeacher(TeacherDto teacherDto);

    ApiResponse<Void> modifyTeacher(String id, NameValueList nameValues);

    ApiResponse<Void> removeTeacher(String id);

    ApiResponse<Teacher> findTeacher(String id);

    ApiResponse<List<Teacher>> findAllTeacher();
}
