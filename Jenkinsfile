#!/usr/bin/env groovy

pipeline {
    agent any
  
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
                    sh './gradlew -Dgeb.env=chrome clean test'
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
