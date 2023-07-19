package com.todo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer todoID;

	@Column(name = "title")
	private String title;

	@Column(name = "task")
	private String task;

	@Column(name = "status")
	private String status;

	@Column(name = "created_at")
	private LocalDate creationDate;

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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

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
		Todo other = (Todo) obj;
		if (todoID == null) {
			if (other.todoID != null)
				return false;
		} else if (!todoID.equals(other.todoID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Todo [todoID=" + todoID + ", title=" + title + ", task=" + task + ", status=" + status + ", creationDate="
				+ creationDate + "]";
	}
}
