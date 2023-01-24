#!/bin/sh
echo 'hello there'
sudo yum install java-17-amazon-corretto-devel -y
sudo wget https://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven
sudo yum install git -y
cd home/ec2-user
git clone https://github.com/ol-8/aws-dynamo-test.git
cd aws-dynamo-test
mvn clean package
