package com.mbridge.msdk.splash.p504c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p470b.FeedbackDialogEventListener;
import com.mbridge.msdk.foundation.p470b.FeedbackManager;
import com.mbridge.msdk.foundation.p470b.p471a.FeedBackBtnBean;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.tools.DynamicViewResourceManager;
import com.mbridge.msdk.mbjscommon.confirmation.SecondaryConfirmationManager;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.splash.p501a.ViewRenderParam;
import com.mbridge.msdk.splash.p501a.p502a.SplashUtils;
import com.mbridge.msdk.splash.p503b.NativeViewRenderStatusListener;
import com.mbridge.msdk.splash.p505d.SplashBridgeListener;
import com.mbridge.msdk.splash.view.MBSplashNativeView;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.widget.dialog.MBAlertDialogListener;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;

/* renamed from: com.mbridge.msdk.splash.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class NativeViewRenderManager {

    /* compiled from: NativeViewRenderManager.java */
    /* renamed from: com.mbridge.msdk.splash.c.a$5 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static /* synthetic */ class C115735 {

        /* renamed from: a */
        static final /* synthetic */ int[] f31767a;

        static {
            int[] iArr = new int[EAction.values().length];
            f31767a = iArr;
            try {
                iArr[EAction.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31767a[EAction.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31767a[EAction.NOTICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31767a[EAction.FEEDBACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31767a[EAction.PRIVATE_ADDRESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31767a[EAction.PERMISSION_INFO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: NativeViewRenderManager.java */
    /* renamed from: com.mbridge.msdk.splash.c.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11574a {

        /* renamed from: a */
        private static final NativeViewRenderManager f31768a = new NativeViewRenderManager();

        /* renamed from: a */
        public static /* synthetic */ NativeViewRenderManager m21237a() {
            return f31768a;
        }
    }

    private NativeViewRenderManager() {
    }

    /* renamed from: a */
    public final void m21238a(final MBSplashView mBSplashView, final ViewRenderParam viewRenderParam, final NativeViewRenderStatusListener nativeViewRenderStatusListener) {
        Context context = mBSplashView.getContext();
        if (context == null) {
            context = MBSDKContext.m22865f().m22861j();
        }
        if (viewRenderParam == null && nativeViewRenderStatusListener != null) {
            nativeViewRenderStatusListener.mo21181a("The render parameters is unavailable.");
            return;
        }
        String m21868a = (viewRenderParam == null || viewRenderParam.m21279c() == null) ? "" : DynamicViewResourceManager.m21868a(viewRenderParam.m21279c().getAdZip());
        if (!TextUtils.isEmpty(m21868a)) {
            if (viewRenderParam == null || viewRenderParam.m21279c() == null) {
                return;
            }
            if (!TextUtils.isEmpty(viewRenderParam.m21279c().getAdZip())) {
                try {
                    final DyOption build = new DyOption.Builder().campaignEx(viewRenderParam.m21279c()).file((File) null).fileDir(m21868a).dyAdType(DyAdType.SPLASH).canSkip(viewRenderParam.m21278d()).isScreenClick(viewRenderParam.m21275g() == 1).isClickButtonVisible(viewRenderParam.m21276f() == 0).isShakeVisible(viewRenderParam.m21273i() == 1).isApkInfoVisible(viewRenderParam.m21274h() == 0).isLogoVisible(viewRenderParam.m21269m() == 1).shakeStrenght(viewRenderParam.m21272j()).shakeTime(viewRenderParam.m21271k()).orientation(viewRenderParam.m21270l()).countDownTime(viewRenderParam.m21277e()).adChoiceLink(SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k()).m23346az()).build();
                    mBSplashView.setDyCountDownListener(new DyCountDownListener() { // from class: com.mbridge.msdk.splash.c.a.1
                        {
                            NativeViewRenderManager.this = this;
                        }

                        public final void getCountDownValue(int i) {
                            build.setDyCountDownListener(i);
                        }
                    });
                    DynamicViewCreator.getInstance().createDynamicView(build, new DynamicViewBackListener() { // from class: com.mbridge.msdk.splash.c.a.2
                        {
                            NativeViewRenderManager.this = this;
                        }

                        public final void viewClicked(BaseRespData baseRespData) {
                            final int i;
                            MBSplashView mBSplashView2 = mBSplashView;
                            final SplashBridgeListener m21036a = (mBSplashView2 == null || mBSplashView2.getSplashJSBridgeImpl() == null) ? null : mBSplashView.getSplashJSBridgeImpl().m21036a();
                            DyOption dyOption = build;
                            CampaignEx campaignEx = dyOption != null ? dyOption.getCampaignEx() : null;
                            EAction eAction = baseRespData instanceof SplashResData ? ((SplashResData) baseRespData).geteAction() : null;
                            if (eAction != null) {
                                switch (C115735.f31767a[eAction.ordinal()]) {
                                    case 1:
                                        a baseViewData = ((SplashResData) baseRespData).getBaseViewData();
                                        if (baseRespData != null) {
                                            NativeViewRenderManager.m21239a(NativeViewRenderManager.this, baseViewData, m21036a, campaignEx);
                                            return;
                                        }
                                        return;
                                    case 2:
                                        if (m21036a != null) {
                                            m21036a.mo21120a();
                                            return;
                                        }
                                        return;
                                    case 3:
                                        if (build != null) {
                                            CommonClickUtil.m23069b(MBSDKContext.m22865f().m22861j(), build.getAdChoiceLink());
                                            return;
                                        }
                                        return;
                                    case 4:
                                        if (baseRespData == null || !(baseRespData instanceof SplashResData)) {
                                            return;
                                        }
                                        a baseViewData2 = ((SplashResData) baseRespData).getBaseViewData();
                                        final NativeViewRenderManager nativeViewRenderManager = NativeViewRenderManager.this;
                                        if (campaignEx != null) {
                                            String campaignUnitId = campaignEx.getCampaignUnitId();
                                            String requestId = campaignEx.getRequestId();
                                            final int currentCountDown = baseViewData2 != null ? baseViewData2.getEffectData().getCurrentCountDown() : 0;
                                            m21036a.mo21118a(1, currentCountDown);
                                            FeedbackManager m22907a = FeedbackManager.m22907a();
                                            FeedBackBtnBean m22904a = m22907a.m22904a(campaignUnitId + "_" + requestId);
                                            if (m22904a != null) {
                                                m22904a.m22928a(campaignEx);
                                                FeedbackManager m22907a2 = FeedbackManager.m22907a();
                                                m22907a2.m22897a(campaignUnitId + "_" + requestId, new FeedbackDialogEventListener() { // from class: com.mbridge.msdk.splash.c.a.4
                                                    @Override // com.mbridge.msdk.foundation.p470b.FeedbackDialogEventListener
                                                    /* renamed from: a */
                                                    public final void mo20986a() {
                                                    }

                                                    @Override // com.mbridge.msdk.foundation.p470b.FeedbackDialogEventListener
                                                    /* renamed from: a */
                                                    public final void mo20985a(String str) {
                                                        m21036a.mo21118a(2, currentCountDown);
                                                    }

                                                    @Override // com.mbridge.msdk.foundation.p470b.FeedbackDialogEventListener
                                                    /* renamed from: b */
                                                    public final void mo20984b() {
                                                        m21036a.mo21118a(2, currentCountDown);
                                                    }
                                                });
                                                m22904a.m22935a();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 5:
                                        if (campaignEx == null || campaignEx.getApkDisplayInfo() == null) {
                                            return;
                                        }
                                        String priUrl = campaignEx.getApkDisplayInfo().getPriUrl();
                                        if (TextUtils.isEmpty(priUrl)) {
                                            return;
                                        }
                                        CommonClickUtil.m23069b(MBSDKContext.m22865f().m22861j(), priUrl);
                                        return;
                                    case 6:
                                        if (baseRespData == null || !(baseRespData instanceof SplashResData)) {
                                            return;
                                        }
                                        final a baseViewData3 = ((SplashResData) baseRespData).getBaseViewData();
                                        final NativeViewRenderManager nativeViewRenderManager2 = NativeViewRenderManager.this;
                                        Context context2 = mBSplashView.getContext();
                                        if (m21036a != null) {
                                            if (baseViewData3 == null || baseViewData3.getEffectData() == null) {
                                                i = 0;
                                            } else {
                                                int currentCountDown2 = baseViewData3.getEffectData().getCurrentCountDown();
                                                m21036a.mo21118a(1, currentCountDown2);
                                                i = currentCountDown2;
                                            }
                                            if (context2 != null) {
                                                final CampaignEx campaignEx2 = campaignEx;
                                                SecondaryConfirmationManager.m21474a().m21455a("", campaignEx, context2, campaignEx.getCampaignUnitId(), new MBAlertDialogListener() { // from class: com.mbridge.msdk.splash.c.a.3
                                                    @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                                                    /* renamed from: a */
                                                    public final void mo20509a() {
                                                        NativeViewRenderManager.m21239a(nativeViewRenderManager2, baseViewData3, m21036a, campaignEx2);
                                                    }

                                                    @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                                                    /* renamed from: b */
                                                    public final void mo20508b() {
                                                        m21036a.mo21118a(2, i);
                                                    }

                                                    @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                                                    /* renamed from: c */
                                                    public final void mo20507c() {
                                                        mo20509a();
                                                    }
                                                });
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }

                        public final void viewCreateFail(com.mbridge.msdk.dycreator.b.a aVar) {
                            try {
                                if (build != null) {
                                    C11385e.m22076a(MBSDKContext.m22865f().m22861j(), build.getDyAdType() + "", build.getTemplateType(), "create dynamic view fail " + aVar.toString(), CommonNetImpl.FAIL, build.getCampaignEx());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MBSplashView mBSplashView2 = mBSplashView;
                            if (mBSplashView2 != null) {
                                Context context2 = mBSplashView2.getContext();
                                if (context2 == null) {
                                    context2 = MBSDKContext.m22865f().m22861j();
                                }
                                NativeViewRenderManager.this.m21241a(context2, mBSplashView, viewRenderParam, nativeViewRenderStatusListener);
                            }
                        }

                        public final void viewCreatedSuccess(View view) {
                            NativeViewRenderStatusListener nativeViewRenderStatusListener2 = nativeViewRenderStatusListener;
                            if (nativeViewRenderStatusListener2 != null) {
                                if (view != null) {
                                    nativeViewRenderStatusListener2.mo21182a(view);
                                } else {
                                    nativeViewRenderStatusListener2.mo21181a("View render error.");
                                }
                            }
                        }
                    });
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            m21241a(context, mBSplashView, viewRenderParam, nativeViewRenderStatusListener);
            return;
        }
        m21241a(context, mBSplashView, viewRenderParam, nativeViewRenderStatusListener);
    }

    /* renamed from: a */
    public void m21241a(Context context, MBSplashView mBSplashView, ViewRenderParam viewRenderParam, NativeViewRenderStatusListener nativeViewRenderStatusListener) {
        try {
            MBSplashNativeView mBSplashNativeView = new MBSplashNativeView(context, mBSplashView, viewRenderParam);
            if (nativeViewRenderStatusListener != null) {
                nativeViewRenderStatusListener.mo21182a(mBSplashNativeView);
            }
        } catch (Throwable unused) {
            if (nativeViewRenderStatusListener != null) {
                nativeViewRenderStatusListener.mo21181a("View render error.");
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m21239a(NativeViewRenderManager nativeViewRenderManager, a aVar, SplashBridgeListener splashBridgeListener, CampaignEx campaignEx) {
        int i;
        float f;
        float f2 = 0.0f;
        if (aVar == null || !(aVar instanceof MBSplashData)) {
            i = 0;
            f = 0.0f;
        } else {
            MBSplashData mBSplashData = (MBSplashData) aVar;
            f2 = mBSplashData.getxInScreen();
            f = mBSplashData.getyInScreen();
            i = mBSplashData.getClickType();
        }
        if (splashBridgeListener != null) {
            try {
                splashBridgeListener.mo21117a(SplashUtils.m21294a(SplashUtils.m21296a(i, f2, f), campaignEx));
            } catch (Throwable th) {
                th.printStackTrace();
                splashBridgeListener.mo21117a(campaignEx);
            }
        }
    }
}
