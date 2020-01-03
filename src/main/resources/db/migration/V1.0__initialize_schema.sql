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
