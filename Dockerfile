FROM openjdk:11.0.11-jdk
WORKDIR /
RUN apt-get -y update
RUN apt-get -y install git
