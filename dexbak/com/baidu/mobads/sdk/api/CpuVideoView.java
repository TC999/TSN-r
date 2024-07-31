package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.internal.C2607aw;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CpuVideoView extends RelativeLayout {
    public static final String TAG = "CpuVideoView";
    private CpuVideoStatusListener mCpuVideoStatusListener;
    private FeedPortraitVideoView mVideoView;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
        this.mVideoView.setProgressBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.mVideoView.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.baidu.mobads.sdk.api.CpuVideoView.1
            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void pauseBtnClick() {
                C2607aw.m50898h(CpuVideoView.TAG).mo50868d("pauseBtnClick: ");
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playCompletion() {
                C2607aw.m50898h(CpuVideoView.TAG).mo50868d("playCompletion: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playCompletion();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playError() {
                C2607aw.m50898h(CpuVideoView.TAG).mo50868d("playError: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playError();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playPause() {
                C2607aw.m50898h(CpuVideoView.TAG).mo50868d("playPause: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playPause();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playRenderingStart() {
                C2607aw.m50898h(CpuVideoView.TAG).mo50868d("playRenderingStart: ");
                if (CpuVideoView.this.mCpuVideoStatusListener != null) {
                    CpuVideoView.this.mCpuVideoStatusListener.playRenderingStart();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playResume() {
                C2607aw.m50898h(CpuVideoView.TAG).mo50868d("playResume: ");
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

    public CpuVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initVideoView();
    }
}
