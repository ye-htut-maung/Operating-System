#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <sys/wait.h>

int main() {

    int pid1 = fork();
    if (pid1 > 0) wait(NULL);
    int pid2 = fork();
    if(pid2 > 0) wait(NULL);
    printf("Process with PID = %d and PPID = %d \n", getpid(), getppid());

    return 0;
}