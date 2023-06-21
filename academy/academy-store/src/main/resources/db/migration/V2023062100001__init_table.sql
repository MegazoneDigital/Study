-- 관리자
create table manager
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    name        VARCHAR(255) NOT NULL COMMENT '이름',
    email       VARCHAR(128) NOT NULL COMMENT '이메일',
    phone       VARCHAR(24) COMMENT '전화번호',
    role_code   VARCHAR(8) COMMENT '룰코드',
    delete_flag BIT DEFAULT FALSE COMMENT '삭제유무',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);

-- 학원관리자
create table academy_manager
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    manager_id        VARCHAR(36)     NOT NULL    COMMENT '매니저 일련번호',
    academy_id        VARCHAR(36)     NOT NULL    COMMENT '학원 일련번호',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);

-- 학생
create table student
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    academy_id            VARCHAR(36)       NOT NULL COMMENT '학원 일련번호',
    name                   VARCHAR(255) NOT NULL COMMENT '이름',
    grade                 INT          NOT NULL COMMENT '학년',
    birthday               DATE         NOT NULL COMMENT '학생 생년월일',
    email                  VARCHAR(128) NOT NULL COMMENT '이메일',
    phone                  VARCHAR(24) COMMENT '전화번호',
    parent_name            VARCHAR(255) NOT NULL COMMENT '학부모이름',
    parent_primary_phone   VARCHAR(24) COMMENT '학부모 전화번호',
    parent_secondary_phone VARCHAR(24) COMMENT '학부모 전화번호2',
    registration_date      DATETIME(6) NOT NULL COMMENT '최초등록일',
    registration_status    BIT DEFAULT FALSE COMMENT '수강등록상태',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);

-- 학원
create table academy
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    name        VARCHAR(255) NOT NULL COMMENT '이름',
    email       VARCHAR(128) NOT NULL COMMENT '이메일',
    phone       VARCHAR(24) COMMENT '전화번호',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);

-- 강사
create table teacher
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    academy_id   VARCHAR(36)       NOT NULL COMMENT '학원 일련번호',
    name         VARCHAR(255) NOT NULL COMMENT '이름',
    subject_type VARCHAR(20)  NOT NULL COMMENT '담당과목유형',
    email        VARCHAR(128) NOT NULL COMMENT '이메일',
    phone        VARCHAR(24)  NOT NULL COMMENT '전화번호',
    delete_flag  BIT DEFAULT FALSE COMMENT '삭제유무',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);

-- 공통코드
create table common_code
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    code       VARCHAR(10) NOT NULL COMMENT '공통 코드',
    main_code  VARCHAR(10)   NOT NULL COMMENT '공통 메인코드',
    code_name  VARCHAR(32)  NOT NULL COMMENT '코드이름',
    use_flag   BIT DEFAULT TRUE COMMENT '사용여부',
    remarks    VARCHAR(255) COMMENT '비고',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id),
    constraint ux_common_code unique (code)
);

-- 과목별 개설 학년
create table subject_grade
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    subject_id        VARCHAR(36)     NOT NULL COMMENT '과목 일련번호',
    grade             INT             NOT NULL COMMENT '학년',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);

-- 과목
create table subject
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    academy_id   VARCHAR(36)      NOT NULL COMMENT '학원 일련번호',
    name         VARCHAR(50) NOT NULL COMMENT '과목명',
    subject_type VARCHAR(20) NOT NULL COMMENT '담당과목유형',
    description  TEXT COMMENT '설명',
    use_flag     BIT DEFAULT TRUE COMMENT '사용여부',
    remarks      VARCHAR(255) COMMENT '비고',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id)
);
