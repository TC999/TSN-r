package xyz.adscope.common.info.deviceinfo.sm.oaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDFactory;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class DeviceID implements IGetter {

    /* renamed from: a  reason: collision with root package name */
    public Application f64717a;

    /* renamed from: b  reason: collision with root package name */
    public String f64718b;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final DeviceID f64719a = new DeviceID();
    }

    public DeviceID() {
    }

    public static void getGAID(Context context, IGetter iGetter) {
        OAIDFactory.createGaid(context).doGet(iGetter);
    }

    public static String getOAID() {
        String str = Holder.f64719a.f64718b;
        return str == null ? "" : str;
    }

    public static void getOAID(Context context, IGetter iGetter) {
        OAIDFactory.create(context).doGet(iGetter);
    }

    public static void register(Application application) {
        if (application == null) {
            return;
        }
        DeviceID deviceID = Holder.f64719a;
        deviceID.f64717a = application;
        getOAID(application, deviceID);
    }

    public static boolean supportedOAID(Context context) {
        return OAIDFactory.create(context).supported();
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter
    public void onOAIDGetComplete(String str) {
        if (TextUtils.isEmpty(str)) {
            onOAIDGetError(new OAIDException("OAID is empty"));
        } else {
            this.f64718b = str;
        }
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter
    public void onOAIDGetError(Exception exc) {
    }
}
