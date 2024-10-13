#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    printf("Process ID(PID) of this process: %d, Parent Process ID(PID) of this process: %d\n", getpid(), getppid());
    return 0;
}