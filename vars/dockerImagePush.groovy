// def call(String project, String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//             credentialsId: "docker",
//             usernameVariable: "USER",
//             passwordVariable: "PASS"
//     )]) {
//         sh "docker login -u '$USER' -p '$PASS'"
//     }
//     sh "docker image push ${hubUser}/${project}:${ImageTag}"
//     sh "docker image push ${hubUser}/${project}:latest"   
// }

/*
def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
     aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}*/

def call(Map config){
    def user = config.user ?: error('user is required')
    def pass = config.pass ?: error('pass is required')
    def imageName = config.imageName ?: error('imageName is required')
    def tag = config.tag ?: error('tag is required')
    sh """
     docker login -u  ${user} -p  ${pass}
     docker push ${imageName}:${tag}
     docker rmi ${imageName}
    """
}
