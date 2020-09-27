package homeworks.lesson_4_exceptions;

import homeworks.lesson_4_exceptions.exceptions.InitializationAuthShellError;

public interface InteractShell {
    void runAuth(PinValidator cb) throws InitializationAuthShellError;
    void runBalanceControl(TerminalServer cb);
}
