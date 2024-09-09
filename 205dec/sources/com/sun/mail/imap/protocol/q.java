package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: RFC822DATA.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class q implements l {

    /* renamed from: c  reason: collision with root package name */
    static final char[] f50583c = {'R', 'F', 'C', '8', '2', '2'};

    /* renamed from: a  reason: collision with root package name */
    public int f50584a;

    /* renamed from: b  reason: collision with root package name */
    public com.sun.mail.iap.d f50585b;

    public q(f fVar) throws ParsingException {
        this.f50584a = fVar.E();
        fVar.B();
        this.f50585b = fVar.s();
    }

    public com.sun.mail.iap.d a() {
        return this.f50585b;
    }

    public ByteArrayInputStream b() {
        com.sun.mail.iap.d dVar = this.f50585b;
        if (dVar != null) {
            return dVar.g();
        }
        return null;
    }
}
