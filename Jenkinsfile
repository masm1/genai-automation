pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Run Tests in Parallel') {
                    parallel {
                        stage('Chrome Tests') {
                            steps {
                                sh 'mvn test -Dbrowser=chrome'
                            }
                        }
                        stage('Firefox Tests') {
                            steps {
                                sh 'mvn test -Dbrowser=firefox'
                            }
                        }
                    }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/surefire-reports/**'
            }
        }
    }
}
