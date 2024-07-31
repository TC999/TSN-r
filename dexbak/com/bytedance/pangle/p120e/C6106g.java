package com.bytedance.pangle.p120e;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6081c;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.bytedance.pangle.e.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6106g {

    /* renamed from: com.bytedance.pangle.e.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6107a extends File {
        public C6107a(File file, String str) {
            super(file, str);
        }
    }

    /* renamed from: a */
    public static String m37179a(String str, int i) {
        int m37177b = m37177b(str, i);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 <= m37177b; i2++) {
            sb.append(new C6107a(new File(C6081c.m37219i(str, i)), i2 == 1 ? "classes.dex" : "classes" + i2 + ".dex").getAbsolutePath());
            sb.append(":");
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static int m37177b(String str, int i) {
        return m37180a((str + "-" + i) + ".dex.number");
    }

    /* renamed from: a */
    public static void m37178a(ZipFile zipFile, ZipEntry zipEntry, C6107a c6107a, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".dex", c6107a.getParentFile());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createTempFile));
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            if (createTempFile.setReadOnly()) {
                if (createTempFile.renameTo(c6107a)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + c6107a.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + c6107a.getAbsolutePath() + "\")");
        } finally {
            m37182a(inputStream);
            createTempFile.delete();
        }
    }

    /* renamed from: a */
    private static void m37182a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            ZeusLogger.m37076w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        }
    }

    /* renamed from: a */
    public static void m37181a(File file) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            ZeusLogger.m37081i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                ZeusLogger.m37077w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
        }
    }

    /* renamed from: a */
    public static SharedPreferences m37183a() {
        return Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    /* renamed from: a */
    private static int m37180a(String str) {
        return m37183a().getInt(str, 0);
    }
}
