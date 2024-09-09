package cn.jiguang.ag;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {
    public static File a(Context context, String str) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            cn.jiguang.w.a.f("FileUtils", "can't get file :" + str);
            return null;
        }
        return new File(filesDir, str);
    }

    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static boolean a(File file, String str) {
        byte[] bytes;
        if (str != null) {
            try {
                bytes = c(str).getBytes("UTF-8");
            } catch (Throwable th) {
                cn.jiguang.w.a.f("FileUtils", "getBytes exception:" + th);
                return false;
            }
        } else {
            bytes = null;
        }
        return a(file, bytes);
    }

    public static boolean a(File file, byte[] bArr) {
        if (file == null || file.isDirectory()) {
            cn.jiguang.w.a.f("FileUtils", "file should not be null or a directory");
            return false;
        }
        FileOutputStream fileOutputStream = null;
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th) {
                th = th;
                try {
                    cn.jiguang.w.a.f("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
                    return false;
                } finally {
                    j.a(fileOutputStream);
                }
            }
        }
        a(file);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        try {
            fileOutputStream2.write(bArr);
            j.a(fileOutputStream2);
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
            cn.jiguang.w.a.f("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
            return false;
        }
    }

    public static boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            char[] charArray = str.toCharArray();
            char[] cArr = new char[10];
            if (charArray.length <= 10) {
                return false;
            }
            for (int i4 = 0; i4 < 10; i4++) {
                cArr[i4] = (char) (charArray[i4] ^ '\u07d0');
            }
            return "j-c-o-r-e-".equals(new String(cArr));
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            char[] charArray = str.toCharArray();
            for (int i4 = 0; i4 < charArray.length; i4++) {
                charArray[i4] = (char) (charArray[i4] ^ '\u07d0');
            }
            return new String(charArray);
        } catch (Throwable unused) {
            return str;
        }
    }

    public static byte[] b(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            return j.a((InputStream) fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            try {
                cn.jiguang.w.a.b("FileUtils", "can't read, give up read. e:" + th);
                return null;
            } finally {
                j.a((Closeable) fileInputStream);
            }
        }
    }

    public static String c(File file) {
        byte[] b4 = b(file);
        if (b4 == null) {
            return null;
        }
        try {
            return d(new String(b4, "UTF-8"));
        } catch (UnsupportedEncodingException e4) {
            cn.jiguang.w.a.b("FileUtils", "can't encoding, give up read :" + e4);
            return null;
        }
    }

    private static String c(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.insert(0, "j-c-o-r-e-");
            return b(sb.toString());
        } catch (Throwable unused) {
            return str;
        }
    }

    private static String d(String str) {
        try {
            return (!TextUtils.isEmpty(str) && a(str)) ? b(str.substring(10)) : str;
        } catch (Throwable unused) {
            return str;
        }
    }
}
