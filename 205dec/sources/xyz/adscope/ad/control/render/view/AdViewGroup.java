package xyz.adscope.ad.control.render.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.RenderModel;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdViewGroup extends RelativeLayout implements IAdView<RenderModel> {
    private AdListener adListener;
    private RelativeLayout adViewGroup;

    public AdViewGroup(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        RelativeLayout relativeLayout = this.adViewGroup;
        if (relativeLayout != null) {
            relativeLayout.addView(view);
        }
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
    }

    @Override // android.view.View
    public int getId() {
        RelativeLayout relativeLayout = this.adViewGroup;
        if (relativeLayout != null) {
            return relativeLayout.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.adViewGroup;
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
    }

    public AdViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(RenderModel renderModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.adViewGroup = relativeLayout;
        relativeLayout.setId(i4);
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), renderModel.getWidth(), renderModel.getHeight(), renderModel.getWidthMode(), renderModel.getHeightMode(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]);
        RenderModel renderModel2 = (RenderModel) RenderViewUtil.buildNone4Super(renderModel);
        RelativeLayout.LayoutParams buildRuleToOtherViewParams = RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), RenderViewUtil.getInstance().buildRuleParams(layoutParams, renderModel2.getCenterX(), renderModel2.getCenterY(), renderModel2.getMarginLeft(), renderModel2.getMarginTop(), renderModel2.getMarginRight(), renderModel2.getMarginBottom(), renderModel2.getSuperView()), textWidthAndHeight, renderModel2), renderModel2.getMarginLeft(), renderModel2.getMarginTop(), renderModel2.getMarginRight(), renderModel2.getMarginBottom());
        try {
            if (!TextUtils.isEmpty(renderModel2.getBgColor())) {
                this.adViewGroup.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor(renderModel2.getBgColor())));
            }
            ShapeUtil.setViewBackGround(this.adViewGroup, UIAdapterUtil.getInstance().autoInterfaceStyleColor(renderModel2.getBgColor()), 0, (String) null, StringUtil.strToInt(renderModel2.getBorderRadius()));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.adViewGroup.setLayoutParams(buildRuleToOtherViewParams);
        if (view != null && view.getTag() != null) {
            ((ViewGroup) view).addView(this.adViewGroup);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.adViewGroup);
        }
        viewGroup.setVisibility(0);
        atomicInteger.getAndDecrement();
    }

    public AdViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
