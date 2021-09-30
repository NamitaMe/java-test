pipeline {
    
    agent {
        dockerfile true
    }
    stages {
        stage('mvn-build') {
            //agent {
            //docker { image 'maven:3.3.3' }
        //}
            steps {
                echo 'builng '
                //sh 'mvn clean install'
                
            }
        }
        /*stage ('Build Docker Image'){
            steps {
                sh ' docker build -t namiducker/java-test:2.0.0 .'
            }
            
        }*/
    }
}
