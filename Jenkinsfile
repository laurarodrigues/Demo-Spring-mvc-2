/* Requires the Docker Pipeline plugin */
/* Requires the Docker Pipeline plugin */
pipeline {
    agent any 

    environment {
        LOGIN_CREDS = credentials('DockerHub')
    }
    
    stages{
        stage('Init'){
            steps{
                echo "Build image"
                withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'DOCKERHUB_PASS', usernameVariable: 'DOCKERHUB_USER')]) {
                    sh 'docker login -u $DOCKERHUB_USER -p $DOCKERHUB_PASS'
                }
                
                sh 'docker build -t lauraped/bigstart-test:latest .'
                sh 'docker push lauraped/bigstart-test:latest'
                
            }
            
        }
        stage('Deployment'){
            //Mangel an Resourcen-> alte Deployments löschen und pods starten lassen
            steps{
                echo "This stage deploys the project"
                withCredentials([file(credentialsId: 'ca', variable: 'CA_CRT')]){
                     withCredentials([file(credentialsId: 'client', variable: 'CLIENT')]){
                          withCredentials([file(credentialsId: 'client_key', variable: 'CLIENT_KEY')]){
                               withCredentials([file(credentialsId: 'Kubeconfig', variable: 'KUBECONFIG_SECRET')]) {
                                sh  'echo $CA_CRT'
                                sh 'rm -f ./kubeconfig'
                                sh 'cp $KUBECONFIG_SECRET ./kubeconfig'
                                sh 'rm -f ./ca.crt'
                                sh 'cp $CA_CRT ./ca.crt'
                                sh 'rm -f ./client.crt'
                                sh 'cp $CLIENT ./client.crt'
                                sh 'rm -f ./client.key'
                                sh 'cp $CLIENT_KEY ./client.key'
                                sh 'kubectl delete deployment bigstart -n default --kubeconfig=./kubeconfig'
                                sh 'kubectl apply -f deployment-app.yaml --kubeconfig=./kubeconfig'
    // some block
                               }
                }
                } 
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