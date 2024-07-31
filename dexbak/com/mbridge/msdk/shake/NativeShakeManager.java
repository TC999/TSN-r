package com.mbridge.msdk.shake;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.umeng.analytics.pro.UMCommonContent;

/* renamed from: com.mbridge.msdk.shake.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class NativeShakeManager {

    /* renamed from: a */
    private SensorManager f31689a;

    /* compiled from: NativeShakeManager.java */
    /* renamed from: com.mbridge.msdk.shake.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class C11557a {

        /* renamed from: a */
        static NativeShakeManager f31690a = new NativeShakeManager();
    }

    /* renamed from: a */
    public static NativeShakeManager m21302a() {
        return C11557a.f31690a;
    }

    /* renamed from: b */
    public final void m21300b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.f31689a;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private NativeShakeManager() {
    }

    /* renamed from: a */
    public final void m21301a(SensorEventListener sensorEventListener) {
        Context m22861j = MBSDKContext.m22865f().m22861j();
        if (m22861j != null) {
            try {
                if (this.f31689a == null) {
                    this.f31689a = (SensorManager) m22861j.getSystemService(UMCommonContent.f37799ac);
                }
                this.f31689a.registerListener(sensorEventListener, this.f31689a.getDefaultSensor(1), 2);
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                try {
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000106&");
                    if (!TextUtils.isEmpty(CommonConst.f30596s)) {
                        stringBuffer.append("b=" + CommonConst.f30596s + "&");
                    }
                    if (!TextUtils.isEmpty(CommonConst.f30597t)) {
                        stringBuffer.append("c=" + CommonConst.f30597t + "&");
                    }
                    stringBuffer.append("reason=" + message);
                    if (MBBatchReportManager.m22142a().m22135c()) {
                        MBBatchReportManager.m22142a().m22139a(stringBuffer.toString());
                    } else {
                        C11385e.m22057b(m22861j, stringBuffer.toString());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
