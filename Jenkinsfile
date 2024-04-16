/* Requires the Docker Pipeline plugin */
pipeline {
    agent any 
    
    stages{
        stage('Init'){
            steps{
                echo "Build image"
                sh 'docker build -t lauraped/bigstart-test:latest .'
                
            }
            
        }
        stage('Compile'){
            when { expression {params.ENVIRONMENT == "PRODUCTION"} }
            steps{
                echo "This stage deploys the project"
            }
            
        }
        stage('Test'){
            steps{
                echo "This stage reports the project"
                sh "printf \"${params.CHANGELOG}\" > ${params.ENVIRONMENT}.txt"
                archiveArtifacts allowEmptyArchive: true,
                    artifacts: '*.txt',
                    fingerprint: true,
                    followSymlinks: false,
                    onlyIfSuccessful: true
                
            }
            
        }
        stage('Upload to Artifactory'){
            steps{
               echo "Upload to Artifactory"
            }
        }   
    }
              
}