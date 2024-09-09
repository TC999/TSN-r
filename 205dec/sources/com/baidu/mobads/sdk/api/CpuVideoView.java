package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.az;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CpuVideoView extends RelativeLayout {
    public static final String TAG = "CpuVideoView";
    private CpuVideoStatusListener mCpuVideoStatusListener;
    private FeedPortraitVideoView mVideoView;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface CpuVideoStatusListener {
        void playCompletion();

        void playError();

        void playPause();

        void playRenderingStart();

        void playResume();
    }

    public CpuVideoView(Context context) {
        this(context, null);
    }

    private void initVideoView() {
        FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(getContext());
        this.mVideoView = feedPortraitVideoView;
        feedPortraitVideoView.systemSetVideoMute(true);
        this.mVideoView.setProgressBarColor(-1);
        this.mVideoView.setProgressHeightInDp(1);
        this.mVideoView.setProgressBackgroundColor(-16777216);
        this.mVideoView.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.baidu.mobads.sdk.api.CpuVideoView.1
            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void pauseBtnClick() {
                az.h("CpuVideoView").d("pauseBtnClick: ");
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playCompletion() {
                az.h("CpuVideoView").d("playCompletion: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playCompletion();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playError() {
                az.h("CpuVideoView").d("playError: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playError();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playPause() {
                az.h("CpuVideoView").d("playPause: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playPause();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playRenderingStart() {
                az.h("CpuVideoView").d("playRenderingStart: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playRenderingStart();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playResume() {
                az.h("CpuVideoView").d("playResume: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playResume();
                }
            }
        });
        addView(this.mVideoView, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setCpuVideoStatusListener(CpuVideoStatusListener cpuVideoStatusListener) {
        this.mCpuVideoStatusListener = cpuVideoStatusListener;
    }

    public void setVideoConfig(IBasicCPUData iBasicCPUData) {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setAdData(iBasicCPUData);
        }
    }

    public CpuVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CpuVideoView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        initVideoView();
    }
}
