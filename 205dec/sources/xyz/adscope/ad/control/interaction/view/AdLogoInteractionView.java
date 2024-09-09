package xyz.adscope.ad.control.interaction.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.acse.ottn.adapter.AutoScrollViewPager;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.R;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.action.webview.WebViewActivity;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.interaction.view.custom.AdCustomImageView;
import xyz.adscope.ad.control.interaction.view.custom.AdCustomLogoView;
import xyz.adscope.ad.control.interaction.view.custom.AdCustomTextView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.tool.imageloader.AdScopeImageLoader;
import xyz.adscope.common.imageloader.inter.IImageLoaderCallback;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdLogoInteractionView extends RelativeLayout implements IInteractionView<InteractionModel> {
    private View adCustomLogoView;
    private View totalAdView;

    public AdLogoInteractionView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isImageView(InteractionModel interactionModel) {
        return TextUtils.isEmpty(interactionModel.getTitle());
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
    }

    @Override // android.view.View
    public int getId() {
        View view = this.adCustomLogoView;
        if (view != null) {
            return view.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.adCustomLogoView;
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
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setInteractionExecute(IInteractionExecute iInteractionExecute) {
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setNativeModel(NativeModel nativeModel) {
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setRendView(RenderView renderView) {
    }

    public AdLogoInteractionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(final InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        if (!isImageView(interactionModel)) {
            AdCustomLogoView adCustomLogoView = new AdCustomLogoView(getContext());
            this.adCustomLogoView = adCustomLogoView;
            adCustomLogoView.setPadding(8, 0, 8, 0);
        } else {
            this.adCustomLogoView = new AdCustomImageView(getContext());
        }
        this.adCustomLogoView.setId(i4);
        this.totalAdView = viewGroup;
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, textWidthAndHeight[1]);
        if (!isImageView(interactionModel)) {
            ((AdCustomLogoView) this.adCustomLogoView).setLogoTitle(interactionModel.getTitle());
        }
        if (isImageView(interactionModel)) {
            ((AdCustomImageView) this.adCustomLogoView).setImageDrawable(getResources().getDrawable(R.drawable.adscope_ad_logo));
        } else {
            ((AdCustomLogoView) this.adCustomLogoView).setImageDrawable(getResources().getDrawable(R.drawable.adscope_ad_logo));
        }
        if (!TextUtils.isEmpty(interactionModel.getImageUrl())) {
            new AdScopeImageLoader();
            AdScopeImageLoader.loadImage(getContext(), interactionModel.getImageUrl(), false, new IImageLoaderCallback() { // from class: xyz.adscope.ad.control.interaction.view.AdLogoInteractionView.1
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
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                        if (AdLogoInteractionView.this.isImageView(interactionModel)) {
                            ((AdCustomImageView) AdLogoInteractionView.this.adCustomLogoView).setImageDrawable(bitmapDrawable);
                        } else {
                            ((AdCustomTextView) AdLogoInteractionView.this.adCustomLogoView).setCompoundDrawablesWithIntrinsicBounds(bitmapDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(interactionModel.getAlign()) && AutoScrollViewPager.f4767g.equals(interactionModel.getAlign())) {
            layoutParams.addRule(17, -1);
        }
        if (!isImageView(interactionModel) && interactionModel.getFontSize() > 0) {
            ((AdCustomLogoView) this.adCustomLogoView).setTextSize(interactionModel.getFontSize());
        }
        if (!isImageView(interactionModel) && !TextUtils.isEmpty(interactionModel.getTextColor())) {
            ((AdCustomLogoView) this.adCustomLogoView).setTextColor(Color.parseColor(interactionModel.getTextColor()));
        }
        if (!TextUtils.isEmpty(interactionModel.getBgColor())) {
            this.adCustomLogoView.setBackgroundColor(Color.parseColor(interactionModel.getBgColor()));
        }
        ShapeUtil.setViewBackGround(this.adCustomLogoView, interactionModel.getBgColor(), 0, (String) null, StringUtil.strToInt(interactionModel.getBorderRadius()));
        RelativeLayout.LayoutParams buildRuleToOtherViewParams = RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, textWidthAndHeight, interactionModel), interactionModel.getCenterX(), interactionModel.getCenterY(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom(), interactionModel.getSuperView()), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        this.adCustomLogoView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.interaction.view.AdLogoInteractionView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TextUtils.isEmpty(interactionModel.getPrivacyUrl())) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("url", interactionModel.getPrivacyUrl());
                if (!(AdLogoInteractionView.this.getContext() instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                intent.setClass(AdLogoInteractionView.this.getContext(), WebViewActivity.class);
                AdLogoInteractionView.this.getContext().startActivity(intent);
            }
        });
        this.adCustomLogoView.setLayoutParams(buildRuleToOtherViewParams);
        if (view != null && view.getTag() != null) {
            ((ViewGroup) view).addView(this.adCustomLogoView);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.adCustomLogoView);
        }
        atomicInteger.getAndDecrement();
    }

    public AdLogoInteractionView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public AdLogoInteractionView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
