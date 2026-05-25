@Library("jenkins-shared-libs") _

pipeline {
    agent any

    options {
        ansiColor('xterm')
        disableResume()
        quietPeriod(0)
    }

    stages {
        stage('Hello') {
            steps {
                quiety {
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
}