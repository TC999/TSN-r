package com.ss.android.socialbase.downloader.f;

import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class gd {

    /* renamed from: c  reason: collision with root package name */
    volatile bk f49603c;
    private JSONObject ev;

    /* renamed from: f  reason: collision with root package name */
    private long f49604f;

    /* renamed from: r  reason: collision with root package name */
    private int f49605r;
    private final AtomicLong sr;
    private volatile long ux;

    /* renamed from: w  reason: collision with root package name */
    int f49606w;
    private final long xv;

    public gd(long j4, long j5) {
        AtomicLong atomicLong = new AtomicLong();
        this.sr = atomicLong;
        this.f49606w = 0;
        this.xv = j4;
        atomicLong.set(j4);
        this.ux = j4;
        if (j5 >= j4) {
            this.f49604f = j5;
        } else {
            this.f49604f = -1L;
        }
    }

    public long c() {
        return this.sr.get() - this.xv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ev() {
        this.f49606w++;
    }

    public long f() {
        return this.f49604f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gd() {
        this.f49606w--;
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = this.ev;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.ev = jSONObject;
        }
        jSONObject.put("st", xv());
        jSONObject.put("cu", sr());
        jSONObject.put("en", f());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f49606w;
    }

    public int r() {
        return this.f49605r;
    }

    public long sr() {
        long j4 = this.sr.get();
        long j5 = this.f49604f;
        if (j5 > 0) {
            long j6 = j5 + 1;
            if (j4 > j6) {
                return j6;
            }
        }
        return j4;
    }

    public String toString() {
        return "Segment{startOffset=" + this.xv + ",\t currentOffset=" + this.sr + ",\t currentOffsetRead=" + ux() + ",\t endOffset=" + this.f49604f + '}';
    }

    public long ux() {
        bk bkVar = this.f49603c;
        if (bkVar != null) {
            long sr = bkVar.sr();
            if (sr > this.ux) {
                return sr;
            }
        }
        return this.ux;
    }

    public long w() {
        long j4 = this.f49604f;
        if (j4 >= this.xv) {
            return (j4 - ux()) + 1;
        }
        return -1L;
    }

    public long xv() {
        return this.xv;
    }

    public void c(long j4) {
        long j5 = this.xv;
        if (j4 < j5) {
            j4 = j5;
        }
        long j6 = this.f49604f;
        if (j6 > 0) {
            long j7 = j6 + 1;
            if (j4 > j7) {
                j4 = j7;
            }
        }
        this.sr.set(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xv(long j4) {
        if (j4 >= this.xv) {
            this.f49604f = j4;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j4 + ", segment = " + this);
        if (j4 == -1) {
            this.f49604f = j4;
        }
    }

    public void sr(long j4) {
        if (j4 >= this.sr.get()) {
            this.ux = j4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(long j4) {
        this.sr.addAndGet(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i4) {
        this.f49606w = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i4) {
        this.f49605r = i4;
    }

    public static String c(List<gd> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<gd>() { // from class: com.ss.android.socialbase.downloader.f.gd.1
            @Override // java.util.Comparator
            /* renamed from: c */
            public int compare(gd gdVar, gd gdVar2) {
                return (int) (gdVar.xv() - gdVar2.xv());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (gd gdVar : list) {
            sb.append(gdVar);
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public gd(gd gdVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.sr = atomicLong;
        this.f49606w = 0;
        this.xv = gdVar.xv;
        this.f49604f = gdVar.f49604f;
        atomicLong.set(gdVar.sr.get());
        this.ux = atomicLong.get();
        this.f49605r = gdVar.f49605r;
    }

    public gd(JSONObject jSONObject) {
        this.sr = new AtomicLong();
        this.f49606w = 0;
        this.xv = jSONObject.optLong("st");
        xv(jSONObject.optLong("en"));
        c(jSONObject.optLong("cu"));
        sr(sr());
    }
}
