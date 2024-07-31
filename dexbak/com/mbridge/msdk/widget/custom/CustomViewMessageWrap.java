package com.mbridge.msdk.widget.custom;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.clj.fastble.BleManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.out.ApkDisplayInfo;
import com.mbridge.msdk.system.NoProGuard;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.bugly.BUGLY;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CustomViewMessageWrap implements NoProGuard {
    private ApkDisplayInfo apkDisplayInfo;
    private CampaignEx campaignEx;
    private String layoutFilePath;
    private Map<String, View> views;

    public CustomViewMessageWrap() {
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void copyAssetsDir2Phone(android.content.Context r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.widget.custom.CustomViewMessageWrap.copyAssetsDir2Phone(android.content.Context, java.lang.String):void");
    }

    public static final void copyViewFile(Context context, String str) {
        copyAssetsDir2Phone(context, str);
    }

    public static final String getMessage(CustomViewMessageWrap customViewMessageWrap, String str) {
        if (TextUtils.isEmpty(str) && customViewMessageWrap == null) {
            return null;
        }
        try {
            Method method = customViewMessageWrap.getClass().getMethod(str, new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(customViewMessageWrap, new Object[0]);
            return invoke != null ? String.valueOf(invoke) : "";
        } catch (IllegalAccessException e) {
            SameLogTool.m21733d("CustomViewMessageWrap", e.getMessage());
            return "";
        } catch (NoSuchMethodException e2) {
            SameLogTool.m21733d("CustomViewMessageWrap", e2.getMessage());
            return "";
        } catch (InvocationTargetException e3) {
            SameLogTool.m21733d("CustomViewMessageWrap", e3.getMessage());
            return "";
        }
    }

    public static final String getViewFilePath(String str) {
        if (TextUtils.equals(str, "mbridge_download_dialog_view")) {
            return MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_OTHER) + "/" + str + ".xml";
        }
        return "";
    }

    public boolean checkIsNull(Object obj) {
        return obj == null;
    }

    public String getApplicationContext() {
        return checkIsNull(this.campaignEx) ? "" : this.campaignEx.getAppDesc();
    }

    public String getApplicationDeveloper() {
        return checkIsNull(this.apkDisplayInfo) ? "" : this.apkDisplayInfo.getDevName();
    }

    public String getApplicationImage() {
        return checkIsNull(this.campaignEx) ? "" : this.campaignEx.getImageUrl();
    }

    public String getApplicationLogo() {
        return checkIsNull(this.campaignEx) ? "" : this.campaignEx.getIconUrl();
    }

    public String getApplicationName() {
        return checkIsNull(this.apkDisplayInfo) ? "" : this.apkDisplayInfo.getAppName();
    }

    public String getApplicationNameFromCampaign() {
        return checkIsNull(this.campaignEx) ? "" : this.campaignEx.getAppName();
    }

    public String getApplicationPermissions() {
        if (checkIsNull(this.apkDisplayInfo)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> permDescAllList = this.apkDisplayInfo.getPermDescAllList();
        if (permDescAllList != null && permDescAllList.size() > 0) {
            for (int i = 0; i < permDescAllList.size(); i++) {
                String str = permDescAllList.get(i);
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    if (i < permDescAllList.size() - 1) {
                        sb.append(ShellAdbUtils.f33810d);
                    }
                }
            }
        }
        return sb.toString();
    }

    public String getApplicationPrivacy() {
        return checkIsNull(this.apkDisplayInfo) ? "" : this.apkDisplayInfo.getPriUrl();
    }

    public String getApplicationScore() {
        return checkIsNull(this.campaignEx) ? String.format("已有 %s 人评分", String.valueOf(new Random().nextInt(BleManager.f22896l) + BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH)) : String.format("已有 %s 人评分", String.valueOf(this.campaignEx.getNumberRating()));
    }

    public String getApplicationUpdateTime() {
        return checkIsNull(this.apkDisplayInfo) ? "" : this.apkDisplayInfo.getUpdateTime();
    }

    public String getApplicationVersion() {
        return checkIsNull(this.apkDisplayInfo) ? "" : this.apkDisplayInfo.getAppVersion();
    }

    public CampaignEx getCampaignEx() {
        return this.campaignEx;
    }

    public String getLayoutFilePath() {
        return this.layoutFilePath;
    }

    public int getStarCount() {
        if (checkIsNull(this.campaignEx)) {
            return 5;
        }
        return (int) Math.ceil(this.campaignEx.getRating());
    }

    public View getView(String str) {
        Map<String, View> map = this.views;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void putView(String str, View view) {
        if (this.views == null) {
            this.views = new HashMap();
        }
        this.views.put(str, view);
    }

    public CustomViewMessageWrap(CampaignEx campaignEx, String str) {
        this.campaignEx = campaignEx;
        this.apkDisplayInfo = campaignEx == null ? null : campaignEx.getApkDisplayInfo();
        this.layoutFilePath = str;
    }
}
