package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p301l.AbstractC8691b;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.p330s.C8936c;
import com.kwad.components.core.page.p321c.C8829d;
import com.kwad.components.core.page.p321c.C8830e;
import com.kwad.components.core.page.p321c.C8832f;
import com.kwad.components.core.page.p323d.C8839a;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.service.C10973b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadLandPageActivity extends AbstractC8691b<C8829d> {
    public static final String KEY_NEED_CLOSE_REWARD = "key_close_reward";
    public static final String KEY_TEMPLATE = "key_template_json";
    private static final String TAG = "DownloadLandPageActivity";
    public static boolean showingAdWebViewLandPage;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    private ImageView mBackIcon;
    private ImageView mCloseIcon;
    private DetailVideoView mDetailVideoView;
    private boolean mIsRewardLandPage;
    private KSRelativeLayout mKsadVideoContainer;
    private C8839a mPlayModule;
    private ImageView mVideoBlurBg;
    private ImageView mVideoCover;
    private InterfaceC9001k mVideoPlayStateListener;

    private void buildView(ComplianceTextView complianceTextView, KSLinearLayout kSLinearLayout, KsLogoView ksLogoView) {
        if (C10483a.m25877bc(C10487e.m25641dQ(this.mAdTemplate))) {
            return;
        }
        ((FrameLayout.LayoutParams) complianceTextView.getLayoutParams()).gravity = 80;
        if (!C11015ai.m24123LZ()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ksLogoView.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, C10751a.m24924a(this.mContext, 100.0f));
            ksLogoView.setLayoutParams(marginLayoutParams);
        }
        ksLogoView.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kSLinearLayout.getLayoutParams();
        layoutParams.gravity = 17;
        kSLinearLayout.setLayoutParams(layoutParams);
    }

    private InterfaceC9001k getVideoPlayStateListener() {
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.6
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(8);
            }
        };
        this.mVideoPlayStateListener = c9002l;
        return c9002l;
    }

    @NonNull
    private C8832f.InterfaceC8835a getWebViewStateListener() {
        return new C8832f.InterfaceC8835a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.3
            @Override // com.kwad.components.core.page.p321c.C8832f.InterfaceC8835a
            /* renamed from: aA */
            public final void mo29768aA(int i) {
                if (i != 1) {
                    DownloadLandPageActivity.this.initNativeLandPage();
                }
            }
        };
    }

    private void handleCloseBtn() {
        long m25923am = C10483a.m25923am(this.mAdInfo);
        if (m25923am == 0) {
            this.mCloseIcon.setVisibility(0);
        } else {
            this.mCloseIcon.postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.7
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (DownloadLandPageActivity.this.getActivity() == null || DownloadLandPageActivity.this.getActivity().isFinishing()) {
                        return;
                    }
                    DownloadLandPageActivity.this.mCloseIcon.setVisibility(0);
                    DownloadLandPageActivity.this.mCloseIcon.setAlpha(0.0f);
                    DownloadLandPageActivity.this.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
                }
            }, m25923am);
        }
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    C8936c.m29567qZ().m29566ra();
                    DownloadLandPageActivity.this.finish();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNativeLandPage() {
        findViewById(C9659R.C9662id.ksad_ad_land_page_native).setVisibility(0);
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(C9659R.C9662id.ksad_compliance_view);
        complianceTextView.setVisibility(0);
        complianceTextView.setAdTemplate(this.mAdTemplate);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(C9659R.C9662id.ksad_ad_cover);
        KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(C9659R.C9662id.ksad_info_container);
        KsLogoView ksLogoView = (KsLogoView) findViewById(C9659R.C9662id.ksad_land_page_logo);
        DownloadProgressBar downloadProgressBar = (DownloadProgressBar) findViewById(C9659R.C9662id.ksad_web_download_progress);
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        setAdTitle((TextView) findViewById(C9659R.C9662id.ksad_ad_title), m25641dQ);
        ((TextView) findViewById(C9659R.C9662id.ksad_ad_info)).setText(m25641dQ.adBaseInfo.adDescription);
        roundAngleImageView.setRadius(32.0f);
        if (!TextUtils.isEmpty(C10483a.m25820cf(m25641dQ))) {
            KSImageLoader.loadImage(roundAngleImageView, C10483a.m25820cf(m25641dQ), this.mAdTemplate);
        }
        setAdkDownload(downloadProgressBar, m25641dQ);
        buildView(complianceTextView, kSLinearLayout, ksLogoView);
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z) {
        Class cls = C11015ai.m24123LZ() ? AdWebViewActivity.class : KsFullScreenLandScapeVideoActivity.class;
        C10973b.m24291a(cls, DownloadLandPageActivity.class);
        Intent intent = new Intent(context, cls);
        intent.addFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_NEED_CLOSE_REWARD, z);
        context.startActivity(intent);
    }

    private void loadBlurImage(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setVisibility(0);
        KSImageLoader.loadImage(imageView, str, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }

    private void setAdTitle(TextView textView, AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adBaseInfo.appName)) {
            textView.setText(adInfo.adBaseInfo.appName);
        } else if (TextUtils.isEmpty(adInfo.advertiserInfo.rawUserName)) {
        } else {
            textView.setText(adInfo.advertiserInfo.rawUserName);
        }
    }

    private void setAdkDownload(final DownloadProgressBar downloadProgressBar, final AdInfo adInfo) {
        if (C10483a.m25956aF(adInfo)) {
            this.mApkDownloadHelper = new C8619c(this.mAdTemplate, new AbstractC10298a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.4
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(C10483a.m25957aE(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(C10483a.m25882bY(DownloadLandPageActivity.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(C10483a.m25957aE(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(C10483a.m25933ac(adInfo));
                }

                @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
                public final void onPaused(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(C10483a.m25794dn(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    downloadProgressBar.setProgress(i);
                    downloadProgressBar.setText(C10483a.m25795dm(i));
                }
            });
            downloadProgressBar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C9908c.m27287p(DownloadLandPageActivity.this.mAdTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION);
                    DownloadLandPageActivity.this.mApkDownloadHelper.m30128r(new C8615a.C8616a(DownloadLandPageActivity.this.getActivity()).m30202ao(true).m30200ap(false).m30198aq(DownloadLandPageActivity.this.mAdTemplate).m30195ar(false));
                    if (DownloadLandPageActivity.this.mIsRewardLandPage) {
                        C9908c.m27340a(DownloadLandPageActivity.this.mAdTemplate, new C9913b(), (JSONObject) null);
                    }
                }
            });
        }
    }

    private void setVideoData() {
        ViewGroup.LayoutParams layoutParams = this.mKsadVideoContainer.getLayoutParams();
        if (C11015ai.m24123LZ()) {
            layoutParams.height = (C10751a.getScreenWidth(this.mContext) * 9) / 16;
            layoutParams.width = -1;
        } else {
            layoutParams.width = C10751a.getScreenWidth(this.mContext) / 2;
            layoutParams.height = -1;
        }
        this.mKsadVideoContainer.setLayoutParams(layoutParams);
        this.mKsadVideoContainer.setVisibility(0);
        KSImageLoader.loadImage(this.mVideoCover, C10483a.m25862br(this.mAdInfo).getUrl(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            if (stringExtra != null) {
                adTemplate.parseJson(new JSONObject(stringExtra));
            }
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
        return this.mAdTemplate != null;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public int getLayoutId() {
        if (C11015ai.m24123LZ()) {
            return C9659R.C9663layout.ksad_activity_ad_land_page;
        }
        return C9659R.C9663layout.ksad_activity_land_page_horizontal;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public String getPageName() {
        return TAG;
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initData() {
        showingAdWebViewLandPage = true;
        this.mIsRewardLandPage = getIntent().getBooleanExtra(KEY_NEED_CLOSE_REWARD, false);
        this.mAdInfo = C10487e.m25641dQ(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    public void initView() {
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(C9659R.C9662id.ksad_root_container);
        this.mKsadVideoContainer = (KSRelativeLayout) findViewById(C9659R.C9662id.ksad_video_container);
        DetailVideoView detailVideoView = (DetailVideoView) kSRelativeLayout.findViewById(C9659R.C9662id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.m29516g(true, C10251d.m26559CC());
        this.mVideoBlurBg = (ImageView) kSRelativeLayout.findViewById(C9659R.C9662id.ksad_video_blur_bg);
        this.mBackIcon = (ImageView) kSRelativeLayout.findViewById(C9659R.C9662id.ksad_back_icon);
        this.mCloseIcon = (ImageView) kSRelativeLayout.findViewById(C9659R.C9662id.ksad_right_close);
        this.mVideoCover = (ImageView) kSRelativeLayout.findViewById(C9659R.C9662id.ksad_video_cover);
        if (this.mAdTemplate.adInfoList.size() > 0) {
            loadBlurImage(C10483a.m25964X(this.mAdTemplate.adInfoList.get(0)), this.mVideoBlurBg);
        }
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    C9908c.m27287p(DownloadLandPageActivity.this.mAdTemplate, 153);
                    DownloadLandPageActivity.this.finish();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (C10483a.m25877bc(C10487e.m25641dQ(this.mAdTemplate))) {
            setVideoData();
        }
        if (this.mIsRewardLandPage) {
            handleCloseBtn();
        }
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        if (C10483a.m25877bc(C10487e.m25641dQ(this.mAdTemplate))) {
            presenter.m24612a(new C8830e());
        }
        presenter.m24612a(new C8832f(getWebViewStateListener(), this.mIsRewardLandPage));
        return presenter;
    }

    @Override // com.kwad.components.core.p301l.AbstractC8691b, com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            showingAdWebViewLandPage = false;
            C8619c c8619c = this.mApkDownloadHelper;
            if (c8619c != null) {
                c8619c.clear();
            }
            C8839a c8839a = this.mPlayModule;
            if (c8839a != null) {
                c8839a.release();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.p301l.AbstractC8691b
    public C8829d onCreateCallerContext() {
        C8829d c8829d = new C8829d(this);
        AdTemplate adTemplate = this.mAdTemplate;
        c8829d.mAdTemplate = adTemplate;
        if (C10483a.m25877bc(C10487e.m25641dQ(adTemplate))) {
            C8932a.m29575ah(this.mContext).m29576aN(true);
            C8839a c8839a = new C8839a(this.mAdTemplate, this.mDetailVideoView, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
            this.mPlayModule = c8839a;
            c8829d.mPlayModule = c8839a;
            c8839a.m29761a(getVideoPlayStateListener());
            c8829d.f28358Ms.add(this.mPlayModule);
        }
        return c8829d;
    }
}
