import java.util.List;
import java.util.ArrayList;

public class TaskService {
    List<Task> taskList = new ArrayList();

    public Task saveTask(String title) {

        // assign unique id to new task
        int newTaskId = taskList.size() + 1;

        // create new task
        Task newTask = new Task(newTaskId, title);

        // add new task in list
        taskList.add(newTask);

        return newTask;
    }

    public Task getTask(int id) {

        for(Task task: taskList) {
            if(task.getId() == id) {
                return task;
            }
        }

        return null;
    }
}