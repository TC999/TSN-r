package p589f0;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.exception.BleException;

@TargetApi(18)
/* renamed from: f0.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class BleGattCallback extends BluetoothGattCallback {
    /* renamed from: c */
    public abstract void m12776c(BleDevice bleDevice, BleException bleException);

    /* renamed from: d */
    public abstract void m12775d(BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i);

    /* renamed from: e */
    public abstract void m12774e(boolean z, BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i);

    /* renamed from: f */
    public abstract void m12773f();
}
