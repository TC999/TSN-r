package com.bytedance.msdk.api;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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

    /* renamed from: a */
    protected Map<String, Object> f21688a;

    public TTRequestExtraParams() {
        this.f21688a = null;
        this.f21688a = new HashMap();
    }

    public Map<String, Object> getExtraObject() {
        Map<String, Object> map = this.f21688a;
        if (map == null) {
            HashMap hashMap = new HashMap();
            this.f21688a = hashMap;
            return hashMap;
        }
        return map;
    }

    public TTRequestExtraParams setExtraObject(String str, Object obj) {
        Map<String, Object> map = this.f21688a;
        if (map != null) {
            map.put(str, obj);
        }
        return this;
    }
}
