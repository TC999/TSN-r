package com.mbridge.msdk.click;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class AppReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38784a;

    static {
        StubApp.interface11(20710);
        f38784a = AppReceiver.class.getSimpleName();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED") || intent.getData() == null) {
            return;
        }
        try {
            final String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            CampaignEx h4 = com.mbridge.msdk.foundation.db.g.b(i.a(context)).h(schemeSpecificPart);
            com.mbridge.msdk.foundation.db.e a4 = com.mbridge.msdk.foundation.db.e.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
            int j4 = a4.j(schemeSpecificPart);
            final String l4 = a4.l(schemeSpecificPart);
            final String d4 = a4.d(l4);
            final String e4 = a4.e(l4);
            final String g4 = a4.g(l4);
            final String f4 = a4.f(l4);
            String k4 = a4.k(schemeSpecificPart);
            try {
                try {
                    try {
                        ADownloadManager.class.getMethod("installed", String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), l4);
                    } catch (IllegalAccessException e5) {
                        e5.printStackTrace();
                    } catch (InvocationTargetException e6) {
                        e6.printStackTrace();
                    }
                } catch (NoSuchMethodException e7) {
                    e7.printStackTrace();
                }
            } catch (ClassNotFoundException e8) {
                e8.printStackTrace();
            }
            if (j4 == 0) {
                c.f(com.mbridge.msdk.foundation.controller.a.f().j(), schemeSpecificPart);
            } else if (j4 == 1) {
                final Context c4 = com.mbridge.msdk.foundation.controller.a.f().c();
                if (c4 instanceof Activity) {
                    MBAlertDialog mBAlertDialog = new MBAlertDialog(c4, new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.click.a.1
                        @Override // com.mbridge.msdk.widget.dialog.a
                        public final void a() {
                            c.f(com.mbridge.msdk.foundation.controller.a.f().j(), schemeSpecificPart);
                            com.mbridge.msdk.foundation.same.report.e.a(c4, l4, d4, schemeSpecificPart, 1, e4, g4, f4);
                        }

                        @Override // com.mbridge.msdk.widget.dialog.a
                        public final void b() {
                            com.mbridge.msdk.foundation.same.report.e.a(c4, l4, d4, schemeSpecificPart, 0, e4, g4, f4);
                        }

                        @Override // com.mbridge.msdk.widget.dialog.a
                        public final void c() {
                            a();
                        }
                    });
                    mBAlertDialog.makeInstallAlert(k4);
                    mBAlertDialog.show();
                }
            }
            if (h4 != null) {
                b.b(h4, context, AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY);
            }
            ae.a(context, schemeSpecificPart, schemeSpecificPart + "downloadType", schemeSpecificPart + "linkType", schemeSpecificPart + "rid", schemeSpecificPart + BidResponsedEx.KEY_CID, schemeSpecificPart + "isDowning", schemeSpecificPart + "process");
        } catch (Exception e9) {
            x.a(f38784a, e9.getMessage());
        }
    }
}
