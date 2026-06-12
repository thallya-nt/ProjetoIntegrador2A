📅 AGENDA DE CONTATOS (PureJava)

Uma aplicação de agenda simples e eficiente desenvolvida em Java Puro (sem frameworks), utilizando JDBC para
comunicação direta com o banco de dados relacional.

## TECNOLOGIAS UTILIZADAS⚙️ ##

* **Java (version 24.0.2):** Linguagem principal do projeto, explorando os conceitos de Orientação a Objetos.
* **JDBC (Java Database Connectivity):** Utilizado na classe `conFactory` para realizar a ponte de comunicação com o banco de dados.
* **Driver do Banco de Dados:** Configurado manualmente no projeto para permitir a persistência de dados.

## ARQUITETURA DO PROJETO🧩 ##
O projeto preza pela simplicidade e separação de conceitos em Java Puro:
* **Classe `conFactory`:** Centraliza a configuração do driver, URL do banco, usuário e senha,
sendo responsável por abrir e fechar as conexões de forma segura.
* **Modelo/Entidade:** Classes que representam os dados da agenda ('Contato.java').
* **Regras de Negócio/Main:** Manipulação dos dados e interface via terminal/console ('AgendaTeste.java').

## SCRIPT SQL (MySQL)📄 ##
*  você pode baixar o script através desse link: [scriptSQL.sql](https://github.com/user-attachments/files/28877032/scriptSQL.sql)
ou copiar o código abaixo:

```
   -- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema agendaTelefonica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agendaTelefonica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agendaTelefonica` DEFAULT CHARACTER SET utf8 ;
USE `agendaTelefonica` ;

-- -----------------------------------------------------
-- Table `agendaTelefonica`.`contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendaTelefonica`.`contato` (
  `idcontato` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `idcontato_UNIQUE` (`idcontato` ASC) VISIBLE,
  PRIMARY KEY (`idcontato`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
```

## COMO EXECUTAR O PROJETO 📂 ##

1. Clone o repositório;
2.  Execute o script SQL; 
3.  Abra o arquivo 'conFactory' e verifique se as credenciais precisam ser alteradas;
```
    private static final String url = "jdbc:mysql://localhost:3306/agendatelefonica";
    private static final String user = "root";
    private static final String password = " ";
```
4.  Verifique se o Driver está adicionado na biblioteca do projeto (Classpath);
5.  Execute o projeto através da classe 'AgendaTeste'.

Projeto desenvolvido por : Thallya
