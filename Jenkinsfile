pipeline {
    agent any
stages {
        stage('Checkout') {
            steps {
                // Check out the code from the Git repository
                git url: 'https://github.com/shraddha8448/InsuranceManagementSys.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                // Clean and build the project using Maven
                sh 'ssh -o StrictHostKeyChecking=no ubuntu@13.61.105.46  "cd app && mvn clean package -DskipTests"'
            }
        }
    stage('Deploy') {
            steps {
                script {
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@13.61.105.46 "cd app && nohup java -jar target/InsuranceManagementSystem-0.0.1-SNAPSHOT.jar > app.log 2>&1 &"'
                    sleep 10 // wait for application to start
                }
            }
        }
        
        stage('Health Check') {
            steps {
                script {
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@13.61.105.46 "curl -sSf http://localhost:8082 || exit 1"'
                }
            }
        }
    }
    post {
    success {
        echo 'Deployment succeeded!'
    }
    failure {
        echo 'Deployment failed!'
    }
}
}
