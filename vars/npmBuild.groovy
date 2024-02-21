def call(Map config) {
    def directory = config.directory ?: error('Directory is required')
    sh """
         cd ${directory}
         npm i
         npm run build
        """
}
