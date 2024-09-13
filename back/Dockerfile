FROM openjdk

RUN mkdir -p /opt/user/myapp

COPY lib/fastCGI.jar /opt/user/myapp/lib/fastCGI.jar
COPY src/ /opt/user/myapp/src/

WORKDIR /opt/user/myapp

RUN javac -cp lib/fastCGI.jar src/Main.java src/*.java

RUN echo "Main-Class: Main" > manifest.txt
RUN echo "Class-Path: lib/fastCGI.jar" >> manifest.txt

RUN jar -cvfm myapp.jar manifest.txt -C src/ . -C lib fastCGI.jar

EXPOSE 9000

CMD ["java", "-DFCGI_PORT=9000", "-jar", "myapp.jar"]
