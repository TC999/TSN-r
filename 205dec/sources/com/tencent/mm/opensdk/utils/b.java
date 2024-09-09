package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f51615a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f51616b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f51617c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f51618d;

    /* renamed from: e  reason: collision with root package name */
    public static ThreadPoolExecutor f51619e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f51616b = availableProcessors;
        int i4 = availableProcessors + 1;
        f51617c = i4;
        int i5 = (availableProcessors * 2) + 1;
        f51618d = i5;
        f51619e = new ThreadPoolExecutor(i4, i5, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    public static int a(ContentResolver contentResolver, Uri uri) {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
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
            } catch (Exception e4) {
                Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e4.getMessage());
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

    public static int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f51615a != null && str.startsWith("content")) {
            try {
                return a(f51615a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int a(String str, int i4) {
        if (str != null) {
            try {
                return str.length() <= 0 ? i4 : Integer.parseInt(str);
            } catch (Exception unused) {
                return i4;
            }
        }
        return i4;
    }

    public static boolean a(int i4) {
        return i4 == 36 || i4 == 46;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }
}
