package com.sun.mail.iap;

import java.io.ByteArrayInputStream;

/* renamed from: com.sun.mail.iap.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ByteArray {

    /* renamed from: a */
    private byte[] f35846a;

    /* renamed from: b */
    private int f35847b;

    /* renamed from: c */
    private int f35848c;

    public ByteArray(byte[] bArr, int i, int i2) {
        this.f35846a = bArr;
        this.f35847b = i;
        this.f35848c = i2;
    }

    /* renamed from: a */
    public byte[] m16428a() {
        return this.f35846a;
    }

    /* renamed from: b */
    public int m16427b() {
        return this.f35848c;
    }

    /* renamed from: c */
    public byte[] m16426c() {
        int i = this.f35848c;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f35846a, this.f35847b, bArr, 0, i);
        return bArr;
    }

    /* renamed from: d */
    public int m16425d() {
        return this.f35847b;
    }

    /* renamed from: e */
    public void m16424e(int i) {
        byte[] bArr = this.f35846a;
        byte[] bArr2 = new byte[bArr.length + i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f35846a = bArr2;
    }

    /* renamed from: f */
    public void m16423f(int i) {
        this.f35848c = i;
    }

    /* renamed from: g */
    public ByteArrayInputStream m16422g() {
        return new ByteArrayInputStream(this.f35846a, this.f35847b, this.f35848c);
    }

    public ByteArray(int i) {
        this(new byte[i], 0, i);
    }
}
