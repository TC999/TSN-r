package com.qq.e.comm.plugin.h;

import android.os.Looper;
import com.qq.e.comm.plugin.util.p0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Vector<WeakReference<d<T>>> f43993a = new Vector<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f43994c;

        a(Object obj) {
            this.f43994c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a((c) this.f43994c);
        }
    }

    public void b(T t3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a((c<T>) t3);
        } else {
            p0.a((Runnable) new a(t3));
        }
    }

    public void a(d<T> dVar) {
        this.f43993a.add(new WeakReference<>(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(T t3) {
        synchronized (this.f43993a) {
            Iterator<WeakReference<d<T>>> it = this.f43993a.iterator();
            while (it.hasNext()) {
                WeakReference<d<T>> next = it.next();
                if (next != null) {
                    d<T> dVar = next.get();
                    if (dVar != null) {
                        dVar.a(t3);
                    } else {
                        it.remove();
                    }
                }
            }
        }
    }

    public void a() {
        b(null);
    }
}
