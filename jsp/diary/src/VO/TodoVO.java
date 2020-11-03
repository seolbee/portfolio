package VO;

import java.util.Date;

public class TodoVO {
	private int TodoNO;
	private String Todo;
	private Date todoDate;
	
	public TodoVO(int todoNO, String todo, Date todoDate) {
		this.TodoNO = todoNO;
		this.Todo = todo;
		this.todoDate = todoDate;
	}

	public int getTodoNO() {
		return TodoNO;
	}
	
	public void setTodoNO(int todoNO) {
		TodoNO = todoNO;
	}
	
	public String getTodo() {
		return Todo;
	}
	
	public void setTodo(String todo) {
		Todo = todo;
	}
	
	public Date getTodoDate() {
		return todoDate;
	}
	
	public void setTodoDate(Date todoDate) {
		this.todoDate = todoDate;
	}
	
	
}
