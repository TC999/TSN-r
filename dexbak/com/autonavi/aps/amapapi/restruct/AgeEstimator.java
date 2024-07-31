package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0463l.Encrypt;
import com.autonavi.aps.amapapi.security.C2422a;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.autonavi.aps.amapapi.restruct.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AgeEstimator<T> {

    /* renamed from: a */
    public String f8087a;

    /* renamed from: b */
    private File f8088b;

    /* renamed from: e */
    private Handler f8091e;

    /* renamed from: f */
    private String f8092f;

    /* renamed from: g */
    private boolean f8093g;

    /* renamed from: c */
    private boolean f8089c = false;

    /* renamed from: d */
    private Map<String, C2418a> f8090d = new ConcurrentHashMap();

    /* renamed from: h */
    private Runnable f8094h = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (AgeEstimator.this.f8089c) {
                if (AgeEstimator.this.f8093g) {
                    AgeEstimator.this.m51598e();
                    AgeEstimator.m51597e(AgeEstimator.this);
                }
                if (AgeEstimator.this.f8091e != null) {
                    AgeEstimator.this.f8091e.postDelayed(AgeEstimator.this.f8094h, 60000L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AgeEstimator.java */
    /* renamed from: com.autonavi.aps.amapapi.restruct.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2418a {

        /* renamed from: a */
        int f8097a;

        /* renamed from: b */
        long f8098b;

        /* renamed from: c */
        long f8099c;

        public C2418a(int i, long j, long j2) {
            this.f8097a = i;
            this.f8098b = j;
            this.f8099c = j2;
        }
    }

    public AgeEstimator(Context context, String str, Handler handler) {
        this.f8092f = null;
        if (context == null) {
            return;
        }
        this.f8091e = handler;
        this.f8087a = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f8092f = C2432j.m51155l(context);
        try {
            this.f8088b = new File(context.getFilesDir().getPath(), this.f8087a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        m51600d();
    }

    /* renamed from: a */
    public static int m51608a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    /* renamed from: e */
    static /* synthetic */ boolean m51597e(AgeEstimator ageEstimator) {
        ageEstimator.f8093g = false;
        return false;
    }

    /* renamed from: a */
    abstract void mo51506a(T t, long j);

    /* renamed from: b */
    abstract long mo51505b();

    /* renamed from: b */
    public abstract String mo51503b(T t);

    /* renamed from: c */
    abstract int mo51500c(T t);

    /* renamed from: c */
    abstract long mo51502c();

    /* renamed from: d */
    abstract long mo51499d(T t);

    /* renamed from: b */
    private void m51602b(T t, long j) {
        if (t == null || mo51499d((AgeEstimator<T>) t) < 0) {
            return;
        }
        String mo51503b = mo51503b((AgeEstimator<T>) t);
        C2418a c2418a = this.f8090d.get(mo51503b);
        if (c2418a == null) {
            mo51506a((AgeEstimator<T>) t, j);
            this.f8090d.put(mo51503b, new C2418a(mo51500c((AgeEstimator<T>) t), mo51499d((AgeEstimator<T>) t), j));
            this.f8093g = true;
            return;
        }
        c2418a.f8099c = j;
        if (c2418a.f8097a != mo51500c((AgeEstimator<T>) t)) {
            mo51506a((AgeEstimator<T>) t, j);
            c2418a.f8097a = mo51500c((AgeEstimator<T>) t);
            c2418a.f8098b = mo51499d((AgeEstimator<T>) t);
            this.f8093g = true;
            return;
        }
        mo51506a((AgeEstimator<T>) t, c2418a.f8098b);
    }

    /* renamed from: d */
    private void m51600d() {
        long m51186b;
        try {
            for (String str : C2432j.m51193a(this.f8088b)) {
                String[] split = new String(C2422a.m51450b(Encrypt.m54718g(str), this.f8092f), "UTF-8").split(",");
                if (split.length >= 4) {
                    m51186b = Long.parseLong(split[3]);
                } else {
                    m51186b = C2432j.m51186b();
                }
                this.f8090d.put(split[0], new C2418a(Integer.parseInt(split[1]), Long.parseLong(split[2]), m51186b));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m51598e() {
        if (mo51502c() > 0) {
            this.f8090d.size();
            if (mo51505b() > 0) {
                long m51186b = C2432j.m51186b();
                Iterator<Map.Entry<String, C2418a>> it = this.f8090d.entrySet().iterator();
                while (it.hasNext()) {
                    if (m51186b - this.f8090d.get(it.next().getKey()).f8099c > mo51505b()) {
                        it.remove();
                    }
                }
            }
            if (this.f8090d.size() > mo51502c()) {
                ArrayList arrayList = new ArrayList(this.f8090d.keySet());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.autonavi.aps.amapapi.restruct.a.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(String str, String str2) {
                        return AgeEstimator.m51608a(((C2418a) AgeEstimator.this.f8090d.get(str2)).f8099c, ((C2418a) AgeEstimator.this.f8090d.get(str)).f8099c);
                    }
                });
                for (int mo51502c = (int) mo51502c(); mo51502c < arrayList.size(); mo51502c++) {
                    this.f8090d.remove(arrayList.get(mo51502c));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, C2418a> entry : this.f8090d.entrySet()) {
            String str = entry.getKey() + "," + entry.getValue().f8097a + "," + entry.getValue().f8098b + "," + entry.getValue().f8099c;
            try {
                sb.append(Encrypt.m54719f(C2422a.m51453a(str.getBytes("UTF-8"), this.f8092f)) + ShellAdbUtils.f33810d);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        C2432j.m51192a(this.f8088b, sb2);
    }

    /* renamed from: a */
    public final void m51609a() {
        Handler handler;
        if (!this.f8089c && (handler = this.f8091e) != null) {
            handler.removeCallbacks(this.f8094h);
            this.f8091e.postDelayed(this.f8094h, 60000L);
        }
        this.f8089c = true;
    }

    /* renamed from: a */
    public final void m51604a(boolean z) {
        Handler handler = this.f8091e;
        if (handler != null) {
            handler.removeCallbacks(this.f8094h);
        }
        if (!z) {
            this.f8094h.run();
        }
        this.f8089c = false;
    }

    /* renamed from: a */
    public final void m51606a(T t) {
        m51602b(t, C2432j.m51186b());
    }

    /* renamed from: a */
    public final void m51605a(List<T> list) {
        long m51186b = C2432j.m51186b();
        for (T t : list) {
            m51602b(t, m51186b);
        }
        if (this.f8090d.size() >= list.size()) {
            this.f8093g = true;
        }
        if (this.f8090d.size() > 16384 || mo51502c() <= 0) {
            this.f8090d.clear();
            for (T t2 : list) {
                this.f8090d.put(mo51503b((AgeEstimator<T>) t2), new C2418a(mo51500c((AgeEstimator<T>) t2), mo51499d((AgeEstimator<T>) t2), m51186b));
            }
        }
    }

    /* renamed from: e */
    public final long m51596e(T t) {
        return (C2432j.m51186b() - mo51499d((AgeEstimator<T>) t)) / 1000;
    }
}
