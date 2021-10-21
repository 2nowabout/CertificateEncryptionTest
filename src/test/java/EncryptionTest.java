import hasher.GetFileHash;
import hasher.Hasher;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EncryptionTest {

    private String locationOriginalDocs = "CertificateTest.docx";
    private String locationOriginalCopyOtherLocation = "E:\\User\\Desktop\\CertificateTest.docx";
    private String locationOnlyEdditedName = "CertificateNameChange.docx";
    private String locationEdditedCopy = "CertificateEdit.docx";

    @Test
    public void TestEncryptionSameHashAfterEncryption() {
        String text = GetFileHash.GetFileHash(locationOriginalDocs);
        String text2 = GetFileHash.GetFileHash(locationOriginalCopyOtherLocation);
        byte[] salt = null;
        try {
            salt = Hasher.getSalt();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String answer1 = Hasher.getSecurePassword(text, salt);
        String answer2 = Hasher.getSecurePassword(text2, salt);
        assertEquals(answer1, answer2);
    }

    @Test
    public void TestEncryptionSameHashAfterNameChange()
    {
        String text = GetFileHash.GetFileHash(locationOriginalDocs);
        String text2 = GetFileHash.GetFileHash(locationOnlyEdditedName);
        byte[] salt = null;
        try {
            salt = Hasher.getSalt();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String answer1 = Hasher.getSecurePassword(text, salt);
        String answer2 = Hasher.getSecurePassword(text2, salt);
        assertEquals(answer1, answer2);
    }

    @Test
    public void TestEncryptionDeniedHashAfterEdit()
    {
        String text = GetFileHash.GetFileHash(locationOriginalDocs);
        String text2 = GetFileHash.GetFileHash(locationEdditedCopy);
        byte[] salt = null;
        try {
            salt = Hasher.getSalt();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String answer1 = Hasher.getSecurePassword(text, salt);
        String answer2 = Hasher.getSecurePassword(text2, salt);
        assertNotEquals(answer1, answer2);
    }
}
