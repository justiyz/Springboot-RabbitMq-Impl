# Springboot-RabbitMq-Impl

How to Implement RabbitMQ with Producer and Consumer Example

**How Install RabbitMQ on windows :**
- Download and install ERlang http://erlang.org/download/otp_win64_22.3.exe
- Downlaod and install RabbitMQ https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.8/rabbitmq-server-3.8.8.exe
- Go to RabbitMQ Server install Directory C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.3\sbin
- Run command rabbitmq-plugins enable rabbitmq_management
- Open browser and enter http://localhost:15672/ to redirect to RabbitMQ Dashboard
- Also we can Open it with IP Address http://127.0.0.1:15672
- Login page default username and password is guest
- After successfully login you should see RabbitMQ Home page





**How to install RabbitMq on Linux :**
Pre-Installation Task -> RabbitMQ has dependencies on the third-party package socat and logrotate. Before you install the RabbitMQ, run the rpm -qa|grep socat and rpm -qa|grep logrotate commands to check whether they have been installed on the server. If they have not been installed yet, you can choose either option below to install the dependencies:
- Online Install: run the yum -y install socat and yum -y install logrotate commands to install them online.
- Offline Install: refer to Offline Installing Third-party Dependencies for more details.


Installing RabbitMQ on Linux
1.Log in to the Linux server as the root user.

2.Run the mkdir command to create a directory under the /opt directory to place the installation package. For example, netbraintemp10.1.

3.Run the cd /opt/netbraintemp10.1 command to navigate to the /opt/netbraintemp10.1 directory.

4.Download the installation package.

▪Option 1: If the Linux server has no access to the Internet, obtain the rabbitmq-linux-x86_64-rhel-3.8.19-10.1.tar.gz file from NetBrain and then upload it to the /opt/netbraintemp10.1 directory by using a file transfer tool.  

▪Option 2: If the Linux server has access to the Internet, run the
wget <download link> command under the /opt/netbraintemp10.1 directory to directly download the rabbitmq-linux-x86_64-rhel-3.8.19-10.1.tar.gz file from NetBrain official download site.

Note: Contact NetBrain Support Team to get the download link. The download link is case-sensitive.

Tip: Run the yum -y install wget command to install the wget command if it has not been installed on the server.

5.Run the tar -zxvf rabbitmq-linux-x86_64-rhel-3.8.19-10.1.tar.gz command under the /opt/netbraintemp10.1 directory to extract installation files.

[root@localhost netbraintemp10.1]# tar -zxvf rabbitmq-linux-x86_64-rhel-3.8.19-10.1.tar.gz
rabbitmq/
rabbitmq/config/
rabbitmq/config/setup.conf
...
rabbitmq/install.sh
..

6.Run the cd rabbitmq/config command to navigate to the config directory.

7.Modify the parameters in the setup.conf file and save the changes. For how to modify the configuration file, refer to Editing a File with VI Editor.

[root@centos config]# vi setup.conf
#RabbitMQ configuration file
 
#Account info
#The UserName or Password should not contain: {}[]:",'|<>@&^%\ or a space
#The length of UserName or Password should not be more than 64 characters
UserName=admin 
Password=Admin1.# 
 
# Mode (Mode can only be 'mirror' or 'standalone')
Mode=standalone
 
# A unique cluster string is used to join all cluster nodes. Each cluster node must have the same cluster ID.
ClusterId=rabbitmqcluster
 
# The role of the current node in the cluster. One or two roles can be configured:
# master or slave. 
NodeRole=master
# Must specify a resolvable hostname of the master node in either standalone or mirror mode.
MasterNode=localhost 
 
# Resource limitation
ResourceLimit=no
 
# CPULimit and MemoryLimit should be ended by % and the range is from 1% to 100%
CPULimit=100%
MemoryLimit=100%
 
# TLS
UseSSL=no
Certificate=/etc/ssl/cert.pem
PrivateKey=/etc/ssl/key.pem
 
# Port --Please enter the same Port for all nodes that belong to the same cluster
Port=5672
 
# Log path
LogPath=/var/log/rabbitmq

8.Run the cd .. command to navigate to the rabbitmq directory.

9.Run the ./install.sh script under the rabbitmq directory to install RabbitMQ.

[root@localhost rabbitmq]# ./install.sh
INFO: Start checking date
INFO: Start checking os
INFO: Start checking required CPU
INFO: Start checking minimum memory
INFO: Selinux-policy version: 3.13.1
INFO: Component Name: RabbitMQ
INFO: RPM name: rabbitmq-server
INFO: Service name: rabbitmq-server
INFO: RPM package list: erlang-23.2.1-1.el7.x86_64.rpm rabbitmq-server-3.8.19-1.el7.noarch.rpm
INFO: Installation path: /usr/lib/rabbitmq/
INFO: Config path: /etc/rabbitmq/
INFO: Preprocessing SUCCEEDED
...
Preparing...                          ########################################
Updating / installing...
rabbitmq-server-3.8.19-1.el7           ########################################
INFO: Official rpm package installing SUCCEEDED
INFO: Configuration parameters updating SUCCEEDED
INFO: Permission setting SUCCEED
Created symlink from /etc/systemd/system/multi-user.target.wants/rabbitmq-server.service to 
/usr/lib/systemd/system/rabbitmq-server.service.
rabbitmq-server.service - RabbitMQ broker
   Loaded: loaded (/usr/lib/systemd/system/rabbitmq-server.service; enabled; vendor preset: disabled)
   Active: active (running) since Mon 2020-07-13 16:04:46 EDT; 8ms ago
 Main PID: 53927 (beam.smp)
   Status: "Initialized"
   Memory: 70.8M (limit: 15.5G)
...
INFO: Backing up uninstall.sh SUCCEEDED
INFO: Successfully installed RabbitMQ

10. Run the systemctl status rabbitmq-server command to verify whether its service starts successfully.

[root@localhost ~]# systemctl status rabbitmq-server
 rabbitmq-server.service - RabbitMQ broker
   Loaded: loaded (/usr/lib/systemd/system/rabbitmq-server.service; enabled; vendor preset: disabled)
   Active: active (running) since Mon 2020-07-13 16:05:23 EDT; 13min ago
   Process: 19522 ExecStop=/usr/sbin/rabbitmqctl shutdown (code=exited, status=0/SUCCESS)
 Main PID: 4509 (beam.smp)
   Status: "Initialized"
   Memory: 96.5M



