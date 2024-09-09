package com.mbridge.msdk.mbjscommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* compiled from: MraidVolumeChangeReceiver.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static double f40296a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private Context f40297b;

    /* renamed from: c  reason: collision with root package name */
    private AudioManager f40298c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40299d = false;

    /* renamed from: e  reason: collision with root package name */
    private b f40300e;

    /* renamed from: f  reason: collision with root package name */
    private a f40301f;

    /* compiled from: MraidVolumeChangeReceiver.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<d> f40302a;

        public a(d dVar) {
            this.f40302a = new WeakReference<>(dVar);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            d dVar;
            b b4;
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (dVar = this.f40302a.get()) == null || (b4 = dVar.b()) == null) {
                return;
            }
            double a4 = dVar.a();
            if (a4 >= 0.0d) {
                b4.a(a4);
            }
        }
    }

    /* compiled from: MraidVolumeChangeReceiver.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void a(double d4);
    }

    public d(Context context) {
        this.f40297b = context;
        this.f40298c = (AudioManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("audio");
    }

    public final double a() {
        AudioManager audioManager = this.f40298c;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.f40298c;
        double streamVolume = audioManager2 != null ? audioManager2.getStreamVolume(3) : -1;
        Double.isNaN(streamVolume);
        double d4 = streamMaxVolume;
        Double.isNaN(d4);
        double d5 = (streamVolume * 100.0d) / d4;
        f40296a = d5;
        return d5;
    }

    public final b b() {
        return this.f40300e;
    }

    public final void c() {
        if (this.f40297b != null) {
            this.f40301f = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f40297b.registerReceiver(this.f40301f, intentFilter);
            this.f40299d = true;
        }
    }

    public final void d() {
        Context context;
        if (!this.f40299d || (context = this.f40297b) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.f40301f);
            this.f40300e = null;
            this.f40299d = false;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void a(b bVar) {
        this.f40300e = bVar;
    }
}
