package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    private final File f41670a;

    /* renamed from: b  reason: collision with root package name */
    private final File f41671b;

    /* renamed from: c  reason: collision with root package name */
    private String f41672c;

    /* renamed from: d  reason: collision with root package name */
    private int f41673d;

    /* renamed from: e  reason: collision with root package name */
    private String f41674e;

    public g(File file, File file2) {
        this.f41670a = file;
        this.f41671b = file2;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        int i4;
        try {
            if (this.f41671b.exists() && this.f41670a.exists()) {
                String a4 = a(this.f41671b);
                this.f41674e = a4;
                if (TextUtils.isEmpty(a4)) {
                    return false;
                }
                String[] split = this.f41674e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i4 = Integer.parseInt(split[0]);
                    } catch (Throwable unused) {
                        i4 = 0;
                    }
                    if (c.b.f41668a.a(str, this.f41670a)) {
                        this.f41672c = str;
                        this.f41673d = i4;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(File file, File file2) {
        return (file.equals(this.f41670a) || h.a(this.f41670a, file)) && (file2.equals(this.f41671b) || h.a(this.f41671b, file2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f41672c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f41673d;
    }

    public String d() {
        return this.f41674e;
    }
}
