package com.todo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class TodoDTO {

  private Integer todoID;

  @NotBlank
  @NotNull(message = "task title cannot be empty")
  private String title;
  
  @NotBlank
  @NotBlank(message = "Task cannot be empty.")
  private String task;

  @NotBlank
  @NotNull(message = "status cannot be empty")
  private String status;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private LocalDate createdAt;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((todoID == null) ? 0 : todoID.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TodoDTO other = (TodoDTO) obj;
    if (todoID == null) {
      if (other.todoID != null)
        return false;
    } else if (!todoID.equals(other.todoID))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "TodoDTO [todoID=" + todoID + ", task=" + task + ", status=" + status + ", createdAt=" + createdAt + "]";
  }

  public Integer getTodoID() {
    return todoID;
  }

  public void setTodoID(Integer todoID) {
    this.todoID = todoID;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

}
