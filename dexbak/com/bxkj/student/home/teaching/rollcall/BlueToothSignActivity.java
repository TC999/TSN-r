package com.bxkj.student.home.teaching.rollcall;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.WaveView;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.rollcall.BlueToothSignActivity;
import com.bxkj.student.run.app.utils.SoundManagerUtil;
import com.kuaishou.weapon.p205p0.C7282g;
import com.orhanobut.logger.C11792j;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p615l.RequestPermission;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BlueToothSignActivity extends BaseActivity {

    /* renamed from: k */
    private QRCodeView f17906k;

    /* renamed from: l */
    private WaveView f17907l;

    /* renamed from: m */
    private final int f17908m = 2561;

    /* renamed from: n */
    private BluetoothLeScanner f17909n;

    /* renamed from: o */
    private String f17910o;

    /* renamed from: p */
    private String f17911p;

    /* renamed from: q */
    private String f17912q;

    /* renamed from: r */
    private String f17913r;

    /* renamed from: s */
    private ScanCallback f17914s;

    /* renamed from: t */
    private String f17915t;

    /* renamed from: com.bxkj.student.home.teaching.rollcall.BlueToothSignActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4834a implements RequestPermission.InterfaceC15268a {
        C4834a() {
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: a */
        public void mo3478a(String... permission) {
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1669h).setMessage("您拒绝了定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: b */
        public void mo3477b() {
            BlueToothSignActivity.this.m41220I0();
            if (Build.VERSION.SDK_INT >= 21) {
                BlueToothSignActivity.this.m41222G0();
            } else {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1669h).setMessage("您的手机不支持蓝牙签到,请联系老师手动签到").show();
            }
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: c */
        public void mo3476c(String... permission) {
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1669h).setMessage("您拒绝了定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BlueToothSignActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4835b extends HttpCallBack {
        C4835b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m41196b(View view) {
            BlueToothSignActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1669h).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BlueToothSignActivity.C4835b.this.m41196b(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BlueToothSignActivity.this.f17910o = JsonParse.getString(data, "Identify");
            BlueToothSignActivity.this.f17911p = JsonParse.getString(data, "teachingClockingin");
            BlueToothSignActivity.this.f17912q = JsonParse.getString(data, "stuTeacherCurriculum");
            BlueToothSignActivity.this.f17913r = JsonParse.getString(data, "weekNum");
            BlueToothSignActivity.this.m41218K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BlueToothSignActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4836c implements QRCodeView.InterfaceC1099f {
        C4836c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m41194c() {
            BlueToothSignActivity.this.f17906k.m58028C();
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
        /* renamed from: D */
        public void mo38629D() {
            Toast.makeText(((BaseActivity) BlueToothSignActivity.this).f1669h, "打开相机出错", 0).show();
            C11792j.m20468e("打开相机出错", new Object[0]);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
        @RequiresApi(api = 18)
        /* renamed from: H */
        public void mo38628H(String result) {
            C11792j.m20470c("result:" + result);
            Context context = ((BaseActivity) BlueToothSignActivity.this).f1669h;
            Toast.makeText(context, "学号：" + result, 0).show();
            SoundManagerUtil.m39512g(((BaseActivity) BlueToothSignActivity.this).f1669h, 2131755010);
            BlueToothSignActivity.this.f17906k.m58025F();
            new Handler().postDelayed(new Runnable() { // from class: com.bxkj.student.home.teaching.rollcall.i
                @Override // java.lang.Runnable
                public final void run() {
                    BlueToothSignActivity.C4836c.this.m41194c();
                }
            }, 3000L);
            BlueToothSignActivity.this.m41219J0(result);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.InterfaceC1099f
        /* renamed from: b */
        public void mo38627b(boolean isDark) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BlueToothSignActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4837d extends ScanCallback {
        C4837d() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> results) {
            C11792j.m20470c("results=" + results);
            super.onBatchScanResults(results);
            C11792j.m20470c("results=" + results);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            C11792j.m20470c("errorCode=" + errorCode);
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1669h).setMessage("签到失败,请重新再试").show();
        }

        @Override // android.bluetooth.le.ScanCallback
        @RequiresApi(api = 21)
        public void onScanResult(int callbackType, ScanResult re) {
            C11792j.m20470c("callbackType=" + callbackType + "\nre=" + re.toString());
            super.onScanResult(callbackType, re);
            try {
                BlueToothSignActivity.this.f17909n.stopScan(this);
                C11792j.m20470c("callbackType=" + callbackType + "\nre=" + re.toString());
                List<ParcelUuid> serviceUuids = re.getScanRecord().getServiceUuids();
                if (re.getScanRecord() == null || serviceUuids == null) {
                    return;
                }
                for (ParcelUuid parcelUuid : serviceUuids) {
                    if (parcelUuid.toString().equalsIgnoreCase(BlueToothSignActivity.this.f17910o)) {
                        BlueToothSignActivity.this.m41217L0();
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BlueToothSignActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4838e extends HttpCallBack {

        /* renamed from: com.bxkj.student.home.teaching.rollcall.BlueToothSignActivity$e$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4839a implements View.OnClickListener {
            View$OnClickListenerC4839a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BlueToothSignActivity.this.finish();
            }
        }

        C4838e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            try {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1669h).setMessage("签到失败，请重新再试").show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            try {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1669h).setMessage("签到失败，请重新再试").show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1669h).setMessage("签到成功").setButtonOnClickListener(new View$OnClickListenerC4839a()).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: F0 */
    public static String m41223F0(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 18)
    /* renamed from: G0 */
    public void m41222G0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m104i0(LoginUser.getLoginUser().getUserId())).setDataListener(new C4835b());
    }

    /* renamed from: H0 */
    private void m41221H0() {
        ZBarView zBarView = (ZBarView) findViewById(2131233335);
        this.f17906k = zBarView;
        zBarView.setDelegate(new C4836c());
        this.f17906k.m57999z();
        this.f17906k.m58001x();
        this.f17906k.m58028C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public void m41220I0() {
        WaveView waveView = (WaveView) findViewById(C4215R.C4219id.waveView);
        this.f17907l = waveView;
        waveView.setStyle(Paint.Style.FILL);
        this.f17907l.setColor(ContextCompat.getColor(this.f1669h, 2131034172));
        this.f17907l.m43490k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 18)
    /* renamed from: K0 */
    public void m41218K0() {
        BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        if (adapter != null && adapter.isEnabled()) {
            m41216M0();
        } else {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2561);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 21)
    /* renamed from: L0 */
    public void m41217L0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m187A1(this.f17911p, this.f17912q, this.f17913r, this.f17915t, LoginUser.getLoginUser().getSchoolId())).setDataListener(new C4838e());
    }

    /* renamed from: M0 */
    private void m41216M0() {
        if (Build.VERSION.SDK_INT >= 21) {
            BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
            this.f17915t = m41223F0(this.f1669h);
            C11792j.m20470c("bluetoothAddress=" + this.f17915t);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(this.f17910o)).build());
            ScanSettings build = new ScanSettings.Builder().setScanMode(2).build();
            this.f17914s = new C4837d();
            BluetoothLeScanner bluetoothLeScanner = adapter.getBluetoothLeScanner();
            this.f17909n = bluetoothLeScanner;
            bluetoothLeScanner.startScan(arrayList, build, this.f17914s);
            return;
        }
        new iOSOneButtonDialog(this.f1669h).setMessage("您的手机不支持蓝牙点名,请联系上课老师手动点名").show();
    }

    /* renamed from: E0 */
    public String m41224E0() {
        Method method;
        Object invoke;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            Field declaredField = BluetoothAdapter.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(defaultAdapter);
            if (obj != null && (method = obj.getClass().getMethod("getAddress", new Class[0])) != null && (invoke = method.invoke(obj, new Object[0])) != null) {
                return invoke.toString();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        return null;
    }

    @RequiresApi(api = 18)
    /* renamed from: J0 */
    public void m41219J0(String number) {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_sign;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    @RequiresApi(api = 18)
    /* renamed from: T */
    public void mo39374T() {
        new RequestPermission(this.f1670i).m3480c(C7282g.f24950h, C7282g.f24949g).m3479d(new C4834a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("上课签到");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 2561) {
            C11792j.m20470c("打开蓝牙异常！");
        } else if (resultCode == -1) {
            C11792j.m20470c("打开蓝牙成功！");
            m41216M0();
        } else {
            new iOSOneButtonDialog(this.f1669h).setMessage("打开蓝牙失败,将无法签到").show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @RequiresApi(api = 21)
    public void onDestroy() {
        QRCodeView qRCodeView = this.f17906k;
        if (qRCodeView != null) {
            qRCodeView.m58007o();
        }
        WaveView waveView = this.f17907l;
        if (waveView != null) {
            waveView.m43489l();
        }
        BluetoothLeScanner bluetoothLeScanner = this.f17909n;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(this.f17914s);
        }
        super.onDestroy();
    }
}
