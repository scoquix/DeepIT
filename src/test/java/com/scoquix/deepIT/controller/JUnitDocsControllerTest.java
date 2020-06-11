package com.scoquix.deepIT.controller;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class JUnitDocsControllerTest {

    @Test
    public void testHomeController() {
        DocsController docsController = new DocsController();
        String actual = docsController.home();
        String expected = "<p>Witaj w Dokumentacji ! </p>" +
                "<br><br>" +
                "<p>Articles Endpointy: </p>" +
                "<p> /api/articles/all   <- (GET) zwraca wszystkie artykuły</p>" +
                "<p> /api/articles/1   <- (GET) zwraca pierwszy artykuł</p>" +
                "<p> /api/articles/   <- (POST) dodaje artykuł, nalezy w request body przeslac JSON-a</p>" +
                "<p>np. <br>{ <br>&#09;\"author_id\":\"12\",<br>&#09;\"content\":\"12\",<br>&#09;\"title\":\"12\"<br>}</p>" +
                "<p> /api/articles/ <- (PUT) aktualizuje artykuł, nalezy w request body przeslac JSON-a ( jak wyzej ale dodajac article_id)</p>" +
                "<p> /api/articles?index=1 <- (DELETE) usuwa artykuł, o article_id = 1</p>" +
                "<br><p> Zapytania POST, PUT i DELETE będą zwracać HttpStatus np. POST -> CREATED, PUT -> ACCEPTED, DELETE -> NO_CONTENT</p>";
        assertEquals(expected,actual);
    }
}
