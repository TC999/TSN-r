package com.tencent.p562mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.opensdk.utils.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12989b {

    /* renamed from: a */
    public static Context f37215a;

    /* renamed from: b */
    private static final int f37216b;

    /* renamed from: c */
    private static final int f37217c;

    /* renamed from: d */
    private static final int f37218d;

    /* renamed from: e */
    public static ThreadPoolExecutor f37219e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f37216b = availableProcessors;
        int i = availableProcessors + 1;
        f37217c = i;
        int i2 = (availableProcessors * 2) + 1;
        f37218d = i2;
        f37219e = new ThreadPoolExecutor(i, i2, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    /* renamed from: a */
    public static int m15259a(ContentResolver contentResolver, Uri uri) {
        Log.m15263i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.m15261w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return 0;
                }
                int available = openInputStream.available();
                try {
                    openInputStream.close();
                } catch (IOException unused2) {
                }
                return available;
            } catch (Exception e) {
                Log.m15261w("MicroMsg.SDK.Util", "getFileSize fail, " + e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static int m15258a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f37215a != null && str.startsWith("content")) {
            try {
                return m15259a(f37215a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m15257a(String str, int i) {
        if (str != null) {
            try {
                return str.length() <= 0 ? i : Integer.parseInt(str);
            } catch (Exception unused) {
                return i;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m15260a(int i) {
        return i == 36 || i == 46;
    }

    /* renamed from: b */
    public static boolean m15256b(String str) {
        return str == null || str.length() <= 0;
    }
}
