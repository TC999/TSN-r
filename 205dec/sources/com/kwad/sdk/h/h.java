package com.kwad.sdk.h;

import android.text.TextUtils;
import com.kwad.sdk.h.e;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class h {
    private static final float aoT = new Random().nextFloat();
    private final AtomicBoolean Kc;
    private final AtomicBoolean aKu;
    private d aKv;
    private g aKw;
    private List<i> aKx;
    private f aKy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class a {
        private static final h aKB = new h((byte) 0);
    }

    /* synthetic */ h(byte b4) {
        this();
    }

    public static h JN() {
        return a.aKB;
    }

    private void JU() {
        List<i> list = this.aKx;
        if (list == null) {
            return;
        }
        for (i iVar : list) {
            b(iVar);
        }
        this.aKx.clear();
        this.aKx = null;
    }

    private void b(final i iVar) {
        d dVar = this.aKv;
        if (dVar == null || j.I(dVar.aKh) || this.aKw == null || this.aKy == null) {
            return;
        }
        j.a(new n() { // from class: com.kwad.sdk.h.h.1
            @Override // com.kwad.sdk.h.n
            public final void doTask() {
                h hVar = h.this;
                e a4 = hVar.a(hVar.aKv, iVar);
                if (a4 == null) {
                    return;
                }
                iVar.n(a4.apu);
                m.a(iVar, a4.aKi == 2);
            }
        });
    }

    private boolean c(e.b bVar) {
        List<String> list = bVar.aGn;
        if (j.I(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(this.aKw.getSdkVersion(), str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(com.kwad.sdk.h.e.b r8) {
        /*
            r7 = this;
            com.kwad.sdk.h.g r0 = r7.aKw
            java.lang.String r0 = r0.getAndroidId()
            com.kwad.sdk.h.g r1 = r7.aKw
            java.lang.String r1 = r1.getDeviceId()
            com.kwad.sdk.h.g r2 = r7.aKw
            java.lang.String r2 = r2.getImei()
            com.kwad.sdk.h.g r3 = r7.aKw
            java.lang.String r3 = r3.getOaid()
            java.util.List<java.lang.String> r8 = r8.aKq
            boolean r4 = com.kwad.sdk.h.j.I(r8)
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.h.h.d(com.kwad.sdk.h.e$b):boolean");
    }

    private static d gh(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Throwable unused) {
            j.JX();
            return null;
        }
    }

    public final void JO() {
        if (!this.Kc.get() || this.aKv == null) {
            return;
        }
        j.JY();
        m.Ka();
    }

    public final synchronized void JP() {
        this.aKu.set(true);
    }

    public final synchronized void JQ() {
        this.aKu.set(false);
    }

    public final g JR() {
        return this.aKw;
    }

    public final f JS() {
        return this.aKy;
    }

    public final long JT() {
        return this.aKv.JG();
    }

    public final void f(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.aKu.get()) {
                    j.JY();
                    return;
                }
                i gk = i.JW().gi(str).gj(str2).gk(str3);
                if (this.Kc.get()) {
                    b(gk);
                    return;
                }
                j.JY();
                a(gk);
            }
        } catch (Throwable unused) {
            j.JX();
        }
    }

    private h() {
        this.Kc = new AtomicBoolean(false);
        this.aKu = new AtomicBoolean(false);
    }

    private boolean b(e.b bVar) {
        List<String> list = bVar.aGm;
        if (j.I(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(this.aKw.getAppId(), str)) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str, g gVar, f fVar) {
        if (this.Kc.get()) {
            return;
        }
        try {
            j.JY();
            this.aKw = gVar;
            this.aKy = fVar;
            this.aKv = gh(str);
            this.Kc.set(true);
            JU();
        } catch (Throwable unused) {
            j.JX();
        }
    }

    private static boolean c(e.a aVar, String str) {
        List<String> list = aVar.aKn;
        if (j.I(list)) {
            return true;
        }
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(e.a aVar, String str) {
        List<String> list = aVar.aKm;
        if (j.I(list)) {
            return true;
        }
        for (String str2 : list) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    private void a(i iVar) {
        if (this.aKx == null) {
            this.aKx = new CopyOnWriteArrayList();
        }
        this.aKx.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(d dVar, i iVar) {
        List<e> list = dVar.aKh;
        if (j.I(list)) {
            return null;
        }
        for (e eVar : list) {
            if (a(eVar.aKj) && a(eVar.aKk, iVar)) {
                double d4 = eVar.apu;
                if (d4 > 0.0d && aoT <= d4) {
                    return eVar;
                }
            }
        }
        return null;
    }

    private boolean a(e.b bVar) {
        if (bVar.aKr != e.b.aKo) {
            return bVar.JH();
        }
        bVar.bD(b(bVar) && c(bVar) && d(bVar));
        return bVar.JH();
    }

    private boolean a(e.a aVar, i iVar) {
        return a(aVar, iVar.aKC) && b(aVar, iVar.aKD) && c(aVar, iVar.aKE);
    }

    private static boolean a(e.a aVar, String str) {
        List<String> list = aVar.aKl;
        if (j.I(list)) {
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
