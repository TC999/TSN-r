package com.kwad.components.ad.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.b;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class FeedDownloadActivityProxy extends com.kwad.components.core.proxy.c implements View.OnClickListener {
    private static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    private static final String TAG = "FeedDownloadActivity";
    private static b.a sInnerAdInteractionListener;
    private KsAdContainer mAdContainer;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private TailFrameBarAppPortraitVertical mAppTailFrameView;
    private TextProgressBar mProgressBarTv;

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.aE(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.bY(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.aE(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.ac(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i4) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.dn(i4), i4);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i4) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.dm(i4), i4);
            }
        });
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, b.a aVar) {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, FeedDownloadActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        sInnerAdInteractionListener = aVar;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.mAdContainer.getTouchCoords()), (JSONObject) null);
        b.a aVar = sInnerAdInteractionListener;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        return this.mAdTemplate != null;
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.mAppTailFrameView;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.km();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        return R.layout.ksad_activity_feed_download;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return "FeedDownloadActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        KsAdContainer ksAdContainer = (KsAdContainer) findViewById(R.id.ksad_container);
        this.mAdContainer = ksAdContainer;
        ksAdContainer.setOnClickListener(this);
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_download_container);
        this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.b(this.mAdTemplate);
        this.mAppTailFrameView.D(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv = textProgressBar;
        textProgressBar.setOnClickListener(this);
        bindDownloadListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.e.d.a.a(new a.C0631a(view.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(view == this.mProgressBarTv ? 1 : 2).ao(view == this.mProgressBarTv).a(new a.b() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    FeedDownloadActivityProxy.this.notifyAdClick();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        destroy();
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }
}
