package com.bytedance.sdk.openadsdk.ys.w;

import android.app.Dialog;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ys.w.w.ys;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class f extends ys {
    public abstract void c(Dialog dialog, int[] iArr);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        c(tTDislikeDialogAbstract, tTDislikeDialogAbstract != null ? tTDislikeDialogAbstract.getTTDislikeListViewIds() : new int[0]);
    }
}
