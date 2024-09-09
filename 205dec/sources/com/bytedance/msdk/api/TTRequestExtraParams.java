package com.bytedance.msdk.api;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TTRequestExtraParams {
    public static final int AD_VIDEO_PLAY_MUTE = 1;
    public static final int AD_VIDEO_PLAY_NOT_MUTE = 2;
    public static final String PARAM_AD_HEIGHT = "ad_height";
    public static final String PARAM_AD_LOAD_TIMEOUT = "ad_load_timeout";
    public static final String PARAM_AD_MUTE = "ad_mute";
    public static final String PARAM_AD_TYPE = "ad_type";
    public static final String PARAM_AD_WIDTH = "ad_width";
    public static final String PARAM_BANNER_ALLOW_SHOW_CLOSE_BTN = "allow_show_close_btn";
    public static final String PARAM_BANNER_REFRESH_TIME = "refresh_time";

    /* renamed from: a  reason: collision with root package name */
    protected Map<String, Object> f27419a;

    public TTRequestExtraParams() {
        this.f27419a = null;
        this.f27419a = new HashMap();
    }

    public Map<String, Object> getExtraObject() {
        Map<String, Object> map = this.f27419a;
        if (map == null) {
            HashMap hashMap = new HashMap();
            this.f27419a = hashMap;
            return hashMap;
        }
        return map;
    }

    public TTRequestExtraParams setExtraObject(String str, Object obj) {
        Map<String, Object> map = this.f27419a;
        if (map != null) {
            map.put(str, obj);
        }
        return this;
    }
}
