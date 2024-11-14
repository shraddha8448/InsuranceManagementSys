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
                sh 'ssh ubuntu@51.20.56.66  "cd app/ && mvn clean package -DskipTests"'
            }
        }


        stage('Deploy') {
            steps {
                script {
                    // Copy the built jar file to the remote EC2 instance
                    sh 'ssh ubuntu@51.20.56.66  "cd app/ && java -jar target/InsuranceManagementSystem-0.0.1-SNAPSHOT.jar"'
                }
            }
        }
    }

}
