package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ck;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TSerializer.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ca {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f52746a;

    /* renamed from: b  reason: collision with root package name */
    private final dc f52747b;

    /* renamed from: c  reason: collision with root package name */
    private cq f52748c;

    public ca() {
        this(new ck.a());
    }

    public byte[] a(br brVar) throws bx {
        this.f52746a.reset();
        brVar.write(this.f52748c);
        return this.f52746a.toByteArray();
    }

    public String b(br brVar) throws bx {
        return new String(a(brVar));
    }

    public ca(cs csVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f52746a = byteArrayOutputStream;
        dc dcVar = new dc(byteArrayOutputStream);
        this.f52747b = dcVar;
        this.f52748c = csVar.a(dcVar);
    }

    public String a(br brVar, String str) throws bx {
        try {
            return new String(a(brVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bx("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
