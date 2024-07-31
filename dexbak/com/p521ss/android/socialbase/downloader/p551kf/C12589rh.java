package com.p521ss.android.socialbase.downloader.p551kf;

import androidx.annotation.NonNull;
import com.github.mikephil.charting.utils.Utils;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.kf.rh */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12589rh {

    /* renamed from: a */
    private int f35388a;

    /* renamed from: ok */
    private final JSONObject f35389ok;

    private C12589rh(JSONObject jSONObject) {
        this.f35389ok = jSONObject;
    }

    /* renamed from: i */
    private int m17210i() {
        return this.f35389ok.optInt("url_balance", 2);
    }

    /* renamed from: a */
    public boolean m17214a() {
        return m17210i() > 0;
    }

    /* renamed from: bl */
    public boolean m17212bl() {
        return m17210i() == 1;
    }

    /* renamed from: h */
    public long m17211h() {
        long optInt = this.f35389ok.optInt("segment_min_kb", 512) * 1024;
        if (optInt < 65536) {
            return 65536L;
        }
        return optInt;
    }

    /* renamed from: j */
    public int m17209j() {
        return this.f35389ok.optInt("ip_strategy", 0);
    }

    /* renamed from: k */
    public long m17208k() {
        long optInt = this.f35389ok.optInt("connect_timeout", -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1L;
    }

    /* renamed from: kf */
    public boolean m17207kf() {
        return this.f35389ok.optInt("segment_mode", 1) == 0;
    }

    /* renamed from: n */
    public int m17206n() {
        return this.f35389ok.optInt("buffer_size", 8192);
    }

    /* renamed from: ok */
    public void m17204ok(int i) {
        this.f35388a = m17213a(i);
    }

    /* renamed from: p */
    public long m17202p() {
        long optInt = this.f35389ok.optInt("segment_min_init_mb", 10) * 1048576;
        if (optInt < 5242880) {
            return 5242880L;
        }
        return optInt;
    }

    /* renamed from: q */
    public long m17201q() {
        long optInt = this.f35389ok.optInt("segment_max_kb", 0) * 1048576;
        if (optInt < m17211h()) {
            return -1L;
        }
        return optInt;
    }

    /* renamed from: r */
    public long m17200r() {
        long optInt = this.f35389ok.optInt("read_timeout", -1);
        if (optInt >= DanmakuFactory.f43786r) {
            return optInt;
        }
        return -1L;
    }

    /* renamed from: rh */
    public int m17199rh() {
        return this.f35389ok.optInt("ratio_segment", 0);
    }

    /* renamed from: s */
    public int m17198s() {
        return this.f35389ok.optInt("buffer_count", 512);
    }

    /* renamed from: t */
    public float m17197t() {
        return Math.min(Math.max(0.0f, (float) this.f35389ok.optDouble("poor_speed_ratio", Utils.DOUBLE_EPSILON)), 1.0f);
    }

    /* renamed from: z */
    public float m17196z() {
        return (float) this.f35389ok.optDouble("main_ratio", Utils.DOUBLE_EPSILON);
    }

    /* renamed from: a */
    private int m17213a(int i) {
        int optInt = this.f35389ok.optInt("thread_count", 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return m17210i() == 1 ? Math.min(optInt, i) : optInt;
        } else if (m17210i() > 0) {
            return i;
        } else {
            return 1;
        }
    }

    /* renamed from: ok */
    public int m17205ok() {
        return this.f35388a;
    }

    @NonNull
    /* renamed from: ok */
    public static C12589rh m17203ok(@NonNull JSONObject jSONObject) {
        return new C12589rh(jSONObject);
    }
}
