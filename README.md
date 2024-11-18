# Assignment-1
![API System Diagram](https://github.com/<bagelsfordagels>/Assignment1/blob/main/<path to image
file>/UpdatedApiSystemDiagram?raw=true)

System Diagram - There are 4 components, the user, the data storage system, the load compute engine, and the compute engine itself. The user inputs data into the data storage system and the load compute engine. The load compute engine feeds the data to the compute engine. The compute engine then creates and organizes the data and returns it to the load compute engine. The load compute engine then gives the sorted data to the data storage system. The data storage system then returns the sorted data to the user.  

Computation - The user provides an integer and an array is created with the user inputted integer as the length. The Array is then populated with random letters and is sorted in the compute engine. 

BenchMarkTest:
Original - 18
New - 4
BenchmarkIntegrationTest - https://github.com/bagelsfordagels/Assignment-1/blob/main/test/BenchmarkIntegrationTest.java
DSSBenchmarkTest - https://github.com/bagelsfordagels/Assignment-1/blob/main/test/DSSBenchmarkTest.java
The mkArr method in the DataStorageSystem was writing each array to the file character by character causing it to be slow. changed the method to instead use the valueOf() method to covert the entire array into a string all at once to be added to the file faster.
