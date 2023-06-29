package mz.academy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.dto.SubjectDto;
import mz.academy.domain.entity.Subject;
import mz.academy.store.BaseStore;
import mz.common.domain.NameValueList;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectService {

    private final BaseStore<Subject> subjectStore;

    public String registerSubject(SubjectDto subjectDto) {

        return subjectStore.create(subjectDto.toDomain());
    }

    public void modifySubject(String id, NameValueList nameValues) {
        Subject subject = subjectStore.findById(id);
        subject.modifyValues(nameValues);
        subjectStore.update(subject);
    }

    public void removeSubject(String id) {

        subjectStore.delete(id);
    }

    public Subject findSubject(String id) {

        return subjectStore.findById(id);
    }

    public List<Subject> findAllSubject() {

        return subjectStore.findAll();
    }
}
