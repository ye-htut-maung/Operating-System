#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    int pid = fork();
    printf("I'm process with pid = %d, "
    "Process ID (PID) = %d, "
    "Parent Process ID (PPID) = %d\n",
    pid, getpid(), getppid() );
    return 0;
}