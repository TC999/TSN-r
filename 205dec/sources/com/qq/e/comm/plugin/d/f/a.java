package com.qq.e.comm.plugin.d.f;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<com.qq.e.comm.plugin.d.f.b> f42181a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private long f42182c;

        /* renamed from: d  reason: collision with root package name */
        private long f42183d;

        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f42181a.get() == null) {
                a.d();
            }
            if (this.f42183d >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis > this.f42183d) {
                    long[] h4 = com.qq.e.comm.plugin.d.a.h();
                    int length = h4.length - 1;
                    int i4 = 0;
                    while (true) {
                        if (i4 > length) {
                            break;
                        } else if (i4 == length) {
                            this.f42183d = -1L;
                            this.f42182c = h4[length];
                            break;
                        } else if (h4[i4] > currentTimeMillis) {
                            this.f42183d = h4[i4];
                            this.f42182c = h4[i4 + 1];
                            break;
                        } else {
                            i4 += 2;
                        }
                    }
                }
            }
            if (this.f42182c <= 0) {
                this.f42182c = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
                this.f42183d = -1L;
            }
            com.qq.e.comm.plugin.d.b.a().postDelayed(this, this.f42182c);
        }
    }

    public static void c() {
        d();
        com.qq.e.comm.plugin.d.b.a().post(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        com.qq.e.comm.plugin.d.f.b bVar = new com.qq.e.comm.plugin.d.f.b(Thread.getDefaultUncaughtExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler(bVar);
        f42181a = new WeakReference<>(bVar);
    }
}
