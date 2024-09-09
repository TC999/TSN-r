package xyz.adscope.ad.control.interaction.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.inter.IBaseInteraction;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdViewInteractionView extends ViewGroup implements IInteractionView<InteractionModel> {
    private AdListener adListener;
    private RelativeLayout adViewInteractionView;
    private ITrackEventStatus iTrackEventStatus;
    private InteractionCommon interactionCommon;
    private IInteractionExecute interactionExecute;
    private NativeModel nativeModel;
    private RenderView renderView;
    private View totalAdView;

    public AdViewInteractionView(Context context) {
        super(context);
        this.interactionCommon = new InteractionCommon(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadAd$0(IBaseInteraction iBaseInteraction, View view) {
        if (iBaseInteraction != null) {
            iBaseInteraction.execute();
        }
    }

    private RelativeLayout renderView(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.adViewInteractionView = relativeLayout;
        relativeLayout.setId(i4);
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]);
        InteractionModel interactionModel2 = (InteractionModel) RenderViewUtil.buildNone4Super(interactionModel);
        RelativeLayout.LayoutParams buildMarginLayoutParams = RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), RenderViewUtil.getInstance().buildRuleParams(layoutParams, interactionModel2.getCenterX(), interactionModel2.getCenterY(), interactionModel2.getMarginLeft(), interactionModel2.getMarginTop(), interactionModel2.getMarginRight(), interactionModel2.getMarginBottom(), interactionModel2.getSuperView()), textWidthAndHeight, interactionModel2);
        if (!TextUtils.isEmpty(interactionModel2.getBgColor())) {
            this.adViewInteractionView.setBackgroundColor(Color.parseColor(interactionModel2.getBgColor()));
        }
        ShapeUtil.setViewBackGround(this.adViewInteractionView, interactionModel2.getBgColor(), 0, (String) null, StringUtil.strToInt(interactionModel2.getBorderRadius()));
        this.adViewInteractionView.setLayoutParams(buildMarginLayoutParams);
        if (view != null && view.getTag() != null) {
            if (((InteractionModel) view.getTag()).getSuperView().equals("super")) {
                ((ViewGroup) view).addView(this.adViewInteractionView);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                viewGroup.addView(view);
            } else {
                if ("bottom".equals(interactionModel2.getMarginTop().getLayout())) {
                    buildMarginLayoutParams.addRule(3, view.getId());
                }
                this.adViewInteractionView.setLayoutParams(buildMarginLayoutParams);
                viewGroup.addView(this.adViewInteractionView);
            }
        } else {
            viewGroup.addView(this.adViewInteractionView);
        }
        return this.adViewInteractionView;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        RelativeLayout relativeLayout = this.adViewInteractionView;
        if (relativeLayout != null) {
            relativeLayout.addView(view);
        }
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
        RelativeLayout relativeLayout = this.adViewInteractionView;
        if (relativeLayout != null) {
            return relativeLayout.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.adViewInteractionView;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public View getTotalAdView() {
        return this.totalAdView;
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadSuccess() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
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
        this.totalAdView = viewGroup;
        this.adViewInteractionView = renderView(interactionModel, viewGroup, view, i4);
        this.interactionCommon.setITrackEventStatus(this.iTrackEventStatus);
        final IBaseInteraction initInteraction = this.interactionCommon.initInteraction(this.interactionExecute, interactionModel, this.nativeModel, adScopeCycleModel);
        this.adViewInteractionView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.interaction.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdViewInteractionView.lambda$loadAd$0(IBaseInteraction.this, view2);
            }
        });
        viewGroup.setVisibility(0);
        atomicInteger.getAndDecrement();
    }

    public AdViewInteractionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdViewInteractionView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.interactionCommon = new InteractionCommon(this);
    }
}
