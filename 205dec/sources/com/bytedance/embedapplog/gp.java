package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.IOaidObserver;
import com.bytedance.embedapplog.zg;
import com.bytedance.embedapplog.zt;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class gp {

    /* renamed from: c  reason: collision with root package name */
    static final String f26735c;

    /* renamed from: p  reason: collision with root package name */
    private static String f26736p;
    private static final List<IOaidObserver> sr = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private static final String f26737w;

    /* renamed from: a  reason: collision with root package name */
    private Long f26738a;
    private final Context ev;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f26739f;

    /* renamed from: k  reason: collision with root package name */
    private Map<String, String> f26740k;

    /* renamed from: r  reason: collision with root package name */
    private final jv f26741r;
    private final zg ux;
    private final ReentrantLock xv = new ReentrantLock();
    private final AtomicBoolean gd = new AtomicBoolean(false);

    static {
        String str = gp.class.getSimpleName() + "#";
        f26737w = str;
        f26735c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gp(Context context) {
        this.ev = StubApp.getOrigApplicationContext(context.getApplicationContext());
        zg c4 = o.c(context);
        this.ux = c4;
        if (c4 != null) {
            this.f26739f = c4.c(context);
        } else {
            this.f26739f = false;
        }
        this.f26741r = new jv(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr() {
        try {
            this.xv.lock();
            rd c4 = this.f26741r.c();
            if (c4 != null) {
                f26736p = c4.f26788c;
                this.f26740k = c4.c();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> c5 = c(this.ev);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            rd rdVar = null;
            String str = null;
            if (c5.first != null) {
                int i4 = -1;
                int i5 = 1;
                if (c4 != null) {
                    str = c4.f26791w;
                    i4 = c4.f26789f.intValue() + 1;
                }
                if (TextUtils.isEmpty(str)) {
                    str = UUID.randomUUID().toString();
                }
                String str2 = str;
                if (i4 > 0) {
                    i5 = i4;
                }
                rd rdVar2 = new rd((String) c5.first, str2, (Boolean) c5.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i5), this.f26738a);
                this.f26741r.c(rdVar2);
                rdVar = rdVar2;
            }
            if (rdVar != null) {
                f26736p = rdVar.f26788c;
                this.f26740k = rdVar.c();
            }
        } finally {
            this.xv.unlock();
            c(new IOaidObserver.Oaid(f26736p), xv());
        }
    }

    private static Object[] xv() {
        Object[] array;
        List<IOaidObserver> list = sr;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    public void w() {
        if (this.gd.compareAndSet(false, true)) {
            c(new Runnable() { // from class: com.bytedance.embedapplog.gp.1
                @Override // java.lang.Runnable
                public void run() {
                    gp.this.sr();
                }
            });
        }
    }

    @Nullable
    @WorkerThread
    public Map<String, String> c(long j4) {
        if (this.f26739f) {
            w();
            if (this.f26740k == null) {
                SystemClock.elapsedRealtime();
                try {
                    if (this.xv.tryLock(j4, TimeUnit.MILLISECONDS)) {
                        this.xv.unlock();
                    }
                } catch (InterruptedException e4) {
                    be.c(e4);
                }
            }
            return this.f26740k;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @AnyThread
    public static void c(@Nullable IOaidObserver iOaidObserver) {
        List<IOaidObserver> list = sr;
        synchronized (list) {
            list.add(iOaidObserver);
        }
        String str = f26736p;
        if (str != null) {
            c(new IOaidObserver.Oaid(str), new Object[]{iOaidObserver});
        }
    }

    public zg c() {
        return this.ux;
    }

    private static void c(@Nullable IOaidObserver.Oaid oaid, Object[] objArr) {
        if (oaid == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((IOaidObserver) obj).onOaidLoaded(oaid);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e4) {
            be.c(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void c(Map<K, V> map, K k4, V v3) {
        if (k4 == null || v3 == null) {
            return;
        }
        map.put(k4, v3);
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> c(Context context) {
        Boolean bool;
        zg.c w3;
        zg zgVar = this.ux;
        String str = null;
        if (zgVar == null || (w3 = zgVar.w(context)) == null) {
            bool = null;
        } else {
            str = w3.f26861w;
            bool = Boolean.valueOf(w3.xv);
            if (w3 instanceof zt.c) {
                this.f26738a = Long.valueOf(((zt.c) w3).f26867c);
            }
        }
        return new Pair<>(str, bool);
    }

    private static void c(Runnable runnable) {
        zr.c(f26735c + "-query", runnable);
    }
}
