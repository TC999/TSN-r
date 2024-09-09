package com.bxkj.student.run.app;

import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MyLocationStyle;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.ViewSwitcher;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.location.service.LocationService;
import com.bxkj.student.run.app.my.MyRunActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.ready.RunDescriptionActivity;
import com.bxkj.student.run.app.ready.RunRoleSetBean;
import com.bxkj.student.run.app.ready.RunType;
import com.bxkj.student.run.app.ready.RunTypeDialog;
import com.bxkj.student.run.app.record.Card;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.step.service.StepService;
import com.bxkj.student.run.app.vm.RunVM;
import com.snail.antifake.jni.EmulatorDetectUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import kotlin.f1;
import l.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class StartRunActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private MapView f22259k;

    /* renamed from: l  reason: collision with root package name */
    private AMap f22260l;

    /* renamed from: m  reason: collision with root package name */
    private Button f22261m;

    /* renamed from: n  reason: collision with root package name */
    private RunTypeDialog f22262n;

    /* renamed from: o  reason: collision with root package name */
    private ViewSwitcher f22263o;

    /* renamed from: p  reason: collision with root package name */
    private Card f22264p;

    /* renamed from: q  reason: collision with root package name */
    private Card f22265q;

    /* renamed from: r  reason: collision with root package name */
    private Card f22266r;

    /* renamed from: s  reason: collision with root package name */
    private iOSTwoButtonDialog f22267s;

    /* renamed from: t  reason: collision with root package name */
    private iOSTwoButtonDialog f22268t;

    /* renamed from: u  reason: collision with root package name */
    private RunVM f22269u = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RunDb f22270a;

        a(final RunDb val$runDb) {
            this.f22270a = val$runDb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(RunDb runDb, View view) {
            StartRunActivity startRunActivity = StartRunActivity.this;
            startRunActivity.x1(runDb, startRunActivity.f22267s, 3);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            StartRunActivity.this.f22267s.dismiss();
            if (status == 201) {
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h);
                iosonebuttondialog.setCanceledOnTouchOutside(false);
                iosonebuttondialog.setCancelable(false);
                final RunDb runDb = this.f22270a;
                iosonebuttondialog.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.g0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.a.this.b(runDb, view);
                    }
                });
                iosonebuttondialog.setMessage(msg).show();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StartRunActivity.this.f22267s.dismiss();
            Intent intent = new Intent();
            intent.putExtra("runExceptionDataDBId", this.f22270a.getIdentify());
            intent.setClass(((BaseActivity) StartRunActivity.this).f1656h, RunningActivity.class);
            StartRunActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements l1.a<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f22272a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f22273b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RunDb f22274c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f22275d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f22276e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a extends HttpCallBack {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void d(View view) {
                StartRunActivity.this.a1();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e(View view) {
                StartRunActivity.this.a1();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(View view) {
                StartRunActivity.this.a1();
            }

            private void g(String msg) {
                iOSTwoButtonDialog iostwobuttondialog = b.this.f22276e;
                if (iostwobuttondialog != null) {
                    iostwobuttondialog.dismiss();
                }
                StartRunActivity.this.p1();
                StartRunActivity.this.f22269u.u(b.this.f22274c.getIdentify());
                new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.i0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.b.a.this.f(view);
                    }
                }).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnFailure(Throwable e4) {
                iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setMessage("\u63d0\u4ea4\u5f02\u5e38\uff0c\u5df2\u4e3a\u60a8\u6682\u5b58\u672c\u5730\uff0c\u8bf7\u7a0d\u540e\u5728\u672c\u5730\u8dd1\u6b65\u8bb0\u5f55\u4e2d\u91cd\u65b0\u4e0a\u4f20\uff01");
                message.setCanceledOnTouchOutside(false);
                message.setCancelable(false);
                message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.j0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.b.a.this.d(view);
                    }
                });
                message.show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                if (status == 202) {
                    g(msg);
                } else {
                    netOnFailure(new Exception("\u4e0a\u4f20\u5931\u8d25"));
                }
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data, String msg) {
                super.netOnSuccess(data, msg);
                g(msg);
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccessServerError(int code, String errorMessage) {
                super.netOnSuccessServerError(code, errorMessage);
                iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setMessage("\u63d0\u4ea4\u5f02\u5e38\uff0c\u5df2\u4e3a\u60a8\u6682\u5b58\u672c\u5730\uff0c\u8bf7\u7a0d\u540e\u5728\u672c\u5730\u8dd1\u6b65\u8bb0\u5f55\u4e2d\u91cd\u65b0\u4e0a\u4f20\uff01");
                message.setCanceledOnTouchOutside(false);
                message.setCancelable(false);
                message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.h0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.b.a.this.e(view);
                    }
                });
                message.show();
            }
        }

        b(final float val$distance, final long val$countTime, final RunDb val$runDb, final int val$uploadType, final iOSTwoButtonDialog val$exceptionDialog) {
            this.f22272a = val$distance;
            this.f22273b = val$countTime;
            this.f22274c = val$runDb;
            this.f22275d = val$uploadType;
            this.f22276e = val$exceptionDialog;
        }

        /* renamed from: a */
        public f1 invoke() {
            Http.with(((BaseActivity) StartRunActivity.this).f1656h).setLoadingMessage("\u6b63\u5728\u4e0a\u4f20...").hideLoadingDialog().setCanCancel(false).hideSuccessMessage().hideFailMessage().setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).q(LoginUser.getLoginUser().getUserId(), Integer.parseInt(this.f22274c.getSportsType()), Long.parseLong(this.f22274c.getStartTime()), Long.parseLong(this.f22274c.getEndTime()), TextUtils.isEmpty(this.f22274c.getLatLngList()) ? null : this.f22274c.getLatLngList(), this.f22274c.getIdentify(), com.bxkj.student.run.app.utils.i.g(this.f22273b), com.bxkj.student.run.app.utils.i.d(this.f22272a), com.bxkj.student.run.app.utils.i.a(this.f22272a, this.f22273b), com.bxkj.student.run.app.utils.i.b(this.f22272a, this.f22273b), TextUtils.isEmpty(this.f22274c.getPassLatLngList()) ? null : this.f22274c.getPassLatLngList(), com.bxkj.base.util.z.d(), com.bxkj.base.util.z.e(), "Android", com.bxkj.base.util.z.c(), com.bxkj.base.util.z.h(((BaseActivity) StartRunActivity.this).f1656h), this.f22274c.getStepList(), this.f22274c.isFaceOut(), TextUtils.isEmpty(this.f22274c.getPassLatLngList()) ? null : this.f22274c.getPassLatLngList(), Integer.valueOf(this.f22275d), null)).setDataListener(new a());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements b.a {
        c() {
        }

        @Override // l.b.a
        public void a(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setMessage(StartRunActivity.this.getString(2131821263)).show();
        }

        @Override // l.b.a
        public void b() {
        }

        @Override // l.b.a
        public void c(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setMessage(StartRunActivity.this.getString(2131821263)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements iOSTwoButtonDialog.RightButtonOnClick {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            com.bxkj.base.util.r.b(((BaseActivity) StartRunActivity.this).f1657i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e implements b.a {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            StartRunActivity.this.startActivity(intent);
        }

        @Override // l.b.a
        public void a(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setMessage(StartRunActivity.this.getString(2131821263)).show();
        }

        @Override // l.b.a
        public void b() {
            if (!((LocationManager) StartRunActivity.this.getSystemService("location")).isProviderEnabled("gps")) {
                new iOSTwoButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setTitle("GPS\u672a\u5f00\u542f").setMessage(StartRunActivity.this.getString(2131821266)).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.k0
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        StartRunActivity.e.this.e();
                    }
                }).show();
            } else {
                StartRunActivity.this.b1();
            }
        }

        @Override // l.b.a
        public void c(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setMessage(StartRunActivity.this.getString(2131821263)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StartRunActivity.this.v1(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g implements RunTypeDialog.a {
        g() {
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.a
        public void a() {
            StartRunActivity.this.w1(4);
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.a
        public void b() {
            StartRunActivity.this.w1(3);
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.a
        public void c() {
            StartRunActivity.this.w1(1);
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.a
        public void d() {
            StartRunActivity.this.w1(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f22284a;

        h(final int val$runType) {
            this.f22284a = val$runType;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                RunRoleSetBean.DataBean dataBean = (RunRoleSetBean.DataBean) JSON.parseObject(JSON.toJSONString(data), RunRoleSetBean.DataBean.class);
                dataBean.setRunType(this.f22284a);
                Intent intent = new Intent(((BaseActivity) StartRunActivity.this).f1656h, RunDescriptionActivity.class);
                intent.putExtra("dataBean", dataBean);
                StartRunActivity.this.startActivity(intent);
                StartRunActivity.this.overridePendingTransition(2130771987, 2130771986);
            } catch (Exception e4) {
                e4.printStackTrace();
                new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1656h).setMessage("\u8dd1\u6b65\u8bbe\u7f6e\u5f02\u5e38,\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class i extends HttpCallBack {
        i() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Map<String, Object> map = JsonParse.getMap(data, "morningRun");
            if (map != null && !map.isEmpty()) {
                int i4 = JsonParse.getInt(map, "succeed");
                double d4 = JsonParse.getDouble(map, "runSportRange");
                int i5 = JsonParse.getInt(map, "isShow");
                if (StartRunActivity.this.f22264p == null && i5 == 1) {
                    StartRunActivity.this.f22264p = new Card(((BaseActivity) StartRunActivity.this).f1656h).i(1).h(ContextCompat.getColor(((BaseActivity) StartRunActivity.this).f1656h, 2131034169));
                    StartRunActivity.this.f22263o.addView(StartRunActivity.this.f22264p);
                }
                if (StartRunActivity.this.f22264p != null) {
                    StartRunActivity.this.f22264p.setCount(i4);
                    StartRunActivity.this.f22264p.setDistance(d4);
                }
            }
            Map<String, Object> map2 = JsonParse.getMap(data, "sunRun");
            if (map2 != null && !map2.isEmpty()) {
                int i6 = JsonParse.getInt(map2, "succeed");
                double d5 = JsonParse.getDouble(map2, "runSportRange");
                int i7 = JsonParse.getInt(map2, "isShow");
                if (StartRunActivity.this.f22265q == null && i7 == 1) {
                    StartRunActivity.this.f22265q = new Card(((BaseActivity) StartRunActivity.this).f1656h).i(2).h(ContextCompat.getColor(((BaseActivity) StartRunActivity.this).f1656h, 2131034170));
                    StartRunActivity.this.f22263o.addView(StartRunActivity.this.f22265q);
                }
                if (StartRunActivity.this.f22265q != null) {
                    StartRunActivity.this.f22265q.setCount(i6);
                    StartRunActivity.this.f22265q.setDistance(d5);
                }
            }
            Map<String, Object> map3 = JsonParse.getMap(data, "freedom");
            if (map3 == null || map3.isEmpty()) {
                return;
            }
            int i8 = JsonParse.getInt(map3, "succeed");
            double d6 = JsonParse.getDouble(map3, "runSportRange");
            int i9 = JsonParse.getInt(map3, "isShow");
            if (StartRunActivity.this.f22266r == null && i9 == 1) {
                StartRunActivity.this.f22266r = new Card(((BaseActivity) StartRunActivity.this).f1656h).i(3).h(ContextCompat.getColor(((BaseActivity) StartRunActivity.this).f1656h, 2131034171));
                StartRunActivity.this.f22263o.addView(StartRunActivity.this.f22266r);
            }
            if (StartRunActivity.this.f22266r != null) {
                StartRunActivity.this.f22266r.setCount(i8);
                StartRunActivity.this.f22266r.setDistance(d6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        iOSTwoButtonDialog iostwobuttondialog = this.f22267s;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f22267s.dismiss();
        }
        iOSTwoButtonDialog iostwobuttondialog2 = this.f22268t;
        if (iostwobuttondialog2 != null && iostwobuttondialog2.isShowing()) {
            this.f22268t.dismiss();
        }
        if (this.f22269u == null) {
            return;
        }
        final LoadingDialog loadingDialog = new LoadingDialog(this.f1656h);
        loadingDialog.show();
        this.f22269u.z(new l1.l() { // from class: com.bxkj.student.run.app.f0
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 h12;
                h12 = StartRunActivity.this.h1(loadingDialog, (List) obj);
                return h12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        final LoadingDialog loadingDialog = new LoadingDialog(this.f1657i);
        loadingDialog.show();
        com.bxkj.student.v2.common.utils.n.f23377a.c(this.f1657i, new l1.a() { // from class: com.bxkj.student.run.app.d0
            public final Object invoke() {
                f1 i12;
                i12 = StartRunActivity.this.i1(loadingDialog);
                return i12;
            }
        }, new l1.a() { // from class: com.bxkj.student.run.app.c0
            public final Object invoke() {
                f1 j12;
                j12 = StartRunActivity.j1(LoadingDialog.this);
                return j12;
            }
        });
    }

    private void c1() {
        if (Build.VERSION.SDK_INT < 21 || !((PowerManager) getSystemService("power")).isPowerSaveMode() || isFinishing()) {
            return;
        }
        new iOSOneButtonDialog(this.f1656h).setMessage("\u5f00\u59cb\u8dd1\u6b65\u524d\u8bf7\u5173\u95ed\u7701\u7535\u6a21\u5f0f\uff0c\u5426\u5219\u8f68\u8ff9\u8bb0\u5f55\u53ef\u80fd\u4e0d\u51c6\u786e\uff01").show();
    }

    public static boolean d1(String source, String dest) {
        try {
            File file = new File(source);
            File file2 = new File(dest);
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (FileNotFoundException | IOException unused) {
            return false;
        }
    }

    private void e1() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).m(LoginUser.getLoginUser().getUserId())).setDataListener(new i());
        }
    }

    private void f1() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).a(LoginUser.getLoginUser().getUserId())).setDataListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 g1(LoadingDialog loadingDialog, List list) {
        loadingDialog.dismiss();
        if (list == null || list.size() <= 0) {
            return null;
        }
        t1(list);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 h1(final LoadingDialog loadingDialog, List list) {
        loadingDialog.dismiss();
        if (list != null && list.size() > 0) {
            s1((RunDb) list.get(0));
            return null;
        }
        loadingDialog.show();
        this.f22269u.A(new l1.l() { // from class: com.bxkj.student.run.app.e0
            @Override // l1.l
            public final Object invoke(Object obj) {
                f1 g12;
                g12 = StartRunActivity.this.g1(loadingDialog, (List) obj);
                return g12;
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 i1(LoadingDialog loadingDialog) {
        loadingDialog.dismiss();
        f1();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f1 j1(LoadingDialog loadingDialog) {
        loadingDialog.dismiss();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1(View view) {
        startActivity(new Intent(this.f1656h, RunRecorderListActivity.class).putExtra("runType", ((Card) view).getRunType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1() {
        startActivity(new Intent(this.f1656h, MyRunActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(RunDb runDb) {
        x1(runDb, this.f22267s, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(RunDb runDb) {
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).e(runDb.getIdentify())).setDataListener(new a(runDb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1() {
        startActivity(new Intent(this.f1656h, RunRecorderListActivity.class));
    }

    private void q1() {
        new l.b(this).c("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION").d(new c());
        if (Build.VERSION.SDK_INT < 19 || com.bxkj.base.util.r.a(this.f1656h)) {
            return;
        }
        new iOSTwoButtonDialog(this.f1656h).setMessage("\u4e3a\u4e86\u80fd\u591f\u8ba9\u4f60\u5728\u8dd1\u6b65\u8fc7\u7a0b\u4e2d\u4e0d\u9519\u8fc7\u91cd\u8981\u7684\u901a\u77e5\u6d88\u606f,\u5f3a\u70c8\u5efa\u8bae\u4f60\u5f00\u59cb\u5141\u8bb8\u63a8\u9001\u901a\u77e5\u529f\u80fd").setRightButtonOnClickListener(new d()).setLeftButtonText("\u4e0d\u4e86").setRightButtonText("\u53bb\u5f00\u542f").show();
    }

    private void r1() {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(2131558820));
        myLocationStyle.strokeColor(-16777216);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        this.f22260l.setMyLocationStyle(myLocationStyle);
        this.f22260l.getUiSettings().setMyLocationButtonEnabled(true);
        this.f22260l.setMyLocationEnabled(true);
        this.f22260l.moveCamera(CameraUpdateFactory.zoomTo(19.0f));
    }

    private void s1(final RunDb runDb) {
        com.orhanobut.logger.j.c("runExceptionDataDB=" + runDb.toString());
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(Long.parseLong(runDb.getStartTime())));
        String g4 = com.bxkj.student.run.app.utils.i.g(Long.parseLong(runDb.getCountTime()));
        String d4 = com.bxkj.student.run.app.utils.i.d((double) Float.parseFloat(runDb.getDistance()));
        String q3 = com.bxkj.student.run.app.utils.i.q(Integer.parseInt(runDb.getSportsType()));
        StringBuilder sb = new StringBuilder();
        sb.append("\u7cfb\u7edf\u68c0\u6d4b\u5230\u60a8\u67091\u6761\u5728");
        sb.append(format);
        sb.append("\u5f00\u59cb\u7684\u7684\u5df2\u8fd0\u52a8");
        sb.append(d4);
        sb.append("KM");
        sb.append(",\u7528\u65f6");
        sb.append(g4);
        sb.append("\u7684");
        sb.append(q3);
        sb.append("\u8bb0\u5f55\u5f02\u5e38\u7ed3\u675f,\u5f3a\u70c8\u5efa\u8bae\u60a8\u68c0\u67e5\u8fd0\u52a8\u6743\u9650\u8bbe\u7f6e\u662f\u5426\u6b63\u786e\u540e\u5c3d\u5feb\u6062\u590d\u7ee7\u7eed\u8dd1\u6b65");
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        this.f22267s = iostwobuttondialog;
        iostwobuttondialog.setClickAutoCancel(false);
        this.f22267s.setCancelable(false);
        this.f22267s.setCanceledOnTouchOutside(false);
        this.f22267s.setMessage(sb).setLeftButtonText("\u7ed3\u675f\u5e76\u4e0a\u4f20").setRightButtonText("\u6062\u590d\u7ee7\u7eed\u8dd1\u6b65").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.z
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                StartRunActivity.this.m1(runDb);
            }
        }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.b0
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                StartRunActivity.this.n1(runDb);
            }
        }).show();
    }

    private void t1(List<RunDb> runDbs1) {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        this.f22268t = iostwobuttondialog;
        iostwobuttondialog.setMessage("\u7cfb\u7edf\u68c0\u6d4b\u5230\u60a8\u8fd8\u6709" + runDbs1.size() + "\u6761\u8dd1\u6b65\u8bb0\u5f55\u5728\u672c\u5730\u6682\u5b58,\u662f\u5426\u4e0a\u4f20\uff1f").setLeftButtonText("\u6682\u5b58\u672c\u5730").setRightButtonText("\u73b0\u5728\u4e0a\u4f20").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.a0
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                StartRunActivity.this.o1();
            }
        }).show();
    }

    private void u1() {
        new l.b(this).c("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION").d(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(@RunType int runType) {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).o(runType, LoginUser.getLoginUser().getUserId())).setDataListener(new h(runType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(RunDb runDb, iOSTwoButtonDialog exceptionDialog, int uploadType) {
        long parseLong = Long.parseLong(runDb.getCountTime());
        this.f22269u.C(runDb, new b(Float.parseFloat(runDb.getDistance()), parseLong, runDb, uploadType, exceptionDialog));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427641;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (com.bxkj.base.util.y.a(this.f1656h, LocationService.class.getName())) {
            com.orhanobut.logger.j.c("LocationService----------isServiceRunning");
            stopService(new Intent(this.f1656h, LocationService.class));
        }
        if (com.bxkj.base.util.y.a(this.f1656h, StepService.class.getName())) {
            com.orhanobut.logger.j.c("StepService----------isServiceRunning");
            stopService(new Intent(this.f1656h, StepService.class));
        }
        this.f22261m.setOnClickListener(this);
        e1();
        q1();
        r1();
        this.f22263o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartRunActivity.this.k1(view);
            }
        });
        c1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("App\u8dd1\u6b65");
        f0(ContextCompat.getColor(this, 2131034196));
        b0(2131558869, new BaseActivity.c() { // from class: com.bxkj.student.run.app.y
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                StartRunActivity.this.l1();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f1656h = this;
        this.f22261m = (Button) findViewById(2131231012);
        MapView mapView = (MapView) findViewById(2131232258);
        this.f22259k = mapView;
        mapView.onCreate(savedInstanceState);
        this.f22260l = this.f22259k.getMap();
        this.f22263o = (ViewSwitcher) findViewById(2131233300);
        this.f22269u = (RunVM) new ViewModelProvider(this).get(RunVM.class);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        RunTypeDialog runTypeDialog = this.f22262n;
        if (runTypeDialog != null && runTypeDialog.isShowing()) {
            com.bxkj.student.run.app.utils.j.d(this);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (!LoginUser.getLoginUser().isLogin()) {
            this.f1656h.startActivity(new Intent(this.f1656h, LoginActivity.class));
        } else if (v3.getId() != 2131231012) {
        } else {
            if (EmulatorDetectUtil.b(this.f1656h)) {
                new iOSOneButtonDialog(this.f1656h).setMessage("\u7cfb\u7edf\u68c0\u67e5\u5230\u5f53\u524d\u8fd0\u884c\u73af\u5883\u4e3a\u6a21\u62df\u5668\uff0c\u8bf7\u4f7f\u7528\u771f\u673a\u8fdb\u884c\u8dd1\u6b65").show();
            } else {
                u1();
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f22259k.onDestroy();
        super.onDestroy();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f22259k.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f22259k.onResume();
        a1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.f22259k.onSaveInstanceState(outState);
    }

    public void p1() {
        e1();
    }

    public void v1(Map<String, Object> data) {
        RunTypeDialog r3 = new RunTypeDialog(this).u(JsonParse.getInt(data, "morningRun", 1) == 0).v(JsonParse.getInt(data, "sunRun", 1) == 0).s(JsonParse.getInt(data, "freedom", 1) == 0).t(JsonParse.getInt(data, "marathonRun", 1) == 0, JsonParse.getString(data, "marathonRunName")).r(new g());
        this.f22262n = r3;
        r3.show();
    }
}
