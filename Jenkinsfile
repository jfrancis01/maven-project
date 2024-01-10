pipeline {
    agent any

    parameters {
         string(name: 'tomcat_dev', defaultValue: '18.227.105.162', description: 'Staging Server')
    }

    triggers {
         pollSCM('* * * * *')
     }

stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        sh "scp -i **/target/*.war ec2-user@${params.tomcat_dev}:/opt/tomcat/apache-tomcat-9.0.83/webapps"
                    }
                }
            }
        }
    }
}