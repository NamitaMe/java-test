def dockerRun ='docker run -p 8080:8080 -d --name java-test namiducker/java-test:2.0.0 .'
pipeline {
    
    agent any //{
        //dockerfile true
    //}
    environment {
		DOCKERHUB_CREDENTIALS=credentials('dockerhub-cred')
	}
    stages {
        stage('mvn-build') {
            //agent {
            //docker { image 'maven:3.3.3' }
        //}
            steps {
                
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                echo "Workspace is ${env.WORKSPACE} and build_url is ${env.BUILD_URL}"
                //sh 'mvn clean install'
                
            }
        }
        stage ('Build Docker Image'){
            steps {
                sh 'docker build -t namiducker/java-test:2.0.0 .'
            }
            
        }
         stage ('Push Docker Image'){
            
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                //withCredentials([usernameColonPassword(credentialsId: 'duckerhub-cred', variable: 'dockerhub-pass')]) {
                    //sh "docker login -u namiducker -p ${dockerhub-pass}"
                //}
                docker.withRegistry('https://hub.docker.com', 'duckerhub-cred') {
                 sh 'docker push namiducker/java-test:2.0.0'
                }
         }


       
            
        }
        
    }
}

