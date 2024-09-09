package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.aa;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AmapDelegateListenerManager.java */
/* renamed from: com.amap.api.col.3l.z9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z9 {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f9590a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AmapDelegateListenerManager.java */
    /* renamed from: com.amap.api.col.3l.z9$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public List<T> f9591a = Collections.synchronizedList(new ArrayList());

        /* renamed from: b  reason: collision with root package name */
        public T f9592b = null;

        public a() {
        }
    }

    /* compiled from: AuthProTask.java */
    /* renamed from: com.amap.api.col.3l.z9$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class b extends z7 {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<IAMapDelegate> f9594a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<Context> f9595b;

        /* renamed from: c  reason: collision with root package name */
        private aa f9596c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AuthProTask.java */
        /* renamed from: com.amap.api.col.3l.z9$b$a */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ IAMapDelegate f9597a;

            a(IAMapDelegate iAMapDelegate) {
                this.f9597a = iAMapDelegate;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IAMapDelegate iAMapDelegate = this.f9597a;
                if (iAMapDelegate == null || iAMapDelegate.getMapConfig() == null) {
                    return;
                }
                MapConfig mapConfig = this.f9597a.getMapConfig();
                mapConfig.setProFunctionAuthEnable(false);
                if (mapConfig.isUseProFunction()) {
                    this.f9597a.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                    this.f9597a.reloadMapCustomStyle();
                    h2.b(b.this.f9595b == null ? null : (Context) b.this.f9595b.get(), "\u9274\u6743\u5931\u8d25\uff0c\u5f53\u524dkey\u6ca1\u6709\u81ea\u5b9a\u4e49\u7eb9\u7406\u7684\u4f7f\u7528\u6743\u9650\uff0c\u81ea\u5b9a\u4e49\u7eb9\u7406\u76f8\u5173\u5185\u5bb9\uff0c\u5c06\u4e0d\u4f1a\u5448\u73b0\uff01");
                }
            }
        }

        public b(IAMapDelegate iAMapDelegate, Context context) {
            this.f9594a = null;
            this.f9595b = null;
            this.f9594a = new WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.f9595b = new WeakReference<>(context);
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [com.amap.api.col.3l.aa, com.amap.api.col.3l.x3] */
        public final void runTask() {
            aa.a aVar;
            WeakReference<Context> weakReference;
            try {
                if (z9.c()) {
                    return;
                }
                if (this.f9596c == null && (weakReference = this.f9595b) != null && weakReference.get() != null) {
                    this.f9596c = new aa(this.f9595b.get(), "");
                }
                z9.d();
                if (z9.f() > z9.h()) {
                    z9.i();
                    a();
                    return;
                }
                ?? r02 = this.f9596c;
                if (r02 == 0 || (aVar = (aa.a) r02.n()) == null) {
                    return;
                }
                if (!aVar.d) {
                    a();
                }
                z9.i();
            } catch (Throwable th) {
                t5.p(th, "authForPro", "loadConfigData_uploadException");
                String str = b3.f7208e;
                c3.l(str, "auth exception get data " + th.getMessage());
            }
        }

        private void a() {
            IAMapDelegate iAMapDelegate;
            WeakReference<IAMapDelegate> weakReference = this.f9594a;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.f9594a.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new a(iAMapDelegate));
        }
    }

    public final <T> List<T> a(int i4) {
        try {
            a aVar = this.f9590a.get(Integer.valueOf(i4));
            if (aVar != null) {
                return aVar.f9591a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> void b() {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f9590a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            for (Map.Entry<Integer, a> entry : concurrentHashMap.entrySet()) {
                a value = entry.getValue();
                value.f9591a.clear();
                value.f9592b = null;
            }
            this.f9590a.clear();
        } catch (Throwable unused) {
        }
    }

    public final <T> void c(int i4, T t3) {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f9590a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(Integer.valueOf(i4));
            if (aVar == null) {
                aVar = new a();
                this.f9590a.putIfAbsent(Integer.valueOf(i4), aVar);
            }
            if (aVar.f9592b == t3) {
                return;
            }
            f(Integer.valueOf(i4), aVar.f9592b);
            aVar.f9592b = t3;
            e(Integer.valueOf(i4), t3);
        } catch (Throwable unused) {
        }
    }

    public final <T> void d(Integer num) {
        a aVar;
        List<T> list;
        try {
            if (!this.f9590a.containsKey(num) || (aVar = this.f9590a.get(num)) == null || (list = aVar.f9591a) == null) {
                return;
            }
            list.clear();
        } catch (Throwable unused) {
        }
    }

    public final <T> void e(Integer num, T t3) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        if (t3 != null && (concurrentHashMap = this.f9590a) != null) {
            try {
                a aVar = concurrentHashMap.get(num);
                if (aVar == null) {
                    aVar = new a();
                    this.f9590a.putIfAbsent(num, aVar);
                }
                List<T> list = aVar.f9591a;
                if (list == null || list.contains(t3)) {
                    return;
                }
                aVar.f9591a.add(t3);
            } catch (Throwable unused) {
            }
        }
    }

    public final <T> void f(Integer num, T t3) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        a aVar;
        List<T> list;
        if (t3 != null && (concurrentHashMap = this.f9590a) != null) {
            try {
                if (!concurrentHashMap.containsKey(num) || (aVar = this.f9590a.get(num)) == null || (list = aVar.f9591a) == null || !list.contains(t3)) {
                    return;
                }
                aVar.f9591a.remove(t3);
            } catch (Throwable unused) {
            }
        }
    }
}
