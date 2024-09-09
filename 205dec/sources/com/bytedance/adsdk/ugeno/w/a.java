package com.bytedance.adsdk.ugeno.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum a {
    UNKNOWN_EVENT("UNKNOWN_EVENT", 0),
    TAP_EVENT("onTap", 1),
    LONG_TAP_EVENT("onLongTap", 2),
    SHAKE_EVENT("onShake", 3),
    SLIDE_EVENT("onSlide", 4),
    EXPOSURE_EVENT("onExposure", 5),
    SCROLL_EVENT("onScroll", 6),
    PULL_TO_REFRESH_EVENT("onPullToRefresh", 7),
    LOAD_MORE_EVENT("onLoadMore", 8),
    TIMER("onTimer", 9),
    DELAY("onDelay", 10),
    ANIMATION("onAnimation", 11),
    VIDEO_PROGRESS("onVideoProgress", 12),
    VIDEO_PAUSE("onVideoPause", 13),
    VIDEO_RESUME("onVideoResume", 14),
    VIDEO_FINISH("onVideoFinish", 15),
    VIDEO_PLAY("onVideoPlay", 16),
    DOWN_EVENT("onDown", 17);
    
    private String fz;

    /* renamed from: u  reason: collision with root package name */
    private int f26339u;

    a(String str, int i4) {
        this.fz = str;
        this.f26339u = i4;
    }

    public static a c(String str) {
        a[] values;
        for (a aVar : values()) {
            if (aVar.fz.equals(str)) {
                return aVar;
            }
        }
        return UNKNOWN_EVENT;
    }

    public int getType() {
        return this.f26339u;
    }
}
