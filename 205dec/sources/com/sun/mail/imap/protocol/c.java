package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BODY.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c implements l {

    /* renamed from: e  reason: collision with root package name */
    static final char[] f50486e = {'B', 'O', 'D', 'Y'};

    /* renamed from: a  reason: collision with root package name */
    public int f50487a;

    /* renamed from: b  reason: collision with root package name */
    public com.sun.mail.iap.d f50488b;

    /* renamed from: c  reason: collision with root package name */
    public String f50489c;

    /* renamed from: d  reason: collision with root package name */
    public int f50490d;

    public c(f fVar) throws ParsingException {
        byte r3;
        this.f50490d = 0;
        this.f50487a = fVar.E();
        fVar.B();
        do {
            r3 = fVar.r();
            if (r3 == 93) {
                if (fVar.r() == 60) {
                    this.f50490d = fVar.v();
                    fVar.A(1);
                }
                this.f50488b = fVar.s();
                return;
            }
        } while (r3 != 0);
        throw new ParsingException("BODY parse error: missing ``]'' at section end");
    }

    public com.sun.mail.iap.d a() {
        return this.f50488b;
    }

    public ByteArrayInputStream b() {
        com.sun.mail.iap.d dVar = this.f50488b;
        if (dVar != null) {
            return dVar.g();
        }
        return null;
    }
}
