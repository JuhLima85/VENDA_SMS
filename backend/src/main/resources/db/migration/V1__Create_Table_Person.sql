CREATE TABLE IF NOT EXISTS public.tb_vendas (
    id bigint NOT NULL,
    data date,
    total integer,
    venda double precision NOT NULL,
    vendedor character varying(255),
    visitas integer,
    CONSTRAINT tb_vendas_pkey PRIMARY KEY (id)
);