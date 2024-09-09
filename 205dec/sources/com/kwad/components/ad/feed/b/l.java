package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private TextView eB;
    private ImageView eD;
    private DownloadProgressView eI;
    private long ey;
    private RoundAngleImageView fv;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public l(@NonNull Context context) {
        super(context);
    }

    private void be() {
        this.mLogoView.aD(this.mAdTemplate);
        this.eI.ai(this.mAdTemplate);
        this.eI.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.eI.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.eI.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            bb();
        }
    }

    private void c(View view, final int i4) {
        if (view == this.eD) {
            tk();
        } else {
            com.kwad.components.core.e.d.a.a(new a.C0631a(getContext()).aq(this.mAdTemplate).al(5).am(i4).b(this.mApkDownloadHelper).an(view == this.eI ? 1 : 2).ao(view == this.eI).a(new a.b() { // from class: com.kwad.components.ad.feed.b.l.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    l.this.aL(i4);
                }
            }));
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((l) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        List<String> ba = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        if (ba.size() > 0) {
            this.ey = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.fv, ba.get(0), this.mAdTemplate, this.ez);
        } else {
            com.kwad.sdk.core.e.c.e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        be();
        com.kwad.sdk.d.a.a.a(this, this.eB, this.fv, this.eI, this.eD);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.fv, this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.eB = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.fv = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.d.a.a.a(getContext(), 3.0f));
        this.eD = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.eI = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eI.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_right_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4;
        if (view == this.eB) {
            i4 = 25;
        } else if (view == this.fv) {
            i4 = 100;
        } else {
            i4 = view == this.eI ? 1 : 35;
        }
        c(view, i4);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            c(view, 153);
        }
    }
}
