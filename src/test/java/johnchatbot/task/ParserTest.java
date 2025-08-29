package johnchatbot.task;

import johnchatbot.chatbot.Parser;
import johnchatbot.exception.ChatbotException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    TaskListStub taskList = new TaskListStub();
    Parser parser = new Parser(taskList);

    @Test
    public void todoTest(){
        parser.parse("todo thing");
        assertInstanceOf(ToDoTask.class, taskList.getTask());
    }

    @Test
    public void deadlineTest() {
        parser.parse("deadline thing /by 2018-09-22");
        assertInstanceOf(DeadlineTask.class, taskList.getTask());
    }
    
    @Test
    public void eventTest() {
        parser.parse("event thing /from 2025-08-27 1830 /to 2026-08-28 0000");
        assertInstanceOf(EventTask.class, taskList.getTask());
    }


}
