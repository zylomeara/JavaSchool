package homeworks.lesson_9_lambda;

import homeworks.lesson_9_lambda.task_4_gamma.Gamma;
import org.junit.Test;

public class GammaTest {
    int key = 123123;
    String text = "Hello World";

    @Test
    public void testEncrypt() {
        byte[] encryptText = Gamma.encrypt(text, key);
        System.out.println(encryptText);
    }

    @Test
    public void testDecrypt() {
        String decryptText = Gamma.decrypt(Gamma.encrypt(text, key), key);
        System.out.println(decryptText);
    }
}
