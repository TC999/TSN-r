package com.bykv.vk.openvk.component.video.c.w;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.component.video.c.w.gd;
import com.bykv.vk.openvk.component.video.c.w.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    private static volatile sr ux;

    /* renamed from: a  reason: collision with root package name */
    private volatile xv f25115a;
    private volatile String bk;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f25116c = 163840;
    private volatile com.bykv.vk.openvk.component.video.c.w.c.w ev;

    /* renamed from: f  reason: collision with root package name */
    private volatile com.bykv.vk.openvk.component.video.c.w.w.xv f25117f;
    private final HashSet<c> gd;

    /* renamed from: k  reason: collision with root package name */
    private volatile xv f25118k;

    /* renamed from: p  reason: collision with root package name */
    private final w.InterfaceC0342w f25119p;

    /* renamed from: r  reason: collision with root package name */
    private volatile com.bykv.vk.openvk.component.video.c.w.c.xv f25120r;
    private final ExecutorService sr;

    /* renamed from: t  reason: collision with root package name */
    private volatile boolean f25121t;

    /* renamed from: w  reason: collision with root package name */
    private final SparseArray<Map<String, com.bykv.vk.openvk.component.video.c.w.w>> f25122w;
    private final w<Runnable> xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        final boolean f25129c;

        /* renamed from: f  reason: collision with root package name */
        final String[] f25130f;
        final String sr;
        final Map<String, String> ux;

        /* renamed from: w  reason: collision with root package name */
        final boolean f25131w;
        final int xv;

        c(boolean z3, boolean z4, int i4, String str, Map<String, String> map, String[] strArr) {
            this.f25129c = z3;
            this.f25131w = z4;
            this.xv = i4;
            this.sr = str;
            this.ux = map;
            this.f25130f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f25129c == cVar.f25129c && this.f25131w == cVar.f25131w && this.xv == cVar.xv) {
                return this.sr.equals(cVar.sr);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f25129c ? 1 : 0) * 31) + (this.f25131w ? 1 : 0)) * 31) + this.xv) * 31) + this.sr.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w<T> extends LinkedBlockingDeque<T> {

        /* renamed from: c  reason: collision with root package name */
        private ThreadPoolExecutor f25132c;

        private w() {
        }

        public void c(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.f25132c != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor != null) {
                    this.f25132c = threadPoolExecutor;
                } else {
                    throw new NullPointerException("executor argument can't be null!");
                }
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t3) {
            synchronized (this) {
                int poolSize = this.f25132c.getPoolSize();
                int activeCount = this.f25132c.getActiveCount();
                int maximumPoolSize = this.f25132c.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (ux.xv) {
                        Log.i("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                }
                return offerFirst(t3);
            }
        }
    }

    private sr() {
        SparseArray<Map<String, com.bykv.vk.openvk.component.video.c.w.w>> sparseArray = new SparseArray<>(2);
        this.f25122w = sparseArray;
        this.gd = new HashSet<>();
        this.f25119p = new w.InterfaceC0342w() { // from class: com.bykv.vk.openvk.component.video.c.w.sr.1
            @Override // com.bykv.vk.openvk.component.video.c.w.w.InterfaceC0342w
            public void c(com.bykv.vk.openvk.component.video.c.w.w wVar) {
                int f4 = wVar.f();
                synchronized (sr.this.f25122w) {
                    Map map = (Map) sr.this.f25122w.get(f4);
                    if (map != null) {
                        map.remove(wVar.ev);
                    }
                }
                if (ux.xv) {
                    Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + wVar.ev);
                }
            }
        };
        w<Runnable> wVar = new w<>();
        this.xv = wVar;
        ExecutorService c4 = c(wVar);
        this.sr = c4;
        wVar.c((ThreadPoolExecutor) c4);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public static sr xv() {
        if (ux == null) {
            synchronized (sr.class) {
                if (ux == null) {
                    ux = new sr();
                }
            }
        }
        return ux;
    }

    public void sr() {
        com.bykv.vk.openvk.component.video.c.xv.c.c(new com.bytedance.sdk.component.gd.p("cancelAll") { // from class: com.bykv.vk.openvk.component.video.c.w.sr.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bykv.vk.openvk.component.video.c.w.w> arrayList = new ArrayList();
                synchronized (sr.this.f25122w) {
                    int size = sr.this.f25122w.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        Map map = (Map) sr.this.f25122w.get(sr.this.f25122w.keyAt(i4));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    sr.this.xv.clear();
                }
                for (com.bykv.vk.openvk.component.video.c.w.w wVar : arrayList) {
                    wVar.c();
                    if (ux.xv) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + wVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bykv.vk.openvk.component.video.c.w.c.xv xvVar) {
        this.f25120r = xvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xv w() {
        return this.f25115a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bykv.vk.openvk.component.video.c.w.w.xv xvVar) {
        this.f25117f = xvVar;
    }

    public void c(int i4) {
        if (i4 > 0) {
            this.f25116c = i4;
        }
        if (ux.xv) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: " + i4);
        }
    }

    public synchronized void c(long j4, long j5, long j6) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xv c() {
        return this.f25118k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z3, String str) {
        com.bykv.vk.openvk.component.video.c.w.w remove;
        this.bk = str;
        this.f25121t = z3;
        if (ux.xv) {
            Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, " + str);
        }
        HashSet hashSet = null;
        HashSet hashSet2 = null;
        if (str == null) {
            synchronized (this.gd) {
                if (!this.gd.isEmpty()) {
                    hashSet2 = new HashSet(this.gd);
                    this.gd.clear();
                }
            }
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    c(cVar.f25129c, cVar.f25131w, cVar.xv, cVar.sr, cVar.ux, cVar.f25130f);
                    if (ux.xv) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + cVar.sr);
                    }
                }
                return;
            }
            return;
        }
        int i4 = ux.ev;
        if (i4 != 3 && i4 != 2) {
            if (i4 == 1) {
                synchronized (this.f25122w) {
                    Map<String, com.bykv.vk.openvk.component.video.c.w.w> map = this.f25122w.get(com.bykv.vk.openvk.component.video.c.w.w.w.c(z3));
                    remove = map != null ? map.remove(str) : null;
                }
                if (remove != null) {
                    remove.c();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.f25122w) {
            int size = this.f25122w.size();
            for (int i5 = 0; i5 < size; i5++) {
                SparseArray<Map<String, com.bykv.vk.openvk.component.video.c.w.w>> sparseArray = this.f25122w;
                Map<String, com.bykv.vk.openvk.component.video.c.w.w> map2 = sparseArray.get(sparseArray.keyAt(i5));
                if (map2 != null) {
                    Collection<com.bykv.vk.openvk.component.video.c.w.w> values = map2.values();
                    if (values != null && !values.isEmpty()) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.addAll(values);
                    }
                    map2.clear();
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            com.bykv.vk.openvk.component.video.c.w.w wVar = (com.bykv.vk.openvk.component.video.c.w.w) it2.next();
            wVar.c();
            if (ux.xv) {
                Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + wVar.f25051r);
            }
        }
        if (i4 == 3) {
            synchronized (this.gd) {
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    c cVar2 = (c) ((com.bykv.vk.openvk.component.video.c.w.w) it3.next()).f25146t;
                    if (cVar2 != null) {
                        this.gd.add(cVar2);
                    }
                }
            }
        }
    }

    public void c(boolean z3, boolean z4, int i4, String str, String... strArr) {
        c(z3, z4, i4, str, null, strArr);
    }

    public void c(boolean z3, boolean z4, int i4, String str, Map<String, String> map, String... strArr) {
        boolean z5 = ux.xv;
        if (z5) {
            Log.d("TAG_PROXY_Preloader", "preload start \uff01\uff01\uff01\uff01");
        }
        com.bykv.vk.openvk.component.video.c.w.c.c cVar = z3 ? this.ev : this.f25120r;
        com.bykv.vk.openvk.component.video.c.w.w.xv xvVar = this.f25117f;
        if (cVar == null || xvVar == null) {
            if (z5) {
                Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
            }
        } else if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            int i5 = i4 <= 0 ? this.f25116c : i4;
            String c4 = z4 ? str : com.bykv.vk.openvk.component.video.api.f.w.c(str);
            File sr = cVar.sr(c4);
            if (sr != null && sr.length() >= i5) {
                if (z5) {
                    Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + sr.length() + ", need preload size: " + i5);
                }
            } else if (f.c().c(com.bykv.vk.openvk.component.video.c.w.w.w.c(z3), c4)) {
                if (z5) {
                    Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: " + str);
                }
            } else {
                synchronized (this.f25122w) {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        Map<String, com.bykv.vk.openvk.component.video.c.w.w> map2 = this.f25122w.get(z3 ? 1 : 0);
                        if (map2.containsKey(c4)) {
                            return;
                        }
                        int i6 = i5;
                        c cVar2 = new c(z3, z4, i5, str, map, strArr);
                        String str2 = this.bk;
                        if (str2 != null) {
                            int i7 = ux.ev;
                            if (i7 == 3) {
                                synchronized (this.gd) {
                                    this.gd.add(cVar2);
                                }
                                if (z5) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                                }
                                return;
                            } else if (i7 == 2) {
                                if (z5) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str);
                                }
                                return;
                            } else if (i7 == 1 && this.f25121t == z3 && str2.equals(c4)) {
                                if (z5) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                                }
                                return;
                            }
                        }
                        ArrayList arrayList = null;
                        List<gd.w> c5 = com.bykv.vk.openvk.component.video.c.xv.c.c(com.bykv.vk.openvk.component.video.c.xv.c.c(map));
                        if (c5 != null) {
                            arrayList = new ArrayList(c5.size());
                            int size = c5.size();
                            for (int i8 = 0; i8 < size; i8++) {
                                gd.w wVar = c5.get(i8);
                                if (wVar != null) {
                                    arrayList.add(new gd.w(wVar.f25101c, wVar.f25102w));
                                }
                            }
                        }
                        com.bykv.vk.openvk.component.video.c.w.w c6 = new w.c().c(cVar).c(xvVar).c(str).w(c4).c(new a(com.bykv.vk.openvk.component.video.c.xv.c.c(strArr))).c((List<gd.w>) arrayList).c(i6).c(this.f25119p).c(cVar2).c();
                        map2.put(c4, c6);
                        this.sr.execute(c6);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
        }
    }

    public void c(String str) {
        c(false, false, str);
    }

    public void c(final boolean z3, final boolean z4, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bykv.vk.openvk.component.video.c.xv.c.c(new com.bytedance.sdk.component.gd.p("cancel b b S") { // from class: com.bykv.vk.openvk.component.video.c.w.sr.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.c.w.w wVar;
                synchronized (sr.this.f25122w) {
                    Map map = (Map) sr.this.f25122w.get(com.bykv.vk.openvk.component.video.c.w.w.w.c(z3));
                    if (map != null) {
                        wVar = (com.bykv.vk.openvk.component.video.c.w.w) map.remove(z4 ? str : com.bykv.vk.openvk.component.video.api.f.w.c(str));
                    } else {
                        wVar = null;
                    }
                }
                if (wVar != null) {
                    wVar.c();
                }
            }
        });
    }

    private static ExecutorService c(final w<Runnable> wVar) {
        int c4 = com.bykv.vk.openvk.component.video.c.xv.c.c();
        return new com.bytedance.sdk.component.gd.sr.sr(0, c4 < 1 ? 1 : c4 > 4 ? 4 : c4, 60L, TimeUnit.SECONDS, wVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.c.w.sr.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.gd.sr.xv xvVar = new com.bytedance.sdk.component.gd.sr.xv(runnable) { // from class: com.bykv.vk.openvk.component.video.c.w.sr.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        super.run();
                    }
                };
                xvVar.setName("csj_video_preload_" + xvVar.getId());
                xvVar.setDaemon(true);
                if (ux.xv) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + xvVar.getName());
                }
                return xvVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.c.w.sr.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    w.this.offerFirst(runnable);
                    if (ux.xv) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
