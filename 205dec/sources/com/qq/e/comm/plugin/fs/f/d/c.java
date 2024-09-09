package com.qq.e.comm.plugin.fs.f.d;

import com.qq.e.comm.plugin.o0.h.e;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.c2;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private final b f43369b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<e> f43370c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f43372e;

    /* renamed from: a  reason: collision with root package name */
    private final String f43368a = c.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private final List<com.qq.e.comm.plugin.fs.f.d.b> f43371d = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f43369b.a(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends c2 {

        /* renamed from: h  reason: collision with root package name */
        private int f43374h;

        public b(long j4, long j5) {
            super(j4, j5);
            this.f43374h = 0;
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void a(long j4) {
            String str = c.this.f43368a;
            d1.a(str, "onTick : " + j4);
            e eVar = (e) c.this.f43370c.get();
            if (eVar == null) {
                d1.a(c.this.f43368a, "GDTVideoPlayer released, stop tick.");
                h();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (com.qq.e.comm.plugin.fs.f.d.b bVar : c.this.f43371d) {
                com.qq.e.comm.plugin.fs.f.d.a aVar = bVar.f43365a.get();
                if (aVar == null) {
                    String str2 = c.this.f43368a;
                    d1.a(str2, "SubscriberEntity[" + bVar.f43366b + "] destroyed ?  no need sync.");
                    bVar.f43367c = false;
                }
                if (bVar.f43367c) {
                    String str3 = c.this.f43368a;
                    d1.a(str3, "SubscriberEntity[" + bVar.f43366b + "] on Sync");
                    if (this.f43374h == 0) {
                        this.f43374h = eVar.getDuration();
                    }
                    bVar.f43367c = aVar.a(c.this.f43372e ? f.t.ERROR : eVar.getVideoState(), this.f43374h, eVar.getCurrentPosition());
                } else {
                    String str4 = c.this.f43368a;
                    d1.a(str4, "SubscriberEntity[" + bVar.f43366b + "] no need sync.");
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 200) {
                String str5 = c.this.f43368a;
                d1.b(str5, "tick, Sync cost : " + currentTimeMillis2);
                return;
            }
            String str6 = c.this.f43368a;
            d1.a(str6, "tick, Sync cost : " + currentTimeMillis2);
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void d() {
        }
    }

    public c() {
        d1.a(this.f43368a, "init VideoPlaySync");
        this.f43369b = new b(Long.MAX_VALUE, 500L);
    }

    public void a(e eVar) {
        if (eVar == null) {
            d1.a("source video player is null");
            return;
        }
        String str = this.f43368a;
        d1.a(str, "Set Source Player : " + eVar.getClass().getSimpleName());
        this.f43370c = new WeakReference<>(eVar);
        this.f43369b.g();
        d1.a(this.f43368a, "Sync start...");
    }

    public void b() {
        a(false);
    }

    public void a(boolean z3) {
        if (this.f43370c == null) {
            return;
        }
        this.f43372e = z3;
        if (this.f43369b != null) {
            p0.a((Runnable) new a());
        }
    }

    public void a(com.qq.e.comm.plugin.fs.f.d.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = this.f43368a;
        d1.a(str, "register : " + aVar.getClass().getSimpleName());
        com.qq.e.comm.plugin.fs.f.d.b bVar = new com.qq.e.comm.plugin.fs.f.d.b();
        bVar.f43365a = new WeakReference<>(aVar);
        bVar.f43366b = aVar.getClass().getSimpleName();
        this.f43371d.add(bVar);
    }

    public void a() {
        d1.a(this.f43368a, "Sync stop...");
        b bVar = this.f43369b;
        if (bVar != null) {
            bVar.h();
        }
        if (this.f43371d.size() > 0) {
            this.f43371d.clear();
        }
    }
}
