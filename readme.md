# Book Manager App

### Intro

Simple full stack application for managing books.

### Requirements

Running the application requires Java to be installed.

Devlopment requires Java, Node, NPM, and Gradle to be installed. The included gradle wrapper should install the required gradle version automatically.

### Running

#### 1. Built jar

The first option is to run simply run the built jar file using java in the build/libs directory.

1. Navigate to the build/libs directory
2. Run the command "java -jar bookmanager-1.0.0-SNAPSHOT.jar"
3. The application should now be available at localhost:8080 shortly

#### 2. Gradle wrapper

The second option is to run the application with the included gradle wrapper.

1. Navigate to the project root directory
2. Run the command "./gradlew run" (Linux) or "gradle.bat run" (Windows)
3. The application should now be available at localhost:8080 shortly

#### 3. Manual

In case there are problems with the gradle wrapper option, the application can be manually started.

1. Go to the bookmanager/frontend directory found at the root (bookmanager represents the project root)
2. Run commands "npm install" and "npm run build"
3. Now copy all files and directories from bookmanager/frontend/dist to bookmanager/src/main/resources/static
4. Navigate back to the project root directory
5. Run the command "./gradlew run" (Linux) or "gradle.bat run" (Windows)
6. If the above command does not work, try running gradle installed on the system: "gradle build"
7. Now run the application itself from the root directory using: "java -jar build/libs/bookmanager-1.0.0-SNAPSHOT.jar"
8. The application should now be available at localhost:8080 shortly
