package cn.bluemobi.dylan.sqlitelibrary;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

/* renamed from: cn.bluemobi.dylan.sqlitelibrary.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SqlcipherUtils {
    /* renamed from: a */
    public static void m57447a(File file, File file2, String str) {
        try {
            SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, str, (SQLiteDatabase.CursorFactory) null);
            String name = file2.getName();
            if (file2.getName().contains(".")) {
                name = file2.getName().split("\\.")[0];
            }
            openOrCreateDatabase.rawExecSQL(String.format("ATTACH DATABASE '%s' as " + name + " KEY '';", file2.getAbsolutePath()));
            openOrCreateDatabase.rawExecSQL("SELECT sqlcipher_export('" + name + "');");
            openOrCreateDatabase.rawExecSQL("DETACH DATABASE " + name + ";");
            SQLiteDatabase.openOrCreateDatabase(file2, "", (SQLiteDatabase.CursorFactory) null).close();
            openOrCreateDatabase.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m57446b(File file, File file2, String str) {
        try {
            SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file2, "", (SQLiteDatabase.CursorFactory) null);
            String name = file.getName();
            if (name.contains(".")) {
                name = file.getName().split("\\.")[0];
            }
            openOrCreateDatabase.rawExecSQL(String.format("ATTACH DATABASE '%s' as " + name + " KEY '" + str + "';", file.getAbsolutePath()));
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT sqlcipher_export('");
            sb.append(name);
            sb.append("');");
            openOrCreateDatabase.rawExecSQL(sb.toString());
            openOrCreateDatabase.rawExecSQL("DETACH DATABASE " + name + ";");
            SQLiteDatabase openOrCreateDatabase2 = SQLiteDatabase.openOrCreateDatabase(file, str, (SQLiteDatabase.CursorFactory) null);
            openOrCreateDatabase2.setVersion(openOrCreateDatabase.getVersion());
            openOrCreateDatabase2.close();
            openOrCreateDatabase.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static File m57445c(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "/data/data/" + context.getPackageName() + "/databases/";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "mydb.db";
        }
        File file = new File(str, str2);
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: d */
    public static void m57444d(Context context, File file, File file2, String str) {
        if (file.exists()) {
            m57446b(file2, file, str);
            file.delete();
        }
    }
}
