package com.clj.fastble.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.clj.fastble.BleManager;
import com.clj.fastble.data.BleMsg;
import com.clj.fastble.exception.GattException;
import com.clj.fastble.exception.OtherException;
import com.clj.fastble.exception.TimeoutException;
import java.util.UUID;
import p589f0.BleIndicateCallback;
import p589f0.BleMtuChangedCallback;
import p589f0.BleNotifyCallback;
import p589f0.BleReadCallback;
import p589f0.BleRssiCallback;
import p589f0.BleWriteCallback;

@TargetApi(18)
/* renamed from: com.clj.fastble.bluetooth.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BleConnector {

    /* renamed from: f */
    private static final String f22945f = "00002902-0000-1000-8000-00805f9b34fb";

    /* renamed from: a */
    private BluetoothGatt f22946a;

    /* renamed from: b */
    private BluetoothGattService f22947b;

    /* renamed from: c */
    private BluetoothGattCharacteristic f22948c;

    /* renamed from: d */
    private BleBluetooth f22949d;

    /* renamed from: e */
    private Handler f22950e = new HandlerC6520a(Looper.getMainLooper());

    /* compiled from: BleConnector.java */
    /* renamed from: com.clj.fastble.bluetooth.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class HandlerC6520a extends Handler {
        HandlerC6520a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 49) {
                BleWriteCallback bleWriteCallback = (BleWriteCallback) message.obj;
                if (bleWriteCallback != null) {
                    bleWriteCallback.mo12754e(new TimeoutException());
                }
            } else if (i == 50) {
                BleConnector.this.m36046z();
                BleWriteCallback bleWriteCallback2 = (BleWriteCallback) message.obj;
                Bundle data = message.getData();
                int i2 = data.getInt(BleMsg.f23005v);
                byte[] byteArray = data.getByteArray(BleMsg.f23006w);
                if (bleWriteCallback2 != null) {
                    if (i2 == 0) {
                        bleWriteCallback2.mo12753f(1, 1, byteArray);
                    } else {
                        bleWriteCallback2.mo12754e(new GattException(i2));
                    }
                }
            } else if (i == 65) {
                BleReadCallback bleReadCallback = (BleReadCallback) message.obj;
                if (bleReadCallback != null) {
                    bleReadCallback.m12764e(new TimeoutException());
                }
            } else if (i == 66) {
                BleConnector.this.m36056p();
                BleReadCallback bleReadCallback2 = (BleReadCallback) message.obj;
                Bundle data2 = message.getData();
                int i3 = data2.getInt(BleMsg.f23009z);
                byte[] byteArray2 = data2.getByteArray(BleMsg.f22975A);
                if (bleReadCallback2 != null) {
                    if (i3 == 0) {
                        bleReadCallback2.m12763f(byteArray2);
                    } else {
                        bleReadCallback2.m12764e(new GattException(i3));
                    }
                }
            } else if (i == 81) {
                BleRssiCallback bleRssiCallback = (BleRssiCallback) message.obj;
                if (bleRssiCallback != null) {
                    bleRssiCallback.m12762e(new TimeoutException());
                }
            } else if (i == 82) {
                BleConnector.this.m36053s();
                BleRssiCallback bleRssiCallback2 = (BleRssiCallback) message.obj;
                Bundle data3 = message.getData();
                int i4 = data3.getInt(BleMsg.f22978D);
                int i5 = data3.getInt(BleMsg.f22979E);
                if (bleRssiCallback2 != null) {
                    if (i4 == 0) {
                        bleRssiCallback2.m12761f(i5);
                    } else {
                        bleRssiCallback2.m12762e(new GattException(i4));
                    }
                }
            } else if (i == 97) {
                BleMtuChangedCallback bleMtuChangedCallback = (BleMtuChangedCallback) message.obj;
                if (bleMtuChangedCallback != null) {
                    bleMtuChangedCallback.m12768f(new TimeoutException());
                }
            } else if (i != 98) {
                switch (i) {
                    case 17:
                        BleNotifyCallback bleNotifyCallback = (BleNotifyCallback) message.obj;
                        if (bleNotifyCallback != null) {
                            bleNotifyCallback.m12766f(new TimeoutException());
                            return;
                        }
                        return;
                    case 18:
                        BleConnector.this.m36058n();
                        BleNotifyCallback bleNotifyCallback2 = (BleNotifyCallback) message.obj;
                        int i6 = message.getData().getInt(BleMsg.f22995l);
                        if (bleNotifyCallback2 != null) {
                            if (i6 == 0) {
                                bleNotifyCallback2.m12765g();
                                return;
                            } else {
                                bleNotifyCallback2.m12766f(new GattException(i6));
                                return;
                            }
                        }
                        return;
                    case 19:
                        BleNotifyCallback bleNotifyCallback3 = (BleNotifyCallback) message.obj;
                        byte[] byteArray3 = message.getData().getByteArray(BleMsg.f22996m);
                        if (bleNotifyCallback3 != null) {
                            bleNotifyCallback3.m12767e(byteArray3);
                            return;
                        }
                        return;
                    default:
                        switch (i) {
                            case 33:
                                BleIndicateCallback bleIndicateCallback = (BleIndicateCallback) message.obj;
                                if (bleIndicateCallback != null) {
                                    bleIndicateCallback.m12771f(new TimeoutException());
                                    return;
                                }
                                return;
                            case 34:
                                BleConnector.this.m36060l();
                                BleIndicateCallback bleIndicateCallback2 = (BleIndicateCallback) message.obj;
                                int i7 = message.getData().getInt(BleMsg.f23000q);
                                if (bleIndicateCallback2 != null) {
                                    if (i7 == 0) {
                                        bleIndicateCallback2.m12770g();
                                        return;
                                    } else {
                                        bleIndicateCallback2.m12771f(new GattException(i7));
                                        return;
                                    }
                                }
                                return;
                            case 35:
                                BleIndicateCallback bleIndicateCallback3 = (BleIndicateCallback) message.obj;
                                byte[] byteArray4 = message.getData().getByteArray(BleMsg.f23001r);
                                if (bleIndicateCallback3 != null) {
                                    bleIndicateCallback3.m12772e(byteArray4);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                }
            } else {
                BleConnector.this.m36059m();
                BleMtuChangedCallback bleMtuChangedCallback2 = (BleMtuChangedCallback) message.obj;
                Bundle data4 = message.getData();
                int i8 = data4.getInt(BleMsg.f22982H);
                int i9 = data4.getInt(BleMsg.f22983I);
                if (bleMtuChangedCallback2 != null) {
                    if (i8 == 0) {
                        bleMtuChangedCallback2.m12769e(i9);
                    } else {
                        bleMtuChangedCallback2.m12768f(new GattException(i8));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BleConnector(BleBluetooth bleBluetooth) {
        this.f22949d = bleBluetooth;
        this.f22946a = bleBluetooth.m36109I();
    }

    /* renamed from: e */
    private UUID m36067e(String str) {
        if (str == null) {
            return null;
        }
        return UUID.fromString(str);
    }

    /* renamed from: f */
    private void m36066f(BleIndicateCallback bleIndicateCallback, String str) {
        if (bleIndicateCallback != null) {
            m36060l();
            bleIndicateCallback.m12777d(str);
            bleIndicateCallback.m12778c(this.f22950e);
            this.f22949d.m36076v(str, bleIndicateCallback);
            Handler handler = this.f22950e;
            handler.sendMessageDelayed(handler.obtainMessage(33, bleIndicateCallback), BleManager.m36123v().m36120y());
        }
    }

    /* renamed from: g */
    private void m36065g(BleNotifyCallback bleNotifyCallback, String str) {
        if (bleNotifyCallback != null) {
            m36058n();
            bleNotifyCallback.m12777d(str);
            bleNotifyCallback.m12778c(this.f22950e);
            this.f22949d.m36074x(str, bleNotifyCallback);
            Handler handler = this.f22950e;
            handler.sendMessageDelayed(handler.obtainMessage(17, bleNotifyCallback), BleManager.m36123v().m36120y());
        }
    }

    /* renamed from: h */
    private void m36064h(BleReadCallback bleReadCallback, String str) {
        if (bleReadCallback != null) {
            m36056p();
            bleReadCallback.m12777d(str);
            bleReadCallback.m12778c(this.f22950e);
            this.f22949d.m36073y(str, bleReadCallback);
            Handler handler = this.f22950e;
            handler.sendMessageDelayed(handler.obtainMessage(65, bleReadCallback), BleManager.m36123v().m36120y());
        }
    }

    /* renamed from: i */
    private void m36063i(BleWriteCallback bleWriteCallback, String str) {
        if (bleWriteCallback != null) {
            m36046z();
            bleWriteCallback.m12777d(str);
            bleWriteCallback.m12778c(this.f22950e);
            this.f22949d.m36117A(str, bleWriteCallback);
            Handler handler = this.f22950e;
            handler.sendMessageDelayed(handler.obtainMessage(49, bleWriteCallback), BleManager.m36123v().m36120y());
        }
    }

    /* renamed from: j */
    private void m36062j(BleRssiCallback bleRssiCallback) {
        if (bleRssiCallback != null) {
            m36053s();
            bleRssiCallback.m12778c(this.f22950e);
            this.f22949d.m36072z(bleRssiCallback);
            Handler handler = this.f22950e;
            handler.sendMessageDelayed(handler.obtainMessage(81, bleRssiCallback), BleManager.m36123v().m36120y());
        }
    }

    /* renamed from: k */
    private void m36061k(BleMtuChangedCallback bleMtuChangedCallback) {
        if (bleMtuChangedCallback != null) {
            m36059m();
            bleMtuChangedCallback.m12778c(this.f22950e);
            this.f22949d.m36075w(bleMtuChangedCallback);
            Handler handler = this.f22950e;
            handler.sendMessageDelayed(handler.obtainMessage(97, bleMtuChangedCallback), BleManager.m36123v().m36120y());
        }
    }

    /* renamed from: t */
    private boolean m36052t(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, BleIndicateCallback bleIndicateCallback) {
        BluetoothGattDescriptor descriptor;
        if (bluetoothGatt != null && bluetoothGattCharacteristic != null) {
            if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z2)) {
                m36060l();
                if (bleIndicateCallback != null) {
                    bleIndicateCallback.m12771f(new OtherException("gatt setCharacteristicNotification fail"));
                }
                return false;
            }
            if (z) {
                descriptor = bluetoothGattCharacteristic.getDescriptor(bluetoothGattCharacteristic.getUuid());
            } else {
                descriptor = bluetoothGattCharacteristic.getDescriptor(m36067e(f22945f));
            }
            if (descriptor == null) {
                m36060l();
                if (bleIndicateCallback != null) {
                    bleIndicateCallback.m12771f(new OtherException("descriptor equals null"));
                }
                return false;
            }
            descriptor.setValue(z2 ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            boolean writeDescriptor = bluetoothGatt.writeDescriptor(descriptor);
            if (!writeDescriptor) {
                m36060l();
                if (bleIndicateCallback != null) {
                    bleIndicateCallback.m12771f(new OtherException("gatt writeDescriptor fail"));
                }
            }
            return writeDescriptor;
        }
        m36060l();
        if (bleIndicateCallback != null) {
            bleIndicateCallback.m12771f(new OtherException("gatt or characteristic equal null"));
        }
        return false;
    }

    /* renamed from: u */
    private boolean m36051u(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, BleNotifyCallback bleNotifyCallback) {
        BluetoothGattDescriptor descriptor;
        if (bluetoothGatt != null && bluetoothGattCharacteristic != null) {
            if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z2)) {
                m36058n();
                if (bleNotifyCallback != null) {
                    bleNotifyCallback.m12766f(new OtherException("gatt setCharacteristicNotification fail"));
                }
                return false;
            }
            if (z) {
                descriptor = bluetoothGattCharacteristic.getDescriptor(bluetoothGattCharacteristic.getUuid());
            } else {
                descriptor = bluetoothGattCharacteristic.getDescriptor(m36067e(f22945f));
            }
            if (descriptor == null) {
                m36058n();
                if (bleNotifyCallback != null) {
                    bleNotifyCallback.m12766f(new OtherException("descriptor equals null"));
                }
                return false;
            }
            descriptor.setValue(z2 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            boolean writeDescriptor = bluetoothGatt.writeDescriptor(descriptor);
            if (!writeDescriptor) {
                m36058n();
                if (bleNotifyCallback != null) {
                    bleNotifyCallback.m12766f(new OtherException("gatt writeDescriptor fail"));
                }
            }
            return writeDescriptor;
        }
        m36058n();
        if (bleNotifyCallback != null) {
            bleNotifyCallback.m12766f(new OtherException("gatt or characteristic equal null"));
        }
        return false;
    }

    /* renamed from: w */
    private BleConnector m36049w(UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        if (uuid != null && (bluetoothGatt = this.f22946a) != null) {
            this.f22947b = bluetoothGatt.getService(uuid);
        }
        BluetoothGattService bluetoothGattService = this.f22947b;
        if (bluetoothGattService != null && uuid2 != null) {
            this.f22948c = bluetoothGattService.getCharacteristic(uuid2);
        }
        return this;
    }

    /* renamed from: a */
    public boolean m36071a(boolean z) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f22948c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() | 16) <= 0) {
            return false;
        }
        return m36052t(this.f22946a, this.f22948c, z, false, null);
    }

    /* renamed from: b */
    public boolean m36070b(boolean z) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f22948c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() | 16) <= 0) {
            return false;
        }
        return m36051u(this.f22946a, this.f22948c, z, false, null);
    }

    /* renamed from: c */
    public void m36069c(BleIndicateCallback bleIndicateCallback, String str, boolean z) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f22948c;
        if (bluetoothGattCharacteristic != null && (bluetoothGattCharacteristic.getProperties() | 16) > 0) {
            m36066f(bleIndicateCallback, str);
            m36052t(this.f22946a, this.f22948c, z, true, bleIndicateCallback);
        } else if (bleIndicateCallback != null) {
            bleIndicateCallback.m12771f(new OtherException("this characteristic not support indicate!"));
        }
    }

    /* renamed from: d */
    public void m36068d(BleNotifyCallback bleNotifyCallback, String str, boolean z) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f22948c;
        if (bluetoothGattCharacteristic != null && (bluetoothGattCharacteristic.getProperties() | 16) > 0) {
            m36065g(bleNotifyCallback, str);
            m36051u(this.f22946a, this.f22948c, z, true, bleNotifyCallback);
        } else if (bleNotifyCallback != null) {
            bleNotifyCallback.m12766f(new OtherException("this characteristic not support notify!"));
        }
    }

    /* renamed from: l */
    public void m36060l() {
        this.f22950e.removeMessages(33);
    }

    /* renamed from: m */
    public void m36059m() {
        this.f22950e.removeMessages(97);
    }

    /* renamed from: n */
    public void m36058n() {
        this.f22950e.removeMessages(17);
    }

    /* renamed from: o */
    public void m36057o(BleReadCallback bleReadCallback, String str) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f22948c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 2) <= 0) {
            if (bleReadCallback != null) {
                bleReadCallback.m12764e(new OtherException("this characteristic not support read!"));
                return;
            }
            return;
        }
        m36064h(bleReadCallback, str);
        if (this.f22946a.readCharacteristic(this.f22948c)) {
            return;
        }
        m36056p();
        if (bleReadCallback != null) {
            bleReadCallback.m12764e(new OtherException("gatt readCharacteristic fail"));
        }
    }

    /* renamed from: p */
    public void m36056p() {
        this.f22950e.removeMessages(65);
    }

    /* renamed from: q */
    public void m36055q(BleRssiCallback bleRssiCallback) {
        m36062j(bleRssiCallback);
        if (this.f22946a.readRemoteRssi()) {
            return;
        }
        m36053s();
        if (bleRssiCallback != null) {
            bleRssiCallback.m12762e(new OtherException("gatt readRemoteRssi fail"));
        }
    }

    /* renamed from: r */
    public boolean m36054r(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f22946a.requestConnectionPriority(i);
        }
        return false;
    }

    /* renamed from: s */
    public void m36053s() {
        this.f22950e.removeMessages(81);
    }

    /* renamed from: v */
    public void m36050v(int i, BleMtuChangedCallback bleMtuChangedCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            if (bleMtuChangedCallback != null) {
                bleMtuChangedCallback.m12768f(new OtherException("API level lower than 21"));
                return;
            }
            return;
        }
        m36061k(bleMtuChangedCallback);
        if (this.f22946a.requestMtu(i)) {
            return;
        }
        m36059m();
        if (bleMtuChangedCallback != null) {
            bleMtuChangedCallback.m12768f(new OtherException("gatt requestMtu fail"));
        }
    }

    /* renamed from: x */
    public BleConnector m36048x(String str, String str2) {
        return m36049w(m36067e(str), m36067e(str2));
    }

    /* renamed from: y */
    public void m36047y(byte[] bArr, BleWriteCallback bleWriteCallback, String str) {
        if (bArr == null || bArr.length <= 0) {
            if (bleWriteCallback != null) {
                bleWriteCallback.mo12754e(new OtherException("the data to be written is empty"));
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f22948c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 12) == 0) {
            if (bleWriteCallback != null) {
                bleWriteCallback.mo12754e(new OtherException("this characteristic not support write!"));
            }
        } else if (!this.f22948c.setValue(bArr)) {
            if (bleWriteCallback != null) {
                bleWriteCallback.mo12754e(new OtherException("Updates the locally stored value of this characteristic fail"));
            }
        } else {
            m36063i(bleWriteCallback, str);
            if (this.f22946a.writeCharacteristic(this.f22948c)) {
                return;
            }
            m36046z();
            if (bleWriteCallback != null) {
                bleWriteCallback.mo12754e(new OtherException("gatt writeCharacteristic fail"));
            }
        }
    }

    /* renamed from: z */
    public void m36046z() {
        this.f22950e.removeMessages(49);
    }
}
