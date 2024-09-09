package u;

import android.util.Base64;
import com.acse.ottn.f;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ClientEncrypt.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f64414a = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmI4spga6IXPP3oQcBlw22l0zE76foy8JDrOjFH7FwAOexq9W1op7bkQXhid9stniBXrGvNDRQJeCi04LfRBatamRfr0nRfbRHc4wrHKKfxXyR8GfscOoJ6b/eifqMDrzCrbgao1mNOUc/76hBT0O+gUellNSqaXdoZLTywEcHnVUkPoCUQgjR7KNBLcQyXjJ81fs5BlYRGJLYpvAdGfnKzACmzWiYzbFJnFmQ0yNdkvPoZ/GZPzoKC83Da4Q2Jw4NSu5NNDeg3QSgx6Q/I5TpzZhocDhCvCefdGBdgzJmlRnYKkbAjNXV1UP/aJFJrzwF9twrPfq3dyF8UmOHwOitQIDAQAB";

    public static String a(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 0), "AES");
        Cipher cipher = Cipher.getInstance(f.f5641a);
        cipher.init(2, secretKeySpec);
        return new String(cipher.doFinal(Base64.decode(str2, 0)));
    }

    public static String[] b(String str) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey generateKey = keyGenerator.generateKey();
        String c4 = c(generateKey.getEncoded());
        Cipher cipher = Cipher.getInstance(f.f5641a);
        cipher.init(1, generateKey);
        return new String[]{Base64.encodeToString(generateKey.getEncoded(), 0), c4, Base64.encodeToString(cipher.doFinal(str.getBytes(d.a)), 0)};
    }

    private static String c(byte[] bArr) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmI4spga6IXPP3oQcBlw22l0zE76foy8JDrOjFH7FwAOexq9W1op7bkQXhid9stniBXrGvNDRQJeCi04LfRBatamRfr0nRfbRHc4wrHKKfxXyR8GfscOoJ6b/eifqMDrzCrbgao1mNOUc/76hBT0O+gUellNSqaXdoZLTywEcHnVUkPoCUQgjR7KNBLcQyXjJ81fs5BlYRGJLYpvAdGfnKzACmzWiYzbFJnFmQ0yNdkvPoZ/GZPzoKC83Da4Q2Jw4NSu5NNDeg3QSgx6Q/I5TpzZhocDhCvCefdGBdgzJmlRnYKkbAjNXV1UP/aJFJrzwF9twrPfq3dyF8UmOHwOitQIDAQAB", 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return Base64.encodeToString(cipher.doFinal(bArr), 0);
    }
}
