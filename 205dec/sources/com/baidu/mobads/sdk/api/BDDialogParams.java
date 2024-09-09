package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BDDialogParams {
    public static final int ANIM_STYLE_BREATHE = 1;
    public static final int ANIM_STYLE_GUIDE = 3;
    public static final int ANIM_STYLE_NONE = 0;
    public static final int ANIM_STYLE_SWIPE = 2;
    public static final int TYPE_BOTTOM_POPUP = 0;
    public static final int TYPE_CENTER_DECORATE = 2;
    public static final int TYPE_CENTER_NORMAL = 1;
    private final Builder mBuilder;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Builder {
        private int mDlDialogType = 0;
        private int mDlDialogAnimStyle = 0;

        public BDDialogParams build() {
            return new BDDialogParams(this);
        }

        public Builder setDlDialogAnimStyle(int i4) {
            this.mDlDialogAnimStyle = i4;
            return this;
        }

        public Builder setDlDialogType(int i4) {
            this.mDlDialogType = i4;
            return this;
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.mBuilder.mDlDialogType);
            jSONObject.put("anim_style", this.mBuilder.mDlDialogAnimStyle);
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        return jSONObject;
    }

    private BDDialogParams(Builder builder) {
        this.mBuilder = builder;
    }
}
