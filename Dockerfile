FROM openjdk:17-jdk
WORKDIR /work/

COPY target/*.jar /work/CabinetdentistSpring-0.0.1-SNAPSHOT.jar



EXPOSE 8081
CMD ["java","-jar","CabinetdentistSpring-0.0.1-SNAPSHOT.jar"]



