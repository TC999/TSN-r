package cn.jiguang.bj;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f2661c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public static final String f2659a = cn.jiguang.bh.a.b(new byte[]{87, 69, 109, 65, 120, 98, 68, 65, 119, 107, 115});

    /* renamed from: b  reason: collision with root package name */
    public static final String f2660b = cn.jiguang.bh.a.b(new byte[]{124, 112, 70, 65, 55, 123, 115, 114, 69, 82, 112, 124, 111, 63, 125, 69, 106, 123, 119, 118, 85, 100, 112, 111, 115, 98, 68});

    /* renamed from: d  reason: collision with root package name */
    private static HashMap<String, MessageDigest> f2662d = new HashMap<>();

    public static String a(Context context) {
        return context.getFilesDir() + File.separator + "p_an";
    }

    public static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            String str2 = File.separator;
            sb.append(str2);
            sb.append("p_an");
            sb.append(str2);
            sb.append(str);
            return a(new File(sb.toString()));
        } catch (Throwable th) {
            cn.jiguang.bi.b.g("FU", "[readFromFileDir] error:" + th.getMessage());
            return null;
        }
    }

    public static String a(File file) {
        BufferedReader bufferedReader;
        try {
            if (!file.exists()) {
                a((Closeable) null);
                return null;
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                return bufferedReader.readLine();
            } catch (Throwable th) {
                th = th;
                try {
                    cn.jiguang.bi.b.g("FU", "[readFile] error:" + th.getMessage());
                    return null;
                } finally {
                    a(bufferedReader);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static String a(String str) {
        FileInputStream fileInputStream;
        Exception e4;
        String str2;
        try {
            File file = new File(str);
            cn.jiguang.bi.b.b("FU", str + "---- f ex = " + file.exists() + "  , l = " + file.length());
            fileInputStream = new FileInputStream(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(i.f2684a);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                str2 = a(messageDigest.digest());
            } catch (Exception e5) {
                e4 = e5;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                e4.printStackTrace();
                str2 = "";
                cn.jiguang.bi.b.b("FU", str + "---- m = " + str2);
                return str2;
            }
        } catch (Exception e7) {
            fileInputStream = null;
            e4 = e7;
        }
        cn.jiguang.bi.b.b("FU", str + "---- m = " + str2);
        return str2;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            char[] cArr = f2661c;
            sb.append(cArr[(bArr[i4] & 240) >>> 4]);
            sb.append(cArr[bArr[i4] & 15]);
        }
        return sb.toString();
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            String str3 = File.separator;
            sb.append(str3);
            sb.append("p_an");
            sb.append(str3);
            sb.append(str);
            a(new File(sb.toString()), str2);
        } catch (Throwable th) {
            cn.jiguang.bi.b.g("FU", "saveToFileDir error:" + th.getMessage());
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(File file, String str) {
        BufferedWriter bufferedWriter = null;
        try {
            if (file.exists() && TextUtils.isEmpty(str)) {
                file.delete();
                return;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter2.write(str);
                bufferedWriter2.flush();
                a(bufferedWriter2);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                try {
                    cn.jiguang.bi.b.g("FU", "[saveToFile] error:" + th.getMessage());
                } finally {
                    a(bufferedWriter);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
