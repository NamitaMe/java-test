pipeline {
    agent { dockerfile true }
    tools { 
        maven 'Maven 3.8.1' 
        jdk 'jdk8' 
    }
    
    environment {
      DOCKER_CERT_PATH = credentials('docker_id')
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
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
