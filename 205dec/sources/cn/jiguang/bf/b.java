package cn.jiguang.bf;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.bj.g;
import cn.jiguang.bj.j;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static File a(Context context, File file, int i4, int i5, String str) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        try {
            String d4 = j.d(g.a(context));
            if (TextUtils.isEmpty(d4)) {
                cn.jiguang.bi.b.g("PIU", "process name to hash failed");
                cn.jiguang.dy.c.a().a(context, i4, i5, cn.jiguang.bg.a.f2609d, 2, "process name to md5 failed");
                cn.jiguang.bj.c.a((Closeable) null);
                cn.jiguang.bj.c.a((Closeable) null);
                return null;
            }
            String d5 = j.d(d4 + file.getName());
            if (TextUtils.isEmpty(d5)) {
                cn.jiguang.bi.b.g("PIU", "process + fileName to hash failed");
                cn.jiguang.dy.c.a().a(context, i4, i5, cn.jiguang.bg.a.f2609d, 2, "process + fileName to md5 failed");
                cn.jiguang.bj.c.a((Closeable) null);
                cn.jiguang.bj.c.a((Closeable) null);
                return null;
            }
            File file2 = new File(file.getParentFile(), d4 + File.separator + d5 + ".d");
            if (file2.exists()) {
                file2.delete();
            }
            file2.getParentFile().mkdirs();
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(file2);
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[32];
                fileInputStream.read(bArr);
                String str2 = new String(bArr, "utf-8");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, new SecretKeySpec(str2.getBytes("utf-8"), "AES"), new IvParameterSpec(str.getBytes("utf-8")));
                CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
                byte[] bArr2 = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr2, 0, 8192);
                    if (read == -1) {
                        break;
                    }
                    cipherOutputStream.write(bArr2, 0, read);
                }
                cn.jiguang.bj.c.a(cipherOutputStream);
                String a4 = cn.jiguang.bj.c.a(file2.getAbsolutePath());
                cn.jiguang.bi.b.b("PIU", "dd f hash:" + a4);
                if (!str2.equals(a4)) {
                    cn.jiguang.dy.c.a().a(context, i4, i5, cn.jiguang.bg.a.f2609d, 2, "file MD5 not match");
                    return null;
                }
                cn.jiguang.bi.b.b("PIU", "d d success");
                if (!file2.exists()) {
                    cn.jiguang.dy.c.a().a(context, i4, i5, cn.jiguang.bg.a.f2609d, 2, "create dex file failed ");
                }
                if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
                    file2.setReadOnly();
                }
                return file2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    cn.jiguang.bi.b.e("PIU", "decode failed:" + th.getMessage());
                    cn.jiguang.dy.c.a().a(context, i4, i5, cn.jiguang.bg.a.f2609d, 2, "decode failed " + th.getMessage());
                    return null;
                } finally {
                    cn.jiguang.bj.c.a(fileOutputStream);
                    cn.jiguang.bj.c.a(fileInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public static File a(Context context, String str, int i4, int i5) {
        String a4 = a(str, i4 + "", i5);
        return new File(context.getFilesDir() + File.separator + ".p", a4);
    }

    private static String a(String str, String str2, int i4) {
        if (TextUtils.isEmpty(str)) {
            str = str2 + i4;
        }
        return "." + str;
    }

    public static boolean a(File file, cn.jiguang.bg.c cVar, boolean z3) {
        if (!file.exists() || !file.canRead()) {
            cn.jiguang.bi.b.b("PIU", "p :" + file.getAbsolutePath() + " not.");
            return false;
        } else if (z3) {
            if (TextUtils.isEmpty(cVar.f2647s)) {
                cn.jiguang.bi.b.g("PIU", "p M error.");
                return false;
            }
            String a4 = cn.jiguang.bj.c.a(file.getAbsolutePath());
            if (TextUtils.isEmpty(a4)) {
                cn.jiguang.bi.b.g("PIU", "g p M f.");
                return false;
            } else if (cVar.f2647s.equalsIgnoreCase(a4)) {
                return true;
            } else {
                file.delete();
                cn.jiguang.bi.b.g("PIU", "p M not m, c m: " + cVar.f2647s + ", b f m:" + a4);
                return false;
            }
        } else {
            return true;
        }
    }

    public static File b(Context context, String str, int i4, int i5) {
        if (context != null) {
            String str2 = context.getFilesDir() + File.separator + ".p";
            File file = new File(str2, a(str, i4 + "", i5) + "o");
            cn.jiguang.bi.b.b("PIU", "getLibPath mkdirs:" + file.mkdirs());
            return file;
        }
        return null;
    }

    public static File c(Context context, String str, int i4, int i5) {
        String str2 = context.getFilesDir() + File.separator + ".p";
        File file = new File(str2, a(str, i4 + "", i5) + "ox");
        cn.jiguang.bi.b.b("PIU", "getOptimizedDexPath mkdirs:" + file.mkdirs());
        return file;
    }
}
