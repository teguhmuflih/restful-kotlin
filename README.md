# API SPEC

## Authentication
All API should use this authentication

Request :
- Header : 
  - X-API-Key : "your secret api key"

## Create Product
Request :
- Method : POST
- Endpoint : "Api/products/"
- Header :
    - content-type : application/json
    - Accept : application/json
- Body : 
```json
{
  "id" : "String, unique",
  "name" : "String",
  "price" : "Long",
  "quantity" : "Integer"
}
```
Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : 
  [
    {"id" : "String, unique",
    "name" : "String",
    "price" : "Long",
    "quantity" : "Integer",
    "createdAt" : "date",
    "updatedAt" : "date"}
  ]
}
```

## Get Product

Request :
- Method : GET
- Endpoint : "Api/products/{id_product}"
- Header :
    - Accept : application/json

Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [{
    "id" : "String, unique",
    "name" : "String",
    "price" : "Long",
    "quantity" : "Integer",
    "createdAt" : "date",
    "updatedAt" : "date"
  }
  ]
}
```

## Update Product
Request :
- Method : PUT
- Endpoint : "Api/products/{id_product}"
- Header :
    - content-type : application/json
    - Accept : application/json
- Body :
```json
{
  "name" : "String",
  "price" : "Long",
  "quantity" : "Integer"
}
```
Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [{
        "id" : "String, unique",
        "name" : "String",
        "price" : "Long",
        "quantity" : "Integer",
        "createdAt" : "date",
        "updatedAt" : "date"
      }
  ]
}
```

## List Product
Request :
- Method : GET
- Endpoint : "Api/products"
- Header :
    - Accept : application/json
- Query Param
  - page : "number"
  - size : "number"
Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [ {
    "id" : "String, unique",
    "name" : "String",
    "price" : "Long",
    "quantity" : "Integer",
    "createdAt" : "date",
    "updatedAt" : "date"
  },
    {
      "id" : "String, unique",
      "name" : "String",
      "price" : "Long",
      "quantity" : "Integer",
      "createdAt" : "date",
      "updatedAt" : "date"
    }
  ]
}
```


## Delete product
Request :
- Method : DELETE
- Endpoint : "Api/products/{id_product}"
- Header :
    - Accept : application/json

Response :
```json
{
  "code" : "number",
  "status" : "string"
}
```