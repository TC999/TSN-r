package com.kwad.components.core.n.b.d;

import android.content.Context;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.components.offline.api.core.webview.IWebView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements IWebView {
    @Override // com.kwad.components.offline.api.core.webview.IWebView
    public final BaseKsWebView createWebView(Context context) {
        return new a(context);
    }
}
