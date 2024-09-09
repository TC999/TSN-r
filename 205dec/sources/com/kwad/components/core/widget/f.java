package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ai;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f extends FrameLayout {
    private boolean acs;
    protected boolean iD;

    /* renamed from: if  reason: not valid java name */
    protected g f2if;
    @NonNull
    protected Context mContext;

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.iD = ai.LZ();
    }

    private void tu() {
        boolean LZ = ai.LZ();
        if (!this.acs || LZ == this.iD) {
            return;
        }
        this.iD = LZ;
        g gVar = this.f2if;
        if (gVar != null) {
            gVar.j(!LZ);
        }
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        tu();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        this.acs = i4 == 0;
        tu();
    }

    public final void setOrientationChangeListener(g gVar) {
        this.f2if = gVar;
    }
}
