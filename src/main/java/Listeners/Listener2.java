package Listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class Listener2 implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Method: beforeInvocation(IInvokedMethod method, ITestResult testResult)");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Method: afterInvocation(IInvokedMethod method, ITestResult testResult)");
    }
}