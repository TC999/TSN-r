package com.bykv.vk.openvk.component.video.api.xv;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: a  reason: collision with root package name */
    private int f24960a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    private int f24961c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f24962f;
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private double f24963k;

    /* renamed from: p  reason: collision with root package name */
    private String f24964p;

    /* renamed from: r  reason: collision with root package name */
    private String f24965r;
    private double sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private int f24969w;
    private long xv;

    /* renamed from: t  reason: collision with root package name */
    private float f24967t = -1.0f;
    private int ys = 0;
    private int fp = 0;
    private int ia = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f24966s = 0;
    private int fz = 307200;

    /* renamed from: u  reason: collision with root package name */
    private int f24968u = 1;

    public String a() {
        return this.f24965r;
    }

    public String bk() {
        return this.ev;
    }

    public int c() {
        return this.f24960a;
    }

    public float ev() {
        return this.f24967t;
    }

    public double f() {
        return this.sr;
    }

    public int fp() {
        if (this.fz < 0) {
            this.fz = 307200;
        }
        long j4 = this.xv;
        if (this.fz > j4) {
            this.fz = (int) j4;
        }
        return this.fz;
    }

    public JSONObject fz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", w());
            jSONObject.put("cover_url", k());
            jSONObject.put("cover_width", xv());
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, bk());
            jSONObject.put("file_hash", ys());
            jSONObject.put("resolution", gd());
            jSONObject.put("size", ux());
            jSONObject.put("video_duration", f());
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, a());
            jSONObject.put("playable_download_url", t());
            jSONObject.put("if_playable_loading_show", u());
            jSONObject.put("remove_loading_page_type", i());
            jSONObject.put("fallback_endcard_judge", c());
            jSONObject.put("video_preload_size", fp());
            jSONObject.put("reward_video_cached_type", ia());
            jSONObject.put("execute_cached_type", s());
            jSONObject.put("endcard_render", sr());
            jSONObject.put("replay_time", ls());
            jSONObject.put("play_speed_ratio", ev());
            if (r() > 0.0d) {
                jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_START, r());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String gd() {
        return this.ux;
    }

    public int i() {
        return this.fp;
    }

    public int ia() {
        return this.ia;
    }

    public boolean j() {
        return this.ia == 0;
    }

    public String k() {
        return this.f24962f;
    }

    public int ls() {
        return this.f24968u;
    }

    public int[] p() {
        try {
            int indexOf = this.ux.indexOf("x");
            return new int[]{Integer.parseInt(this.ux.substring(0, indexOf).trim()), Integer.parseInt(this.ux.substring(indexOf + 1).trim())};
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.xv.xv("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public boolean q() {
        return this.f24966s == 1;
    }

    public double r() {
        return this.f24963k;
    }

    public int s() {
        return this.f24966s;
    }

    public int sr() {
        return this.bk;
    }

    public String t() {
        return this.gd;
    }

    public int u() {
        return this.ys;
    }

    public long ux() {
        return this.xv;
    }

    public int w() {
        return this.f24961c;
    }

    public int xv() {
        return this.f24969w;
    }

    public String ys() {
        if (TextUtils.isEmpty(this.f24964p)) {
            this.f24964p = com.bykv.vk.openvk.component.video.api.f.w.c(this.f24965r);
        }
        return this.f24964p;
    }

    public void c(int i4) {
        this.f24960a = i4;
    }

    public void f(int i4) {
        this.f24966s = i4;
    }

    public void sr(String str) {
        this.ev = str;
    }

    public void ux(String str) {
        this.f24964p = str;
    }

    public void w(int i4) {
        this.f24961c = i4;
    }

    public void xv(int i4) {
        this.f24969w = i4;
    }

    public void c(long j4) {
        this.xv = j4;
    }

    public void sr(int i4) {
        this.fz = i4;
    }

    public void ux(int i4) {
        this.ia = i4;
    }

    public void w(double d4) {
        this.f24963k = d4;
    }

    public void xv(String str) {
        this.f24965r = str;
    }

    public void c(double d4) {
        this.sr = d4;
    }

    public void w(String str) {
        this.f24962f = str;
    }

    public void c(float f4) {
        this.f24967t = f4;
    }

    public void c(String str) {
        this.ux = str;
    }
}
