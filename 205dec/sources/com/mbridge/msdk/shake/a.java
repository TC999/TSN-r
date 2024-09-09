package com.mbridge.msdk.shake;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.report.e;

/* compiled from: NativeShakeManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f40460a;

    /* compiled from: NativeShakeManager.java */
    /* renamed from: com.mbridge.msdk.shake.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class C0761a {

        /* renamed from: a  reason: collision with root package name */
        static a f40461a = new a();
    }

    public static a a() {
        return C0761a.f40461a;
    }

    public final void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.f40460a;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private a() {
    }

    public final void a(SensorEventListener sensorEventListener) {
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (j4 != null) {
            try {
                if (this.f40460a == null) {
                    this.f40460a = (SensorManager) j4.getSystemService("sensor");
                }
                this.f40460a.registerListener(sensorEventListener, this.f40460a.getDefaultSensor(1), 2);
            } catch (Exception e4) {
                e4.printStackTrace();
                String message = e4.getMessage();
                try {
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000106&");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39391s)) {
                        stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.f39391s + "&");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39392t)) {
                        stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.f39392t + "&");
                    }
                    stringBuffer.append("reason=" + message);
                    if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                        com.mbridge.msdk.foundation.same.report.b.a().a(stringBuffer.toString());
                    } else {
                        e.b(j4, stringBuffer.toString());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
