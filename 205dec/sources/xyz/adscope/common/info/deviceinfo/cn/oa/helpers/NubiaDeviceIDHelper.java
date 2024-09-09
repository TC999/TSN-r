package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class NubiaDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64684a;

    public NubiaDeviceIDHelper(Context context) {
        this.f64684a = context;
    }

    public String getNubiaID() {
        Bundle call;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 > 17) {
                ContentProviderClient acquireContentProviderClient = this.f64684a.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (i4 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.f64684a.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
            call.getString("message");
            return null;
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return null;
        }
    }
}
