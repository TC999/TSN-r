package com.mbridge.msdk.foundation.same.net.c;

import android.text.TextUtils;

/* compiled from: Header.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f39496a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39497b;

    public b(String str, String str2) {
        this.f39496a = str;
        this.f39497b = str2;
    }

    public final String a() {
        return this.f39496a;
    }

    public final String b() {
        return this.f39497b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.f39496a, bVar.f39496a) && TextUtils.equals(this.f39497b, bVar.f39497b);
    }

    public final int hashCode() {
        return (this.f39496a.hashCode() * 31) + this.f39497b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.f39496a + ",value=" + this.f39497b + "]";
    }
}
