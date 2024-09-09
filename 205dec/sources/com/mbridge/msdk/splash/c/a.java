package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.i;
import com.mbridge.msdk.splash.view.MBSplashNativeView;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.io.File;

/* compiled from: NativeViewRenderManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* compiled from: NativeViewRenderManager.java */
    /* renamed from: com.mbridge.msdk.splash.c.a$5 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a */
        static final /* synthetic */ int[] f40539a;

        static {
            int[] iArr = new int[EAction.values().length];
            f40539a = iArr;
            try {
                iArr[EAction.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40539a[EAction.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40539a[EAction.NOTICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40539a[EAction.FEEDBACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40539a[EAction.PRIVATE_ADDRESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40539a[EAction.PERMISSION_INFO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: NativeViewRenderManager.java */
    /* renamed from: com.mbridge.msdk.splash.c.a$a */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0762a {

        /* renamed from: a */
        private static final a f40540a = new a();

        public static /* synthetic */ a a() {
            return f40540a;
        }
    }

    private a() {
    }

    public final void a(final MBSplashView mBSplashView, final com.mbridge.msdk.splash.a.c cVar, final com.mbridge.msdk.splash.b.a aVar) {
        Context context = mBSplashView.getContext();
        if (context == null) {
            context = com.mbridge.msdk.foundation.controller.a.f().j();
        }
        if (cVar == null && aVar != null) {
            aVar.a("The render parameters is unavailable.");
            return;
        }
        String a4 = (cVar == null || cVar.c() == null) ? "" : i.a(cVar.c().getAdZip());
        if (!TextUtils.isEmpty(a4)) {
            if (cVar == null || cVar.c() == null) {
                return;
            }
            if (!TextUtils.isEmpty(cVar.c().getAdZip())) {
                try {
                    final DyOption build = new DyOption.Builder().campaignEx(cVar.c()).file((File) null).fileDir(a4).dyAdType(DyAdType.SPLASH).canSkip(cVar.d()).isScreenClick(cVar.g() == 1).isClickButtonVisible(cVar.f() == 0).isShakeVisible(cVar.i() == 1).isApkInfoVisible(cVar.h() == 0).isLogoVisible(cVar.m() == 1).shakeStrenght(cVar.j()).shakeTime(cVar.k()).orientation(cVar.l()).countDownTime(cVar.e()).adChoiceLink(com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k()).az()).build();
                    mBSplashView.setDyCountDownListener(new DyCountDownListener() { // from class: com.mbridge.msdk.splash.c.a.1
                        {
                            a.this = this;
                        }

                        public final void getCountDownValue(int i4) {
                            build.setDyCountDownListener(i4);
                        }
                    });
                    DynamicViewCreator.getInstance().createDynamicView(build, new DynamicViewBackListener() { // from class: com.mbridge.msdk.splash.c.a.2
                        {
                            a.this = this;
                        }

                        public final void viewClicked(BaseRespData baseRespData) {
                            final int i4;
                            MBSplashView mBSplashView2 = mBSplashView;
                            final com.mbridge.msdk.splash.d.a a5 = (mBSplashView2 == null || mBSplashView2.getSplashJSBridgeImpl() == null) ? null : mBSplashView.getSplashJSBridgeImpl().a();
                            DyOption dyOption = build;
                            CampaignEx campaignEx = dyOption != null ? dyOption.getCampaignEx() : null;
                            EAction eAction = baseRespData instanceof SplashResData ? ((SplashResData) baseRespData).geteAction() : null;
                            if (eAction != null) {
                                switch (AnonymousClass5.f40539a[eAction.ordinal()]) {
                                    case 1:
                                        com.mbridge.msdk.dycreator.f.a.a baseViewData = ((SplashResData) baseRespData).getBaseViewData();
                                        if (baseRespData != null) {
                                            a.a(a.this, baseViewData, a5, campaignEx);
                                            return;
                                        }
                                        return;
                                    case 2:
                                        if (a5 != null) {
                                            a5.a();
                                            return;
                                        }
                                        return;
                                    case 3:
                                        if (build != null) {
                                            com.mbridge.msdk.click.c.b(com.mbridge.msdk.foundation.controller.a.f().j(), build.getAdChoiceLink());
                                            return;
                                        }
                                        return;
                                    case 4:
                                        if (baseRespData == null || !(baseRespData instanceof SplashResData)) {
                                            return;
                                        }
                                        com.mbridge.msdk.dycreator.f.a.a baseViewData2 = ((SplashResData) baseRespData).getBaseViewData();
                                        final a aVar2 = a.this;
                                        if (campaignEx != null) {
                                            String campaignUnitId = campaignEx.getCampaignUnitId();
                                            String requestId = campaignEx.getRequestId();
                                            final int currentCountDown = baseViewData2 != null ? baseViewData2.getEffectData().getCurrentCountDown() : 0;
                                            a5.a(1, currentCountDown);
                                            com.mbridge.msdk.foundation.b.b a6 = com.mbridge.msdk.foundation.b.b.a();
                                            com.mbridge.msdk.foundation.b.a.a a7 = a6.a(campaignUnitId + "_" + requestId);
                                            if (a7 != null) {
                                                a7.a(campaignEx);
                                                com.mbridge.msdk.foundation.b.b a8 = com.mbridge.msdk.foundation.b.b.a();
                                                a8.a(campaignUnitId + "_" + requestId, new com.mbridge.msdk.foundation.b.a() { // from class: com.mbridge.msdk.splash.c.a.4
                                                    @Override // com.mbridge.msdk.foundation.b.a
                                                    public final void a() {
                                                    }

                                                    @Override // com.mbridge.msdk.foundation.b.a
                                                    public final void a(String str) {
                                                        a5.a(2, currentCountDown);
                                                    }

                                                    @Override // com.mbridge.msdk.foundation.b.a
                                                    public final void b() {
                                                        a5.a(2, currentCountDown);
                                                    }
                                                });
                                                a7.a();
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
                                        com.mbridge.msdk.click.c.b(com.mbridge.msdk.foundation.controller.a.f().j(), priUrl);
                                        return;
                                    case 6:
                                        if (baseRespData == null || !(baseRespData instanceof SplashResData)) {
                                            return;
                                        }
                                        final com.mbridge.msdk.dycreator.f.a.a baseViewData3 = ((SplashResData) baseRespData).getBaseViewData();
                                        final a aVar3 = a.this;
                                        Context context2 = mBSplashView.getContext();
                                        if (a5 != null) {
                                            if (baseViewData3 == null || baseViewData3.getEffectData() == null) {
                                                i4 = 0;
                                            } else {
                                                int currentCountDown2 = baseViewData3.getEffectData().getCurrentCountDown();
                                                a5.a(1, currentCountDown2);
                                                i4 = currentCountDown2;
                                            }
                                            if (context2 != null) {
                                                final CampaignEx campaignEx2 = campaignEx;
                                                com.mbridge.msdk.mbjscommon.confirmation.e.a().a("", campaignEx, context2, campaignEx.getCampaignUnitId(), new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.splash.c.a.3
                                                    @Override // com.mbridge.msdk.widget.dialog.a
                                                    public final void a() {
                                                        a.a(aVar3, baseViewData3, a5, campaignEx2);
                                                    }

                                                    @Override // com.mbridge.msdk.widget.dialog.a
                                                    public final void b() {
                                                        a5.a(2, i4);
                                                    }

                                                    @Override // com.mbridge.msdk.widget.dialog.a
                                                    public final void c() {
                                                        a();
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

                        public final void viewCreateFail(com.mbridge.msdk.dycreator.b.a aVar2) {
                            try {
                                if (build != null) {
                                    com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.a.f().j(), build.getDyAdType() + "", build.getTemplateType(), "create dynamic view fail " + aVar2.toString(), "fail", build.getCampaignEx());
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            MBSplashView mBSplashView2 = mBSplashView;
                            if (mBSplashView2 != null) {
                                Context context2 = mBSplashView2.getContext();
                                if (context2 == null) {
                                    context2 = com.mbridge.msdk.foundation.controller.a.f().j();
                                }
                                a.this.a(context2, mBSplashView, cVar, aVar);
                            }
                        }

                        public final void viewCreatedSuccess(View view) {
                            com.mbridge.msdk.splash.b.a aVar2 = aVar;
                            if (aVar2 != null) {
                                if (view != null) {
                                    aVar2.a(view);
                                } else {
                                    aVar2.a("View render error.");
                                }
                            }
                        }
                    });
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            a(context, mBSplashView, cVar, aVar);
            return;
        }
        a(context, mBSplashView, cVar, aVar);
    }

    public void a(Context context, MBSplashView mBSplashView, com.mbridge.msdk.splash.a.c cVar, com.mbridge.msdk.splash.b.a aVar) {
        try {
            MBSplashNativeView mBSplashNativeView = new MBSplashNativeView(context, mBSplashView, cVar);
            if (aVar != null) {
                aVar.a(mBSplashNativeView);
            }
        } catch (Throwable unused) {
            if (aVar != null) {
                aVar.a("View render error.");
            }
        }
    }

    static /* synthetic */ void a(a aVar, com.mbridge.msdk.dycreator.f.a.a aVar2, com.mbridge.msdk.splash.d.a aVar3, CampaignEx campaignEx) {
        int i4;
        float f4;
        float f5 = 0.0f;
        if (aVar2 == null || !(aVar2 instanceof MBSplashData)) {
            i4 = 0;
            f4 = 0.0f;
        } else {
            MBSplashData mBSplashData = (MBSplashData) aVar2;
            f5 = mBSplashData.getxInScreen();
            f4 = mBSplashData.getyInScreen();
            i4 = mBSplashData.getClickType();
        }
        if (aVar3 != null) {
            try {
                aVar3.a(com.mbridge.msdk.splash.a.a.a.a(com.mbridge.msdk.splash.a.a.a.a(i4, f5, f4), campaignEx));
            } catch (Throwable th) {
                th.printStackTrace();
                aVar3.a(campaignEx);
            }
        }
    }
}
