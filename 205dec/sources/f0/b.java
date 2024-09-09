package f0;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.exception.BleException;

/* compiled from: BleGattCallback.java */
@TargetApi(18)
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class b extends BluetoothGattCallback {
    public abstract void c(BleDevice bleDevice, BleException bleException);

    public abstract void d(BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i4);

    public abstract void e(boolean z3, BleDevice bleDevice, BluetoothGatt bluetoothGatt, int i4);

    public abstract void f();
}
