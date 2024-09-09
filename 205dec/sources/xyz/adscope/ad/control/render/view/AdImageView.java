package xyz.adscope.ad.control.render.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.advertisings.model.AdType;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.control.render.inter.IRender;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.model.RenderViewEnum;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.control.render.widget.CustomRoundImageView;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.ImageFilter;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.RenderModel;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;
import xyz.adscope.ad.tool.imageloader.AdScopeImageLoader;
import xyz.adscope.common.imageloader.inter.IImageLoaderCallback;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdImageView extends FrameLayout implements IAdView<RenderModel> {
    private AdListener adListener;
    private CustomRoundImageView imageView;
    private Context mContext;

    public AdImageView(Context context) {
        super(context);
        this.mContext = context;
    }

    private void buildImageView(RenderModel renderModel, ViewGroup viewGroup, View view, int i4, AdScopeCycleModel adScopeCycleModel) {
        RelativeLayout.LayoutParams layoutParams;
        this.imageView = new CustomRoundImageView(this.mContext);
        adScopeCycleModel.getAdScopeRenderCustomTrackerModel().setAdView(this.imageView);
        try {
            if (!TextUtils.isEmpty(renderModel.getBgColor()) && renderModel.getBgColor().startsWith("#")) {
                this.imageView.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor(renderModel.getBgColor())));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.imageView.setRectRadius(StringUtil.strToInt(renderModel.getBorderRadius()));
        this.imageView.setBorderColor(renderModel.getBorderColor());
        this.imageView.setId(i4);
        this.imageView.setBorderWidth(StringUtil.strToInt(renderModel.getBorderSize()));
        if (renderModel.getPaddingLeft() != null && renderModel.getPaddingTop() != null && renderModel.getPaddingRight() != null && renderModel.getPaddingBottom() != null) {
            this.imageView.setPadding(StringUtil.strToInt(renderModel.getPaddingLeft().getSize()), StringUtil.strToInt(renderModel.getPaddingTop().getSize()), StringUtil.strToInt(renderModel.getPaddingRight().getSize()), StringUtil.strToInt(renderModel.getPaddingBottom().getSize()));
        }
        int[] iArr = new int[2];
        if (isMainImage(renderModel)) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        } else {
            iArr = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), renderModel.getWidth(), renderModel.getHeight(), renderModel.getWidthMode(), renderModel.getHeightMode(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom());
            layoutParams = new RelativeLayout.LayoutParams(iArr[0], iArr[1]);
        }
        this.imageView.setLayoutParams(RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, iArr, renderModel), renderModel.getCenterX(), renderModel.getCenterY(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom(), renderModel.getSuperView()), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom()));
        if (view != null && view.getTag() != null) {
            ((ViewGroup) view).addView(this.imageView);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.imageView);
        }
        viewGroup.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFailEvent(AdScopeCycleModel adScopeCycleModel, String str, String str2, IRenderCallback iRenderCallback) {
        if (iRenderCallback != null) {
            IRender.RENDER_ERROR_TYPE render_error_type = IRender.RENDER_ERROR_TYPE.RENDER_IMAGE_FAIL;
            iRenderCallback.failCallback(render_error_type.getCode(), render_error_type.getMsg());
        }
        IRender.RENDER_ERROR_TYPE render_error_type2 = IRender.RENDER_ERROR_TYPE.RENDER_IMAGE_FAIL;
        adScopeCycleModel.setErrorInfo(render_error_type2.getMsg());
        adScopeCycleModel.setErrorCode(render_error_type2.getCode() + "");
        AdScopeEventReport.getInstance().reportAdEvent(adScopeCycleModel, EventReportCode.EVENT_REPORT_RENDER_FAIL_CODE, (System.currentTimeMillis() - adScopeCycleModel.getRenderStartTime()) + "");
        adScopeCycleModel.setRenderStartTime(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMainImage(RenderModel renderModel) {
        return renderModel.getImageModel() != null && RenderViewEnum.RenderImageViewType.IMAGE_VIEW_MAIN_TYPE.getImageType().equals(renderModel.getImageModel().getType());
    }

    private boolean isNativeAd(AdScopeCycleModel adScopeCycleModel) {
        return adScopeCycleModel != null && adScopeCycleModel.getSpaceType().equals(AdType.NATIVE.getValue());
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
    }

    @Override // android.view.View
    public int getId() {
        CustomRoundImageView customRoundImageView = this.imageView;
        if (customRoundImageView != null) {
            return customRoundImageView.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.imageView;
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

    public void startRenderImageView(final RenderModel renderModel, ViewGroup viewGroup, View view, int i4, final IRenderCallback iRenderCallback, AtomicInteger atomicInteger, final AdScopeCycleModel adScopeCycleModel) {
        if (this.mContext == null) {
            StringBuilder sb = new StringBuilder();
            IRender.RENDER_ERROR_TYPE render_error_type = IRender.RENDER_ERROR_TYPE.RENDER_FAIL_CONTEXT_NULL;
            sb.append(render_error_type.getCode());
            sb.append("");
            doFailEvent(adScopeCycleModel, sb.toString(), render_error_type.getMsg(), iRenderCallback);
        } else if (renderModel == null) {
        } else {
            try {
                buildImageView(renderModel, viewGroup, view, i4, adScopeCycleModel);
                new AdScopeImageLoader();
                AdScopeImageLoader.loadImage(this.mContext, renderModel.getImageUrl(), new IImageLoaderCallback() { // from class: xyz.adscope.ad.control.render.view.AdImageView.1
                    @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                    public void failCallback(String str) {
                        AdImageView adImageView = AdImageView.this;
                        AdScopeCycleModel adScopeCycleModel2 = adScopeCycleModel;
                        StringBuilder sb2 = new StringBuilder();
                        IRender.RENDER_ERROR_TYPE render_error_type2 = IRender.RENDER_ERROR_TYPE.RENDER_IMAGE_FAIL;
                        sb2.append(render_error_type2.getCode());
                        sb2.append("");
                        adImageView.doFailEvent(adScopeCycleModel2, sb2.toString(), render_error_type2.getMsg(), iRenderCallback);
                    }

                    @Override // xyz.adscope.common.imageloader.inter.IImageLoaderCallback
                    public void successCallback(Bitmap bitmap) {
                        if (bitmap == null) {
                            return;
                        }
                        try {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(ImageFilter.blurBitmap(AdImageView.this.mContext, bitmap, 20.0f));
                            if (AdImageView.this.isMainImage(renderModel)) {
                                AdImageView.this.imageView.setBackground(bitmapDrawable);
                            }
                            AdImageView.this.imageView.setImageBitmap(bitmap);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                });
            } catch (Exception e4) {
                String str = Constants.TAG;
                LogUtil.i(str, " Exception : " + e4);
                StringBuilder sb2 = new StringBuilder();
                IRender.RENDER_ERROR_TYPE render_error_type2 = IRender.RENDER_ERROR_TYPE.RENDER_IMAGE_EXCEPTION;
                sb2.append(render_error_type2.getCode());
                sb2.append("");
                doFailEvent(adScopeCycleModel, sb2.toString(), render_error_type2.getMsg(), iRenderCallback);
            }
        }
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(RenderModel renderModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        startRenderImageView(renderModel, viewGroup, view, i4, iRenderCallback, atomicInteger, adScopeCycleModel);
        atomicInteger.getAndDecrement();
    }

    public AdImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public AdImageView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mContext = context;
    }
}
