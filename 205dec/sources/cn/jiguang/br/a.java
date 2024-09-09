package cn.jiguang.br;

import cn.jiguang.bq.d;
import cn.jiguang.f.i;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    private static void a(int i4, String str, File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            String substring = str.substring(0, 16);
            d.c("CryptoUtils", "doCrypto cipherMode is " + i4 + ", key is " + str + ", IvParameterSpec is " + substring + ", inputFile is " + file.getAbsolutePath() + ", outputFile is " + file2.getAbsolutePath());
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(substring.getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(i4, secretKeySpec, ivParameterSpec);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream2.read(bArr);
                byte[] doFinal = cipher.doFinal(bArr);
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(doFinal);
                    fileOutputStream.flush();
                    i.a((Closeable) fileInputStream2);
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = fileInputStream2;
                    try {
                        d.i("CryptoUtils", "Error encrypting/decrypting file, error message is " + e.getMessage());
                        i.a((Closeable) fileInputStream);
                        i.a(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        i.a((Closeable) fileInputStream);
                        i.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    i.a((Closeable) fileInputStream);
                    i.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        i.a(fileOutputStream);
    }

    public static void a(String str, File file, File file2) {
        a(1, str, file, file2);
    }
}
