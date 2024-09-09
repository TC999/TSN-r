package com.bytedance.c.w.c;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.gd.sr.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    private final f f26497a;

    /* renamed from: b  reason: collision with root package name */
    private final int f26498b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f26499c;

    /* renamed from: com.bytedance.c.w.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private final class C0372a extends xv {

        /* renamed from: a  reason: collision with root package name */
        private int f26500a;

        C0372a(int i4) {
            super("ANRFileObserver$RestartMonitorThread");
            this.f26500a = i4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.f26500a);
            a.this.f26499c = true;
        }
    }

    public a(f fVar, String str, int i4) {
        super(str, i4);
        this.f26498b = 5000;
        this.f26499c = true;
        if (fVar != null && !TextUtils.isEmpty(str)) {
            this.f26497a = fVar;
            return;
        }
        throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
    }

    @Override // android.os.FileObserver
    public void onEvent(int i4, String str) {
        if (this.f26499c && i4 == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && this.f26497a != null) {
            this.f26499c = false;
            f fVar = this.f26497a;
            fVar.e(200, "/data/anr/" + str, 80);
            new C0372a(5000).start();
        }
    }
}
