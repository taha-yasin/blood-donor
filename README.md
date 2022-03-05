<<<<<<< HEAD
# blood-donor
=======
# BloodDonor

A full stack restful Application to connect with real time donors for voluntary blood donation.

## Technologies used:

- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL

<<<<<<< HEAD
## Challenges

- MultipleBagFetchException

=======

## Challenges
- MultipleBagFetchException


## ER Diagram

```mermaid

erDiagram
    DONOR ||--o{ REQUEST : Connets
    DONOR {
        string name
        string bloodGroup
        int age
    }
    RECIPIENT ||--o{ REQUEST : CreateRequest
    RECIPIENT {
        string name
        string address
    }
    REQUEST {
        Long RequestId
        string bloodGroup
        string status
    }
```
