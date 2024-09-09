package xyz.adscope.ad.control.interaction.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
public class AdEulerAngleInteractionView extends RelativeLayout implements IInteractionView<InteractionModel> {
    private View adContainerView;
    private AdIndicateArrowView adIndicateArrowView;
    private RelativeLayout adInteractionContainerRl;
    private ImageView adInteractionImgView;
    private AdListener adListener;
    private InteractionModel adResponseModel;
    private AdScopeCycleModel adScopeCycleModel;
    private TextView adSubTitleView;
    private LinearLayout adTitleContainerView;
    private TextView adTitleView;
    private float angleDegreeX;
    private float angleDegreeY;
    private float angleDegreeZ;
    private AnimatorSet animatorSet;
    private int duration;
    private ITrackEventStatus iTrackEventStatus;
    private InteractionCommon interactionCommon;
    private IInteractionExecute interactionExecute;
    private NativeModel nativeModel;
    private RenderView renderView;
    private int titleFontSize;
    private View totalAdView;
    private int[] widthAndHeight;

    public AdEulerAngleInteractionView(@NonNull Context context) {
        super(context);
        this.duration = 350;
        this.angleDegreeX = 60.0f;
        this.angleDegreeY = 60.0f;
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
            AdScopeImageLoader.loadImage(getContext(), imageUrl, new IImageLoaderCallback() { // from class: xyz.adscope.ad.control.interaction.view.AdEulerAngleInteractionView.1
                @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                public void failCallback(String str) {
                }

                @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                public void successCallback(Bitmap bitmap) {
                    try {
                        if (AdEulerAngleInteractionView.this.adInteractionImgView == null || bitmap == null) {
                            return;
                        }
                        AdEulerAngleInteractionView.this.adInteractionImgView.setImageBitmap(bitmap);
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

    private void renderTitleView() {
        try {
            InteractionModel interactionModel = this.adResponseModel;
            if (interactionModel == null) {
                return;
            }
            String textColor = interactionModel.getTextColor();
            textColor = (TextUtils.isEmpty(textColor) || !textColor.startsWith("#")) ? "#FFFFFFFF" : "#FFFFFFFF";
            int fontSize = this.adResponseModel.getFontSize();
            this.titleFontSize = fontSize;
            if (fontSize == 0) {
                this.titleFontSize = 20;
            }
            TextView textView = this.adTitleView;
            if (textView != null) {
                textView.setTextColor(Color.parseColor(textColor));
                this.adTitleView.setTextSize(this.titleFontSize);
                this.adTitleView.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
            TextView textView2 = this.adSubTitleView;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(textColor));
                this.adSubTitleView.setTextSize(this.titleFontSize - 4);
                this.adSubTitleView.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void renderView(ViewGroup viewGroup, View view, int i4) {
        try {
            View inflate = View.inflate(getContext(), R.layout.adscope_interaction_euler_angle_view, null);
            this.adContainerView = inflate;
            this.adInteractionContainerRl = (RelativeLayout) inflate.findViewById(R.id.adscope_ieav_container_rl);
            this.adInteractionImgView = (ImageView) this.adContainerView.findViewById(R.id.adscope_ieav_img_iv);
            this.adIndicateArrowView = (AdIndicateArrowView) this.adContainerView.findViewById(R.id.adscope_ieav_indicate_arrow_view);
            this.adTitleContainerView = (LinearLayout) this.adContainerView.findViewById(R.id.adscope_ieav_title_container_ll);
            this.adTitleView = (TextView) this.adContainerView.findViewById(R.id.adscope_ieav_title_tv);
            this.adSubTitleView = (TextView) this.adContainerView.findViewById(R.id.adscope_ieav_subtitle_tv);
            this.adContainerView.setId(i4);
            this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickView(this.adContainerView);
            this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickType(RenderTrackClickTypeEnum.RENDER_TRACK_CLICK_TYPE_EULER_ANGLE.getCode());
            this.widthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), this.adResponseModel.getWidth(), this.adResponseModel.getHeight(), this.adResponseModel.getWidthMode(), this.adResponseModel.getHeightMode(), this.adResponseModel.getMarginLeft(), this.adResponseModel.getMarginTop(), this.adResponseModel.getMarginRight(), this.adResponseModel.getMarginBottom());
            int[] iArr = this.widthAndHeight;
            int i5 = 0;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.max(iArr[0], iArr[1]), this.widthAndHeight[1]);
            int[] iArr2 = this.widthAndHeight;
            RelativeLayout.LayoutParams buildRuleToOtherViewParams = RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, new int[]{Math.max(iArr2[0], iArr2[1]), this.widthAndHeight[1]}, this.adResponseModel), this.adResponseModel.getCenterX(), this.adResponseModel.getCenterY(), this.adResponseModel.getMarginLeft(), this.adResponseModel.getMarginTop(), this.adResponseModel.getMarginRight(), this.adResponseModel.getMarginBottom(), this.adResponseModel.getSuperView()), this.adResponseModel.getMarginLeft(), this.adResponseModel.getMarginTop(), this.adResponseModel.getMarginRight(), this.adResponseModel.getMarginBottom());
            View view2 = this.adContainerView;
            if (view2 != null) {
                view2.setLayoutParams(buildRuleToOtherViewParams);
            }
            renderTitleView();
            LinearLayout linearLayout = this.adTitleContainerView;
            if (linearLayout != null) {
                linearLayout.measure(0, 0);
                i5 = this.adTitleContainerView.getMeasuredHeight();
            }
            int i6 = this.widthAndHeight[1] - i5;
            renderRoundBgView(i6);
            renderAnimationView(i6);
            renderIndicateArrowView(i6);
            if (view != null) {
                ((ViewGroup) view).addView(this.adContainerView);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                viewGroup.addView(view);
                return;
            }
            viewGroup.addView(this.adContainerView);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void setIndicateArrowDirection(String str, String str2, String str3) {
        try {
            if (this.adIndicateArrowView == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.adIndicateArrowView.setArrowDirection(0);
            } else if (("1".equals(str2) && "1".equals(str3)) || ((TextUtils.isEmpty(str2) && "1".equals(str3)) || (TextUtils.isEmpty(str3) && "1".equals(str2)))) {
                this.adIndicateArrowView.setArrowDirection(1);
            } else if (("2".equals(str2) && "2".equals(str3)) || ((TextUtils.isEmpty(str2) && "2".equals(str3)) || (TextUtils.isEmpty(str3) && "2".equals(str2)))) {
                this.adIndicateArrowView.setArrowDirection(2);
            } else {
                this.adIndicateArrowView.setArrowDirection(0);
            }
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

    public void setCurrentProgress(double d4) {
        try {
            AdIndicateArrowView adIndicateArrowView = this.adIndicateArrowView;
            if (adIndicateArrowView != null) {
                adIndicateArrowView.setCurrentProgress(d4);
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

    public void setMaxProgress(double d4) {
        try {
            AdIndicateArrowView adIndicateArrowView = this.adIndicateArrowView;
            if (adIndicateArrowView != null) {
                adIndicateArrowView.setMaxProgress(d4);
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

    public void setTitle(String str, String str2) {
        TextView textView;
        TextView textView2;
        try {
            LinearLayout linearLayout = this.adTitleContainerView;
            int i4 = 0;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            if (this.adTitleView != null && !TextUtils.isEmpty(str)) {
                this.adTitleView.setVisibility(0);
                this.adTitleView.setText(str);
            }
            if (this.adSubTitleView != null && !TextUtils.isEmpty(str2)) {
                this.adSubTitleView.setVisibility(0);
                this.adSubTitleView.setText(str2);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                    int i5 = this.widthAndHeight[1];
                    LinearLayout linearLayout2 = this.adTitleContainerView;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                    renderRoundBgView(i5);
                    renderAnimationView(i5);
                    renderIndicateArrowView(i5);
                    return;
                }
                if (TextUtils.isEmpty(str) && (textView2 = this.adTitleView) != null) {
                    textView2.setVisibility(8);
                }
                if (TextUtils.isEmpty(str2) && (textView = this.adSubTitleView) != null) {
                    textView.setVisibility(8);
                }
                LinearLayout linearLayout3 = this.adTitleContainerView;
                if (linearLayout3 != null) {
                    linearLayout3.measure(0, 0);
                    i4 = this.adTitleContainerView.getMeasuredHeight();
                }
                int i6 = this.widthAndHeight[1] - i4;
                renderRoundBgView(i6);
                renderAnimationView(i6);
                renderIndicateArrowView(i6);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void startInteractionAnimation(String str, String str2, String str3) {
        try {
            setIndicateArrowDirection(str, str2, str3);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                if ("2".equals(str)) {
                    addObjectAnimatorToList(arrayList, "rotationX", 0.0f, -this.angleDegreeX);
                    addObjectAnimatorToList(arrayList, "rotationX", -this.angleDegreeX, 0.0f);
                } else if ("1".equals(str)) {
                    addObjectAnimatorToList(arrayList, "rotationX", 0.0f, this.angleDegreeX);
                    addObjectAnimatorToList(arrayList, "rotationX", this.angleDegreeX, 0.0f);
                } else {
                    addObjectAnimatorToList(arrayList, "rotationX", 0.0f, this.angleDegreeX);
                    addObjectAnimatorToList(arrayList, "rotationX", this.angleDegreeX, 0.0f);
                    addObjectAnimatorToList(arrayList, "rotationX", 0.0f, -this.angleDegreeX);
                    addObjectAnimatorToList(arrayList, "rotationX", -this.angleDegreeX, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("2".equals(str2)) {
                    addObjectAnimatorToList(arrayList, "rotationY", 0.0f, -this.angleDegreeY);
                    addObjectAnimatorToList(arrayList, "rotationY", -this.angleDegreeY, 0.0f);
                } else if ("1".equals(str2)) {
                    addObjectAnimatorToList(arrayList, "rotationY", 0.0f, this.angleDegreeY);
                    addObjectAnimatorToList(arrayList, "rotationY", this.angleDegreeY, 0.0f);
                } else {
                    addObjectAnimatorToList(arrayList, "rotationY", 0.0f, this.angleDegreeY);
                    addObjectAnimatorToList(arrayList, "rotationY", this.angleDegreeY, 0.0f);
                    addObjectAnimatorToList(arrayList, "rotationY", 0.0f, -this.angleDegreeY);
                    addObjectAnimatorToList(arrayList, "rotationY", -this.angleDegreeY, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                if ("2".equals(str3)) {
                    addObjectAnimatorToList(arrayList, "rotation", 0.0f, -this.angleDegreeZ);
                    addObjectAnimatorToList(arrayList, "rotation", -this.angleDegreeZ, 0.0f);
                } else if ("1".equals(str3)) {
                    addObjectAnimatorToList(arrayList, "rotation", 0.0f, this.angleDegreeZ);
                    addObjectAnimatorToList(arrayList, "rotation", this.angleDegreeZ, 0.0f);
                } else {
                    addObjectAnimatorToList(arrayList, "rotation", 0.0f, this.angleDegreeZ);
                    addObjectAnimatorToList(arrayList, "rotation", this.angleDegreeZ, 0.0f);
                    addObjectAnimatorToList(arrayList, "rotation", 0.0f, -this.angleDegreeZ);
                    addObjectAnimatorToList(arrayList, "rotation", -this.angleDegreeZ, 0.0f);
                }
            }
            if (this.animatorSet != null) {
                this.animatorSet = null;
            }
            if (arrayList.size() > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.animatorSet = animatorSet;
                animatorSet.addListener(new Animator.AnimatorListener() { // from class: xyz.adscope.ad.control.interaction.view.AdEulerAngleInteractionView.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        try {
                            if (AdEulerAngleInteractionView.this.animatorSet != null) {
                                AdEulerAngleInteractionView.this.animatorSet.start();
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

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        this.adResponseModel = interactionModel;
        this.adScopeCycleModel = adScopeCycleModel;
        this.totalAdView = viewGroup;
        renderView(viewGroup, view, i4);
        this.interactionCommon.setITrackEventStatus(this.iTrackEventStatus);
        this.interactionCommon.initInteraction(this.interactionExecute, interactionModel, this.nativeModel, adScopeCycleModel);
        atomicInteger.getAndDecrement();
    }

    public AdEulerAngleInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duration = 350;
        this.angleDegreeX = 60.0f;
        this.angleDegreeY = 60.0f;
        this.angleDegreeZ = 30.0f;
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdEulerAngleInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.duration = 350;
        this.angleDegreeX = 60.0f;
        this.angleDegreeY = 60.0f;
        this.angleDegreeZ = 30.0f;
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdEulerAngleInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.duration = 350;
        this.angleDegreeX = 60.0f;
        this.angleDegreeY = 60.0f;
        this.angleDegreeZ = 30.0f;
        this.interactionCommon = new InteractionCommon(this);
    }
}
