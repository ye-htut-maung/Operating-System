#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    int pid = fork();

    printf("I'm process with pid(child1)= %d\n", pid);

    return 0;
}
