package com.bytedance.sdk.openadsdk.ys.w;

import android.app.Dialog;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import com.bytedance.sdk.openadsdk.ys.w.w.t;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class ux extends t {
    public abstract ev c(Dialog dialog, int[] iArr);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public ev c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        return c(tTDislikeDialogAbstract, tTDislikeDialogAbstract != null ? tTDislikeDialogAbstract.getTTDislikeListViewIds() : new int[0]);
    }

    public abstract void w(Dialog dialog, int[] iArr);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void w(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        w(tTDislikeDialogAbstract, tTDislikeDialogAbstract != null ? tTDislikeDialogAbstract.getTTDislikeListViewIds() : new int[0]);
    }
}
