package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private TextView eB;
    private ImageView eC;
    private ImageView eD;
    private KsLogoView mLogoView;

    public j(@NonNull Context context) {
        super(context);
    }

    private void c(View view, int i4) {
        if (view == this.eD) {
            tk();
        } else if (com.kwad.components.core.e.d.d.a(new a.C0631a(getContext()).aq(this.mAdTemplate), 1) == 1) {
            aL(i4);
        } else if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            aL(i4);
            FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.abm);
        } else {
            aL(i4);
            AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((j) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        List<String> ba = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        this.mLogoView.aD(this.mAdTemplate);
        if (ba.size() > 0) {
            KSImageLoader.loadFeeImage(this.eC, ba.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.e.c.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        com.kwad.sdk.d.a.a.a(this, this.eB, this.eC, this.eD);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eC, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            bb();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.5600000023841858d);
        this.eB = (TextView) findViewById(R.id.ksad_ad_desc);
        this.eC = (ImageView) findViewById(R.id.ksad_ad_image);
        this.eD = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4;
        if (view == this.eB) {
            i4 = 25;
        } else {
            i4 = view == this.eC ? 100 : 35;
        }
        c(view, i4);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            c(view, 153);
        }
    }
}
