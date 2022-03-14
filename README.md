# mPulsePractice

## End Point References

### Get a member for a given Account ID
**Request: GET**

localhost:8080/api/account/123123

**Response:**
```
{
    "id": 1,
    "firstName": "Esra",
    "lastName": "Yazar",
    "phoneNumber": "1234567890",
    "clientMemberId": 111111,
    "accountId": 123123
}
```

### Get a member by their ID
**Request: GET**

localhost:8080/api/client/1

**Response:**
```
{
    "id": 1,
    "firstName": "Esra",
    "lastName": "Yazar",
    "phoneNumber": "1234567890",
    "clientMemberId": 111111,
    "accountId": 123123
}
```

### Get a member by their Phone Number
**Request: GET**

localhost:8080/api/phone/1234567890

**Response:**
```
{
    "id": 1,
    "firstName": "Esra",
    "lastName": "Yazar",
    "phoneNumber": "1234567890",
    "clientMemberId": 111111,
    "accountId": 123123
}
```

### Get a member by their Client Member ID
**Request: GET**

localhost:8080/api/member/111111

**Response:**
```
{
    "id": 1,
    "firstName": "Esra",
    "lastName": "Yazar",
    "phoneNumber": "1234567890",
    "clientMemberId": 111111,
    "accountId": 123123
}
```

### Create a new Member
**Request: POST** to localhost:8080/api/new/member

Payload
```
{
   "firstName":"Yank",
	"lastName":"Deboo",
  "phoneNumber":"1284628753",
	"clientMemberId":"7228138",
	"accountId": "12"
}
```

**Response:**
```
{
    "id": 7,
    "firstName": "Yank",
    "lastName": "Deboo",
    "phoneNumber": "1284628753",
    "clientMemberId": 7228138,
    "accountId": 12
}
```

### Batch insert members by uploading a CSV (similar to the one provided)
**Request: POST** to localhost:8080/api/new/batch

Payload: Multipart file (csv)

**Response:**
int count (the record size of inserted row from cvs)
