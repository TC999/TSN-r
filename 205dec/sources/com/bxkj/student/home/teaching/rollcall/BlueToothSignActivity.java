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
import com.bxkj.student.home.teaching.rollcall.BlueToothSignActivity;
import com.bxkj.student.run.app.utils.y;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import l.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BlueToothSignActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private QRCodeView f21244k;

    /* renamed from: l  reason: collision with root package name */
    private WaveView f21245l;

    /* renamed from: m  reason: collision with root package name */
    private final int f21246m = 2561;

    /* renamed from: n  reason: collision with root package name */
    private BluetoothLeScanner f21247n;

    /* renamed from: o  reason: collision with root package name */
    private String f21248o;

    /* renamed from: p  reason: collision with root package name */
    private String f21249p;

    /* renamed from: q  reason: collision with root package name */
    private String f21250q;

    /* renamed from: r  reason: collision with root package name */
    private String f21251r;

    /* renamed from: s  reason: collision with root package name */
    private ScanCallback f21252s;

    /* renamed from: t  reason: collision with root package name */
    private String f21253t;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements b.a {
        a() {
        }

        @Override // l.b.a
        public void a(String... permission) {
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1656h).setMessage("\u60a8\u62d2\u7edd\u4e86\u5b9a\u4f4d\u6743\u9650,\u65e0\u6cd5\u8fdb\u884c\u84dd\u7259\u7b7e\u5230,\u8bf7\u5728(\u8bbe\u7f6e->\u5e94\u7528\u2014>\u4f53\u9002\u80fd->\u6743\u9650\u7ba1\u7406->\u83b7\u53d6\u5b9a\u4f4d)\u8bbe\u7f6e\u5141\u8bb8\u5b9a\u4f4d\u540e\u518d\u8fdb\u884c\u84dd\u7259\u7b7e\u5230").show();
        }

        @Override // l.b.a
        public void b() {
            BlueToothSignActivity.this.I0();
            if (Build.VERSION.SDK_INT >= 21) {
                BlueToothSignActivity.this.G0();
            } else {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1656h).setMessage("\u60a8\u7684\u624b\u673a\u4e0d\u652f\u6301\u84dd\u7259\u7b7e\u5230,\u8bf7\u8054\u7cfb\u8001\u5e08\u624b\u52a8\u7b7e\u5230").show();
            }
        }

        @Override // l.b.a
        public void c(String... permission) {
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1656h).setMessage("\u60a8\u62d2\u7edd\u4e86\u5b9a\u4f4d\u6743\u9650,\u65e0\u6cd5\u8fdb\u884c\u84dd\u7259\u7b7e\u5230,\u8bf7\u5728(\u8bbe\u7f6e->\u5e94\u7528\u2014>\u4f53\u9002\u80fd->\u6743\u9650\u7ba1\u7406->\u83b7\u53d6\u5b9a\u4f4d)\u8bbe\u7f6e\u5141\u8bb8\u5b9a\u4f4d\u540e\u518d\u8fdb\u884c\u84dd\u7259\u7b7e\u5230").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            BlueToothSignActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1656h).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BlueToothSignActivity.b.this.b(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BlueToothSignActivity.this.f21248o = JsonParse.getString(data, "Identify");
            BlueToothSignActivity.this.f21249p = JsonParse.getString(data, "teachingClockingin");
            BlueToothSignActivity.this.f21250q = JsonParse.getString(data, "stuTeacherCurriculum");
            BlueToothSignActivity.this.f21251r = JsonParse.getString(data, "weekNum");
            BlueToothSignActivity.this.K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements QRCodeView.f {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            BlueToothSignActivity.this.f21244k.C();
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
        public void D() {
            Toast.makeText(((BaseActivity) BlueToothSignActivity.this).f1656h, "\u6253\u5f00\u76f8\u673a\u51fa\u9519", 0).show();
            com.orhanobut.logger.j.e("\u6253\u5f00\u76f8\u673a\u51fa\u9519", new Object[0]);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
        @RequiresApi(api = 18)
        public void H(String result) {
            com.orhanobut.logger.j.c("result:" + result);
            Context context = ((BaseActivity) BlueToothSignActivity.this).f1656h;
            Toast.makeText(context, "\u5b66\u53f7\uff1a" + result, 0).show();
            y.g(((BaseActivity) BlueToothSignActivity.this).f1656h, 2131755010);
            BlueToothSignActivity.this.f21244k.F();
            new Handler().postDelayed(new Runnable() { // from class: com.bxkj.student.home.teaching.rollcall.i
                @Override // java.lang.Runnable
                public final void run() {
                    BlueToothSignActivity.c.this.c();
                }
            }, 3000L);
            BlueToothSignActivity.this.J0(result);
        }

        @Override // cn.bingoogolapple.qrcode.core.QRCodeView.f
        public void b(boolean isDark) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends ScanCallback {
        d() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> results) {
            com.orhanobut.logger.j.c("results=" + results);
            super.onBatchScanResults(results);
            com.orhanobut.logger.j.c("results=" + results);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
            com.orhanobut.logger.j.c("errorCode=" + errorCode);
            new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1656h).setMessage("\u7b7e\u5230\u5931\u8d25,\u8bf7\u91cd\u65b0\u518d\u8bd5").show();
        }

        @Override // android.bluetooth.le.ScanCallback
        @RequiresApi(api = 21)
        public void onScanResult(int callbackType, ScanResult re) {
            com.orhanobut.logger.j.c("callbackType=" + callbackType + "\nre=" + re.toString());
            super.onScanResult(callbackType, re);
            try {
                BlueToothSignActivity.this.f21247n.stopScan(this);
                com.orhanobut.logger.j.c("callbackType=" + callbackType + "\nre=" + re.toString());
                List<ParcelUuid> serviceUuids = re.getScanRecord().getServiceUuids();
                if (re.getScanRecord() == null || serviceUuids == null) {
                    return;
                }
                for (ParcelUuid parcelUuid : serviceUuids) {
                    if (parcelUuid.toString().equalsIgnoreCase(BlueToothSignActivity.this.f21248o)) {
                        BlueToothSignActivity.this.L0();
                        return;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                BlueToothSignActivity.this.finish();
            }
        }

        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            try {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1656h).setMessage("\u7b7e\u5230\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u518d\u8bd5").show();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            try {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1656h).setMessage("\u7b7e\u5230\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u518d\u8bd5").show();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            try {
                new iOSOneButtonDialog(((BaseActivity) BlueToothSignActivity.this).f1656h).setMessage("\u7b7e\u5230\u6210\u529f").setButtonOnClickListener(new a()).show();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static String F0(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 18)
    public void G0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).i0(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    private void H0() {
        ZBarView zBarView = (ZBarView) findViewById(2131233335);
        this.f21244k = zBarView;
        zBarView.setDelegate(new c());
        this.f21244k.z();
        this.f21244k.x();
        this.f21244k.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        WaveView waveView = (WaveView) findViewById(2131233314);
        this.f21245l = waveView;
        waveView.setStyle(Paint.Style.FILL);
        this.f21245l.setColor(ContextCompat.getColor(this.f1656h, 2131034172));
        this.f21245l.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 18)
    public void K0() {
        BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        if (adapter != null && adapter.isEnabled()) {
            M0();
        } else {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2561);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 21)
    public void L0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).A1(this.f21249p, this.f21250q, this.f21251r, this.f21253t, LoginUser.getLoginUser().getSchoolId())).setDataListener(new e());
    }

    private void M0() {
        if (Build.VERSION.SDK_INT >= 21) {
            BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
            this.f21253t = F0(this.f1656h);
            com.orhanobut.logger.j.c("bluetoothAddress=" + this.f21253t);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(this.f21248o)).build());
            ScanSettings build = new ScanSettings.Builder().setScanMode(2).build();
            this.f21252s = new d();
            BluetoothLeScanner bluetoothLeScanner = adapter.getBluetoothLeScanner();
            this.f21247n = bluetoothLeScanner;
            bluetoothLeScanner.startScan(arrayList, build, this.f21252s);
            return;
        }
        new iOSOneButtonDialog(this.f1656h).setMessage("\u60a8\u7684\u624b\u673a\u4e0d\u652f\u6301\u84dd\u7259\u70b9\u540d,\u8bf7\u8054\u7cfb\u4e0a\u8bfe\u8001\u5e08\u624b\u52a8\u70b9\u540d").show();
    }

    public String E0() {
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
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
        }
        return null;
    }

    @RequiresApi(api = 18)
    public void J0(String number) {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427492;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    @RequiresApi(api = 18)
    public void T() {
        new l.b(this.f1657i).c("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION").d(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4e0a\u8bfe\u7b7e\u5230");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 2561) {
            com.orhanobut.logger.j.c("\u6253\u5f00\u84dd\u7259\u5f02\u5e38\uff01");
        } else if (resultCode == -1) {
            com.orhanobut.logger.j.c("\u6253\u5f00\u84dd\u7259\u6210\u529f\uff01");
            M0();
        } else {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u6253\u5f00\u84dd\u7259\u5931\u8d25,\u5c06\u65e0\u6cd5\u7b7e\u5230").show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @RequiresApi(api = 21)
    public void onDestroy() {
        QRCodeView qRCodeView = this.f21244k;
        if (qRCodeView != null) {
            qRCodeView.o();
        }
        WaveView waveView = this.f21245l;
        if (waveView != null) {
            waveView.l();
        }
        BluetoothLeScanner bluetoothLeScanner = this.f21247n;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(this.f21252s);
        }
        super.onDestroy();
    }
}
