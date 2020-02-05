package se.ecutb.data;

import org.springframework.stereotype.Component;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class TodoRepositoryImpl implements TodoRepository {

    private List<Todo> todoList = new ArrayList<>();


    @Override
    public Todo persist(Todo todo) {
        if(!todoList.contains(todo)){
            todoList.add(todo);
        }
        return todo;
    }

    @Override
    public Optional<Todo> findById(int todoId) {
        return todoList.stream().filter(todo -> todo.getTodoId() == todoId)
                .findFirst();
    }

    @Override
    public List<Todo> findByTaskDescriptionContains(String taskDescription) {
        return todoList.stream().filter(todo -> todo.getTaskDescription().toLowerCase().contains(taskDescription))
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByDeadLineBefore(LocalDate endDate) {
        return todoList.stream().filter(todo -> todo.getDeadLine().isBefore(endDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByDeadLineAfter(LocalDate startDate) {
        return todoList.stream().filter(todo -> todo.getDeadLine().isAfter(startDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByDeadLineBetween(LocalDate start, LocalDate end) {

        return todoList.stream().filter(todo -> todo.getDeadLine().isAfter(start) &&
                todo.getDeadLine().isBefore(end)).collect(Collectors.toList());

    }

    @Override
    public List<Todo> findByAssigneeId(int personId) {

        return todoList.stream().filter(todo -> todo.getTodoId() == personId)
                .collect(Collectors.toList());

    }

    @Override
    public List<Todo> findAllUnassignedTasks() {
        return todoList.stream().filter(todo -> todo.getTodoId() != 0 && todo.getAssignee() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findAllAssignedTasks() {

        return todoList.stream().filter(todo -> todo.getAssignee() != null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByDone(boolean isDone) {
        return todoList.stream().filter(todo -> todo.isDone() == isDone)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findAll() {
        return todoList;
    }

    @Override
    public boolean delete(int todoId) throws IllegalArgumentException {
        return todoList.remove(findById(todoId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void clear() {
        todoList.clear();
    }
}
