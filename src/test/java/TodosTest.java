import Obdjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notAllTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Записаться на тренировку");

        String[] subtasks = {"Приседания", "Отжимания", "Бег"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Бег",
                "10 километров",
                "В субботу вечером"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("Бег");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Записаться на тренировку");

        String[] subtasks = {"Приседания", "Отжимания", "Бег"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Бег",
                "10 километров",
                "В субботу вечером"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Подтягивания");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Записаться на тренировку");

        String[] subtasks = {"Приседания", "Отжимания", "Бег"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Бег",
                "10 километров",
                "В субботу вечером"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("километров");
        Assertions.assertArrayEquals(expected, actual);
    }
}
