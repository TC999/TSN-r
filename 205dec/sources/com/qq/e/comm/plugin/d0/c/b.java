package com.qq.e.comm.plugin.d0.c;

import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.j2;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private final File f42233a;

    /* renamed from: b  reason: collision with root package name */
    private final File f42234b;

    public b(File file, File file2) {
        this.f42233a = file;
        this.f42234b = file2;
    }

    private void b(int i4) {
        v.b(9120037, null, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i4) {
        try {
            if (this.f42234b.exists() && this.f42233a.exists()) {
                String a4 = a(this.f42234b);
                if (TextUtils.isEmpty(a4)) {
                    b(1);
                    return false;
                }
                String[] split = a4.split("#####");
                if (split.length == 2) {
                    if (i4 != a(split[0], 0)) {
                        return false;
                    }
                    if (j2.a().a(split[1], this.f42233a)) {
                        return true;
                    }
                    b(2);
                    return false;
                }
                b(3);
            }
            return false;
        } catch (Throwable unused) {
            GDTLogger.d("Exception while checking plugin");
            b(4);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        if (file.equals(this.f42233a) || b1.a(this.f42233a, file)) {
            return file2.equals(this.f42234b) || b1.a(this.f42234b, file2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    private String a(File file) throws IOException {
        Throwable th;
        ?? r12 = 0;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                            return sb2;
                        } catch (IOException e4) {
                            throw e4;
                        }
                    } catch (IOException e5) {
                        throw e5;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r12 != 0) {
                            try {
                                r12.close();
                            } catch (Exception unused2) {
                                GDTLogger.d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                r12 = file;
                th = th3;
            }
        }
        return null;
    }

    private int a(String str, int i4) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i4;
        }
    }
}
