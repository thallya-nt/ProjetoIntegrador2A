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
*  você pode baixar o script através desse link:[scriptSQL.sql](https://github.com/user-attachments/files/29021858/scriptSQL.sql)
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
  UNIQUE INDEX `idcontato_UNIQUE` (`idcontato` ASC) ,
  PRIMARY KEY (`idcontato`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

```

## DUMP DO BANCO DE DADOS ⬇️ ##
*  você pode acessar o dump através desse link: [dumpMySQL.sql](https://github.com/user-attachments/files/29018974/dumpMySQL.sql)   ou copiando o código abaixo :
```
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: agendatelefonica
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contato` (
  `idcontato` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idcontato`),
  UNIQUE KEY `idcontato_UNIQUE` (`idcontato`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` VALUES (3,'Bianca','990456679','Bianca@example');
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-16 16:46:42

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
