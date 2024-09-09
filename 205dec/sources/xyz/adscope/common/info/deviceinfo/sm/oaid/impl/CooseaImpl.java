package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CooseaImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64727a;

    /* renamed from: b  reason: collision with root package name */
    public final KeyguardManager f64728b;

    public CooseaImpl(Context context) {
        this.f64727a = context;
        this.f64728b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64727a == null || iGetter == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f64728b;
        if (keyguardManager == null) {
            iGetter.onOAIDGetError(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f64728b, new Object[0]);
            if (invoke == null) {
                throw new OAIDException("OAID obtain failed");
            }
            String obj = invoke.toString();
            OAIDLog.print("OAID obtain success: " + obj);
            iGetter.onOAIDGetComplete(obj);
        } catch (Exception e4) {
            OAIDLog.print(e4);
        }
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        KeyguardManager keyguardManager;
        if (this.f64727a == null || (keyguardManager = this.f64728b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f64728b, new Object[0]);
            invoke.getClass();
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e4) {
            OAIDLog.print(e4);
            return false;
        }
    }
}
