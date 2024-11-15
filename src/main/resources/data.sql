-- Tabela cliente
INSERT INTO cliente (id, nome, cpf, email, telefone)
VALUES (1, 'João da Silva', '123.456.789-00', 'joao.silva@example.com', '(11) 91234-5678'),
       (2, 'Maria Oliveira', '987.654.321-00', 'maria.oliveira@example.com', '(21) 92345-6789'),
       (3, 'Carlos Pereira', '456.789.123-00', 'carlos.pereira@example.com', '(31) 93456-7890');

-- Tabela instituicao
INSERT INTO instituicao (nome, cnpj)
VALUES ('Banco do Brasil', '01.234.567/0001-89'),
       ('Caixa Econômica Federal', '98.765.432/0001-10'),
       ('Bradesco', '12.345.678/0001-21');

-- Tabela leilao
INSERT INTO leilao (id_leilao, nome_leilao, data_ocorrencia, data_visitacao, local, endereco, cidade, estado, status)
VALUES (1, 'Leilao da Creuza', '2024-12-01', '2024-11-25', 'Auditório Central', 'Rua das Flores, 100', 'São Paulo',
        'SP', 'Aberto'),
       (2, 'Leilao da PRF', '2024-12-15', '2024-12-10', 'Pátio', 'Av. dos migrantes, 1268', 'Jacareí',
        'RJ', 'Aberto'),
       (3, 'Leilao do STJ', '2024-5-15', '2024-6-10', 'Centro de Convenções', 'Av. Brasil, 2000', 'Rio de Janeiro',
        'RJ', 'Aberto');

-- Tabela leilao_instituicao
INSERT INTO leilao_instituicao (id_leilao, id_instituicao)
VALUES (1, 1),
       (3, 2),
       (2, 3);

-- Tabela lote
INSERT INTO lote (tipo, nome, descricao, lance_inicial, leilao_id_leilao)
VALUES ('Veículo', 'Carro Sedan', 'Carro usado, bom estado', 15000.00, 1),
       ('Eletrônico', 'Notebook Dell', 'Notebook semi-novo, i7', 3000.00, 1),
       ('Imóvel', 'Apartamento 2 Quartos', 'Apartamento em boa localização', 250000.00, 2);

-- Tabela lance
INSERT INTO lance (valor, cliente_id, lote_id)
VALUES (16000.00, 1, 1),
       (3200.00, 2, 2),
       (260000.00, 3, 3);
