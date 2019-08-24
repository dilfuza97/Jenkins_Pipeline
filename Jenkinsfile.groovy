node {
    stage("Say Hello"){
      properties([parameters([string(defaultValue: '34.247.30.115', description: '''Dev: 34.247.30.115 Qa: 34.240.9.133 Prod: 52.210.154.4''', name: 'Remote_instance', trim: true)])])
    }
    stage("Install Apache"){
       sh "ssh   ec2-user@${Remote_instances}    sudo yum install httpd -y"
   }
   stage("Create Index.html"){
       sh "scp  index.html  ec2-user@${Remote_instances}:/tmp"
   }
   stage("Move Files"){
       sh "ssh   ec2-user@${Remote_instances}    sudo mv /tmp/index.html  /var/www/html/index.html"
   }
   stage("Restart httpd"){
       sh "ssh   ec2-user@${Remote_instances} sudo systemctl restart  httpd"
   }
}
