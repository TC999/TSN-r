package xyz.adscope.common.info.deviceinfo.sm.oaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class DeviceIdentifier {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f64720a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f64721b;

    public static String getOAID(Context context) {
        if (TextUtils.isEmpty(f64721b)) {
            synchronized (DeviceIdentifier.class) {
                if (TextUtils.isEmpty(f64721b)) {
                    f64721b = DeviceID.getOAID();
                    if (f64721b == null || f64721b.length() == 0) {
                        DeviceID.getOAID(context, new IGetter() { // from class: xyz.adscope.common.info.deviceinfo.sm.oaid.DeviceIdentifier.1
                            @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter
                            public void onOAIDGetComplete(String str) {
                                String unused = DeviceIdentifier.f64721b = str;
                            }

                            @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter
                            public void onOAIDGetError(Exception exc) {
                                String unused = DeviceIdentifier.f64721b = "";
                            }
                        });
                    }
                }
            }
        }
        if (f64721b == null) {
            f64721b = "";
        }
        return f64721b;
    }

    public static void register(Application application) {
        if (f64720a) {
            return;
        }
        synchronized (DeviceIdentifier.class) {
            if (!f64720a) {
                DeviceID.register(application);
                f64720a = true;
            }
        }
    }
}
