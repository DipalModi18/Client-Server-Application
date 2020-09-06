* The multicast datagram socket class is useful for sending and receiving IP multicast packets. 
* A MulticastSocket is a (UDP) DatagramSocket, with additional capabilities for joining "groups" of other multicast hosts on the internet.
* A multicast group is specified by a class D IP address, those in the range 224.0.0.1 to 239.255.255.255, inclusive, and by a standard UDP port number. 
* When one sends a message to a multicast group, all subscribing recipients to that host and port receive the message