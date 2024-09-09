package com.qq.e.comm.plugin.fs.e;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.plugin.rewardvideo.m;
import com.qq.e.comm.plugin.util.d1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    private static volatile c f43246d;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, b> f43247a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, WeakReference<b>> f43248b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Handler f43249c = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43250c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f43251d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f43252e;

        a(String str, int i4, Object obj) {
            this.f43250c = str;
            this.f43251d = i4;
            this.f43252e = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = (b) c.this.f43247a.get(this.f43250c);
            if (bVar == null) {
                WeakReference weakReference = (WeakReference) c.this.f43248b.get(this.f43250c);
                if (weakReference != null) {
                    b bVar2 = (b) weakReference.get();
                    if (bVar2 == null) {
                        c.this.f43248b.remove(this.f43250c);
                        return;
                    } else {
                        bVar2.a(this.f43250c, this.f43251d, this.f43252e);
                        return;
                    }
                }
                return;
            }
            bVar.a(this.f43250c, this.f43251d, this.f43252e);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a(String str, int i4, Object obj);
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.e.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class C0822c {

        /* renamed from: a  reason: collision with root package name */
        public String f43254a;

        /* renamed from: b  reason: collision with root package name */
        public m f43255b;
    }

    private c() {
    }

    public static c a() {
        if (f43246d == null) {
            synchronized (c.class) {
                if (f43246d == null) {
                    f43246d = new c();
                }
            }
        }
        return f43246d;
    }

    public void b(String str, b bVar) {
        if (!TextUtils.isEmpty(str) && bVar != null) {
            this.f43248b.put(str, new WeakReference<>(bVar));
        } else {
            d1.a("registerListener id null or listener null");
        }
    }

    public void a(String str, b bVar) {
        if (!TextUtils.isEmpty(str) && bVar != null) {
            this.f43247a.put(str, bVar);
        } else {
            d1.a("registerListener id null or listener null");
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f43247a.remove(str);
        this.f43248b.remove(str);
    }

    public void a(String str, int i4) {
        a(str, i4, null);
    }

    public void a(String str, int i4, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f43249c.post(new a(str, i4, obj));
    }
}
