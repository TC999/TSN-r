package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class MeizuDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64683a;

    public MeizuDeviceIDHelper(Context context) {
        this.f64683a = context;
    }

    public final String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    public void getMeizuID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        try {
            this.f64683a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
        Uri parse = Uri.parse("content://com.meizu.flyme.openidsdk/");
        try {
            Cursor query = this.f64683a.getContentResolver().query(parse, null, null, new String[]{AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY}, null);
            String a4 = a(query);
            if (appIdsUpdater != null) {
                appIdsUpdater.OnIdsValid(a4);
            }
            query.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
