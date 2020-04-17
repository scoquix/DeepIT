# deepIT
Educational Project - Simple REST API (Spring, Hibernate, JPA, PostgreSQL)

API info: 

  Articles Endpointy:
  
    /api/articles/all   <- (GET) zwraca wszystkie artykuły
    
    /api/articles/1   <- (GET) zwraca pierwszy artykuł
    
    /api/articles/   <- (POST) dodaje artykuł, nalezy w request body przeslac JSON-a
    
    np. {
          "author_id":"12",
          "content":"12", 
          "title":"12"
        }
        
    /api/articles/ <- (PUT) aktualizuje artykuł, nalezy w request body przeslac JSON-a ( jak wyzej ale dodajac article_id)
    
    /api/articles?index=1 <- (DELETE) usuwa artykuł, o article_id = 1

    Zapytania POST, PUT i DELETE będą zwracać HttpStatus np. POST -> CREATED, PUT -> ACCEPTED, DELETE -> NO_CONTENT
