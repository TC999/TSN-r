package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SplashFocusParams {
    private final Builder mBuilder;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Builder {
        private int iconRightMarginDp = 15;
        private int iconBottomMarginDp = 95;
        private int iconSizeDp = 44;
        private boolean autoAnimOffset = true;
        private int animOffsetPx = 0;
        private double darkAlpha = 0.0d;

        public SplashFocusParams build() {
            return new SplashFocusParams(this);
        }

        @Deprecated
        public Builder setAnimOffsetPx(int i4) {
            this.autoAnimOffset = false;
            this.animOffsetPx = i4;
            return this;
        }

        public Builder setDarkAlpha(double d4) {
            this.darkAlpha = d4;
            return this;
        }

        public Builder setIconBottomMarginDp(int i4) {
            this.iconBottomMarginDp = i4;
            return this;
        }

        public Builder setIconRightMarginDp(int i4) {
            this.iconRightMarginDp = i4;
            return this;
        }

        public Builder setIconSizeDp(int i4) {
            this.iconSizeDp = i4;
            return this;
        }
    }

    public SplashFocusParams(Builder builder) {
        this.mBuilder = builder;
    }

    public JSONObject getFocusParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", this.mBuilder.iconRightMarginDp);
            jSONObject.put("bottom_margin", this.mBuilder.iconBottomMarginDp);
            jSONObject.put("icon_size", this.mBuilder.iconSizeDp);
            if (!this.mBuilder.autoAnimOffset) {
                jSONObject.put("anim_offset_y", this.mBuilder.animOffsetPx);
            }
            jSONObject.put("icon_dark_alpha", this.mBuilder.darkAlpha);
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        return jSONObject;
    }
}
