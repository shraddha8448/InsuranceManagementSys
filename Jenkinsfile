// pipeline {
//     agent any
// stages {
//         stage('Checkout') {
//             steps {
//                 // Check out the code from the Git repository
//                 git url: 'https://github.com/shraddha8448/InsuranceManagementSys.git', branch: 'master'
//             }
//         }

//         stage('Build') {
//             steps {
//                 // Clean and build the project using Maven
//                 sh 'ssh -o StrictHostKeyChecking=no ubuntu@13.61.105.46  "cd app && mvn clean package -DskipTests"'
//             }
//         }


//         stage('Deploy') {
//             steps {
//                 script {
//                     // Copy the built jar file to the remote EC2 instance
//                     sh 'ssh -o StrictHostKeyChecking=no ubuntu@13.61.105.46  "cd app && java -jar target/InsuranceManagementSystem-0.0.1-SNAPSHOT.jar"'
//                 }
//             }
//         }
//     }
//     post {
//     success {
//         echo 'Deployment succeeded!'
//     }
//     failure {
//         echo 'Deployment failed!'
//     }
// }
// }

pipeline {
    agent any

    stages {
        stage('git pull') {
            steps {
              git branch: 'master', url: 'https://github.com/shraddha8448/InsuranceManagementSys.git'
            }
        }
        stage('mvn-clean'){
            steps{
                // Clean and build the project using Maven
                 sh 'ssh -o StrictHostKeyChecking=no ubuntu@13.61.105.46  "cd app && mvn clean package -DskipTests
            }
        }
        stage('copy'){
            steps{
                script{
                 sh """
                    scp -o StrictHostKeyChecking=no $WORKSPACE/target/InsuranceManagementSystem-0.0.1-SNAPSHOT.jar ubuntu@13.61.105.46:/home/ubuntu/app/target/
                  """
                }
                
    
            }
        }
        stage('restart'){
            steps{
             
            script{
                 sh """ssh ubuntu@13.61.105.46 'sudo systemctl restart spring.service' """
                  }
        }
        }
        
        stage('status'){
            steps{
                script{
                      sh """ssh ubuntu@13.61.105.46 'sudo systemctl status spring.service' """
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
