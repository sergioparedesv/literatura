 # 📚 Java + Spring Boot + Google Books API + SQL

Proyecto base para buscar libros en **Google Books API**, exponer endpoints REST con **Spring Boot**, y guardar favoritos en **SQL** (H2 por defecto; guías para PostgreSQL/MySQL).

---

## 🧭 Índice
- [Descripción](#descripción)
- [Tecnologías](#tecnologías)
- [Arquitectura](#arquitectura)
- [Requisitos previos](#requisitos-previos)
- [Empezar rápido](#empezar-rápido)
- [Variables de entorno](#variables-de-entorno)
- [Configuración de base de datos](#configuración-de-base-de-datos)
- [Endpoints REST](#endpoints-rest)
- [Ejemplos con cURL](#ejemplos-con-curl)
- [Modelo de datos](#modelo-de-datos)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Pruebas](#pruebas)
- [Solución de problemas](#solución-de-problemas)
- [Roadmap](#roadmap)
- [Licencia](#licencia)
- [Agradecimientos](#agradecimientos)

---

## Descripción
Este servicio ofrece una API para **buscar libros** en Google Books y **guardar favoritos** en una base de datos SQL. Ideal para demos, prototipos y como base de un catálogo de libros.

---

## Tecnologías
- **Java 17**
- **Spring Boot 3.x** (Web, Data JPA, Validation)
- **Cliente HTTP** con `WebClient`
- **Base de datos**: H2 (dev) / PostgreSQL o MySQL (prod)
- **Maven**

---

## Arquitectura

