#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

void* task() {
    printf("Print from threads\n");
    return NULL;
}

int main(int argc, char* argv[]) {
    pthread_t t1;
    pthread_create(&t1, NULL, &task, NULL);
    pthread_join(t1, NULL);
    return 0;
}