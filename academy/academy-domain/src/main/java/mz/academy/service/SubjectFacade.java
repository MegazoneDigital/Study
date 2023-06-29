package mz.academy.service;

import mz.academy.domain.dto.SubjectDto;
import mz.academy.domain.entity.Subject;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;

import java.util.List;

public interface SubjectFacade {

    ApiResponse<String> registerSubject(SubjectDto subjectDto);

    ApiResponse<Void> modifySubject(String id, NameValueList nameValues);

    ApiResponse<Void> removeSubject(String id);

    ApiResponse<Subject> findSubject(String id);

    ApiResponse<List<Subject>> findAllSubject();
}
