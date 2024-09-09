package com.qq.e.comm.plugin.p.j.o;

import android.text.TextUtils;
import com.qq.e.comm.plugin.i0.e;
import com.qq.e.comm.plugin.i0.k;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f45286a;

    /* renamed from: b  reason: collision with root package name */
    private final int f45287b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f45288c;

    /* renamed from: d  reason: collision with root package name */
    private String f45289d;

    public b(int i4, int i5, boolean z3) {
        this.f45286a = i4;
        this.f45287b = i5;
        this.f45288c = z3;
    }

    public a a(String str, long j4, long j5, boolean z3) throws IOException {
        HttpURLConnection a4 = a(str, j4, j5);
        if (z3) {
            a4.setRequestMethod("HEAD");
        } else {
            a4.setRequestMethod("GET");
        }
        return new a(a4, 0, null);
    }

    private HttpURLConnection a(String str, long j4, long j5) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(e.a(str, 2)).openConnection();
        String str2 = this.f45289d;
        if (str2 != null && !str2.startsWith("null")) {
            httpURLConnection.setRequestProperty(k.b(), k.a(this.f45289d));
        } else {
            httpURLConnection.setRequestProperty(k.b(), k.a());
        }
        httpURLConnection.setConnectTimeout(this.f45286a);
        httpURLConnection.setReadTimeout(this.f45287b);
        if (this.f45288c) {
            String a4 = a(j4, j5);
            if (!TextUtils.isEmpty(a4)) {
                httpURLConnection.setRequestProperty("Range", a4);
            }
        }
        return httpURLConnection;
    }

    private String a(long j4, long j5) {
        if (j4 >= 0) {
            if (j5 > 0) {
                return "bytes=" + j4 + "-" + ((j4 + j5) - 1);
            }
            return "bytes=" + j4 + "-";
        }
        return null;
    }

    public void a(String str) {
        this.f45289d = str;
    }
}
