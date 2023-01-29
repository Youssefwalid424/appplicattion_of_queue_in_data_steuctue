

public class Main {

    public static void main(String[] args)  {
        boolean flag=false;
        int [] processes={1,2,3,4,5,6,7};
        int []time    ={9,8,10,11,14,16,11};
        int[] arrivial={0,0,2,4,7,9,10};
        int []burst_time={7,8,10,11,14,16,11};
        int n=processes.length;
        Machine m1 = new Machine(1), m2=new Machine(2) ; //declaration 2 computers-->m1 and m2
        Machine [] machines ={m1,m2}; // save
        MainQueue q = new MainQueue(machines); //declaration object  Mainqueue which take array of object of number of computers
        m1.setQ(q);
                 //    |-->let m1 and m2 contact with queue q
        m2.setQ(q);
        int i = 0 ;
        int j=2;
        time t1=new time();
        t1.findAverageTime(processes,n,burst_time,arrivial);
        int x[] ;
        x=t1.display();

        t1.findServiceTime(x);
        while (i<7){ //this loop for add number of tasks,time of tasks and arrivial time then add to queue
            Task t = new Task(i,time[i]*1000,arrivial[j]);
            q.add_update(t);
            j++;
            if (j==arrivial.length){j=0;}
            i++;

        }


      //  t1.findServiceTime();
    }
    }


