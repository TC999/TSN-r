package p601i0;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* renamed from: i0.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class StorageUtil {

    /* renamed from: a */
    private static final String f40176a = "video-cache";

    /* renamed from: a */
    public static boolean m12715a(String str) {
        String[] list;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                return file.delete();
            }
            for (String str2 : file.list()) {
                m12715a(str + File.separator + str2);
            }
            return file.delete();
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m12714b(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    /* renamed from: c */
    private static File m12713c(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File m12712d = (z && "mounted".equals(str)) ? m12712d(context) : null;
        if (m12712d == null) {
            m12712d = context.getCacheDir();
        }
        if (m12712d == null) {
            return new File(context.getFilesDir().getPath() + context.getPackageName() + "/cache/");
        }
        return m12712d;
    }

    /* renamed from: d */
    private static File m12712d(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    /* renamed from: e */
    public static File m12711e(Context context) {
        return new File(m12713c(context, true), f40176a);
    }
}
