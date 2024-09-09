package com.bxkj.base.intercept;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.ResponseInterceptor;
import com.bjtsn.dylan.lifecycleobserver.LifecycleObserver;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.orhanobut.logger.j;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ResponseInterceptor.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f implements ResponseInterceptor {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ResponseInterceptor.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a extends com.bjtsn.dylan.lifecycleobserver.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Dialog f18290a;

        a(Dialog dialog) {
            this.f18290a = dialog;
        }

        @Override // com.bjtsn.dylan.lifecycleobserver.b
        public void onDestroy() {
            Dialog dialog = this.f18290a;
            if (dialog != null && dialog.isShowing()) {
                this.f18290a.dismiss();
            }
            super.onDestroy();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ResponseInterceptor.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f18292a;

        b(Context context) {
            this.f18292a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginUser.getLoginUser().setLogin(false);
            LoginUser.getLoginUser().setToken("");
            LoginUser.getLoginUser().setUserId("");
            cn.bluemobi.dylan.base.utils.a.n().j();
            if (LoginUser.getLoginUser().getUserType() == 1) {
                this.f18292a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.student", "com.bxkj.student.MainActivity")).setFlags(TTAdConstant.KEY_CLICK_AREA));
                this.f18292a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.student", "com.bxkj.student.personal.login.LoginActivity")).setFlags(268435456));
                return;
            }
            this.f18292a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.teacher", "com.bxkj.teacher.login.LoginActivity")).setFlags(TTAdConstant.KEY_CLICK_AREA));
        }
    }

    private void d(Context context, Dialog dialog) {
        if (context instanceof Activity) {
            new LifecycleObserver((FragmentActivity) context).c(new a(dialog));
        }
    }

    private void e(String str) {
        ((ClipboardManager) BaseApp.b().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("\u9519\u8bef\u4fe1\u606f", str));
    }

    private String f(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (sb.indexOf("=") != -1) {
                sb.append("\n");
            }
            sb.append(key);
            sb.append("=");
            sb.append(value);
        }
        return sb.toString();
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return JsonParse.formatJson(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(StringBuilder sb, Context context) {
        e(sb.toString());
        Toast.makeText(context, "\u5df2\u590d\u5236\u5230\u526a\u5207\u677f", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Context context, View view) {
        BaseApp.b().h(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(StringBuilder sb, Context context) {
        e(sb.toString());
        Toast.makeText(context, "\u5df2\u590d\u5236\u5230\u526a\u5207\u677f", 0).show();
    }

    @Override // cn.bluemobi.dylan.http.ResponseInterceptor
    public void onError(final Context context, Throwable th) {
        if (LoginUser.getLoginUser().isOpenModel()) {
            j.c(th.getMessage());
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(context);
            iostwobuttondialog.setMessageGrivity(3);
            iostwobuttondialog.setLeftButtonText("\u590d\u5236\u5230\u526a\u5207\u677f");
            final StringBuilder sb = new StringBuilder();
            sb.append("\u63a5\u53e3\u8bf7\u6c42\u62a5\u9519:\n" + stringWriter2);
            iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.base.intercept.d
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                public final void buttonLeftOnClick() {
                    f.this.h(sb, context);
                }
            });
            iostwobuttondialog.setMessage(sb).show();
            d(context, iostwobuttondialog);
        }
    }

    @Override // cn.bluemobi.dylan.http.ResponseInterceptor
    public boolean onResponse(final Context context, int i4, String str, Map<String, Object> map, String str2) {
        if (i4 == 201) {
            if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/ispwdmod")) {
                if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/appstu/uploadGatherPhoto")) {
                    if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/runingFace/appRuningFace")) {
                        if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/callStuIdentify/userAddCallStuIdentify")) {
                            if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/face/checkUserByFace")) {
                                if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/appLearnResource/learnResourceDetailOperation")) {
                                    if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/sportRecordSetting/checkTimeOut")) {
                                        if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/appSportRecord/appAddSportRecord")) {
                                            if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/getSysUserByThirdId")) {
                                                new iOSOneButtonDialog(context).setMessage(str).show();
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (i4 == 601) {
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).show();
            return false;
        } else if (i4 != 602) {
            if (i4 == 603) {
                new iOSOneButtonDialog(context).setMessage(str).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.intercept.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        f.i(context, view);
                    }
                }).show();
            }
            return false;
        } else {
            iOSOneButtonDialog iosonebuttondialog2 = new iOSOneButtonDialog(context);
            iosonebuttondialog2.setCancelable(false);
            iosonebuttondialog2.setMessage(str).show();
            iosonebuttondialog2.setButtonOnClickListener(new b(context));
            return false;
        }
    }

    @Override // cn.bluemobi.dylan.http.ResponseInterceptor
    public boolean onResponseStart(final Context context, String str, Map<String, Object> map, String str2, int i4) {
        if (LoginUser.getLoginUser().isOpenModel()) {
            iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(context);
            iostwobuttondialog.setTitle("\u63a5\u53e3\u4fe1\u606f");
            iostwobuttondialog.setMessageGrivity(3);
            iostwobuttondialog.setLeftButtonText("\u590d\u5236\u5230\u526a\u5207\u677f");
            final StringBuilder sb = new StringBuilder();
            sb.append("\u8bf7\u6c42\u5730\u5740:\n" + str);
            sb.append("\n\u8bf7\u6c42\u53c2\u6570:\n" + f(map));
            sb.append("\n\u54cd\u5e94\u72b6\u6001:" + i4);
            sb.append("\n\u54cd\u5e94\u6570\u636e:\n" + g(str2));
            iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.base.intercept.e
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                public final void buttonLeftOnClick() {
                    f.this.j(sb, context);
                }
            });
            iostwobuttondialog.setMessage(sb).show();
            d(context, iostwobuttondialog);
            return false;
        }
        return false;
    }
}
