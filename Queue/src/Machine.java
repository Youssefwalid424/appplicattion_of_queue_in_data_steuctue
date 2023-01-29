import java.util.Timer;
import java.util.TimerTask;

public class Machine {
    boolean state = false ;
  public  int id ,waiting_time_for_each_task;
    MainQueue q = null;
    Task currTask = null;
    Machine(int id ){
        this.id = id ;
    }
    public boolean getState(){
        return this.state;
    }
    public void setQ(MainQueue q) {
        this.q = q;
    }

    public void setState(boolean state) { // true --> run and do task , false --> stop tell all
            this.state = state;
            if (!state)
                notifyAllObservers();

            else

                running();

        }
    public void notifyAllObservers(){//remove task from queue and
            currTask=null;
                Task t = q.remove_update();
                if (t != null) {
                    this.currTask = t;

                    setState(true);


                }
    }

int x;int sum,average;
    public void running() {

if (currTask.getId()==0| currTask.getId()==1){waiting_time_for_each_task=0;}
        System.out.println("I am added to computer("+this.id+")"+" now , client : " +currTask.getId()+" service time : "+currTask.getTime()/1000+"  sec , "+" waitng: "+waiting_time_for_each_task +" sec ");
        int time = this.currTask.getTime();
         waiting_time_for_each_task+=currTask.getTime()/1000-currTask.getArrivial_at();

        Timer timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {

                        setState(false);
                    }
                }, time);
    }



}
