package com.qq.e.comm.dynamic;

import android.text.TextUtils;
import com.qq.e.comm.plugin.q.i;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private QuickJS f41611a;

    public a() {
        try {
            this.f41611a = QuickJS.a();
        } catch (Exception unused) {
            i.a();
        }
    }

    @Override // com.qq.e.comm.dynamic.b
    public void a() {
        if (b()) {
            this.f41611a.close();
            this.f41611a = null;
        }
    }

    @Override // com.qq.e.comm.dynamic.b
    public Object b(String str) throws Throwable {
        if (!b() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f41611a.a(str);
    }

    @Override // com.qq.e.comm.dynamic.b
    public <T> void a(String str, Class<T> cls, T t3) {
        if (b()) {
            this.f41611a.a(str, cls, t3);
        }
    }

    @Override // com.qq.e.comm.dynamic.b
    public boolean b() {
        return this.f41611a != null;
    }

    @Override // com.qq.e.comm.dynamic.b
    public Object a(byte[] bArr) throws Throwable {
        if (!b() || bArr == null || bArr.length <= 0) {
            return null;
        }
        return this.f41611a.a(bArr);
    }

    @Override // com.qq.e.comm.dynamic.b
    public byte[] a(String str) throws Throwable {
        if (!b() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f41611a.a(str, "?");
    }
}
