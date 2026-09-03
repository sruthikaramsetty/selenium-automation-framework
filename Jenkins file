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
            echo 'Build completed'
        }
    }
}