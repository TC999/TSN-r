package com.bytedance.sdk.component.w.c.c.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.w.c.bk;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.ia;
import com.bytedance.sdk.component.w.c.k;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.component.xv.w.z;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends fp {

    /* renamed from: c  reason: collision with root package name */
    HttpURLConnection f30394c;
    public long sr;
    z ux = null;

    /* renamed from: w  reason: collision with root package name */
    t f30395w;
    public long xv;

    public f(HttpURLConnection httpURLConnection, t tVar) {
        this.f30394c = httpURLConnection;
        this.f30395w = tVar;
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public long c() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.component.w.c.fp, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            f().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public bk ev() {
        return bk.HTTP_1_1;
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public ia f() {
        try {
            return new r(this.f30394c);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public k gd() {
        return new k(this.ux);
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public com.bytedance.sdk.component.w.c.f r() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.f30394c.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!"Content-Range".equalsIgnoreCase(entry.getKey()) || xv() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.w.c.f((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public boolean sr() {
        return xv() >= 200 && xv() < 300;
    }

    public String toString() {
        return "";
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public String ux() throws IOException {
        return this.f30394c.getResponseMessage();
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public long w() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public int xv() {
        try {
            return this.f30394c.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public String c(String str) {
        return this.f30394c.getHeaderField(str);
    }

    @Override // com.bytedance.sdk.component.w.c.fp
    public String c(String str, String str2) {
        return !TextUtils.isEmpty(c(str)) ? c(str) : str2;
    }
}
