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
        builder.append("Witaj w Dokumentacji ! ");
        builder.append("<br><br>");
        builder.append("Articles Endpointy: ");
        builder.append(" /api/articles/all   <- (GET) zwraca wszystkie artykuły");
        builder.append(" /api/articles/1   <- (GET) zwraca pierwszy artykuł");
        builder.append(" /api/articles/   <- (POST) dodaje artykuł, nalezy w request body przeslac JSON-a");
        builder.append("np. <br>{ <br>&#09;\"author_id\":\"12\",<br>&#09;\"content\":\"12\",<br>&#09;\"title\":\"12\"<br>}");
        builder.append(" /api/articles/ <- (PUT) aktualizuje artykuł, nalezy w request body przeslac JSON-a ( jak wyzej ale dodajac article_id)");
        builder.append(" /api/articles?index=1 <- (DELETE) usuwa artykuł, o article_id = 1");
        builder.append("<br> Zapytania POST, PUT i DELETE będą zwracać HttpStatus np. POST -> CREATED, PUT -> ACCEPTED, DELETE -> NO_CONTENT");

        return builder.toString();
    }

}
