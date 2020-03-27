#include <stdio.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main()
{
    int file;
    file = open("content.txt", O_RDONLY);
    if (file == -1) {
        printf("open file failed, try to create a file");
        file = creat("content.txt", 0777);
        write(file, "Something Just Like This", 24);
    } 
    else
    {
        ssize_t ret;
        char buf[25];
        int len = sizeof(buf);
        ret = read(file, buf, len);
        write(1, "Finshed...\n", 12);
        write(1, buf, ret);    
    }
    close(file);
    return 0;
}
