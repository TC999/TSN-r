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
import com.clj.fastble.bluetooth.BleBluetooth;
import com.clj.fastble.bluetooth.MultipleBluetoothController;
import com.clj.fastble.bluetooth.SplitWriter;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.exception.OtherException;
import com.clj.fastble.scan.BleScanRuleConfig;
import com.clj.fastble.scan.BleScanner;
import com.clj.fastble.utils.BleLog;
import com.stub.StubApp;
import java.util.List;
import p589f0.BleGattCallback;
import p589f0.BleIndicateCallback;
import p589f0.BleMtuChangedCallback;
import p589f0.BleNotifyCallback;
import p589f0.BleReadCallback;
import p589f0.BleRssiCallback;
import p589f0.BleScanAndConnectCallback;
import p589f0.BleScanCallback;
import p589f0.BleWriteCallback;

@TargetApi(18)
/* renamed from: com.clj.fastble.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BleManager {

    /* renamed from: l */
    public static final int f22896l = 10000;

    /* renamed from: m */
    private static final int f22897m = 7;

    /* renamed from: n */
    private static final int f22898n = 5000;

    /* renamed from: o */
    private static final int f22899o = 0;

    /* renamed from: p */
    private static final int f22900p = 5000;

    /* renamed from: q */
    private static final int f22901q = 23;

    /* renamed from: r */
    private static final int f22902r = 512;

    /* renamed from: s */
    private static final int f22903s = 20;

    /* renamed from: t */
    private static final int f22904t = 10000;

    /* renamed from: a */
    private Application f22905a;

    /* renamed from: b */
    private BleScanRuleConfig f22906b;

    /* renamed from: c */
    private BluetoothAdapter f22907c;

    /* renamed from: d */
    private MultipleBluetoothController f22908d;

    /* renamed from: e */
    private BluetoothManager f22909e;

    /* renamed from: f */
    private int f22910f = 7;

    /* renamed from: g */
    private int f22911g = 5000;

    /* renamed from: h */
    private int f22912h = 0;

    /* renamed from: i */
    private long f22913i = 5000;

    /* renamed from: j */
    private int f22914j = 20;

    /* renamed from: k */
    private long f22915k = 10000;

    /* compiled from: BleManager.java */
    /* renamed from: com.clj.fastble.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static class C6515a {

        /* renamed from: a */
        private static final BleManager f22916a = new BleManager();

        private C6515a() {
        }
    }

    /* renamed from: v */
    public static BleManager m36123v() {
        return C6515a.f22916a;
    }

    /* renamed from: A */
    public long m36184A() {
        return this.f22913i;
    }

    /* renamed from: B */
    public BleScanRuleConfig m36183B() {
        return this.f22906b;
    }

    /* renamed from: C */
    public BleScanState m36182C() {
        return BleScanner.m35971b().m35970c();
    }

    /* renamed from: D */
    public int m36181D() {
        return this.f22914j;
    }

    /* renamed from: E */
    public void m36180E(BleDevice bleDevice, String str, String str2, BleIndicateCallback bleIndicateCallback) {
        m36179F(bleDevice, str, str2, false, bleIndicateCallback);
    }

    /* renamed from: F */
    public void m36179F(BleDevice bleDevice, String str, String str2, boolean z, BleIndicateCallback bleIndicateCallback) {
        if (bleIndicateCallback != null) {
            BleBluetooth m36040f = this.f22908d.m36040f(bleDevice);
            if (m36040f == null) {
                bleIndicateCallback.m12771f(new OtherException("This device not connect!"));
                return;
            } else {
                m36040f.m36106L().m36048x(str, str2).m36069c(bleIndicateCallback, str2, z);
                return;
            }
        }
        throw new IllegalArgumentException("BleIndicateCallback can not be Null!");
    }

    /* renamed from: G */
    public void m36178G(Application application) {
        if (this.f22905a != null || application == null) {
            return;
        }
        this.f22905a = application;
        if (m36173L()) {
            this.f22909e = (BluetoothManager) this.f22905a.getSystemService("bluetooth");
        }
        this.f22907c = BluetoothAdapter.getDefaultAdapter();
        this.f22908d = new MultipleBluetoothController();
        this.f22906b = new BleScanRuleConfig();
    }

    /* renamed from: H */
    public void m36177H(BleScanRuleConfig bleScanRuleConfig) {
        this.f22906b = bleScanRuleConfig;
    }

    /* renamed from: I */
    public boolean m36176I() {
        BluetoothAdapter bluetoothAdapter = this.f22907c;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    /* renamed from: J */
    public boolean m36175J(BleDevice bleDevice) {
        return m36124u(bleDevice) == 2;
    }

    /* renamed from: K */
    public boolean m36174K(String str) {
        for (BleDevice bleDevice : m36134m()) {
            if (bleDevice != null && bleDevice.m36017c().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: L */
    public boolean m36173L() {
        return Build.VERSION.SDK_INT >= 18 && StubApp.getOrigApplicationContext(this.f22905a.getApplicationContext()).getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    /* renamed from: M */
    public void m36172M(BleDevice bleDevice, String str, String str2, BleNotifyCallback bleNotifyCallback) {
        m36171N(bleDevice, str, str2, false, bleNotifyCallback);
    }

    /* renamed from: N */
    public void m36171N(BleDevice bleDevice, String str, String str2, boolean z, BleNotifyCallback bleNotifyCallback) {
        if (bleNotifyCallback != null) {
            BleBluetooth m36040f = this.f22908d.m36040f(bleDevice);
            if (m36040f == null) {
                bleNotifyCallback.m12766f(new OtherException("This device not connect!"));
                return;
            } else {
                m36040f.m36106L().m36048x(str, str2).m36068d(bleNotifyCallback, str2, z);
                return;
            }
        }
        throw new IllegalArgumentException("BleNotifyCallback can not be Null!");
    }

    /* renamed from: O */
    public void m36170O(BleDevice bleDevice, String str, String str2, BleReadCallback bleReadCallback) {
        if (bleReadCallback != null) {
            BleBluetooth m36040f = this.f22908d.m36040f(bleDevice);
            if (m36040f == null) {
                bleReadCallback.m12764e(new OtherException("This device is not connected!"));
                return;
            } else {
                m36040f.m36106L().m36048x(str, str2).m36057o(bleReadCallback, str2);
                return;
            }
        }
        throw new IllegalArgumentException("BleReadCallback can not be Null!");
    }

    /* renamed from: P */
    public void m36169P(BleDevice bleDevice, BleRssiCallback bleRssiCallback) {
        if (bleRssiCallback != null) {
            BleBluetooth m36040f = this.f22908d.m36040f(bleDevice);
            if (m36040f == null) {
                bleRssiCallback.m12762e(new OtherException("This device is not connected!"));
                return;
            } else {
                m36040f.m36106L().m36055q(bleRssiCallback);
                return;
            }
        }
        throw new IllegalArgumentException("BleRssiCallback can not be Null!");
    }

    /* renamed from: Q */
    public void m36168Q(BleDevice bleDevice) {
        BleBluetooth m36132n = m36132n(bleDevice);
        if (m36132n != null) {
            m36132n.m36104N();
        }
    }

    /* renamed from: R */
    public void m36167R(BleDevice bleDevice, String str) {
        BleBluetooth m36132n = m36132n(bleDevice);
        if (m36132n != null) {
            m36132n.m36103O(str);
        }
    }

    /* renamed from: S */
    public void m36166S(BleDevice bleDevice) {
        BleBluetooth m36132n = m36132n(bleDevice);
        if (m36132n != null) {
            m36132n.m36102P();
        }
    }

    /* renamed from: T */
    public void m36165T(BleDevice bleDevice, String str) {
        BleBluetooth m36132n = m36132n(bleDevice);
        if (m36132n != null) {
            m36132n.m36101Q(str);
        }
    }

    /* renamed from: U */
    public void m36164U(BleDevice bleDevice, String str) {
        BleBluetooth m36132n = m36132n(bleDevice);
        if (m36132n != null) {
            m36132n.m36100R(str);
        }
    }

    /* renamed from: V */
    public void m36163V(BleDevice bleDevice) {
        BleBluetooth m36132n = m36132n(bleDevice);
        if (m36132n != null) {
            m36132n.m36099S();
        }
    }

    /* renamed from: W */
    public void m36162W(BleDevice bleDevice, String str) {
        BleBluetooth m36132n = m36132n(bleDevice);
        if (m36132n != null) {
            m36132n.m36098T(str);
        }
    }

    /* renamed from: X */
    public boolean m36161X(BleDevice bleDevice, int i) {
        BleBluetooth m36040f;
        if (Build.VERSION.SDK_INT < 21 || (m36040f = this.f22908d.m36040f(bleDevice)) == null) {
            return false;
        }
        return m36040f.m36106L().m36054r(i);
    }

    /* renamed from: Y */
    public void m36160Y(BleScanCallback bleScanCallback) {
        if (bleScanCallback != null) {
            if (!m36176I()) {
                BleLog.m35959b("Bluetooth not enable!");
                bleScanCallback.mo12756a(false);
                return;
            }
            BleScanner.m35971b().m35969d(this.f22906b.m35982j(), this.f22906b.m35984h(), this.f22906b.m35985g(), this.f22906b.m35980l(), this.f22906b.m35983i(), bleScanCallback);
            return;
        }
        throw new IllegalArgumentException("BleScanCallback can not be Null!");
    }

    /* renamed from: Z */
    public void m36159Z(BleScanAndConnectCallback bleScanAndConnectCallback) {
        if (bleScanAndConnectCallback != null) {
            if (!m36176I()) {
                BleLog.m35959b("Bluetooth not enable!");
                bleScanAndConnectCallback.mo12756a(false);
                return;
            }
            BleScanner.m35971b().m35968e(this.f22906b.m35982j(), this.f22906b.m35984h(), this.f22906b.m35985g(), this.f22906b.m35980l(), this.f22906b.m35983i(), bleScanAndConnectCallback);
            return;
        }
        throw new IllegalArgumentException("BleScanAndConnectCallback can not be Null!");
    }

    /* renamed from: a */
    public void m36158a() {
        BleScanner.m35971b().m35966g();
    }

    /* renamed from: a0 */
    public BleManager m36157a0(long j) {
        if (j <= 0) {
            j = 100;
        }
        this.f22915k = j;
        return this;
    }

    /* renamed from: b */
    public void m36156b(BleDevice bleDevice) {
        BleBluetooth m36132n = m36132n(bleDevice);
        if (m36132n != null) {
            m36132n.m36116B();
        }
    }

    /* renamed from: b0 */
    public BleManager m36155b0(int i) {
        if (i > 7) {
            i = 7;
        }
        this.f22910f = i;
        return this;
    }

    /* renamed from: c */
    public BluetoothGatt m36154c(BleDevice bleDevice, BleGattCallback bleGattCallback) {
        if (bleGattCallback != null) {
            if (!m36176I()) {
                BleLog.m35959b("Bluetooth not enable!");
                bleGattCallback.m12776c(bleDevice, new OtherException("Bluetooth not enable!"));
                return null;
            }
            if (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper()) {
                BleLog.m35957d("Be careful: currentThread is not MainThread!");
            }
            if (bleDevice != null && bleDevice.m36019a() != null) {
                return this.f22908d.m36044b(bleDevice).m36114D(bleDevice, this.f22906b.m35981k(), bleGattCallback);
            }
            bleGattCallback.m12776c(bleDevice, new OtherException("Not Found Device Exception Occurred!"));
            return null;
        }
        throw new IllegalArgumentException("BleGattCallback can not be Null!");
    }

    /* renamed from: c0 */
    public void m36153c0(BleDevice bleDevice, int i, BleMtuChangedCallback bleMtuChangedCallback) {
        if (bleMtuChangedCallback == null) {
            throw new IllegalArgumentException("BleMtuChangedCallback can not be Null!");
        }
        if (i > 512) {
            BleLog.m35959b("requiredMtu should lower than 512 !");
            bleMtuChangedCallback.m12768f(new OtherException("requiredMtu should lower than 512 !"));
        } else if (i < 23) {
            BleLog.m35959b("requiredMtu should higher than 23 !");
            bleMtuChangedCallback.m12768f(new OtherException("requiredMtu should higher than 23 !"));
        } else {
            BleBluetooth m36040f = this.f22908d.m36040f(bleDevice);
            if (m36040f == null) {
                bleMtuChangedCallback.m12768f(new OtherException("This device is not connected!"));
            } else {
                m36040f.m36106L().m36050v(i, bleMtuChangedCallback);
            }
        }
    }

    /* renamed from: d */
    public BluetoothGatt m36152d(String str, BleGattCallback bleGattCallback) {
        return m36154c(new BleDevice(m36130o().getRemoteDevice(str), 0, null, 0L), bleGattCallback);
    }

    /* renamed from: d0 */
    public BleManager m36151d0(int i) {
        this.f22911g = i;
        return this;
    }

    /* renamed from: e */
    public BleDevice m36150e(BluetoothDevice bluetoothDevice) {
        return new BleDevice(bluetoothDevice);
    }

    /* renamed from: e0 */
    public BleManager m36149e0(int i) {
        return m36147f0(i, 5000L);
    }

    @TargetApi(21)
    /* renamed from: f */
    public BleDevice m36148f(ScanResult scanResult) {
        if (scanResult != null) {
            BluetoothDevice device = scanResult.getDevice();
            int rssi = scanResult.getRssi();
            ScanRecord scanRecord = scanResult.getScanRecord();
            return new BleDevice(device, rssi, scanRecord != null ? scanRecord.getBytes() : null, scanResult.getTimestampNanos());
        }
        throw new IllegalArgumentException("scanResult can not be Null!");
    }

    /* renamed from: f0 */
    public BleManager m36147f0(int i, long j) {
        if (i > 10) {
            i = 10;
        }
        if (j < 0) {
            j = 0;
        }
        this.f22912h = i;
        this.f22913i = j;
        return this;
    }

    /* renamed from: g */
    public void m36146g() {
        MultipleBluetoothController multipleBluetoothController = this.f22908d;
        if (multipleBluetoothController != null) {
            multipleBluetoothController.m36043c();
        }
    }

    /* renamed from: g0 */
    public BleManager m36145g0(int i) {
        if (i > 0) {
            this.f22914j = i;
        }
        return this;
    }

    public Context getContext() {
        return this.f22905a;
    }

    /* renamed from: h */
    public void m36144h() {
        BluetoothAdapter bluetoothAdapter = this.f22907c;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            return;
        }
        this.f22907c.disable();
    }

    /* renamed from: h0 */
    public boolean m36143h0(BleDevice bleDevice, String str, String str2) {
        return m36141i0(bleDevice, str, str2, false);
    }

    /* renamed from: i */
    public void m36142i(BleDevice bleDevice) {
        MultipleBluetoothController multipleBluetoothController = this.f22908d;
        if (multipleBluetoothController != null) {
            multipleBluetoothController.m36042d(bleDevice);
        }
    }

    /* renamed from: i0 */
    public boolean m36141i0(BleDevice bleDevice, String str, String str2, boolean z) {
        BleBluetooth m36040f = this.f22908d.m36040f(bleDevice);
        if (m36040f == null) {
            return false;
        }
        boolean m36071a = m36040f.m36106L().m36048x(str, str2).m36071a(z);
        if (m36071a) {
            m36040f.m36103O(str2);
        }
        return m36071a;
    }

    /* renamed from: j */
    public void m36140j() {
        MultipleBluetoothController multipleBluetoothController = this.f22908d;
        if (multipleBluetoothController != null) {
            multipleBluetoothController.m36041e();
        }
    }

    /* renamed from: j0 */
    public boolean m36139j0(BleDevice bleDevice, String str, String str2) {
        return m36137k0(bleDevice, str, str2, false);
    }

    /* renamed from: k */
    public void m36138k() {
        BluetoothAdapter bluetoothAdapter = this.f22907c;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.enable();
        }
    }

    /* renamed from: k0 */
    public boolean m36137k0(BleDevice bleDevice, String str, String str2, boolean z) {
        BleBluetooth m36040f = this.f22908d.m36040f(bleDevice);
        if (m36040f == null) {
            return false;
        }
        boolean m36070b = m36040f.m36106L().m36048x(str, str2).m36070b(z);
        if (m36070b) {
            m36040f.m36101Q(str2);
        }
        return m36070b;
    }

    /* renamed from: l */
    public BleManager m36136l(boolean z) {
        BleLog.f23051a = z;
        return this;
    }

    /* renamed from: l0 */
    public void m36135l0(BleDevice bleDevice, String str, String str2, byte[] bArr, BleWriteCallback bleWriteCallback) {
        m36133m0(bleDevice, str, str2, bArr, true, bleWriteCallback);
    }

    /* renamed from: m */
    public List<BleDevice> m36134m() {
        MultipleBluetoothController multipleBluetoothController = this.f22908d;
        if (multipleBluetoothController == null) {
            return null;
        }
        return multipleBluetoothController.m36038h();
    }

    /* renamed from: m0 */
    public void m36133m0(BleDevice bleDevice, String str, String str2, byte[] bArr, boolean z, BleWriteCallback bleWriteCallback) {
        m36131n0(bleDevice, str, str2, bArr, z, true, 0L, bleWriteCallback);
    }

    /* renamed from: n */
    public BleBluetooth m36132n(BleDevice bleDevice) {
        MultipleBluetoothController multipleBluetoothController = this.f22908d;
        if (multipleBluetoothController != null) {
            return multipleBluetoothController.m36040f(bleDevice);
        }
        return null;
    }

    /* renamed from: n0 */
    public void m36131n0(BleDevice bleDevice, String str, String str2, byte[] bArr, boolean z, boolean z2, long j, BleWriteCallback bleWriteCallback) {
        if (bleWriteCallback == null) {
            throw new IllegalArgumentException("BleWriteCallback can not be Null!");
        }
        if (bArr == null) {
            BleLog.m35959b("data is Null!");
            bleWriteCallback.mo12754e(new OtherException("data is Null!"));
            return;
        }
        if (bArr.length > 20 && !z) {
            BleLog.m35957d("Be careful: data's length beyond 20! Ensure MTU higher than 23, or use spilt write!");
        }
        BleBluetooth m36040f = this.f22908d.m36040f(bleDevice);
        if (m36040f == null) {
            bleWriteCallback.mo12754e(new OtherException("This device not connect!"));
        } else if (z && bArr.length > m36181D()) {
            new SplitWriter().m36021k(m36040f, str, str2, bArr, z2, j, bleWriteCallback);
        } else {
            m36040f.m36106L().m36048x(str, str2).m36047y(bArr, bleWriteCallback, str2);
        }
    }

    /* renamed from: o */
    public BluetoothAdapter m36130o() {
        return this.f22907c;
    }

    /* renamed from: p */
    public BluetoothGatt m36129p(BleDevice bleDevice) {
        BleBluetooth m36132n = m36132n(bleDevice);
        if (m36132n != null) {
            return m36132n.m36109I();
        }
        return null;
    }

    /* renamed from: q */
    public List<BluetoothGattCharacteristic> m36128q(BluetoothGattService bluetoothGattService) {
        return bluetoothGattService.getCharacteristics();
    }

    /* renamed from: r */
    public List<BluetoothGattService> m36127r(BleDevice bleDevice) {
        BluetoothGatt m36129p = m36129p(bleDevice);
        if (m36129p != null) {
            return m36129p.getServices();
        }
        return null;
    }

    /* renamed from: s */
    public BluetoothManager m36126s() {
        return this.f22909e;
    }

    /* renamed from: t */
    public long m36125t() {
        return this.f22915k;
    }

    /* renamed from: u */
    public int m36124u(BleDevice bleDevice) {
        if (bleDevice != null) {
            return this.f22909e.getConnectionState(bleDevice.m36019a(), 7);
        }
        return 0;
    }

    /* renamed from: w */
    public int m36122w() {
        return this.f22910f;
    }

    /* renamed from: x */
    public MultipleBluetoothController m36121x() {
        return this.f22908d;
    }

    /* renamed from: y */
    public int m36120y() {
        return this.f22911g;
    }

    /* renamed from: z */
    public int m36119z() {
        return this.f22912h;
    }
}
