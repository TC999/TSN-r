package ms.bz.bd.c.Pgl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.util.ArrayMap;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class pbly {
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[256];
        long j4 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                outputStream.flush();
                return j4;
            }
            outputStream.write(bArr, 0, read);
            j4 += read;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static Activity b() {
        try {
            Class<?> cls = Class.forName((String) pblk.a(16777217, 0, 0L, "5f1d86", new byte[]{37, 106, 70, 2, 8, 40, 50, 9, 97, 36, 52, 42, 99, 19, 19, 40, 32, 78, 116, 45, 16, 108, 80, 21, 6, 37}));
            Object invoke = cls.getMethod((String) pblk.a(16777217, 0, 0L, "964775", new byte[]{43, 33, 85, 81, 13, 44, 46, 54, 102, 115, 33, 34, 78, 87, 17, 22, 50, 5, 96, 102, 44}), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField((String) pblk.a(16777217, 0, 0L, "ba7c82", new byte[]{126, 66, 71, 3, 14, 51, 104, 84, 111, 54, 96}));
            declaredField.setAccessible(true);
            Map map = Build.VERSION.SDK_INT < 19 ? (HashMap) declaredField.get(invoke) : (ArrayMap) declaredField.get(invoke);
            if (map.size() < 1) {
                return null;
            }
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField((String) pblk.a(16777217, 0, 0L, "7f76b3", new byte[]{54, 101, 81, 81, 88, 32}));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField((String) pblk.a(16777217, 0, 0L, "c37639", new byte[]{115, 50, 80, 75, 26, 39, 116, 11}));
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
            return null;
        } catch (Exception unused) {
            String str = (String) pblk.a(16777217, 0, 0L, "3b94a9", new byte[]{35, 105, 117, 71});
            return null;
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static byte[] d(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i4 = 0; i4 < length; i4 += 2) {
            bArr[i4 / 2] = (byte) ((Character.digit(str.charAt(i4), 16) << 4) + Character.digit(str.charAt(i4 + 1), 16));
        }
        return bArr;
    }
}
