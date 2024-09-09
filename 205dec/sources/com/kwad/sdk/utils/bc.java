package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.hardware.SensorEvent;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bb;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bc {
    private static String TAG = "plugin.signature";
    public static Signature[] aPZ = new Signature[0];

    /* renamed from: com.kwad.sdk.utils.bc$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass1 extends com.kwad.sdk.core.c.d {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            bc.b(bc.this);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (o.LT()) {
                bc.a(bc.this);
            }
        }
    }

    /* renamed from: com.kwad.sdk.utils.bc$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass2 implements bb.b {
        AnonymousClass2() {
        }

        public final void onFailed() {
            bc.a(bc.this, true);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class a {
        private static final bc aRe = new bc((byte) 0);
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class b {
        private SensorEvent aRf;
        private long timestamp;

        private b() {
        }

        public final void Q(List<com.kwad.sdk.k.a.e> list) {
            if (this.aRf == null) {
                return;
            }
            com.kwad.sdk.k.a.e eVar = new com.kwad.sdk.k.a.e();
            eVar.sensorType = this.aRf.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f4 : this.aRf.values) {
                eVar.aOj.add(Float.valueOf(f4));
            }
            list.add(eVar);
        }

        public final void b(SensorEvent sensorEvent) {
            this.aRf = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    private static Signature[] cS(Context context) {
        Signature[] signatureArr = aPZ;
        if (signatureArr == null || signatureArr.length <= 0) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                if (packageInfo != null) {
                    aPZ = packageInfo.signatures;
                }
            } catch (PackageManager.NameNotFoundException e4) {
                String str = TAG;
                com.kwad.sdk.core.e.c.w(str, "Can not get signature, error = " + e4.getLocalizedMessage());
                com.kwad.sdk.core.e.c.w(TAG, e4);
            }
            return aPZ;
        }
        return signatureArr;
    }

    public static String cT(Context context) {
        try {
            Signature[] cS = cS(context);
            if (cS != null && cS.length > 0) {
                return ad.l(cS[0].toByteArray());
            }
            return "";
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.w(TAG, e4);
            return "";
        }
    }
}
