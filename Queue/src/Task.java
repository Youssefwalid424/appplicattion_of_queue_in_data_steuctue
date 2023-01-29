public class Task {
    private int id;
    private int time;
    private int arrivial_at;
    private int waiting;
    Task(int id ,int time,int arrivial_at ){ //this constructor recive id of tasks ,and time of every task and arrivial time
        this.arrivial_at=arrivial_at;
        this.id=id;
        this.time=time;

    }
    public int getId() {
        return id;
    }
    public int getTime() {
        return time;
    }
    public int getArrivial_at(){
        return arrivial_at;
    }
    public int getWaiting(){
       waiting= getTime()/1000- getArrivial_at();
        return waiting;
    }
}
