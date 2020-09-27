package homeworks.lesson_4_exceptions;

import homeworks.lesson_4_exceptions.exceptions.*;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SimpleTerminal implements InteractShell {
    org.jline.terminal.Terminal terminal;

    public SimpleTerminal() throws IOException {
        terminal = TerminalBuilder.builder()
                .jna(true)
                .system(true)
                .build();


        terminal.enterRawMode();
    }

    void clearRow() {
        System.out.print("\033[2K");
    }

    void goToUpRow(int count) {
        System.out.printf("\033[%dA\r", count);
        resetCaret();
    }

    void goToDownRow(int count) {
        System.out.printf("\033[%dB\r", count);
        resetCaret();
    }

    void resetCaret() {
        System.out.print("\r");
    }

    void printInfo(String msg) {
        goToUpRow(1);
        clearRow();
        System.out.print(msg);
        goToDownRow(1);
    }

    void printWarning(String msg) {
        goToUpRow(2);
        clearRow();
        System.out.print(msg);
        goToDownRow(2);
    }

    void printPassword(String password) {
        resetCaret();
        System.out.print("_ _ _ _");
        resetCaret();
        IntStream.range(0, password.length()).forEach((a) -> System.out.print("* "));
    }

    @Override
    public void runAuth(PinValidator pinValidator) throws InitializationAuthShellError {
        NonBlockingReader reader = terminal.reader();
        System.out.println("\n");
        printInfo("Введите пароль:");

        PasswordTransformer password = new PasswordTransformer("");

        while (true) {
            printPassword(password.toString());

            while (password.length() < 4) {
                int read;
                try {
                    read = reader.read();
                } catch (IOException e) {
                    throw new InitializationAuthShellError("Проблема инициализации интерфейса авторизации");
                }
                char readChar = (char) read;
                printWarning("");

                if (read == 127)
                    password.deleteLast();
                else {
                    try {
                        pinValidator.validate(password.toString() + readChar);
                        password.append(readChar);
                    } catch (IncorrectPasswordError e) {
                        printWarning(e.getMessage());
                    }
                }

                printPassword(password.toString());
            }
            try {
                pinValidator.auth(password.toString());
                break;
            } catch (InvalidPasswordError | AccountIsLockedException e) {
                printWarning(e.getMessage());
                password = new PasswordTransformer("");
            }
        }
        System.out.println();

        try {
            reader.close();
            terminal.close();
        } catch (IOException e) {
            throw new InitializationAuthShellError("Проблема инициализации интерфейса авторизации");
        }
    }

    @Override
    public void runBalanceControl(TerminalServer cb) {
        while (true) {
            System.out.println("Введите команду (check, put, take, exit):");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            switch (command) {
                case "check": {
                    System.out.println("На вашем счете: " + cb.checkBalance());
                    break;
                }
                case "put": {
                    while(true) {
                        System.out.println("Введите сумму для пополнения:");
                        try {
                            String count = new Scanner(System.in).nextLine();
                            cb.putMoney(Integer.parseInt(count));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Невалидное число");
                        }  catch (PositiveNumberError | MultiplicitySumMoneyError e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case "take": {
                    while(true) {
                        System.out.println("Введите сумму для получения:");
                        try {
                            String count = new Scanner(System.in).nextLine();
                            cb.takeMoney(Integer.parseInt(count));
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Невалидное число");
                        } catch (PositiveNumberError | MultiplicitySumMoneyError | NotEnoughMoneyError e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case "exit": {
                    return;
                }
            }
        }
    }
}
