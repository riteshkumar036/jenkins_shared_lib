def call(credentialsId){

    withSonarQubeEnv(credentialsId: credentialsId) {
         sh 'mvn clean package sonar:sonar'
    }
}

/* mvn clean verify sonar:sonar \
  -Dsonar.projectKey=k8-project \
  -Dsonar.host.url=http://13.233.141.61:9000 \
  -Dsonar.login=sqp_8b8c7330bcd7ad296c7d8a4db8bf993f90543625 */
