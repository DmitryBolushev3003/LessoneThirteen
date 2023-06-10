import Obdjects.Epic;
import Obdjects.Meeting;
import Obdjects.SimpleTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void SimpleTaskTrueTest() {
        SimpleTask simpleTask = new SimpleTask(1, "Записаться на тренировку");
        boolean actual = simpleTask.matches("Записаться");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void SimpleTaskFalseTest() {
        SimpleTask simpleTask = new SimpleTask(2, "Записаться на тренировку");
        boolean actual = simpleTask.matches("записаться");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void EpicFalseTest() {
        String[] subtusks = {"Пробежать 5 км", "Отжаться 3 раза", "Приседать 700 раз"};
        Epic epic = new Epic(3, subtusks);
        boolean actual = epic.matches("Подтянуться");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void EpicTrueTest() {
        String[] subtusks = {"Пробежать 5 км", "Отжаться 3 раза", "Приседать 700 раз"};
        Epic epic = new Epic(4, subtusks);
        boolean actual = epic.matches("Пробежать");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void MeetingTrueTest() {
        Meeting meeting = new Meeting(5, "Изготовление детали", "Шасси самолета", "12.06.2023");
        boolean actual = meeting.matches("Изготовление");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void MeetingFalseTest() {
        Meeting meeting = new Meeting(5, "Изготовление детали", "Шасси самолета", "12.06.2023");
        boolean actual = meeting.matches("Колесо");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }

}
