package com.bytedance.sdk.openadsdk.core.p.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p.ev;
import com.bytedance.sdk.openadsdk.core.p.r;
import com.bytedance.sdk.openadsdk.core.p.sr;
import com.bytedance.sdk.openadsdk.core.p.ux;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements ITTDownloadVisitor {
    private c() {
    }

    public static ITTDownloadVisitor c() {
        return new c();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void checkAutoControl(JSONObject jSONObject, String str) {
        me meVar;
        JSONObject optJSONObject = jSONObject.optJSONObject("open_ad_sdk_download_extra");
        if (optJSONObject == null) {
            return;
        }
        if (!xk.c()) {
            Log.d("TTDownloadVisitor", "\u9501\u5c4f\u4e0d\u6267\u884c\u81ea\u542f\u52a8\u8c03\u8d77");
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.xv.w.c c4 = com.bytedance.sdk.openadsdk.core.p.xv.w.c.c(optJSONObject);
        if (c4 == null || (meVar = c4.f34380c) == null) {
            return;
        }
        ev.c(str, meVar);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void clearAllData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f.xv(new File(str));
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void execute(int i4, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        ux.c(i4, str, map, iTTHttpCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void executeLogUpload(TTDownloadEventModel tTDownloadEventModel, boolean z3) {
        if (c(tTDownloadEventModel)) {
            try {
                com.bytedance.sdk.component.gd.ev.c(sr.c.c(tTDownloadEventModel, z3), 5);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public boolean getAppIsBackground() {
        return k.sr().c();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public JSONObject getDownloadSettings() {
        return ev.c();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public TTDownloadEventLogger getTTDownloadEventLogger() {
        return k.sr().i();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public boolean hasPermission(Context context, String str) {
        return r.c(context, str);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public String initPath(boolean z3) {
        return ev.c(z3);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public boolean isOpenSdkEvent(String str) {
        return sr.c(str);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void postBody(String str, byte[] bArr, String str2, ITTHttpCallback iTTHttpCallback) {
        ux.c(str, bArr, str2, 0, iTTHttpCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void requestPermission(Activity activity, String[] strArr, ITTPermissionCallback iTTPermissionCallback) {
        r.c(activity, strArr, iTTPermissionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void showDialogByDelegate(WeakReference<Context> weakReference, boolean z3, DialogBuilder dialogBuilder) {
        com.bytedance.sdk.openadsdk.core.p.f.c(weakReference, z3, dialogBuilder);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public AlertDialog showDialogBySelf(Activity activity, boolean z3, DialogBuilder dialogBuilder) {
        return com.bytedance.sdk.openadsdk.core.p.f.c(activity, z3, dialogBuilder);
    }

    private boolean c(TTDownloadEventModel tTDownloadEventModel) {
        JSONObject extJson;
        if (tTDownloadEventModel == null || (extJson = tTDownloadEventModel.getExtJson()) == null) {
            return false;
        }
        String optString = extJson.optString("ad_extra_data");
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        try {
            return new JSONObject(optString).optJSONObject("open_ad_sdk_download_extra") != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
