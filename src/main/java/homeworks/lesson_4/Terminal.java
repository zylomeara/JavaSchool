package homeworks.lesson_4;

import homeworks.lesson_4.exceptions.InitializationAuthShellError;

public class Terminal {
    PinValidator pinValidator;
    TerminalServer terminalServer;
    InteractShell shell;

    public Terminal(PinValidator pinValidator, TerminalServer terminalServer, InteractShell shell) {
        this.pinValidator = pinValidator;
        this.terminalServer = terminalServer;
        this.shell = shell;
    }

    void startService() throws InitializationAuthShellError {
        shell.runAuth(pinValidator);
        shell.runBalanceControl(terminalServer);
    }
}
