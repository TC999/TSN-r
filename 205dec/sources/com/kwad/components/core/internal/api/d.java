package com.kwad.components.core.internal.api;

import android.text.TextUtils;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.KsImage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d implements KsImage {
    private int height;
    private String imageUrl;
    private int width;

    public d(int i4, int i5, String str) {
        this.width = i4;
        this.height = i5;
        this.imageUrl = str;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.b(KsImage.class, d.class);
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.height;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.width;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.width > 0 && this.height > 0 && !TextUtils.isEmpty(this.imageUrl);
    }
}
