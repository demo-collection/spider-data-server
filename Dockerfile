FROM java:8

VOLUME /home/vagrant/labs/tmp/

ADD spider-0.0.1.jar app.jar
RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]