package com.jg.ids.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class i extends com.jg.ids.g {

    /* renamed from: b  reason: collision with root package name */
    private String f37840b;

    /* renamed from: c  reason: collision with root package name */
    private String f37841c;

    public i(Context context) {
        super(context);
        this.f37840b = "";
        this.f37841c = "";
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        String str = this.f37841c;
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1010579227:
                if (str.equals("openid")) {
                    c4 = 0;
                    break;
                }
                break;
            case 103726968:
                if (str.equals("mcsid")) {
                    c4 = 1;
                    break;
                }
                break;
            case 109760126:
                if (str.equals("stdid")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                return intent;
            case 1:
                Intent intent2 = new Intent("action.com.oplus.stdid.ID_SERVICE");
                intent2.setComponent(new ComponentName("com.coloros.mcs", "com.oplus.stdid.IdentifyService"));
                return intent2;
            case 2:
                Intent intent3 = new Intent("action.com.oplus.stdid.ID_SERVICE");
                intent3.setComponent(new ComponentName("com.oplus.stdid", "com.oplus.stdid.IdentifyService"));
                return intent3;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.g
    public final void a(IBinder iBinder) {
        h hVar = null;
        try {
            String str = this.f37841c;
            char c4 = '\uffff';
            switch (str.hashCode()) {
                case -1010579227:
                    if (str.equals("openid")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 103726968:
                    if (str.equals("mcsid")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 109760126:
                    if (str.equals("stdid")) {
                        c4 = 2;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    hVar = b.a(iBinder);
                    break;
                case 1:
                    hVar = e.a(iBinder);
                    break;
                case 2:
                    hVar = e.a(iBinder);
                    break;
            }
            String a4 = a(this.f37822a, hVar, "AUID");
            String a5 = a(this.f37822a, hVar, "OUID");
            String a6 = a(this.f37822a, hVar, "DUID");
            a(a4);
            b(a6);
            c(a5);
            b();
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f37822a == null) {
            return false;
        }
        if (g.a(this.f37822a)) {
            this.f37841c = "openid";
        }
        if (com.jg.ids.j.b(this.f37822a)) {
            this.f37841c = "mcsid";
        }
        if (j.d(this.f37822a)) {
            this.f37841c = "stdid";
        }
        return !TextUtils.isEmpty(this.f37841c);
    }

    private String a(Context context, h hVar, String str) {
        Signature[] signatureArr;
        String str2 = null;
        if (context == null || hVar == null || !d()) {
            return "";
        }
        String packageName = this.f37822a.getPackageName();
        if (TextUtils.isEmpty(this.f37840b)) {
            try {
                signatureArr = this.f37822a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Throwable th) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b4 : digest) {
                            sb.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Throwable th2) {
                }
            }
            this.f37840b = str2;
        }
        return hVar.a(context.getPackageName(), this.f37840b, str);
    }
}
