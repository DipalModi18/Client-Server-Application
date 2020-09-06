// Client side C/C++ program to demonstrate Socket programming
#include <stdio.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <string.h>
#define PORT 8081
#define IP "127.0.0.1"

int main(int argc, char const *argv[])
{
	int sock = 0, valread;
	struct sockaddr_in serv_addr;
	char *hello = "Hello from client";
	char buffer[1024] = {0}, file_content[1024], cmd[64];

	if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0)
	{
		printf("\n Socket creation error \n");
		return -1;
	}

	serv_addr.sin_family = AF_INET;
	serv_addr.sin_port = htons(PORT);

	// Convert IPv4 and IPv6 addresses from text to binary form
	if(inet_pton(AF_INET, IP, &serv_addr.sin_addr)<=0)
	{
		printf("\nInvalid address/ Address not supported \n");
		return -1;
	}

	if (connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
	{
		perror("Failed\n");
		printf("\nConnection Failed \n");
		return -1;
	}

	while(1)
	{
		printf("Enter command for server: ");
		fgets(cmd, 50, stdin);
		int cmd_len = strlen(cmd);
		if(cmd[cmd_len - 1] == '\n')
			cmd[cmd_len - 1] = 0;
		send(sock, cmd, strlen(cmd), 0);
		printf("\nCommand sent to the server: %s\n", cmd);

		if(strcmp(cmd, "quit\n") == 0)
		{
			printf("Client is quitting...\n");
			break;
		}
		else
		{
			char *delim = " ";
			char *base_cmd = strtok(cmd, delim);
			char *file_name = strtok(NULL, delim);
			printf("Decoding command: %s %s\n", base_cmd, file_name);
			if(strcmp(base_cmd, "get") == 0)
			{
				printf("get is requested from the server\n");
				int valread = read(sock, buffer, 1024);
				printf("Got file content: %s\n", buffer);
			}
			else if(strcmp(base_cmd, "put") == 0)
			{
				printf("Uploading the file to the server\n");
				FILE *fp = fopen(file_name, "r");
				fgets(file_content, 1024, fp);
				//char file_content[1024] = "Temporary file content from the client";
				send(sock , file_content , strlen(file_content) , 0 );
				printf("Data sent to the server\n");
			}
			else
			{
				printf("Invalid command entered\n");
			}
		}
		printf("Command message sent to the server\n");
		//valread = read( sock , buffer, 1024);
		//printf("Server responded: %s\n",buffer );
		sleep(5);
	}
	return 0;
}

