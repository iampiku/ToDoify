package com.todo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo.exception.TodoException;
import com.todo.repository.TodoRepository;
import com.todo.services.TodoServiceImpl;
import com.todo.dto.TodoDTO;

@SpringBootTest
class TodoServiceImplTest {
    
    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoServiceImpl todoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTodos() throws TodoException { 
        List<TodoDTO> todos = new ArrayList<>();
        TodoDTO todoOne = new TodoDTO();
        todoOne.setTodoID(1);
        todoOne.setTitle("TaskOne");
        todoOne.setTask("TaskOne");
        todoOne.setCreatedAt(LocalDate.now());

        todos.add(todoOne);
    }
}
