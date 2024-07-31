package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsConvertButton extends KSCornerButton implements KsAppDownloadListener {
    @Nullable
    private AdTemplate mAdTemplate;
    @Nullable
    private C8619c mApkDownloadHelper;

    public KsConvertButton(Context context) {
        super(context);
    }

    /* renamed from: aX */
    private void m28914aX(@Nullable String str) {
        if (str != null) {
            setText(str);
        }
    }

    @Nullable
    private String getAdActionDesc() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            return C10483a.m25957aE(C10487e.m25641dQ(adTemplate));
        }
        return null;
    }

    /* renamed from: a */
    public final void m28915a(@Nullable C8619c c8619c, AdTemplate adTemplate) {
        this.mApkDownloadHelper = c8619c;
        this.mAdTemplate = adTemplate;
        if (c8619c != null) {
            c8619c.m30151b(this);
        }
        m28914aX(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        m28914aX(adTemplate != null ? C10483a.m25957aE(C10487e.m25641dQ(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        m28914aX(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        m28914aX(adTemplate != null ? C10483a.m25933ac(C10487e.m25641dQ(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        m28914aX("下载中..." + i + "%");
    }

    public KsConvertButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsConvertButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
