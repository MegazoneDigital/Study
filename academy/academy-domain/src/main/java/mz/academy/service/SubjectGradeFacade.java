package mz.academy.service;

import mz.academy.domain.dto.SubjectGradeDto;
import mz.academy.domain.entity.SubjectGrade;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;

import java.util.List;

public interface SubjectGradeFacade {

    ApiResponse<String> registerSubjectGrade(SubjectGradeDto subjectGradeDto);

    ApiResponse<Void> modifySubjectGrade(String id, NameValueList nameValues);

    ApiResponse<Void> removeSubjectGrade(String id);

    ApiResponse<SubjectGrade> findSubjectGrade(String id);

    ApiResponse<List<SubjectGrade>> findAllSubjectGrade();
}
