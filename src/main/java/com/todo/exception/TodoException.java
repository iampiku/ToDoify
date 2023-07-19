package com.todo.exception;

/**
 * This custom exception class can be used in the application to raise an
 * exception with a specific error message, and provide a centralized way of
 * handling exceptions within the application.
 */
public class TodoException extends Exception {

  /**
   * The class has a private static final long variable "serialVersionUID" with a
   * value of 1. This is used as a version identifier for the serialization of the
   * exception object, which is a mechanism for transmitting an object's state
   * from one JVM to another.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The class has a single constructor which takes a single string argument
   * "message". The constructor passes the message to the parent class'
   * constructor using the "super" keyword, thus allowing the message to be
   * retrieved using the getMessage() method inherited from the parent class.
   */
  public TodoException(String message) {
    super(message);
  }
}
