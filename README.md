Architecture Diagram 

![architecture-diagram](./architecture-diagram.png)


Request postcode-service get postcode

[GET] http://localhost:8070/postcode-service/api/v1/postcode/AB10%201XG

```json
  {
    "status": "OK",
    "response": {
        "postcode": "AB10 1XG",
        "latitude": 57.14270100,
        "longitude": -2.09329500
    }
}
```

