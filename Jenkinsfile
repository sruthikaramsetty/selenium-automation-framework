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
            archiveArtifacts artifacts: 'target/surefire-reports/emailable-report.html',
                             allowEmptyArchive: false

            echo 'Build completed'
        }
    }
}