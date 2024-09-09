package com.ss.android.socialbase.downloader.kf;

import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    int f49852a;
    private final long bl;

    /* renamed from: h  reason: collision with root package name */
    private int f49853h;
    private long kf;

    /* renamed from: n  reason: collision with root package name */
    private volatile long f49854n;
    volatile z ok;

    /* renamed from: p  reason: collision with root package name */
    private JSONObject f49855p;

    /* renamed from: s  reason: collision with root package name */
    private final AtomicLong f49856s;

    public q(long j4, long j5) {
        AtomicLong atomicLong = new AtomicLong();
        this.f49856s = atomicLong;
        this.f49852a = 0;
        this.bl = j4;
        atomicLong.set(j4);
        this.f49854n = j4;
        if (j5 >= j4) {
            this.kf = j5;
        } else {
            this.kf = -1L;
        }
    }

    public long a() {
        long j4 = this.kf;
        if (j4 >= this.bl) {
            return (j4 - n()) + 1;
        }
        return -1L;
    }

    public long bl() {
        return this.bl;
    }

    public int h() {
        return this.f49853h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f49852a;
    }

    public long kf() {
        return this.kf;
    }

    public long n() {
        z zVar = this.ok;
        if (zVar != null) {
            long s3 = zVar.s();
            if (s3 > this.f49854n) {
                return s3;
            }
        }
        return this.f49854n;
    }

    public long ok() {
        return this.f49856s.get() - this.bl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        this.f49852a++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f49852a--;
    }

    public JSONObject r() throws JSONException {
        JSONObject jSONObject = this.f49855p;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.f49855p = jSONObject;
        }
        jSONObject.put("st", bl());
        jSONObject.put("cu", s());
        jSONObject.put("en", kf());
        return jSONObject;
    }

    public long s() {
        long j4 = this.f49856s.get();
        long j5 = this.kf;
        if (j5 > 0) {
            long j6 = j5 + 1;
            if (j4 > j6) {
                return j6;
            }
        }
        return j4;
    }

    public String toString() {
        return "Segment{startOffset=" + this.bl + ",\t currentOffset=" + this.f49856s + ",\t currentOffsetRead=" + n() + ",\t endOffset=" + this.kf + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bl(long j4) {
        if (j4 >= this.bl) {
            this.kf = j4;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j4 + ", segment = " + this);
        if (j4 == -1) {
            this.kf = j4;
        }
    }

    public void ok(long j4) {
        long j5 = this.bl;
        if (j4 < j5) {
            j4 = j5;
        }
        long j6 = this.kf;
        if (j6 > 0) {
            long j7 = j6 + 1;
            if (j4 > j7) {
                j4 = j7;
            }
        }
        this.f49856s.set(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j4) {
        this.f49856s.addAndGet(j4);
    }

    public void s(long j4) {
        if (j4 >= this.f49856s.get()) {
            this.f49854n = j4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4) {
        this.f49852a = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(int i4) {
        this.f49853h = i4;
    }

    public static String ok(List<q> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<q>() { // from class: com.ss.android.socialbase.downloader.kf.q.1
            @Override // java.util.Comparator
            /* renamed from: ok */
            public int compare(q qVar, q qVar2) {
                return (int) (qVar.bl() - qVar2.bl());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (q qVar : list) {
            sb.append(qVar);
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public q(q qVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.f49856s = atomicLong;
        this.f49852a = 0;
        this.bl = qVar.bl;
        this.kf = qVar.kf;
        atomicLong.set(qVar.f49856s.get());
        this.f49854n = atomicLong.get();
        this.f49853h = qVar.f49853h;
    }

    public q(JSONObject jSONObject) {
        this.f49856s = new AtomicLong();
        this.f49852a = 0;
        this.bl = jSONObject.optLong("st");
        bl(jSONObject.optLong("en"));
        ok(jSONObject.optLong("cu"));
        s(s());
    }
}
