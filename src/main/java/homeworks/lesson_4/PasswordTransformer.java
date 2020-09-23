package homeworks.lesson_4;

public class PasswordTransformer {
    StringBuilder password;

    public PasswordTransformer(String password) {
        this.password = new StringBuilder(password);
    }

    @Override
    public String toString() {
        return password.toString();
    }

    public void deleteLast() {
        password.replace(
                0,
                password.length(),
                password.substring(0, password.length() == 0 ? 0 : password.length() - 1)
        );
    }

    public void append(char ch) {
        password.append(ch);
    }

    public int length() {
        return password.length();
    }
}
