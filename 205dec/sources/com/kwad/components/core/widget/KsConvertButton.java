package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsConvertButton extends KSCornerButton implements KsAppDownloadListener {
    @Nullable
    private AdTemplate mAdTemplate;
    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public KsConvertButton(Context context) {
        super(context);
    }

    private void aX(@Nullable String str) {
        if (str != null) {
            setText(str);
        }
    }

    @Nullable
    private String getAdActionDesc() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            return com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        }
        return null;
    }

    public final void a(@Nullable com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
        this.mApkDownloadHelper = cVar;
        this.mAdTemplate = adTemplate;
        if (cVar != null) {
            cVar.b(this);
        }
        aX(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        aX(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "\u7acb\u5373\u4e0b\u8f7d");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        aX(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        aX(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "\u7acb\u5373\u6253\u5f00");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i4) {
        aX("\u4e0b\u8f7d\u4e2d..." + i4 + "%");
    }

    public KsConvertButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @RequiresApi(api = 21)
    public KsConvertButton(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
