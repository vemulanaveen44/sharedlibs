/*
def call(name){
 echo "Hey ${name}, How are you ?"
}
*/
pipeline {
    agent any
    tools {
        terraform 'terraform'
    }
    stages {
        stage('git checkout'){
            steps {
                git branch: 'main', credentialsId: 'git-credit', url: 'https://github.com/vemulanaveen44/jennkins-terraform.git'
            }
        }
        stage('init'){
            steps {
                ansiColor('xterm') {
                     sh 'terraform init'
                }
                
            }
        }
        stage('plan') {
            steps {
                ansiColor('xterm') {
            
                    sh 'terraform plan'
                }
                
           }
        }
        stage('Approval') {
      steps {
        script {
          def userInput = input(id: 'confirm', message: 'Apply Terraform?', parameters: [ [$class: 'BooleanParameterDefinition', defaultValue: false, description: 'Apply terraform', name: 'confirm'] ])
        }
      }
    }
        
        stage('apply') {
            steps {
                ansiColor('xterm') {
                    sh 'terraform apply -auto-approve'
                }
                
            }
        }
        
    }
}
