ALTER TABLE conserto ALTER COLUMN nome SET NOT NULL;
ALTER TABLE conserto ALTER COLUMN marca SET NOT NULL;
ALTER TABLE conserto ALTER COLUMN modelo SET NOT NULL;
ALTER TABLE conserto ALTER COLUMN ano SET NOT NULL;
alter table conserto add column ativo boolean;