package com.bxkj.student.p094v2.p098ui.p099h5.p100js;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Intent;
import android.os.Build;
import android.os.ParcelUuid;
import android.provider.Settings;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bxkj.base.p085v2.p086h5.GPSJS;
import com.bxkj.student.p094v2.p098ui.p099h5.p100js.BlueToothJS;
import com.clj.fastble.BleManager;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.scan.BleScanRuleConfig;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import java.util.List;
import java.util.UUID;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p589f0.BleScanCallback;
import p615l.RequestPermission;
import p617l1.InterfaceC15284p;
import p618m.StartActivityForResult;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\u0013\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/h5/js/a;", "Lcom/bxkj/base/v2/h5/c;", "", "identify", "Lkotlin/f1;", "n", "uuid", C7304t.f25048d, "m", "k", "openBluetooth", "closeBluetooth", "stuOpenBluetooth", "Landroidx/fragment/app/FragmentActivity;", "c", "Landroidx/fragment/app/FragmentActivity;", "()Landroidx/fragment/app/FragmentActivity;", "e", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroid/webkit/WebView;", "d", "Landroid/webkit/WebView;", "()Landroid/webkit/WebView;", "f", "(Landroid/webkit/WebView;)V", "mWebView", "Landroid/bluetooth/BluetoothGattServer;", "Landroid/bluetooth/BluetoothGattServer;", "bluetoothGattServer", "Landroid/bluetooth/le/BluetoothLeAdvertiser;", "Landroid/bluetooth/le/BluetoothLeAdvertiser;", "advertiser", "Landroid/bluetooth/le/AdvertiseCallback;", "g", "Landroid/bluetooth/le/AdvertiseCallback;", "advertiseCallback", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/webkit/WebView;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.h5.js.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BlueToothJS extends GPSJS {
    @NotNull

    /* renamed from: c */
    private FragmentActivity f20453c;
    @NotNull

    /* renamed from: d */
    private WebView f20454d;
    @Nullable

    /* renamed from: e */
    private BluetoothGattServer f20455e;
    @Nullable

    /* renamed from: f */
    private BluetoothLeAdvertiser f20456f;
    @Nullable

    /* renamed from: g */
    private AdvertiseCallback f20457g;

    /* compiled from: BlueToothJS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/h5/js/a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5655a implements StartActivityForResult.InterfaceC15293a {

        /* renamed from: b */
        final /* synthetic */ String f20459b;

        C5655a(String str) {
            this.f20459b = str;
        }

        @Override // p618m.StartActivityForResult.InterfaceC15293a
        /* renamed from: a */
        public void mo3459a(int i, @Nullable Intent intent) {
            if (i == -1) {
                BlueToothJS.this.m38724m(this.f20459b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlueToothJS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.h5.js.BlueToothJS$openBluetooth$1", m8638f = "BlueToothJS.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5656b extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20460a;

        /* renamed from: c */
        final /* synthetic */ String f20462c;

        /* compiled from: BlueToothJS.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/h5/js/a$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.h5.js.a$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5657a implements StartActivityForResult.InterfaceC15293a {

            /* renamed from: a */
            final /* synthetic */ BlueToothJS f20463a;

            /* renamed from: b */
            final /* synthetic */ String f20464b;

            C5657a(BlueToothJS blueToothJS, String str) {
                this.f20463a = blueToothJS;
                this.f20464b = str;
            }

            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public void mo3459a(int i, @Nullable Intent intent) {
                if (i != -1) {
                    this.f20463a.openBluetooth(this.f20464b);
                } else {
                    this.f20463a.m38723n(this.f20464b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5656b(String str, InterfaceC14268c<? super C5656b> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f20462c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5656b(this.f20462c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5656b) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f20460a == 0) {
                C14294d0.m8596n(obj);
                if (Build.VERSION.SDK_INT >= 21) {
                    Object systemService = BlueToothJS.this.mo38718c().getSystemService("bluetooth");
                    if (systemService != null) {
                        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
                        if (adapter != null && adapter.isEnabled()) {
                            BlueToothJS.this.m38723n(this.f20462c);
                        } else {
                            new StartActivityForResult(BlueToothJS.this.mo38718c()).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE")).m3460c(new C5657a(BlueToothJS.this, this.f20462c));
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
                    }
                } else {
                    new iOSOneButtonDialog(BlueToothJS.this.mo38718c()).setMessage("您的手机不支持蓝牙签到,请联系管理员").show();
                }
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: BlueToothJS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¨\u0006\r"}, m12616d2 = {"com/bxkj/student/v2/ui/h5/js/a$c", "Lf0/i;", "", "success", "Lkotlin/f1;", "a", "Lcom/clj/fastble/data/BleDevice;", "bleDevice", "c", "b", "", "scanResultList", "d", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.a$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5658c extends BleScanCallback {

        /* renamed from: b */
        final /* synthetic */ String f20466b;

        C5658c(String str) {
            this.f20466b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public static final void m38720g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public static final void m38719h(BlueToothJS this$0, String uuid) {
            C14342f0.m8184p(this$0, "this$0");
            C14342f0.m8184p(uuid, "$uuid");
            this$0.m38724m(uuid);
        }

        @Override // p589f0.BleScanPresenterImp
        /* renamed from: a */
        public void mo12756a(boolean z) {
            C11792j.m20469d("onScanStarted", new Object[0]);
        }

        @Override // p589f0.BleScanPresenterImp
        /* renamed from: b */
        public void mo12755b(@NotNull BleDevice bleDevice) {
            C14342f0.m8184p(bleDevice, "bleDevice");
            C11792j.m20469d("onScanning:" + ((Object) bleDevice.m36016d()) + '-' + ((Object) bleDevice.m36017c()), new Object[0]);
            BleManager.m36123v().m36158a();
            String m38726k = BlueToothJS.this.m38726k();
            WebView mo38732d = BlueToothJS.this.mo38732d();
            mo38732d.loadUrl("javascript:stuSignStatus('" + this.f20466b + "','" + ((Object) m38726k) + "')");
        }

        @Override // p589f0.BleScanCallback
        /* renamed from: c */
        public void mo12758c(@NotNull BleDevice bleDevice) {
            C14342f0.m8184p(bleDevice, "bleDevice");
            C11792j.m20469d("onLeScan:" + ((Object) bleDevice.m36016d()) + '-' + ((Object) bleDevice.m36017c()), new Object[0]);
        }

        @Override // p589f0.BleScanCallback
        /* renamed from: d */
        public void mo12757d(@NotNull List<? extends BleDevice> scanResultList) {
            C14342f0.m8184p(scanResultList, "scanResultList");
            C11792j.m20469d(C14342f0.m8216C("onScanFinished:", scanResultList), new Object[0]);
            if (scanResultList.isEmpty()) {
                iOSTwoButtonDialog leftButtonOnClickListener = new iOSTwoButtonDialog(BlueToothJS.this.mo38718c()).setMessage("未搜索到蓝牙信息，签到失败，是否重试？").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.v2.ui.h5.js.b
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        BlueToothJS.C5658c.m38720g();
                    }
                });
                final BlueToothJS blueToothJS = BlueToothJS.this;
                final String str = this.f20466b;
                leftButtonOnClickListener.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.v2.ui.h5.js.c
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        BlueToothJS.C5658c.m38719h(BlueToothJS.this, str);
                    }
                }).show();
            }
        }
    }

    /* compiled from: BlueToothJS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\t"}, m12616d2 = {"com/bxkj/student/v2/ui/h5/js/a$d", "Landroid/bluetooth/BluetoothGattServerCallback;", "Landroid/bluetooth/BluetoothDevice;", ConstantHelper.LOG_DE, "", "status", "newState", "Lkotlin/f1;", "onConnectionStateChange", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.a$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5659d extends BluetoothGattServerCallback {
        C5659d() {
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onConnectionStateChange(@NotNull BluetoothDevice device, int i, int i2) {
            C14342f0.m8184p(device, "device");
            super.onConnectionStateChange(device, i, i2);
        }
    }

    /* compiled from: BlueToothJS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, m12616d2 = {"com/bxkj/student/v2/ui/h5/js/a$e", "Landroid/bluetooth/le/AdvertiseCallback;", "Landroid/bluetooth/le/AdvertiseSettings;", "settingsInEffect", "Lkotlin/f1;", "onStartSuccess", "", "errorCode", "onStartFailure", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.a$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5660e extends AdvertiseCallback {
        C5660e() {
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartFailure(int i) {
            super.onStartFailure(i);
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(BlueToothJS.this.mo38718c());
            iosonebuttondialog.setMessage("开启蓝牙广播服务失败,错误码：" + i + ",请重新再试").show();
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartSuccess(@NotNull AdvertiseSettings settingsInEffect) {
            C14342f0.m8184p(settingsInEffect, "settingsInEffect");
            super.onStartSuccess(settingsInEffect);
            C11792j.m20466g("服务发布成功", new Object[0]);
        }
    }

    /* compiled from: BlueToothJS.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.h5.js.BlueToothJS$stuOpenBluetooth$1", m8638f = "BlueToothJS.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.a$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5661f extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20468a;

        /* renamed from: c */
        final /* synthetic */ String f20470c;

        /* compiled from: BlueToothJS.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/v2/ui/h5/js/a$f$a", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.h5.js.a$f$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5662a implements RequestPermission.InterfaceC15268a {

            /* renamed from: a */
            final /* synthetic */ BlueToothJS f20471a;

            /* renamed from: b */
            final /* synthetic */ String f20472b;

            C5662a(BlueToothJS blueToothJS, String str) {
                this.f20471a = blueToothJS;
                this.f20472b = str;
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: a */
            public void mo3478a(@NotNull String[] permission) {
                C14342f0.m8184p(permission, "permission");
                new iOSOneButtonDialog(this.f20471a.mo38718c()).setMessage("您拒绝了蓝牙定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: b */
            public void mo3477b() {
                if (Build.VERSION.SDK_INT >= 21) {
                    BleManager.m36123v().m36178G(this.f20471a.mo38718c().getApplication());
                    BleManager.m36123v().m36136l(true).m36147f0(1, 5000L).m36151d0(5000);
                    this.f20471a.m38725l(this.f20472b);
                    return;
                }
                new iOSOneButtonDialog(this.f20471a.mo38718c()).setMessage("您的手机不支持蓝牙签到,请联系老师手动签到").show();
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: c */
            public void mo3476c(@NotNull String[] permission) {
                C14342f0.m8184p(permission, "permission");
                new iOSOneButtonDialog(this.f20471a.mo38718c()).setMessage("您拒绝了蓝牙和定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5661f(String str, InterfaceC14268c<? super C5661f> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f20470c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5661f(this.f20470c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5661f) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f20468a == 0) {
                C14294d0.m8596n(obj);
                new RequestPermission(BlueToothJS.this.mo38718c()).m3480c("android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", C7282g.f24950h, C7282g.f24949g).m3479d(new C5662a(BlueToothJS.this, this.f20470c));
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlueToothJS(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        super(mActivity, mWebView);
        C14342f0.m8184p(mActivity, "mActivity");
        C14342f0.m8184p(mWebView, "mWebView");
        this.f20453c = mActivity;
        this.f20454d = mWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public final String m38726k() {
        return Settings.Secure.getString(mo38718c().getContentResolver(), "bluetooth_address");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public final void m38725l(String str) {
        if (BleManager.m36123v().m36173L()) {
            new StartActivityForResult(mo38718c()).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE")).m3460c(new C5655a(str));
        } else {
            new iOSOneButtonDialog(mo38718c()).setMessage("您的手机不支持蓝牙签到,请联系老师手动签到").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public final void m38724m(String str) {
        BleManager.m36123v().m36177H(new BleScanRuleConfig.C6532a().m35973g(new UUID[]{UUID.fromString(str)}).m35974f(30000L).m35978b());
        BleManager.m36123v().m36160Y(new C5658c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    /* renamed from: n */
    public final void m38723n(String str) {
        Object systemService = mo38718c().getSystemService("bluetooth");
        if (systemService != null) {
            BluetoothManager bluetoothManager = (BluetoothManager) systemService;
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UUID.fromString(str), 16, 1);
            BluetoothGattService bluetoothGattService = new BluetoothGattService(UUID.fromString(str), 0);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
            this.f20455e = bluetoothManager.openGattServer(mo38718c(), new C5659d());
            this.f20456f = adapter.getBluetoothLeAdvertiser();
            BluetoothGattServer bluetoothGattServer = this.f20455e;
            if (bluetoothGattServer != null) {
                bluetoothGattServer.addService(bluetoothGattService);
            }
            AdvertiseData build = new AdvertiseData.Builder().addServiceUuid(ParcelUuid.fromString(str)).build();
            AdvertiseSettings build2 = new AdvertiseSettings.Builder().setConnectable(true).build();
            C5660e c5660e = new C5660e();
            this.f20457g = c5660e;
            BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f20456f;
            if (bluetoothLeAdvertiser == null) {
                return;
            }
            bluetoothLeAdvertiser.startAdvertising(build2, build, c5660e);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }

    @Override // com.bxkj.base.p085v2.p086h5.GPSJS
    @NotNull
    /* renamed from: c */
    public FragmentActivity mo38718c() {
        return this.f20453c;
    }

    @JavascriptInterface
    @RequiresApi(21)
    public final void closeBluetooth() {
        BleManager m36123v;
        C11792j.m20469d("关闭蓝牙点名", new Object[0]);
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f20456f;
        if (bluetoothLeAdvertiser != null) {
            bluetoothLeAdvertiser.stopAdvertising(this.f20457g);
        }
        BluetoothGattServer bluetoothGattServer = this.f20455e;
        if (bluetoothGattServer != null) {
            bluetoothGattServer.clearServices();
        }
        BluetoothGattServer bluetoothGattServer2 = this.f20455e;
        if (bluetoothGattServer2 != null) {
            bluetoothGattServer2.close();
        }
        if (BleManager.m36123v().m36182C() != BleScanState.STATE_SCANNING || (m36123v = BleManager.m36123v()) == null) {
            return;
        }
        m36123v.m36158a();
    }

    @Override // com.bxkj.base.p085v2.p086h5.GPSJS
    @NotNull
    /* renamed from: d */
    public WebView mo38732d() {
        return this.f20454d;
    }

    @Override // com.bxkj.base.p085v2.p086h5.GPSJS
    /* renamed from: e */
    public void mo38717e(@NotNull FragmentActivity fragmentActivity) {
        C14342f0.m8184p(fragmentActivity, "<set-?>");
        this.f20453c = fragmentActivity;
    }

    @Override // com.bxkj.base.p085v2.p086h5.GPSJS
    /* renamed from: f */
    public void mo38731f(@NotNull WebView webView) {
        C14342f0.m8184p(webView, "<set-?>");
        this.f20454d = webView;
    }

    @JavascriptInterface
    public final void openBluetooth(@Nullable String str) {
        C11792j.m20469d(C14342f0.m8216C("开始蓝牙点名uuid=", str), new Object[0]);
        C15111j.m4126f(LifecycleOwnerKt.getLifecycleScope(mo38718c()), Dispatchers.m5034e(), null, new C5656b(str, null), 2, null);
    }

    @JavascriptInterface
    public final void stuOpenBluetooth(@NotNull String identify) {
        C14342f0.m8184p(identify, "identify");
        C15111j.m4126f(LifecycleOwnerKt.getLifecycleScope(mo38718c()), Dispatchers.m5034e(), null, new C5661f(identify, null), 2, null);
    }
}
