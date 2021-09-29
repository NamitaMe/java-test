pipeline {
    agent {
        docker { image 'openjdk:8-jdk-alpine'}
    } //{ dockerfile true }
   
        
    tools{
        maven 'maven.3.8.2' 
        jdk 'jdk.9.0.4' 
        
    }
    
    /*environment {
      DOCKER_CERT_PATH = credentials('docker_id')
    }*/
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
                sh 'mvn -Dmaven.test.failure.ignore=true clean install'
       
                sh 'ls -l ./target'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true 
                echo ' testing build success. '
                echo " Build Id :, ${env.BUILD_ID} "
            }
        }
        stage('Sanity check') {
            steps {
                input "Does the staging environment look ok?"
            }
        }
        
        stage('test') {
            steps {
                echo ' testing success.******* '
            }
        }
        stage('Deploy') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                echo 'Finally in deploy stage'
            }
        }
    }
    post {
        always {
            echo 'One way or another, I have finished'
            //deleteDir()
        }
        success {
            echo 'I succeeded!'
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }
    }
}
