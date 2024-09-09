package com.bytedance.sdk.openadsdk.core.p.xv.w;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.p.ev;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.sr;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv {
    public static AdDownloadModel.Builder c(String str, String str2, me meVar, JSONObject jSONObject) {
        if (meVar == null) {
            return new AdDownloadModel.Builder();
        }
        if (TextUtils.isEmpty(str)) {
            return new AdDownloadModel.Builder();
        }
        String vt = meVar.vt();
        if (TextUtils.isEmpty(vt) && meVar.zg() != null) {
            vt = meVar.zg().k();
        }
        return c(str2, meVar, jSONObject, str, "", vt);
    }

    public static void c(AdDownloadModel.Builder builder) {
    }

    public static AdDownloadModel.Builder c(String str, me meVar, JSONObject jSONObject) {
        String str2;
        String str3;
        String str4;
        if (meVar == null) {
            return new AdDownloadModel.Builder();
        }
        sr ix = meVar.ix();
        if (ix != null) {
            String w3 = ix.w();
            String xv = ix.xv();
            str4 = ix.sr();
            str2 = w3;
            str3 = xv;
        } else {
            str2 = "";
            str3 = str2;
            str4 = str3;
        }
        return c(str, meVar, jSONObject, str2, str3, str4);
    }

    private static AdDownloadModel.Builder c(String str, me meVar, JSONObject jSONObject, String str2, String str3, String str4) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("open_ad_sdk_download_extra", c.c().c(str).w(jSONObject).c(meVar).w());
        } catch (Exception unused) {
        }
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(Double.valueOf(meVar.jr()).longValue()).setAppIcon(meVar.kr() == null ? null : meVar.kr().c()).setIsShowNotification(k.sr().fp()).setAutoInstallWithoutNotification(!k.sr().fp()).setLogExtra(meVar.cf()).setExtra(jSONObject2).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.w.xv.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str5, String str6) {
                return com.bytedance.sdk.openadsdk.t.c.c(str5, str6);
            }
        });
        try {
            JSONObject c4 = ev.c();
            JSONObject jSONObject3 = new JSONObject();
            int i4 = 0;
            int optInt = c4.optInt("notification_opt_2", 0);
            if (optInt == 1) {
                i4 = optInt;
            }
            int ia = ia.ia(meVar);
            if (!eq.sr()) {
                jSONObject3.put("cancel_pause_optimise_switch", ia);
                jSONObject3.put("cancel_pause_optimise_wifi_retain_switch", ia);
                jSONObject3.put("cancel_pause_optimise_apk_retain_switch", ia);
                jSONObject3.put("cancel_pause_optimise_download_percent_retain_switch", ia);
            }
            jSONObject3.put("show_pause_continue_toast", ia);
            if (ia == 1) {
                fileUriProvider.setIsShowToast(true);
                jSONObject3.put("download_start_toast_text", c4.optString("download_start_toast_text", "\u5df2\u5f00\u59cb\u4e0b\u8f7d\uff0c\u518d\u6b21\u70b9\u51fb\u53ef\u6682\u505c\u6216\u53d6\u6d88\u8be5\u4e0b\u8f7d\u4efb\u52a1\u3002"));
            }
            jSONObject3.put("notification_opt_2", i4);
            fileUriProvider.setDownloadSettings(jSONObject3);
        } catch (JSONException unused2) {
        }
        c(fileUriProvider);
        if (!TextUtils.isEmpty(str2)) {
            fileUriProvider.setDownloadUrl(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setAppName(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setPackageName(str4);
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            fileUriProvider.setNeedIndependentProcess(true);
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux = k.sr().ux();
        if (ux != null && !ux.ux()) {
            try {
                fileUriProvider.setFilePath(c());
            } catch (Throwable unused3) {
            }
        }
        DeepLink deepLink = new DeepLink();
        if (meVar.qu() != null) {
            deepLink.setId(Long.valueOf(meVar.jr()).longValue());
            deepLink.setOpenUrl(meVar.qu().c());
            deepLink.setWebTitle(meVar.ny());
            if (meVar.qu().xv() == 2 && !me.w(meVar)) {
                deepLink.setWebUrl(null);
            } else if (meVar.qu().xv() == 1) {
                deepLink.setWebUrl(meVar.qu().w());
            } else {
                deepLink.setWebUrl(meVar.pu());
            }
        } else {
            deepLink.setWebUrl(meVar.pu());
        }
        fileUriProvider.setDeepLink(deepLink);
        return fileUriProvider;
    }

    public static AdDownloadController.Builder c(me meVar) {
        int w3 = ia.w(meVar);
        int xv = ia.xv(meVar);
        if (meVar != null && !TextUtils.isEmpty(meVar.ib())) {
            xv = 2;
        }
        AdDownloadController.Builder extraOperation = new AdDownloadController.Builder().setLinkMode(w3).setDownloadMode(xv).setIsEnableBackDialog(true).setIsAddToDownloadManage(false).setExtraOperation(meVar);
        if (meVar != null && meVar.d() != null) {
            extraOperation.setEnableAH(meVar.d().c());
            extraOperation.setEnableAM(meVar.d().w());
        }
        return extraOperation;
    }

    public static AdDownloadEventConfig.Builder c(String str) {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str).setClickStartLabel("click_start").setClickContinueLabel("click_continue").setClickPauseLabel("click_pause").setStorageDenyLabel("download_failed").setClickInstallLabel("click_install").setIsEnableClickEvent(true).setIsEnableV3Event(false);
    }

    public static DownloadEventConfig c(DownloadEventConfig downloadEventConfig, JSONObject jSONObject) {
        return (downloadEventConfig == null || jSONObject == null) ? downloadEventConfig : new AdDownloadEventConfig.Builder().setClickButtonTag(downloadEventConfig.getClickButtonTag()).setClickItemTag(downloadEventConfig.getClickItemTag()).setClickStartLabel(downloadEventConfig.getClickStartLabel()).setClickContinueLabel(downloadEventConfig.getClickContinueLabel()).setClickPauseLabel(downloadEventConfig.getClickPauseLabel()).setStorageDenyLabel(downloadEventConfig.getStorageDenyLabel()).setClickInstallLabel(downloadEventConfig.getClickInstallLabel()).setIsEnableClickEvent(downloadEventConfig.isEnableClickEvent()).setIsEnableV3Event(downloadEventConfig.isEnableV3Event()).setExtraEventObject(jSONObject).build();
    }

    public static String c() {
        File c4 = com.bytedance.sdk.openadsdk.api.plugin.w.c(ls.getContext(), Environment.DIRECTORY_DOWNLOADS);
        if (c4 != null) {
            if (!c4.exists()) {
                c4.mkdirs();
            }
            if (c4.exists()) {
                return c4.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static void c(Map<String, Object> map, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (eq.f33190w < 4400 || map == null || iDownloadButtonClickListener == null || map.get("downloadButtonClickListener") != null) {
            return;
        }
        map.put("downloadButtonClickListener", iDownloadButtonClickListener);
    }

    public static boolean c(Context context, String str, me meVar, String str2, boolean z3) {
        if (context == null) {
            return false;
        }
        try {
            wv.c(z3, false, meVar, str2);
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
