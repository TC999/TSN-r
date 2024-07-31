package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMShareAPI {

    /* renamed from: a */
    private static UMShareAPI f39267a = null;

    /* renamed from: b */
    private static boolean f39268b = true;
    public boolean isZyb = true;

    /* renamed from: a */
    private static Class<?> m13440a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static UMShareAPI get(Context context) {
        if (m13441a(context) && !CommonUtil.isSilentMode(context)) {
            if (f39267a == null) {
                f39267a = new UMShareImpl(context);
                SLog.welcome();
            }
            return f39267a;
        }
        UMShareMock uMShareMock = new UMShareMock(context);
        f39267a = uMShareMock;
        return uMShareMock;
    }

    public static String getSdkVersion() {
        return "7.3.2";
    }

    public static boolean getSmartEnableFlag() {
        return f39268b;
    }

    public static void init(Context context, String str) {
        if (m13441a(context)) {
            SocializeConstants.APPKEY = str;
            get(context);
            UMWorkDispatch.sendEvent(context, SocializeConstants.REGIST_TO_WORK_QUEUE, CommonNetImpl.get(context), null);
        }
    }

    public static void setSmartEnable(boolean z) {
        f39268b = z;
    }

    public void deleteOauth(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f39267a.deleteOauth(activity, share_media, uMAuthListener);
    }

    @Deprecated
    public void doOauthVerify(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f39267a.doOauthVerify(activity, share_media, uMAuthListener);
    }

    public void doShare(Activity activity, ShareAction shareAction, UMShareListener uMShareListener) {
        f39267a.doShare(activity, shareAction, uMShareListener);
    }

    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        f39267a.fetchAuthResultWithBundle(activity, bundle, uMAuthListener);
    }

    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        return f39267a.getHandler(share_media);
    }

    public void getPlatformInfo(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f39267a.getPlatformInfo(activity, share_media, uMAuthListener);
    }

    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return f39267a.getversion(activity, share_media);
    }

    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return f39267a.isAuthorize(activity, share_media);
    }

    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return f39267a.isInstall(activity, share_media);
    }

    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return f39267a.isSupport(activity, share_media);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        f39267a.onActivityResult(i, i2, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        f39267a.onSaveInstanceState(bundle);
    }

    public void release() {
        f39267a.release();
    }

    public void setShareConfig(UMShareConfig uMShareConfig) {
        f39267a.setShareConfig(uMShareConfig);
    }

    /* renamed from: a */
    private static boolean m13442a() {
        try {
            Class<?> m13440a = m13440a("com.umeng.commonsdk.framework.UMEnvelopeBuild");
            if (m13440a != null) {
                return m13440a.getDeclaredMethod("buildEnvelopeWithExtHeader", Context.class, JSONObject.class, JSONObject.class, String.class, String.class, String.class) != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m13441a(final Context context) {
        if (m13442a()) {
            return true;
        }
        new Thread() { // from class: com.umeng.socialize.UMShareAPI.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Looper.prepare();
                    Toast.makeText(context.getApplicationContext(), UmengText.CHECK.DEPENDENT_COMMON_NOT_MATCH, 1).show();
                    Looper.loop();
                } catch (Throwable unused) {
                }
            }
        }.start();
        SLog.m13211E(UmengText.CHECK.DEPENDENT_COMMON_NOT_MATCH);
        return false;
    }
}
