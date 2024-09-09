package com.kwad.components.core.widget.a;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bq;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends a {
    private View mRootView;

    public b(@NonNull View view, int i4) {
        super(view, i4);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public boolean dW() {
        return bq.a(this.mRootView, 70, true);
    }
}
