# API Documentation

Documentation available at `/swagger-ui/index.html`

## Examples

### Example 1
Request:  
`GET /api/currency/convert?from=USD&to=KZT`

Result:
```
{
    "KZT": 463.08,
    "USD": 1.0
}
```

### Example 2
Request:  
`GET /api/currency/convert?amount=100&to=KZT,RUB,BTC&from=USD`  

Result:
```
{
    "BTC": 0.002339,
    "KZT": 46308.0,
    "USD": 100.0,
    "RUB": 9039.0
}
```

### Example 3
Request:  
`GET api/currency/exchange?from=KZT,RUB&to=USD,BTC`

Result:
```
{
    "BTC": 0.002339,
    "KZT": 46308.0,
    "USD": 100.0,
    "RUB": 9039.0
}
```




