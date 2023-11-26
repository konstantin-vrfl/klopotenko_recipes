## Recipes
#### GET: /klopotenko_recipes/api/recipes
Response sample:
```json
[
    {
        "id": 15,
        "name": "Кримськотатарські чібереки (чебуреки)",
        "url": "https://www.youtube.com/watch?v=YhCDGHlw7Po",
        "description": "Простий рецепт хрумких та соковитих кримськотатарських чібереків (чебуреків). Впевнений, більшість з вас їли саме такі десь на березі моря. Вдома вони вийдуть такими ж чудовими. Тісто на чебуреки зробимо заварне. З ним немає мороки, воно еластичне, добре зліплюється, а при обсмажених з’являються бульбашки. Також розкрию секрет соковитості начинки. Дивіться та готуйте, щоб думками перенестися в Крим.",
        "hot_dish": true,
        "vegetarian_dish": false,
        "cooking_time": null
    }
]
```
#### GET: /klopotenko_recipes/api/recipes/{id}
Response sample:
```json
{
  "id": 15,
  "name": "Кримськотатарські чібереки (чебуреки)",
  "url": "https://www.youtube.com/watch?v=YhCDGHlw7Po",
  "description": "Простий рецепт хрумких та соковитих кримськотатарських чібереків (чебуреків). Впевнений, більшість з вас їли саме такі десь на березі моря. Вдома вони вийдуть такими ж чудовими. Тісто на чебуреки зробимо заварне. З ним немає мороки, воно еластичне, добре зліплюється, а при обсмажених з’являються бульбашки. Також розкрию секрет соковитості начинки. Дивіться та готуйте, щоб думками перенестися в Крим.",
  "hot_dish": true,
  "vegetarian_dish": false,
  "cooking_time": null,
  "ingredients": [
    {
      "id": 2,
      "name": "борошно",
      "vegetarian": true,
      "measure": {
        "id": 2,
        "name": "грам"
      }
    },
    {
      "id": 3,
      "name": "сіль",
      "vegetarian": true,
      "measure": {
        "id": 3,
        "name": "чайна ложка"
      }
    },
    {
      "id": 4,
      "name": "соняшникова олія",
      "vegetarian": true,
      "measure": {
        "id": 4,
        "name": "столова ложка"
      }
    },
    {
      "id": 5,
      "name": "окріп",
      "vegetarian": true,
      "measure": {
        "id": 5,
        "name": "мілілітр"
      }
    },
    {
      "id": 6,
      "name": "цибуля",
      "vegetarian": true,
      "measure": {
        "id": 6,
        "name": "штука"
      }
    },
    {
      "id": 7,
      "name": "яловичина",
      "vegetarian": false,
      "measure": {
        "id": 2,
        "name": "грам"
      }
    },
    {
      "id": 8,
      "name": "вода",
      "vegetarian": true,
      "measure": {
        "id": 5,
        "name": "мілілітр"
      }
    },
    {
      "id": 9,
      "name": "чорний перець",
      "vegetarian": true,
      "measure": null
    }
  ]
}
```
#### POST: /klopotenko_recipes/api/recipes - TODO

#### PUT: /klopotenko_recipes/api/recipes - TODO

#### DELETE: /klopotenko_recipes/api/recipes/{id} - TODO

## Ingredients
#### GET: /klopotenko_recipes/api/ingredients
Response sample:
```json
[
    {
        "id": 2,
        "name": "борошно",
        "vegetarian": true,
        "measure": {
            "id": 2,
            "name": "грам"
        }
    },
    {
        "id": 3,
        "name": "сіль",
        "vegetarian": true,
        "measure": {
            "id": 3,
            "name": "чайна ложка"
        }
    },
    {
        "id": 4,
        "name": "соняшникова олія",
        "vegetarian": true,
        "measure": {
            "id": 4,
            "name": "столова ложка"
        }
    },
    {
        "id": 5,
        "name": "окріп",
        "vegetarian": true,
        "measure": {
            "id": 5,
            "name": "мілілітр"
        }
    },
    {
        "id": 6,
        "name": "цибуля",
        "vegetarian": true,
        "measure": {
            "id": 6,
            "name": "штука"
        }
    },
    {
        "id": 7,
        "name": "яловичина",
        "vegetarian": false,
        "measure": {
            "id": 2,
            "name": "грам"
        }
    },
    {
        "id": 8,
        "name": "вода",
        "vegetarian": true,
        "measure": {
            "id": 5,
            "name": "мілілітр"
        }
    },
    {
        "id": 9,
        "name": "чорний перець",
        "vegetarian": true,
        "measure": null
    }
]
```
#### GET: /klopotenko_recipes/api/ingredients/{id}
Response sample:
```json
{
    "id": 2,
    "name": "борошно",
    "vegetarian": true,
    "measure": {
        "id": 2,
        "name": "грам"
    }
}
```
#### POST: /klopotenko_recipes/api/ingredients
Request sample:
Header: Content-Type: application/json
```json
{
  "name": "цукор",
  "vegetarian": true,
  "measureId": 2
}
```
??? Вопрос на подумать: стоит ли изменить request-payload на:
```json
{
  "name": "цукор",
  "vegetarian": true,
  "measure": {
    "id": 2,
    "name": "грам"
  }
}
```
Response sample:
```json
{
    "id": 11,
    "name": "цукор",
    "vegetarian": true,
    "measure": {
        "id": 2,
        "name": "грам"
    }
}
```
#### PUT: /klopotenko_recipes/api/ingredients - TODO

#### DELETE: /klopotenko_recipes/api/ingredients/{id}
Response sample:
```text
Іngredient with ID = 11 was deleted
```
TODO: дописать 2й вариант ответа
(not found - при попытке удаления ингредиента с несуществующим id)

## Measures
#### GET: /klopotenko_recipes/api/measures
Response sample:
```json
[
    {
        "id": 2,
        "name": "грам"
    },
    {
        "id": 3,
        "name": "чайна ложка"
    },
    {
        "id": 4,
        "name": "столова ложка"
    },
    {
        "id": 5,
        "name": "мілілітр"
    },
    {
        "id": 6,
        "name": "штука"
    }
]
```
#### GET: /klopotenko_recipes/api/measures/{id}
Response sample:
```json
{
  "id": 2,
  "name": "грам"
}
```
#### POST: /klopotenko_recipes/api/measures
Request sample:</br>
Header: ```Content-Type: application/json```
```json
{
  "name": "test measure name"
}
```
Response sample:
```json
{
  "id": 13,
  "name": "test measure name"
}
```
#### DELETE: /klopotenko_recipes/api/measures/{id}
Response sample:
```text
Measure with ID = 13 was deleted
```
TODO: дописать 2й вариант ответа
(not found - при попытке удаления меры с несуществующим id)
