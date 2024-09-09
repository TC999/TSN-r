package xyz.adscope.ad.control.render.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.R;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.interaction.view.AdClickInteractionView;
import xyz.adscope.ad.control.interaction.view.AdReplayInteractionView;
import xyz.adscope.ad.control.interaction.view.AdTotalView;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.render.util.TextureVideoViewOutlineProvider;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.RenderModel;
import xyz.adscope.ad.tool.monitor.AdScopeADNScreenTool;
import xyz.adscope.common.cache.video.VideoCacheManager;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.StringUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdVideoView extends RelativeLayout implements IAdView<RenderModel> {
    private int AD_VIDEO_VIEW_STATUS;
    private AdListener adListener;
    private MediaPlayer adMediaPlayer;
    private VideoView adVideoView;
    private RelativeLayout adVideoViewParent;
    private int adVideoViewParentHeight;
    private int adVideoViewParentWidth;
    private boolean isFirstVideoPrepared;
    private boolean isResumeVideo;
    private boolean isVoiceOn;
    private boolean replay;
    private ImageView replayImageView;
    private View totalView;
    private int videoStopPosition;

    public AdVideoView(Context context) {
        super(context);
        this.isVoiceOn = false;
        this.isFirstVideoPrepared = true;
    }

    private void checkTargetView(final View view) {
        view.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: xyz.adscope.ad.control.render.view.AdVideoView.2
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z3) {
                String str = Constants.TAG;
                LogUtil.i(str, "checkView_asnp hasFocus : " + z3 + " , isResumeVideo : " + AdVideoView.this.isResumeVideo);
                if (AdVideoView.this.AD_VIDEO_VIEW_STATUS != 3) {
                    String str2 = Constants.TAG;
                    LogUtil.i(str2, "advideo_tag AdScopeADNScreenTool.isVisible() : " + AdScopeADNScreenTool.isVisible(view, 100));
                    if (AdScopeADNScreenTool.isVisible(view, 100)) {
                        if (AdVideoView.this.isResumeVideo) {
                            AdVideoView.this.isResumeVideo = false;
                            AdVideoView.this.resumeVideo();
                        }
                    } else if (AdVideoView.this.isResumeVideo) {
                    } else {
                        AdVideoView.this.isResumeVideo = true;
                        AdVideoView.this.pauseVideo();
                    }
                }
            }
        });
    }

    private int getVideoDuration() {
        return this.adMediaPlayer.getDuration() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnVideoListener$0(MediaPlayer mediaPlayer) {
        LogUtil.i(Constants.TAG, "onCompletion() ");
        this.AD_VIDEO_VIEW_STATUS = 3;
        String str = Constants.TAG;
        LogUtil.i(str, "advideo_tag 55555 : AD_VIDEO_VIEW_STATUS " + this.AD_VIDEO_VIEW_STATUS);
        View view = this.totalView;
        if (view != null && (view instanceof AdTotalView)) {
            ImageView replayInteractionView = ((AdTotalView) view).getReplayInteractionView();
            View maskView = ((AdTotalView) this.totalView).getMaskView();
            if (replayInteractionView != null) {
                replayInteractionView.setVisibility(0);
                replayInteractionView.setImageResource(R.drawable.asnp_video_replay_icon);
            }
            ImageView imageView = this.replayImageView;
            if (imageView != null) {
                imageView.setVisibility(0);
                this.replayImageView.setImageResource(0);
            }
            if (maskView != null) {
                maskView.setVisibility(0);
            }
        }
        this.adVideoView.seekTo(mediaPlayer.getDuration());
        this.adVideoView.pause();
        updateCountDownTime(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnVideoListener$1(int i4, MediaPlayer mediaPlayer) {
        AdReplayInteractionView adReplayInteractionView;
        View selfView;
        VideoView videoView;
        LogUtil.i(Constants.TAG, "onPrepared() ");
        this.adMediaPlayer = mediaPlayer;
        if (this.isVoiceOn) {
            mediaPlayer.setVolume(0.0f, 1.0f);
        } else {
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
        if (this.adVideoView != null) {
            int i5 = this.videoStopPosition;
            if (i5 > 0) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.adMediaPlayer.seekTo(i5, 3);
                }
            } else if (Build.VERSION.SDK_INT >= 26) {
                this.adMediaPlayer.seekTo(2L, 3);
            }
            View view = this.totalView;
            if (view != null && (view instanceof AdTotalView) && (adReplayInteractionView = ((AdTotalView) view).getAdReplayInteractionView()) != null && (selfView = adReplayInteractionView.getSelfView()) != null && selfView.getVisibility() == 8 && (videoView = this.adVideoView) != null) {
                videoView.start();
            }
        }
        if (this.isFirstVideoPrepared) {
            updateCountDownTime(getVideoDuration());
            updateVideViewCorner(i4);
            this.AD_VIDEO_VIEW_STATUS = 1;
            String str = Constants.TAG;
            LogUtil.i(str, "advideo_tag 11111 : AD_VIDEO_VIEW_STATUS " + this.AD_VIDEO_VIEW_STATUS);
        }
        this.isFirstVideoPrepared = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setOnVideoListener$2(MediaPlayer mediaPlayer, int i4, int i5) {
        LogUtil.i(Constants.TAG, "onError() ");
        return false;
    }

    private void playVideo(RenderModel renderModel, int i4) {
        try {
            if (this.adVideoView != null) {
                String videoPath = getVideoPath(renderModel);
                if (!TextUtils.isEmpty(videoPath)) {
                    VideoCacheManager.with().getCacheVideo(AdScopeSDK.getContext(), videoPath, new VideoCacheManager.VideoLoadedListener() { // from class: xyz.adscope.ad.control.render.view.AdVideoView.1
                        @Override // xyz.adscope.common.cache.video.VideoCacheManager.VideoLoadedListener
                        public void onVideoLoadFailed() {
                            try {
                                WeakReference<Context> findActivityContext = SystemUtil.findActivityContext(AdVideoView.this.totalView);
                                if (findActivityContext.get() == null || !(findActivityContext.get() instanceof Activity)) {
                                    return;
                                }
                                ((Activity) findActivityContext.get()).finish();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        @Override // xyz.adscope.common.cache.video.VideoCacheManager.VideoLoadedListener
                        public void onVideoLoaded(String str) {
                            AdVideoView.this.adVideoView.setVideoPath(str);
                            AdVideoView.this.adVideoView.setFocusable(true);
                            AdVideoView.this.adVideoView.start();
                        }
                    });
                }
            }
            setOnVideoListener(i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void setOnVideoListener(final int i4) {
        VideoView videoView = this.adVideoView;
        if (videoView != null) {
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: xyz.adscope.ad.control.render.view.a
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    AdVideoView.this.lambda$setOnVideoListener$0(mediaPlayer);
                }
            });
            this.adVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: xyz.adscope.ad.control.render.view.c
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    AdVideoView.this.lambda$setOnVideoListener$1(i4, mediaPlayer);
                }
            });
            this.adVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: xyz.adscope.ad.control.render.view.b
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer, int i5, int i6) {
                    boolean lambda$setOnVideoListener$2;
                    lambda$setOnVideoListener$2 = AdVideoView.lambda$setOnVideoListener$2(mediaPlayer, i5, i6);
                    return lambda$setOnVideoListener$2;
                }
            });
        }
    }

    private void updateCountDownTime(int i4) {
        AdClickInteractionView adClickInteractionView;
        View view = this.totalView;
        if (!(view instanceof AdTotalView) || (adClickInteractionView = ((AdTotalView) view).getAdClickInteractionView()) == null) {
            return;
        }
        adClickInteractionView.checkCountDownTimeView(adClickInteractionView.getSelfView(), i4);
    }

    private void updateVideViewCorner(int i4) {
        float f4;
        this.adVideoView.measure(0, 0);
        int measuredWidth = this.adVideoView.getMeasuredWidth();
        int measuredHeight = this.adVideoView.getMeasuredHeight();
        this.adVideoViewParentWidth = this.adVideoViewParent.getWidth();
        int height = this.adVideoViewParent.getHeight();
        this.adVideoViewParentHeight = height;
        double d4 = measuredWidth;
        Double.isNaN(d4);
        double d5 = measuredHeight;
        Double.isNaN(d5);
        float f5 = (float) ((d4 * 1.0d) / d5);
        double d6 = this.adVideoViewParentWidth;
        Double.isNaN(d6);
        if (Math.abs((((float) (d6 * 1.0d)) / height) - f5) < 0.0f || Math.abs(f4) > 0.01d) {
            return;
        }
        this.adVideoView.setOutlineProvider(new TextureVideoViewOutlineProvider(DeviceInfoUtil.dip2px(getContext(), i4)));
        this.adVideoView.setClipToOutline(true);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
    }

    @Override // android.view.View
    public int getId() {
        RelativeLayout relativeLayout = this.adVideoViewParent;
        if (relativeLayout != null) {
            return relativeLayout.getId();
        }
        return super.getId();
    }

    public ImageView getReplayImageView() {
        return this.replayImageView;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.adVideoViewParent;
    }

    public String getVideoPath(RenderModel renderModel) {
        if (renderModel.getVideoModel() != null) {
            if (!TextUtils.isEmpty(renderModel.getVideoModel().getUrl())) {
                return renderModel.getVideoModel().getUrl();
            }
            if (TextUtils.isEmpty(renderModel.getVideoModel().getAdm())) {
                return !TextUtils.isEmpty(renderModel.getVideoModel().getCurl()) ? renderModel.getVideoModel().getCurl() : "";
            }
            return renderModel.getVideoModel().getAdm();
        }
        return "";
    }

    public boolean isVoiceOn() {
        return this.isVoiceOn;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadSuccess() {
    }

    public void operateMute() {
        if (this.isVoiceOn) {
            View view = this.totalView;
            if (view instanceof AdTotalView) {
                ((AdTotalView) view).getVoiceRenderView().setImageResource(R.drawable.asnp_voice_off);
            }
            MediaPlayer mediaPlayer = this.adMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            }
        } else {
            View view2 = this.totalView;
            if (view2 instanceof AdTotalView) {
                ((AdTotalView) view2).getVoiceRenderView().setImageResource(R.drawable.asnp_voice_on);
            }
            MediaPlayer mediaPlayer2 = this.adMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setVolume(0.0f, 1.0f);
            }
        }
        this.isVoiceOn = !this.isVoiceOn;
    }

    public void operateReplayVideo() {
        if (this.adVideoView != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.adMediaPlayer.seekTo(0L, 3);
            }
            this.adVideoView.start();
            this.AD_VIDEO_VIEW_STATUS = 1;
            String str = Constants.TAG;
            LogUtil.i(str, "advideo_tag 44444 : AD_VIDEO_VIEW_STATUS " + this.AD_VIDEO_VIEW_STATUS);
        }
        updateCountDownTime(getVideoDuration());
    }

    public void pauseVideo() {
        AdClickInteractionView adClickInteractionView;
        try {
            LogUtil.i(Constants.TAG, "advideo_position 33333 : pauseVideo() ");
            VideoView videoView = this.adVideoView;
            if (videoView != null) {
                if (this.AD_VIDEO_VIEW_STATUS == 3) {
                    this.videoStopPosition = 0;
                } else {
                    this.videoStopPosition = videoView.getCurrentPosition();
                }
                this.adVideoView.pause();
            }
            int duration = (this.adMediaPlayer.getDuration() - this.adMediaPlayer.getCurrentPosition()) / 1000;
            updateCountDownTime(duration);
            String str = Constants.TAG;
            LogUtil.i(str, "advideo_position 33333 : pausePosition : " + duration);
            View view = this.totalView;
            if ((view instanceof AdTotalView) && (adClickInteractionView = ((AdTotalView) view).getAdClickInteractionView()) != null) {
                adClickInteractionView.pauseCountDownTimer();
            }
            this.AD_VIDEO_VIEW_STATUS = 2;
            String str2 = Constants.TAG;
            LogUtil.i(str2, "advideo_tag 33333 : AD_VIDEO_VIEW_STATUS " + this.AD_VIDEO_VIEW_STATUS);
        } catch (Exception e4) {
            String str3 = Constants.TAG;
            LogUtil.i(str3, "e : " + e4);
        }
    }

    public void resumeVideo() {
        AdClickInteractionView adClickInteractionView;
        VideoView videoView = this.adVideoView;
        if (videoView != null) {
            videoView.start();
        }
        View view = this.totalView;
        if ((view instanceof AdTotalView) && (adClickInteractionView = ((AdTotalView) view).getAdClickInteractionView()) != null) {
            adClickInteractionView.resumeCountDownTimer();
        }
        this.AD_VIDEO_VIEW_STATUS = 1;
        String str = Constants.TAG;
        LogUtil.i(str, "advideo_tag 2222 : AD_VIDEO_VIEW_STATUS " + this.AD_VIDEO_VIEW_STATUS);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void setAdListener(AdListener adListener) {
        this.adListener = adListener;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    @SuppressLint({"ResourceType"})
    public void loadAd(RenderModel renderModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        this.totalView = viewGroup;
        if (viewGroup instanceof AdTotalView) {
            ((AdTotalView) viewGroup).setAdVideoView(this);
        }
        this.adVideoViewParent = new RelativeLayout(getContext());
        this.adVideoView = new VideoView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.adVideoView.setLayoutParams(layoutParams);
        this.adVideoViewParent.setId(i4);
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), renderModel.getWidth(), renderModel.getHeight(), renderModel.getWidthMode(), renderModel.getHeightMode(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]);
        try {
            if (!TextUtils.isEmpty(renderModel.getBgColor())) {
                this.adVideoViewParent.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor(renderModel.getBgColor())));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        int buildRadius = RenderViewUtil.buildRadius(renderModel.getBorderRadius(), DeviceInfoUtil.px2dip(getContext(), textWidthAndHeight[1]));
        try {
            ShapeUtil.setViewBackGround(this.adVideoViewParent, UIAdapterUtil.getInstance().autoInterfaceStyleColor(renderModel.getBgColor()), StringUtil.strToInt(renderModel.getBorderSize()), renderModel.getBorderColor(), buildRadius);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        RelativeLayout.LayoutParams buildRuleToOtherViewParams = RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams2, textWidthAndHeight, renderModel), renderModel.getCenterX(), renderModel.getCenterY(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom(), renderModel.getSuperView()), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom());
        if (renderModel.getVideoModel() != null && !TextUtils.isEmpty(renderModel.getVideoModel().getVoiceOn())) {
            this.isVoiceOn = "1".equals(renderModel.getVideoModel().getVoiceOn());
        }
        if (renderModel.getVideoModel() != null && !TextUtils.isEmpty(renderModel.getVideoModel().getReplay())) {
            this.replay = "1".equals(renderModel.getVideoModel().getReplay());
        }
        playVideo(renderModel, buildRadius);
        checkTargetView(this.adVideoView);
        this.adVideoViewParent.setLayoutParams(buildRuleToOtherViewParams);
        this.adVideoViewParent.addView(this.adVideoView);
        if (this.replay) {
            ImageView imageView = new ImageView(getContext());
            this.replayImageView = imageView;
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.replayImageView.setImageResource(R.drawable.asnp_video_replay_icon);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            this.replayImageView.setLayoutParams(layoutParams3);
            this.replayImageView.setVisibility(4);
            this.adVideoViewParent.addView(this.replayImageView);
        }
        if (view != null) {
            ((ViewGroup) view).addView(this.adVideoViewParent);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.adVideoViewParent);
        }
        viewGroup.setVisibility(0);
        atomicInteger.getAndDecrement();
    }

    public AdVideoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isVoiceOn = false;
        this.isFirstVideoPrepared = true;
    }

    public AdVideoView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.isVoiceOn = false;
        this.isFirstVideoPrepared = true;
    }
}
