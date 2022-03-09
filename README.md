# BloodDonor

A full stack restful Application to connect with real time donors for voluntary blood donation.

## Technologies used:

### Frontend
- React
- axios

### Backend
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL


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
More than 10 million developers use Twilio’s platform to add customer engagement solutions to their products and services.