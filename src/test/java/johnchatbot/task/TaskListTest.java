package johnchatbot.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    @Test
    public void addTest(){
        TaskList taskList = new TaskList();
        taskList.add(new TaskStub());
        taskList.add(new TaskStub());
        assertEquals(2,taskList.size());
    }

    @Test
    public void deleteTest(){
        TaskList taskList = new TaskList();
        taskList.add(new TaskStub());
        taskList.add(new TaskStub());
        taskList.delete(0);
        assertEquals(1,taskList.size());
    }



}
