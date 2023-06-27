package mz.academy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.dto.SubjectGradeDto;
import mz.academy.domain.entity.SubjectGrade;
import mz.academy.store.BaseStore;
import mz.common.domain.NameValueList;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectGradeService {

    private final BaseStore<SubjectGrade> subjectGradeStore;

    public String registerSubjectGrade(SubjectGradeDto subjectGradeDto) {

        return subjectGradeStore.create(subjectGradeDto.toDomain());
    }

    public void modifySubjectGrade(String id, NameValueList nameValues) {
        SubjectGrade subjectGrade = subjectGradeStore.findById(id);
        subjectGrade.modifyValues(nameValues);
        subjectGradeStore.update(subjectGrade);
    }

    public void removeSubjectGrade(String id) {

        subjectGradeStore.delete(id);
    }

    public SubjectGrade findSubjectGrade(String id) {

        return subjectGradeStore.findById(id);
    }

    public List<SubjectGrade> findAllSubjectGrade() {

        return subjectGradeStore.findAll();
    }
}
