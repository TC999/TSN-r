package com.mbridge.msdk.mbjscommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.github.mikephil.charting.utils.Utils;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* renamed from: com.mbridge.msdk.mbjscommon.mraid.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MraidVolumeChangeReceiver {

    /* renamed from: a */
    public static double f31524a = -1.0d;

    /* renamed from: b */
    private Context f31525b;

    /* renamed from: c */
    private AudioManager f31526c;

    /* renamed from: d */
    private boolean f31527d = false;

    /* renamed from: e */
    private InterfaceC11501b f31528e;

    /* renamed from: f */
    private C11500a f31529f;

    /* compiled from: MraidVolumeChangeReceiver.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.mraid.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class C11500a extends BroadcastReceiver {

        /* renamed from: a */
        private WeakReference<MraidVolumeChangeReceiver> f31530a;

        public C11500a(MraidVolumeChangeReceiver mraidVolumeChangeReceiver) {
            this.f31530a = new WeakReference<>(mraidVolumeChangeReceiver);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            MraidVolumeChangeReceiver mraidVolumeChangeReceiver;
            InterfaceC11501b m21411b;
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (mraidVolumeChangeReceiver = this.f31530a.get()) == null || (m21411b = mraidVolumeChangeReceiver.m21411b()) == null) {
                return;
            }
            double m21413a = mraidVolumeChangeReceiver.m21413a();
            if (m21413a >= Utils.DOUBLE_EPSILON) {
                m21411b.m21408a(m21413a);
            }
        }
    }

    /* compiled from: MraidVolumeChangeReceiver.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.mraid.d$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11501b {
        /* renamed from: a */
        void m21408a(double d);
    }

    public MraidVolumeChangeReceiver(Context context) {
        this.f31525b = context;
        this.f31526c = (AudioManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("audio");
    }

    /* renamed from: a */
    public final double m21413a() {
        AudioManager audioManager = this.f31526c;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.f31526c;
        double streamVolume = audioManager2 != null ? audioManager2.getStreamVolume(3) : -1;
        Double.isNaN(streamVolume);
        double d = streamMaxVolume;
        Double.isNaN(d);
        double d2 = (streamVolume * 100.0d) / d;
        f31524a = d2;
        return d2;
    }

    /* renamed from: b */
    public final InterfaceC11501b m21411b() {
        return this.f31528e;
    }

    /* renamed from: c */
    public final void m21410c() {
        if (this.f31525b != null) {
            this.f31529f = new C11500a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f31525b.registerReceiver(this.f31529f, intentFilter);
            this.f31527d = true;
        }
    }

    /* renamed from: d */
    public final void m21409d() {
        Context context;
        if (!this.f31527d || (context = this.f31525b) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.f31529f);
            this.f31528e = null;
            this.f31527d = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m21412a(InterfaceC11501b interfaceC11501b) {
        this.f31528e = interfaceC11501b;
    }
}
