package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class XiaomiImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64753a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f64754b;

    /* renamed from: c  reason: collision with root package name */
    public Object f64755c;

    @SuppressLint({"PrivateApi"})
    public XiaomiImpl(Context context) {
        this.f64753a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f64754b = cls;
            this.f64755c = cls.newInstance();
        } catch (Exception e4) {
            OAIDLog.print(e4);
        }
    }

    public final String a() {
        return (String) this.f64754b.getMethod("getOAID", Context.class).invoke(this.f64755c, this.f64753a);
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64753a == null || iGetter == null) {
            return;
        }
        if (this.f64754b == null || this.f64755c == null) {
            iGetter.onOAIDGetError(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String a4 = a();
            if (a4 == null || a4.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            OAIDLog.print("OAID query success: " + a4);
            iGetter.onOAIDGetComplete(a4);
        } catch (Exception e4) {
            OAIDLog.print(e4);
            iGetter.onOAIDGetError(e4);
        }
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        return this.f64755c != null;
    }
}
