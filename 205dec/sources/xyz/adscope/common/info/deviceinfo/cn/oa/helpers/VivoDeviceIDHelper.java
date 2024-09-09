package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.acse.ottn.f3;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class VivoDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64698a;

    /* renamed from: b  reason: collision with root package name */
    public HandlerThread f64699b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f64700c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64701d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f64702e = null;

    public VivoDeviceIDHelper(Context context) {
        this.f64698a = context;
    }

    public final String a(int i4, String str) {
        Cursor query = this.f64698a.getContentResolver().query(i4 != 0 ? null : Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            r8 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        }
        return r8;
    }

    public final String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return str2;
        }
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        this.f64699b = handlerThread;
        handlerThread.start();
        this.f64700c = new Handler(this.f64699b.getLooper()) { // from class: xyz.adscope.common.info.deviceinfo.cn.oa.helpers.VivoDeviceIDHelper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 11) {
                    VivoDeviceIDHelper.this.a(message.getData().getInt("type"), message.getData().getString("appid"));
                }
            }
        };
    }

    public final void b(int i4, String str) {
        Message obtainMessage = this.f64700c.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", 0);
        if (i4 == 1 || i4 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        this.f64700c.sendMessage(obtainMessage);
    }

    public final boolean b() {
        boolean equals = a("persist.sys.identifierid.supported", "0").equals("1");
        this.f64701d = equals;
        return equals;
    }

    public String getOaid() {
        Cursor query = this.f64698a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            r1 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        }
        return r1;
    }

    public String loge() {
        a();
        b();
        if (this.f64701d && this.f64702e == null) {
            b(0, null);
            return null;
        }
        return null;
    }
}
