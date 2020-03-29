#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main()
{
    pid_t pid;
    pid = fork();
    if (pid == -1)
    {
        perro("fork");
        exit(EXIT_FAILURE);
    }
    else if (pid == 0)
    {
        char *argv[] = {"code", NULL};
        printf("Will start code");
        execvp("code", argv);
    }
    else
    {
        int p_return;
        int stat;
        p_return = wait(&stat);
        printf("child's status is %d", p_return);
        printf("child's pid is %d", pid);
    }

    return 0;
}
