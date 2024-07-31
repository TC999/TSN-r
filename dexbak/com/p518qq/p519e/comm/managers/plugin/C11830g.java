package com.p518qq.p519e.comm.managers.plugin;

import android.text.TextUtils;
import com.p518qq.p519e.comm.managers.plugin.C11824c;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: com.qq.e.comm.managers.plugin.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C11830g {

    /* renamed from: a */
    private final File f32936a;

    /* renamed from: b */
    private final File f32937b;

    /* renamed from: c */
    private String f32938c;

    /* renamed from: d */
    private int f32939d;

    /* renamed from: e */
    private String f32940e;

    public C11830g(File file, File file2) {
        this.f32936a = file;
        this.f32937b = file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* renamed from: a */
    private String m20324a(File file) throws IOException {
        Throwable th;
        ?? r1 = 0;
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
                                GDTLogger.m20308d("Exception while close bufferreader");
                            }
                            return sb2;
                        } catch (IOException e) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r1 != 0) {
                            try {
                                r1.close();
                            } catch (Exception unused2) {
                                GDTLogger.m20308d("Exception while close bufferreader");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                r1 = file;
                th = th3;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m20325a() {
        int i;
        try {
            if (this.f32937b.exists() && this.f32936a.exists()) {
                String m20324a = m20324a(this.f32937b);
                this.f32940e = m20324a;
                if (TextUtils.isEmpty(m20324a)) {
                    return false;
                }
                String[] split = this.f32940e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    try {
                        i = Integer.parseInt(split[0]);
                    } catch (Throwable unused) {
                        i = 0;
                    }
                    if (C11824c.C11826b.f32934a.m20330a(str, this.f32936a)) {
                        this.f32938c = str;
                        this.f32939d = i;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused2) {
            GDTLogger.m20308d("Exception while checking plugin");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m20323a(File file, File file2) {
        return (file.equals(this.f32936a) || C11831h.m20316a(this.f32936a, file)) && (file2.equals(this.f32937b) || C11831h.m20316a(this.f32937b, file2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public String m20322b() {
        return this.f32938c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m20321c() {
        return this.f32939d;
    }

    /* renamed from: d */
    public String m20320d() {
        return this.f32940e;
    }
}
