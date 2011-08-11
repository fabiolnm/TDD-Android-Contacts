To enable local networking during development tests, it's necessary to push a custom hosts file to the emulator.

1) Emulator must be started with partition-size parameter (resolve out of memory error on adb push command) 

	emulator -avd youravdname -partition-size 128
	
2) Emulator filesystem must be remounted (resolve read-only filesystem errors on adb push)

	adb remount
	
3) Create a custom hosts-file
	
	127.0.0.1	localhost
	10.0.2.2	m.concretesolutions.com.br
	
4) Push it to the emulator
	
	adb push my_custom_hosts_file /system/etc/hosts
	
5) Verify:
	
	adb -s emulator-5554 shell cat /etc/hosts

6) Local fake server runs on tomcat port 8080:
	
		http://localhost:8080/extranet/contact/list

	So it's necessary to configure a iptables rule to serve on port 80:

		sudo iptables -t nat -A OUTPUT -d localhost -p tcp --dport 80 -j REDIRECT --to-ports 8080
	
	Now test url without port number
	 
		http://localhost/extranet/contact/list