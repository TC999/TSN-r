package com.bxkj.student.v2.ui.h5.js;

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
import com.bxkj.student.v2.ui.h5.js.a;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.scan.b;
import com.orhanobut.logger.j;
import d2.p;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.q0;
import l.b;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BlueToothJS.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\u0013\u001a\u00020\r8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/bxkj/student/v2/ui/h5/js/a;", "Lcom/bxkj/base/v2/h5/c;", "", "identify", "Lkotlin/f1;", "n", "uuid", "l", "m", "k", "openBluetooth", "closeBluetooth", "stuOpenBluetooth", "Landroidx/fragment/app/FragmentActivity;", "c", "Landroidx/fragment/app/FragmentActivity;", "()Landroidx/fragment/app/FragmentActivity;", "e", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroid/webkit/WebView;", "d", "Landroid/webkit/WebView;", "()Landroid/webkit/WebView;", "f", "(Landroid/webkit/WebView;)V", "mWebView", "Landroid/bluetooth/BluetoothGattServer;", "Landroid/bluetooth/BluetoothGattServer;", "bluetoothGattServer", "Landroid/bluetooth/le/BluetoothLeAdvertiser;", "Landroid/bluetooth/le/BluetoothLeAdvertiser;", "advertiser", "Landroid/bluetooth/le/AdvertiseCallback;", "g", "Landroid/bluetooth/le/AdvertiseCallback;", "advertiseCallback", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/webkit/WebView;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends com.bxkj.base.v2.h5.c {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private FragmentActivity f23845c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private WebView f23846d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private BluetoothGattServer f23847e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private BluetoothLeAdvertiser f23848f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private AdvertiseCallback f23849g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BlueToothJS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/h5/js/a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.h5.js.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0308a implements b.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23851b;

        C0308a(String str) {
            this.f23851b = str;
        }

        @Override // m.b.a
        public void a(int i4, @Nullable Intent intent) {
            if (i4 == -1) {
                a.this.m(this.f23851b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BlueToothJS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.BlueToothJS$openBluetooth$1", f = "BlueToothJS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23852a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23854c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* compiled from: BlueToothJS.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/h5/js/a$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.h5.js.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class C0309a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f23855a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f23856b;

            C0309a(a aVar, String str) {
                this.f23855a = aVar;
                this.f23856b = str;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                if (i4 != -1) {
                    this.f23855a.openBluetooth(this.f23856b);
                } else {
                    this.f23855a.n(this.f23856b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f23854c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new b(this.f23854c, cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f23852a == 0) {
                d0.n(obj);
                if (Build.VERSION.SDK_INT >= 21) {
                    Object systemService = a.this.c().getSystemService("bluetooth");
                    if (systemService != null) {
                        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
                        if (adapter != null && adapter.isEnabled()) {
                            a.this.n(this.f23854c);
                        } else {
                            new m.b(a.this.c()).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE")).c(new C0309a(a.this, this.f23854c));
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
                    }
                } else {
                    new iOSOneButtonDialog(a.this.c()).setMessage("\u60a8\u7684\u624b\u673a\u4e0d\u652f\u6301\u84dd\u7259\u7b7e\u5230,\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
                }
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BlueToothJS.kt */
    @Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016\u00a8\u0006\r"}, d2 = {"com/bxkj/student/v2/ui/h5/js/a$c", "Lz0/i;", "", "success", "Lkotlin/f1;", "a", "Lcom/clj/fastble/data/BleDevice;", "bleDevice", "c", "b", "", "scanResultList", "d", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class c extends i {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23858b;

        c(String str) {
            this.f23858b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(a this$0, String uuid) {
            f0.p(this$0, "this$0");
            f0.p(uuid, "$uuid");
            this$0.m(uuid);
        }

        @Override // z0.j
        public void a(boolean z3) {
            j.d("onScanStarted", new Object[0]);
        }

        @Override // z0.j
        public void b(@NotNull BleDevice bleDevice) {
            f0.p(bleDevice, "bleDevice");
            j.d("onScanning:" + ((Object) bleDevice.g()) + '-' + ((Object) bleDevice.e()), new Object[0]);
            com.clj.fastble.a.v().a();
            String k4 = a.this.k();
            WebView d4 = a.this.d();
            d4.loadUrl("javascript:stuSignStatus('" + this.f23858b + "','" + ((Object) k4) + "')");
        }

        @Override // z0.i
        public void c(@NotNull BleDevice bleDevice) {
            f0.p(bleDevice, "bleDevice");
            j.d("onLeScan:" + ((Object) bleDevice.g()) + '-' + ((Object) bleDevice.e()), new Object[0]);
        }

        @Override // z0.i
        public void d(@NotNull List<? extends BleDevice> scanResultList) {
            f0.p(scanResultList, "scanResultList");
            j.d(f0.C("onScanFinished:", scanResultList), new Object[0]);
            if (scanResultList.isEmpty()) {
                iOSTwoButtonDialog leftButtonOnClickListener = new iOSTwoButtonDialog(a.this.c()).setMessage("\u672a\u641c\u7d22\u5230\u84dd\u7259\u4fe1\u606f\uff0c\u7b7e\u5230\u5931\u8d25\uff0c\u662f\u5426\u91cd\u8bd5\uff1f").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.v2.ui.h5.js.b
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        a.c.g();
                    }
                });
                final a aVar = a.this;
                final String str = this.f23858b;
                leftButtonOnClickListener.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.v2.ui.h5.js.c
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        a.c.h(a.this, str);
                    }
                }).show();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BlueToothJS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/bxkj/student/v2/ui/h5/js/a$d", "Landroid/bluetooth/BluetoothGattServerCallback;", "Landroid/bluetooth/BluetoothDevice;", "device", "", "status", "newState", "Lkotlin/f1;", "onConnectionStateChange", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class d extends BluetoothGattServerCallback {
        d() {
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onConnectionStateChange(@NotNull BluetoothDevice device, int i4, int i5) {
            f0.p(device, "device");
            super.onConnectionStateChange(device, i4, i5);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BlueToothJS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/bxkj/student/v2/ui/h5/js/a$e", "Landroid/bluetooth/le/AdvertiseCallback;", "Landroid/bluetooth/le/AdvertiseSettings;", "settingsInEffect", "Lkotlin/f1;", "onStartSuccess", "", "errorCode", "onStartFailure", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class e extends AdvertiseCallback {
        e() {
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartFailure(int i4) {
            super.onStartFailure(i4);
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(a.this.c());
            iosonebuttondialog.setMessage("\u5f00\u542f\u84dd\u7259\u5e7f\u64ad\u670d\u52a1\u5931\u8d25,\u9519\u8bef\u7801\uff1a" + i4 + ",\u8bf7\u91cd\u65b0\u518d\u8bd5").show();
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartSuccess(@NotNull AdvertiseSettings settingsInEffect) {
            f0.p(settingsInEffect, "settingsInEffect");
            super.onStartSuccess(settingsInEffect);
            j.g("\u670d\u52a1\u53d1\u5e03\u6210\u529f", new Object[0]);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BlueToothJS.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.BlueToothJS$stuOpenBluetooth$1", f = "BlueToothJS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class f extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23860a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23862c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* compiled from: BlueToothJS.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/student/v2/ui/h5/js/a$f$a", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.h5.js.a$f$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class C0310a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f23863a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f23864b;

            C0310a(a aVar, String str) {
                this.f23863a = aVar;
                this.f23864b = str;
            }

            @Override // l.b.a
            public void a(@NotNull String[] permission) {
                f0.p(permission, "permission");
                new iOSOneButtonDialog(this.f23863a.c()).setMessage("\u60a8\u62d2\u7edd\u4e86\u84dd\u7259\u5b9a\u4f4d\u6743\u9650,\u65e0\u6cd5\u8fdb\u884c\u84dd\u7259\u7b7e\u5230,\u8bf7\u5728(\u8bbe\u7f6e->\u5e94\u7528\u2014>\u4f53\u9002\u80fd->\u6743\u9650\u7ba1\u7406->\u83b7\u53d6\u5b9a\u4f4d)\u8bbe\u7f6e\u5141\u8bb8\u5b9a\u4f4d\u540e\u518d\u8fdb\u884c\u84dd\u7259\u7b7e\u5230").show();
            }

            @Override // l.b.a
            public void b() {
                if (Build.VERSION.SDK_INT >= 21) {
                    com.clj.fastble.a.v().G(this.f23863a.c().getApplication());
                    com.clj.fastble.a.v().l(true).f0(1, 5000L).d0(5000);
                    this.f23863a.l(this.f23864b);
                    return;
                }
                new iOSOneButtonDialog(this.f23863a.c()).setMessage("\u60a8\u7684\u624b\u673a\u4e0d\u652f\u6301\u84dd\u7259\u7b7e\u5230,\u8bf7\u8054\u7cfb\u8001\u5e08\u624b\u52a8\u7b7e\u5230").show();
            }

            @Override // l.b.a
            public void c(@NotNull String[] permission) {
                f0.p(permission, "permission");
                new iOSOneButtonDialog(this.f23863a.c()).setMessage("\u60a8\u62d2\u7edd\u4e86\u84dd\u7259\u548c\u5b9a\u4f4d\u6743\u9650,\u65e0\u6cd5\u8fdb\u884c\u84dd\u7259\u7b7e\u5230,\u8bf7\u5728(\u8bbe\u7f6e->\u5e94\u7528\u2014>\u4f53\u9002\u80fd->\u6743\u9650\u7ba1\u7406->\u83b7\u53d6\u5b9a\u4f4d)\u8bbe\u7f6e\u5141\u8bb8\u5b9a\u4f4d\u540e\u518d\u8fdb\u884c\u84dd\u7259\u7b7e\u5230").show();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
            this.f23862c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new f(this.f23862c, cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((f) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f23860a == 0) {
                d0.n(obj);
                new l.b(a.this.c()).c("android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION").d(new C0310a(a.this, this.f23862c));
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        super(mActivity, mWebView);
        f0.p(mActivity, "mActivity");
        f0.p(mWebView, "mWebView");
        this.f23845c = mActivity;
        this.f23846d = mWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k() {
        return Settings.Secure.getString(c().getContentResolver(), "bluetooth_address");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String str) {
        if (com.clj.fastble.a.v().L()) {
            new m.b(c()).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE")).c(new C0308a(str));
        } else {
            new iOSOneButtonDialog(c()).setMessage("\u60a8\u7684\u624b\u673a\u4e0d\u652f\u6301\u84dd\u7259\u7b7e\u5230,\u8bf7\u8054\u7cfb\u8001\u5e08\u624b\u52a8\u7b7e\u5230").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String str) {
        com.clj.fastble.a.v().H(new b.a().g(new UUID[]{UUID.fromString(str)}).f(PolicyConfig.mServerBusyRetryBaseInternal).b());
        com.clj.fastble.a.v().Y(new c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    public final void n(String str) {
        Object systemService = c().getSystemService("bluetooth");
        if (systemService != null) {
            BluetoothManager bluetoothManager = (BluetoothManager) systemService;
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UUID.fromString(str), 16, 1);
            BluetoothGattService bluetoothGattService = new BluetoothGattService(UUID.fromString(str), 0);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
            this.f23847e = bluetoothManager.openGattServer(c(), new d());
            this.f23848f = adapter.getBluetoothLeAdvertiser();
            BluetoothGattServer bluetoothGattServer = this.f23847e;
            if (bluetoothGattServer != null) {
                bluetoothGattServer.addService(bluetoothGattService);
            }
            AdvertiseData build = new AdvertiseData.Builder().addServiceUuid(ParcelUuid.fromString(str)).build();
            AdvertiseSettings build2 = new AdvertiseSettings.Builder().setConnectable(true).build();
            e eVar = new e();
            this.f23849g = eVar;
            BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f23848f;
            if (bluetoothLeAdvertiser == null) {
                return;
            }
            bluetoothLeAdvertiser.startAdvertising(build2, build, eVar);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }

    @Override // com.bxkj.base.v2.h5.c
    @NotNull
    public FragmentActivity c() {
        return this.f23845c;
    }

    @JavascriptInterface
    @RequiresApi(21)
    public final void closeBluetooth() {
        com.clj.fastble.a v3;
        j.d("\u5173\u95ed\u84dd\u7259\u70b9\u540d", new Object[0]);
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f23848f;
        if (bluetoothLeAdvertiser != null) {
            bluetoothLeAdvertiser.stopAdvertising(this.f23849g);
        }
        BluetoothGattServer bluetoothGattServer = this.f23847e;
        if (bluetoothGattServer != null) {
            bluetoothGattServer.clearServices();
        }
        BluetoothGattServer bluetoothGattServer2 = this.f23847e;
        if (bluetoothGattServer2 != null) {
            bluetoothGattServer2.close();
        }
        if (com.clj.fastble.a.v().C() != BleScanState.STATE_SCANNING || (v3 = com.clj.fastble.a.v()) == null) {
            return;
        }
        v3.a();
    }

    @Override // com.bxkj.base.v2.h5.c
    @NotNull
    public WebView d() {
        return this.f23846d;
    }

    @Override // com.bxkj.base.v2.h5.c
    public void e(@NotNull FragmentActivity fragmentActivity) {
        f0.p(fragmentActivity, "<set-?>");
        this.f23845c = fragmentActivity;
    }

    @Override // com.bxkj.base.v2.h5.c
    public void f(@NotNull WebView webView) {
        f0.p(webView, "<set-?>");
        this.f23846d = webView;
    }

    @JavascriptInterface
    public final void openBluetooth(@Nullable String str) {
        j.d(f0.C("\u5f00\u59cb\u84dd\u7259\u70b9\u540duuid=", str), new Object[0]);
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(c()), kotlinx.coroutines.f1.e(), null, new b(str, null), 2, null);
    }

    @JavascriptInterface
    public final void stuOpenBluetooth(@NotNull String identify) {
        f0.p(identify, "identify");
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(c()), kotlinx.coroutines.f1.e(), null, new f(identify, null), 2, null);
    }
}
