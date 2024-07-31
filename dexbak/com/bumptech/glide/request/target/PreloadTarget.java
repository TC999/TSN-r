package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.C3558j;
import com.bumptech.glide.request.transition.InterfaceC3759f;

/* renamed from: com.bumptech.glide.request.target.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PreloadTarget<Z> extends SimpleTarget<Z> {

    /* renamed from: e */
    private static final int f14481e = 1;

    /* renamed from: f */
    private static final Handler f14482f = new Handler(Looper.getMainLooper(), new C3752a());

    /* renamed from: d */
    private final C3558j f14483d;

    /* compiled from: PreloadTarget.java */
    /* renamed from: com.bumptech.glide.request.target.m$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3752a implements Handler.Callback {
        C3752a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((PreloadTarget) message.obj).m44483d();
                return true;
            }
            return false;
        }
    }

    private PreloadTarget(C3558j c3558j, int i, int i2) {
        super(i, i2);
        this.f14483d = c3558j;
    }

    /* renamed from: e */
    public static <Z> PreloadTarget<Z> m44482e(C3558j c3558j, int i, int i2) {
        return new PreloadTarget<>(c3558j, i, i2);
    }

    /* renamed from: d */
    void m44483d() {
        this.f14483d.m45490z(this);
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: k */
    public void mo44364k(@NonNull Z z, @Nullable InterfaceC3759f<? super Z> interfaceC3759f) {
        f14482f.obtainMessage(1, this).sendToTarget();
    }
}
