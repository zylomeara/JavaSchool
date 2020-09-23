package homeworks.lesson_4;

import homeworks.lesson_4.exceptions.InitializationAuthShellError;

public interface InteractShell {
    void runAuth(PinValidator cb) throws InitializationAuthShellError;
    void runBalanceControl(TerminalServer cb);
}
