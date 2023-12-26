Architecture Diagram 

![architecture-diagram](./architecture-diagram.png)


Postcode-service to get postcode

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


Postcode-service to update postcode

[PUT] http://localhost:8070/postcode-service/api/v1/postcode

Request
```json
  {
      "postcode": "AB10 1XG",
      "latitude": 57.14415601,
      "longitude": -2.11486400
  }
```


Response 
```json
  {
    "status": "OK",
    "response": {
        "postcode": "AB10 1XG",
        "latitude": 57.14415601,
        "longitude": -2.11486400
    }
}
```


Distance-service to calculate distance 

[POST] http://localhost:8070/distance-service/api/v1/distance

Request
```json
{
    "from": "AB10 1XG",
    "to": "AB10 6RN"
}
```

Response 
```json
{
    "status": "OK",
    "response": {
        "from": {
            "postcode": "AB10 1XG",
            "latitude": 57.14415601,
            "longitude": -2.11486400
        },
        "to": {
            "postcode": "AB10 6RN",
            "latitude": 57.13787100,
            "longitude": -2.12148700
        },
        "distance": 0.8050261295897083,
        "unit": "km"
    }
}
```
