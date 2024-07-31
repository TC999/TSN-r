package com.mbridge.msdk.foundation.same.net.p482c;

import android.text.TextUtils;

/* compiled from: Header.java */
/* renamed from: com.mbridge.msdk.foundation.same.net.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11336b {

    /* renamed from: a */
    private final String f30702a;

    /* renamed from: b */
    private final String f30703b;

    public C11336b(String str, String str2) {
        this.f30702a = str;
        this.f30703b = str2;
    }

    /* renamed from: a */
    public final String m22291a() {
        return this.f30702a;
    }

    /* renamed from: b */
    public final String m22290b() {
        return this.f30703b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C11336b.class != obj.getClass()) {
            return false;
        }
        C11336b c11336b = (C11336b) obj;
        return TextUtils.equals(this.f30702a, c11336b.f30702a) && TextUtils.equals(this.f30703b, c11336b.f30703b);
    }

    public final int hashCode() {
        return (this.f30702a.hashCode() * 31) + this.f30703b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.f30702a + ",value=" + this.f30703b + "]";
    }
}
