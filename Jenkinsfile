pipeline {
    agent any  
    
    environment {
      DOCKER_CERT_PATH = credentials('docker_id')
    }
    stages {
        stage('build') {
            steps {
                echo ' testing build success. '
            }
        }
    }
}
