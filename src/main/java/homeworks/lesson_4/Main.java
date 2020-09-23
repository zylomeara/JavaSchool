package homeworks.lesson_4;

import homeworks.lesson_4.exceptions.InitializationAuthShellError;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException, InitializationAuthShellError {
        PinValidator pinValidator = new PinValidator();
        TerminalServer terminalServer = new TerminalServer();
        SimpleTerminal simpleTerminal = new SimpleTerminal();
        Terminal terminal = new Terminal(pinValidator, terminalServer, simpleTerminal);
        terminal.startService();
    }
}