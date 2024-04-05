# Book Manager App

### Requirements

Requires Java, Node and NPM to be installed. Gradle also needs to be installed but the included wrapper should download it automatically.

### Running

#### 1. Gradle

The first option is to run the application with the included Gradle wrapper. 

1. Navigate to the project root directory.
2. Run the command ./gradlew run (Linux) or gradle.bat run (Windows).
3. Wait for the build to finish. The application should now be available at localhost:8080.

#### 2. Manual

In case there are problems with the Gradle wrapper option, the application can be manually started.

1. Go to the bookmanager/frontend directory found at the root.
2. Run commands npm install and npm run build.
3. Copy all files in the bookmanager/frontend/dist directory to bookmanager/src/main/resources/static.
4. Navigate back to the project root directory.
5. Run the command ./gradlew run (Linux) or gradle.bat run (Windows).
6. If the above command does not work, try running Gradle installed on the system: gradle build.
7. Now run the application itself using java -jar build/libs/bookmanager-1.0.0-SNAPSHOT.jar. The application should now be available at localhost:8080.
