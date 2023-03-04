CREATE SCHEMA IF NOT EXISTS wc;

CREATE SEQUENCE wc.word_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE wc.category_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE wc.study_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE wc.word
(
    id            bigint DEFAULT nextval('wc.word_id_seq'::regclass) NOT NULL,
    hu            varchar(100)                                       NOT NULL,
    en            varchar(100)                                       NOT NULL,
    category_code varchar(20)                                        NOT NULL,
    letrehozo     varchar(50),
    letrehozas    timestamp,
    modosito      varchar(50),
    modositas     timestamp,
    "version"     integer,
    CONSTRAINT wc_word_pkey PRIMARY KEY (id)
);


CREATE TABLE wc.category
(
    id          bigint DEFAULT nextval('wc.category_id_seq'::regclass) NOT NULL,
    code        varchar(20)                                            NOT NULL,
    name        varchar(50)                                            NOT NULL,
    description varchar(200)                                           NOT NULL,
    letrehozo   varchar(50),
    letrehozas  timestamp,
    modosito    varchar(50),
    modositas   timestamp,
    "version"   integer,
    CONSTRAINT wc_category_pkey PRIMARY KEY (id)
);


CREATE TABLE wc.study
(
    id            bigint  DEFAULT nextval('wc.study_id_seq'::regclass) NOT NULL,
    word_id       bigint                                               NOT NULL,
    user_id       bigint                                               NOT NULL,
    studied       boolean                                              NOT NULL,
    studied_times integer DEFAULT 0,
    letrehozo     varchar(50),
    letrehozas    timestamp,
    modosito      varchar(50),
    modositas     timestamp,
    "version"     integer,
    CONSTRAINT wc_study_pkey PRIMARY KEY (id)
);

-- USER tábla, és constraintek kialakítása
