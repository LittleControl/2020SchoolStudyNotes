#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    pid_t pid;
    pid = fork();
    if (pid == -1)
    {
        perror("fork");
        exit(1);
    }
    else if (pid == 0)
    {
        close(1);
        int file = creat("list.txt", 0644);
        if (execlp("ls", "ls", "-l", NULL) < 0)
        {
            perror("exec");
            exit(1);
        }
    }
    else
    {
        wait(NULL);
        system("cat list.txt");
    }

    return 0;
}
