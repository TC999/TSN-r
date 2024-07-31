package com.umeng.socialize.uploadlog;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.umeng.socialize.Config;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.utils.ContextUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMLog {
    private static boolean isAuth;
    private static boolean isShare;

    public static Bundle getShareAndAuth() {
        Bundle bundle = new Bundle();
        if (ContextUtil.getContext() != null) {
            SharedPreferences sharedPreferences = ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0);
            bundle.putBoolean("share", sharedPreferences.getBoolean("share", false));
            bundle.putBoolean("auth", sharedPreferences.getBoolean("auth", false));
            bundle.putBoolean("isjump", sharedPreferences.getBoolean("isjump", false));
        } else {
            bundle.putBoolean("share", false);
            bundle.putBoolean("auth", false);
            bundle.putBoolean("isjump", false);
        }
        return bundle;
    }

    public static boolean isOpenShareEdit() {
        if (ContextUtil.getContext() != null) {
            return ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).getBoolean(SocializeConstants.SP_KEY_IS_OPEN_SHARE_EDIT, true);
        }
        return true;
    }

    public static void putAuth() {
        if (ContextUtil.getContext() == null || isAuth) {
            return;
        }
        SharedPreferences.Editor edit = ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit();
        edit.putBoolean("auth", true);
        edit.putBoolean("isjump", Config.isJumptoAppStore);
        edit.commit();
        isShare = true;
    }

    public static void putShare() {
        if (ContextUtil.getContext() == null || isShare) {
            return;
        }
        SharedPreferences.Editor edit = ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit();
        edit.putBoolean("share", true);
        edit.putBoolean("isjump", Config.isJumptoAppStore);
        edit.commit();
        isShare = true;
    }

    public static void setIsOpenShareEdit(boolean z) {
        if (ContextUtil.getContext() != null) {
            ContextUtil.getContext().getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit().putBoolean(SocializeConstants.SP_KEY_IS_OPEN_SHARE_EDIT, z).apply();
        }
    }
}
