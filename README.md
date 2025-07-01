# Bowling-Game

Dieses Projekt ist eine Implementierung einer Bowling-Game unter Verwendung von Java und Spring Boot, entwickelt mit TDD und Clean Code Practices.

---

## Einrichtung

* **Grund-Setup:** Verwendung von Spring Initializr mit den Abhängigkeiten **Spring Web**, **Lombok** und **Spring Data JPA**.

* **Struktur:** Es wurde eine moderne Ordnerstruktur gemäß den Spring-Best-Practices mit Verzeichnissen wie `entity`, `service`, `controller` usw. angelegt.

---

## Test Driven Development (TDD)

### Vorgehensweise

Der Entwicklungsprozess folgte den TDD-Prinzipien.

1. **Grundlegende Tests:** Zuerst wurden einfache Testfälle und Unit-Tests für die Kernlogik des Bowling-Spiels geschrieben:

   * Test für einen einzelnen Wurf (`roll`).

   * Test für mehrere Würfe.

   * Test für einen Gutterball (0 Pins).

   * Test für ein ganzes Spiel nur mit Gutterballs.

2. **Komplexe Tests & Sonderfälle:** Nachdem die Grundlagen abgedeckt waren, wurden komplexere Szenarien und die "goldenen" Anwendungsfälle getestet:

   * Test für einen **Spare**.

   * Test für einen **Strike**.

   * Test für ein **perfektes Spiel** (12 Strikes).

3. **Dokumentation weitergeschreiben**

---

## Zukünftige Verbesserungen

Bei mehr Zeit könnten folgende Verbesserungen umgesetzt werden:

* Die Anwendung **dockerisieren**.

* **OpenAPI** für die API-Dokumentation integrieren.

* **Postman-Tests** für das API-End-to-End-Testing schreiben.

* **DTO-Klassen** und **Mapper** für weitere Entitäten hinzufügen (z. B. `Frame`, `Player`), um die API-Schicht von der Datenbankschicht zu entkoppeln.

* Ein besseres, **zentralisiertes Exception-Handling** implementieren.

* Einen stärkeren **BDD-Ansatz** (Behavior-Driven Development) verfolgen.

* Weitere **Integrationstests** schreiben.

* Datenbank mit **Datenbankzugriffsdaten** in .env Datei

* Weiterentwicklung vom **Frontend** mit React oder mit Thymeleaf

---

## PS

1. Ich weiß, dass viele schon Bowling gespielt haben. Aber ich vermute, dass einige die Zählregeln übersehen – mich eingeschlossen. Ich habe mir das Spielprinzip genau angesehen, um das Punktesystem zu verstehen, von dessen Boni ich bisher nichts wusste. Tja, bis jetzt :)

2. Der TDD-Ansatz beinhaltet, dass man zuerst Tests schreibt, die einem helfen, den Produktionscode zu erstellen. Bei TDD heißt es oft, man solle zuerst die einfacheren, umliegenden Anwendungsfälle abdecken, bevor man sich der zentralen "goldenen" Funktionalität widmet. Diese wird am Ende entweder automatisch mit abgedeckt oder ist durch den TDD-Prozess bereits zur Hälfte implementiert. Ich halte TDD für einen hervorragenden Ansatz, der einen dazu anleitet, ein eigenes, anwendungsspezifisches Test-Framework zu erstellen.