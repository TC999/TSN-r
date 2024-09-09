package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
abstract class AndroidSpringLooperFactory {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    @TargetApi(16)
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private static class ChoreographerAndroidSpringLooper extends SpringLooper {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f37002b;

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f37003c = new Choreographer.FrameCallback() { // from class: com.facebook.rebound.AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j4) {
                if (!ChoreographerAndroidSpringLooper.this.f37004d || ChoreographerAndroidSpringLooper.this.f37081a == null) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                ChoreographerAndroidSpringLooper choreographerAndroidSpringLooper = ChoreographerAndroidSpringLooper.this;
                choreographerAndroidSpringLooper.f37081a.i(uptimeMillis - choreographerAndroidSpringLooper.f37005e);
                ChoreographerAndroidSpringLooper.this.f37005e = uptimeMillis;
                ChoreographerAndroidSpringLooper.this.f37002b.postFrameCallback(ChoreographerAndroidSpringLooper.this.f37003c);
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private boolean f37004d;

        /* renamed from: e  reason: collision with root package name */
        private long f37005e;

        public ChoreographerAndroidSpringLooper(Choreographer choreographer) {
            this.f37002b = choreographer;
        }

        public static ChoreographerAndroidSpringLooper i() {
            return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
        }

        @Override // com.facebook.rebound.SpringLooper
        public void b() {
            if (this.f37004d) {
                return;
            }
            this.f37004d = true;
            this.f37005e = SystemClock.uptimeMillis();
            this.f37002b.removeFrameCallback(this.f37003c);
            this.f37002b.postFrameCallback(this.f37003c);
        }

        @Override // com.facebook.rebound.SpringLooper
        public void c() {
            this.f37004d = false;
            this.f37002b.removeFrameCallback(this.f37003c);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private static class LegacyAndroidSpringLooper extends SpringLooper {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f37007b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f37008c = new Runnable() { // from class: com.facebook.rebound.AndroidSpringLooperFactory.LegacyAndroidSpringLooper.1
            @Override // java.lang.Runnable
            public void run() {
                if (!LegacyAndroidSpringLooper.this.f37009d || LegacyAndroidSpringLooper.this.f37081a == null) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                LegacyAndroidSpringLooper legacyAndroidSpringLooper = LegacyAndroidSpringLooper.this;
                legacyAndroidSpringLooper.f37081a.i(uptimeMillis - legacyAndroidSpringLooper.f37010e);
                LegacyAndroidSpringLooper.this.f37010e = uptimeMillis;
                LegacyAndroidSpringLooper.this.f37007b.post(LegacyAndroidSpringLooper.this.f37008c);
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private boolean f37009d;

        /* renamed from: e  reason: collision with root package name */
        private long f37010e;

        public LegacyAndroidSpringLooper(Handler handler) {
            this.f37007b = handler;
        }

        public static SpringLooper i() {
            return new LegacyAndroidSpringLooper(new Handler());
        }

        @Override // com.facebook.rebound.SpringLooper
        public void b() {
            if (this.f37009d) {
                return;
            }
            this.f37009d = true;
            this.f37010e = SystemClock.uptimeMillis();
            this.f37007b.removeCallbacks(this.f37008c);
            this.f37007b.post(this.f37008c);
        }

        @Override // com.facebook.rebound.SpringLooper
        public void c() {
            this.f37009d = false;
            this.f37007b.removeCallbacks(this.f37008c);
        }
    }

    AndroidSpringLooperFactory() {
    }

    public static SpringLooper a() {
        return ChoreographerAndroidSpringLooper.i();
    }
}
