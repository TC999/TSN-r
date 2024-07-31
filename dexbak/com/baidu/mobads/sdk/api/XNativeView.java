package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.C2663co;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class XNativeView extends RelativeLayout implements View.OnClickListener {
    private static final String TAG = "XNativeView";
    private C2634bs mAdLogger;
    private XAdNativeResponse mCurrentNativeItem;
    private INativeVideoListener mFeedVideoListener;
    private INativeViewClickListener mNativeViewListener;
    private int mProgressBg;
    private int mProgressColor;
    private int mProgressHeight;
    private boolean mShowProgressBar;
    private FeedPortraitVideoView mVideoView;
    private boolean videoMute;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface INativeViewClickListener {
        void onNativeViewClick(XNativeView xNativeView);
    }

    public XNativeView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callNativeViewClick() {
        INativeViewClickListener iNativeViewClickListener = this.mNativeViewListener;
        if (iNativeViewClickListener != null) {
            iNativeViewClickListener.onNativeViewClick(this);
        }
    }

    private void initAdVideoView() {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView == null) {
            return;
        }
        feedPortraitVideoView.setCanClickVideo(true);
        this.mVideoView.setAdData(this.mCurrentNativeItem);
        this.mVideoView.systemSetVideoMute(this.videoMute);
    }

    private boolean isVisible(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= ((long) i) * height2;
        }
        return false;
    }

    private void play() {
        if (this.mVideoView != null) {
            initAdVideoView();
            this.mVideoView.hideFeedPauseBtn(this.mCurrentNativeItem);
            this.mVideoView.play();
        }
    }

    private void renderView() {
        XAdNativeResponse xAdNativeResponse = this.mCurrentNativeItem;
        if (xAdNativeResponse == null) {
            return;
        }
        NativeResponse.MaterialType materialType = xAdNativeResponse.getMaterialType();
        if (this.mVideoView == null) {
            FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(getContext());
            this.mVideoView = feedPortraitVideoView;
            feedPortraitVideoView.setShowProgress(this.mShowProgressBar);
            this.mVideoView.setProgressBarColor(this.mProgressColor);
            this.mVideoView.setProgressBackgroundColor(this.mProgressBg);
            this.mVideoView.setProgressHeightInDp(this.mProgressHeight);
            addView(this.mVideoView, new RelativeLayout.LayoutParams(-1, -1));
            this.mVideoView.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.baidu.mobads.sdk.api.XNativeView.1
                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void pauseBtnClick() {
                    XNativeView.this.callNativeViewClick();
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playCompletion() {
                    if (XNativeView.this.mFeedVideoListener != null) {
                        XNativeView.this.mFeedVideoListener.onCompletion();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playError() {
                    if (XNativeView.this.mFeedVideoListener != null) {
                        XNativeView.this.mFeedVideoListener.onError();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playPause() {
                    if (XNativeView.this.mFeedVideoListener != null) {
                        XNativeView.this.mFeedVideoListener.onPause();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playRenderingStart() {
                    if (XNativeView.this.mVideoView != null) {
                        XNativeView.this.mVideoView.hideFeedCoverPic(XNativeView.this.mCurrentNativeItem);
                    }
                    XNativeViewManager.getInstance().resetAllPlayer(XNativeView.this);
                    if (XNativeView.this.mFeedVideoListener != null) {
                        XNativeView.this.mFeedVideoListener.onRenderingStart();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playResume() {
                    if (XNativeView.this.mFeedVideoListener != null) {
                        XNativeView.this.mFeedVideoListener.onResume();
                    }
                }
            });
        }
        if (materialType == NativeResponse.MaterialType.NORMAL) {
            this.mVideoView.showNormalPic(this.mCurrentNativeItem);
        } else if (materialType == NativeResponse.MaterialType.VIDEO) {
            showView(this.mCurrentNativeItem);
        }
    }

    private boolean shouldAutoPlay() {
        XAdNativeResponse xAdNativeResponse = this.mCurrentNativeItem;
        boolean z = xAdNativeResponse != null && xAdNativeResponse.isAutoPlay();
        XAdNativeResponse xAdNativeResponse2 = this.mCurrentNativeItem;
        boolean z2 = xAdNativeResponse2 == null || xAdNativeResponse2.isNonWifiAutoPlay();
        Boolean m50614a = C2663co.m50615a().m50614a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        if (z && m50614a.booleanValue()) {
            return true;
        }
        return z2 && !m50614a.booleanValue();
    }

    private void showView(XAdNativeResponse xAdNativeResponse) {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView == null) {
            return;
        }
        feedPortraitVideoView.showFeedVideoCover(xAdNativeResponse);
    }

    public void handleCover() {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView == null) {
            return;
        }
        feedPortraitVideoView.handleFeedCover(this.mCurrentNativeItem);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        XNativeViewManager.getInstance().addItem(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XNativeViewManager.getInstance().removeNativeView(this);
    }

    public void pause() {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.pause();
        }
    }

    public void render() {
        if (shouldAutoPlay()) {
            play();
        } else {
            initAdVideoView();
        }
    }

    public void resume() {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.resume();
        }
    }

    public void setNativeItem(NativeResponse nativeResponse) {
        this.mCurrentNativeItem = (XAdNativeResponse) nativeResponse;
        renderView();
    }

    public void setNativeVideoListener(INativeVideoListener iNativeVideoListener) {
        this.mFeedVideoListener = iNativeVideoListener;
    }

    public void setNativeViewClickListener(INativeViewClickListener iNativeViewClickListener) {
        this.mNativeViewListener = iNativeViewClickListener;
    }

    public void setProgressBackgroundColor(int i) {
        this.mProgressBg = i;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setProgressBackgroundColor(i);
        }
    }

    public void setProgressBarColor(int i) {
        this.mProgressColor = i;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setProgressBarColor(i);
        }
    }

    public void setProgressHeightInDp(int i) {
        this.mProgressHeight = i;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setProgressHeightInDp(i);
        }
    }

    public void setShowProgress(boolean z) {
        this.mShowProgressBar = z;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setShowProgress(z);
        }
    }

    public void setUseDownloadFrame(boolean z) {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setUseDownloadFrame(z);
        }
    }

    public void setVideoMute(boolean z) {
        this.videoMute = z;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(z);
        }
    }

    public void stop() {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
        }
    }

    public XNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoMute = true;
        this.mProgressColor = -1;
        this.mProgressBg = ViewCompat.MEASURED_STATE_MASK;
        this.mShowProgressBar = false;
        this.mProgressHeight = 1;
        this.mAdLogger = C2634bs.m50744a();
        setBackgroundColor(Color.parseColor("#000000"));
    }
}
