package p623n0;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* renamed from: n0.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C15376d extends ContentObserver {

    /* renamed from: a */
    private final Context f44097a;

    /* renamed from: b */
    private final AudioManager f44098b;

    /* renamed from: c */
    private final C15373a f44099c;

    /* renamed from: d */
    private final InterfaceC15375c f44100d;

    /* renamed from: e */
    private float f44101e;

    public C15376d(Handler handler, Context context, C15373a c15373a, InterfaceC15375c interfaceC15375c) {
        super(handler);
        this.f44097a = context;
        this.f44098b = (AudioManager) context.getSystemService("audio");
        this.f44099c = c15373a;
        this.f44100d = interfaceC15375c;
    }

    /* renamed from: b */
    private boolean m2878b(float f) {
        return f != this.f44101e;
    }

    /* renamed from: d */
    private float m2876d() {
        return this.f44099c.m2882a(this.f44098b.getStreamVolume(3), this.f44098b.getStreamMaxVolume(3));
    }

    /* renamed from: e */
    private void m2875e() {
        this.f44100d.mo2880a(this.f44101e);
    }

    /* renamed from: a */
    public void m2879a() {
        this.f44101e = m2876d();
        m2875e();
        this.f44097a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: c */
    public void m2877c() {
        this.f44097a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        float m2876d = m2876d();
        if (m2878b(m2876d)) {
            this.f44101e = m2876d;
            m2875e();
        }
    }
}
