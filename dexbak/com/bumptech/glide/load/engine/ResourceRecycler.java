package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.bumptech.glide.load.engine.x */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class ResourceRecycler {

    /* renamed from: a */
    private boolean f13927a;

    /* renamed from: b */
    private final Handler f13928b = new Handler(Looper.getMainLooper(), new C3647a());

    /* compiled from: ResourceRecycler.java */
    /* renamed from: com.bumptech.glide.load.engine.x$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3647a implements Handler.Callback {

        /* renamed from: a */
        static final int f13929a = 1;

        C3647a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((Resource) message.obj).recycle();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m45131a(Resource<?> resource) {
        if (this.f13927a) {
            this.f13928b.obtainMessage(1, resource).sendToTarget();
        } else {
            this.f13927a = true;
            resource.recycle();
            this.f13927a = false;
        }
    }
}
