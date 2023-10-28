package edu.hw2.task4;

public class Calling {
    public record CallingInfo(String className, String methodName) {}
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            return new CallingInfo("", "");
        }
        String className = stackTrace[1].getClassName();
        String methodName = stackTrace[1].getMethodName();
        return new CallingInfo(className, methodName);
    }
}
