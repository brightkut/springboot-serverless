# Spring Boot Serverless

You can follow this instruction for implement and deploy to AWS Lambda:  

(1) https://docs.aws.amazon.com/lambda/latest/dg/java-package.html#java-package-maven

(2) https://github.com/aws/serverless-java-container/wiki/Quick-start---Spring-Boot3


AWS DynamoDB section we implement by using `DynamoDBMapper` instead of `DynamoDbClient`, 
because `DynamoDBMapper` is easier to implment and work like `JPA` but performance is not good than `DynamoDbClient` but it is hard for implemented.