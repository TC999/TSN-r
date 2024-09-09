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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMShareAPI {

    /* renamed from: a  reason: collision with root package name */
    private static UMShareAPI f53856a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f53857b = true;
    public boolean isZyb = true;

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static UMShareAPI get(Context context) {
        if (a(context) && !CommonUtil.isSilentMode(context)) {
            if (f53856a == null) {
                f53856a = new a(context);
                SLog.welcome();
            }
            return f53856a;
        }
        b bVar = new b(context);
        f53856a = bVar;
        return bVar;
    }

    public static String getSdkVersion() {
        return "7.3.2";
    }

    public static boolean getSmartEnableFlag() {
        return f53857b;
    }

    public static void init(Context context, String str) {
        if (a(context)) {
            SocializeConstants.APPKEY = str;
            get(context);
            UMWorkDispatch.sendEvent(context, 24592, CommonNetImpl.get(context), null);
        }
    }

    public static void setSmartEnable(boolean z3) {
        f53857b = z3;
    }

    public void deleteOauth(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f53856a.deleteOauth(activity, share_media, uMAuthListener);
    }

    @Deprecated
    public void doOauthVerify(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f53856a.doOauthVerify(activity, share_media, uMAuthListener);
    }

    public void doShare(Activity activity, ShareAction shareAction, UMShareListener uMShareListener) {
        f53856a.doShare(activity, shareAction, uMShareListener);
    }

    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        f53856a.fetchAuthResultWithBundle(activity, bundle, uMAuthListener);
    }

    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        return f53856a.getHandler(share_media);
    }

    public void getPlatformInfo(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f53856a.getPlatformInfo(activity, share_media, uMAuthListener);
    }

    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return f53856a.getversion(activity, share_media);
    }

    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return f53856a.isAuthorize(activity, share_media);
    }

    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return f53856a.isInstall(activity, share_media);
    }

    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return f53856a.isSupport(activity, share_media);
    }

    public void onActivityResult(int i4, int i5, Intent intent) {
        f53856a.onActivityResult(i4, i5, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        f53856a.onSaveInstanceState(bundle);
    }

    public void release() {
        f53856a.release();
    }

    public void setShareConfig(UMShareConfig uMShareConfig) {
        f53856a.setShareConfig(uMShareConfig);
    }

    private static boolean a() {
        try {
            Class<?> a4 = a("com.umeng.commonsdk.framework.UMEnvelopeBuild");
            if (a4 != null) {
                return a4.getDeclaredMethod("buildEnvelopeWithExtHeader", Context.class, JSONObject.class, JSONObject.class, String.class, String.class, String.class) != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(final Context context) {
        if (a()) {
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
        SLog.E(UmengText.CHECK.DEPENDENT_COMMON_NOT_MATCH);
        return false;
    }
}
