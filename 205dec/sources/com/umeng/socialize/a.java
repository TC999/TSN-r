package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.stub.StubApp;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
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
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMShareImpl.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends UMShareAPI {

    /* renamed from: a  reason: collision with root package name */
    private final com.umeng.socialize.b.a f53859a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMShareImpl.java */
    /* renamed from: com.umeng.socialize.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class C1067a extends QueuedWork.UMAsyncTask<Void> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f53882a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f53883b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f53884c = SocializeUtils.isHasDplusCache();

        public C1067a(Context context) {
            this.f53882a = context;
            this.f53883b = SocializeUtils.isToday(SocializeSpUtils.getTime(context));
        }

        private boolean b() {
            return this.f53882a.getSharedPreferences("umeng_socialize", 0).getBoolean("newinstall", false);
        }

        private void c() {
            SharedPreferences.Editor edit = this.f53882a.getSharedPreferences("umeng_socialize", 0).edit();
            edit.putBoolean("newinstall", true);
            edit.commit();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
        /* renamed from: a */
        public Void doInBackground() {
            boolean b4 = b();
            SLog.E(UmengText.CHECK.SDKVERSION + "7.3.2");
            if (!this.f53883b) {
                SocializeSpUtils.putTime(this.f53882a);
                DplusApi.uploadDAU(ContextUtil.getContext());
                SocialAnalytics.dauStats(this.f53882a, true);
            } else if (this.f53884c) {
                DplusApi.uploadDAU(ContextUtil.getContext());
                SocialAnalytics.dauStats(this.f53882a, true);
            }
            SocialAnalytics.verifyStats(this.f53882a);
            if (b4) {
                Context context = this.f53882a;
                UMWorkDispatch.sendEvent(context, 24594, CommonNetImpl.get(context), null, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                return null;
            }
            c();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        ContextUtil.setContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f53859a = new com.umeng.socialize.b.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        String currentProcessName = UMFrUtils.getCurrentProcessName(context);
        if (TextUtils.isEmpty(currentProcessName) || !currentProcessName.equals(ContextUtil.getPackageName())) {
            return;
        }
        new C1067a(StubApp.getOrigApplicationContext(context.getApplicationContext())).execute();
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void deleteOauth(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (activity != null) {
            new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.2
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                protected Object doInBackground() {
                    a.this.f53859a.a(activity, share_media, uMAuthListener);
                    return null;
                }
            }.execute();
        } else {
            SLog.E(UmengText.CHECK.ACTIVITYNULL);
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void doOauthVerify(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        UMLog.putAuth();
        if (!UMConfigure.getInitStatus()) {
            SLog.selfLog(UmengText.CHECK.NOINT);
        } else if (!SLog.isDebug() || a(activity, share_media)) {
            if (activity != null) {
                new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                    /* renamed from: a */
                    public Void doInBackground() {
                        a.this.f53859a.c(activity, share_media, uMAuthListener);
                        return null;
                    }
                }.execute();
            } else {
                SLog.E(UmengText.CHECK.ACTIVITYNULL);
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
            if (!a(activity, shareAction.getPlatform())) {
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
                        a.this.f53859a.a((Activity) weakReference.get(), shareAction, uMShareListener);
                        Context context = ContextUtil.getContext();
                        if (context != null) {
                            UMWorkDispatch.sendEvent(context, 24594, CommonNetImpl.get(context), null, 5000L);
                        }
                    }
                    return null;
                }
            }.execute();
        } else {
            SLog.E(UmengText.CHECK.ACTIVITYNULL);
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        this.f53859a.a(activity, bundle, uMAuthListener);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        com.umeng.socialize.b.a aVar = this.f53859a;
        if (aVar != null) {
            return aVar.a(share_media);
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
                if (!a(activity, share_media)) {
                    return;
                }
                UrlUtil.getInfoPrint(share_media);
            }
            new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.3
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                protected Object doInBackground() {
                    a.this.f53859a.b(activity, share_media, uMAuthListener);
                    Context context = ContextUtil.getContext();
                    if (context != null) {
                        UMWorkDispatch.sendEvent(context, 24594, CommonNetImpl.get(context), null, 5000L);
                        return null;
                    }
                    return null;
                }
            }.execute();
            return;
        }
        SLog.E(UmengText.CHECK.ACTIVITYNULL);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return this.f53859a.c(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return this.f53859a.d(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return this.f53859a.a(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return this.f53859a.b(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onActivityResult(int i4, int i5, Intent intent) {
        com.umeng.socialize.b.a aVar = this.f53859a;
        if (aVar != null) {
            aVar.a(i4, i5, intent);
        } else {
            SLog.E(UmengText.CHECK.ROUTERNULL);
        }
        SLog.I(UmengText.CHECK.getActivityResult(i4, i5));
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onSaveInstanceState(Bundle bundle) {
        this.f53859a.a(bundle);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void release() {
        this.f53859a.a();
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void setShareConfig(UMShareConfig uMShareConfig) {
        this.f53859a.a(uMShareConfig);
    }

    private boolean a(Activity activity, SHARE_MEDIA share_media) {
        boolean z3 = false;
        for (Method method : activity.getClass().getDeclaredMethods()) {
            if (method.getName().equals("onActivityResult")) {
                z3 = true;
            }
        }
        if (!z3) {
            SLog.mutlE(UmengText.CHECK.ALL_NO_ONACTIVITY, UrlUtil.ALL_NO_ONACTIVITY);
        }
        if (share_media == SHARE_MEDIA.QQ) {
            SLog.E(UmengTool.checkQQByself(activity));
            return true;
        } else if (share_media == SHARE_MEDIA.WEIXIN) {
            SLog.E(UmengTool.checkWxBySelf(activity));
            return true;
        } else if (share_media == SHARE_MEDIA.SINA) {
            SLog.E(UmengTool.checkSinaBySelf(activity));
            return true;
        } else if (share_media == SHARE_MEDIA.FACEBOOK) {
            SLog.E(UmengTool.checkFBByself(activity));
            return true;
        } else {
            if (share_media == SHARE_MEDIA.VKONTAKTE) {
                SLog.E(UmengTool.checkVKByself(activity));
            }
            if (share_media == SHARE_MEDIA.LINKEDIN) {
                SLog.E(UmengTool.checkLinkin(activity));
            }
            if (share_media == SHARE_MEDIA.KAKAO) {
                SLog.E(UmengTool.checkKakao(activity));
            }
            return true;
        }
    }
}
