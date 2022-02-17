# KeremAlp-Case2
## İstenen işlemlerin yapılması için şimdilik Requestler:
### ###
POST http://localhost:9001/api/v1/town
Content-Type: application/json

{"townName": "Derince",
  "province": {
  "provinceName": "Kocaeli",
  "plateCode": "41","country": {
      "countryName": "Rusya",
      "countryCode": "Rus"
    }}

}


###
POST http://localhost:9001/api/v1/country
Content-Type:application/json

{
      "countryName": "Türkiye",
      "countryCode": "TR"
    }

###
POST http://localhost:9001/api/v1/province
Content-Type:application/json

{
  "provinceName": "Kocaeli",
  "plateCode": "41",
  "country_Id": 1
}

###
POST http://localhost:9001/api/v1/neighborhood
Content-Type: application/json

{"neighName": "Yenikent","town":{"townName": "Derince",
  "province": {
    "provinceName": "Kocaeli",
    "plateCode": "41","country": {
      "countryName": "Türkiye",
      "countryCode": "TR  "
    }}}

}

###

POST http://localhost:9001/api/v1/address
Content-Type: application/json

{
  "country":"Türkiye",
  "province": "Ankara",
  "town":"Dikmen",
  "neighborhood": "7.mahalle",
  "street":"330.sk",
  "doorNumber":"8",
  "aptNumber":"25"

}

###
PUT http://localhost:9001/api/v1/neighborhood/1?name=Değiştirdim
Content-Type: application/json

###
PUT http://localhost:9001/api/v1/address
Content-Type: application/json

{
  "id": 1,
  "province":"Kütahya"

}

###

POST http://localhost:9001/api/v1/street
Content-Type: application/json

{"streetName":"Mevlana","doorNumber": "21","aptNumber": "a1","neighborhood":{"neighName": "Yenikent","town":{"townName": "Derince",
  "province": {
    "provinceName": "Kocaeli",
    "plateCode": "41","country": {
      "countryName": "Türkiye",
      "countryCode": "TR  "
    }}}}

}

