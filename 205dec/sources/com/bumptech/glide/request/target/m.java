package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PreloadTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class m<Z> extends n<Z> {

    /* renamed from: e  reason: collision with root package name */
    private static final int f17999e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final Handler f18000f = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.j f18001d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PreloadTarget.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((m) message.obj).d();
                return true;
            }
            return false;
        }
    }

    private m(com.bumptech.glide.j jVar, int i4, int i5) {
        super(i4, i5);
        this.f18001d = jVar;
    }

    public static <Z> m<Z> e(com.bumptech.glide.j jVar, int i4, int i5) {
        return new m<>(jVar, i4, i5);
    }

    void d() {
        this.f18001d.z(this);
    }

    @Override // com.bumptech.glide.request.target.p
    public void k(@NonNull Z z3, @Nullable com.bumptech.glide.request.transition.f<? super Z> fVar) {
        f18000f.obtainMessage(1, this).sendToTarget();
    }
}
