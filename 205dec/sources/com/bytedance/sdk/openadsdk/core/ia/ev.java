package com.bytedance.sdk.openadsdk.core.ia;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.bytedance.sdk.component.utils.a;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private int f33764c = -1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33765f = false;

    /* renamed from: r  reason: collision with root package name */
    private int f33766r = -1;
    private final Context sr;
    private final AudioManager ux;

    /* renamed from: w  reason: collision with root package name */
    private r f33767w;
    private c xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c extends BroadcastReceiver {

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<ev> f33768c;

        public c(ev evVar) {
            this.f33768c = new WeakReference<>(evVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            r xv;
            int w3;
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    a.w("VolumeChangeObserver", "\u5a92\u4f53\u97f3\u91cf\u6539\u53d8\u901a.......");
                    ev evVar = this.f33768c.get();
                    if (evVar == null || (xv = evVar.xv()) == null || (w3 = evVar.w()) == evVar.c()) {
                        return;
                    }
                    evVar.c(w3);
                    if (w3 >= 0) {
                        xv.c(w3);
                    }
                }
            } catch (Throwable th) {
                a.c("VolumeChangeObserver", "onVolumeChangedError: ", th);
            }
        }
    }

    public ev(Context context) {
        this.sr = context;
        this.ux = (AudioManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("audio");
    }

    public int c() {
        return this.f33766r;
    }

    public void registerReceiver() {
        if (this.f33765f) {
            return;
        }
        try {
            this.xv = new c(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.sr.registerReceiver(this.xv, intentFilter);
            this.f33765f = true;
        } catch (Throwable th) {
            a.c("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    public void unregisterReceiver() {
        if (this.f33765f) {
            try {
                this.sr.unregisterReceiver(this.xv);
                this.f33767w = null;
                this.f33765f = false;
            } catch (Throwable th) {
                a.c("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public int w() {
        try {
            AudioManager audioManager = this.ux;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            a.c("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    public r xv() {
        return this.f33767w;
    }

    public void c(int i4) {
        this.f33766r = i4;
    }

    public void c(r rVar) {
        this.f33767w = rVar;
    }
}
