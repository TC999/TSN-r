package com.bykv.vk.openvk.component.video.api.xv;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private String f24941c;
    private int ev;

    /* renamed from: w  reason: collision with root package name */
    private String f24944w;
    private long xv = -2147483648L;
    private int sr = Integer.MIN_VALUE;
    private long ux = -2147483648L;

    /* renamed from: f  reason: collision with root package name */
    private double f24942f = -2.147483648E9d;

    /* renamed from: r  reason: collision with root package name */
    private double f24943r = -2.147483648E9d;

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f24944w)) {
                jSONObject.putOpt("audio_url", this.f24944w);
            }
            if (!TextUtils.isEmpty(this.f24941c)) {
                jSONObject.putOpt("file_hash", this.f24941c);
            }
            long j4 = this.xv;
            if (j4 > 0) {
                jSONObject.put("size", j4);
            }
            int i4 = this.sr;
            if (i4 >= 0) {
                jSONObject.put("reward_audio_cached_type", i4);
            }
            long j5 = this.ux;
            if (j5 >= 0) {
                jSONObject.put("audio_preload_size", j5);
            }
            double d4 = this.f24942f;
            if (d4 > 0.0d) {
                jSONObject.put("audio_duration", d4);
            }
            double d5 = this.f24943r;
            if (d5 > 0.0d) {
                jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_START, d5);
            }
            int i5 = this.ev;
            if (i5 > 0) {
                jSONObject.put("repeat_count", i5);
            }
            return jSONObject;
        } catch (Exception e4) {
            com.bykv.vk.openvk.component.video.api.f.xv.c(e4.getMessage());
            return null;
        }
    }

    public double f() {
        return this.f24942f;
    }

    public int r() {
        return this.ev;
    }

    public double sr() {
        return this.f24943r;
    }

    public String ux() {
        return this.f24944w;
    }

    public String w() {
        return this.f24941c;
    }

    public long xv() {
        return this.xv;
    }

    public void w(long j4) {
        this.ux = j4;
    }

    public void w(String str) {
        this.f24944w = str;
    }

    public void w(double d4) {
        this.f24942f = d4;
    }

    public void w(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        this.ev = i4;
    }

    public void c(String str) {
        this.f24941c = str;
    }

    public void c(long j4) {
        this.xv = j4;
    }

    public void c(int i4) {
        this.sr = i4;
    }

    public void c(double d4) {
        this.f24943r = d4;
    }
}
