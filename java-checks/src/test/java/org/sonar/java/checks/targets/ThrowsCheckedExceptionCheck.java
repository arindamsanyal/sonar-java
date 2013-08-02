/*
 * SonarQube Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.java.checks.targets;

import java.io.IOException;

public class ThrowsCheckedExceptionCheck {

  public void foo1() { // Compliant
  }

  public void foo2() throws Throwable { // Non-Compliant
  }

  public void foo3() throws Error { // Non-Compliant
  }

  public void foo4() throws MyException { // Non-Compliant
  }

  public void foo5() throws RuntimeException { // Compliant
  }

  public void foo6() throws IllegalArgumentException { // Compliant
  }

  public void foo7() throws MyRuntimeException { // Compliant
  }

  public void foo8() throws IllegalArgumentException, MyException, IOException { // Non-Compliant
  }

  public class MyException extends Exception {
  }

  public class MyRuntimeException extends RuntimeException {
  }

}