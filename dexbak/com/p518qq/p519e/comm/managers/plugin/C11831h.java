package com.p518qq.p519e.comm.managers.plugin;

import android.content.Context;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.qq.e.comm.managers.plugin.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11831h {

    /* renamed from: a */
    private static String f32941a = C11823b.m20332a("e_qq_com_plugin");

    /* renamed from: b */
    private static String f32942b = C11823b.m20332a("e_qq_com_dex");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static File m20318a(Context context) {
        return context.getDir(f32942b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m20319a() {
        return "gdt_plugin";
    }

    /* renamed from: a */
    public static void m20317a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m20314a(String str, File file) throws IOException {
        OutputStreamWriter outputStreamWriter;
        if (file == null) {
            throw new IOException("Target File Can not be null in StringUtil.writeTo");
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        } catch (Throwable th) {
            th = th;
        }
        try {
            outputStreamWriter.write(str);
            m20317a(outputStreamWriter);
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter2 = outputStreamWriter;
            m20317a(outputStreamWriter2);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m20316a(File file, File file2) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            return m20315a(new FileInputStream(file), file2);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m20315a(InputStream inputStream, File file) throws Throwable {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                GDTLogger.m20307e("parent dir not exists " + parentFile.getAbsolutePath());
                return false;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        m20317a(inputStream);
                        m20317a(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    GDTLogger.m20306e("Exception while copy from InputStream to File", th);
                    throw th;
                } finally {
                    m20317a(inputStream);
                    m20317a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static File m20313b(Context context) {
        return new File(context.getDir(f32941a, 0), "update_lc");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static File m20312c(Context context) {
        return new File(context.getDir(f32941a, 0), "gdt_plugin.next");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static File m20311d(Context context) {
        return new File(context.getDir(f32941a, 0), "gdt_plugin.next.sig");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static File m20310e(Context context) {
        return new File(context.getDir(f32941a, 0), "gdt_plugin.jar");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static File m20309f(Context context) {
        return new File(context.getDir(f32941a, 0), "gdt_plugin.jar.sig");
    }
}
