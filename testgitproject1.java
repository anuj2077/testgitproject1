node {
  stage('SCM') {
    git 'https://github.com/anuj2077/testgitproject1'
  }


stage('Compile-Package'){
def mvnHome = tool name: 'maven-3', type: 'maven!
sh "${mvnHome}/bin/mvn package"
}



stage('SonarQube Analysis') {

def mvnHome tool name: 'maven-3', type: 'maven'

withSonarQubeEnv('sonar-6') {

sh "${mvnHome}/bin/mvn sonar:sonar"
}
}
class Simple{  
    public static void main(String args[]){  
     System.out.println("Hello Java");  
    }  
}  
