package com.bytedance.msdk.c;

import android.app.Activity;
import android.app.Dialog;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface xv {
    ev getDislikeDialog(Activity activity);

    ev getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    com.bytedance.sdk.openadsdk.ys.w.w.sr getDislikeInfo();

    void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar);

    void setDislikeDialog(Dialog dialog);

    void uploadDislikeEvent(String str);
}
