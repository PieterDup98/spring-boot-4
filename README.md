# spring-boot-4
Simple demo of new things in Spring boot 4

Test insert v1:

```shell
 curl -i   -X POST "http://localhost:8080/todo"   -H "API-Version: 1" --data-urlencode "description=Write tests"
```

Test insert v2, error:
```shell
 curl -i   -X POST "http://localhost:8080/todo"   -H "API-Version: 2" --data-urlencode "description=Write tests again"
```