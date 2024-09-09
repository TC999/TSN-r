package com.qq.e.comm.plugin.dl;

import android.text.TextUtils;
import com.qq.e.comm.plugin.k0.f.e;
import com.qq.e.comm.plugin.util.d1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class o extends b implements com.qq.e.dl.e, com.qq.e.comm.plugin.k0.f.d {
    @Deprecated

    /* renamed from: q  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.k0.f.d> f42499q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private boolean f42500r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f42501s = false;

    private void k() {
        com.qq.e.dl.l.d dVar;
        WeakReference<com.qq.e.dl.l.d> weakReference = this.f42370i;
        if (weakReference == null || !this.f42500r || (dVar = weakReference.get()) == null) {
            return;
        }
        this.f42500r = false;
        for (Map.Entry<com.qq.e.dl.l.h, com.qq.e.dl.l.j.c> entry : this.f42366e.entrySet()) {
            com.qq.e.dl.l.j.c value = entry.getValue();
            if (value.f47127h) {
                dVar.c(entry.getKey(), value);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a() {
    }

    @Override // com.qq.e.dl.e
    @Deprecated
    public void a(com.qq.e.comm.plugin.k0.f.d dVar) {
        this.f42499q.add(dVar);
    }

    @Override // com.qq.e.dl.e
    @Deprecated
    public void b(com.qq.e.comm.plugin.k0.f.d dVar) {
        this.f42499q.remove(dVar);
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void c() {
        for (com.qq.e.comm.plugin.k0.f.d dVar : this.f42499q) {
            dVar.c();
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.dl.b
    public void g() {
        super.g();
        int e4 = com.qq.e.comm.plugin.k0.c.e(this.f42364c, this.f42369h);
        com.qq.e.comm.plugin.k0.f.e a4 = e.a.a(e4, com.qq.e.comm.plugin.k0.c.d(this.f42364c, this.f42369h), com.qq.e.comm.plugin.k0.c.b(this.f42364c));
        if (a4 != null) {
            com.qq.e.comm.plugin.k0.c.a(this.f42364c, a4, "startTwist");
            a4.a(this);
            if (this.f42501s) {
                int a5 = com.qq.e.comm.plugin.k0.c.a(this.f42369h);
                if (a5 > 0) {
                    e4 = a5;
                }
                a4.a(e4);
            }
        }
        this.f42365d = a4;
        this.f42376o = com.qq.e.comm.plugin.k0.c.c();
    }

    @Override // com.qq.e.comm.plugin.dl.b, com.qq.e.dl.c
    public void stop() {
        super.stop();
        k();
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a(int i4, int i5, int i6, int i7, float f4) {
        com.qq.e.dl.l.d dVar = this.f42370i.get();
        if (dVar == null) {
            return;
        }
        for (com.qq.e.comm.plugin.k0.f.d dVar2 : this.f42499q) {
            dVar2.a(i4, i5, i6, i7, f4);
        }
        if (f4 < this.f42376o) {
            this.f42377p = false;
        } else if (!this.f42377p) {
            this.f42377p = true;
            this.f42375n = System.currentTimeMillis();
            d1.a("gdt_tag_sensor", "onTwist mMotionStartTime = " + this.f42375n);
        }
        if (this.f42367f) {
            if (this.f42500r) {
                for (Map.Entry<com.qq.e.dl.l.h, com.qq.e.dl.l.j.c> entry : this.f42366e.entrySet()) {
                    com.qq.e.dl.l.j.c value = entry.getValue();
                    if (value.f47127h) {
                        a(value, f4, i4, i5, i6, 0L);
                        dVar.a(entry.getKey(), value, f4);
                    }
                }
                return;
            }
            this.f42500r = true;
            for (Map.Entry<com.qq.e.dl.l.h, com.qq.e.dl.l.j.c> entry2 : this.f42366e.entrySet()) {
                com.qq.e.dl.l.j.c value2 = entry2.getValue();
                if (value2.f47127h) {
                    a(value2, f4, i4, i5, i6, 0L);
                    dVar.a(entry2.getKey(), value2);
                }
            }
        }
    }

    @Override // com.qq.e.dl.e
    public void b() {
        this.f42501s = true;
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a(int i4, int i5, int i6, int i7, long j4) {
        com.qq.e.dl.l.d dVar = this.f42370i.get();
        if (dVar != null && h()) {
            for (com.qq.e.comm.plugin.k0.f.d dVar2 : this.f42499q) {
                dVar2.a(i4, i5, i6, i7, j4);
            }
            com.qq.e.dl.l.j.c f4 = f();
            long currentTimeMillis = System.currentTimeMillis();
            d1.a("gdt_tag_sensor", "onTwistComplete motionEndTime = " + currentTimeMillis);
            f4.a("motionDuration", Long.valueOf(currentTimeMillis - this.f42375n));
            a(f4, 1.0f, i4, i5, i6, j4);
            dVar.b(this.f42368g, f4);
        }
    }

    private void a(com.qq.e.dl.l.j.c cVar, float f4, int i4, int i5, int i6, long j4) {
        boolean z3 = !TextUtils.isEmpty(cVar.f47129j);
        a(cVar, "tf", Float.valueOf(f4), z3);
        a(cVar, "tx", Integer.valueOf(i4), z3);
        a(cVar, "ty", Integer.valueOf(i5), z3);
        a(cVar, "tz", Integer.valueOf(i6), z3);
        if (f4 >= 1.0f) {
            a(cVar, "nt", Long.valueOf(j4), z3);
        }
    }

    private void a(com.qq.e.dl.l.j.c cVar, String str, Object obj, boolean z3) {
        cVar.a(str, obj);
        if (z3) {
            cVar.a(str + cVar.f47129j, obj);
        }
    }
}
