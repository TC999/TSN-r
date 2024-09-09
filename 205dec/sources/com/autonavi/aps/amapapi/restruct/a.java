package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003l.j4;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AgeEstimator.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public String f11764a;

    /* renamed from: b  reason: collision with root package name */
    private File f11765b;

    /* renamed from: e  reason: collision with root package name */
    private Handler f11768e;

    /* renamed from: f  reason: collision with root package name */
    private String f11769f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11770g;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11766c = false;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, C0107a> f11767d = new ConcurrentHashMap();

    /* renamed from: h  reason: collision with root package name */
    private Runnable f11771h = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.f11766c) {
                if (a.this.f11770g) {
                    a.this.e();
                    a.e(a.this);
                }
                if (a.this.f11768e != null) {
                    a.this.f11768e.postDelayed(a.this.f11771h, 60000L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AgeEstimator.java */
    /* renamed from: com.autonavi.aps.amapapi.restruct.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class C0107a {

        /* renamed from: a  reason: collision with root package name */
        int f11774a;

        /* renamed from: b  reason: collision with root package name */
        long f11775b;

        /* renamed from: c  reason: collision with root package name */
        long f11776c;

        public C0107a(int i4, long j4, long j5) {
            this.f11774a = i4;
            this.f11775b = j4;
            this.f11776c = j5;
        }
    }

    public a(Context context, String str, Handler handler) {
        this.f11769f = null;
        if (context == null) {
            return;
        }
        this.f11768e = handler;
        this.f11764a = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f11769f = com.autonavi.aps.amapapi.utils.j.l(context);
        try {
            this.f11765b = new File(context.getFilesDir().getPath(), this.f11764a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d();
    }

    public static int a(long j4, long j5) {
        if (j4 < j5) {
            return -1;
        }
        return j4 == j5 ? 0 : 1;
    }

    static /* synthetic */ boolean e(a aVar) {
        aVar.f11770g = false;
        return false;
    }

    abstract void a(T t3, long j4);

    abstract long b();

    public abstract String b(T t3);

    abstract int c(T t3);

    abstract long c();

    abstract long d(T t3);

    private void b(T t3, long j4) {
        if (t3 == null || d((a<T>) t3) < 0) {
            return;
        }
        String b4 = b((a<T>) t3);
        C0107a c0107a = this.f11767d.get(b4);
        if (c0107a == null) {
            a((a<T>) t3, j4);
            this.f11767d.put(b4, new C0107a(c((a<T>) t3), d((a<T>) t3), j4));
            this.f11770g = true;
            return;
        }
        c0107a.f11776c = j4;
        if (c0107a.f11774a != c((a<T>) t3)) {
            a((a<T>) t3, j4);
            c0107a.f11774a = c((a<T>) t3);
            c0107a.f11775b = d((a<T>) t3);
            this.f11770g = true;
            return;
        }
        a((a<T>) t3, c0107a.f11775b);
    }

    private void d() {
        long b4;
        try {
            for (String str : com.autonavi.aps.amapapi.utils.j.a(this.f11765b)) {
                String[] split = new String(com.autonavi.aps.amapapi.security.a.b(j4.g(str), this.f11769f), "UTF-8").split(",");
                if (split.length >= 4) {
                    b4 = Long.parseLong(split[3]);
                } else {
                    b4 = com.autonavi.aps.amapapi.utils.j.b();
                }
                this.f11767d.put(split[0], new C0107a(Integer.parseInt(split[1]), Long.parseLong(split[2]), b4));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (c() > 0) {
            this.f11767d.size();
            if (b() > 0) {
                long b4 = com.autonavi.aps.amapapi.utils.j.b();
                Iterator<Map.Entry<String, C0107a>> it = this.f11767d.entrySet().iterator();
                while (it.hasNext()) {
                    if (b4 - this.f11767d.get(it.next().getKey()).f11776c > b()) {
                        it.remove();
                    }
                }
            }
            if (this.f11767d.size() > c()) {
                ArrayList arrayList = new ArrayList(this.f11767d.keySet());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.autonavi.aps.amapapi.restruct.a.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(String str, String str2) {
                        return a.a(((C0107a) a.this.f11767d.get(str2)).f11776c, ((C0107a) a.this.f11767d.get(str)).f11776c);
                    }
                });
                for (int c4 = (int) c(); c4 < arrayList.size(); c4++) {
                    this.f11767d.remove(arrayList.get(c4));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, C0107a> entry : this.f11767d.entrySet()) {
            String str = entry.getKey() + "," + entry.getValue().f11774a + "," + entry.getValue().f11775b + "," + entry.getValue().f11776c;
            try {
                sb.append(j4.f(com.autonavi.aps.amapapi.security.a.a(str.getBytes("UTF-8"), this.f11769f)) + "\n");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.j.a(this.f11765b, sb2);
    }

    public final void a() {
        Handler handler;
        if (!this.f11766c && (handler = this.f11768e) != null) {
            handler.removeCallbacks(this.f11771h);
            this.f11768e.postDelayed(this.f11771h, 60000L);
        }
        this.f11766c = true;
    }

    public final void a(boolean z3) {
        Handler handler = this.f11768e;
        if (handler != null) {
            handler.removeCallbacks(this.f11771h);
        }
        if (!z3) {
            this.f11771h.run();
        }
        this.f11766c = false;
    }

    public final void a(T t3) {
        b(t3, com.autonavi.aps.amapapi.utils.j.b());
    }

    public final void a(List<T> list) {
        long b4 = com.autonavi.aps.amapapi.utils.j.b();
        for (T t3 : list) {
            b(t3, b4);
        }
        if (this.f11767d.size() >= list.size()) {
            this.f11770g = true;
        }
        if (this.f11767d.size() > 16384 || c() <= 0) {
            this.f11767d.clear();
            for (T t4 : list) {
                this.f11767d.put(b((a<T>) t4), new C0107a(c((a<T>) t4), d((a<T>) t4), b4));
            }
        }
    }

    public final long e(T t3) {
        return (com.autonavi.aps.amapapi.utils.j.b() - d((a<T>) t3)) / 1000;
    }
}
