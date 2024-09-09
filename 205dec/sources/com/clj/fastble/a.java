package com.clj.fastble;

import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.clj.fastble.bluetooth.c;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.exception.OtherException;
import com.stub.StubApp;
import java.util.List;
import z0.d;
import z0.e;
import z0.f;
import z0.g;
import z0.h;
import z0.i;
import z0.k;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BleManager.java */
@TargetApi(18)
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class a {

    /* renamed from: l  reason: collision with root package name */
    public static final int f36572l = 10000;

    /* renamed from: m  reason: collision with root package name */
    private static final int f36573m = 7;

    /* renamed from: n  reason: collision with root package name */
    private static final int f36574n = 5000;

    /* renamed from: o  reason: collision with root package name */
    private static final int f36575o = 0;

    /* renamed from: p  reason: collision with root package name */
    private static final int f36576p = 5000;

    /* renamed from: q  reason: collision with root package name */
    private static final int f36577q = 23;

    /* renamed from: r  reason: collision with root package name */
    private static final int f36578r = 512;

    /* renamed from: s  reason: collision with root package name */
    private static final int f36579s = 20;

    /* renamed from: t  reason: collision with root package name */
    private static final int f36580t = 10000;

    /* renamed from: a  reason: collision with root package name */
    private Application f36581a;

    /* renamed from: b  reason: collision with root package name */
    private com.clj.fastble.scan.b f36582b;

    /* renamed from: c  reason: collision with root package name */
    private BluetoothAdapter f36583c;

    /* renamed from: d  reason: collision with root package name */
    private c f36584d;

    /* renamed from: e  reason: collision with root package name */
    private BluetoothManager f36585e;

    /* renamed from: f  reason: collision with root package name */
    private int f36586f = 7;

    /* renamed from: g  reason: collision with root package name */
    private int f36587g = 5000;

    /* renamed from: h  reason: collision with root package name */
    private int f36588h = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f36589i = 5000;

    /* renamed from: j  reason: collision with root package name */
    private int f36590j = 20;

    /* renamed from: k  reason: collision with root package name */
    private long f36591k = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleManager.java */
    /* renamed from: com.clj.fastble.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private static class C0539a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f36592a = new a();

        private C0539a() {
        }
    }

    public static a v() {
        return C0539a.f36592a;
    }

    public long A() {
        return this.f36589i;
    }

    public com.clj.fastble.scan.b B() {
        return this.f36582b;
    }

    public BleScanState C() {
        return com.clj.fastble.scan.c.b().c();
    }

    public int D() {
        return this.f36590j;
    }

    public void E(BleDevice bleDevice, String str, String str2, z0.c cVar) {
        F(bleDevice, str, str2, false, cVar);
    }

    public void F(BleDevice bleDevice, String str, String str2, boolean z3, z0.c cVar) {
        if (cVar != null) {
            com.clj.fastble.bluetooth.a f4 = this.f36584d.f(bleDevice);
            if (f4 == null) {
                cVar.f(new OtherException("This device not connect!"));
                return;
            } else {
                f4.L().x(str, str2).c(cVar, str2, z3);
                return;
            }
        }
        throw new IllegalArgumentException("BleIndicateCallback can not be Null!");
    }

    public void G(Application application) {
        if (this.f36581a != null || application == null) {
            return;
        }
        this.f36581a = application;
        if (L()) {
            this.f36585e = (BluetoothManager) this.f36581a.getSystemService("bluetooth");
        }
        this.f36583c = BluetoothAdapter.getDefaultAdapter();
        this.f36584d = new c();
        this.f36582b = new com.clj.fastble.scan.b();
    }

    public void H(com.clj.fastble.scan.b bVar) {
        this.f36582b = bVar;
    }

    public boolean I() {
        BluetoothAdapter bluetoothAdapter = this.f36583c;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public boolean J(BleDevice bleDevice) {
        return u(bleDevice) == 2;
    }

    public boolean K(String str) {
        for (BleDevice bleDevice : m()) {
            if (bleDevice != null && bleDevice.e().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean L() {
        return Build.VERSION.SDK_INT >= 18 && StubApp.getOrigApplicationContext(this.f36581a.getApplicationContext()).getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public void M(BleDevice bleDevice, String str, String str2, e eVar) {
        N(bleDevice, str, str2, false, eVar);
    }

    public void N(BleDevice bleDevice, String str, String str2, boolean z3, e eVar) {
        if (eVar != null) {
            com.clj.fastble.bluetooth.a f4 = this.f36584d.f(bleDevice);
            if (f4 == null) {
                eVar.f(new OtherException("This device not connect!"));
                return;
            } else {
                f4.L().x(str, str2).d(eVar, str2, z3);
                return;
            }
        }
        throw new IllegalArgumentException("BleNotifyCallback can not be Null!");
    }

    public void O(BleDevice bleDevice, String str, String str2, f fVar) {
        if (fVar != null) {
            com.clj.fastble.bluetooth.a f4 = this.f36584d.f(bleDevice);
            if (f4 == null) {
                fVar.e(new OtherException("This device is not connected!"));
                return;
            } else {
                f4.L().x(str, str2).o(fVar, str2);
                return;
            }
        }
        throw new IllegalArgumentException("BleReadCallback can not be Null!");
    }

    public void P(BleDevice bleDevice, g gVar) {
        if (gVar != null) {
            com.clj.fastble.bluetooth.a f4 = this.f36584d.f(bleDevice);
            if (f4 == null) {
                gVar.e(new OtherException("This device is not connected!"));
                return;
            } else {
                f4.L().q(gVar);
                return;
            }
        }
        throw new IllegalArgumentException("BleRssiCallback can not be Null!");
    }

    public void Q(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.a n4 = n(bleDevice);
        if (n4 != null) {
            n4.N();
        }
    }

    public void R(BleDevice bleDevice, String str) {
        com.clj.fastble.bluetooth.a n4 = n(bleDevice);
        if (n4 != null) {
            n4.O(str);
        }
    }

    public void S(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.a n4 = n(bleDevice);
        if (n4 != null) {
            n4.P();
        }
    }

    public void T(BleDevice bleDevice, String str) {
        com.clj.fastble.bluetooth.a n4 = n(bleDevice);
        if (n4 != null) {
            n4.Q(str);
        }
    }

    public void U(BleDevice bleDevice, String str) {
        com.clj.fastble.bluetooth.a n4 = n(bleDevice);
        if (n4 != null) {
            n4.R(str);
        }
    }

    public void V(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.a n4 = n(bleDevice);
        if (n4 != null) {
            n4.S();
        }
    }

    public void W(BleDevice bleDevice, String str) {
        com.clj.fastble.bluetooth.a n4 = n(bleDevice);
        if (n4 != null) {
            n4.T(str);
        }
    }

    public boolean X(BleDevice bleDevice, int i4) {
        com.clj.fastble.bluetooth.a f4;
        if (Build.VERSION.SDK_INT < 21 || (f4 = this.f36584d.f(bleDevice)) == null) {
            return false;
        }
        return f4.L().r(i4);
    }

    public void Y(i iVar) {
        if (iVar != null) {
            if (!I()) {
                com.clj.fastble.utils.a.b("Bluetooth not enable!");
                iVar.a(false);
                return;
            }
            com.clj.fastble.scan.c.b().d(this.f36582b.j(), this.f36582b.h(), this.f36582b.g(), this.f36582b.l(), this.f36582b.i(), iVar);
            return;
        }
        throw new IllegalArgumentException("BleScanCallback can not be Null!");
    }

    public void Z(h hVar) {
        if (hVar != null) {
            if (!I()) {
                com.clj.fastble.utils.a.b("Bluetooth not enable!");
                hVar.a(false);
                return;
            }
            com.clj.fastble.scan.c.b().e(this.f36582b.j(), this.f36582b.h(), this.f36582b.g(), this.f36582b.l(), this.f36582b.i(), hVar);
            return;
        }
        throw new IllegalArgumentException("BleScanAndConnectCallback can not be Null!");
    }

    public void a() {
        com.clj.fastble.scan.c.b().g();
    }

    public a a0(long j4) {
        if (j4 <= 0) {
            j4 = 100;
        }
        this.f36591k = j4;
        return this;
    }

    public void b(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.a n4 = n(bleDevice);
        if (n4 != null) {
            n4.B();
        }
    }

    public a b0(int i4) {
        if (i4 > 7) {
            i4 = 7;
        }
        this.f36586f = i4;
        return this;
    }

    public BluetoothGatt c(BleDevice bleDevice, z0.b bVar) {
        if (bVar != null) {
            if (!I()) {
                com.clj.fastble.utils.a.b("Bluetooth not enable!");
                bVar.c(bleDevice, new OtherException("Bluetooth not enable!"));
                return null;
            }
            if (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper()) {
                com.clj.fastble.utils.a.d("Be careful: currentThread is not MainThread!");
            }
            if (bleDevice != null && bleDevice.b() != null) {
                return this.f36584d.b(bleDevice).D(bleDevice, this.f36582b.k(), bVar);
            }
            bVar.c(bleDevice, new OtherException("Not Found Device Exception Occurred!"));
            return null;
        }
        throw new IllegalArgumentException("BleGattCallback can not be Null!");
    }

    public void c0(BleDevice bleDevice, int i4, d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("BleMtuChangedCallback can not be Null!");
        }
        if (i4 > 512) {
            com.clj.fastble.utils.a.b("requiredMtu should lower than 512 !");
            dVar.f(new OtherException("requiredMtu should lower than 512 !"));
        } else if (i4 < 23) {
            com.clj.fastble.utils.a.b("requiredMtu should higher than 23 !");
            dVar.f(new OtherException("requiredMtu should higher than 23 !"));
        } else {
            com.clj.fastble.bluetooth.a f4 = this.f36584d.f(bleDevice);
            if (f4 == null) {
                dVar.f(new OtherException("This device is not connected!"));
            } else {
                f4.L().v(i4, dVar);
            }
        }
    }

    public BluetoothGatt d(String str, z0.b bVar) {
        return c(new BleDevice(o().getRemoteDevice(str), 0, null, 0L), bVar);
    }

    public a d0(int i4) {
        this.f36587g = i4;
        return this;
    }

    public BleDevice e(BluetoothDevice bluetoothDevice) {
        return new BleDevice(bluetoothDevice);
    }

    public a e0(int i4) {
        return f0(i4, 5000L);
    }

    @TargetApi(21)
    public BleDevice f(ScanResult scanResult) {
        if (scanResult != null) {
            BluetoothDevice device = scanResult.getDevice();
            int rssi = scanResult.getRssi();
            ScanRecord scanRecord = scanResult.getScanRecord();
            return new BleDevice(device, rssi, scanRecord != null ? scanRecord.getBytes() : null, scanResult.getTimestampNanos());
        }
        throw new IllegalArgumentException("scanResult can not be Null!");
    }

    public a f0(int i4, long j4) {
        if (i4 > 10) {
            i4 = 10;
        }
        if (j4 < 0) {
            j4 = 0;
        }
        this.f36588h = i4;
        this.f36589i = j4;
        return this;
    }

    public void g() {
        c cVar = this.f36584d;
        if (cVar != null) {
            cVar.c();
        }
    }

    public a g0(int i4) {
        if (i4 > 0) {
            this.f36590j = i4;
        }
        return this;
    }

    public Context getContext() {
        return this.f36581a;
    }

    public void h() {
        BluetoothAdapter bluetoothAdapter = this.f36583c;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            return;
        }
        this.f36583c.disable();
    }

    public boolean h0(BleDevice bleDevice, String str, String str2) {
        return i0(bleDevice, str, str2, false);
    }

    public void i(BleDevice bleDevice) {
        c cVar = this.f36584d;
        if (cVar != null) {
            cVar.d(bleDevice);
        }
    }

    public boolean i0(BleDevice bleDevice, String str, String str2, boolean z3) {
        com.clj.fastble.bluetooth.a f4 = this.f36584d.f(bleDevice);
        if (f4 == null) {
            return false;
        }
        boolean a4 = f4.L().x(str, str2).a(z3);
        if (a4) {
            f4.O(str2);
        }
        return a4;
    }

    public void j() {
        c cVar = this.f36584d;
        if (cVar != null) {
            cVar.e();
        }
    }

    public boolean j0(BleDevice bleDevice, String str, String str2) {
        return k0(bleDevice, str, str2, false);
    }

    public void k() {
        BluetoothAdapter bluetoothAdapter = this.f36583c;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.enable();
        }
    }

    public boolean k0(BleDevice bleDevice, String str, String str2, boolean z3) {
        com.clj.fastble.bluetooth.a f4 = this.f36584d.f(bleDevice);
        if (f4 == null) {
            return false;
        }
        boolean b4 = f4.L().x(str, str2).b(z3);
        if (b4) {
            f4.Q(str2);
        }
        return b4;
    }

    public a l(boolean z3) {
        com.clj.fastble.utils.a.f36718a = z3;
        return this;
    }

    public void l0(BleDevice bleDevice, String str, String str2, byte[] bArr, k kVar) {
        m0(bleDevice, str, str2, bArr, true, kVar);
    }

    public List<BleDevice> m() {
        c cVar = this.f36584d;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    public void m0(BleDevice bleDevice, String str, String str2, byte[] bArr, boolean z3, k kVar) {
        n0(bleDevice, str, str2, bArr, z3, true, 0L, kVar);
    }

    public com.clj.fastble.bluetooth.a n(BleDevice bleDevice) {
        c cVar = this.f36584d;
        if (cVar != null) {
            return cVar.f(bleDevice);
        }
        return null;
    }

    public void n0(BleDevice bleDevice, String str, String str2, byte[] bArr, boolean z3, boolean z4, long j4, k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("BleWriteCallback can not be Null!");
        }
        if (bArr == null) {
            com.clj.fastble.utils.a.b("data is Null!");
            kVar.e(new OtherException("data is Null!"));
            return;
        }
        if (bArr.length > 20 && !z3) {
            com.clj.fastble.utils.a.d("Be careful: data's length beyond 20! Ensure MTU higher than 23, or use spilt write!");
        }
        com.clj.fastble.bluetooth.a f4 = this.f36584d.f(bleDevice);
        if (f4 == null) {
            kVar.e(new OtherException("This device not connect!"));
        } else if (z3 && bArr.length > D()) {
            new com.clj.fastble.bluetooth.d().k(f4, str, str2, bArr, z4, j4, kVar);
        } else {
            f4.L().x(str, str2).y(bArr, kVar, str2);
        }
    }

    public BluetoothAdapter o() {
        return this.f36583c;
    }

    public BluetoothGatt p(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.a n4 = n(bleDevice);
        if (n4 != null) {
            return n4.I();
        }
        return null;
    }

    public List<BluetoothGattCharacteristic> q(BluetoothGattService bluetoothGattService) {
        return bluetoothGattService.getCharacteristics();
    }

    public List<BluetoothGattService> r(BleDevice bleDevice) {
        BluetoothGatt p3 = p(bleDevice);
        if (p3 != null) {
            return p3.getServices();
        }
        return null;
    }

    public BluetoothManager s() {
        return this.f36585e;
    }

    public long t() {
        return this.f36591k;
    }

    public int u(BleDevice bleDevice) {
        if (bleDevice != null) {
            return this.f36585e.getConnectionState(bleDevice.b(), 7);
        }
        return 0;
    }

    public int w() {
        return this.f36586f;
    }

    public c x() {
        return this.f36584d;
    }

    public int y() {
        return this.f36587g;
    }

    public int z() {
        return this.f36588h;
    }
}
