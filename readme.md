# Book Manager App

### Intro

Simple full-stack application for managing books.

### Requirements

Running the application requires Java to be installed.

Development requires Java, Node, NPM, and Gradle to be installed. The included gradle wrapper should install the needed gradle version automatically.

### Running

#### 1. Jar

The first option and simplest is to run the build jar found in the build/libs directory.

1. Navigate to the build/libs directory
2. Run the command "java -jar bookmanager-1.0.0-SNAPSHOT.jar"
3. The application should now be available at localhost:8080

#### 2. Gradle wrapper

The second option is to run the application with the included gradle wrapper.

1. Navigate to the project root directory
2. Run the command "./gradlew run" (Linux) or "gradle.bat run" (Windows)
3. The application should now be available at localhost:8080 shortly

#### 3. Manual

If there are problems with the gradle wrapper option, the application can be manually started.

1. Go to the bookmanager/frontend directory (bookmanager represents the project root directory)
2. Run commands "npm install" and "npm run build"
3. Now copy all files and directories from bookmanager/frontend/dist to bookmanager/src/main/resources/static
4. Navigate back to the project root directory and run the command "./gradlew run" (Linux) or "gradle.bat run" (Windows)
5. If the above command does not work, try running gradle installed on the system instead: "gradle build"
6. Now navigate to bookmanager/build/libs folder and run the application itself: "java -jar bookmanager-1.0.0-SNAPSHOT.jar"
7. The application should now be available at localhost:8080
