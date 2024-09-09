package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Status.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class u {

    /* renamed from: g  reason: collision with root package name */
    static final String[] f50591g = {"MESSAGES", "RECENT", "UNSEEN", "UIDNEXT", "UIDVALIDITY"};

    /* renamed from: a  reason: collision with root package name */
    public String f50592a;

    /* renamed from: b  reason: collision with root package name */
    public int f50593b;

    /* renamed from: c  reason: collision with root package name */
    public int f50594c;

    /* renamed from: d  reason: collision with root package name */
    public long f50595d;

    /* renamed from: e  reason: collision with root package name */
    public long f50596e;

    /* renamed from: f  reason: collision with root package name */
    public int f50597f;

    public u(com.sun.mail.iap.g gVar) throws ParsingException {
        this.f50592a = null;
        this.f50593b = -1;
        this.f50594c = -1;
        this.f50595d = -1L;
        this.f50596e = -1L;
        this.f50597f = -1;
        this.f50592a = gVar.q();
        gVar.B();
        if (gVar.r() == 40) {
            do {
                String o4 = gVar.o();
                if (o4.equalsIgnoreCase("MESSAGES")) {
                    this.f50593b = gVar.v();
                } else if (o4.equalsIgnoreCase("RECENT")) {
                    this.f50594c = gVar.v();
                } else if (o4.equalsIgnoreCase("UIDNEXT")) {
                    this.f50595d = gVar.u();
                } else if (o4.equalsIgnoreCase("UIDVALIDITY")) {
                    this.f50596e = gVar.u();
                } else if (o4.equalsIgnoreCase("UNSEEN")) {
                    this.f50597f = gVar.v();
                }
            } while (gVar.r() != 41);
            return;
        }
        throw new ParsingException("parse error in STATUS");
    }

    public static void a(u uVar, u uVar2) {
        int i4 = uVar2.f50593b;
        if (i4 != -1) {
            uVar.f50593b = i4;
        }
        int i5 = uVar2.f50594c;
        if (i5 != -1) {
            uVar.f50594c = i5;
        }
        long j4 = uVar2.f50595d;
        if (j4 != -1) {
            uVar.f50595d = j4;
        }
        long j5 = uVar2.f50596e;
        if (j5 != -1) {
            uVar.f50596e = j5;
        }
        int i6 = uVar2.f50597f;
        if (i6 != -1) {
            uVar.f50597f = i6;
        }
    }
}
