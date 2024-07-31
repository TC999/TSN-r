package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.C10668c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.p427b.C10667b;

/* renamed from: com.kwad.sdk.crash.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10671e {
    private C10667b aFK;
    private C10668c aFL;
    private long aFM;

    /* renamed from: com.kwad.sdk.crash.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10672a {
        private static final C10671e aFN = new C10671e((byte) 0);
    }

    /* synthetic */ C10671e(byte b) {
        this();
    }

    /* renamed from: Hu */
    public static C10671e m25134Hu() {
        return C10672a.aFN;
    }

    /* renamed from: HA */
    public final InterfaceC10677h m25136HA() {
        return this.aFL.aFl;
    }

    /* renamed from: HB */
    public final long m25135HB() {
        return SystemClock.elapsedRealtime() - this.aFM;
    }

    /* renamed from: Hv */
    public final String[] m25133Hv() {
        return this.aFK.m25203HI();
    }

    /* renamed from: Hw */
    public final String[] m25132Hw() {
        return this.aFK.m25202Hw();
    }

    /* renamed from: Hx */
    public final String m25131Hx() {
        return this.aFL.aFj.aGl;
    }

    /* renamed from: Hy */
    public final int m25130Hy() {
        return this.aFL.aFj.aGp;
    }

    /* renamed from: Hz */
    public final C10668c m25129Hz() {
        return this.aFL;
    }

    /* renamed from: a */
    public final void m25128a(@NonNull C10668c c10668c) {
        this.aFL = c10668c;
        this.aFM = SystemClock.elapsedRealtime();
        this.aFK.m25201a(c10668c.aFm, c10668c.aFn);
    }

    /* renamed from: b */
    public final void m25127b(int i, ExceptionMessage exceptionMessage) {
        InterfaceC10673f m25200Hq = this.aFL.m25200Hq();
        if (m25200Hq != null) {
            m25200Hq.mo25125a(i, exceptionMessage);
        }
    }

    public final String getAppId() {
        return this.aFL.aFk.aGc;
    }

    public final Context getContext() {
        return this.aFL.context;
    }

    public final String getSdkVersion() {
        return this.aFL.aFj.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.aFL.m25199Hr();
    }

    private C10671e() {
        this.aFK = new C10667b();
        this.aFL = new C10668c.C10669a().m25192Ht();
    }
}
