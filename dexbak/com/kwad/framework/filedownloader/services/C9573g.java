package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.InterfaceC9583y;
import com.kwad.framework.filedownloader.download.C9470b;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p351d.C9461a;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p351d.C9466d;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.framework.filedownloader.services.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9573g implements InterfaceC9583y {
    private final C9574h aia = new C9574h(C9470b.m28631vo().m28628vr());

    /* renamed from: bI */
    private boolean m28374bI(int i) {
        return mo28318a(m28366wD().mo28780bk(i));
    }

    /* renamed from: wD */
    private static InterfaceC9440a m28366wD() {
        return C9470b.m28631vo().m28629vq();
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9583y
    /* renamed from: a */
    public final boolean mo28318a(C9464c c9464c) {
        if (c9464c == null) {
            return false;
        }
        boolean m28362bK = this.aia.m28362bK(c9464c.getId());
        if (C9466d.m28676bF(c9464c.m28687tV())) {
            if (!m28362bK) {
                return false;
            }
        } else if (!m28362bK) {
            C9498d.m28538a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(c9464c.getId()), Byte.valueOf(c9464c.m28687tV()));
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0178 A[Catch: all -> 0x01c1, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0033, B:12:0x0041, B:14:0x004b, B:16:0x004f, B:17:0x0062, B:21:0x0070, B:23:0x0076, B:25:0x007a, B:29:0x008b, B:31:0x0094, B:33:0x009d, B:35:0x00a1, B:40:0x00b4, B:43:0x00bd, B:45:0x00c6, B:47:0x00d5, B:49:0x00d9, B:51:0x00ea, B:55:0x00f4, B:57:0x00fb, B:59:0x0102, B:61:0x0108, B:63:0x010f, B:65:0x0115, B:67:0x011b, B:69:0x0131, B:70:0x0135, B:72:0x013b, B:81:0x0178, B:82:0x017b, B:73:0x0148, B:75:0x0152, B:77:0x0158, B:78:0x015e, B:44:0x00c2, B:30:0x0090), top: B:90:0x0009 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m28375b(java.lang.String r20, java.lang.String r21, boolean r22, int r23, int r24, int r25, boolean r26, com.kwad.framework.filedownloader.p351d.C9462b r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.services.C9573g.m28375b(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.kwad.framework.filedownloader.d.b, boolean):void");
    }

    /* renamed from: bJ */
    public final long m28373bJ(int i) {
        InterfaceC9440a m28366wD = m28366wD();
        C9464c mo28780bk = m28366wD.mo28780bk(i);
        if (mo28780bk == null) {
            return 0L;
        }
        int m28680wo = mo28780bk.m28680wo();
        if (m28680wo <= 1) {
            return mo28780bk.m28683wl();
        }
        List<C9461a> mo28779bl = m28366wD.mo28779bl(i);
        if (mo28779bl == null || mo28779bl.size() != m28680wo) {
            return 0L;
        }
        return C9461a.m28709r(mo28779bl);
    }

    /* renamed from: bd */
    public final boolean m28372bd(int i) {
        if (C9498d.ail) {
            C9498d.m28535c(this, "request pause the task %d", Integer.valueOf(i));
        }
        C9464c mo28780bk = m28366wD().mo28780bk(i);
        if (mo28780bk == null) {
            return false;
        }
        mo28780bk.m28690d((byte) -2);
        this.aia.cancel(i);
        return true;
    }

    /* renamed from: be */
    public final byte m28371be(int i) {
        C9464c mo28780bk = m28366wD().mo28780bk(i);
        if (mo28780bk == null) {
            return (byte) 0;
        }
        return mo28780bk.m28687tV();
    }

    /* renamed from: bf */
    public final boolean m28370bf(int i) {
        if (i == 0) {
            C9498d.m28534d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        } else if (m28374bI(i)) {
            C9498d.m28534d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        } else {
            InterfaceC9440a m28366wD = m28366wD();
            m28366wD.mo28777bn(i);
            m28366wD.mo28778bm(i);
            return true;
        }
    }

    /* renamed from: bx */
    public final synchronized boolean m28369bx(int i) {
        return this.aia.m28361bx(i);
    }

    /* renamed from: bz */
    public final long m28368bz(int i) {
        C9464c mo28780bk = m28366wD().mo28780bk(i);
        if (mo28780bk == null) {
            return 0L;
        }
        return mo28780bk.getTotal();
    }

    public final boolean isIdle() {
        return this.aia.m28358wG() <= 0;
    }

    @Override // com.kwad.framework.filedownloader.InterfaceC9583y
    /* renamed from: p */
    public final int mo28317p(String str, int i) {
        return this.aia.m28360p(str, i);
    }

    /* renamed from: vV */
    public final void m28367vV() {
        m28366wD().clear();
    }

    /* renamed from: wE */
    public final void m28365wE() {
        List<Integer> m28357wH = this.aia.m28357wH();
        if (C9498d.ail) {
            C9498d.m28535c(this, "pause all tasks %d", Integer.valueOf(m28357wH.size()));
        }
        for (Integer num : m28357wH) {
            m28372bd(num.intValue());
        }
    }

    /* renamed from: y */
    public final boolean m28364y(String str, String str2) {
        return m28374bI(C9501f.m28528A(str, str2));
    }
}
