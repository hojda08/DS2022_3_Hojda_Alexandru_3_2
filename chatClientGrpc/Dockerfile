FROM openjdk:11-jdk

# Install Maven and Xvfb
RUN apt-get update && apt-get install -y maven xvfb

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml file into the container at /app
COPY pom.xml .

# Run Maven to download dependencies
RUN mvn dependency:resolve

# Copy the rest of the application code into the container at /app
COPY . .

# Compile the application
RUN mvn package

# Expose the VNC port and the port that the application will listen on
EXPOSE 5901 9090

# Start the Xvfb server
CMD ["Xvfb", ":1", "-screen", "0", "1024x768x24"]

# Start the VNC server and the application
CMD ["x11vnc", "-display", ":1", "-forever", "-shared", "-rfbport", "5901"]

# Start the application
CMD ["java", "-jar", "target/chatClientGrpc-1.0-SNAPSHOT.jar"]