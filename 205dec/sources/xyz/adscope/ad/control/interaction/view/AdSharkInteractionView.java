package xyz.adscope.ad.control.interaction.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.R;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.interaction.view.custom.AdIndicateArrowView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.model.RenderTrackClickTypeEnum;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.tool.imageloader.AdScopeImageLoader;
import xyz.adscope.common.imageloader.inter.IImageLoaderCallback;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdSharkInteractionView extends RelativeLayout implements IInteractionView<InteractionModel> {
    private View adContainerView;
    private AdIndicateArrowView adIndicateArrowView;
    private RelativeLayout adInteractionContainerRl;
    private ImageView adInteractionImgView;
    private AdListener adListener;
    private InteractionModel adResponseModel;
    private AdScopeCycleModel adScopeCycleModel;
    private float angleDegreeZ;
    private AnimatorSet animatorSet;
    private int duration;
    private ITrackEventStatus iTrackEventStatus;
    private InteractionCommon interactionCommon;
    private IInteractionExecute interactionExecute;
    private NativeModel nativeModel;
    private RenderView renderView;
    private View totalAdView;

    public AdSharkInteractionView(@NonNull Context context) {
        super(context);
        this.duration = 50;
        this.angleDegreeZ = 30.0f;
        this.interactionCommon = new InteractionCommon(this);
    }

    private void addObjectAnimatorToList(List<Animator> list, String str, float f4, float f5) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.adInteractionImgView, str, f4, f5);
            ofFloat.setDuration(this.duration);
            list.add(ofFloat);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void addShakeViewAnimation() {
        try {
            ArrayList arrayList = new ArrayList();
            addObjectAnimatorToList(arrayList, "rotation", 0.0f, this.angleDegreeZ);
            addObjectAnimatorToList(arrayList, "rotation", this.angleDegreeZ, 0.0f);
            addObjectAnimatorToList(arrayList, "rotation", 0.0f, -this.angleDegreeZ);
            addObjectAnimatorToList(arrayList, "rotation", -this.angleDegreeZ, 0.0f);
            if (arrayList.size() > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.animatorSet = animatorSet;
                animatorSet.addListener(new Animator.AnimatorListener() { // from class: xyz.adscope.ad.control.interaction.view.AdSharkInteractionView.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (AdSharkInteractionView.this.animatorSet != null) {
                                AdSharkInteractionView.this.animatorSet.start();
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                this.animatorSet.playSequentially(arrayList);
                this.animatorSet.start();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void renderAnimationView(int i4) {
        try {
            ImageView imageView = this.adInteractionImgView;
            if (imageView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                double d4 = i4;
                Double.isNaN(d4);
                layoutParams.width = (int) (0.35d * d4);
                Double.isNaN(d4);
                layoutParams.height = (int) (d4 * 0.5d);
                this.adInteractionImgView.setLayoutParams(layoutParams);
            }
            String imageUrl = this.adResponseModel.getImageUrl();
            if (TextUtils.isEmpty(imageUrl)) {
                return;
            }
            new AdScopeImageLoader();
            AdScopeImageLoader.loadImage(getContext(), imageUrl, new IImageLoaderCallback() { // from class: xyz.adscope.ad.control.interaction.view.AdSharkInteractionView.1
                @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                public void failCallback(String str) {
                }

                @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                public void successCallback(Bitmap bitmap) {
                    try {
                        if (AdSharkInteractionView.this.adInteractionImgView == null || bitmap == null) {
                            return;
                        }
                        AdSharkInteractionView.this.adInteractionImgView.setImageBitmap(bitmap);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void renderIndicateArrowView(int i4) {
        try {
            if (this.adIndicateArrowView == null) {
                return;
            }
            if (this.adResponseModel.getFeedbackAnimation() == 0) {
                this.adIndicateArrowView.setVisibility(8);
                return;
            }
            this.adIndicateArrowView.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adIndicateArrowView.getLayoutParams();
            double d4 = i4;
            Double.isNaN(d4);
            int i5 = (int) (d4 * 0.7d);
            layoutParams.width = i5;
            layoutParams.height = i5;
            this.adIndicateArrowView.setLayoutParams(layoutParams);
            this.adIndicateArrowView.setLineWidth(i4 / 30);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void renderRoundBgView(int i4) {
        try {
            RelativeLayout relativeLayout = this.adInteractionContainerRl;
            if (relativeLayout == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i4;
            this.adInteractionContainerRl.setLayoutParams(layoutParams);
            String bgColor = this.adResponseModel.getBgColor();
            int i5 = i4 / 2;
            if (!TextUtils.isEmpty(bgColor) && bgColor.startsWith("#")) {
                ShapeUtil.setViewBackGround(this.adInteractionContainerRl, bgColor, 0, (String) null, i5);
            } else {
                ShapeUtil.setViewBackGround(this.adInteractionContainerRl, "#66333333", 0, (String) null, i5);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void renderView(ViewGroup viewGroup, View view, int i4) {
        try {
            View inflate = View.inflate(getContext(), R.layout.adscope_interaction_shake_view, null);
            this.adContainerView = inflate;
            this.adInteractionContainerRl = (RelativeLayout) inflate.findViewById(R.id.adscope_isv_container_rl);
            this.adInteractionImgView = (ImageView) this.adContainerView.findViewById(R.id.adscope_isv_img_iv);
            this.adIndicateArrowView = (AdIndicateArrowView) this.adContainerView.findViewById(R.id.adscope_isv_indicate_arrow_view);
            this.adContainerView.setId(i4);
            this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickView(this.adContainerView);
            this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickType(RenderTrackClickTypeEnum.RENDER_TRACK_CLICK_TYPE_SHAKE.getCode());
            int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), this.adResponseModel.getWidth(), this.adResponseModel.getHeight(), this.adResponseModel.getWidthMode(), this.adResponseModel.getHeightMode(), this.adResponseModel.getMarginLeft(), this.adResponseModel.getMarginTop(), this.adResponseModel.getMarginRight(), this.adResponseModel.getMarginBottom());
            RelativeLayout.LayoutParams buildRuleToOtherViewParams = RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]), textWidthAndHeight, this.adResponseModel), this.adResponseModel.getCenterX(), this.adResponseModel.getCenterY(), this.adResponseModel.getMarginLeft(), this.adResponseModel.getMarginTop(), this.adResponseModel.getMarginRight(), this.adResponseModel.getMarginBottom(), this.adResponseModel.getSuperView()), this.adResponseModel.getMarginLeft(), this.adResponseModel.getMarginTop(), this.adResponseModel.getMarginRight(), this.adResponseModel.getMarginBottom());
            View view2 = this.adContainerView;
            if (view2 != null) {
                view2.setLayoutParams(buildRuleToOtherViewParams);
            }
            int min = Math.min(textWidthAndHeight[0], textWidthAndHeight[1]);
            renderRoundBgView(min);
            renderAnimationView(min);
            renderIndicateArrowView(min);
            if (view != null) {
                ((ViewGroup) view).addView(this.adContainerView);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                viewGroup.addView(view);
            } else {
                viewGroup.addView(this.adContainerView);
            }
            addShakeViewAnimation();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
        try {
            AnimatorSet animatorSet = this.animatorSet;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.animatorSet = null;
            InteractionCommon interactionCommon = this.interactionCommon;
            if (interactionCommon != null) {
                interactionCommon.destroy();
            }
            this.interactionCommon = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.view.View
    public int getId() {
        View view = this.adContainerView;
        if (view != null) {
            return view.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.adContainerView;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public View getTotalAdView() {
        return this.totalAdView;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadSuccess() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InteractionCommon interactionCommon = this.interactionCommon;
        if (interactionCommon == null || !interactionCommon.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void setAdListener(AdListener adListener) {
        this.adListener = adListener;
    }

    public void setCurrentProgress(int i4) {
        try {
            AdIndicateArrowView adIndicateArrowView = this.adIndicateArrowView;
            if (adIndicateArrowView != null) {
                adIndicateArrowView.setCurrentProgress(i4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
        this.iTrackEventStatus = iTrackEventStatus;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setInteractionExecute(IInteractionExecute iInteractionExecute) {
        this.interactionExecute = iInteractionExecute;
    }

    public void setMaxProgress(int i4) {
        try {
            AdIndicateArrowView adIndicateArrowView = this.adIndicateArrowView;
            if (adIndicateArrowView != null) {
                adIndicateArrowView.setMaxProgress(i4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setNativeModel(NativeModel nativeModel) {
        this.nativeModel = nativeModel;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setRendView(RenderView renderView) {
        this.renderView = renderView;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        try {
            this.adResponseModel = interactionModel;
            this.adScopeCycleModel = adScopeCycleModel;
            this.totalAdView = viewGroup;
            renderView(viewGroup, view, i4);
            this.interactionCommon.setITrackEventStatus(this.iTrackEventStatus);
            this.interactionCommon.initInteraction(this.interactionExecute, interactionModel, this.nativeModel, adScopeCycleModel);
            atomicInteger.getAndDecrement();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public AdSharkInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duration = 50;
        this.angleDegreeZ = 30.0f;
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdSharkInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.duration = 50;
        this.angleDegreeZ = 30.0f;
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdSharkInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.duration = 50;
        this.angleDegreeZ = 30.0f;
        this.interactionCommon = new InteractionCommon(this);
    }
}
