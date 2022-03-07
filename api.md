**Get all Merchants**
----
  Returns json data about all merchants

* **URL**

  /merchants/

* **Method:**

  `GET`
  
*  **URL Params**
  None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "id": 1,
        "name": "Amazon",
        "country": "USA",
        "websiteUrl": "https://www.amazon.com/",
        "platforms": "Online & In-store"
    },
    {
        "id": 2,
        "name": "Amc Theatres",
        "country": "USA",
        "websiteUrl": "https://www.amctheatres.com/",
        "platforms": "Online & In-store"
    },
    {
        "id": 3,
        "name": "Amazon",
        "country": "Canada",
        "websiteUrl": "https://www.amazon.ca/",
        "platforms": "Online & In-store"
    }
]`
 

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/merchants/",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```
  
**Get Merchants filtered by country**
----
  Returns json data about all merchants from a particular country

* **URL**

  /merchants/?country=USA

* **Method:**

  `GET`
  
*  **URL Params**
  None

* **Data Params**

  `country=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "id": 1,
        "name": "Amazon",
        "country": "USA",
        "websiteUrl": "https://www.amazon.com/",
        "platforms": "Online & In-store"
    },
    {
        "id": 2,
        "name": "Amc Theatres",
        "country": "USA",
        "websiteUrl": "https://www.amctheatres.com/",
        "platforms": "Online & In-store"
    }
]`
 

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/merchants/?country=USA",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```
  
**Get Merchants filtered by text (Search)**
----
  Returns json data about all merchants of a particular name or substr of a name

* **URL**

  /merchants/?name=am

* **Method:**

  `GET`
  
*  **URL Params**
  None

* **Data Params**

  `name=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "id": 1,
        "name": "Amazon",
        "country": "USA",
        "websiteUrl": "https://www.amazon.com/",
        "platforms": "Online & In-store"
    },
    {
        "id": 2,
        "name": "Amc Theatres",
        "country": "USA",
        "websiteUrl": "https://www.amctheatres.com/",
        "platforms": "Online & In-store"
    },
    {
        "id": 3,
        "name": "Amazon",
        "country": "Canada",
        "websiteUrl": "https://www.amazon.ca/",
        "platforms": "Online & In-store"
    }
]`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/merchants/?name=am",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```
 ----
  Returns json data about all merchants matching a name/substring of a name and a particular country

* **URL**

  /merchants/?name=amc&country=USA

* **Method:**

  `GET`
  
*  **URL Params**
  None

* **Data Params**

  `name=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "id": 2,
        "name": "Amc Theatres",
        "country": "USA",
        "websiteUrl": "https://www.amctheatres.com/",
        "platforms": "Online & In-store"
    }
]`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/merchants/?name=amc&country=USA",
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```
