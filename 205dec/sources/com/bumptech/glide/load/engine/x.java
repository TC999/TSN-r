package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ResourceRecycler.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class x {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17244a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f17245b = new Handler(Looper.getMainLooper(), new a());

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ResourceRecycler.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class a implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        static final int f17246a = 1;

        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((u) message.obj).recycle();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(u<?> uVar) {
        if (this.f17244a) {
            this.f17245b.obtainMessage(1, uVar).sendToTarget();
        } else {
            this.f17244a = true;
            uVar.recycle();
            this.f17244a = false;
        }
    }
}
