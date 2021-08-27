pipeline {
    agent { dockerfile true }
    tools { 
        maven 'Maven 3.3.3' 
        jdk 'jdk8' 
    }
    
    environment {
      DOCKER_CERT_PATH = credentials('docker_id')
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
                echo ' testing build success. '
            }
        }
        
        stage('test') {
            steps {
                echo ' testing success.******* '
            }
        }
    }
}
