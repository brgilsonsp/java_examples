FROM openjdk:11

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac ./src/main/java/br/com/learning/gilson/regex/AppMain.java

CMD ["java", "./src/main/java/br/com/learning/gilson/regex/AppMain.java"]