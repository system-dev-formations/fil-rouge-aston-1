pipeline {
  agent any
  stages {
    stage('initial') {
      steps {
        git(url: 'https://github.com/system-dev-formations/fil-rouge-aston-1.git', branch: 'master')
        sh 'mvn clean install package'
      }
    }

  }
}