// vars/customMap.groovy
/*
def call(Map config) {
    // Extract parameters
    def directory = config.directory ?: error('Directory is required')
    def mavenGoal = config.mavenGoal ?: 'clean install'

    // Define closure to execute within the directory context
    def stepsClosure = {
        // Change directory to the specified location
        dir(directory) {
            // Run Maven clean install
            sh "mvn ${mavenGoal}"
        }
    }

    // Execute the closure within the pipeline
    steps(stepsClosure)
}
*/

def call(Map config) {
    def directory = config.directory ?: error('Directory is required')
    def mavenGoal = config.mavenGoal ?: 'clean install'
    sh """
         cd ${directory}
         mvn ${mavenGoal}
        """
}
