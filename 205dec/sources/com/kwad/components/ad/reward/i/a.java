package com.kwad.components.ad.reward.i;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.n;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.v;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements n {
    @Nullable
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.e.n
    public final boolean gT() {
        Context context = this.mContext;
        if (context != null) {
            v.c(this.mContext, context.getResources().getString(R.string.ksad_reward_playable_load_error_toast), 0L);
            return true;
        }
        return true;
    }
}
