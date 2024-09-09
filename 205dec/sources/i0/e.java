package i0;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* compiled from: StorageUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f54760a = "video-cache";

    public static boolean a(String str) {
        String[] list;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                return file.delete();
            }
            for (String str2 : file.list()) {
                a(str + File.separator + str2);
            }
            return file.delete();
        }
        return true;
    }

    public static boolean b(File file) {
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

    private static File c(Context context, boolean z3) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File d4 = (z3 && "mounted".equals(str)) ? d(context) : null;
        if (d4 == null) {
            d4 = context.getCacheDir();
        }
        if (d4 == null) {
            return new File(context.getFilesDir().getPath() + context.getPackageName() + "/cache/");
        }
        return d4;
    }

    private static File d(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static File e(Context context) {
        return new File(c(context, true), f54760a);
    }
}
