package xyz.adscope.ad.control.interaction;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.inter.IBaseInteraction;
import xyz.adscope.ad.control.render.model.AdScopeRenderCustomTrackerModel;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InteractionGestures implements IBaseInteraction {
    public static final int DEFAULT_PASSIVATION_TYPE = 0;
    public static final int MOVE_BOTTOM = 3;
    public static final int MOVE_LEFT = 0;
    public static final int MOVE_RIGHT = 2;
    public static final int MOVE_UP = 1;
    private AdScopeCycleModel adScopeCycleModel;
    private CallBack callBack;
    private String direction;
    private float downPointX;
    private float downPointY;
    private int effectiveMovingDistance;
    private int passivationType;
    private int slop;
    private View targetView;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface CallBack {
        void onListener(String str);
    }

    private InteractionGestures(View view, CallBack callBack, AdScopeCycleModel adScopeCycleModel) {
        this.targetView = view;
        this.callBack = callBack;
        this.adScopeCycleModel = adScopeCycleModel;
        this.slop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
    }

    public static InteractionGestures create(View view, CallBack callBack, AdScopeCycleModel adScopeCycleModel) {
        return new InteractionGestures(view, callBack, adScopeCycleModel);
    }

    private void initAnim(int i4, final int i5, int i6) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i4, this.passivationType == 0 ? i4 : i5);
        ofInt.setDuration(i6);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.adscope.ad.control.interaction.InteractionGestures.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InteractionGestures.this.effectiveMovingDistance = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: xyz.adscope.ad.control.interaction.InteractionGestures.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (InteractionGestures.this.passivationType == 0) {
                    InteractionGestures.this.effectiveMovingDistance = i5;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofInt.start();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void execute() {
    }

    public int getPassivationType() {
        return this.passivationType;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.downPointX = motionEvent.getX();
            this.downPointY = motionEvent.getY();
            AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
            adScopeRenderCustomTrackerModel.setAdDownX(this.downPointX + "");
            AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel2 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
            adScopeRenderCustomTrackerModel2.setAdDownY(this.downPointY + "");
        } else if (motionEvent.getAction() != 2 && motionEvent.getAction() == 1) {
            int scaledTouchSlop = ViewConfiguration.get(this.targetView.getContext()).getScaledTouchSlop();
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel3 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
            adScopeRenderCustomTrackerModel3.setAdUpX(x3 + "");
            AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel4 = this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
            adScopeRenderCustomTrackerModel4.setAdUpY(y3 + "");
            float f4 = (float) scaledTouchSlop;
            if ((Math.abs(this.downPointX - x3) > f4 || Math.abs(this.downPointY - y3) > f4) && (Math.abs(this.downPointX - x3) > this.effectiveMovingDistance || Math.abs(this.downPointY - y3) > this.effectiveMovingDistance)) {
                if (Math.abs(this.downPointX - x3) > Math.abs(this.downPointY - y3)) {
                    if (this.downPointX > x3) {
                        this.callBack.onListener("left");
                    } else {
                        this.callBack.onListener("right");
                    }
                } else if (this.downPointY > y3) {
                    this.callBack.onListener("up");
                } else {
                    this.callBack.onListener("down");
                }
            }
        }
        return true;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IBaseInteraction
    public void setAdListener(AdListener adListener) {
    }

    public void setPassivationType(int i4) {
        this.passivationType = i4;
    }

    public void setSlideDirection(String str) {
        this.direction = str;
    }

    public void startTouchEventListen(int i4, int i5, int i6) {
        initAnim(i4, i5, i6);
    }
}
