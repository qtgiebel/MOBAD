## Week 01

Estimated time spent: 5 hours

Created the original MOBADictionary repository. Began work on the initial dictionary resource, as well as the team resume and team charter.
Began brainstorming ideas on how to implement our project.

## Week 02

Estimated time spent: 8 hours

Decided on using various AWS services to meet project goals. Finished with the team resume and team charter, and updated the readme.md to
reflect the decisions made thus far on the project. Began work on the AWS aspects of the project, including the DynamoDB table and the inital set up for
the necessary IAM roles, AWS Lambda functions, and API Gateway services.

## Week 03

Estimated time spent: 15 hours

Finished setting up the initial project requirements in AWS. Began work on the codebase for the project, referring to various AWS supplied articles to
assist in the creation of a starting MVP. Encountered issues with inital code and the implementation of the code in AWS Lambda. Encountered further issues
with implementing the necessary libraries for the project.

## Week 04

Estimated time spent: 15+ hours

Day - 1 : Created new repository for the project, this time implementing the provided AWS Toolkit. Using the Toolkit, we recreated the project using Java 11 Correto,
with dependencies for various other Amazon provided services. Refactored previous codebase multiple times in attempts to create a working application. Decided on
a fresh start with a new codebase, and were able to create a working project that correctly interacted with AWS Lambda, DynamoDB, and API Gateway. Got application
working with a test database, and eventually with the production database. Began work on implementing unit tests and extensive error handling, and were met 
with various issues related to working with a primarily remote application.

Day - 2 : We figured out how to properly utilize the dynamodb objects, and how to get the data through api gateway. Wrote tests that cover all parts of the code that are not redundant (already covered when passing through API Gateway and DynamoDB Scans). Finished up by adding Javadocs throughout the code,
and ensuring that code still ran.


