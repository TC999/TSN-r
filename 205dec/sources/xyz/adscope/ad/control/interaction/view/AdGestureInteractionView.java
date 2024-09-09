package xyz.adscope.ad.control.interaction.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.R;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.model.RenderTrackClickTypeEnum;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdGestureInteractionView extends RelativeLayout implements IInteractionView<InteractionModel> {
    private AdListener adListener;
    private AdScopeCycleModel adScopeCycleModel;
    private RelativeLayout gestureRelativeLayout;
    private IInteractionExecute iInteractionExecute;
    private ITrackEventStatus iTrackEventStatus;
    private InteractionCommon interactionCommon;
    private NativeModel nativeModel;
    private RenderView renderView;
    private View totalAdView;

    public AdGestureInteractionView(@NonNull Context context) {
        super(context);
        this.interactionCommon = new InteractionCommon(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setState$0(View view, MotionEvent motionEvent) {
        return this.interactionCommon.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setState$1(String str, ImageView imageView, int i4, int i5, ImageView imageView2, int i6, int i7, int i8, int i9, int i10, int i11, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (!TextUtils.isEmpty(str) && (str.equals("up") || str.equals("down"))) {
            int i12 = i4 + intValue;
            int i13 = intValue + i5;
            imageView.layout(imageView.getLeft(), i12, imageView.getRight(), i13);
            if (str.equals("up")) {
                imageView2.layout(imageView2.getLeft(), i12, imageView2.getRight(), i6);
            } else {
                imageView2.layout(imageView2.getLeft(), i7 + (i5 / 4), imageView2.getRight(), i13);
            }
        } else if (TextUtils.isEmpty(str)) {
        } else {
            if (str.equals("right") || str.equals("left")) {
                imageView.layout(i8 + intValue, imageView.getTop(), i9 + intValue, imageView.getBottom());
                if (str.equals("right")) {
                    int i14 = i11 / 2;
                    imageView2.layout(i10 - i14, imageView2.getTop(), i14 + intValue, imageView2.getBottom());
                    return;
                }
                int i15 = i11 / 2;
                imageView2.layout(i10 + i15 + intValue, imageView2.getTop(), i11 + i15, imageView2.getBottom());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setState$2(final String str, int[] iArr, final ImageView imageView, final ImageView imageView2) {
        ValueAnimator ofInt;
        if (TextUtils.isEmpty(str)) {
            ofInt = ValueAnimator.ofInt(0, iArr[1] - iArr[0]);
        } else if ("right".equals(str)) {
            ofInt = ValueAnimator.ofInt(iArr[1] - iArr[0], -(iArr[1] - iArr[0]));
        } else if ("up".equals(str)) {
            ofInt = ValueAnimator.ofInt(iArr[1] - iArr[0], 0);
        } else {
            ofInt = "left".equals(str) ? ValueAnimator.ofInt(-(iArr[1] - iArr[0]), iArr[1] - iArr[0]) : ValueAnimator.ofInt(0, iArr[1] - iArr[0]);
        }
        ValueAnimator valueAnimator = ofInt;
        final int top2 = imageView.getTop();
        final int bottom = imageView.getBottom();
        final int top3 = imageView2.getTop();
        final int bottom2 = imageView2.getBottom();
        final int left = imageView.getLeft();
        final int right = imageView.getRight();
        final int left2 = imageView2.getLeft();
        final int right2 = imageView2.getRight();
        valueAnimator.setDuration(1000L);
        valueAnimator.setRepeatMode(1);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.adscope.ad.control.interaction.view.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                AdGestureInteractionView.lambda$setState$1(str, imageView, top2, bottom, imageView2, bottom2, top3, left, right, left2, right2, valueAnimator2);
            }
        });
        valueAnimator.start();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
        InteractionCommon interactionCommon = this.interactionCommon;
        if (interactionCommon != null) {
            interactionCommon.destroy();
        }
    }

    @Override // android.view.View
    public int getId() {
        RelativeLayout relativeLayout = this.gestureRelativeLayout;
        if (relativeLayout != null) {
            return relativeLayout.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.gestureRelativeLayout;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public View getTotalAdView() {
        return this.totalAdView;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadSuccess() {
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void setAdListener(AdListener adListener) {
        this.adListener = adListener;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
        this.iTrackEventStatus = iTrackEventStatus;
    }

    public void setInteractionCommon(InteractionCommon interactionCommon) {
        this.interactionCommon = interactionCommon;
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

    public void setState(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4) {
        final int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.gestureRelativeLayout = relativeLayout;
        relativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: xyz.adscope.ad.control.interaction.view.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean lambda$setState$0;
                lambda$setState$0 = AdGestureInteractionView.this.lambda$setState$0(view2, motionEvent);
                return lambda$setState$0;
            }
        });
        RelativeLayout.LayoutParams buildRuleParams = RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]), textWidthAndHeight, interactionModel), interactionModel.getCenterX(), interactionModel.getCenterY(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom(), interactionModel.getSuperView());
        this.gestureRelativeLayout.setBackgroundColor(Color.parseColor(interactionModel.getBgColor()));
        this.gestureRelativeLayout.setLayoutParams(buildRuleParams);
        this.gestureRelativeLayout.setId(i4);
        final ImageView imageView = new ImageView(getContext());
        imageView.setId(i4);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.asnp_scrollbar);
        final String slideDirection = interactionModel.getSlideDirection();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(slideDirection)) {
            if (!slideDirection.equals("up") && !slideDirection.equals("down")) {
                if (slideDirection.equals("left") || slideDirection.equals("right")) {
                    layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1] / 4);
                    layoutParams.addRule(15);
                }
            } else {
                layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[0] / 4, textWidthAndHeight[1]);
                layoutParams.addRule(14);
            }
        }
        final ImageView imageView2 = new ImageView(getContext());
        this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickView(imageView2);
        this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickType(RenderTrackClickTypeEnum.RENDER_TRACK_CLICK_TYPE_SLIDE.getCode());
        imageView2.setImageResource(R.drawable.asnp_hand);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        if (!"up".equals(slideDirection)) {
            if ("down".equals(slideDirection)) {
                imageView.setRotation(180.0f);
            } else if (!"right".equals(slideDirection)) {
                "left".equals(slideDirection);
            }
        }
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        this.gestureRelativeLayout.addView(imageView);
        this.gestureRelativeLayout.addView(imageView2);
        this.gestureRelativeLayout.post(new Runnable() { // from class: xyz.adscope.ad.control.interaction.view.e
            @Override // java.lang.Runnable
            public final void run() {
                AdGestureInteractionView.lambda$setState$2(slideDirection, textWidthAndHeight, imageView2, imageView);
            }
        });
        if (view != null) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            viewGroup2.addView(this.gestureRelativeLayout);
            if (viewGroup2.getParent() != null) {
                ((ViewGroup) viewGroup2.getParent()).removeView(viewGroup2);
            }
            viewGroup.addView(view);
            return;
        }
        viewGroup.addView(this.gestureRelativeLayout);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
        this.totalAdView = viewGroup;
        if (viewGroup instanceof AdGestureInteractionView) {
            ((AdGestureInteractionView) viewGroup).setInteractionCommon(this.interactionCommon);
        }
        this.interactionCommon.setITrackEventStatus(this.iTrackEventStatus);
        this.interactionCommon.initInteraction(this.iInteractionExecute, interactionModel, this.nativeModel, adScopeCycleModel);
        setState(interactionModel, viewGroup, view, i4);
        atomicInteger.getAndDecrement();
    }

    public AdGestureInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdGestureInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdGestureInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.interactionCommon = new InteractionCommon(this);
    }
}
