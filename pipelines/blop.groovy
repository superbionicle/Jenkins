@Library("jenkins-shared-libs") _

import src.logs

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