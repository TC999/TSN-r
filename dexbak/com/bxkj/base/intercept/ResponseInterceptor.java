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
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import com.bjtsn.dylan.lifecycleobserver.LifecycleCallback;
import com.bjtsn.dylan.lifecycleobserver.LifecycleObserver;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4229c;
import com.orhanobut.logger.C11792j;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

/* renamed from: com.bxkj.base.intercept.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ResponseInterceptor implements cn.bluemobi.dylan.http.ResponseInterceptor {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResponseInterceptor.java */
    /* renamed from: com.bxkj.base.intercept.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3877a extends LifecycleCallback {

        /* renamed from: a */
        final /* synthetic */ Dialog f14805a;

        C3877a(Dialog dialog) {
            this.f14805a = dialog;
        }

        @Override // com.bjtsn.dylan.lifecycleobserver.LifecycleCallback
        public void onDestroy() {
            Dialog dialog = this.f14805a;
            if (dialog != null && dialog.isShowing()) {
                this.f14805a.dismiss();
            }
            super.onDestroy();
        }
    }

    /* compiled from: ResponseInterceptor.java */
    /* renamed from: com.bxkj.base.intercept.f$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class View$OnClickListenerC3878b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Context f14807a;

        View$OnClickListenerC3878b(Context context) {
            this.f14807a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginUser.getLoginUser().setLogin(false);
            LoginUser.getLoginUser().setToken("");
            LoginUser.getLoginUser().setUserId("");
            AppManager.m57776n().m57780j();
            if (LoginUser.getLoginUser().getUserType() == 1) {
                this.f14807a.startActivity(new Intent().setComponent(new ComponentName(C4229c.f16086b, "com.bxkj.student.MainActivity")).setFlags(67108864));
                this.f14807a.startActivity(new Intent().setComponent(new ComponentName(C4229c.f16086b, "com.bxkj.student.personal.login.LoginActivity")).setFlags(268435456));
                return;
            }
            this.f14807a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.teacher", "com.bxkj.teacher.login.LoginActivity")).setFlags(67108864));
        }
    }

    /* renamed from: d */
    private void m44200d(Context context, Dialog dialog) {
        if (context instanceof Activity) {
            new LifecycleObserver((FragmentActivity) context).m45791c(new C3877a(dialog));
        }
    }

    /* renamed from: e */
    private void m44199e(String str) {
        ((ClipboardManager) BaseApp.m44341b().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("错误信息", str));
    }

    /* renamed from: f */
    private String m44198f(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (sb.indexOf("=") != -1) {
                sb.append(ShellAdbUtils.f33810d);
            }
            sb.append(key);
            sb.append("=");
            sb.append(value);
        }
        return sb.toString();
    }

    /* renamed from: g */
    private String m44197g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return JsonParse.formatJson(str);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m44196h(StringBuilder sb, Context context) {
        m44199e(sb.toString());
        Toast.makeText(context, "已复制到剪切板", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static /* synthetic */ void m44195i(Context context, View view) {
        BaseApp.m44341b().mo43012h(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m44194j(StringBuilder sb, Context context) {
        m44199e(sb.toString());
        Toast.makeText(context, "已复制到剪切板", 0).show();
    }

    @Override // cn.bluemobi.dylan.http.ResponseInterceptor
    public void onError(final Context context, Throwable th) {
        if (LoginUser.getLoginUser().isOpenModel()) {
            C11792j.m20470c(th.getMessage());
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(context);
            iostwobuttondialog.setMessageGrivity(3);
            iostwobuttondialog.setLeftButtonText("复制到剪切板");
            final StringBuilder sb = new StringBuilder();
            sb.append("接口请求报错:\n" + stringWriter2);
            iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.base.intercept.d
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                public final void buttonLeftOnClick() {
                    ResponseInterceptor.this.m44196h(sb, context);
                }
            });
            iostwobuttondialog.setMessage(sb).show();
            m44200d(context, iostwobuttondialog);
        }
    }

    @Override // cn.bluemobi.dylan.http.ResponseInterceptor
    public boolean onResponse(final Context context, int i, String str, Map<String, Object> map, String str2) {
        if (i == 201) {
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
        if (i == 601) {
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).show();
            return false;
        } else if (i != 602) {
            if (i == 603) {
                new iOSOneButtonDialog(context).setMessage(str).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.intercept.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ResponseInterceptor.m44195i(context, view);
                    }
                }).show();
            }
            return false;
        } else {
            iOSOneButtonDialog iosonebuttondialog2 = new iOSOneButtonDialog(context);
            iosonebuttondialog2.setCancelable(false);
            iosonebuttondialog2.setMessage(str).show();
            iosonebuttondialog2.setButtonOnClickListener(new View$OnClickListenerC3878b(context));
            return false;
        }
    }

    @Override // cn.bluemobi.dylan.http.ResponseInterceptor
    public boolean onResponseStart(final Context context, String str, Map<String, Object> map, String str2, int i) {
        if (LoginUser.getLoginUser().isOpenModel()) {
            iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(context);
            iostwobuttondialog.setTitle("接口信息");
            iostwobuttondialog.setMessageGrivity(3);
            iostwobuttondialog.setLeftButtonText("复制到剪切板");
            final StringBuilder sb = new StringBuilder();
            sb.append("请求地址:\n" + str);
            sb.append("\n请求参数:\n" + m44198f(map));
            sb.append("\n响应状态:" + i);
            sb.append("\n响应数据:\n" + m44197g(str2));
            iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.base.intercept.e
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                public final void buttonLeftOnClick() {
                    ResponseInterceptor.this.m44194j(sb, context);
                }
            });
            iostwobuttondialog.setMessage(sb).show();
            m44200d(context, iostwobuttondialog);
            return false;
        }
        return false;
    }
}
