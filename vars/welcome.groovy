/*
def call(name){
 echo "Hey ${name}, How are you ?"
}
*/
def call(jenkinsfile){
    pipeline {
        agent any
    
    }
    stages {
        stage('git checkout'){
            steps {
                git branch: 'main', credentialsId: 'git-credit', url: 'https://github.com/vemulanaveen44/jennkins-terraform.git'
            }
        }
        stage('init'){
            setps {
                ansiColor('xterm'){
                    sh 'terraform init'
                    
                }
                
            }
        }
    }
    
}
