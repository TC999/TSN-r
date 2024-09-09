package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class NubiaImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64741a;

    public NubiaImpl(Context context) {
        this.f64741a = context;
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64741a == null || iGetter == null) {
            return;
        }
        if (!supported()) {
            OAIDLog.print("Only supports Android 10.0 and above for Nubia");
            iGetter.onOAIDGetError(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f64741a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                throw new OAIDException("OAID query failed: bundle is null");
            }
            String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException("OAID query failed: " + call.getString("message"));
            }
            OAIDLog.print("OAID query success: " + string);
            iGetter.onOAIDGetComplete(string);
        } catch (Exception e4) {
            OAIDLog.print(e4);
            iGetter.onOAIDGetError(e4);
        }
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean supported() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
