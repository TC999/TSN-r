package com.kwad.sdk.components;

import android.content.Intent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface l {
    void a(n nVar);

    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z3, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();
}