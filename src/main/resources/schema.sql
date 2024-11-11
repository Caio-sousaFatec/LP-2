-- Tabela de Leilão
CREATE TABLE Leilao
(
    id_leilao       INT AUTO_INCREMENT PRIMARY KEY,
    data_ocorrencia DATE         NOT NULL,
    data_visitacao  DATE         NOT NULL,
    local           VARCHAR(255) NOT NULL,
    endereco        VARCHAR(255),
    cidade          VARCHAR(100),
    estado          VARCHAR(2),
    status          VARCHAR(20)  NOT NULL -- EM ABERTO, EM ANDAMENTO, FINALIZADO
);

-- Tabela de Lote (dispositivos ou veículos)
CREATE TABLE Lote
(
    id_lote       INT AUTO_INCREMENT PRIMARY KEY,
    tipo          VARCHAR(50)    NOT NULL, -- 'dispositivo' ou 'veículo'
    nome          VARCHAR(100)   NOT NULL, -- Nome do item (notebook, carro, etc.)
    descricao     TEXT,
    lance_inicial DECIMAL(10, 2) NOT NULL,
    id_leilao     INT            NOT NULL,
    CONSTRAINT fk_leilao FOREIGN KEY (id_leilao) REFERENCES Leilao (id_leilao)
);

-- Tabela de Cliente
CREATE TABLE Cliente
(
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome       VARCHAR(100)       NOT NULL,
    cpf        VARCHAR(11) UNIQUE NOT NULL,
    email      VARCHAR(100),
    telefone   VARCHAR(15)
);

-- Tabela de Lance
CREATE TABLE Lance
(
    id_lance   INT AUTO_INCREMENT PRIMARY KEY,
    valor      DECIMAL(10, 2) NOT NULL,
    id_cliente INT            NOT NULL,
    id_lote    INT            NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES Cliente (id_cliente),
    CONSTRAINT fk_lote FOREIGN KEY (id_lote) REFERENCES Lote (id_lote)
);

-- Tabela de Instituições Financeiras
CREATE TABLE InstituicaoFinanceira
(
    id_instituicao INT AUTO_INCREMENT PRIMARY KEY,
    nome           VARCHAR(100) NOT NULL,
    cnpj           VARCHAR(14)  NOT NULL
);

-- Inserts para InstituicaoFinanceira
INSERT INTO InstituicaoFinanceira (nome, cnpj)
VALUES
    ('Banco do Brasil', '00123456000100'),
    ('Caixa Econômica', '00765432000100'),
    ('Bradesco', '12345678000100');

-- Inserts para Leilao
INSERT INTO Leilao (data_ocorrencia, data_visitacao, local, endereco, cidade, estado, status)
VALUES
    ('2024-11-15', '2024-11-10', 'Galpão A', 'Rua 123', 'São Paulo', 'SP', 'EM ABERTO'),
    ('2024-11-20', '2024-11-18', 'Galpão B', 'Avenida 456', 'Rio de Janeiro', 'RJ', 'EM ANDAMENTO'),
    ('2024-11-25', '2024-11-23', 'Galpão C', 'Praça 789', 'Curitiba', 'PR', 'FINALIZADO');


-- Associação entre Leilão e Instituições Financeiras
CREATE TABLE Leilao_Instituicao
(
    id_leilao      INT,
    id_instituicao INT,
    PRIMARY KEY (id_leilao, id_instituicao),
    CONSTRAINT fk_leilao_inst FOREIGN KEY (id_leilao) REFERENCES Leilao (id_leilao),
    CONSTRAINT fk_inst_leilao FOREIGN KEY (id_instituicao) REFERENCES InstituicaoFinanceira (id_instituicao)
);


-- Inserts para Lote
INSERT INTO Lote (tipo, nome, descricao, lance_inicial, id_leilao)
VALUES
    ('dispositivo', 'Notebook Dell', 'Notebook Dell Inspiron 15', 1500.00, 1),
    ('veículo', 'Carro Toyota Corolla', 'Corolla 2020, cor prata', 35000.00, 2),
    ('dispositivo', 'Smartphone Samsung', 'Samsung Galaxy S21', 2000.00, 1),
    ('veículo', 'Moto Honda CB500', 'Honda CB500 2018, cor preta', 12000.00, 3);

-- Inserts para Cliente
INSERT INTO Cliente (nome, cpf, email, telefone)
VALUES
    ('João Silva', '12345678901', 'joao@gmail.com', '11987654321'),
    ('Maria Souza', '23456789012', 'maria@gmail.com', '21987654321'),
    ('Carlos Pereira', '34567890123', 'carlos@gmail.com', '31987654321');

-- Inserts para Lance
INSERT INTO Lance (valor, id_cliente, id_lote)
VALUES
    (1600.00, 1, 1),
    (36000.00, 2, 2),
    (2050.00, 3, 3),
    (13000.00, 1, 4);



-- Inserts para Leilao_Instituicao
INSERT INTO Leilao_Instituicao (id_leilao, id_instituicao)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 1);
