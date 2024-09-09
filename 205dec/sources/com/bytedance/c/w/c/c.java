package com.bytedance.c.w.c;

import java.io.File;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final f f26505b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f26506c = false;

    /* renamed from: d  reason: collision with root package name */
    private Runnable f26507d = new a();

    /* renamed from: a  reason: collision with root package name */
    private long f26504a = a();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f26506c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f fVar) {
        this.f26505b = fVar;
        com.bytedance.c.w.ux.c.a(2L);
        com.bytedance.c.w.ux.f.a().b(4500L, this.f26507d);
        com.bytedance.c.w.ux.f.a().c(5000L, this, 40, 5000L);
    }

    private long a() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    private boolean c() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i4;
        if (this.f26506c) {
            return;
        }
        if (c()) {
            i4 = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i4 = 100;
        }
        if (this.f26505b.e(i4, str, 25)) {
            this.f26506c = true;
        }
    }
}
