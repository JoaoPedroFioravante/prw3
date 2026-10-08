create table conserto
(
    id               bigint auto_increment primary key,
    data_entrada     varchar(10),
    data_saida       varchar(10),
    nome             varchar(50),
    anos_experiencia integer,
    marca            varchar(50),
    modelo           varchar(50),
    ano              varchar(4)
);