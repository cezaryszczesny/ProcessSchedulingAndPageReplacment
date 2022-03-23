# Process scheduling and page replacment algorithms

I've made this project for my classes at my University of Science and Technology.
<br />
Program implements and compares two of process scheduling(FCFS, SJF) and two of page replacment(FIFO, LRU) algorithms. 
It also generates all processes needed for tests and save results in CSV file.
<br />
FCFS sorts processes by their arrival time. SJF makes the same as FCFS, but also checks if some process cannot execute faster, even though they came later.
They are very common algorithms not only used in Computer Science but also in real life, for example queues for a table in restaurant/tickets etc.
<br />
Processes are described by two parameters: Execution time, Arrival time and flag(information if procces was executed or not) for this task I used 3D table.
Compared parameters are Turn around time and Average waiting time.
I tested this algorithms on 100 strings and in every string were 100 processes.
<br />
<br />
Page replacment algorithm were tested within 3,5 and 7 frames, but it can be easily changed in the program because the method can calculate it for any amout of frames.
<br />
FIFO drops process which came firstly. LRU drops process which was recently used. Compared parameter was page faults.
<br />
I also tested this program on 100 string where in every string were 100 processes.

