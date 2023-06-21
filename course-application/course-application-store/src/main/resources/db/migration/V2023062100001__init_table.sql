-- 수강신청
create table course_application
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    student_id              VARCHAR(36)      NOT NULL COMMENT '학생 일련번호',
    course_item_teacher_id  VARCHAR(36)      NOT NULL COMMENT '강좌별 담당 선생님 일련번호',
    receipt_date            DATETIME(6) NOT NULL COMMENT '접수 시간',
    receipt_status          VARCHAR(10) NOT NULL COMMENT '접수상태',
    wait_number             INT COMMENT '대기번호',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);