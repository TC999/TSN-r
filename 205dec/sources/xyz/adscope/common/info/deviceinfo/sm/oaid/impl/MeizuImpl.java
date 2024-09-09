package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class MeizuImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64738a;

    public MeizuImpl(Context context) {
        this.f64738a = context;
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64738a == null || iGetter == null) {
            return;
        }
        try {
            Cursor query = this.f64738a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY}, null);
            query.getClass();
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("value"));
            if (string == null || string.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            OAIDLog.print("OAID query success: " + string);
            iGetter.onOAIDGetComplete(string);
            query.close();
        } catch (Exception e4) {
            OAIDLog.print(e4);
            iGetter.onOAIDGetError(e4);
        }
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.f64738a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e4) {
            OAIDLog.print(e4);
            return false;
        }
    }
}
