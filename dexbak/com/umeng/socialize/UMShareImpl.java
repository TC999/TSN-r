package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.p570b.SocialRouter;
import com.umeng.socialize.uploadlog.UMLog;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeSpUtils;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.umeng.socialize.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMShareImpl extends UMShareAPI {

    /* renamed from: a */
    private final SocialRouter f39270a;

    /* compiled from: UMShareImpl.java */
    /* renamed from: com.umeng.socialize.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13307a extends QueuedWork.UMAsyncTask<Void> {

        /* renamed from: a */
        private final Context f39287a;

        /* renamed from: b */
        private final boolean f39288b;

        /* renamed from: c */
        private final boolean f39289c = SocializeUtils.isHasDplusCache();

        public C13307a(Context context) {
            this.f39287a = context;
            this.f39288b = SocializeUtils.isToday(SocializeSpUtils.getTime(context));
        }

        /* renamed from: b */
        private boolean m13434b() {
            return this.f39287a.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).getBoolean("newinstall", false);
        }

        /* renamed from: c */
        private void m13433c() {
            SharedPreferences.Editor edit = this.f39287a.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit();
            edit.putBoolean("newinstall", true);
            edit.commit();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
        /* renamed from: a */
        public Void doInBackground() {
            boolean m13434b = m13434b();
            SLog.m13211E(UmengText.CHECK.SDKVERSION + "7.3.2");
            if (!this.f39288b) {
                SocializeSpUtils.putTime(this.f39287a);
                DplusApi.uploadDAU(ContextUtil.getContext());
                SocialAnalytics.dauStats(this.f39287a, true);
            } else if (this.f39289c) {
                DplusApi.uploadDAU(ContextUtil.getContext());
                SocialAnalytics.dauStats(this.f39287a, true);
            }
            SocialAnalytics.verifyStats(this.f39287a);
            if (m13434b) {
                Context context = this.f39287a;
                UMWorkDispatch.sendEvent(context, SocializeConstants.AZX_TRIGGER, CommonNetImpl.get(context), null, 10000L);
                return null;
            }
            m13433c();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UMShareImpl(Context context) {
        ContextUtil.setContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f39270a = new SocialRouter(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        String currentProcessName = UMFrUtils.getCurrentProcessName(context);
        if (TextUtils.isEmpty(currentProcessName) || !currentProcessName.equals(ContextUtil.getPackageName())) {
            return;
        }
        new C13307a(StubApp.getOrigApplicationContext(context.getApplicationContext())).execute();
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void deleteOauth(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (activity != null) {
            new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.2
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                protected Object doInBackground() {
                    UMShareImpl.this.f39270a.m13348a(activity, share_media, uMAuthListener);
                    return null;
                }
            }.execute();
        } else {
            SLog.m13211E(UmengText.CHECK.ACTIVITYNULL);
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void doOauthVerify(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        UMLog.putAuth();
        if (!UMConfigure.getInitStatus()) {
            SLog.selfLog(UmengText.CHECK.NOINT);
        } else if (!SLog.isDebug() || m13439a(activity, share_media)) {
            if (activity != null) {
                new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                    /* renamed from: a */
                    public Void doInBackground() {
                        UMShareImpl.this.f39270a.m13327c(activity, share_media, uMAuthListener);
                        return null;
                    }
                }.execute();
            } else {
                SLog.m13211E(UmengText.CHECK.ACTIVITYNULL);
            }
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void doShare(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        UMLog.putShare();
        if (!UMConfigure.getInitStatus()) {
            SLog.selfLog(UmengText.CHECK.NOINT);
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        if (SLog.isDebug()) {
            if (!m13439a(activity, shareAction.getPlatform())) {
                return;
            }
            UrlUtil.sharePrint(shareAction.getPlatform());
        }
        if (weakReference.get() != null && !((Activity) weakReference.get()).isFinishing()) {
            new QueuedWork.DialogThread<Void>((Context) weakReference.get()) { // from class: com.umeng.socialize.a.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                /* renamed from: a */
                public Void doInBackground() {
                    if (weakReference.get() != null && !((Activity) weakReference.get()).isFinishing()) {
                        UMShareImpl.this.f39270a.m13350a((Activity) weakReference.get(), shareAction, uMShareListener);
                        Context context = ContextUtil.getContext();
                        if (context != null) {
                            UMWorkDispatch.sendEvent(context, SocializeConstants.AZX_TRIGGER, CommonNetImpl.get(context), null, 5000L);
                        }
                    }
                    return null;
                }
            }.execute();
        } else {
            SLog.m13211E(UmengText.CHECK.ACTIVITYNULL);
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        this.f39270a.m13351a(activity, bundle, uMAuthListener);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        SocialRouter socialRouter = this.f39270a;
        if (socialRouter != null) {
            return socialRouter.m13341a(share_media);
        }
        return null;
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void getPlatformInfo(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (activity != null) {
            if (!UMConfigure.getInitStatus()) {
                SLog.selfLog(UmengText.CHECK.NOINT);
                return;
            }
            UMLog.putAuth();
            if (SLog.isDebug()) {
                if (!m13439a(activity, share_media)) {
                    return;
                }
                UrlUtil.getInfoPrint(share_media);
            }
            new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.3
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                protected Object doInBackground() {
                    UMShareImpl.this.f39270a.m13333b(activity, share_media, uMAuthListener);
                    Context context = ContextUtil.getContext();
                    if (context != null) {
                        UMWorkDispatch.sendEvent(context, SocializeConstants.AZX_TRIGGER, CommonNetImpl.get(context), null, 5000L);
                        return null;
                    }
                    return null;
                }
            }.execute();
            return;
        }
        SLog.m13211E(UmengText.CHECK.ACTIVITYNULL);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return this.f39270a.m13328c(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return this.f39270a.m13324d(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return this.f39270a.m13349a(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return this.f39270a.m13334b(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onActivityResult(int i, int i2, Intent intent) {
        SocialRouter socialRouter = this.f39270a;
        if (socialRouter != null) {
            socialRouter.m13356a(i, i2, intent);
        } else {
            SLog.m13211E(UmengText.CHECK.ROUTERNULL);
        }
        SLog.m13210I(UmengText.CHECK.getActivityResult(i, i2));
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onSaveInstanceState(Bundle bundle) {
        this.f39270a.m13346a(bundle);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void release() {
        this.f39270a.m13358a();
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void setShareConfig(UMShareConfig uMShareConfig) {
        this.f39270a.m13344a(uMShareConfig);
    }

    /* renamed from: a */
    private boolean m13439a(Activity activity, SHARE_MEDIA share_media) {
        boolean z = false;
        for (Method method : activity.getClass().getDeclaredMethods()) {
            if (method.getName().equals("onActivityResult")) {
                z = true;
            }
        }
        if (!z) {
            SLog.mutlE(UmengText.CHECK.ALL_NO_ONACTIVITY, UrlUtil.ALL_NO_ONACTIVITY);
        }
        if (share_media == SHARE_MEDIA.QQ) {
            SLog.m13211E(UmengTool.checkQQByself(activity));
            return true;
        } else if (share_media == SHARE_MEDIA.WEIXIN) {
            SLog.m13211E(UmengTool.checkWxBySelf(activity));
            return true;
        } else if (share_media == SHARE_MEDIA.SINA) {
            SLog.m13211E(UmengTool.checkSinaBySelf(activity));
            return true;
        } else if (share_media == SHARE_MEDIA.FACEBOOK) {
            SLog.m13211E(UmengTool.checkFBByself(activity));
            return true;
        } else {
            if (share_media == SHARE_MEDIA.VKONTAKTE) {
                SLog.m13211E(UmengTool.checkVKByself(activity));
            }
            if (share_media == SHARE_MEDIA.LINKEDIN) {
                SLog.m13211E(UmengTool.checkLinkin(activity));
            }
            if (share_media == SHARE_MEDIA.KAKAO) {
                SLog.m13211E(UmengTool.checkKakao(activity));
            }
            return true;
        }
    }
}
