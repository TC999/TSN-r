package xyz.adscope.ad.control.interaction.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.interaction.view.custom.AdTwistView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.model.RenderTrackClickTypeEnum;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdRollInteractionView extends RelativeLayout implements IInteractionView<InteractionModel> {
    private AdListener adListener;
    private AdScopeCycleModel adScopeCycleModel;
    private AdTwistView adSharkInteractionView;
    private ITrackEventStatus iTrackEventStatus;
    private InteractionCommon interactionCommon;
    private IInteractionExecute interactionExecute;
    private NativeModel nativeModel;
    private RenderView renderView;
    private View totalAdView;

    public AdRollInteractionView(@NonNull Context context) {
        super(context);
        this.interactionCommon = new InteractionCommon(this);
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
    }

    @Override // android.view.View
    public int getId() {
        AdTwistView adTwistView = this.adSharkInteractionView;
        if (adTwistView != null) {
            return adTwistView.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.adSharkInteractionView;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public View getTotalAdView() {
        return this.totalAdView;
    }

    @SuppressLint({"ResourceType"})
    public void initAnim(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4) {
        this.adSharkInteractionView = new AdTwistView(viewGroup.getContext());
        this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickView(this.adSharkInteractionView);
        this.adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setClickType(RenderTrackClickTypeEnum.RENDER_TRACK_CLICK_TYPE_SHAKE.getCode());
        this.adSharkInteractionView.setId(i4);
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        this.adSharkInteractionView.setLayoutParams(RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]), textWidthAndHeight, interactionModel), interactionModel.getCenterX(), interactionModel.getCenterY(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom(), interactionModel.getSuperView()), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom()));
        if (view != null) {
            ((ViewGroup) view).addView(this.adSharkInteractionView);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return;
        }
        viewGroup.addView(this.adSharkInteractionView);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadSuccess() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.interactionCommon.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
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
        this.interactionExecute = iInteractionExecute;
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
        this.adScopeCycleModel = adScopeCycleModel;
        this.totalAdView = viewGroup;
        this.interactionCommon.setITrackEventStatus(this.iTrackEventStatus);
        this.interactionCommon.initInteraction(this.interactionExecute, interactionModel, this.nativeModel, adScopeCycleModel);
        initAnim(interactionModel, viewGroup, view, i4);
        atomicInteger.getAndDecrement();
    }

    public AdRollInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdRollInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdRollInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.interactionCommon = new InteractionCommon(this);
    }
}
