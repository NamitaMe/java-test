pipeline {
    agent { dockerfile true }

    
    environment {
      DOCKER_CERT_PATH = credentials('docker_id')
    }
    stages {
        stage('build') {
            steps {
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
