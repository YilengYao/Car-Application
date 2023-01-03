http://localhost:8085/graphiql

Queries

```graphql
query allCars {
  allCars(car_year_range: {
    min_year: 2009
    max_year: 2020
  }) {
    car_id
    first_name
    last_name
    email
    gender
    country
    city
    street_number
    address
    credit_card_type
    credit_card
    currency
    ethnicity
    car_make
    car_model
    car_model_year
    car_vin
  }
}
```
```graphql
query cars {
  cars(ids: [1001]) {
    car_id
    first_name
    last_name
    email
    gender
    country
    city
    street_number
    address
    credit_card_type
    credit_card
    currency
    ethnicity
    car_make
    car_model
    car_model_year
    car_vin
  }
}
```

Mutation
```graphql
mutation createCar {
  createCar(
    first_name: "Yi", 
  	last_name: "Yao",
    email: "yiyao@gmail.com",
    gender: Male,
    country: "Canada",
    city: "Vancouver",
    street_number: "123",
    address: "Marine DR",
    credit_card_type: "Master Card",
    credit_card: 1234566,
    currency: "CDN",
    ethnicity: "Sibarian",
    car_make: "Tesla",
    car_model: "Model Y",
    car_model_year: 2022,
    car_vin: "abcdefghi12kkkk"
  ) {
    id
  }
}
```