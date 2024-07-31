package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
abstract class AndroidSpringLooperFactory {

    @TargetApi(16)
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static class ChoreographerAndroidSpringLooper extends SpringLooper {

        /* renamed from: b */
        private final Choreographer f23406b;

        /* renamed from: c */
        private final Choreographer.FrameCallback f23407c = new Choreographer.FrameCallback() { // from class: com.facebook.rebound.AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (!ChoreographerAndroidSpringLooper.this.f23408d || ChoreographerAndroidSpringLooper.this.f23485a == null) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                ChoreographerAndroidSpringLooper choreographerAndroidSpringLooper = ChoreographerAndroidSpringLooper.this;
                choreographerAndroidSpringLooper.f23485a.m35633i(uptimeMillis - choreographerAndroidSpringLooper.f23409e);
                ChoreographerAndroidSpringLooper.this.f23409e = uptimeMillis;
                ChoreographerAndroidSpringLooper.this.f23406b.postFrameCallback(ChoreographerAndroidSpringLooper.this.f23407c);
            }
        };

        /* renamed from: d */
        private boolean f23408d;

        /* renamed from: e */
        private long f23409e;

        public ChoreographerAndroidSpringLooper(Choreographer choreographer) {
            this.f23406b = choreographer;
        }

        /* renamed from: i */
        public static ChoreographerAndroidSpringLooper m35658i() {
            return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
        }

        @Override // com.facebook.rebound.SpringLooper
        /* renamed from: b */
        public void mo35549b() {
            if (this.f23408d) {
                return;
            }
            this.f23408d = true;
            this.f23409e = SystemClock.uptimeMillis();
            this.f23406b.removeFrameCallback(this.f23407c);
            this.f23406b.postFrameCallback(this.f23407c);
        }

        @Override // com.facebook.rebound.SpringLooper
        /* renamed from: c */
        public void mo35548c() {
            this.f23408d = false;
            this.f23406b.removeFrameCallback(this.f23407c);
        }
    }

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static class LegacyAndroidSpringLooper extends SpringLooper {

        /* renamed from: b */
        private final Handler f23411b;

        /* renamed from: c */
        private final Runnable f23412c = new Runnable() { // from class: com.facebook.rebound.AndroidSpringLooperFactory.LegacyAndroidSpringLooper.1
            @Override // java.lang.Runnable
            public void run() {
                if (!LegacyAndroidSpringLooper.this.f23413d || LegacyAndroidSpringLooper.this.f23485a == null) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                LegacyAndroidSpringLooper legacyAndroidSpringLooper = LegacyAndroidSpringLooper.this;
                legacyAndroidSpringLooper.f23485a.m35633i(uptimeMillis - legacyAndroidSpringLooper.f23414e);
                LegacyAndroidSpringLooper.this.f23414e = uptimeMillis;
                LegacyAndroidSpringLooper.this.f23411b.post(LegacyAndroidSpringLooper.this.f23412c);
            }
        };

        /* renamed from: d */
        private boolean f23413d;

        /* renamed from: e */
        private long f23414e;

        public LegacyAndroidSpringLooper(Handler handler) {
            this.f23411b = handler;
        }

        /* renamed from: i */
        public static SpringLooper m35652i() {
            return new LegacyAndroidSpringLooper(new Handler());
        }

        @Override // com.facebook.rebound.SpringLooper
        /* renamed from: b */
        public void mo35549b() {
            if (this.f23413d) {
                return;
            }
            this.f23413d = true;
            this.f23414e = SystemClock.uptimeMillis();
            this.f23411b.removeCallbacks(this.f23412c);
            this.f23411b.post(this.f23412c);
        }

        @Override // com.facebook.rebound.SpringLooper
        /* renamed from: c */
        public void mo35548c() {
            this.f23413d = false;
            this.f23411b.removeCallbacks(this.f23412c);
        }
    }

    AndroidSpringLooperFactory() {
    }

    /* renamed from: a */
    public static SpringLooper m35664a() {
        return ChoreographerAndroidSpringLooper.m35658i();
    }
}
