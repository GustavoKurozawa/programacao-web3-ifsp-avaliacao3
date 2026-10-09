-- Comando SQL para criar o campo ativo:
alter table consertos add ativo boolean;

-- Atualizar registros existentes para ativo = true:
update consertos set ativo = true;
