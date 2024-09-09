package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class t {

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f49641c;

    /* renamed from: w  reason: collision with root package name */
    private int f49642w;

    private t(JSONObject jSONObject) {
        this.f49641c = jSONObject;
    }

    private int fp() {
        return this.f49641c.optInt("url_balance", 2);
    }

    public int a() {
        return this.f49641c.optInt("ip_strategy", 0);
    }

    public float bk() {
        return (float) this.f49641c.optDouble("main_ratio", 0.0d);
    }

    public void c(int i4) {
        this.f49642w = w(i4);
    }

    public long ev() {
        long optInt = this.f49641c.optInt("segment_min_init_mb", 10) * 1048576;
        if (optInt < 5242880) {
            return 5242880L;
        }
        return optInt;
    }

    public boolean f() {
        return this.f49641c.optInt("segment_mode", 1) == 0;
    }

    public long gd() {
        long optInt = this.f49641c.optInt("segment_max_kb", 0) * 1048576;
        if (optInt < r()) {
            return -1L;
        }
        return optInt;
    }

    public long k() {
        long optInt = this.f49641c.optInt("read_timeout", -1);
        if (optInt >= 4000) {
            return optInt;
        }
        return -1L;
    }

    public long p() {
        long optInt = this.f49641c.optInt("connect_timeout", -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1L;
    }

    public long r() {
        long optInt = this.f49641c.optInt("segment_min_kb", 512) * 1024;
        if (optInt < 65536) {
            return 65536L;
        }
        return optInt;
    }

    public int sr() {
        return this.f49641c.optInt("buffer_count", 512);
    }

    public int t() {
        return this.f49641c.optInt("ratio_segment", 0);
    }

    public int ux() {
        return this.f49641c.optInt("buffer_size", 8192);
    }

    public boolean w() {
        return fp() > 0;
    }

    public boolean xv() {
        return fp() == 1;
    }

    public float ys() {
        return Math.min(Math.max(0.0f, (float) this.f49641c.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    private int w(int i4) {
        int optInt = this.f49641c.optInt("thread_count", 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return fp() == 1 ? Math.min(optInt, i4) : optInt;
        } else if (fp() > 0) {
            return i4;
        } else {
            return 1;
        }
    }

    public int c() {
        return this.f49642w;
    }

    @NonNull
    public static t c(@NonNull JSONObject jSONObject) {
        return new t(jSONObject);
    }
}
