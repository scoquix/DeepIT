package com.scoquix.deepIT.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/docs")
@RestController
public class DocsController {
    @GetMapping
    public String home(){
        StringBuilder builder = new StringBuilder();
        builder.append("<p>Witaj w Dokumentacji ! </p>");
        builder.append("<br><br>");
        builder.append("<p>Articles Endpointy: </p>");
        builder.append("<p> /api/articles/all   <- (GET) zwraca wszystkie artykuły</p>");
        builder.append("<p> /api/articles/1   <- (GET) zwraca pierwszy artykuł</p>");
        builder.append("<p> /api/articles/   <- (POST) dodaje artykuł, nalezy w request body przeslac JSON-a</p>");
        builder.append("<p>np. <br>{ <br>&#09;\"author_id\":\"12\",<br>&#09;\"content\":\"12\",<br>&#09;\"title\":\"12\"<br>}</p>");
        builder.append("<p> /api/articles/ <- (PUT) aktualizuje artykuł, nalezy w request body przeslac JSON-a ( jak wyzej ale dodajac article_id)</p>");
        builder.append("<p> /api/articles?index=1 <- (DELETE) usuwa artykuł, o article_id = 1</p>");
        builder.append("<br><p> Zapytania POST, PUT i DELETE będą zwracać HttpStatus np. POST -> CREATED, PUT -> ACCEPTED, DELETE -> NO_CONTENT</p>");

        return builder.toString();
    }

}
