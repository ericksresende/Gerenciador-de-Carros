CREATE DATABASE IF NOT EXISTS GerenciadorCarros;
USE GerenciadorCarros;

CREATE TABLE carro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100) NOT NULL,
    ano INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade_portas INT NOT NULL,
    tipo_combustivel ENUM('gasolina', 'etanol', 'diesel', 'flex') NOT NULL
);

CREATE TABLE moto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100) NOT NULL,
    ano INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    cilindrada INT NOT NULL
);
