package com.mbridge.msdk.click;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignDAIDao;
import com.mbridge.msdk.foundation.p472db.CampaignReportDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import com.mbridge.msdk.widget.dialog.MBAlertDialogListener;
import com.stub.StubApp;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.reflect.InvocationTargetException;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AppReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f29957a;

    static {
        StubApp.interface11(20710);
        f29957a = AppReceiver.class.getSimpleName();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED") || intent.getData() == null) {
            return;
        }
        try {
            final String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            CampaignEx m22725h = CampaignReportDao.m22726b(CommonSDKDBHelper.m22721a(context)).m22725h(schemeSpecificPart);
            CampaignDAIDao m22789a = CampaignDAIDao.m22789a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
            int m22774j = m22789a.m22774j(schemeSpecificPart);
            final String m22772l = m22789a.m22772l(schemeSpecificPart);
            final String m22780d = m22789a.m22780d(m22772l);
            final String m22779e = m22789a.m22779e(m22772l);
            final String m22777g = m22789a.m22777g(m22772l);
            final String m22778f = m22789a.m22778f(m22772l);
            String m22773k = m22789a.m22773k(schemeSpecificPart);
            try {
                try {
                    try {
                        ADownloadManager.class.getMethod("installed", String.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), m22772l);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                }
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
            }
            if (m22774j == 0) {
                CommonClickUtil.m23063f(MBSDKContext.m22865f().m22861j(), schemeSpecificPart);
            } else if (m22774j == 1) {
                final Context m22872c = MBSDKContext.m22865f().m22872c();
                if (m22872c instanceof Activity) {
                    MBAlertDialog mBAlertDialog = new MBAlertDialog(m22872c, new MBAlertDialogListener() { // from class: com.mbridge.msdk.click.a.1
                        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                        /* renamed from: a */
                        public final void mo20509a() {
                            CommonClickUtil.m23063f(MBSDKContext.m22865f().m22861j(), schemeSpecificPart);
                            C11385e.m22072a(m22872c, m22772l, m22780d, schemeSpecificPart, 1, m22779e, m22777g, m22778f);
                        }

                        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                        /* renamed from: b */
                        public final void mo20508b() {
                            C11385e.m22072a(m22872c, m22772l, m22780d, schemeSpecificPart, 0, m22779e, m22777g, m22778f);
                        }

                        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                        /* renamed from: c */
                        public final void mo20507c() {
                            mo20509a();
                        }
                    });
                    mBAlertDialog.makeInstallAlert(m22773k);
                    mBAlertDialog.show();
                }
            }
            if (m22725h != null) {
                CommonClickControl.m23098b(m22725h, context, "install");
            }
            C11400ae.m21962a(context, schemeSpecificPart, schemeSpecificPart + "downloadType", schemeSpecificPart + "linkType", schemeSpecificPart + "rid", schemeSpecificPart + BidResponsedEx.KEY_CID, schemeSpecificPart + "isDowning", schemeSpecificPart + UMModuleRegister.PROCESS);
        } catch (Exception e5) {
            SameLogTool.m21738a(f29957a, e5.getMessage());
        }
    }
}
