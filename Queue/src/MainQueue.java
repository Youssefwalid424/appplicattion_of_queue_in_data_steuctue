import java.util.LinkedList;
import java.util.Queue;

public class MainQueue {
    private Queue<Task> Q = new LinkedList<>(); // sign in report we use in  data structure queue type of linked list
    private Machine [] computers ;
    MainQueue(Machine [] computers){
        this.computers=computers;
    }
    public void add_update(Task t){
        System.out.println("I am added to queue now , client : " +t.getId());
            this.Q.add(t);
            for (Machine machine : computers) {//this loop for send task for computer which computer the state --> false(without task)
                if (!machine.getState()) { //fasle--> fady |true -->running
                    machine.setState(false);
                    break;
                }
            }
    }
    public Task remove_update() {
        return this.Q.isEmpty() ? null : this.Q.poll();
        // (poll)--> Retrieves, but does not remove, the head of this queue. This method differs from peek only in that it throws an exception if this queue is empty.
        //Returns:the head of this queue

    }

}
