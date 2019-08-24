node {
    stage("Say Hello"){
        properties([parameters([string(defaultValue: '34.253.214.183', description: '''Dev: 34.253.214.183 Qa: 34.254.184.67 Prod: 34.253.225.101''', name: 'Remote_instance', trim: true)])])
        git 'https://github.com/dilfuza97/jenkins_html.git'
    }
    stage("Install Apache"){
        sh "ssh ec2-user@${Remote_instance}  sudo yum install httpd -y"
    }
}
