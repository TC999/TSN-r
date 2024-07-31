package com.kwad.components.p208ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.ad.widget.DownloadProgressView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadProgressView extends FrameLayout {

    /* renamed from: HU */
    protected TextView f28002HU;
    @ColorInt

    /* renamed from: HV */
    private int f28003HV;
    @ColorInt

    /* renamed from: HW */
    private int f28004HW;
    @ColorInt

    /* renamed from: HX */
    private int f28005HX;

    /* renamed from: HY */
    private int f28006HY;

    /* renamed from: HZ */
    private Drawable f28007HZ;

    /* renamed from: Ia */
    private Drawable f28008Ia;

    /* renamed from: Ib */
    private String f28009Ib;

    /* renamed from: cx */
    private final KsAppDownloadListener f28010cx;

    /* renamed from: dh */
    protected TextProgressBar f28011dh;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_DownloadProgressView);
        this.f28003HV = obtainStyledAttributes.getColor(C9659R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.f28004HW = obtainStyledAttributes.getColor(C9659R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.f28005HX = obtainStyledAttributes.getColor(C9659R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.f28006HY = obtainStyledAttributes.getDimensionPixelSize(C9659R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, C10751a.m24924a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(C9659R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.f28007HZ = drawable;
        if (drawable == null) {
            this.f28007HZ = getResources().getDrawable(C9659R.C9661drawable.ksad_feed_download_progress);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(C9659R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.f28008Ia = drawable2;
        if (drawable2 == null) {
            this.f28008Ia = getResources().getDrawable(C9659R.C9661drawable.ksad_feed_app_download_before_bg);
        }
        String string = obtainStyledAttributes.getString(C9659R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.f28009Ib = string;
        if (string == null) {
            this.f28009Ib = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    private void initView() {
        C10887l.inflate(getContext(), C9659R.C9663layout.ksad_download_progress_layout, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(C9659R.C9662id.ksad_progress_bar);
        this.f28011dh = textProgressBar;
        textProgressBar.setTextDimen(this.f28006HY);
        this.f28011dh.setTextColor(this.f28004HW, this.f28005HX);
        this.f28011dh.setProgressDrawable(this.f28007HZ);
        TextView textView = (TextView) findViewById(C9659R.C9662id.ksad_normal_text);
        this.f28002HU = textView;
        textView.setTextColor(this.f28003HV);
        this.f28002HU.setTextSize(0, this.f28006HY);
        this.f28002HU.setVisibility(0);
        this.f28002HU.setBackground(this.f28008Ia);
        findViewById(C9659R.C9662id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    /* renamed from: ai */
    public final void m30446ai(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.mAdInfo = m25641dQ;
        this.f28002HU.setText(C10483a.m25957aE(m25641dQ));
        this.f28011dh.setVisibility(8);
        this.f28002HU.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.f28010cx;
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C10887l.wrapContextIfNeed(context), attributeSet, i);
        this.f28010cx = new AbstractC10298a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f28002HU.setText(C10483a.m25957aE(downloadProgressView.mAdInfo));
                DownloadProgressView.this.f28002HU.setVisibility(0);
                DownloadProgressView.this.f28011dh.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.f28002HU.setVisibility(8);
                DownloadProgressView.this.f28011dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f28011dh.m29709e(C10483a.m25882bY(downloadProgressView.mAdTemplate), DownloadProgressView.this.f28011dh.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f28002HU.setText(C10483a.m25957aE(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.f28002HU.setVisibility(8);
                DownloadProgressView.this.f28011dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f28011dh.m29709e(C10483a.m25933ac(downloadProgressView.mAdInfo), DownloadProgressView.this.f28011dh.getMax());
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
            public final void onPaused(int i2) {
                DownloadProgressView.this.f28002HU.setVisibility(8);
                DownloadProgressView.this.f28011dh.setVisibility(0);
                DownloadProgressView.this.f28011dh.m29709e(C10483a.m25980Fg(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DownloadProgressView.this.f28002HU.setVisibility(8);
                DownloadProgressView.this.f28011dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.f28011dh.m29709e(C10483a.m25793q(i2, downloadProgressView.f28009Ib), i2);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }
}
