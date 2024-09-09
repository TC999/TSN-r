package xyz.adscope.ad.control.interaction.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.acse.ottn.adapter.AutoScrollViewPager;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.action.download.DownloadAppInfoActivity;
import xyz.adscope.ad.control.action.download.DownloadUtil;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.interaction.view.custom.AdCustomTextView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.util.ShapeUtil;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.DwinfoModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdAppInfoInteractionView extends RelativeLayout implements IInteractionView<InteractionModel> {
    private AdCustomTextView adCustomTextView;
    private String appName;
    private DwinfoModel dwinfoModel;
    private NativeModel nativeModel;
    private View totalAdView;

    public AdAppInfoInteractionView(Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public void destroy() {
    }

    @Override // android.view.View
    public int getId() {
        AdCustomTextView adCustomTextView = this.adCustomTextView;
        if (adCustomTextView != null) {
            return adCustomTextView.getId();
        }
        return super.getId();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView, xyz.adscope.ad.control.render.inter.IAdView
    public View getSelfView() {
        return this.adCustomTextView;
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
        this.nativeModel = nativeModel;
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionView
    public void setRendView(RenderView renderView) {
    }

    public AdAppInfoInteractionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // xyz.adscope.ad.control.render.inter.IAdView
    public void loadAd(InteractionModel interactionModel, ViewGroup viewGroup, View view, int i4, IRenderCallback iRenderCallback, AtomicInteger atomicInteger, AdScopeCycleModel adScopeCycleModel) {
        String str;
        AdCustomTextView adCustomTextView = new AdCustomTextView(getContext());
        this.adCustomTextView = adCustomTextView;
        adCustomTextView.setId(i4);
        this.totalAdView = viewGroup;
        int[] textWidthAndHeight = RenderViewUtil.getInstance().getTextWidthAndHeight(getContext(), interactionModel.getWidth(), interactionModel.getHeight(), interactionModel.getWidthMode(), interactionModel.getHeightMode(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, textWidthAndHeight[1]);
        if (!TextUtils.isEmpty(interactionModel.getAlign()) && AutoScrollViewPager.f4767g.equals(interactionModel.getAlign())) {
            layoutParams.addRule(17, -1);
        }
        NativeModel nativeModel = this.nativeModel;
        if (nativeModel != null) {
            this.dwinfoModel = nativeModel.getDwinfo();
        }
        DwinfoModel dwinfoModel = this.dwinfoModel;
        if (dwinfoModel != null) {
            this.appName = dwinfoModel.getName();
            str = "\u5e94\u7528\u540d\u79f0\uff1a" + this.appName + " | \u5f00\u53d1\u8005\uff1a" + this.dwinfoModel.getDeveloper() + " | \u5e94\u7528\u7248\u672c\uff1a" + this.dwinfoModel.getVersion() + " | <u>\u6743\u9650\u8be6\u60c5</u> | <u>\u9690\u79c1\u534f\u8bae</u> | <u>\u529f\u80fd\u4ecb\u7ecd</u>";
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(interactionModel.getTitle())) {
            str = interactionModel.getTitle();
        }
        this.adCustomTextView.setText(Html.fromHtml(str));
        if (interactionModel.getFontSize() > 0) {
            this.adCustomTextView.setTextSize(interactionModel.getFontSize());
        }
        this.adCustomTextView.setPadding(10, 5, 10, 5);
        ShapeUtil.setViewBackGround(this.adCustomTextView, interactionModel.getBgColor(), 0, (String) null, StringUtil.strToInt(interactionModel.getBorderRadius()));
        RelativeLayout.LayoutParams buildRuleToOtherViewParams = RenderViewUtil.getInstance().buildRuleToOtherViewParams(RenderViewUtil.getInstance().buildRuleParams(RenderViewUtil.getInstance().buildMarginLayoutParams(getContext(), layoutParams, textWidthAndHeight, interactionModel), interactionModel.getCenterX(), interactionModel.getCenterY(), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom(), interactionModel.getSuperView()), interactionModel.getMarginLeft(), interactionModel.getMarginTop(), interactionModel.getMarginRight(), interactionModel.getMarginBottom());
        this.adCustomTextView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.interaction.view.AdAppInfoInteractionView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                try {
                    if (AdAppInfoInteractionView.this.dwinfoModel != null) {
                        String policyContent = DownloadUtil.getPolicyContent(AdAppInfoInteractionView.this.dwinfoModel);
                        String permissionContent = DownloadUtil.getPermissionContent(AdAppInfoInteractionView.this.dwinfoModel);
                        String appIntroContent = DownloadUtil.getAppIntroContent(AdAppInfoInteractionView.this.dwinfoModel);
                        Intent intent = new Intent(AdAppInfoInteractionView.this.getContext(), DownloadAppInfoActivity.class);
                        if (!(AdAppInfoInteractionView.this.getContext() instanceof Activity)) {
                            intent.setFlags(268435456);
                        }
                        intent.putExtra(Constants.TITLE_CONTENT_KEY, AdAppInfoInteractionView.this.appName);
                        intent.putExtra(Constants.PRIVACY_CONTENT_KEY, policyContent);
                        intent.putExtra("permission_content_key", permissionContent);
                        intent.putExtra(Constants.INTRO_CONTENT_KEY, appIntroContent);
                        AdAppInfoInteractionView.this.getContext().startActivity(intent);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
        this.adCustomTextView.setLayoutParams(buildRuleToOtherViewParams);
        if (view != null && view.getTag() != null) {
            ((ViewGroup) view).addView(this.adCustomTextView);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
        } else {
            viewGroup.addView(this.adCustomTextView);
        }
        atomicInteger.getAndDecrement();
    }

    public AdAppInfoInteractionView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public AdAppInfoInteractionView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
