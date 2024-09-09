package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.comm.pi.DFA;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class c implements DFA {

    /* renamed from: a  reason: collision with root package name */
    private IGDTApkListener f44712a;

    /* renamed from: b  reason: collision with root package name */
    private b f44713b = new b();

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f44714c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f44715d;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IGDTApkListener f44716a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, IGDTApkListener iGDTApkListener) {
            super(looper);
            this.f44716a = iGDTApkListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            c.this.f44713b.a(this.f44716a);
            c.this.f44715d.removeCallbacks(null);
        }
    }

    public c(IGDTApkListener iGDTApkListener) {
        this.f44712a = iGDTApkListener;
        HandlerThread handlerThread = new HandlerThread("GDTApkDelegate");
        this.f44714c = handlerThread;
        handlerThread.start();
        this.f44715d = new a(this.f44714c.getLooper(), iGDTApkListener);
    }

    @Override // com.qq.e.comm.pi.DFA
    public final void loadGDTApk() {
        Handler handler = this.f44715d;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    @Override // com.qq.e.comm.pi.DFA
    public final void startInstall(Context context, GDTApk gDTApk) {
        b bVar = this.f44713b;
        if (bVar != null) {
            bVar.a(context, gDTApk, this.f44712a);
        }
    }
}
