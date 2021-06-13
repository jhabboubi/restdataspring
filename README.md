Rest Data Spring 
a simple project using spring boot.

objectives
- build a pipeline to dockerize Jenkins on port 8090 (host side) 
- using docker installed on the host machine
- creating a Free Style pipeline with the help of a few plugins to:
    - build an image of the project using docker
    - push image to docker hub 
    - run a docker container with the new image 
    
Instructions: 
- clone repository
- build the jenkins image with dockerfile available in `Instruction` folder
- open a terminal and go to cloned repository on you machine then to `Instructions` folder
- run `docker build -t dockertest .`  notice: the period at the end is part of the code   
- run `docker run -it -u root -p 8090:8080 -p 50000:50000 --name jenkins_container -v jenkins_home:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock --restart unless-stopped jenkins/jenkins:2.289.1-lts-jdk11`
- once the container runs for the first time a temporary password is printed in the logs
- open a browser and goto `localhost:8090` a greeting from jenkins asking for the temporary password
- Navigate to `Manage Jenkins > Manage Plugins > click tap Available > search for docker`
- install the list of plugins:
    - CloudBees Docker Build and Publish plugin
    - Docker Pipeline
    - Docker Plugins
    - Docker API Plugin (usually installed already)
    - Docker Commons Plugin (usually installed already)

Important step    
- open a terminal run `docker exec -it -u root jenkins_container bash`
- Now you are login as root for the container jenkins_container
- run `docker logout`
- run `docker login`
- enter docker hub credentials

- in jenkins navigate to `new item` > `Freestyle project`
- follow screenshot
[freestylejob](Instructions/job-restdataspring-configure.pdf)
  
* To add SonarQube
- run `docker network create jenkins`
- run `docker network connect jenkins {jenkins container name}`  
- run `docker run -d --network=jenkins -p 9000:9000 --name sonarqube -e SOANR_ES_BOOTSTRP_CHECK_DISABLE=true sonarqube`
after configuring sonar qube go to jenkins pipeline and add build step
`invoke top-level Maven target` goal `sonar:sonar -Dsonar.projectKey={projectname_in_sonar} -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login={TOKEN}`