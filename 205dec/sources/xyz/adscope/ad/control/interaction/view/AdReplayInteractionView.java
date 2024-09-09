package xyz.adscope.ad.control.interaction.view;

import android.content.Context;
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
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.interaction.view.custom.AdCustomImageView;
import xyz.adscope.ad.control.interaction.view.custom.AdCustomTextView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.render.view.AdVideoView;
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
public class AdReplayInteractionView extends RelativeLayout implements IInteractionView<InteractionModel> {
    private View adCustomReplayView;
    private View totalAdView;

    public AdReplayInteractionView(Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
    }

    @Override // android.view.View
    public int getId() {
        View view = this.adCustomReplayView;
        if (view != null) {
            return view.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.adCustomReplayView;
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

    public void setVisibleStatus(int i4) {
        View view = this.adCustomReplayView;
        if (view != null) {
            view.setVisibility(i4);
        }
    }

    public AdReplayInteractionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        AdCustomImageView adCustomImageView = new AdCustomImageView(getContext());
        this.adCustomReplayView = adCustomImageView;
        adCustomImageView.setId(i4);
        this.totalAdView = viewGroup;
        if (viewGroup instanceof AdTotalView) {
            ((AdTotalView) viewGroup).setAdReplayInteractionView(this);
        }
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, textWidthAndHeight[1]);
        ((AdCustomImageView) this.adCustomReplayView).setImageDrawable(getResources().getDrawable(R.drawable.asnp_video_replay_icon));
        if (!TextUtils.isEmpty(interactionModel.getImageUrl())) {
            new AdScopeImageLoader();
            AdScopeImageLoader.loadImage(getContext(), interactionModel.getImageUrl(), false, new IImageLoaderCallback() { // from class: xyz.adscope.ad.control.interaction.view.AdReplayInteractionView.1
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
                        ((AdCustomTextView) AdReplayInteractionView.this.adCustomReplayView).setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(bitmap), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(interactionModel.getAlign()) && AutoScrollViewPager.f4767g.equals(interactionModel.getAlign())) {
            layoutParams.addRule(17, -1);
        }
        if (!TextUtils.isEmpty(interactionModel.getBgColor())) {
            this.adCustomReplayView.setBackgroundColor(Color.parseColor(interactionModel.getBgColor()));
        }
        ShapeUtil.setViewBackGround(this.adCustomReplayView, interactionModel.getBgColor(), 0, (String) null, StringUtil.strToInt(interactionModel.getBorderRadius()));
        RelativeLayout.LayoutParams buildRuleToOtherViewParams = RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, textWidthAndHeight, interactionModel), interactionModel.getCenterX(), interactionModel.getCenterY(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom(), interactionModel.getSuperView()), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        this.adCustomReplayView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.interaction.view.AdReplayInteractionView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdVideoView adVideoView;
                AdReplayInteractionView.this.adCustomReplayView.setVisibility(8);
                if (AdReplayInteractionView.this.totalAdView == null || !(AdReplayInteractionView.this.totalAdView instanceof AdTotalView) || (adVideoView = ((AdTotalView) AdReplayInteractionView.this.totalAdView).getAdVideoView()) == null) {
                    return;
                }
                adVideoView.operateReplayVideo();
            }
        });
        this.adCustomReplayView.setLayoutParams(buildRuleToOtherViewParams);
        if (view != null && view.getTag() != null) {
            ((ViewGroup) view).addView(this.adCustomReplayView);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.adCustomReplayView);
        }
        this.adCustomReplayView.setVisibility(8);
        atomicInteger.getAndDecrement();
    }

    public AdReplayInteractionView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public AdReplayInteractionView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
