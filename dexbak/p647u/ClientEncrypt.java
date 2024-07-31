package p647u;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Charsets;

/* renamed from: u.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ClientEncrypt {

    /* renamed from: a */
    private static final String f47137a = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmI4spga6IXPP3oQcBlw22l0zE76foy8JDrOjFH7FwAOexq9W1op7bkQXhid9stniBXrGvNDRQJeCi04LfRBatamRfr0nRfbRHc4wrHKKfxXyR8GfscOoJ6b/eifqMDrzCrbgao1mNOUc/76hBT0O+gUellNSqaXdoZLTywEcHnVUkPoCUQgjR7KNBLcQyXjJ81fs5BlYRGJLYpvAdGfnKzACmzWiYzbFJnFmQ0yNdkvPoZ/GZPzoKC83Da4Q2Jw4NSu5NNDeg3QSgx6Q/I5TpzZhocDhCvCefdGBdgzJmlRnYKkbAjNXV1UP/aJFJrzwF9twrPfq3dyF8UmOHwOitQIDAQAB";

    /* renamed from: a */
    public static String m246a(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 0), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, secretKeySpec);
        return new String(cipher.doFinal(Base64.decode(str2, 0)));
    }

    /* renamed from: b */
    public static String[] m245b(String str) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey generateKey = keyGenerator.generateKey();
        String m244c = m244c(generateKey.getEncoded());
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, generateKey);
        return new String[]{Base64.encodeToString(generateKey.getEncoded(), 0), m244c, Base64.encodeToString(cipher.doFinal(str.getBytes(Charsets.f41591a)), 0)};
    }

    /* renamed from: c */
    private static String m244c(byte[] bArr) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(f47137a, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return Base64.encodeToString(cipher.doFinal(bArr), 0);
    }
}
