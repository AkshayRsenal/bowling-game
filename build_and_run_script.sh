#!/bin/bash


# Load environment variables from .env file
if [ -f .env ]; then
    echo "Loading environment variables from environment files..."
    export $(grep -v '^#' .env | xargs)
else
    echo ".env file not found!"
    exit 1
fi

# Run Maven commands
echo "Running mvn clean install..."
mvn clean install

# Get the name of the generated JAR file
JAR_FILE=$(ls target/*.jar | grep -v 'original' | head -n 1)

if [ ! -f "$JAR_FILE" ]; then
    echo "JAR file not found in target/!"
    exit 1
fi

echo "Running the JAR file..."

java -jar ${JAR_FILE} 

#--spring.profiles.active=prod
