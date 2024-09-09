package xyz.adscope.ad.control.render.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.control.interaction.view.AdTotalView;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.render.util.UIAdapterUtil;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.AdResponseModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.model.http.response.ad.DwinfoModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.model.http.response.ad.RenderModel;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdAppInfoView extends AppCompatTextView implements IAdView<RenderModel> {
    private AdListener adListener;
    private String appName;
    private DwinfoModel dwinfoModel;
    private TextView textView1;

    public AdAppInfoView(Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
    }

    @Override // android.view.View
    public int getId() {
        TextView textView = this.textView1;
        if (textView != null) {
            return textView.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.textView1;
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

    public AdAppInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    @SuppressLint({"ResourceType"})
    public void loadAd(RenderModel renderModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        TextView textView = new TextView(getContext());
        this.textView1 = textView;
        textView.setId(i4);
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), renderModel.getWidth(), renderModel.getHeight(), renderModel.getWidthMode(), renderModel.getHeightMode(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(textWidthAndHeight[0], textWidthAndHeight[1]);
        AdResponseModel adResponseModel = adScopeCycleModel != null ? adScopeCycleModel.getAdResponseModel() : null;
        BidModel bidModel = adResponseModel != null ? AdResponseManager.getBidModel(adResponseModel) : null;
        NativeModel nativeModel = bidModel != null ? AdResponseManager.getNativeModel(bidModel) : null;
        if (nativeModel != null) {
            this.dwinfoModel = nativeModel.getDwinfo();
        }
        if (viewGroup instanceof AdTotalView) {
            AdTotalView adTotalView = (AdTotalView) viewGroup;
            adTotalView.setAppInfoRenderView(this.textView1);
            adTotalView.setDwinfoModel(this.dwinfoModel);
        }
        DwinfoModel dwinfoModel = this.dwinfoModel;
        if (dwinfoModel != null) {
            this.appName = dwinfoModel.getName();
            String developer = this.dwinfoModel.getDeveloper();
            String version = this.dwinfoModel.getVersion();
            this.textView1.setText(Html.fromHtml("\u5e94\u7528\u540d\u79f0\uff1a" + this.appName + " | \u5f00\u53d1\u8005\uff1a" + developer + " | \u5e94\u7528\u7248\u672c\uff1a" + version + " | <u>\u6743\u9650\u8be6\u60c5</u> | <u>\u9690\u79c1\u534f\u8bae</u> | <u>\u529f\u80fd\u4ecb\u7ecd</u>"));
            this.textView1.setVisibility(0);
        } else {
            this.textView1.setVisibility(8);
        }
        try {
            if (!TextUtils.isEmpty(renderModel.getTextColor())) {
                this.textView1.setTextColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor(renderModel.getTextColor())));
            }
            if (renderModel.getFontSize() > 0) {
                this.textView1.setTextSize(renderModel.getFontSize());
            }
            if (!TextUtils.isEmpty(renderModel.getBgColor())) {
                this.textView1.setBackgroundColor(Color.parseColor(UIAdapterUtil.getInstance().autoInterfaceStyleColor(renderModel.getBgColor())));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (!TextUtils.isEmpty(renderModel.getTitle())) {
            this.textView1.setText(renderModel.getTitle());
        }
        RenderViewUtil.buildAlignView(this.textView1, renderModel.getTextAlign());
        try {
            ShapeUtil.setViewBackGround(this.textView1, UIAdapterUtil.getInstance().autoInterfaceStyleColor(renderModel.getBgColor()), StringUtil.strToInt(renderModel.getBorderSize()), renderModel.getBorderColor(), RenderViewUtil.buildRadius(renderModel.getBorderRadius(), DeviceInfoUtil.px2dip(getContext(), textWidthAndHeight[1])));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        this.textView1.setLayoutParams(RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, textWidthAndHeight, renderModel), renderModel.getCenterX(), renderModel.getCenterY(), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom(), renderModel.getSuperView()), renderModel.getMarginLeft(), renderModel.getMarginTop(), renderModel.getMarginRight(), renderModel.getMarginBottom()));
        if (view != null) {
            ((ViewGroup) view).addView(this.textView1);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.textView1);
        }
        viewGroup.setVisibility(0);
        atomicInteger.getAndDecrement();
    }

    public AdAppInfoView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
