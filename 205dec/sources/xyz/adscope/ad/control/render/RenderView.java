package xyz.adscope.ad.control.render;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import xyz.adscope.ad.R;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.advertisings.base.IBaseAdListener;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.action.download.DownloadAppInfoActivity;
import xyz.adscope.ad.control.action.download.DownloadUtil;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.inter.IInteractionView;
import xyz.adscope.ad.control.interaction.view.AdAppInfoInteractionView;
import xyz.adscope.ad.control.interaction.view.AdClickInteractionView;
import xyz.adscope.ad.control.interaction.view.AdComplainInteractionView;
import xyz.adscope.ad.control.interaction.view.AdEulerAngleInteractionView;
import xyz.adscope.ad.control.interaction.view.AdGestureInteractionView;
import xyz.adscope.ad.control.interaction.view.AdImageInteractionView;
import xyz.adscope.ad.control.interaction.view.AdLogoInteractionView;
import xyz.adscope.ad.control.interaction.view.AdMuteInteractionView;
import xyz.adscope.ad.control.interaction.view.AdReplayInteractionView;
import xyz.adscope.ad.control.interaction.view.AdRollInteractionView;
import xyz.adscope.ad.control.interaction.view.AdSharkInteractionView;
import xyz.adscope.ad.control.interaction.view.AdTagInteractionView;
import xyz.adscope.ad.control.interaction.view.AdTextInteractionView;
import xyz.adscope.ad.control.interaction.view.AdTotalView;
import xyz.adscope.ad.control.interaction.view.AdViewInteractionView;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IAdView;
import xyz.adscope.ad.control.render.inter.IRender;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.view.AdAppInfoView;
import xyz.adscope.ad.control.render.view.AdImageView;
import xyz.adscope.ad.control.render.view.AdTextView;
import xyz.adscope.ad.control.render.view.AdVideoView;
import xyz.adscope.ad.control.render.view.AdViewGroup;
import xyz.adscope.ad.control.render.view.AdVoiceView;
import xyz.adscope.ad.control.render.view.AdWebView;
import xyz.adscope.ad.control.template.TemplateManager;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.util.RenderViewUtil;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.model.http.response.ad.DwinfoModel;
import xyz.adscope.ad.model.http.response.ad.InteractionModel;
import xyz.adscope.ad.model.http.response.ad.MediaModel;
import xyz.adscope.ad.model.http.response.ad.NativeModel;
import xyz.adscope.ad.model.http.response.ad.RenderModel;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.json.util.JsonResolver;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RenderView implements IRender<MediaModel> {
    private IBaseAdListener adListener;
    private AdScopeCycleModel adScopeCycleModel;
    private String adType;
    private boolean autoHeight;
    private BidModel bidModel;
    private Context context;
    private WeakReference<Handler> handler;
    private List<IAdView> iAdViewList;
    private List<IInteractionView> iInteractionView;
    private ITrackEventStatus iTrackEventStatus;
    private IInteractionExecute interactionExecute;
    private final int RENDER_VIEW_PRE = 1000;
    private final int INTERACTION_VIEW_PRE = 2000;
    private AtomicInteger atomicIntegerRender = null;

    /* renamed from: xyz.adscope.ad.control.render.RenderView$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class AnonymousClass3 implements Runnable {
        public final /* synthetic */ ViewGroup val$viewGroup;

        public AnonymousClass3(ViewGroup viewGroup) {
            this.val$viewGroup = viewGroup;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$1(View view) {
            LogUtil.i(Constants.TAG, "maskView");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$2(ImageView imageView, ImageView imageView2, View view, AdVideoView adVideoView, View view2) {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
            view.setVisibility(8);
            adVideoView.operateReplayVideo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$3(DwinfoModel dwinfoModel, View view) {
            if (dwinfoModel != null) {
                try {
                    String policyContent = DownloadUtil.getPolicyContent(dwinfoModel);
                    String permissionContent = DownloadUtil.getPermissionContent(dwinfoModel);
                    String appIntroContent = DownloadUtil.getAppIntroContent(dwinfoModel);
                    Intent intent = new Intent(view.getContext(), DownloadAppInfoActivity.class);
                    if (!(view.getContext() instanceof Activity)) {
                        intent.setFlags(268435456);
                    }
                    intent.putExtra(Constants.TITLE_CONTENT_KEY, dwinfoModel.getName());
                    intent.putExtra(Constants.PRIVACY_CONTENT_KEY, policyContent);
                    intent.putExtra("permission_content_key", permissionContent);
                    intent.putExtra(Constants.INTRO_CONTENT_KEY, appIntroContent);
                    view.getContext().startActivity(intent);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AdTotalView adTotalView = (AdTotalView) this.val$viewGroup;
            final AdVideoView adVideoView = adTotalView.getAdVideoView();
            int[] iArr = new int[2];
            this.val$viewGroup.getLocationInWindow(iArr);
            if (adVideoView != null) {
                ImageView voiceRenderView = adTotalView.getVoiceRenderView();
                if (voiceRenderView != null) {
                    if (adVideoView.isVoiceOn()) {
                        voiceRenderView.setImageResource(R.drawable.asnp_voice_on);
                    } else {
                        voiceRenderView.setImageResource(R.drawable.asnp_voice_off);
                    }
                    int width = voiceRenderView.getWidth();
                    int height = voiceRenderView.getHeight();
                    int[] iArr2 = new int[2];
                    voiceRenderView.getLocationInWindow(iArr2);
                    int i4 = iArr2[0] - iArr[0];
                    int i5 = iArr2[1] - iArr[1];
                    ImageView imageView = new ImageView(this.val$viewGroup.getContext());
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                    layoutParams.leftMargin = i4;
                    layoutParams.topMargin = i5;
                    this.val$viewGroup.addView(imageView, layoutParams);
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.render.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            AdVideoView.this.operateMute();
                        }
                    });
                }
                final ImageView replayImageView = adVideoView.getReplayImageView();
                if (replayImageView != null) {
                    View selfView = adVideoView.getSelfView();
                    int width2 = selfView.getWidth();
                    int height2 = selfView.getHeight();
                    int[] iArr3 = new int[2];
                    selfView.getLocationInWindow(iArr3);
                    int i6 = iArr3[0] - iArr[0];
                    int i7 = iArr3[1] - iArr[1];
                    final View view = new View(this.val$viewGroup.getContext());
                    view.setLayoutParams(new ViewGroup.LayoutParams(width2, height2));
                    view.setBackgroundColor(Color.parseColor("#99000000"));
                    view.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(width2, height2);
                    layoutParams2.leftMargin = i6;
                    layoutParams2.topMargin = i7;
                    this.val$viewGroup.addView(view, layoutParams2);
                    adTotalView.setMaskView(view);
                    view.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.render.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            RenderView.AnonymousClass3.lambda$run$1(view2);
                        }
                    });
                    int width3 = replayImageView.getWidth();
                    int height3 = replayImageView.getHeight();
                    int[] iArr4 = new int[2];
                    replayImageView.getLocationInWindow(iArr4);
                    int i8 = iArr4[0] - iArr[0];
                    int i9 = iArr4[1] - iArr[1];
                    final ImageView imageView2 = new ImageView(this.val$viewGroup.getContext());
                    imageView2.setLayoutParams(new ViewGroup.LayoutParams(width3, height3));
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(width3, width3);
                    layoutParams3.leftMargin = i8;
                    layoutParams3.topMargin = i9;
                    this.val$viewGroup.addView(imageView2, layoutParams3);
                    adTotalView.setReplayInteractionView(imageView2);
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.render.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            RenderView.AnonymousClass3.lambda$run$2(imageView2, replayImageView, view, adVideoView, view2);
                        }
                    });
                }
            }
            TextView appInfoRenderView = adTotalView.getAppInfoRenderView();
            if (appInfoRenderView != null) {
                int width4 = appInfoRenderView.getWidth();
                int height4 = appInfoRenderView.getHeight();
                int[] iArr5 = new int[2];
                appInfoRenderView.getLocationInWindow(iArr5);
                int i10 = iArr5[1] - iArr[1];
                ImageView imageView3 = new ImageView(this.val$viewGroup.getContext());
                imageView3.setLayoutParams(new ViewGroup.LayoutParams(width4, height4));
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(width4, height4);
                layoutParams4.leftMargin = iArr5[0] - iArr[0];
                layoutParams4.topMargin = i10;
                this.val$viewGroup.addView(imageView3, layoutParams4);
                final DwinfoModel dwinfoModel = adTotalView.getDwinfoModel();
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.control.render.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        RenderView.AnonymousClass3.lambda$run$3(DwinfoModel.this, view2);
                    }
                });
            }
        }
    }

    private void delayRenderInteraction(ViewGroup viewGroup) {
        WeakReference<Handler> weakReference = this.handler;
        if (weakReference == null || weakReference.get() == null || !(viewGroup instanceof AdTotalView)) {
            return;
        }
        this.handler.get().postDelayed(new AnonymousClass3(viewGroup), 200L);
    }

    private void executeRendAd(ViewGroup viewGroup, IRenderCallback iRenderCallback) {
        this.iAdViewList = buildRenderView();
        this.iInteractionView = buildInteractionView();
        if (this.autoHeight) {
            int dip2px = DeviceInfoUtil.dip2px(viewGroup.getContext(), this.adScopeCycleModel.getNativeAdViewWidth());
            int autoHeight = RenderViewUtil.getInstance().getAutoHeight(viewGroup.getContext(), this.iAdViewList, dip2px, DeviceInfoUtil.dip2px(viewGroup.getContext(), this.adScopeCycleModel.getNativeAdViewHeight()));
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (autoHeight > 0) {
                layoutParams.height = autoHeight;
            } else {
                layoutParams.height = -2;
            }
            if (dip2px > 0) {
                layoutParams.width = dip2px;
            } else {
                layoutParams.width = -2;
            }
            viewGroup.setLayoutParams(layoutParams);
        }
        this.atomicIntegerRender = new AtomicInteger(this.iAdViewList.size() + this.iInteractionView.size());
        this.adScopeCycleModel.setRenderStartTime(System.currentTimeMillis());
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_RENDER_CODE, "");
        startRender(viewGroup, iRenderCallback);
    }

    private String getAdType() {
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        return adScopeCycleModel != null ? adScopeCycleModel.getSpaceType() : "";
    }

    private void sort(List<InteractionModel> list) {
        Collections.sort(list, new Comparator<InteractionModel>() { // from class: xyz.adscope.ad.control.render.RenderView.1
            @Override // java.util.Comparator
            public int compare(InteractionModel interactionModel, InteractionModel interactionModel2) {
                int a4 = androidx.constraintlayout.motion.widget.a.a(interactionModel.getLayer(), interactionModel2.getLayer());
                return a4 == 0 ? androidx.constraintlayout.motion.widget.a.a(StringUtil.strToInt(interactionModel.getId()), StringUtil.strToInt(interactionModel2.getId())) : a4;
            }
        });
    }

    private void sortRenderList(List<RenderModel> list) {
        Collections.sort(list, new Comparator<RenderModel>() { // from class: xyz.adscope.ad.control.render.RenderView.2
            @Override // java.util.Comparator
            public int compare(RenderModel renderModel, RenderModel renderModel2) {
                renderModel.getLayer();
                int a4 = androidx.constraintlayout.motion.widget.a.a(renderModel.getLayer(), renderModel2.getLayer());
                return a4 == 0 ? androidx.constraintlayout.motion.widget.a.a(StringUtil.strToInt(renderModel.getId()), StringUtil.strToInt(renderModel2.getId())) : a4;
            }
        });
    }

    private void writeTemplateToLocal() {
        String str;
        NativeModel nativeModel = AdResponseManager.getNativeModel(this.bidModel);
        if (nativeModel != null) {
            String renderId = nativeModel.getRenderId();
            String interactionId = nativeModel.getInteractionId();
            List<InteractionModel> interaction = nativeModel.getInteraction();
            String str2 = null;
            try {
                str = JsonResolver.toJson(nativeModel.getRender());
                try {
                    str2 = JsonResolver.toJson(interaction);
                } catch (Exception e4) {
                    e = e4;
                    LogUtil.e(Constants.TAG, "e : " + e);
                    if (!TextUtils.isEmpty(renderId)) {
                        TemplateManager.getInstance().writeLocalRenderTemplate(this.adType, renderId, str);
                    }
                    if (TextUtils.isEmpty(interactionId)) {
                        return;
                    }
                    return;
                }
            } catch (Exception e5) {
                e = e5;
                str = null;
            }
            if (!TextUtils.isEmpty(renderId) && !TextUtils.isEmpty(str)) {
                TemplateManager.getInstance().writeLocalRenderTemplate(this.adType, renderId, str);
            }
            if (TextUtils.isEmpty(interactionId) || TextUtils.isEmpty(str2)) {
                return;
            }
            TemplateManager.getInstance().writeLocalInteractionTemplate(this.adType, interactionId, str2);
        }
    }

    public List<IInteractionView> buildInteractionView() {
        List<IInteractionView> interactionView = getInteractionView();
        if (interactionView.size() <= 1) {
            return interactionView;
        }
        for (int i4 = 0; i4 < interactionView.size(); i4++) {
            IInteractionView iInteractionView = interactionView.get(i4);
            InteractionModel interactionModel = (InteractionModel) ((View) iInteractionView).getTag();
            for (int i5 = 0; i5 < interactionView.size(); i5++) {
                View view = (View) interactionView.get(i5);
                InteractionModel interactionModel2 = (InteractionModel) view.getTag();
                if (interactionModel.getId().equals(interactionModel2.getSuperView())) {
                    interactionModel2.setDependenceView(iInteractionView);
                    view.setTag(interactionModel2);
                }
                if (interactionModel2.getMarginTop() != null && interactionModel.getId().equals(interactionModel2.getMarginTop().getReference())) {
                    interactionModel2.getMarginTop().setReferenceView(iInteractionView);
                    view.setTag(interactionModel2);
                }
                if (interactionModel2.getMarginBottom() != null && interactionModel.getId().equals(interactionModel2.getMarginBottom().getReference())) {
                    interactionModel2.getMarginBottom().setReferenceView(iInteractionView);
                    view.setTag(interactionModel2);
                }
                if (interactionModel2.getMarginLeft() != null && interactionModel.getId().equals(interactionModel2.getMarginLeft().getReference())) {
                    interactionModel2.getMarginLeft().setReferenceView(iInteractionView);
                    view.setTag(interactionModel2);
                }
                if (interactionModel2.getMarginRight() != null && interactionModel.getId().equals(interactionModel2.getMarginRight().getReference())) {
                    interactionModel2.getMarginRight().setReferenceView(iInteractionView);
                    view.setTag(interactionModel2);
                }
            }
        }
        return interactionView;
    }

    public List<IAdView> buildRenderView() {
        List<IAdView> renderView = getRenderView();
        if (renderView.size() <= 1) {
            return renderView;
        }
        for (int i4 = 0; i4 < renderView.size(); i4++) {
            IAdView iAdView = renderView.get(i4);
            RenderModel renderModel = (RenderModel) ((View) iAdView).getTag();
            for (int i5 = 0; i5 < renderView.size(); i5++) {
                View view = (View) renderView.get(i5);
                RenderModel renderModel2 = (RenderModel) view.getTag();
                if (renderModel.getId().equals(renderModel2.getSuperView())) {
                    renderModel2.setDependenceView(iAdView);
                    view.setTag(renderModel2);
                }
                if (renderModel2.getMarginTop() != null && renderModel.getId().equals(renderModel2.getMarginTop().getReference())) {
                    renderModel2.getMarginTop().setReferenceView(iAdView);
                    view.setTag(renderModel2);
                }
                if (renderModel2.getMarginBottom() != null && renderModel.getId().equals(renderModel2.getMarginBottom().getReference())) {
                    renderModel2.getMarginBottom().setReferenceView(iAdView);
                    view.setTag(renderModel2);
                }
                if (renderModel2.getMarginLeft() != null && renderModel.getId().equals(renderModel2.getMarginLeft().getReference())) {
                    renderModel2.getMarginLeft().setReferenceView(iAdView);
                    view.setTag(renderModel2);
                }
                if (renderModel2.getMarginRight() != null && renderModel.getId().equals(renderModel2.getMarginRight().getReference())) {
                    renderModel2.getMarginRight().setReferenceView(iAdView);
                    view.setTag(renderModel2);
                }
            }
        }
        return renderView;
    }

    @Override // xyz.adscope.ad.control.render.inter.IRender
    public void destroy() {
        List<IInteractionView> list = this.iInteractionView;
        if (list != null && list.size() > 0) {
            for (IInteractionView iInteractionView : this.iInteractionView) {
                iInteractionView.destroy();
            }
            this.iInteractionView.clear();
            this.iInteractionView = null;
        }
        List<IAdView> list2 = this.iAdViewList;
        if (list2 != null && list2.size() > 0) {
            for (IAdView iAdView : this.iAdViewList) {
                iAdView.destroy();
            }
            this.iAdViewList.clear();
            this.iAdViewList = null;
        }
        WeakReference<Handler> weakReference = this.handler;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.handler.get().removeCallbacks(null);
        this.handler.clear();
        this.handler = null;
    }

    public AdClickInteractionView getAdClickInteractionView() {
        List<IInteractionView> list = this.iInteractionView;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (int i4 = 0; i4 < this.iInteractionView.size(); i4++) {
            IInteractionView iInteractionView = this.iInteractionView.get(i4);
            if (iInteractionView instanceof AdClickInteractionView) {
                return (AdClickInteractionView) iInteractionView;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [xyz.adscope.ad.control.interaction.view.AdTagInteractionView] */
    /* JADX WARN: Type inference failed for: r4v11, types: [xyz.adscope.ad.control.interaction.view.AdTextInteractionView] */
    /* JADX WARN: Type inference failed for: r4v12, types: [xyz.adscope.ad.control.interaction.view.AdAppInfoInteractionView] */
    /* JADX WARN: Type inference failed for: r4v13, types: [xyz.adscope.ad.control.interaction.view.AdGestureInteractionView] */
    /* JADX WARN: Type inference failed for: r4v15, types: [xyz.adscope.ad.control.interaction.view.AdSharkInteractionView] */
    /* JADX WARN: Type inference failed for: r4v2, types: [xyz.adscope.ad.control.interaction.view.AdEulerAngleInteractionView] */
    /* JADX WARN: Type inference failed for: r4v3, types: [xyz.adscope.ad.control.interaction.view.AdRollInteractionView] */
    /* JADX WARN: Type inference failed for: r4v4, types: [xyz.adscope.ad.control.interaction.view.AdReplayInteractionView] */
    /* JADX WARN: Type inference failed for: r4v5, types: [xyz.adscope.ad.control.interaction.view.AdMuteInteractionView] */
    /* JADX WARN: Type inference failed for: r4v6, types: [xyz.adscope.ad.control.interaction.view.AdLogoInteractionView] */
    /* JADX WARN: Type inference failed for: r4v7, types: [xyz.adscope.ad.control.interaction.view.AdImageInteractionView] */
    /* JADX WARN: Type inference failed for: r4v8, types: [xyz.adscope.ad.control.interaction.view.AdViewInteractionView] */
    /* JADX WARN: Type inference failed for: r4v9, types: [xyz.adscope.ad.control.interaction.view.AdComplainInteractionView] */
    public List<IInteractionView> getInteractionView() {
        ArrayList arrayList = new ArrayList();
        List<InteractionModel> interactionTypeFrom = AdResponseManager.getInteractionTypeFrom(this.bidModel, this.adType);
        if (interactionTypeFrom != null && interactionTypeFrom.size() > 0) {
            sort(interactionTypeFrom);
            for (int i4 = 0; i4 < interactionTypeFrom.size(); i4++) {
                InteractionModel interactionModel = interactionTypeFrom.get(i4);
                AdClickInteractionView adClickInteractionView = null;
                if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_SHARK.getValue().equals(interactionModel.getControlType())) {
                    adClickInteractionView = new AdSharkInteractionView(this.context);
                } else if (!IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_CLICK.getValue().equals(interactionModel.getControlType()) && !IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_REGIONAL.getValue().equals(interactionModel.getControlType()) && !IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_CAPSULE_CLOSE.getValue().equals(interactionModel.getControlType().toLowerCase())) {
                    if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_GESTURE.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdGestureInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_APPINFO.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdAppInfoInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_TEXT.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdTextInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_TAG.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdTagInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_COMPLAIN.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdComplainInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_VIEW.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdViewInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_IMAGE.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdImageInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_LOGO.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdLogoInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_MUTE.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdMuteInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_REPLAY.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdReplayInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_ROLL.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdRollInteractionView(this.context);
                    } else if (IInteractionView.INTERACTION_VIEW_TYPE.INTERACTION_VIEW_EULERANGLE.getValue().equals(interactionModel.getControlType())) {
                        adClickInteractionView = new AdEulerAngleInteractionView(this.context);
                    }
                } else {
                    adClickInteractionView = new AdClickInteractionView(this.context);
                }
                if (adClickInteractionView != null) {
                    IBaseAdListener iBaseAdListener = this.adListener;
                    if (iBaseAdListener != null && (iBaseAdListener instanceof AdListener)) {
                        adClickInteractionView.setAdListener((AdListener) iBaseAdListener);
                    }
                    adClickInteractionView.setTag(interactionModel);
                    arrayList.add(adClickInteractionView);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [xyz.adscope.ad.control.render.view.AdTextView] */
    /* JADX WARN: Type inference failed for: r3v4, types: [xyz.adscope.ad.control.render.view.AdVoiceView] */
    /* JADX WARN: Type inference failed for: r3v5, types: [xyz.adscope.ad.control.render.view.AdAppInfoView] */
    /* JADX WARN: Type inference failed for: r3v6, types: [xyz.adscope.ad.control.render.view.AdVideoView] */
    /* JADX WARN: Type inference failed for: r3v7, types: [xyz.adscope.ad.control.render.view.AdWebView] */
    /* JADX WARN: Type inference failed for: r3v9, types: [xyz.adscope.ad.control.render.view.AdImageView] */
    public List<IAdView> getRenderView() {
        ArrayList arrayList = new ArrayList();
        List<RenderModel> renderTypeFrom = AdResponseManager.getRenderTypeFrom(this.bidModel, this.adType);
        if (renderTypeFrom != null && renderTypeFrom.size() > 0) {
            sortRenderList(renderTypeFrom);
            for (int i4 = 0; i4 < renderTypeFrom.size(); i4++) {
                AdViewGroup adViewGroup = null;
                if (IAdView.AD_VIEW_TYPE.IMAGE_VIEW.getValue().equals(renderTypeFrom.get(i4).getControlType())) {
                    adViewGroup = new AdImageView(this.context);
                } else if (IAdView.AD_VIEW_TYPE.WEB_VIEW.getValue().equals(renderTypeFrom.get(i4).getControlType())) {
                    adViewGroup = new AdWebView(this.context);
                } else if (IAdView.AD_VIEW_TYPE.VIDEO_VIEW.getValue().equals(renderTypeFrom.get(i4).getControlType())) {
                    adViewGroup = new AdVideoView(this.context);
                } else if (IAdView.AD_VIEW_TYPE.APP_INFO_VIEW.getValue().equals(renderTypeFrom.get(i4).getControlType())) {
                    adViewGroup = new AdAppInfoView(this.context);
                } else if (IAdView.AD_VIEW_TYPE.VOICE_VIEW.getValue().equals(renderTypeFrom.get(i4).getControlType())) {
                    adViewGroup = new AdVoiceView(this.context);
                } else if (IAdView.AD_VIEW_TYPE.TEXT_VIEW.getValue().equals(renderTypeFrom.get(i4).getControlType())) {
                    adViewGroup = new AdTextView(this.context);
                } else if (IAdView.AD_VIEW_TYPE.TYPE_VIEW.getValue().equals(renderTypeFrom.get(i4).getControlType())) {
                    adViewGroup = new AdViewGroup(this.context);
                }
                if (adViewGroup != null) {
                    IBaseAdListener iBaseAdListener = this.adListener;
                    if (iBaseAdListener != null && (iBaseAdListener instanceof AdListener)) {
                        adViewGroup.setAdListener((AdListener) iBaseAdListener);
                    }
                    adViewGroup.setTag(renderTypeFrom.get(i4));
                    arrayList.add(adViewGroup);
                }
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.ad.control.render.inter.IRender
    public void rendAd(Context context, ViewGroup viewGroup, BidModel bidModel, AdScopeCycleModel adScopeCycleModel, IRenderCallback iRenderCallback) {
        this.context = context;
        this.adScopeCycleModel = adScopeCycleModel;
        this.bidModel = bidModel;
        this.adType = getAdType();
        this.handler = new WeakReference<>(new Handler(Looper.getMainLooper()));
        executeRendAd(viewGroup, iRenderCallback);
    }

    @Override // xyz.adscope.ad.control.render.inter.IRender
    public void renderSuccess() {
    }

    public void setAdListener(IBaseAdListener iBaseAdListener) {
        this.adListener = iBaseAdListener;
    }

    @Override // xyz.adscope.ad.control.render.inter.IRender
    public void setAutoHeight(boolean z3) {
        this.autoHeight = z3;
    }

    @Override // xyz.adscope.ad.control.render.inter.IRender
    public void setITrackEventStatus(ITrackEventStatus iTrackEventStatus) {
        this.iTrackEventStatus = iTrackEventStatus;
    }

    @Override // xyz.adscope.ad.control.render.inter.IRender
    public void setInteractionExecute(IInteractionExecute iInteractionExecute) {
        this.interactionExecute = iInteractionExecute;
    }

    @Override // xyz.adscope.ad.control.render.inter.IRender
    public void startRender(ViewGroup viewGroup, IRenderCallback iRenderCallback) {
        IRender.RENDER_ERROR_TYPE render_error_type;
        List<IAdView> list = this.iAdViewList;
        if (list != null && list.size() > 0) {
            for (int i4 = 0; i4 < this.iAdViewList.size(); i4++) {
                IAdView iAdView = this.iAdViewList.get(i4);
                RenderModel renderModel = (RenderModel) ((View) iAdView).getTag();
                iAdView.setITrackEventStatus(this.iTrackEventStatus);
                if (renderModel.getDependenceView() != null) {
                    iAdView.loadAd(renderModel, viewGroup, (View) renderModel.getDependenceView(), i4 + 1000, iRenderCallback, this.atomicIntegerRender, this.adScopeCycleModel);
                } else {
                    iAdView.loadAd(renderModel, viewGroup, null, i4 + 1000, iRenderCallback, this.atomicIntegerRender, this.adScopeCycleModel);
                }
            }
        }
        List<IInteractionView> list2 = this.iInteractionView;
        if (list2 != null && list2.size() > 0) {
            for (int i5 = 0; i5 < this.iInteractionView.size(); i5++) {
                IInteractionView iInteractionView = this.iInteractionView.get(i5);
                InteractionModel interactionModel = (InteractionModel) ((View) iInteractionView).getTag();
                iInteractionView.setNativeModel(AdResponseManager.getNativeModel(this.bidModel));
                iInteractionView.setInteractionExecute(this.interactionExecute);
                iInteractionView.setITrackEventStatus(this.iTrackEventStatus);
                iInteractionView.setRendView(this);
                if (interactionModel.getDependenceView() != null) {
                    iInteractionView.loadAd(interactionModel, viewGroup, (View) interactionModel.getDependenceView(), i5 + 2000, iRenderCallback, this.atomicIntegerRender, this.adScopeCycleModel);
                } else {
                    iInteractionView.loadAd(interactionModel, viewGroup, null, i5 + 2000, iRenderCallback, this.atomicIntegerRender, this.adScopeCycleModel);
                }
            }
        }
        delayRenderInteraction(viewGroup);
        LogUtil.i(Constants.TAG, "atomicIntegerRender.get() : " + this.atomicIntegerRender.get());
        if (this.atomicIntegerRender.get() == 0) {
            LogUtil.i(Constants.TAG, "onAdRenderSuccess");
            IBaseAdListener iBaseAdListener = this.adListener;
            if (iBaseAdListener != null && (iBaseAdListener instanceof AdListener)) {
                ((AdListener) iBaseAdListener).onAdRenderSuccess();
            }
            String str = (System.currentTimeMillis() - this.adScopeCycleModel.getRenderStartTime()) + "";
            LogUtil.i(Constants.TAG, "roundTripTimeASNP \u6e32\u67d3\u6700\u7ec8\u8017\u65f6 \uff1a" + str);
            AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_RENDER_SUCCESS_CODE, str);
            this.adScopeCycleModel.setRenderStartTime(0L);
            if (iRenderCallback != null) {
                iRenderCallback.successCallback();
            }
        } else {
            IBaseAdListener iBaseAdListener2 = this.adListener;
            if (iBaseAdListener2 != null && (iBaseAdListener2 instanceof AdListener)) {
                ((AdListener) iBaseAdListener2).onAdRenderFail();
            }
            AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_RENDER_FAIL_CODE, (System.currentTimeMillis() - this.adScopeCycleModel.getRenderStartTime()) + "");
            this.adScopeCycleModel.setRenderStartTime(0L);
            if (iRenderCallback != null) {
                IRender.RENDER_ERROR_TYPE render_error_type2 = IRender.RENDER_ERROR_TYPE.RENDER_FAIL_TOTAL_RENDER_OR_INTERACTION_NOT_COMPLETE;
                iRenderCallback.failCallback(render_error_type2.getCode(), render_error_type2.getMsg());
            }
            this.adScopeCycleModel.setErrorInfo(IRender.RENDER_ERROR_TYPE.RENDER_FAIL_TOTAL_RENDER_OR_INTERACTION_NOT_COMPLETE.getMsg());
            this.adScopeCycleModel.setErrorInfo(render_error_type.getCode() + "");
        }
        writeTemplateToLocal();
    }
}
