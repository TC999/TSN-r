package com.bytedance.android.live.base.api.push;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.push.model.PushData;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ILivePush {
    public static final String TAG = "livePush";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class ClickType {
        public static final String CLOSE = "close";
        public static final String LIVE = "live";
        private String value;

        public ClickType() {
        }

        public ClickType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class PushType {
        public static final int CLOD_LAUNCH = 2;
        public static final int SELF_DRIVING = 1;
        public static final int VIDEO = 3;
        private int value;

        public PushType() {
        }

        public PushType(int i4) {
            this.value = i4;
        }

        public final int getValue() {
            return this.value;
        }
    }

    void addPushInterceptor(PushInterceptor pushInterceptor);

    void clickPush(PushData pushData, Context context);

    void dismiss();

    void enterRoom(Context context, PushData pushData);

    boolean isShowing();

    void removePushInterceptor(PushInterceptor pushInterceptor);

    void reportPushClick(PushData pushData, ClickType clickType);

    void reportShow(PushData pushData);

    void requestPush(PushCallback pushCallback);

    void requestPushAndShow(boolean z3, Activity activity, PushType pushType, PushCallback pushCallback, PushUIConfig pushUIConfig);

    void requestPushAndShow(boolean z3, Activity activity, PushType pushType, PushCallback pushCallback, PushUIConfig pushUIConfig, Bundle bundle);
}
