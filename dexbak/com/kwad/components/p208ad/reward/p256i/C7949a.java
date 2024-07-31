package com.kwad.components.p208ad.reward.p256i;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.utils.C11128v;

/* renamed from: com.kwad.components.ad.reward.i.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7949a implements InterfaceC7894n {
    @Nullable
    private Context mContext;

    public C7949a(Context context) {
        this.mContext = context;
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7894n
    /* renamed from: gT */
    public final boolean mo31940gT() {
        Context context = this.mContext;
        if (context != null) {
            C11128v.m23668c(this.mContext, context.getResources().getString(C9659R.C9664string.ksad_reward_playable_load_error_toast), 0L);
            return true;
        }
        return true;
    }
}
