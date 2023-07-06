FROM openjdk:17-jdk
WORKDIR /work/

COPY pfa4-main/target/*.jar /work/CabinetdentistSpring-0.0.1-SNAPSHOT.jar



EXPOSE 8080
CMD ["java","-jar","CabinetdentistSpring-0.0.1-SNAPSHOT.jar"]