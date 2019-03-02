FROM openjdk:13-ea-9-jdk-alpine3.9
COPY target/classes /root
WORKDIR /root
CMD ["java", "Main"]
