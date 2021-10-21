package hasher;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class GetFileHash {
    public static String GetFileHash(String location)
    {
        Path path = Paths.get(location);
        byte[] digest = null;
        try {
            digest = Files.readAllBytes(path);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hash = sb.toString();
        return hash;
    }
}
