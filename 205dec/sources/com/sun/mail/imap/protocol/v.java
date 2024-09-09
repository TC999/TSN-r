package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UID.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class v implements l {

    /* renamed from: c  reason: collision with root package name */
    static final char[] f50598c = {'U', 'I', 'D'};

    /* renamed from: a  reason: collision with root package name */
    public int f50599a;

    /* renamed from: b  reason: collision with root package name */
    public long f50600b;

    public v(f fVar) throws ParsingException {
        this.f50599a = fVar.E();
        fVar.B();
        this.f50600b = fVar.u();
    }
}
