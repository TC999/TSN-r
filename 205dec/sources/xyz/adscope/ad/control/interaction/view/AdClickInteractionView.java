package xyz.adscope.ad.control.interaction.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.advertisings.model.AdType;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.interaction.InteractionGestures;
import xyz.adscope.ad.control.interaction.inter.IBaseInteraction;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.interaction.view.custom.AdCustomCloseView;
import xyz.adscope.ad.control.interaction.view.custom.AdCustomTextView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.model.RenderTrackClickTypeEnum;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.tool.monitor.AdScopeADNScreenTool;
import xyz.adscope.ad.tool.widget.countdowntimer.CountDownTimerListener;
import xyz.adscope.ad.tool.widget.countdowntimer.CustomCountDownTimer;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdClickInteractionView extends AppCompatTextView implements IInteractionView<InteractionModel>, InteractionGestures.CallBack {
    private static final int IS_AUTO_CLOSE = 1;
    private static final int MAX_COUNT_TIME = 5;
    private static final int MIN_COUNT_TIME = 0;
    private static final int NOT_AUTO_CLOSE = 2;
    private AdListener adListener;
    private InteractionModel adResponseModel;
    private AdScopeCycleModel adScopeCycleModel;
    private View clickView;
    private CustomCountDownTimer countDownTimer;
    private IInteractionExecute iInteractionExecute;
    private ITrackEventStatus iTrackEventStatus;
    private InteractionCommon interactionCommon;
    private boolean isShowCloseUI;
    private NativeModel nativeModel;
    private RenderView renderView;
    private View textView;
    private View totalAdView;

    public AdClickInteractionView(@NonNull Context context) {
        super(context);
        this.interactionCommon = new InteractionCommon(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDownTimeView(final View view) {
        view.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: xyz.adscope.ad.control.interaction.view.AdClickInteractionView.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z3) {
                String str = Constants.TAG;
                LogUtil.i(str, "checkView_asnp hasFocus : " + z3);
                if (AdScopeADNScreenTool.isVisible(view, 100) && AdClickInteractionView.this.iInteractionExecute != null) {
                    AdClickInteractionView.this.iInteractionExecute.customClose();
                    AdClickInteractionView.this.iInteractionExecute = null;
                }
                view.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadAd$0(IBaseInteraction iBaseInteraction, View view) {
        if (iBaseInteraction != null) {
            iBaseInteraction.execute();
        }
    }

    private View renderTextView(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4) {
        RelativeLayout.LayoutParams layoutParams;
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        AdType adType = AdType.INTERSTITIAL;
        if (adType.getValue().equals(this.adScopeCycleModel.getSpaceType())) {
            this.textView = new AdCustomCloseView(getContext());
        } else {
            this.textView = new AdCustomTextView(getContext());
        }
        int buildRadius = RenderViewUtil.buildRadius(interactionModel.getBorderRadius(), DeviceInfoUtil.px2dip(getContext(), textWidthAndHeight[1]));
        this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickType(RenderTrackClickTypeEnum.RENDER_TRACK_CLICK_TYPE_CLICK.getCode());
        View view2 = this.textView;
        if (view2 instanceof AdCustomTextView) {
            ((AdCustomTextView) view2).setAdScopeCycleModel(this.adScopeCycleModel);
            ((AdCustomTextView) this.textView).setLines(1);
            if (interactionModel.getFontSize() > 0) {
                ((AdCustomTextView) this.textView).setTextSize(2, interactionModel.getFontSize());
            }
            if (!TextUtils.isEmpty(interactionModel.getTextColor())) {
                ((AdCustomTextView) this.textView).setTextColor(Color.parseColor(interactionModel.getTextColor()));
            }
            if (!TextUtils.isEmpty(interactionModel.getTitle())) {
                ((AdCustomTextView) this.textView).setText(interactionModel.getTitle());
            }
            ((AdCustomTextView) this.textView).setGravity(17);
        } else {
            ((AdCustomCloseView) view2).setLines(1);
            if (interactionModel.getFontSize() > 0) {
                ((AdCustomCloseView) this.textView).setTextSize(2, interactionModel.getFontSize());
            }
            if (!TextUtils.isEmpty(interactionModel.getTextColor())) {
                ((AdCustomCloseView) this.textView).setTextColor(Color.parseColor(interactionModel.getTextColor()));
            }
            if (!TextUtils.isEmpty(interactionModel.getTitle())) {
                ((AdCustomCloseView) this.textView).setText(interactionModel.getTitle());
            }
            ((AdCustomCloseView) this.textView).setGravity(17);
        }
        if (interactionModel.getExecution().equals("close")) {
            if (adType.getValue().equals(this.adScopeCycleModel.getSpaceType())) {
                if (viewGroup instanceof AdTotalView) {
                    if (((AdTotalView) viewGroup).getAdVideoView() != null) {
                        ((AdCustomCloseView) this.textView).showCountDownTimeUI(buildRadius);
                    } else if (interactionModel.getCountDownTime() != 0) {
                        ((AdCustomCloseView) this.textView).showCountDownTimeUI(buildRadius);
                        checkCountDownTimeView(this.textView, interactionModel.getCountDownTime() / 1000);
                    } else {
                        ((AdCustomCloseView) this.textView).showCloseUI(textWidthAndHeight[1], textWidthAndHeight[1]);
                        this.isShowCloseUI = true;
                    }
                }
            } else {
                checkCountDownTimeView(this.textView, interactionModel.getCountDownTime() / 1000);
            }
        }
        if (this.isShowCloseUI) {
            layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[1], textWidthAndHeight[1]);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]);
        }
        RelativeLayout.LayoutParams buildRuleParams = RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, textWidthAndHeight, interactionModel), interactionModel.getCenterX(), interactionModel.getCenterY(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom(), interactionModel.getSuperView());
        this.textView.setId(i4);
        ShapeUtil.setViewBackGround(this.textView, interactionModel.getBgColor(), StringUtil.strToInt(interactionModel.getBorderSize()), interactionModel.getBorderColor(), buildRadius);
        this.textView.setLayoutParams(buildRuleParams);
        if (view != null) {
            ((ViewGroup) view).addView(this.textView);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.textView);
        }
        return this.textView;
    }

    private void startCountDown(final String str, final View view, final int i4, int i5) {
        CustomCountDownTimer customCountDownTimer = this.countDownTimer;
        if (customCountDownTimer != null) {
            customCountDownTimer.stop();
        }
        CustomCountDownTimer customCountDownTimer2 = new CustomCountDownTimer((i5 * 1000) + 600, 1000L);
        this.countDownTimer = customCountDownTimer2;
        customCountDownTimer2.setCountDownTimerListener(new CountDownTimerListener() { // from class: xyz.adscope.ad.control.interaction.view.AdClickInteractionView.1
            @Override // xyz.adscope.ad.tool.widget.countdowntimer.CountDownTimerListener
            public void onCancel() {
            }

            @Override // xyz.adscope.ad.tool.widget.countdowntimer.CountDownTimerListener
            public void onFinish() {
                if (i4 == 1) {
                    if (AdType.SPLASH.getValue().equals(AdClickInteractionView.this.adScopeCycleModel.getSpaceType())) {
                        if (AdScopeADNScreenTool.isVisible(view, 100)) {
                            if (AdClickInteractionView.this.iInteractionExecute != null) {
                                AdClickInteractionView.this.iInteractionExecute.customClose();
                                return;
                            }
                            return;
                        }
                        AdClickInteractionView.this.checkDownTimeView(view);
                    } else if (AdClickInteractionView.this.iInteractionExecute != null) {
                        AdClickInteractionView.this.iInteractionExecute.customClose();
                    }
                }
            }

            @Override // xyz.adscope.ad.tool.widget.countdowntimer.CountDownTimerListener
            public void onTick(long j4) {
                View view2 = view;
                if (view2 != null) {
                    int i6 = (int) (((float) j4) / 1000.0f);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        if (i6 == 0) {
                            textView.setText(str);
                            return;
                        }
                        textView.setText(str + i6);
                    } else if (view2 instanceof AdCustomCloseView) {
                        ((AdCustomCloseView) view2).updateCountDownTimeText(i6);
                    }
                }
            }
        });
        this.countDownTimer.start();
        view.setTag(this.countDownTimer);
    }

    public void checkCountDownTimeView(final View view, final int i4) {
        if (view == null) {
            return;
        }
        try {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: xyz.adscope.ad.control.interaction.view.AdClickInteractionView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    try {
                        AdClickInteractionView.this.updateCountDownTimer(i4);
                        View view2 = view;
                        if (view2 != null) {
                            view2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            String str = Constants.TAG;
            LogUtil.i(str, "e : " + th);
        }
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
        InteractionCommon interactionCommon = this.interactionCommon;
        if (interactionCommon != null) {
            interactionCommon.destroy();
        }
        CustomCountDownTimer customCountDownTimer = this.countDownTimer;
        if (customCountDownTimer != null) {
            customCountDownTimer.stop();
            this.countDownTimer = null;
        }
    }

    @Override // android.view.View
    public int getId() {
        View view = this.clickView;
        if (view != null) {
            return view.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.clickView;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public View getTotalAdView() {
        return this.totalAdView;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadSuccess() {
    }

    @Override // xyz.adscope.ad.control.interaction.InteractionGestures.CallBack
    public void onListener(String str) {
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.interactionCommon.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void pauseCountDownTimer() {
        CustomCountDownTimer customCountDownTimer = this.countDownTimer;
        if (customCountDownTimer != null) {
            customCountDownTimer.pause();
        }
    }

    public void resumeCountDownTimer() {
        CustomCountDownTimer customCountDownTimer = this.countDownTimer;
        if (customCountDownTimer != null) {
            customCountDownTimer.resume();
        }
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void setAdListener(AdListener adListener) {
        this.adListener = adListener;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
        this.iTrackEventStatus = iTrackEventStatus;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setInteractionExecute(IInteractionExecute iInteractionExecute) {
        this.iInteractionExecute = iInteractionExecute;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setNativeModel(NativeModel nativeModel) {
        this.nativeModel = nativeModel;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setRendView(RenderView renderView) {
        this.renderView = renderView;
    }

    public void updateCountDownTimer(int i4) {
        if (i4 <= 0) {
            return;
        }
        startCountDown(this.adResponseModel.getTitle(), this.textView, "1".equals(this.adResponseModel.getAutoClose()) ? 1 : 2, i4);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
        this.totalAdView = viewGroup;
        if (viewGroup instanceof AdTotalView) {
            ((AdTotalView) viewGroup).setAdClickInteractionView(this);
        }
        this.adResponseModel = interactionModel;
        this.clickView = renderTextView(interactionModel, viewGroup, view, i4);
        this.interactionCommon.setITrackEventStatus(this.iTrackEventStatus);
        final IBaseInteraction initInteraction = this.interactionCommon.initInteraction(this.iInteractionExecute, interactionModel, this.nativeModel, adScopeCycleModel);
        this.clickView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.interaction.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdClickInteractionView.lambda$loadAd$0(IBaseInteraction.this, view2);
            }
        });
        viewGroup.setVisibility(0);
        atomicInteger.getAndDecrement();
    }

    public AdClickInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdClickInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.interactionCommon = new InteractionCommon(this);
    }
}
