# Попытка docker
# usefull
# docker image build . -t test
# container run test
# docker container run -it  --shm-size=1024m test bash
# docker image ls

# Запуск gui приложений в docker
# https://dev-ops-notes.ru/docker/%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D0%BA-gui-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D0%B9-%D0%B2-docker/
# В общем получается надо ставить socat и X11 сервер, идея так себе...

# FROM maven:3-jdk-8
FROM debian:jessie

# грят это надо
RUN apt-get update
RUN apt-get install -y xvfb

# Install Java
# https://stackoverflow.com/questions/48301257/how-to-install-oracle-java8-installer-on-docker-debianjessie
ENV JAVA_VERSION 1.8.0

RUN echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" > /etc/apt/sources.list.d/webupd8team-java.list
RUN echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" >> /etc/apt/sources.list.d/webupd8team-java.list
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys EEA14886
RUN echo "debconf shared/accepted-oracle-license-v1-1 select true" | /usr/bin/debconf-set-selections
RUN apt-get update
RUN apt-get install -y --force-yes vim
RUN apt-get install -y --force-yes less
RUN apt-get install -y --force-yes oracle-java8-installer

# Install Maven
RUN apt-get install -y maven

# Install firefox
RUN apt-get install -y firefox-esr

# CMD ["/bin/echo", "hello world 1"]

# Get a clean build immediately after and 'go-offline' to improve subsequent builds
RUN mkdir /usr/src/testng
COPY src /usr/src/testng/src
COPY pom.xml /usr/src/testng/pom.xml
RUN cd /usr/src/testng && mvn dependency:go-offline
#WORKDIR /usr/src/testng/

# Additional support files that needed but not for the build
#COPY supportfiles /usr/src/testng/supportfiles

# Хм
# You need to export the display in the shell that selenium server is running in otherwise it will not be able to open the browser.
# RUN nohup sudo Xvfb: 10 - ac &
# RUN export DISPLAY=10

RUN export DISPLAY=:99
# /usr/bin/xvfb-run /opt/tomcat-latest/bin/startup.sh
RUN /usr/bin/Xvfb :99 &
RUN /usr/bin/xvfb-run "mvn test"

# CMD [ "mvn test" ]