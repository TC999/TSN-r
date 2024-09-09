package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class c {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f41665c = {82, 83, 65, 47, 69, 67, 66, 47, 80, 75, 67, 83, 49, 80, 97, 100, 100, 105, 110, 103};

    /* renamed from: a  reason: collision with root package name */
    private PublicKey f41666a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f41667b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f41668a = new c();
    }

    private c() {
        boolean z3;
        try {
            this.f41666a = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z3 = true;
        } catch (Throwable unused) {
            z3 = false;
        }
        this.f41667b = z3;
    }

    private PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("\u516c\u94a5\u6570\u636e\u4e3a\u7a7a");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("\u65e0\u6b64\u7b97\u6cd5");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("\u516c\u94a5\u975e\u6cd5");
        }
    }

    public boolean a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (this.f41667b) {
            if (this.f41666a != null) {
                byte[] decode = Base64.decode(str, 0);
                try {
                    Cipher cipher = Cipher.getInstance(new String(f41665c, "UTF-8"));
                    cipher.init(2, this.f41666a);
                    str3 = new String(cipher.doFinal(decode), "UTF-8").trim();
                } catch (Throwable unused) {
                    GDTLogger.d("ErrorWhileVerifySigNature");
                }
                boolean equals = str2.equals(str3);
                GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + str3);
                return equals;
            }
            str3 = null;
            boolean equals2 = str2.equals(str3);
            GDTLogger.d("Verify Result" + equals2 + "src=" + str2 + " & target=" + str3);
            return equals2;
        }
        return true;
    }

    public boolean a(String str, File file) {
        String str2;
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str2 = d.a(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                str2 = "";
                return a(str, str2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
            return a(str, str2);
        }
        str2 = "";
        return a(str, str2);
    }
}
