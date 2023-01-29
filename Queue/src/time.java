public class time {
    private int processes[];
    private int n;  //array_size
    private int bt[]; //burst_time
    private int wt[];  //waiting_time
    private int tat[]; //turnaround_time
    private int arrive[];  //arrival_time
    private double total_wt=0; //total_waitingTime
    int arr[]=new int[7];
    public void findWaitingTime(int processes[],int n,int bt[],int arrive[]) {
        this.processes=processes;
        this.arrive=arrive;
        this.bt=bt;
        this.wt=wt;
        wt[0]=0;
        // waiting time for first process will be 0
        // calculating waiting time
        for (int i = 1; i < n ; i++)
        {
            tat[i] = (bt[i]+bt[i-1])-arrive[i];
            wt[i] = tat[i]-bt[i];
            arr[i]=wt[i];
        }
    }
    public int[] display(){
        return arr;
    }
    public void findServiceTime(int arr[]){
        for(int i=0;i<7;i++) {
            System.out.println("The service is:" +(arr[i]*(Math.exp(-arr[i]))));}}
    public void findTurnaroundTime(int processes[],int n,int bt[],int wt[],int tat[]) {
        this.processes=processes;
        this.bt=bt;
        this.wt=wt;
        this.tat=tat;
        for (int i = 0; i < n ; i++)   // calculating turnaround time by adding
        // bt[i] + wt[i]
        {
            tat[i] = bt[i] + wt[i];
        }
    }
    public void findAverageTime(int processes[],int n,int bt[],int arrive[]) {
        this.arrive=arrive;
        wt=new int[n];
        tat=new int[n];
        this.processes=processes;
        this.bt=bt;
        findWaitingTime(processes,n,bt,arrive);  //find waiting_time
        findTurnaroundTime(processes, n, bt, wt, tat);  //find turnaround_time
        System.out.println("Processes\t ArrivalTime\t BurstTime\t WaitingTime\t TurnaroundTime");
        for(int i=0;i<n;i++) {
            System.out.println(processes[i]+"\t\t\t\t"+" "+arrive[i]+"\t\t\t\t"+" "+bt[i]+"\t\t\t\t"+" "+wt[i]+"\t\t\t\t"+" "+tat[i]);
        }
        for(int i=0;i<n;i++) {
            total_wt=total_wt+wt[i];
        }
        System.out.println("Average_WaitingTime:" +total_wt/n);
    }

}
