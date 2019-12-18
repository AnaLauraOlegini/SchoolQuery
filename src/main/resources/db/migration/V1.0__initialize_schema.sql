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
