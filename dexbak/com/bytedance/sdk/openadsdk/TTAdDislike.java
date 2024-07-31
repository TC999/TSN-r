package com.bytedance.sdk.openadsdk;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface TTAdDislike {

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i, String str, boolean z);

        void onShow();
    }

    boolean isShow();

    void resetDislikeStatus();

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeSource(String str);

    void showDislikeDialog();
}
