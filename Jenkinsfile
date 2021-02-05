#!/usr/bin/env groovy

pipeline {
    agent any
    environment {
        BROWSER = 'chrome'
    }
    stages {

        stage('Test') {
            steps {
                withGradle {
                    sh './gradlew -Pbrowser=${BROWSER} clean test'
                }
            }
            post {
                always {
                    junit 'build/test-results/test/TEST-*.xml'
                }
            }
        }
    }
}
