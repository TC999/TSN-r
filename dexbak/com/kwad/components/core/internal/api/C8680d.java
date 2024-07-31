package com.kwad.components.core.internal.api;

import android.text.TextUtils;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.service.C10973b;

/* renamed from: com.kwad.components.core.internal.api.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8680d implements KsImage {
    private int height;
    private String imageUrl;
    private int width;

    public C8680d(int i, int i2, String str) {
        this.width = i;
        this.height = i2;
        this.imageUrl = str;
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        C10973b.m24290b(KsImage.class, C8680d.class);
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
