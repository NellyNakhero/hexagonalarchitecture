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

## The Domain
- The domain should be pure without annotations or dependencies on external frameworks.
- `Grafitti Entity is a domain`

## Ports
- Defines the boundaries
- Ports are interfaces that define how the domain communicates.
- `GrafitiRepository` is an Output port(secondary)
- `GraffitiManagementUseCase` is an input port(primary)

## Use cases
- Orchestrates the domain
- Usecases implement primary ports and use secondary ports.
- `GrafittiManagementService` is a usecase

## Adapters
- Connects with the external world
- Implements ports to provide concrete functionality.
- `JpaRepositoryAdapter` is an output adapter for repository implementation with spring data JPA
- `GraffitiController` is an input adapter for REST implementation