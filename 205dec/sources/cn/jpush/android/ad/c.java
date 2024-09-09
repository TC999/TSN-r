package cn.jpush.android.ad;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {
    public static File a(Context context, String str) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            Logger.w("FileUtils", "can't get file :" + str);
            return null;
        }
        return new File(filesDir, str);
    }

    public static Object a(File file) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            Object readObject = objectInputStream.readObject();
            m.a((Closeable) objectInputStream);
            return readObject;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            m.a((Closeable) objectInputStream2);
            throw th;
        }
    }

    public static String a(Context context, String str, int i4) {
        return a(context, str, i4, true);
    }

    public static String a(Context context, String str, int i4, boolean z3) {
        String b4;
        File file = null;
        if (context == null) {
            return null;
        }
        try {
            if (a.a()) {
                String absolutePath = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(str);
                sb.append(str2);
                String sb2 = sb.toString();
                File file2 = new File(sb2);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                b4 = sb2;
                file = file2;
            } else {
                b4 = b(context, str + File.separator);
            }
            if (z3) {
                a(context, str, i4, file);
            }
            return b4;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
        }
        if (z3) {
            return "j_in_app_image_" + System.currentTimeMillis();
        }
        return str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1);
    }

    private static void a(Context context, String str, int i4, File file) {
        File[] listFiles;
        if (file == null) {
            file = a(context, str);
        }
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > i4) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: cn.jpush.android.ad.c.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file2, File file3) {
                    if (file2.lastModified() > file3.lastModified()) {
                        return -1;
                    }
                    return file2.lastModified() < file3.lastModified() ? 1 : 0;
                }
            });
            e(listFiles[listFiles.length - 1]);
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Throwable th) {
            Logger.w("FileUtils", "FileUtils e:" + th);
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        return a(str, str2, true);
    }

    public static boolean a(String str, String str2, boolean z3) {
        try {
            Logger.w("debug_117", "save isAddHeader" + z3);
            Logger.w("debug_117", "save first data" + str2);
            if (z3) {
                str2 = e(str2);
            }
            Logger.w("debug_117", "save after data" + str2);
            return b(str, str2 != null ? str2.getBytes("UTF-8") : null);
        } catch (Exception e4) {
            Logger.w("FileUtils", "getBytes exception:" + e4);
            return false;
        }
    }

    public static boolean a(String str, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return b(str, bArr);
    }

    public static String b(Context context, String str) {
        try {
            File a4 = a(context, str);
            if (a4 == null) {
                Logger.w("FileUtils", str + " can't be null");
                return "";
            }
            if (a4.isFile()) {
                a4.delete();
            }
            if (!a4.exists()) {
                a4.mkdirs();
            }
            return a4.getAbsolutePath() + File.separator;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b(File file) {
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

    public static boolean b(String str) {
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

    public static boolean b(String str, String str2) {
        Logger.v("FileUtils", "action:createHtmlFile - filePath:" + str + ", content:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return a(str, str2, false);
    }

    private static boolean b(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                b(file);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    m.a(fileOutputStream2);
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    Logger.w("FileUtils", "save to file exception:" + e + " path = " + str);
                    m.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    m.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static String c(Context context, String str) {
        try {
            if (!a.a()) {
                a(context, "rich", 10, (File) null);
                return b(context, "rich" + File.separator + str);
            }
            String absolutePath = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(str);
            sb.append(str2);
            String sb2 = sb.toString();
            File file = new File(sb2);
            if (!file.exists()) {
                file.mkdirs();
            }
            return sb2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(File file) {
        byte[] d4 = d(file);
        if (d4 == null) {
            return null;
        }
        try {
            return d(new String(d4, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String c(String str) {
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

    private static String d(String str) {
        try {
            return (!TextUtils.isEmpty(str) && b(str)) ? c(str.substring(10)) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void d(Context context, String str) {
        try {
            e(new File(a(context, "j_in_app_" + str, 0, false)));
        } catch (Throwable th) {
            Logger.ee("FileUtils", "delete file throwable" + th);
        }
    }

    public static byte[] d(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.exists() && !file.isDirectory()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] a4 = m.a((InputStream) fileInputStream);
                    m.a((Closeable) fileInputStream);
                    return a4;
                } catch (Throwable unused) {
                    m.a((Closeable) fileInputStream);
                    return null;
                }
            } catch (Throwable unused2) {
                fileInputStream = null;
            }
        }
        return null;
    }

    public static String e(Context context, String str) {
        try {
            String str2 = (a.a() ? context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : context.getFilesDir()).getAbsolutePath() + File.separator + str;
            if (new File(str2).exists()) {
                return str2;
            }
            Logger.ww("FileUtils", "Can't find developer picture resource in SDCard.");
            return "";
        } catch (Throwable th) {
            Logger.ww("FileUtils", "Get developer picture resource failed." + th);
            return "";
        }
    }

    private static String e(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.insert(0, "j-c-o-r-e-");
            return c(sb.toString());
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean e(File file) {
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    return file.delete();
                }
                String[] list = file.list();
                if (list != null) {
                    for (String str : list) {
                        File file2 = new File(file, str);
                        if (file2.isDirectory()) {
                            e(file2);
                        } else {
                            file2.delete();
                        }
                    }
                }
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            Logger.e("FileUtils", "Delete dir error");
            return false;
        }
    }
}
