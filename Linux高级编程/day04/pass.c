#include <stdio.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main()
{
    int file;
    ssize_t ret;
    char buf[1024];
    int len = sizeof(buf);
    file = open("pass", O_RDONLY);
    if (file == -1) {
        write(1, "open failed, try to create\n", 28);
        close(file);
        file = creat("pass", 0777);
        int newFile;
        newFile = open("/etc/passwd", O_RDONLY);
        while ((ret = read(newFile, buf, len)) > 0)
        {
            write(file, buf, ret);
        }
        write(1, "Finished...\n", 13);
        close(newFile);
    } 
    else
    {
        write(1, "open successfully\n", 19);
        while ((ret = read(file ,buf, len)) > 0) 
        {
            write(1, buf, ret);
        }
    }
    close(file);
    return 0;
}
