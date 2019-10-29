package TestCases;

import org.testng.annotations.Factory;

public class runner
{
  @Factory
  public Object[] factory()
  {
      String a;
      return new Object[] {new DatadrivenTest("Santosh"),new DatadrivenTest("Priyanka"),new DatadrivenTest("rockstar")};
  }
}
