package xyz.adscope.ad.control.interaction.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
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
import xyz.adscope.common.info.AppInfo;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdTextInteractionView extends AppCompatTextView implements IInteractionView<InteractionModel> {
    private AdListener adListener;
    private TextView adTextInteractionView;
    private ITrackEventStatus iTrackEventStatus;
    private InteractionCommon interactionCommon;
    private IInteractionExecute interactionExecute;
    private NativeModel nativeModel;
    private RenderView renderView;
    private View totalAdView;

    public AdTextInteractionView(@NonNull Context context) {
        super(context);
        this.interactionCommon = new InteractionCommon(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadAd$0(IBaseInteraction iBaseInteraction, View view) {
        if (iBaseInteraction != null) {
            iBaseInteraction.execute();
        }
    }

    private TextView rendTextView(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4, AdScopeCycleModel adScopeCycleModel) {
        TextView textView = new TextView(getContext());
        this.adTextInteractionView = textView;
        textView.setId(i4);
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]);
        if (!TextUtils.isEmpty(interactionModel.getTextColor())) {
            this.adTextInteractionView.setTextColor(Color.parseColor(interactionModel.getTextColor()));
        }
        if (interactionModel.getFontSize() > 0) {
            this.adTextInteractionView.setTextSize(interactionModel.getFontSize());
        }
        if (!TextUtils.isEmpty(interactionModel.getBgColor())) {
            this.adTextInteractionView.setBackgroundColor(Color.parseColor(interactionModel.getBgColor()));
        }
        if (!TextUtils.isEmpty(interactionModel.getTitle())) {
            if (interactionModel.getTitle().equalsIgnoreCase("appname")) {
                this.adTextInteractionView.setText(AppInfo.getAppName(getContext()));
            } else if (interactionModel.getTitle().equalsIgnoreCase("tag")) {
                String materialMd5Value = adScopeCycleModel.getMaterialMd5Value();
                if (!TextUtils.isEmpty(materialMd5Value)) {
                    this.adTextInteractionView.setText(materialMd5Value);
                }
            } else {
                this.adTextInteractionView.setText(interactionModel.getTitle());
            }
        }
        RenderViewUtil.buildAlignView(this.adTextInteractionView, interactionModel.getTextAlign());
        ShapeUtil.setViewBackGround(this.adTextInteractionView, interactionModel.getBgColor(), StringUtil.strToInt(interactionModel.getBorderSize()), interactionModel.getBorderColor(), RenderViewUtil.buildRadius(interactionModel.getBorderRadius(), DeviceInfoUtil.px2dip(getContext(), textWidthAndHeight[1])));
        this.adTextInteractionView.setLayoutParams(RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, textWidthAndHeight, interactionModel), interactionModel.getCenterX(), interactionModel.getCenterY(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom(), interactionModel.getSuperView()), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom()));
        if (view != null) {
            ((ViewGroup) view).addView(this.adTextInteractionView);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.adTextInteractionView);
        }
        return this.adTextInteractionView;
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
        TextView textView = this.adTextInteractionView;
        if (textView != null) {
            return textView.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.adTextInteractionView;
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
        this.adTextInteractionView = rendTextView(interactionModel, viewGroup, view, i4, adScopeCycleModel);
        this.interactionCommon.setITrackEventStatus(this.iTrackEventStatus);
        final IBaseInteraction initInteraction = this.interactionCommon.initInteraction(this.interactionExecute, interactionModel, this.nativeModel, adScopeCycleModel);
        this.adTextInteractionView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.interaction.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdTextInteractionView.lambda$loadAd$0(IBaseInteraction.this, view2);
            }
        });
        viewGroup.setVisibility(0);
        atomicInteger.getAndDecrement();
    }

    public AdTextInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interactionCommon = new InteractionCommon(this);
    }
}
