package xyz.adscope.ad.control.render.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.view.AdTotalView;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.RenderModel;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdVoiceView extends AppCompatImageView implements IAdView<RenderModel> {
    private AdListener adListener;
    private ImageView voiceImageView;

    public AdVoiceView(Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
    }

    @Override // android.view.View
    public int getId() {
        ImageView imageView = this.voiceImageView;
        if (imageView != null) {
            return imageView.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.voiceImageView;
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

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i4) {
        ImageView imageView = this.voiceImageView;
        if (imageView != null) {
            imageView.setImageResource(i4);
        }
    }

    public AdVoiceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    @SuppressLint({"ResourceType"})
    public void loadAd(RenderModel renderModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        ImageView imageView = new ImageView(getContext());
        this.voiceImageView = imageView;
        imageView.setId(i4);
        if (viewGroup instanceof AdTotalView) {
            ((AdTotalView) viewGroup).setVoiceRenderView(this.voiceImageView);
        }
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), renderModel.getWidth(), renderModel.getHeight(), renderModel.getWidthMode(), renderModel.getHeightMode(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]);
        int buildRadius = RenderViewUtil.buildRadius(renderModel.getBorderRadius(), DeviceInfoUtil.px2dip(getContext(), textWidthAndHeight[1]));
        try {
            if (!TextUtils.isEmpty(renderModel.getBgColor())) {
                ShapeUtil.setViewBackGround(this.voiceImageView, UIAdapterUtil.getInstance().autoInterfaceStyleColor(renderModel.getBgColor()), StringUtil.strToInt(renderModel.getBorderSize()), renderModel.getBorderColor(), buildRadius);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.voiceImageView.setLayoutParams(RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, textWidthAndHeight, renderModel), renderModel.getCenterX(), renderModel.getCenterY(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom(), renderModel.getSuperView()), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom()));
        if (view != null) {
            ((ViewGroup) view).addView(this.voiceImageView);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.voiceImageView);
        }
        viewGroup.setVisibility(0);
        atomicInteger.getAndDecrement();
    }

    public AdVoiceView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
