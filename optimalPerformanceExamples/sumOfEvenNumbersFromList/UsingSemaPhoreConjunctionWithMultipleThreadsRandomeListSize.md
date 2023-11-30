- This approach uses the `Semaphore` to coordinate the completion of multiple threads.

- Multiple threads are created to compute the sum of even numbers in sublists of the generated list.

- Each thread computes the sum of even numbers in its assigned sublist.

- After completing its computation, each thread updates a `totalSum` variable which is synchronized for thread safety.

- The `Semaphore` is used to ensure that the main thread waits until all worker threads have finished their computations before printing the total sum of even numbers.

*This approach demonstrates an alternative way to utilize synchronization mechanisms like `Semaphore` for coordination among multiple threads while computing the sum of even numbers from a list. Adjust the `threadCount` variable based on the available resources or specific requirements.*