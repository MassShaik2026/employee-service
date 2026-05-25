pipeline{
    agent any
    tools{
        jdk 'java-8'
    }
    stages{
        stage('Clone') {

            steps {

                git branch: "${params.BRANCH_NAME.replace('origin/','')}",
                    credentialsId: 'github-creds',
                    url: 'https://github.com/MassShaik2026/employee-service.git'
            }
        }
        stage('Compile'){
            steps{
              bat 'mvn compile'
            }
        }
        stage('Test'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Build'){
            steps{
                bat 'mvn package'
            }
        }
          stage('Remove Docker Image'){
            steps{
                bat 'docker rm -f employee-service || exit 0'
            }
        }
        stage('Docker Build Image'){
            steps{
                bat 'docker build -t employee-service:%BUILD_NUMBER% .'
            }
        }
        stage('Docker Push And Run Container'){
            steps{
                 withCredentials([usernamePassword(
                    credentialsId: 'docker-hub-creds',
                    usernameVariable : 'DOCKER_USER',
                    passwordVariable : 'DOCKER_PWD'
                    )]){
                        bat 'docker login -u %DOCKER_USER% -p %DOCKER_PWD%'
                        bat 'docker tag employee-service:%BUILD_NUMBER% %DOCKER_USER%/employee-service:%BUILD_NUMBER%'
                        bat 'docker push %DOCKER_USER%/employee-service:%BUILD_NUMBER%'
                        bat 'docker run -d -p 8082:8080 --name employee-service %DOCKER_USER%/employee-service:%BUILD_NUMBER%'
                    }
            }
        }
        stage('Kubernetes Deploy'){
            steps{
                withCredentials([usernamePassword(
                    credentialsId: 'docker-hub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PWD')]){
                        bat 'kubectl set image deployment/employee-service employee-service=%DOCKER_USER%/employee-service:%BUILD_NUMBER%'
                    }
            }
        }
    }
}
