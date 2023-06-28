-- 강좌
create table course
(
    id                VARCHAR(36)      NOT NULL    COMMENT '엔티티ID',
    version           BIGINT           NOT NULL    COMMENT '엔티티버전',
    course_planning_id                 VARCHAR(36)      NOT NULL COMMENT '강좌편성 일련번호',
    subject_id                         VARCHAR(36)      NOT NULL COMMENT '과목 일련번호',
    subject_grade_id                   VARCHAR(36)      NOT NULL COMMENT '과목별 학년 일련번호',
    title                              VARCHAR(20) NOT NULL COMMENT '강좌제목',
    remarks                            VARCHAR(255) COMMENT '비고',
    course_registration_start_date     DATETIME(6) NOT NULL COMMENT '재학생 수강신청 시작일',
    course_registration_end_date       DATETIME(6) NOT NULL COMMENT '재학생 수강신청 종료일',
    course_new_registration_start_date DATETIME(6) NOT NULL COMMENT '신입생 수강신청 시작일',
    course_new_registration_end_date   DATETIME(6) NOT NULL COMMENT '신입생 수강신청 시작일',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);

-- 강좌편성
create table course_planning
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    academy_id         VARCHAR(36)      NOT NULL COMMENT '학원 일련번호',
    title               VARCHAR(20) NOT NULL COMMENT '강좌제목',
    planning_year       VARCHAR(4)  NOT NULL COMMENT '편성년도',
    course_open_date    DATETIME(6) NOT NULL COMMENT '전체 강좌 시작일',
    course_close_date   DATETIME(6) NOT NULL COMMENT '전체 강좌 종료일',
    remarks             VARCHAR(255) COMMENT '비고',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);

-- 강좌 세부내역
create table course_item
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    course_id       VARCHAR(36)     NOT NULL COMMENT '강좌 일련번호',
    course_day      TINYINT       NOT NULL COMMENT '요일',
    course_period   VARCHAR(5) NOT NULL COMMENT '교시',
    start_time      VARCHAR(4) NOT NULL COMMENT '시작 시간',
    end_time        VARCHAR(4) NOT NULL COMMENT '종료 시간',
    min_number      INT        NOT NULL COMMENT '최소정원',
    max_number      INT        NOT NULL COMMENT '최대정원',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);

-- 강좌별 담당선생님
create table course_item_teacher
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    course_item_id         VARCHAR(36) NOT NULL COMMENT '강좌세부내역 일련번호',
    teacher_id             VARCHAR(36) NOT NULL COMMENT '선생님 일련번호',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);