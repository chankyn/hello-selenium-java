#!/usr/bin/env groovy

pipeline {
    agent any
    environment {
        BROWSER = 'chrome'
    }
    stages {
        
        stage('Build') {
            steps {
                withGradle {
                    sh './gradlew assemble'
                }
            }
        }
        stage('Test') {
            steps {
                withGradle {
                    sh './gradlew -Dgeb.env=${BROWSER} clean test'
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
