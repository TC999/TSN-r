package com.p521ss.android.socialbase.downloader.p551kf;

import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.kf.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12584q {

    /* renamed from: a */
    int f35347a;

    /* renamed from: bl */
    private final long f35348bl;

    /* renamed from: h */
    private int f35349h;

    /* renamed from: kf */
    private long f35350kf;

    /* renamed from: n */
    private volatile long f35351n;

    /* renamed from: ok */
    volatile RunnableC12593z f35352ok;

    /* renamed from: p */
    private JSONObject f35353p;

    /* renamed from: s */
    private final AtomicLong f35354s;

    public C12584q(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.f35354s = atomicLong;
        this.f35347a = 0;
        this.f35348bl = j;
        atomicLong.set(j);
        this.f35351n = j;
        if (j2 >= j) {
            this.f35350kf = j2;
        } else {
            this.f35350kf = -1L;
        }
    }

    /* renamed from: a */
    public long m17296a() {
        long j = this.f35350kf;
        if (j >= this.f35348bl) {
            return (j - m17288n()) + 1;
        }
        return -1L;
    }

    /* renamed from: bl */
    public long m17293bl() {
        return this.f35348bl;
    }

    /* renamed from: h */
    public int m17291h() {
        return this.f35349h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public int m17290k() {
        return this.f35347a;
    }

    /* renamed from: kf */
    public long m17289kf() {
        return this.f35350kf;
    }

    /* renamed from: n */
    public long m17288n() {
        RunnableC12593z runnableC12593z = this.f35352ok;
        if (runnableC12593z != null) {
            long m17158s = runnableC12593z.m17158s();
            if (m17158s > this.f35351n) {
                return m17158s;
            }
        }
        return this.f35351n;
    }

    /* renamed from: ok */
    public long m17287ok() {
        return this.f35354s.get() - this.f35348bl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void m17283p() {
        this.f35347a++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public void m17282q() {
        this.f35347a--;
    }

    /* renamed from: r */
    public JSONObject m17281r() throws JSONException {
        JSONObject jSONObject = this.f35353p;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.f35353p = jSONObject;
        }
        jSONObject.put("st", m17293bl());
        jSONObject.put("cu", m17280s());
        jSONObject.put("en", m17289kf());
        return jSONObject;
    }

    /* renamed from: s */
    public long m17280s() {
        long j = this.f35354s.get();
        long j2 = this.f35350kf;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public String toString() {
        return "Segment{startOffset=" + this.f35348bl + ",\t currentOffset=" + this.f35354s + ",\t currentOffsetRead=" + m17288n() + ",\t endOffset=" + this.f35350kf + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bl */
    public void m17292bl(long j) {
        if (j >= this.f35348bl) {
            this.f35350kf = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f35350kf = j;
        }
    }

    /* renamed from: ok */
    public void m17285ok(long j) {
        long j2 = this.f35348bl;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.f35350kf;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.f35354s.set(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m17294a(long j) {
        this.f35354s.addAndGet(j);
    }

    /* renamed from: s */
    public void m17279s(long j) {
        if (j >= this.f35354s.get()) {
            this.f35351n = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m17295a(int i) {
        this.f35347a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m17286ok(int i) {
        this.f35349h = i;
    }

    /* renamed from: ok */
    public static String m17284ok(List<C12584q> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<C12584q>() { // from class: com.ss.android.socialbase.downloader.kf.q.1
            @Override // java.util.Comparator
            /* renamed from: ok */
            public int compare(C12584q c12584q, C12584q c12584q2) {
                return (int) (c12584q.m17293bl() - c12584q2.m17293bl());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (C12584q c12584q : list) {
            sb.append(c12584q);
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public C12584q(C12584q c12584q) {
        AtomicLong atomicLong = new AtomicLong();
        this.f35354s = atomicLong;
        this.f35347a = 0;
        this.f35348bl = c12584q.f35348bl;
        this.f35350kf = c12584q.f35350kf;
        atomicLong.set(c12584q.f35354s.get());
        this.f35351n = atomicLong.get();
        this.f35349h = c12584q.f35349h;
    }

    public C12584q(JSONObject jSONObject) {
        this.f35354s = new AtomicLong();
        this.f35347a = 0;
        this.f35348bl = jSONObject.optLong("st");
        m17292bl(jSONObject.optLong("en"));
        m17285ok(jSONObject.optLong("cu"));
        m17279s(m17280s());
    }
}
