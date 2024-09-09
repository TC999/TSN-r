package com.bytedance.sdk.component.r.w.w.c;

import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.component.r.c.ev;
import com.bytedance.sdk.component.r.c.sr;
import com.bytedance.sdk.component.r.c.ux;
import com.bytedance.sdk.component.r.w.w.w;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private AtomicLong f30123c = new AtomicLong(0);

    /* renamed from: w  reason: collision with root package name */
    private AtomicLong f30135w = new AtomicLong(0);
    private AtomicLong xv = new AtomicLong(0);
    private AtomicLong sr = new AtomicLong(0);
    private AtomicLong ux = new AtomicLong(0);

    /* renamed from: f  reason: collision with root package name */
    private AtomicLong f30124f = new AtomicLong(0);

    /* renamed from: r  reason: collision with root package name */
    private AtomicLong f30131r = new AtomicLong(0);
    private AtomicLong ev = new AtomicLong(0);
    private AtomicLong gd = new AtomicLong(0);

    /* renamed from: p  reason: collision with root package name */
    private AtomicLong f30129p = new AtomicLong(0);

    /* renamed from: k  reason: collision with root package name */
    private AtomicLong f30127k = new AtomicLong(0);

    /* renamed from: a  reason: collision with root package name */
    private AtomicLong f30122a = new AtomicLong(0);
    private AtomicLong bk = new AtomicLong(0);

    /* renamed from: t  reason: collision with root package name */
    private AtomicLong f30133t = new AtomicLong(0);
    private AtomicLong ys = new AtomicLong(0);
    private AtomicLong fp = new AtomicLong(0);
    private AtomicLong ia = new AtomicLong(0);

    /* renamed from: s  reason: collision with root package name */
    private AtomicLong f30132s = new AtomicLong(0);
    private AtomicLong fz = new AtomicLong(0);

    /* renamed from: u  reason: collision with root package name */
    private AtomicLong f30134u = new AtomicLong(0);

    /* renamed from: i  reason: collision with root package name */
    private AtomicLong f30125i = new AtomicLong(0);

    /* renamed from: q  reason: collision with root package name */
    private AtomicLong f30130q = new AtomicLong(0);

    /* renamed from: j  reason: collision with root package name */
    private AtomicLong f30126j = new AtomicLong(0);
    private AtomicLong ls = new AtomicLong(0);
    private AtomicLong gb = new AtomicLong(0);

    /* renamed from: n  reason: collision with root package name */
    private AtomicLong f30128n = new AtomicLong(0);
    private AtomicLong ck = new AtomicLong(0);

    public AtomicLong a() {
        return this.sr;
    }

    public AtomicLong bk() {
        return this.f30135w;
    }

    public AtomicLong c() {
        return this.gb;
    }

    public AtomicLong ck() {
        return this.ia;
    }

    public AtomicLong ev() {
        return this.f30134u;
    }

    public AtomicLong f() {
        return this.f30125i;
    }

    public AtomicLong fp() {
        return this.f30123c;
    }

    public AtomicLong fz() {
        return this.f30124f;
    }

    public AtomicLong gb() {
        return this.ys;
    }

    public AtomicLong gd() {
        return this.ck;
    }

    public AtomicLong i() {
        return this.gd;
    }

    public AtomicLong ia() {
        return this.xv;
    }

    public AtomicLong j() {
        return this.bk;
    }

    public AtomicLong k() {
        return this.ev;
    }

    public AtomicLong ls() {
        return this.f30133t;
    }

    public AtomicLong n() {
        return this.fp;
    }

    public synchronized void p() {
        ia().set(0L);
        gb().set(0L);
        n().set(0L);
        ls().set(0L);
        z().set(0L);
        ck().set(0L);
        j().set(0L);
        q().set(0L);
        u().set(0L);
        fp().set(0L);
        s().set(0L);
        i().set(0L);
        fz().set(0L);
        t().set(0L);
        a().set(0L);
        bk().set(0L);
        k().set(0L);
        ys().set(0L);
        ev().set(0L);
        f().set(0L);
        ux().set(0L);
        sr().set(0L);
        xv().set(0L);
        w().set(0L);
        c().set(0L);
        gd().set(0L);
    }

    public AtomicLong q() {
        return this.f30127k;
    }

    public AtomicLong r() {
        return this.f30122a;
    }

    public AtomicLong s() {
        return this.ux;
    }

    public AtomicLong sr() {
        return this.f30126j;
    }

    public AtomicLong t() {
        return this.f30129p;
    }

    public AtomicLong u() {
        return this.f30131r;
    }

    public AtomicLong ux() {
        return this.f30130q;
    }

    public AtomicLong w() {
        return this.f30128n;
    }

    public AtomicLong xv() {
        return this.ls;
    }

    public AtomicLong ys() {
        return this.fz;
    }

    public AtomicLong z() {
        return this.f30132s;
    }

    public synchronized void c(long j4) {
        this.f30123c.getAndAdd(j4);
        this.f30135w.incrementAndGet();
    }

    public JSONObject c(long j4, ux uxVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j5 = bk().get();
            long j6 = 1;
            jSONObject.put("create_save_cost_ts_avg", (((float) fp().get()) * 1.0f) / ((float) (j5 == 0 ? 1L : j5)));
            jSONObject.put(EventMonitor.SAVE_SUCCESS_COUNT, j5);
            long j7 = a().get();
            jSONObject.put("save_upload_cost_ts_avg", (((float) ia().get()) * 1.0f) / ((float) (j7 == 0 ? 1L : j7)));
            jSONObject.put(EventMonitor.WILL_SEND_COUNT, j7);
            jSONObject.put(EventMonitor.KEY_SDK_EVENT_INDEX, j4);
            jSONObject.put(EventMonitor.SDK_SEND_SUCCESS_COUNT, this.f30122a.get());
            jSONObject.put("all_delete_count", s().get());
            jSONObject.put("success_delete_count", fz().get());
            jSONObject.put("invalid_delete_count", u().get());
            jSONObject.put(EventMonitor.WILL_SAVE_COUNT, i().get());
            jSONObject.put(EventMonitor.DID_SEND_COUNT, t().get());
            jSONObject.put(EventMonitor.SEND_SUCCESS_VALID_COUNT, q().get());
            long j8 = k().get();
            jSONObject.put(EventMonitor.SEND_SUCCESS_INVALID_COUNT, j().get());
            jSONObject.put(EventMonitor.SEND_FAIL_COUNT, j8);
            jSONObject.put("before_save_count", ys().get());
            jSONObject.put("tm_count", ev().get());
            jSONObject.put("success_tm", f().get());
            jSONObject.put("queue_timeout_tm", ux().get());
            jSONObject.put("after_upload_tm", sr().get());
            jSONObject.put("quit_tm", xv().get());
            long j9 = gb().get();
            long j10 = n().get();
            jSONObject.put("success_request_cost_ts_avg", (((float) ck().get()) * 1.0f) / ((float) (j9 == 0 ? 1L : j9)));
            float f4 = ((float) z().get()) * 1.0f;
            if (j10 != 0) {
                j6 = j10;
            }
            jSONObject.put("fail_request_cost_ts_avg", f4 / ((float) j6));
            jSONObject.put(EventMonitor.REQUEST_COUNT, ls().get());
            jSONObject.put(EventMonitor.REQUEST_SUCCESS_COUNT, j9);
            jSONObject.put(EventMonitor.REQUEST_FAIL_COUNT, j10);
            jSONObject.put("is_multi_process", uxVar.k());
            jSONObject.put("app_start_time", w.sr);
            jSONObject.put("app_first_time", w.ux);
            jSONObject.put("stop_counts", gd().get());
            sr sr = uxVar.sr();
            if (sr != null) {
                jSONObject.put("is_debug", sr.c());
                ev a4 = sr.a();
                if (a4 != null) {
                    jSONObject.put("is_plugin", a4.ev());
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }
}
