# Marketplace for Self-Employed

# Solution

I implemented the solution using the following technologies:
- Java 8 - 11
- Spring boot, Spring Data
- Swagger for documenting  the Rest API (endpoint are accesible at http://localhost:8080/swagger-ui.html)
- Junit for testing
- MySql 
- Lombok
- H2 for in memory tests

TESTING:
- Unit tests for the repository layer were made with h2
- with more time I consider neccesary create integration test for the 
main features (creating and retriving pojects, creating bids, ) . And I would
add unit tets for the service layer using Mockito.

Other points that I would cover:
1) Improve exceptions handling, Create more specific exceptions
2) Logs
3) Evaluate to segregate the components in different microservices and if its worthy
4) Configure Docker conatiner
5) Jacoco to check testing coverage.
6) Evaluate using messaging for events like:
  - project deadlines reached and winner is declared
  - when a bid is beated
 
 
##Feedback
- Difficulty: Moderate
- 8
- 7
- I think it was a good excersice. I liked the requierments and the open ending


 