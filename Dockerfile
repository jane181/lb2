FROM openjdk:15
WORKDIR /app/
COPY ./* ./
ENV CLASSPATH="./antlr-4.9.3-complete.jar:$CLASSPATH"
RUN javac main.java
