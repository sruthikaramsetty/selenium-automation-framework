pipeline {
    agent any

    stages {
        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/testng-results.xml'
            archiveArtifacts artifacts: 'target/surefire-reports/emailable-report.html',
                             allowEmptyArchive: true

            echo 'Build completed'
        }
    }
}