package com.bykv.vk.component.ttvideo.log;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public long f24890a = -2147483648L;

    /* renamed from: b  reason: collision with root package name */
    public long f24891b = -2147483648L;

    /* renamed from: c  reason: collision with root package name */
    public long f24892c = -2147483648L;

    /* renamed from: d  reason: collision with root package name */
    public long f24893d = -2147483648L;

    /* renamed from: e  reason: collision with root package name */
    public long f24894e = -2147483648L;

    /* renamed from: f  reason: collision with root package name */
    public long f24895f = -2147483648L;

    /* renamed from: g  reason: collision with root package name */
    public int f24896g = Integer.MIN_VALUE;

    /* renamed from: h  reason: collision with root package name */
    public int f24897h = Integer.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public int f24898i = Integer.MIN_VALUE;

    /* renamed from: j  reason: collision with root package name */
    public int f24899j = Integer.MIN_VALUE;

    /* renamed from: k  reason: collision with root package name */
    public String f24900k = "";

    /* renamed from: l  reason: collision with root package name */
    public String f24901l = "";

    /* renamed from: m  reason: collision with root package name */
    public int f24902m = Integer.MIN_VALUE;

    /* renamed from: n  reason: collision with root package name */
    public String f24903n = "";

    /* renamed from: o  reason: collision with root package name */
    public String f24904o = "";

    /* renamed from: p  reason: collision with root package name */
    public String f24905p = "";

    public static void a(Map map, String str, int i4) {
        if (i4 != Integer.MIN_VALUE) {
            map.put(str, Integer.valueOf(i4));
        }
    }

    public static void a(Map map, String str, long j4) {
        if (j4 != -2147483648L) {
            map.put(str, Long.valueOf(j4));
        }
    }

    public static void a(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    public JSONObject a(c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        a(hashMap, "player_sessionid", this.f24903n);
        a(hashMap, "log_type", "video_playq");
        a(hashMap, "sdk_version", cVar.f24867e);
        a(hashMap, "sv", cVar.f24866d);
        a(hashMap, "pc", cVar.f24865c);
        a(hashMap, "pt", this.f24892c);
        a(hashMap, "vt", this.f24893d);
        a(hashMap, "et", this.f24894e);
        a(hashMap, "lt", this.f24895f);
        a((Map) hashMap, "bc", this.f24896g);
        a((Map) hashMap, "br", this.f24897h);
        a((Map) hashMap, "vd", cVar.f24870h);
        a(hashMap, "initial_url", this.f24900k);
        a(hashMap, "init_audio_url", this.f24901l);
        a((Map) hashMap, "watch_dur", this.f24902m);
        a((Map) hashMap, "errt", this.f24898i);
        a((Map) hashMap, "errc", this.f24899j);
        a(hashMap, "ps_t", this.f24890a);
        a(hashMap, "pt_new", this.f24891b);
        a(hashMap, "play_log_id", this.f24904o);
        a(hashMap, "last_sessionid", this.f24905p);
        return new JSONObject(hashMap);
    }
}
