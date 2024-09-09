package com.jg.ids.h;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class a extends com.jg.ids.a {

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f37828b = Uri.parse("content://cn.nubia.identity/identity");

    public a(Context context) {
        super(context, "nubia_thread");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.a
    public final void a(Message message) {
        String str = null;
        if (message != null) {
            try {
                if (message.what == 0) {
                    int i4 = message.getData().getInt("type", -1);
                    String str2 = "";
                    switch (i4) {
                        case 0:
                            str2 = "getOAID";
                            break;
                        case 1:
                            str2 = "getVAID";
                            str = this.f37822a.getPackageName();
                            break;
                        case 2:
                            str2 = "getAAID";
                            str = this.f37822a.getPackageName();
                            break;
                    }
                    a(i4, a(this.f37822a, str2, str));
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.jg.ids.a
    protected final void b() {
        a(2);
        a(0);
        a(1);
    }

    private void a(int i4) {
        try {
            Message a4 = a();
            a4.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i4);
            a4.setData(bundle);
            b(a4);
        } catch (Throwable th) {
        }
    }

    private static String a(Context context, String str, String str2) {
        Bundle call;
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(f37828b);
                if (acquireContentProviderClient == null) {
                    return "";
                }
                call = acquireContentProviderClient.call(str, str2, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = context.getContentResolver().call(f37828b, str, str2, (Bundle) null);
            }
            if (call != null && call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
        } catch (Throwable th) {
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.a
    public final void a(int i4, String str) {
        switch (i4) {
            case 0:
                a(new b(this, str));
                return;
            case 1:
                a(new c(this, str));
                return;
            case 2:
                a(new d(this, str));
                return;
            default:
                return;
        }
    }
}
