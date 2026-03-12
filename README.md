# Hexagonal Architecture with Spring Boot

## The problem with coupled systems

* A simple change in business requirement affects the entire codebase.
* Replacing an external technology like database, messaging system etc requires massive refactoring.
* Automated tests are complex and slow due to external dependencies.
* New features cause unpredictable side effects.

NB: These problems typically arise from an architecture that fails to adequately separate concerns. Business domain, application logic & external technologies become so intertwined that the system becomes fragile & resistant to change.

## Hexagonal Architecture
- Solves these problems by introducing a powerful mental model that
- "Allows an application to be driven by users, programs, automated tests or batch scripts and to be developed and tested in isolation from its eventual runtime devices & devices."
- It restructures the application into 3 main areas:
-  - Domain: Contains business logic & entities completely independent of external technologies.
-  - Ports: Interfaces that define how the domain interacts with the outside world.
-  - Adapters: Implement ports to connect specific technologies to the domain.
- 