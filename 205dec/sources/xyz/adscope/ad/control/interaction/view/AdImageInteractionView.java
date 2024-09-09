package xyz.adscope.ad.control.interaction.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.R;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.interaction.inter.IBaseInteraction;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.interaction.view.custom.AdCustomImageView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.tool.imageloader.AdScopeImageLoader;
import xyz.adscope.common.imageloader.inter.IImageLoaderCallback;
import xyz.adscope.common.info.AppInfo;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdImageInteractionView extends AppCompatImageView implements IInteractionView<InteractionModel> {
    private AdListener adListener;
    private AdCustomImageView customRoundImageView;
    private IInteractionExecute iInteractionExecute;
    private ITrackEventStatus iTrackEventStatus;
    private InteractionCommon interactionCommon;
    private NativeModel nativeModel;
    private RenderView renderView;
    private View totalAdView;

    public AdImageInteractionView(@NonNull Context context) {
        super(context);
        this.interactionCommon = new InteractionCommon(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadAd$0(IBaseInteraction iBaseInteraction, View view) {
        if (iBaseInteraction != null) {
            iBaseInteraction.execute();
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
        AdCustomImageView adCustomImageView = this.customRoundImageView;
        if (adCustomImageView != null) {
            return adCustomImageView.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.customRoundImageView;
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

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        this.totalAdView = viewGroup;
        AdCustomImageView adCustomImageView = new AdCustomImageView(getContext());
        this.customRoundImageView = adCustomImageView;
        adCustomImageView.setId(i4);
        this.interactionCommon.setITrackEventStatus(this.iTrackEventStatus);
        final IBaseInteraction initInteraction = this.interactionCommon.initInteraction(this.iInteractionExecute, interactionModel, this.nativeModel, adScopeCycleModel);
        this.customRoundImageView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.interaction.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdImageInteractionView.lambda$loadAd$0(IBaseInteraction.this, view2);
            }
        });
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]);
        if (!TextUtils.isEmpty(interactionModel.getImageUrl())) {
            if ("appicon".equalsIgnoreCase(interactionModel.getImageUrl())) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((DeviceInfoUtil.dip2px(getContext(), StringUtil.strToFloat(((InteractionModel) view.getTag()).getHeight().getSize())) - DeviceInfoUtil.dip2px(getContext(), StringUtil.strToFloat(interactionModel.getMarginTop().getSize()))) - DeviceInfoUtil.dip2px(getContext(), StringUtil.strToFloat(interactionModel.getMarginBottom().getSize())), -1);
                this.customRoundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                if (AppInfo.getAppIcon(getContext()) != null) {
                    this.customRoundImageView.setImageBitmap(AppInfo.getAppIcon(getContext()));
                } else {
                    this.customRoundImageView.setImageResource(R.drawable.adscope_app_icon);
                }
                if (!TextUtils.isEmpty(interactionModel.getBorderRadius())) {
                    this.customRoundImageView.setRectRadius(Float.parseFloat(interactionModel.getBorderRadius()));
                }
                layoutParams = layoutParams2;
            } else if ("arrowback".equalsIgnoreCase(interactionModel.getImageUrl())) {
                this.customRoundImageView.setImageDrawable(getResources().getDrawable(R.drawable.adscope_ad_back));
            } else if (InteractionCommon.DISLIKE_TYPE_EXECUTION.equalsIgnoreCase(interactionModel.getImageUrl())) {
                this.customRoundImageView.setImageDrawable(getResources().getDrawable(R.drawable.asnp_dislike));
            }
            if (!TextUtils.isEmpty(interactionModel.getImageUrl())) {
                new AdScopeImageLoader();
                AdScopeImageLoader.loadImage(getContext(), interactionModel.getImageUrl(), false, new IImageLoaderCallback() { // from class: xyz.adscope.ad.control.interaction.view.AdImageInteractionView.1
                    @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                    public void failCallback(String str) {
                        String str2 = Constants.TAG;
                        LogUtil.i(str2, "AdLogoInteractionView error : " + str);
                    }

                    @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                    public void successCallback(Bitmap bitmap) {
                        String str = Constants.TAG;
                        LogUtil.i(str, "AdLogoInteractionView bitmap : " + bitmap);
                        if (bitmap != null) {
                            AdImageInteractionView.this.customRoundImageView.setImageDrawable(new BitmapDrawable(bitmap));
                        }
                    }
                });
            }
        }
        this.customRoundImageView.setLayoutParams(RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, textWidthAndHeight, interactionModel), interactionModel.getCenterX(), interactionModel.getCenterY(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom(), interactionModel.getSuperView()), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom()));
        if (view != null && view.getTag() != null) {
            ((ViewGroup) view).addView(this.customRoundImageView);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.customRoundImageView);
        }
        atomicInteger.getAndDecrement();
    }

    public AdImageInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interactionCommon = new InteractionCommon(this);
    }

    public AdImageInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.interactionCommon = new InteractionCommon(this);
    }
}
