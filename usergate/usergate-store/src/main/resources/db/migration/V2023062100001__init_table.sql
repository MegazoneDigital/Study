-- 로그인정보
create table account
(
    id                VARCHAR(36)     NOT NULL    COMMENT '엔티티ID',
    version           BIGINT          NOT NULL    COMMENT '엔티티버전',
    login_id       VARCHAR(36) NOT NULL COMMENT '로그인ID',
    password VARCHAR(255) NOT NULL COMMENT '비밀번호',
    email    VARCHAR(128) NOT NULL COMMENT '이메일',
    create_user       VARCHAR(36)     NOT NULL    COMMENT '등록자',
    create_date       DATETIME(6)     NOT NULL    COMMENT '등록일시',
    update_user       VARCHAR(36)     COMMENT '수정자',
    update_date       DATETIME(6)     COMMENT '수정일시',
    PRIMARY KEY (id),
    constraint ux_account_login_id_password unique (login_id, password)
);
