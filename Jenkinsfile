/* Requires the Docker Pipeline plugin */
pipeline {
    agent any 
    
    stages{
        stage('Init'){
            steps{
                echo "Build image"
                sh 'docker login -u lauraped -p Holita69!'
                sh 'docker build -t lauraped/bigstart-test:latest .'
                sh 'docker push lauraped/bigstart-test:latest'
                
            }
            
        }
        stage('Deployment'){
            //Mangel an Resourcen-> alte Deployments löschen und pods starten lassen
            steps{
                echo "This stage deploys the project"
                withCredentials([file(credentialsId: 'Kubeconfig', variable: 'KUBECONFIG')]) {
                    sh 'kubectl delete deployment bigstart -n default'
                    sh 'kubectl apply -f deployment-app.yaml'
    // some block
                }
                
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