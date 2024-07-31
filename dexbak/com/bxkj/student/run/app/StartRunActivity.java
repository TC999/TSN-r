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
import androidx.core.view.ViewCompat;
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
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3919y;
import com.bxkj.base.util.NotificationsUtils;
import com.bxkj.base.util.SystemUtils;
import com.bxkj.base.view.ViewSwitcher;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.utils.SQZSManager;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.location.service.LocationService;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.p092my.MyRunActivity;
import com.bxkj.student.run.app.p093vm.RunVM;
import com.bxkj.student.run.app.ready.RunDescriptionActivity;
import com.bxkj.student.run.app.ready.RunRoleSetBean;
import com.bxkj.student.run.app.ready.RunType;
import com.bxkj.student.run.app.ready.RunTypeDialog;
import com.bxkj.student.run.app.record.Card;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.step.service.StepService;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.bxkj.student.run.app.utils.IntentWrapper;
import com.kuaishou.weapon.p205p0.C7282g;
import com.orhanobut.logger.C11792j;
import com.snail.antifake.jni.EmulatorDetectUtil;
import com.umeng.socialize.common.SocializeConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import p615l.RequestPermission;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StartRunActivity extends BaseActivity {

    /* renamed from: k */
    private MapView f19013k;

    /* renamed from: l */
    private AMap f19014l;

    /* renamed from: m */
    private Button f19015m;

    /* renamed from: n */
    private RunTypeDialog f19016n;

    /* renamed from: o */
    private ViewSwitcher f19017o;

    /* renamed from: p */
    private Card f19018p;

    /* renamed from: q */
    private Card f19019q;

    /* renamed from: r */
    private Card f19020r;

    /* renamed from: s */
    private iOSTwoButtonDialog f19021s;

    /* renamed from: t */
    private iOSTwoButtonDialog f19022t;

    /* renamed from: u */
    private RunVM f19023u = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.StartRunActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5194a extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ RunDb f19024a;

        C5194a(final RunDb val$runDb) {
            this.f19024a = val$runDb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m40131b(RunDb runDb, View view) {
            StartRunActivity startRunActivity = StartRunActivity.this;
            startRunActivity.m40135x1(runDb, startRunActivity.f19021s, 3);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            StartRunActivity.this.f19021s.dismiss();
            if (status == 201) {
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h);
                iosonebuttondialog.setCanceledOnTouchOutside(false);
                iosonebuttondialog.setCancelable(false);
                final RunDb runDb = this.f19024a;
                iosonebuttondialog.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.g0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.C5194a.this.m40131b(runDb, view);
                    }
                });
                iosonebuttondialog.setMessage(msg).show();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StartRunActivity.this.f19021s.dismiss();
            Intent intent = new Intent();
            intent.putExtra("runExceptionDataDBId", this.f19024a.getIdentify());
            intent.setClass(((BaseActivity) StartRunActivity.this).f1669h, RunningActivity.class);
            StartRunActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.StartRunActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5195b implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        final /* synthetic */ float f19026a;

        /* renamed from: b */
        final /* synthetic */ long f19027b;

        /* renamed from: c */
        final /* synthetic */ RunDb f19028c;

        /* renamed from: d */
        final /* synthetic */ int f19029d;

        /* renamed from: e */
        final /* synthetic */ iOSTwoButtonDialog f19030e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.run.app.StartRunActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C5196a extends HttpCallBack {
            C5196a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: d */
            public /* synthetic */ void m40126d(View view) {
                StartRunActivity.this.m40174a1();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: e */
            public /* synthetic */ void m40125e(View view) {
                StartRunActivity.this.m40174a1();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: f */
            public /* synthetic */ void m40124f(View view) {
                StartRunActivity.this.m40174a1();
            }

            /* renamed from: g */
            private void m40123g(String msg) {
                iOSTwoButtonDialog iostwobuttondialog = C5195b.this.f19030e;
                if (iostwobuttondialog != null) {
                    iostwobuttondialog.dismiss();
                }
                StartRunActivity.this.m40151p1();
                StartRunActivity.this.f19023u.m39504u(C5195b.this.f19028c.getIdentify());
                new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.i0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.C5195b.C5196a.this.m40124f(view);
                    }
                }).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnFailure(Throwable e) {
                iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setMessage("提交异常，已为您暂存本地，请稍后在本地跑步记录中重新上传！");
                message.setCanceledOnTouchOutside(false);
                message.setCancelable(false);
                message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.j0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.C5195b.C5196a.this.m40126d(view);
                    }
                });
                message.show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                if (status == 202) {
                    m40123g(msg);
                } else {
                    netOnFailure(new Exception("上传失败"));
                }
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data, String msg) {
                super.netOnSuccess(data, msg);
                m40123g(msg);
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccessServerError(int code, String errorMessage) {
                super.netOnSuccessServerError(code, errorMessage);
                iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setMessage("提交异常，已为您暂存本地，请稍后在本地跑步记录中重新上传！");
                message.setCanceledOnTouchOutside(false);
                message.setCancelable(false);
                message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.h0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StartRunActivity.C5195b.C5196a.this.m40125e(view);
                    }
                });
                message.show();
            }
        }

        C5195b(final float val$distance, final long val$countTime, final RunDb val$runDb, final int val$uploadType, final iOSTwoButtonDialog val$exceptionDialog) {
            this.f19026a = val$distance;
            this.f19027b = val$countTime;
            this.f19028c = val$runDb;
            this.f19029d = val$uploadType;
            this.f19030e = val$exceptionDialog;
        }

        @Override // p617l1.InterfaceC15269a
        /* renamed from: a */
        public Unit invoke() {
            Http.with(((BaseActivity) StartRunActivity.this).f1669h).setLoadingMessage("正在上传...").hideLoadingDialog().setCanCancel(false).hideSuccessMessage().hideFailMessage().setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40104q(LoginUser.getLoginUser().getUserId(), Integer.parseInt(this.f19028c.getSportsType()), Long.parseLong(this.f19028c.getStartTime()), Long.parseLong(this.f19028c.getEndTime()), TextUtils.isEmpty(this.f19028c.getLatLngList()) ? null : this.f19028c.getLatLngList(), this.f19028c.getIdentify(), FormatUtils.m39630g(this.f19027b), FormatUtils.m39633d(this.f19026a), FormatUtils.m39636a(this.f19026a, this.f19027b), FormatUtils.m39635b(this.f19026a, this.f19027b), TextUtils.isEmpty(this.f19028c.getPassLatLngList()) ? null : this.f19028c.getPassLatLngList(), SystemUtils.m44002d(), SystemUtils.m44001e(), "Android", SystemUtils.m44003c(), SystemUtils.m43998h(((BaseActivity) StartRunActivity.this).f1669h), this.f19028c.getStepList(), this.f19028c.isFaceOut(), TextUtils.isEmpty(this.f19028c.getPassLatLngList()) ? null : this.f19028c.getPassLatLngList(), Integer.valueOf(this.f19029d), null)).setDataListener(new C5196a());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.StartRunActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5197c implements RequestPermission.InterfaceC15268a {
        C5197c() {
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: a */
        public void mo3478a(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setMessage(StartRunActivity.this.getString(C4215R.C4224string.run_permission_hint)).show();
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: b */
        public void mo3477b() {
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: c */
        public void mo3476c(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setMessage(StartRunActivity.this.getString(C4215R.C4224string.run_permission_hint)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.StartRunActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5198d implements iOSTwoButtonDialog.RightButtonOnClick {
        C5198d() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            NotificationsUtils.m44050b(((BaseActivity) StartRunActivity.this).f1670i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.StartRunActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5199e implements RequestPermission.InterfaceC15268a {
        C5199e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void m40121e() {
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            StartRunActivity.this.startActivity(intent);
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: a */
        public void mo3478a(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setMessage(StartRunActivity.this.getString(C4215R.C4224string.run_permission_hint)).show();
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: b */
        public void mo3477b() {
            if (!((LocationManager) StartRunActivity.this.getSystemService(SocializeConstants.KEY_LOCATION)).isProviderEnabled(GeocodeSearch.GPS)) {
                new iOSTwoButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setTitle("GPS未开启").setMessage(StartRunActivity.this.getString(C4215R.C4224string.run_request_location)).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.k0
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        StartRunActivity.C5199e.this.m40121e();
                    }
                }).show();
            } else {
                StartRunActivity.this.m40173b1();
            }
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: c */
        public void mo3476c(@NonNull String[] strings) {
            new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setMessage(StartRunActivity.this.getString(C4215R.C4224string.run_permission_hint)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.StartRunActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5200f extends HttpCallBack {
        C5200f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StartRunActivity.this.m40139v1(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.StartRunActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5201g implements RunTypeDialog.InterfaceC5309a {
        C5201g() {
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.InterfaceC5309a
        /* renamed from: a */
        public void mo39891a() {
            StartRunActivity.this.m40137w1(4);
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.InterfaceC5309a
        /* renamed from: b */
        public void mo39890b() {
            StartRunActivity.this.m40137w1(3);
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.InterfaceC5309a
        /* renamed from: c */
        public void mo39889c() {
            StartRunActivity.this.m40137w1(1);
        }

        @Override // com.bxkj.student.run.app.ready.RunTypeDialog.InterfaceC5309a
        /* renamed from: d */
        public void mo39888d() {
            StartRunActivity.this.m40137w1(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.StartRunActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5202h extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ int f19038a;

        C5202h(final int val$runType) {
            this.f19038a = val$runType;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                RunRoleSetBean.DataBean dataBean = (RunRoleSetBean.DataBean) JSON.parseObject(JSON.toJSONString(data), RunRoleSetBean.DataBean.class);
                dataBean.setRunType(this.f19038a);
                Intent intent = new Intent(((BaseActivity) StartRunActivity.this).f1669h, RunDescriptionActivity.class);
                intent.putExtra("dataBean", dataBean);
                StartRunActivity.this.startActivity(intent);
                StartRunActivity.this.overridePendingTransition(2130771987, 2130771986);
            } catch (Exception e) {
                e.printStackTrace();
                new iOSOneButtonDialog(((BaseActivity) StartRunActivity.this).f1669h).setMessage("跑步设置异常,请联系管理员").show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.StartRunActivity$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5203i extends HttpCallBack {
        C5203i() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Map<String, Object> map = JsonParse.getMap(data, "morningRun");
            if (map != null && !map.isEmpty()) {
                int i = JsonParse.getInt(map, "succeed");
                double d = JsonParse.getDouble(map, "runSportRange");
                int i2 = JsonParse.getInt(map, "isShow");
                if (StartRunActivity.this.f19018p == null && i2 == 1) {
                    StartRunActivity.this.f19018p = new Card(((BaseActivity) StartRunActivity.this).f1669h).m39859i(1).m39860h(ContextCompat.getColor(((BaseActivity) StartRunActivity.this).f1669h, C4215R.C4217color.card1));
                    StartRunActivity.this.f19017o.addView(StartRunActivity.this.f19018p);
                }
                if (StartRunActivity.this.f19018p != null) {
                    StartRunActivity.this.f19018p.setCount(i);
                    StartRunActivity.this.f19018p.setDistance(d);
                }
            }
            Map<String, Object> map2 = JsonParse.getMap(data, "sunRun");
            if (map2 != null && !map2.isEmpty()) {
                int i3 = JsonParse.getInt(map2, "succeed");
                double d2 = JsonParse.getDouble(map2, "runSportRange");
                int i4 = JsonParse.getInt(map2, "isShow");
                if (StartRunActivity.this.f19019q == null && i4 == 1) {
                    StartRunActivity.this.f19019q = new Card(((BaseActivity) StartRunActivity.this).f1669h).m39859i(2).m39860h(ContextCompat.getColor(((BaseActivity) StartRunActivity.this).f1669h, C4215R.C4217color.card2));
                    StartRunActivity.this.f19017o.addView(StartRunActivity.this.f19019q);
                }
                if (StartRunActivity.this.f19019q != null) {
                    StartRunActivity.this.f19019q.setCount(i3);
                    StartRunActivity.this.f19019q.setDistance(d2);
                }
            }
            Map<String, Object> map3 = JsonParse.getMap(data, "freedom");
            if (map3 == null || map3.isEmpty()) {
                return;
            }
            int i5 = JsonParse.getInt(map3, "succeed");
            double d3 = JsonParse.getDouble(map3, "runSportRange");
            int i6 = JsonParse.getInt(map3, "isShow");
            if (StartRunActivity.this.f19020r == null && i6 == 1) {
                StartRunActivity.this.f19020r = new Card(((BaseActivity) StartRunActivity.this).f1669h).m39859i(3).m39860h(ContextCompat.getColor(((BaseActivity) StartRunActivity.this).f1669h, C4215R.C4217color.card3));
                StartRunActivity.this.f19017o.addView(StartRunActivity.this.f19020r);
            }
            if (StartRunActivity.this.f19020r != null) {
                StartRunActivity.this.f19020r.setCount(i5);
                StartRunActivity.this.f19020r.setDistance(d3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public void m40174a1() {
        iOSTwoButtonDialog iostwobuttondialog = this.f19021s;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f19021s.dismiss();
        }
        iOSTwoButtonDialog iostwobuttondialog2 = this.f19022t;
        if (iostwobuttondialog2 != null && iostwobuttondialog2.isShowing()) {
            this.f19022t.dismiss();
        }
        if (this.f19023u == null) {
            return;
        }
        final LoadingDialog loadingDialog = new LoadingDialog(this.f1669h);
        loadingDialog.show();
        this.f19023u.m39499z(new InterfaceC15280l() { // from class: com.bxkj.student.run.app.f0
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m40167h1;
                m40167h1 = StartRunActivity.this.m40167h1(loadingDialog, (List) obj);
                return m40167h1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b1 */
    public void m40173b1() {
        final LoadingDialog loadingDialog = new LoadingDialog(this.f1670i);
        loadingDialog.show();
        SQZSManager.f20133a.m39066c(this.f1670i, new InterfaceC15269a() { // from class: com.bxkj.student.run.app.d0
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m40165i1;
                m40165i1 = StartRunActivity.this.m40165i1(loadingDialog);
                return m40165i1;
            }
        }, new InterfaceC15269a() { // from class: com.bxkj.student.run.app.c0
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m40163j1;
                m40163j1 = StartRunActivity.m40163j1(LoadingDialog.this);
                return m40163j1;
            }
        });
    }

    /* renamed from: c1 */
    private void m40172c1() {
        if (Build.VERSION.SDK_INT < 21 || !((PowerManager) getSystemService("power")).isPowerSaveMode() || isFinishing()) {
            return;
        }
        new iOSOneButtonDialog(this.f1669h).setMessage("开始跑步前请关闭省电模式，否则轨迹记录可能不准确！").show();
    }

    /* renamed from: d1 */
    public static boolean m40171d1(String source, String dest) {
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

    /* renamed from: e1 */
    private void m40170e1() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40108m(LoginUser.getLoginUser().getUserId())).setDataListener(new C5203i());
        }
    }

    /* renamed from: f1 */
    private void m40169f1() {
        Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40120a(LoginUser.getLoginUser().getUserId())).setDataListener(new C5200f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ Unit m40168g1(LoadingDialog loadingDialog, List list) {
        loadingDialog.dismiss();
        if (list == null || list.size() <= 0) {
            return null;
        }
        m40143t1(list);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ Unit m40167h1(final LoadingDialog loadingDialog, List list) {
        loadingDialog.dismiss();
        if (list != null && list.size() > 0) {
            m40145s1((RunDb) list.get(0));
            return null;
        }
        loadingDialog.show();
        this.f19023u.m39508A(new InterfaceC15280l() { // from class: com.bxkj.student.run.app.e0
            @Override // p617l1.InterfaceC15280l
            public final Object invoke(Object obj) {
                Unit m40168g1;
                m40168g1 = StartRunActivity.this.m40168g1(loadingDialog, (List) obj);
                return m40168g1;
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ Unit m40165i1(LoadingDialog loadingDialog) {
        loadingDialog.dismiss();
        m40169f1();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1 */
    public static /* synthetic */ Unit m40163j1(LoadingDialog loadingDialog) {
        loadingDialog.dismiss();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void m40161k1(View view) {
        startActivity(new Intent(this.f1669h, RunRecorderListActivity.class).putExtra("runType", ((Card) view).getRunType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1 */
    public /* synthetic */ void m40159l1() {
        startActivity(new Intent(this.f1669h, MyRunActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void m40157m1(RunDb runDb) {
        m40135x1(runDb, this.f19021s, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ void m40155n1(RunDb runDb) {
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40116e(runDb.getIdentify())).setDataListener(new C5194a(runDb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public /* synthetic */ void m40153o1() {
        startActivity(new Intent(this.f1669h, RunRecorderListActivity.class));
    }

    /* renamed from: q1 */
    private void m40149q1() {
        new RequestPermission(this).m3480c(C7282g.f24950h, C7282g.f24949g).m3479d(new C5197c());
        if (Build.VERSION.SDK_INT < 19 || NotificationsUtils.m44051a(this.f1669h)) {
            return;
        }
        new iOSTwoButtonDialog(this.f1669h).setMessage("为了能够让你在跑步过程中不错过重要的通知消息,强烈建议你开始允许推送通知功能").setRightButtonOnClickListener(new C5198d()).setLeftButtonText("不了").setRightButtonText("去开启").show();
    }

    /* renamed from: r1 */
    private void m40147r1() {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.location_marker));
        myLocationStyle.strokeColor(ViewCompat.MEASURED_STATE_MASK);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        this.f19014l.setMyLocationStyle(myLocationStyle);
        this.f19014l.getUiSettings().setMyLocationButtonEnabled(true);
        this.f19014l.setMyLocationEnabled(true);
        this.f19014l.moveCamera(CameraUpdateFactory.zoomTo(19.0f));
    }

    /* renamed from: s1 */
    private void m40145s1(final RunDb runDb) {
        C11792j.m20470c("runExceptionDataDB=" + runDb.toString());
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(Long.parseLong(runDb.getStartTime())));
        String m39630g = FormatUtils.m39630g(Long.parseLong(runDb.getCountTime()));
        String m39633d = FormatUtils.m39633d((double) Float.parseFloat(runDb.getDistance()));
        String m39620q = FormatUtils.m39620q(Integer.parseInt(runDb.getSportsType()));
        StringBuilder sb = new StringBuilder();
        sb.append("系统检测到您有1条在");
        sb.append(format);
        sb.append("开始的的已运动");
        sb.append(m39633d);
        sb.append("KM");
        sb.append(",用时");
        sb.append(m39630g);
        sb.append("的");
        sb.append(m39620q);
        sb.append("记录异常结束,强烈建议您检查运动权限设置是否正确后尽快恢复继续跑步");
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        this.f19021s = iostwobuttondialog;
        iostwobuttondialog.setClickAutoCancel(false);
        this.f19021s.setCancelable(false);
        this.f19021s.setCanceledOnTouchOutside(false);
        this.f19021s.setMessage(sb).setLeftButtonText("结束并上传").setRightButtonText("恢复继续跑步").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.run.app.z
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                StartRunActivity.this.m40157m1(runDb);
            }
        }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.b0
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                StartRunActivity.this.m40155n1(runDb);
            }
        }).show();
    }

    /* renamed from: t1 */
    private void m40143t1(List<RunDb> runDbs1) {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        this.f19022t = iostwobuttondialog;
        iostwobuttondialog.setMessage("系统检测到您还有" + runDbs1.size() + "条跑步记录在本地暂存,是否上传？").setLeftButtonText("暂存本地").setRightButtonText("现在上传").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.run.app.a0
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                StartRunActivity.this.m40153o1();
            }
        }).show();
    }

    /* renamed from: u1 */
    private void m40141u1() {
        new RequestPermission(this).m3480c(C7282g.f24950h, C7282g.f24949g).m3479d(new C5199e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1 */
    public void m40137w1(@RunType int runType) {
        Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40106o(runType, LoginUser.getLoginUser().getUserId())).setDataListener(new C5202h(runType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x1 */
    public void m40135x1(RunDb runDb, iOSTwoButtonDialog exceptionDialog, int uploadType) {
        long parseLong = Long.parseLong(runDb.getCountTime());
        this.f19023u.m39506C(runDb, new C5195b(Float.parseFloat(runDb.getDistance()), parseLong, runDb, uploadType, exceptionDialog));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.fm_run;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (C3919y.m44006a(this.f1669h, LocationService.class.getName())) {
            C11792j.m20470c("LocationService----------isServiceRunning");
            stopService(new Intent(this.f1669h, LocationService.class));
        }
        if (C3919y.m44006a(this.f1669h, StepService.class.getName())) {
            C11792j.m20470c("StepService----------isServiceRunning");
            stopService(new Intent(this.f1669h, StepService.class));
        }
        this.f19015m.setOnClickListener(this);
        m40170e1();
        m40149q1();
        m40147r1();
        this.f19017o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartRunActivity.this.m40161k1(view);
            }
        });
        m40172c1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("App跑步");
        m57921f0(ContextCompat.getColor(this, 2131034196));
        m57925b0(2131558869, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.run.app.y
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                StartRunActivity.this.m40159l1();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f1669h = this;
        this.f19015m = (Button) findViewById(C4215R.C4219id.bt_start);
        MapView mapView = (MapView) findViewById(C4215R.C4219id.map);
        this.f19013k = mapView;
        mapView.onCreate(savedInstanceState);
        this.f19014l = this.f19013k.getMap();
        this.f19017o = (ViewSwitcher) findViewById(C4215R.C4219id.viewSwitcher);
        this.f19023u = (RunVM) new ViewModelProvider(this).get(RunVM.class);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        RunTypeDialog runTypeDialog = this.f19016n;
        if (runTypeDialog != null && runTypeDialog.isShowing()) {
            IntentWrapper.m39612d(this);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (!LoginUser.getLoginUser().isLogin()) {
            this.f1669h.startActivity(new Intent(this.f1669h, LoginActivity.class));
        } else if (v.getId() != 2131231012) {
        } else {
            if (EmulatorDetectUtil.m19668b(this.f1669h)) {
                new iOSOneButtonDialog(this.f1669h).setMessage("系统检查到当前运行环境为模拟器，请使用真机进行跑步").show();
            } else {
                m40141u1();
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f19013k.onDestroy();
        super.onDestroy();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f19013k.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f19013k.onResume();
        m40174a1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.f19013k.onSaveInstanceState(outState);
    }

    /* renamed from: p1 */
    public void m40151p1() {
        m40170e1();
    }

    /* renamed from: v1 */
    public void m40139v1(Map<String, Object> data) {
        RunTypeDialog m39899r = new RunTypeDialog(this).m39896u(JsonParse.getInt(data, "morningRun", 1) == 0).m39895v(JsonParse.getInt(data, "sunRun", 1) == 0).m39898s(JsonParse.getInt(data, "freedom", 1) == 0).m39897t(JsonParse.getInt(data, "marathonRun", 1) == 0, JsonParse.getString(data, "marathonRunName")).m39899r(new C5201g());
        this.f19016n = m39899r;
        m39899r.show();
    }
}
