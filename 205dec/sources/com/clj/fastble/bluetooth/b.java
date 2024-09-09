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
import com.clj.fastble.exception.GattException;
import com.clj.fastble.exception.OtherException;
import com.clj.fastble.exception.TimeoutException;
import java.util.UUID;
import z0.e;
import z0.f;
import z0.g;
import z0.k;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BleConnector.java */
@TargetApi(18)
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    private static final String f36621f = "00002902-0000-1000-8000-00805f9b34fb";

    /* renamed from: a  reason: collision with root package name */
    private BluetoothGatt f36622a;

    /* renamed from: b  reason: collision with root package name */
    private BluetoothGattService f36623b;

    /* renamed from: c  reason: collision with root package name */
    private BluetoothGattCharacteristic f36624c;

    /* renamed from: d  reason: collision with root package name */
    private com.clj.fastble.bluetooth.a f36625d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f36626e = new a(Looper.getMainLooper());

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleConnector.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i4 = message.what;
            if (i4 == 49) {
                k kVar = (k) message.obj;
                if (kVar != null) {
                    kVar.e(new TimeoutException());
                }
            } else if (i4 == 50) {
                b.this.z();
                k kVar2 = (k) message.obj;
                Bundle data = message.getData();
                int i5 = data.getInt("write_status");
                byte[] byteArray = data.getByteArray("write_value");
                if (kVar2 != null) {
                    if (i5 == 0) {
                        kVar2.f(1, 1, byteArray);
                    } else {
                        kVar2.e(new GattException(i5));
                    }
                }
            } else if (i4 == 65) {
                f fVar = (f) message.obj;
                if (fVar != null) {
                    fVar.e(new TimeoutException());
                }
            } else if (i4 == 66) {
                b.this.p();
                f fVar2 = (f) message.obj;
                Bundle data2 = message.getData();
                int i6 = data2.getInt("read_status");
                byte[] byteArray2 = data2.getByteArray("read_value");
                if (fVar2 != null) {
                    if (i6 == 0) {
                        fVar2.f(byteArray2);
                    } else {
                        fVar2.e(new GattException(i6));
                    }
                }
            } else if (i4 == 81) {
                g gVar = (g) message.obj;
                if (gVar != null) {
                    gVar.e(new TimeoutException());
                }
            } else if (i4 == 82) {
                b.this.s();
                g gVar2 = (g) message.obj;
                Bundle data3 = message.getData();
                int i7 = data3.getInt("rssi_status");
                int i8 = data3.getInt("rssi_value");
                if (gVar2 != null) {
                    if (i7 == 0) {
                        gVar2.f(i8);
                    } else {
                        gVar2.e(new GattException(i7));
                    }
                }
            } else if (i4 == 97) {
                z0.d dVar = (z0.d) message.obj;
                if (dVar != null) {
                    dVar.f(new TimeoutException());
                }
            } else if (i4 != 98) {
                switch (i4) {
                    case 17:
                        e eVar = (e) message.obj;
                        if (eVar != null) {
                            eVar.f(new TimeoutException());
                            return;
                        }
                        return;
                    case 18:
                        b.this.n();
                        e eVar2 = (e) message.obj;
                        int i9 = message.getData().getInt("notify_status");
                        if (eVar2 != null) {
                            if (i9 == 0) {
                                eVar2.g();
                                return;
                            } else {
                                eVar2.f(new GattException(i9));
                                return;
                            }
                        }
                        return;
                    case 19:
                        e eVar3 = (e) message.obj;
                        byte[] byteArray3 = message.getData().getByteArray("notify_value");
                        if (eVar3 != null) {
                            eVar3.e(byteArray3);
                            return;
                        }
                        return;
                    default:
                        switch (i4) {
                            case 33:
                                z0.c cVar = (z0.c) message.obj;
                                if (cVar != null) {
                                    cVar.f(new TimeoutException());
                                    return;
                                }
                                return;
                            case 34:
                                b.this.l();
                                z0.c cVar2 = (z0.c) message.obj;
                                int i10 = message.getData().getInt("indicate_status");
                                if (cVar2 != null) {
                                    if (i10 == 0) {
                                        cVar2.g();
                                        return;
                                    } else {
                                        cVar2.f(new GattException(i10));
                                        return;
                                    }
                                }
                                return;
                            case 35:
                                z0.c cVar3 = (z0.c) message.obj;
                                byte[] byteArray4 = message.getData().getByteArray("indicate_value");
                                if (cVar3 != null) {
                                    cVar3.e(byteArray4);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                }
            } else {
                b.this.m();
                z0.d dVar2 = (z0.d) message.obj;
                Bundle data4 = message.getData();
                int i11 = data4.getInt("mtu_status");
                int i12 = data4.getInt("mtu_value");
                if (dVar2 != null) {
                    if (i11 == 0) {
                        dVar2.e(i12);
                    } else {
                        dVar2.f(new GattException(i11));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.clj.fastble.bluetooth.a aVar) {
        this.f36625d = aVar;
        this.f36622a = aVar.I();
    }

    private UUID e(String str) {
        if (str == null) {
            return null;
        }
        return UUID.fromString(str);
    }

    private void f(z0.c cVar, String str) {
        if (cVar != null) {
            l();
            cVar.d(str);
            cVar.c(this.f36626e);
            this.f36625d.v(str, cVar);
            Handler handler = this.f36626e;
            handler.sendMessageDelayed(handler.obtainMessage(33, cVar), com.clj.fastble.a.v().y());
        }
    }

    private void g(e eVar, String str) {
        if (eVar != null) {
            n();
            eVar.d(str);
            eVar.c(this.f36626e);
            this.f36625d.x(str, eVar);
            Handler handler = this.f36626e;
            handler.sendMessageDelayed(handler.obtainMessage(17, eVar), com.clj.fastble.a.v().y());
        }
    }

    private void h(f fVar, String str) {
        if (fVar != null) {
            p();
            fVar.d(str);
            fVar.c(this.f36626e);
            this.f36625d.y(str, fVar);
            Handler handler = this.f36626e;
            handler.sendMessageDelayed(handler.obtainMessage(65, fVar), com.clj.fastble.a.v().y());
        }
    }

    private void i(k kVar, String str) {
        if (kVar != null) {
            z();
            kVar.d(str);
            kVar.c(this.f36626e);
            this.f36625d.A(str, kVar);
            Handler handler = this.f36626e;
            handler.sendMessageDelayed(handler.obtainMessage(49, kVar), com.clj.fastble.a.v().y());
        }
    }

    private void j(g gVar) {
        if (gVar != null) {
            s();
            gVar.c(this.f36626e);
            this.f36625d.z(gVar);
            Handler handler = this.f36626e;
            handler.sendMessageDelayed(handler.obtainMessage(81, gVar), com.clj.fastble.a.v().y());
        }
    }

    private void k(z0.d dVar) {
        if (dVar != null) {
            m();
            dVar.c(this.f36626e);
            this.f36625d.w(dVar);
            Handler handler = this.f36626e;
            handler.sendMessageDelayed(handler.obtainMessage(97, dVar), com.clj.fastble.a.v().y());
        }
    }

    private boolean t(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z3, boolean z4, z0.c cVar) {
        BluetoothGattDescriptor descriptor;
        if (bluetoothGatt != null && bluetoothGattCharacteristic != null) {
            if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z4)) {
                l();
                if (cVar != null) {
                    cVar.f(new OtherException("gatt setCharacteristicNotification fail"));
                }
                return false;
            }
            if (z3) {
                descriptor = bluetoothGattCharacteristic.getDescriptor(bluetoothGattCharacteristic.getUuid());
            } else {
                descriptor = bluetoothGattCharacteristic.getDescriptor(e("00002902-0000-1000-8000-00805f9b34fb"));
            }
            if (descriptor == null) {
                l();
                if (cVar != null) {
                    cVar.f(new OtherException("descriptor equals null"));
                }
                return false;
            }
            descriptor.setValue(z4 ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            boolean writeDescriptor = bluetoothGatt.writeDescriptor(descriptor);
            if (!writeDescriptor) {
                l();
                if (cVar != null) {
                    cVar.f(new OtherException("gatt writeDescriptor fail"));
                }
            }
            return writeDescriptor;
        }
        l();
        if (cVar != null) {
            cVar.f(new OtherException("gatt or characteristic equal null"));
        }
        return false;
    }

    private boolean u(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z3, boolean z4, e eVar) {
        BluetoothGattDescriptor descriptor;
        if (bluetoothGatt != null && bluetoothGattCharacteristic != null) {
            if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z4)) {
                n();
                if (eVar != null) {
                    eVar.f(new OtherException("gatt setCharacteristicNotification fail"));
                }
                return false;
            }
            if (z3) {
                descriptor = bluetoothGattCharacteristic.getDescriptor(bluetoothGattCharacteristic.getUuid());
            } else {
                descriptor = bluetoothGattCharacteristic.getDescriptor(e("00002902-0000-1000-8000-00805f9b34fb"));
            }
            if (descriptor == null) {
                n();
                if (eVar != null) {
                    eVar.f(new OtherException("descriptor equals null"));
                }
                return false;
            }
            descriptor.setValue(z4 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            boolean writeDescriptor = bluetoothGatt.writeDescriptor(descriptor);
            if (!writeDescriptor) {
                n();
                if (eVar != null) {
                    eVar.f(new OtherException("gatt writeDescriptor fail"));
                }
            }
            return writeDescriptor;
        }
        n();
        if (eVar != null) {
            eVar.f(new OtherException("gatt or characteristic equal null"));
        }
        return false;
    }

    private b w(UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        if (uuid != null && (bluetoothGatt = this.f36622a) != null) {
            this.f36623b = bluetoothGatt.getService(uuid);
        }
        BluetoothGattService bluetoothGattService = this.f36623b;
        if (bluetoothGattService != null && uuid2 != null) {
            this.f36624c = bluetoothGattService.getCharacteristic(uuid2);
        }
        return this;
    }

    public boolean a(boolean z3) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f36624c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() | 16) <= 0) {
            return false;
        }
        return t(this.f36622a, this.f36624c, z3, false, null);
    }

    public boolean b(boolean z3) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f36624c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() | 16) <= 0) {
            return false;
        }
        return u(this.f36622a, this.f36624c, z3, false, null);
    }

    public void c(z0.c cVar, String str, boolean z3) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f36624c;
        if (bluetoothGattCharacteristic != null && (bluetoothGattCharacteristic.getProperties() | 16) > 0) {
            f(cVar, str);
            t(this.f36622a, this.f36624c, z3, true, cVar);
        } else if (cVar != null) {
            cVar.f(new OtherException("this characteristic not support indicate!"));
        }
    }

    public void d(e eVar, String str, boolean z3) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f36624c;
        if (bluetoothGattCharacteristic != null && (bluetoothGattCharacteristic.getProperties() | 16) > 0) {
            g(eVar, str);
            u(this.f36622a, this.f36624c, z3, true, eVar);
        } else if (eVar != null) {
            eVar.f(new OtherException("this characteristic not support notify!"));
        }
    }

    public void l() {
        this.f36626e.removeMessages(33);
    }

    public void m() {
        this.f36626e.removeMessages(97);
    }

    public void n() {
        this.f36626e.removeMessages(17);
    }

    public void o(f fVar, String str) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f36624c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 2) <= 0) {
            if (fVar != null) {
                fVar.e(new OtherException("this characteristic not support read!"));
                return;
            }
            return;
        }
        h(fVar, str);
        if (this.f36622a.readCharacteristic(this.f36624c)) {
            return;
        }
        p();
        if (fVar != null) {
            fVar.e(new OtherException("gatt readCharacteristic fail"));
        }
    }

    public void p() {
        this.f36626e.removeMessages(65);
    }

    public void q(g gVar) {
        j(gVar);
        if (this.f36622a.readRemoteRssi()) {
            return;
        }
        s();
        if (gVar != null) {
            gVar.e(new OtherException("gatt readRemoteRssi fail"));
        }
    }

    public boolean r(int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f36622a.requestConnectionPriority(i4);
        }
        return false;
    }

    public void s() {
        this.f36626e.removeMessages(81);
    }

    public void v(int i4, z0.d dVar) {
        if (Build.VERSION.SDK_INT < 21) {
            if (dVar != null) {
                dVar.f(new OtherException("API level lower than 21"));
                return;
            }
            return;
        }
        k(dVar);
        if (this.f36622a.requestMtu(i4)) {
            return;
        }
        m();
        if (dVar != null) {
            dVar.f(new OtherException("gatt requestMtu fail"));
        }
    }

    public b x(String str, String str2) {
        return w(e(str), e(str2));
    }

    public void y(byte[] bArr, k kVar, String str) {
        if (bArr == null || bArr.length <= 0) {
            if (kVar != null) {
                kVar.e(new OtherException("the data to be written is empty"));
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f36624c;
        if (bluetoothGattCharacteristic == null || (bluetoothGattCharacteristic.getProperties() & 12) == 0) {
            if (kVar != null) {
                kVar.e(new OtherException("this characteristic not support write!"));
            }
        } else if (!this.f36624c.setValue(bArr)) {
            if (kVar != null) {
                kVar.e(new OtherException("Updates the locally stored value of this characteristic fail"));
            }
        } else {
            i(kVar, str);
            if (this.f36622a.writeCharacteristic(this.f36624c)) {
                return;
            }
            z();
            if (kVar != null) {
                kVar.e(new OtherException("gatt writeCharacteristic fail"));
            }
        }
    }

    public void z() {
        this.f36626e.removeMessages(49);
    }
}
