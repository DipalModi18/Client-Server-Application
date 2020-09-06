// Server side C/C++ program to demonstrate Socket programming
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <fcntl.h>
#include <sys/types.h>
#include <string.h>
#define PORT 8081

int main(int argc, char const *argv[])
{
    int server_fd, client_fd, valread;
    int opt = 1, pid, status;
    struct sockaddr_in address;
    int addrlen = sizeof(address);
    char client_msg[1024] = {0}, cmd[64] = {0};
    char *hello = "Hello from server";
char file_content[1024];

    // Creating socket file descriptor
    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0)
    {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }

    // Forcefully attaching socket to the port 8080
    if (setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR | SO_REUSEPORT,
                                                  &opt, sizeof(opt)))
    {
        perror("setsockopt");
        exit(EXIT_FAILURE);
    }
    address.sin_family = AF_INET;
    address.sin_addr.s_addr = INADDR_ANY;
    address.sin_port = htons( PORT );

    // Forcefully attaching socket to the port 8080
    if (bind(server_fd, (struct sockaddr *)&address,
                                 sizeof(address))<0)
    {
        perror("bind failed");
        exit(EXIT_FAILURE);
    }
    if (listen(server_fd, 3) < 0)
    {
        perror("listen");
        exit(EXIT_FAILURE);
    }

	printf("Listening for a client...\n");
	if ((client_fd = accept(server_fd, (struct sockaddr *)&address, (socklen_t*)&addrlen))<0)
	{
		perror("accept");
		exit(EXIT_FAILURE);
	}
	printf("Accepted connection from client: %s\n", inet_ntoa(address.sin_addr));
	pid = fork();

	if(pid > 0) // Parent process
	{
		printf("Waiting for the child to finish the execution\n");
		wait(&status);
		printf("Parent process exiting\n");
	}
	else  // Child process
	{
		while(1)
		{
			valread = read(client_fd , cmd, 64);
			printf("\n\nReceived command: %s\n",cmd);
			// send(client_fd , client_msg , strlen(client_msg) , 0 );
			// printf("Command response sent\n");

			if(strcmp(cmd,"quit") == 0)
			{
				printf("Child process exiting\n");
				exit(0);  // Normal termination of child
			}
			else
			{
				char *delim = " ";
				char *base_cmd = strtok(cmd, delim);
				char *file_name = strtok(NULL, delim);
				printf("Decoding command: %s %s\n", base_cmd, file_name);
				if(strcmp(base_cmd, "get") == 0)
				{
					//int valread = read(sock, buffer, 1024);
					//printf("Got file content: %s\n", buffer);
					printf("sending file %s to the client\n", file_name);
					FILE *fp = fopen(file_name, "r");
					fgets(file_content, 1024, fp);
					//char file_content[1024] = "Temporary file content from the server";
					//read(fd, file_content, file_length);
					send(client_fd, file_content, strlen(file_content), 0);
				}
				else if(strcmp(base_cmd, "put") == 0)
				{
					printf("Uploading the file to the server\n");
					char file_content[1024];
					read(client_fd, file_content, 1024);
					printf("Got client_msg: %s", file_content);
				}
				else
				{
					printf("Invalid command entered\n");
				}
			}
		}
	}
    return 0;
}
