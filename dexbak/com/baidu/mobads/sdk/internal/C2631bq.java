package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* renamed from: com.baidu.mobads.sdk.internal.bq */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2631bq {

    /* renamed from: a */
    public static final String f8721a = "IOUtils";

    /* renamed from: a */
    public static boolean m50755a(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists()) {
                return file.renameTo(file2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m50757a(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    fileOutputStream.close();
                    inputStream.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static void m50759a(Context context, String str, String str2) {
        try {
            m50757a(context.getAssets().open(str), str2);
        } catch (Exception e) {
            C2634bs.m50744a().m50738a(e);
        }
    }

    /* renamed from: a */
    public static boolean m50758a(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m50756a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                return file.length() > 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
