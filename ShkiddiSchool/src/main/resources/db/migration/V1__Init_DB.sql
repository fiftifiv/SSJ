create table answer
(
    id   integer not null,
    text varchar(255),
    primary key (id)
) engine = MyISAM;

create table article
(
    id      bigint not null,
    text    varchar(255),
    title   varchar(255),
    test_id integer,
    primary key (id)
) engine = MyISAM;

create table article_photo_articles
(
    article_id        bigint not null,
    photo_articles_id bigint not null,
    primary key (article_id, photo_articles_id)
) engine = MyISAM;

create table hibernate_sequence
(
    next_val bigint
) engine = MyISAM;


insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);




create table photo_article
(
    id     bigint  not null,
    name   varchar(255),
    number integer not null,
    primary key (id)
) engine = MyISAM;

create table progres
(
    id                   integer not null,
    number_of_passes     integer not null,
    test_completion_rate integer not null,
    test_id              integer,
    primary key (id)
) engine = MyISAM;

create table question
(
    id          integer not null,
    question    varchar(255),
    true_answer varchar(255),
    primary key (id)
) engine = MyISAM;

create table question_false_answers
(
    question_id      integer not null,
    false_answers_id integer not null,
    primary key (question_id, false_answers_id)
) engine = MyISAM;

create table test
(
    id integer not null,
    primary key (id)
) engine = MyISAM;

create table test_questions
(
    test_id      integer not null,
    questions_id integer not null,
    primary key (test_id, questions_id)
) engine = MyISAM;

create table user
(
    id              bigint not null,
    activation_code varchar(255),
    active          bit    not null,
    email           varchar(255),
    password        varchar(255),
    username        varchar(255),
    primary key (id)
) engine = MyISAM;

create table user_progres
(
    user_id    bigint  not null,
    progres_id integer not null,
    primary key (user_id, progres_id)
) engine = MyISAM;

create table user_roles
(
    user_id bigint not null,
    roles   varchar(255)
) engine = MyISAM;

