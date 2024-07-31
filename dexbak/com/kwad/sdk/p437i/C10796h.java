package com.kwad.sdk.p437i;

import android.text.TextUtils;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.p437i.C10791e;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.i.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10796h {
    private static final float anQ = new Random().nextFloat();

    /* renamed from: JB */
    private final AtomicBoolean f29660JB;
    private final AtomicBoolean aJf;
    private C10790d aJg;
    private C10795g aJh;
    private List<C10799i> aJi;
    private InterfaceC10794f aJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.i.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10798a {
        private static final C10796h aJm = new C10796h((byte) 0);
    }

    /* synthetic */ C10796h(byte b) {
        this();
    }

    /* renamed from: Jc */
    public static C10796h m24844Jc() {
        return C10798a.aJm;
    }

    /* renamed from: Jj */
    private void m24837Jj() {
        List<C10799i> list = this.aJi;
        if (list == null) {
            return;
        }
        for (C10799i c10799i : list) {
            m24826b(c10799i);
        }
        this.aJi.clear();
        this.aJi = null;
    }

    /* renamed from: b */
    private void m24826b(final C10799i c10799i) {
        C10790d c10790d = this.aJg;
        if (c10790d == null || C10800j.m24814I(c10790d.aIS) || this.aJh == null || this.aJj == null) {
            return;
        }
        C10800j.m24810a(new AbstractRunnableC10807n() { // from class: com.kwad.sdk.i.h.1
            @Override // com.kwad.sdk.p437i.AbstractRunnableC10807n
            public final void doTask() {
                C10796h c10796h = C10796h.this;
                C10791e m24836a = c10796h.m24836a(c10796h.aJg, c10799i);
                if (m24836a == null) {
                    return;
                }
                c10799i.m24815n(m24836a.aor);
                C10805m.m24794a(c10799i, m24836a.aIT == 2);
            }
        });
    }

    /* renamed from: c */
    private boolean m24824c(C10791e.C10793b c10793b) {
        List<String> list = c10793b.aEZ;
        if (C10800j.m24814I(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(this.aJh.getSdkVersion(), str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m24823d(com.kwad.sdk.p437i.C10791e.C10793b r8) {
        /*
            r7 = this;
            com.kwad.sdk.i.g r0 = r7.aJh
            java.lang.String r0 = r0.getAndroidId()
            com.kwad.sdk.i.g r1 = r7.aJh
            java.lang.String r1 = r1.getDeviceId()
            com.kwad.sdk.i.g r2 = r7.aJh
            java.lang.String r2 = r2.getImei()
            com.kwad.sdk.i.g r3 = r7.aJh
            java.lang.String r3 = r3.getOaid()
            java.util.List<java.lang.String> r8 = r8.aJb
            boolean r4 = com.kwad.sdk.p437i.C10800j.m24814I(r8)
            r5 = 1
            if (r4 == 0) goto L22
            return r5
        L22:
            java.util.Iterator r8 = r8.iterator()
        L26:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L4e
            java.lang.Object r4 = r8.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r6 = android.text.TextUtils.equals(r4, r0)
            if (r6 == 0) goto L39
            return r5
        L39:
            boolean r6 = android.text.TextUtils.equals(r4, r1)
            if (r6 == 0) goto L40
            return r5
        L40:
            boolean r6 = android.text.TextUtils.equals(r4, r2)
            if (r6 == 0) goto L47
            return r5
        L47:
            boolean r4 = android.text.TextUtils.equals(r4, r3)
            if (r4 == 0) goto L26
            return r5
        L4e:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.p437i.C10796h.m24823d(com.kwad.sdk.i.e$b):boolean");
    }

    /* renamed from: fU */
    private static C10790d m24821fU(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            C10790d c10790d = new C10790d();
            c10790d.parseJson(jSONObject);
            return c10790d;
        } catch (Throwable unused) {
            C10800j.m24813Jm();
            return null;
        }
    }

    /* renamed from: Jd */
    public final void m24843Jd() {
        if (!this.f29660JB.get() || this.aJg == null) {
            return;
        }
        C10800j.m24812Jn();
        C10805m.m24795Jp();
    }

    /* renamed from: Je */
    public final synchronized void m24842Je() {
        this.aJf.set(true);
    }

    /* renamed from: Jf */
    public final synchronized void m24841Jf() {
        this.aJf.set(false);
    }

    /* renamed from: Jg */
    public final C10795g m24840Jg() {
        return this.aJh;
    }

    /* renamed from: Jh */
    public final InterfaceC10794f m24839Jh() {
        return this.aJj;
    }

    /* renamed from: Ji */
    public final long m24838Ji() {
        return this.aJg.m24865IV();
    }

    /* renamed from: f */
    public final void m24822f(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.aJf.get()) {
                    C10800j.m24812Jn();
                    return;
                }
                C10799i m24816fX = C10799i.m24819Jl().m24818fV(str).m24817fW(str2).m24816fX(str3);
                if (this.f29660JB.get()) {
                    m24826b(m24816fX);
                    return;
                }
                C10800j.m24812Jn();
                m24830a(m24816fX);
            }
        } catch (Throwable unused) {
            C10800j.m24813Jm();
        }
    }

    private C10796h() {
        this.f29660JB = new AtomicBoolean(false);
        this.aJf = new AtomicBoolean(false);
    }

    /* renamed from: b */
    private boolean m24827b(C10791e.C10793b c10793b) {
        List<String> list = c10793b.aEY;
        if (C10800j.m24814I(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(this.aJh.getAppId(), str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void m24829a(String str, C10795g c10795g, InterfaceC10794f interfaceC10794f) {
        if (this.f29660JB.get()) {
            return;
        }
        try {
            C10800j.m24812Jn();
            this.aJh = c10795g;
            this.aJj = interfaceC10794f;
            this.aJg = m24821fU(str);
            this.f29660JB.set(true);
            m24837Jj();
        } catch (Throwable unused) {
            C10800j.m24813Jm();
        }
    }

    /* renamed from: c */
    private static boolean m24825c(C10791e.C10792a c10792a, String str) {
        List<String> list = c10792a.aIY;
        if (C10800j.m24814I(list)) {
            return true;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m24828b(C10791e.C10792a c10792a, String str) {
        List<String> list = c10792a.aIX;
        if (C10800j.m24814I(list)) {
            return true;
        }
        for (String str2 : list) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m24830a(C10799i c10799i) {
        if (this.aJi == null) {
            this.aJi = new CopyOnWriteArrayList();
        }
        this.aJi.add(c10799i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C10791e m24836a(C10790d c10790d, C10799i c10799i) {
        List<C10791e> list = c10790d.aIS;
        if (C10800j.m24814I(list)) {
            return null;
        }
        for (C10791e c10791e : list) {
            if (m24833a(c10791e.aIU) && m24835a(c10791e.aIV, c10799i)) {
                double d = c10791e.aor;
                if (d > Utils.DOUBLE_EPSILON && anQ <= d) {
                    return c10791e;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m24833a(C10791e.C10793b c10793b) {
        if (c10793b.aJc != C10791e.C10793b.aIZ) {
            return c10793b.m24864IW();
        }
        c10793b.m24863bD(m24827b(c10793b) && m24824c(c10793b) && m24823d(c10793b));
        return c10793b.m24864IW();
    }

    /* renamed from: a */
    private boolean m24835a(C10791e.C10792a c10792a, C10799i c10799i) {
        return m24834a(c10792a, c10799i.aJn) && m24828b(c10792a, c10799i.aJo) && m24825c(c10792a, c10799i.aJp);
    }

    /* renamed from: a */
    private static boolean m24834a(C10791e.C10792a c10792a, String str) {
        List<String> list = c10792a.aIW;
        if (C10800j.m24814I(list)) {
            return true;
        }
        for (String str2 : list) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }
}
