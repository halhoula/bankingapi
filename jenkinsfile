pipeline {
    agent any  // This will run the pipeline on any available agent

    triggers {
        pollSCM('* * * * *')  // Poll SCM every minute to check for changes
        cron('0 20 * * *')   // Run the job everyday at 8 PM
    }

    stages {
        stage('Checkout') {
            steps {
                // Check out from version control
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Use Maven to build and test
                sh 'mvn clean install'
            }
        }
    }

    post {
        failure {
            // Send email notification on failure
            mail to: 'amina.halhoul@gmail.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}
