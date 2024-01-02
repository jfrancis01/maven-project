package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }
  /**
   *
   * @uthor Joel Francis
   * @param someone string
   * @return string
   */
  public final String greet(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}
