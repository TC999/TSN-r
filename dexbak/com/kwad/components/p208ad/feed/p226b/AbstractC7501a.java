package com.kwad.components.p208ad.feed.p226b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.p208ad.feed.monitor.C7601b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;

/* renamed from: com.kwad.components.ad.feed.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC7501a extends AbstractDialogInterface$OnDismissListenerC9367b<AdResultData, AdTemplate> {

    /* renamed from: ex */
    private boolean f25595ex;

    /* renamed from: ey */
    protected long f25596ey;

    /* renamed from: ez */
    protected SimpleImageLoadingListener f25597ez;

    public AbstractC7501a(@NonNull Context context) {
        super(context);
        this.f25597ez = new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.a.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                C7601b.m32815a(AbstractC7501a.this.mAdTemplate, 1, 2, str, null, SystemClock.elapsedRealtime() - AbstractC7501a.this.f25596ey);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                C7601b.m32815a(AbstractC7501a.this.mAdTemplate, 2, 2, str, failReason.toString(), SystemClock.elapsedRealtime() - AbstractC7501a.this.f25596ey);
            }
        };
    }

    /* renamed from: ba */
    public final void m33140ba() {
        if (this.f25595ex) {
            return;
        }
        this.f25595ex = true;
        C7601b.m32814a(this.mAdTemplate, 1, getStayTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: bb */
    public final void m33139bb() {
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(C9659R.C9662id.ksad_compliance_view);
        if (C10483a.m25946aP(this.mAdInfo)) {
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
            return;
        }
        complianceTextView.setVisibility(8);
    }
}
