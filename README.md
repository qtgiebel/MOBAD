# MOBADictionary

## Problem Statement
Communicating in MOBA(**M**ultiplayer **O**nline **B**attle **A**rena) video games can be confusing to new players due to vocabulary specific to this genre. Our objective is to create an API that can be accessed by players to help them better understand MOBA vocabulary. 

## Resources
Our API will return dictionary resources that contain attributes/information such as the keyword, definition, and game. The returned data will be in JSON format.

## Operations
Our API operations will include getAllDefinitions, getByGame, and getByKeyword
- GET /definitions/{keyword}
- GET /definitions
- GET /definitions/games/{title}

## Tech Stack
- IntelliJ IDEA
- AWS Lambda
- DynamoDB
- Amazon API Gateway
- SAM CLI
- Java11 (Coretto)
- Maven
- Docker
