package com.kwad.sdk.i;

import android.text.TextUtils;
import com.kwad.sdk.i.e;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {
    private static final float anQ = new Random().nextFloat();
    private final AtomicBoolean JB;
    private final AtomicBoolean aJf;
    private d aJg;
    private g aJh;
    private List<i> aJi;
    private f aJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private static final h aJm = new h((byte) 0);
    }

    /* synthetic */ h(byte b4) {
        this();
    }

    public static h Jc() {
        return a.aJm;
    }

    private void Jj() {
        List<i> list = this.aJi;
        if (list == null) {
            return;
        }
        for (i iVar : list) {
            b(iVar);
        }
        this.aJi.clear();
        this.aJi = null;
    }

    private void b(final i iVar) {
        d dVar = this.aJg;
        if (dVar == null || j.I(dVar.aIS) || this.aJh == null || this.aJj == null) {
            return;
        }
        j.a(new n() { // from class: com.kwad.sdk.i.h.1
            @Override // com.kwad.sdk.i.n
            public final void doTask() {
                h hVar = h.this;
                e a4 = hVar.a(hVar.aJg, iVar);
                if (a4 == null) {
                    return;
                }
                iVar.n(a4.aor);
                m.a(iVar, a4.aIT == 2);
            }
        });
    }

    private boolean c(e.b bVar) {
        List<String> list = bVar.aEZ;
        if (j.I(list)) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(com.kwad.sdk.i.e.b r8) {
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
            boolean r4 = com.kwad.sdk.i.j.I(r8)
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.i.h.d(com.kwad.sdk.i.e$b):boolean");
    }

    private static d fU(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Throwable unused) {
            j.Jm();
            return null;
        }
    }

    public final void Jd() {
        if (!this.JB.get() || this.aJg == null) {
            return;
        }
        j.Jn();
        m.Jp();
    }

    public final synchronized void Je() {
        this.aJf.set(true);
    }

    public final synchronized void Jf() {
        this.aJf.set(false);
    }

    public final g Jg() {
        return this.aJh;
    }

    public final f Jh() {
        return this.aJj;
    }

    public final long Ji() {
        return this.aJg.IV();
    }

    public final void f(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.aJf.get()) {
                    j.Jn();
                    return;
                }
                i fX = i.Jl().fV(str).fW(str2).fX(str3);
                if (this.JB.get()) {
                    b(fX);
                    return;
                }
                j.Jn();
                a(fX);
            }
        } catch (Throwable unused) {
            j.Jm();
        }
    }

    private h() {
        this.JB = new AtomicBoolean(false);
        this.aJf = new AtomicBoolean(false);
    }

    private boolean b(e.b bVar) {
        List<String> list = bVar.aEY;
        if (j.I(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(this.aJh.getAppId(), str)) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str, g gVar, f fVar) {
        if (this.JB.get()) {
            return;
        }
        try {
            j.Jn();
            this.aJh = gVar;
            this.aJj = fVar;
            this.aJg = fU(str);
            this.JB.set(true);
            Jj();
        } catch (Throwable unused) {
            j.Jm();
        }
    }

    private static boolean c(e.a aVar, String str) {
        List<String> list = aVar.aIY;
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
        List<String> list = aVar.aIX;
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
        if (this.aJi == null) {
            this.aJi = new CopyOnWriteArrayList();
        }
        this.aJi.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(d dVar, i iVar) {
        List<e> list = dVar.aIS;
        if (j.I(list)) {
            return null;
        }
        for (e eVar : list) {
            if (a(eVar.aIU) && a(eVar.aIV, iVar)) {
                double d4 = eVar.aor;
                if (d4 > 0.0d && anQ <= d4) {
                    return eVar;
                }
            }
        }
        return null;
    }

    private boolean a(e.b bVar) {
        if (bVar.aJc != e.b.aIZ) {
            return bVar.IW();
        }
        bVar.bD(b(bVar) && c(bVar) && d(bVar));
        return bVar.IW();
    }

    private boolean a(e.a aVar, i iVar) {
        return a(aVar, iVar.aJn) && b(aVar, iVar.aJo) && c(aVar, iVar.aJp);
    }

    private static boolean a(e.a aVar, String str) {
        List<String> list = aVar.aIW;
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
