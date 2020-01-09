CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE aluno
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default",
    cpf character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
	forma_ingresso character varying(255) COLLATE pg_catalog."default" NOT NULL,
    matricula integer,
    CONSTRAINT aluno_pkey PRIMARY KEY (id)
);

CREATE INDEX idx1_aluno_cpf
    ON aluno USING btree
    (cpf COLLATE pg_catalog."default")
    TABLESPACE pg_default;
	
	
CREATE TABLE professor
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default",
    cpf character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
	titulacao character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT professor_pkey PRIMARY KEY (id)
);

CREATE INDEX idx1_professor_cpf
    ON professor USING btree
    (cpf COLLATE pg_catalog."default")
    TABLESPACE pg_default;	

CREATE TABLE disciplina
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    descricao character varying(255) COLLATE pg_catalog."default",
    sigla character varying(255) COLLATE pg_catalog."default",
    carga_horaria integer,
    CONSTRAINT disciplina_pkey PRIMARY KEY (id)
);

CREATE TABLE disciplina_professor_disciplina
(
    id uuid DEFAULT uuid_generate_v4(),
    professor_id character varying(255) COLLATE pg_catalog."default",
    disciplina_id character varying(255) COLLATE pg_catalog."default",
    
    CONSTRAINT disciplina_professor_pkey PRIMARY KEY (id),
    CONSTRAINT FK_disciplina_professor FOREIGN KEY (disciplina_id) 
        REFERENCES disciplina (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE INDEX idx1_disciplina_professor_professor_id
    ON disciplina_professor_disciplina USING btree
    (professor_id COLLATE pg_catalog."default")
    TABLESPACE pg_default;

CREATE TABLE turma
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    descricao character varying(255) COLLATE pg_catalog."default",
    ano_letivo integer,
    periodo_letivo integer,
    numero_vagas integer,    
    CONSTRAINT turma_pkey PRIMARY KEY (id)
);

CREATE TABLE turma_disciplina_turma
(
    id uuid DEFAULT uuid_generate_v4(),
    disciplina_id character varying(255) COLLATE pg_catalog."default",
    turma_id character varying(255) COLLATE pg_catalog."default",
    
    CONSTRAINT turma_disciplina_pkey PRIMARY KEY (id),
    CONSTRAINT FK_turma_disciplina FOREIGN KEY (turma_id) 
        REFERENCES turma (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE INDEX idx1_turma_disciplina_disciplina_id
    ON turma_disciplina_turma USING btree
    (disciplina_id COLLATE pg_catalog."default")
    TABLESPACE pg_default;

CREATE TABLE turma_aluno_turma
(
    id uuid DEFAULT uuid_generate_v4(),
    aluno_id character varying(255) COLLATE pg_catalog."default",
    turma_id character varying(255) COLLATE pg_catalog."default",
    
    CONSTRAINT turma_aluno_pkey PRIMARY KEY (id),
    CONSTRAINT FK_turma_aluno FOREIGN KEY (turma_id) 
        REFERENCES turma (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE INDEX idx1_turma_aluno_aluno_id
    ON turma_aluno_turma USING btree
    (aluno_id COLLATE pg_catalog."default")
    TABLESPACE pg_default;
