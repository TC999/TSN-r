package com.bytedance.sdk.component.adexpress.dynamic.xv;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.ad.control.interaction.view.InteractionCommon;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, Integer> f29381c;

    /* renamed from: f  reason: collision with root package name */
    private String f29382f;
    private f sr;
    private f ux;

    /* renamed from: w  reason: collision with root package name */
    private String f29383w;
    private String xv;

    static {
        HashMap hashMap = new HashMap();
        f29381c = hashMap;
        hashMap.put("root", 8);
        hashMap.put("footer", 6);
        hashMap.put("empty", 6);
        hashMap.put("title", 0);
        hashMap.put(MediaFormat.KEY_SUBTITLE, 0);
        hashMap.put("source", 0);
        hashMap.put("score-count", 0);
        hashMap.put("text_star", 0);
        hashMap.put("text", 0);
        hashMap.put("tag-group", 17);
        hashMap.put("app-version", 0);
        hashMap.put("development-name", 0);
        hashMap.put("privacy-detail", 23);
        hashMap.put("image", 1);
        hashMap.put("image-wide", 1);
        hashMap.put("image-square", 1);
        hashMap.put("image-long", 1);
        hashMap.put("image-splash", 1);
        hashMap.put("image-cover", 1);
        hashMap.put("app-icon", 1);
        hashMap.put("icon-download", 1);
        hashMap.put("logoad", 4);
        hashMap.put("logounion", 5);
        hashMap.put("logo-union", 9);
        hashMap.put(InteractionCommon.DISLIKE_TYPE_EXECUTION, 3);
        hashMap.put("close", 3);
        hashMap.put("close-fill", 3);
        hashMap.put("webview-close", 22);
        hashMap.put("feedback-dislike", 12);
        hashMap.put("button", 2);
        hashMap.put("downloadWithIcon", 2);
        hashMap.put("downloadButton", 2);
        hashMap.put("fillButton", 2);
        hashMap.put("laceButton", 2);
        hashMap.put("cardButton", 2);
        hashMap.put("colourMixtureButton", 2);
        hashMap.put("arrowButton", 1);
        hashMap.put("download-progress-button", 2);
        hashMap.put("vessel", 6);
        hashMap.put("image-group", 6);
        hashMap.put("custom-component-vessel", 6);
        hashMap.put("carousel", 24);
        hashMap.put("carousel-vessel", 26);
        hashMap.put("leisure-interact", 25);
        hashMap.put("video-hd", 7);
        hashMap.put("video", 7);
        hashMap.put("video-vd", 7);
        hashMap.put("video-sq", 7);
        hashMap.put("muted", 10);
        hashMap.put("star", 11);
        hashMap.put("skip-countdowns", 19);
        hashMap.put("skip-with-countdowns-skip-btn", 21);
        hashMap.put("skip-with-countdowns-video-countdown", 13);
        hashMap.put("skip-with-countdowns-skip-countdown", 20);
        hashMap.put("skip-with-time", 14);
        hashMap.put("skip-with-time-countdown", 13);
        hashMap.put("skip-with-time-skip-btn", 15);
        hashMap.put("skip", 27);
        hashMap.put("timedown", 13);
        hashMap.put(RewardPlus.ICON, 16);
        hashMap.put("scoreCountWithIcon", 6);
        hashMap.put("split-line", 18);
        hashMap.put("creative-playable-bait", 0);
        hashMap.put("score-count-type-2", 0);
        hashMap.put("lottie", 28);
    }

    public int c() {
        if (TextUtils.isEmpty(this.f29383w)) {
            return 0;
        }
        if (this.f29383w.equals("logo")) {
            String str = this.f29383w + this.xv;
            this.f29383w = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.f29383w.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = f29381c;
        if (map.get(this.f29383w) != null) {
            return map.get(this.f29383w).intValue();
        }
        return -1;
    }

    public f f() {
        return this.ux;
    }

    public String getType() {
        return this.f29383w;
    }

    public f sr() {
        return this.sr;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.f29383w + "', data='" + this.xv + "', value=" + this.sr + ", themeValue=" + this.ux + ", dataExtraInfo='" + this.f29382f + "'}";
    }

    public int ux() {
        return this.sr.xg();
    }

    public String w() {
        return this.xv;
    }

    public void xv(String str) {
        this.f29382f = str;
    }

    public void w(String str) {
        this.xv = str;
    }

    public String xv() {
        return this.f29382f;
    }

    public void w(f fVar) {
        this.ux = fVar;
    }

    public void c(String str) {
        this.f29383w = str;
    }

    public void c(f fVar) {
        this.sr = fVar;
    }
}
