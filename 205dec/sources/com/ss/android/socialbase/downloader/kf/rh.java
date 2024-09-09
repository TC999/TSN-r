package com.ss.android.socialbase.downloader.kf;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class rh {

    /* renamed from: a  reason: collision with root package name */
    private int f49876a;
    private final JSONObject ok;

    private rh(JSONObject jSONObject) {
        this.ok = jSONObject;
    }

    private int i() {
        return this.ok.optInt("url_balance", 2);
    }

    public boolean a() {
        return i() > 0;
    }

    public boolean bl() {
        return i() == 1;
    }

    public long h() {
        long optInt = this.ok.optInt("segment_min_kb", 512) * 1024;
        if (optInt < 65536) {
            return 65536L;
        }
        return optInt;
    }

    public int j() {
        return this.ok.optInt("ip_strategy", 0);
    }

    public long k() {
        long optInt = this.ok.optInt("connect_timeout", -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1L;
    }

    public boolean kf() {
        return this.ok.optInt("segment_mode", 1) == 0;
    }

    public int n() {
        return this.ok.optInt("buffer_size", 8192);
    }

    public void ok(int i4) {
        this.f49876a = a(i4);
    }

    public long p() {
        long optInt = this.ok.optInt("segment_min_init_mb", 10) * 1048576;
        if (optInt < 5242880) {
            return 5242880L;
        }
        return optInt;
    }

    public long q() {
        long optInt = this.ok.optInt("segment_max_kb", 0) * 1048576;
        if (optInt < h()) {
            return -1L;
        }
        return optInt;
    }

    public long r() {
        long optInt = this.ok.optInt("read_timeout", -1);
        if (optInt >= 4000) {
            return optInt;
        }
        return -1L;
    }

    public int rh() {
        return this.ok.optInt("ratio_segment", 0);
    }

    public int s() {
        return this.ok.optInt("buffer_count", 512);
    }

    public float t() {
        return Math.min(Math.max(0.0f, (float) this.ok.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public float z() {
        return (float) this.ok.optDouble("main_ratio", 0.0d);
    }

    private int a(int i4) {
        int optInt = this.ok.optInt("thread_count", 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return i() == 1 ? Math.min(optInt, i4) : optInt;
        } else if (i() > 0) {
            return i4;
        } else {
            return 1;
        }
    }

    public int ok() {
        return this.f49876a;
    }

    @NonNull
    public static rh ok(@NonNull JSONObject jSONObject) {
        return new rh(jSONObject);
    }
}
