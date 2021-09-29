pipeline {
    
    agent {
        docker { image 'maven:3.3.3' }
    }
    stages {
        stage('mvn-build') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean install'
                
            }
        }
        stage ('Build Docker Image'){
            sh ' docker build -t namiducker/java-test:2.0.0 .'
            
        }
    }
}
