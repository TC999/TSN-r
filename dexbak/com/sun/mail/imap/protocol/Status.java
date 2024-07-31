package com.sun.mail.imap.protocol;

import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.ParsingException;

/* renamed from: com.sun.mail.imap.protocol.u */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Status {

    /* renamed from: g */
    static final String[] f36181g = {"MESSAGES", "RECENT", "UNSEEN", "UIDNEXT", "UIDVALIDITY"};

    /* renamed from: a */
    public String f36182a;

    /* renamed from: b */
    public int f36183b;

    /* renamed from: c */
    public int f36184c;

    /* renamed from: d */
    public long f36185d;

    /* renamed from: e */
    public long f36186e;

    /* renamed from: f */
    public int f36187f;

    public Status(C12728g c12728g) throws ParsingException {
        this.f36182a = null;
        this.f36183b = -1;
        this.f36184c = -1;
        this.f36185d = -1L;
        this.f36186e = -1L;
        this.f36187f = -1;
        this.f36182a = c12728g.m16390q();
        c12728g.m16408B();
        if (c12728g.m16389r() == 40) {
            do {
                String m16392o = c12728g.m16392o();
                if (m16392o.equalsIgnoreCase("MESSAGES")) {
                    this.f36183b = c12728g.m16385v();
                } else if (m16392o.equalsIgnoreCase("RECENT")) {
                    this.f36184c = c12728g.m16385v();
                } else if (m16392o.equalsIgnoreCase("UIDNEXT")) {
                    this.f36185d = c12728g.m16386u();
                } else if (m16392o.equalsIgnoreCase("UIDVALIDITY")) {
                    this.f36186e = c12728g.m16386u();
                } else if (m16392o.equalsIgnoreCase("UNSEEN")) {
                    this.f36187f = c12728g.m16385v();
                }
            } while (c12728g.m16389r() != 41);
            return;
        }
        throw new ParsingException("parse error in STATUS");
    }

    /* renamed from: a */
    public static void m16088a(Status status, Status status2) {
        int i = status2.f36183b;
        if (i != -1) {
            status.f36183b = i;
        }
        int i2 = status2.f36184c;
        if (i2 != -1) {
            status.f36184c = i2;
        }
        long j = status2.f36185d;
        if (j != -1) {
            status.f36185d = j;
        }
        long j2 = status2.f36186e;
        if (j2 != -1) {
            status.f36186e = j2;
        }
        int i3 = status2.f36187f;
        if (i3 != -1) {
            status.f36187f = i3;
        }
    }
}
