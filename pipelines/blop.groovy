@Library("jenkins-shared-libs") _

pipeline {
    agent any

    options {
        ansiColor('xterm')
    }

    stages {
        stage('Hello') {
            steps {
                script{
                    logs.info("Blop")
                    logs.warning("Blop")
                    logs.error("Blop")
                    logs.debug("Blop")
                    logs.system("Blop")
                }
            }
        }
    }
}