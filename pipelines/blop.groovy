@Library("jenkins-shared-libs") _

pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                logs.info("Blop")
                logs.warning("Blop")
                logs.error("Blop")
                logs.debug("Blop")
                logs.system("Blop")
            }
        }
    }
}