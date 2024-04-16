/* Requires the Docker Pipeline plugin */
pipeline {
    agent any 
    parameters{
        choice(name: 'ENVIRONMENT',
            choices: ['DEVELOPMENT', 'STAGING', 'PRODUCTION'],
            //defaultValue: 'DEVELOPMENT'
            )
            
        password(name: 'API_KEY',
            defaultValue: '123ABC')
            
        text(name: 'CHANGELOG',
            defaultValue: 'This is the changelog')
            
    }
    stages{
        stage('Init'){
            steps{
                echo "This stage tests the project"
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