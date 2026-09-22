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

            emailext(
                subject: "Selenium Test Report - ${currentBuild.currentResult}",
                body: """
                    <h2>Selenium Automation Test Report</h2>
                    <p>Build: ${env.BUILD_NUMBER}</p>
                    <p>Status: ${currentBuild.currentResult}</p>
                    <p>Please find the TestNG report attached.</p>
                """,
                to: "karamsettysruthi@gmail.com",
                attachmentsPattern: "target/surefire-reports/emailable-report.html"
            )
        }
    }
}