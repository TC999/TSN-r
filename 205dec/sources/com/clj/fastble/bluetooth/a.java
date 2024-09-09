package com.clj.fastble.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.exception.ConnectException;
import com.clj.fastble.exception.OtherException;
import com.clj.fastble.exception.TimeoutException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import z0.e;
import z0.f;
import z0.g;
import z0.k;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BleBluetooth.java */
@TargetApi(18)
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private z0.b f36599a;

    /* renamed from: b  reason: collision with root package name */
    private g f36600b;

    /* renamed from: c  reason: collision with root package name */
    private z0.d f36601c;

    /* renamed from: h  reason: collision with root package name */
    private b f36606h;

    /* renamed from: j  reason: collision with root package name */
    private BleDevice f36608j;

    /* renamed from: k  reason: collision with root package name */
    private BluetoothGatt f36609k;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, e> f36602d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, z0.c> f36603e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, k> f36604f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, f> f36605g = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private boolean f36607i = false;

    /* renamed from: l  reason: collision with root package name */
    private c f36610l = new c(Looper.getMainLooper());

    /* renamed from: m  reason: collision with root package name */
    private int f36611m = 0;

    /* renamed from: n  reason: collision with root package name */
    private BluetoothGattCallback f36612n = new C0540a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleBluetooth.java */
    /* renamed from: com.clj.fastble.bluetooth.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class C0540a extends BluetoothGattCallback {
        C0540a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            Handler a4;
            Handler a5;
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            for (Map.Entry entry : a.this.f36602d.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof e) {
                    e eVar = (e) value;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(eVar.b()) && (a5 = eVar.a()) != null) {
                        Message obtainMessage = a5.obtainMessage();
                        obtainMessage.what = 19;
                        obtainMessage.obj = eVar;
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("notify_value", bluetoothGattCharacteristic.getValue());
                        obtainMessage.setData(bundle);
                        a5.sendMessage(obtainMessage);
                    }
                }
            }
            for (Map.Entry entry2 : a.this.f36603e.entrySet()) {
                Object value2 = entry2.getValue();
                if (value2 instanceof z0.c) {
                    z0.c cVar = (z0.c) value2;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(cVar.b()) && (a4 = cVar.a()) != null) {
                        Message obtainMessage2 = a4.obtainMessage();
                        obtainMessage2.what = 35;
                        obtainMessage2.obj = cVar;
                        Bundle bundle2 = new Bundle();
                        bundle2.putByteArray("indicate_value", bluetoothGattCharacteristic.getValue());
                        obtainMessage2.setData(bundle2);
                        a4.sendMessage(obtainMessage2);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i4) {
            Handler a4;
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i4);
            for (Map.Entry entry : a.this.f36605g.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof f) {
                    f fVar = (f) value;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(fVar.b()) && (a4 = fVar.a()) != null) {
                        Message obtainMessage = a4.obtainMessage();
                        obtainMessage.what = 66;
                        obtainMessage.obj = fVar;
                        Bundle bundle = new Bundle();
                        bundle.putInt("read_status", i4);
                        bundle.putByteArray("read_value", bluetoothGattCharacteristic.getValue());
                        obtainMessage.setData(bundle);
                        a4.sendMessage(obtainMessage);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i4) {
            Handler a4;
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i4);
            for (Map.Entry entry : a.this.f36604f.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof k) {
                    k kVar = (k) value;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(kVar.b()) && (a4 = kVar.a()) != null) {
                        Message obtainMessage = a4.obtainMessage();
                        obtainMessage.what = 50;
                        obtainMessage.obj = kVar;
                        Bundle bundle = new Bundle();
                        bundle.putInt("write_status", i4);
                        bundle.putByteArray("write_value", bluetoothGattCharacteristic.getValue());
                        obtainMessage.setData(bundle);
                        a4.sendMessage(obtainMessage);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i4, int i5) {
            super.onConnectionStateChange(bluetoothGatt, i4, i5);
            com.clj.fastble.utils.a.c("BluetoothGattCallback\uff1aonConnectionStateChange \nstatus: " + i4 + "\nnewState: " + i5 + "\ncurrentThread: " + Thread.currentThread().getId());
            a.this.f36609k = bluetoothGatt;
            a.this.f36610l.removeMessages(7);
            if (i5 == 2) {
                Message obtainMessage = a.this.f36610l.obtainMessage();
                obtainMessage.what = 4;
                a.this.f36610l.sendMessageDelayed(obtainMessage, 500L);
            } else if (i5 == 0) {
                if (a.this.f36606h == b.CONNECT_CONNECTING) {
                    Message obtainMessage2 = a.this.f36610l.obtainMessage();
                    obtainMessage2.what = 1;
                    obtainMessage2.obj = new com.clj.fastble.data.a(i4);
                    a.this.f36610l.sendMessage(obtainMessage2);
                } else if (a.this.f36606h == b.CONNECT_CONNECTED) {
                    Message obtainMessage3 = a.this.f36610l.obtainMessage();
                    obtainMessage3.what = 2;
                    com.clj.fastble.data.a aVar = new com.clj.fastble.data.a(i4);
                    aVar.c(a.this.f36607i);
                    obtainMessage3.obj = aVar;
                    a.this.f36610l.sendMessage(obtainMessage3);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i4) {
            Handler a4;
            Handler a5;
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i4);
            for (Map.Entry entry : a.this.f36602d.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof e) {
                    e eVar = (e) value;
                    if (bluetoothGattDescriptor.getCharacteristic().getUuid().toString().equalsIgnoreCase(eVar.b()) && (a5 = eVar.a()) != null) {
                        Message obtainMessage = a5.obtainMessage();
                        obtainMessage.what = 18;
                        obtainMessage.obj = eVar;
                        Bundle bundle = new Bundle();
                        bundle.putInt("notify_status", i4);
                        obtainMessage.setData(bundle);
                        a5.sendMessage(obtainMessage);
                    }
                }
            }
            for (Map.Entry entry2 : a.this.f36603e.entrySet()) {
                Object value2 = entry2.getValue();
                if (value2 instanceof z0.c) {
                    z0.c cVar = (z0.c) value2;
                    if (bluetoothGattDescriptor.getCharacteristic().getUuid().toString().equalsIgnoreCase(cVar.b()) && (a4 = cVar.a()) != null) {
                        Message obtainMessage2 = a4.obtainMessage();
                        obtainMessage2.what = 34;
                        obtainMessage2.obj = cVar;
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("indicate_status", i4);
                        obtainMessage2.setData(bundle2);
                        a4.sendMessage(obtainMessage2);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i4, int i5) {
            Handler a4;
            super.onMtuChanged(bluetoothGatt, i4, i5);
            if (a.this.f36601c == null || (a4 = a.this.f36601c.a()) == null) {
                return;
            }
            Message obtainMessage = a4.obtainMessage();
            obtainMessage.what = 98;
            obtainMessage.obj = a.this.f36601c;
            Bundle bundle = new Bundle();
            bundle.putInt("mtu_status", i5);
            bundle.putInt("mtu_value", i4);
            obtainMessage.setData(bundle);
            a4.sendMessage(obtainMessage);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i4, int i5) {
            Handler a4;
            super.onReadRemoteRssi(bluetoothGatt, i4, i5);
            if (a.this.f36600b == null || (a4 = a.this.f36600b.a()) == null) {
                return;
            }
            Message obtainMessage = a4.obtainMessage();
            obtainMessage.what = 82;
            obtainMessage.obj = a.this.f36600b;
            Bundle bundle = new Bundle();
            bundle.putInt("rssi_status", i5);
            bundle.putInt("rssi_value", i4);
            obtainMessage.setData(bundle);
            a4.sendMessage(obtainMessage);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i4) {
            super.onServicesDiscovered(bluetoothGatt, i4);
            com.clj.fastble.utils.a.c("BluetoothGattCallback\uff1aonServicesDiscovered \nstatus: " + i4 + "\ncurrentThread: " + Thread.currentThread().getId());
            a.this.f36609k = bluetoothGatt;
            if (i4 == 0) {
                Message obtainMessage = a.this.f36610l.obtainMessage();
                obtainMessage.what = 6;
                obtainMessage.obj = new com.clj.fastble.data.a(i4);
                a.this.f36610l.sendMessage(obtainMessage);
                return;
            }
            Message obtainMessage2 = a.this.f36610l.obtainMessage();
            obtainMessage2.what = 5;
            a.this.f36610l.sendMessage(obtainMessage2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleBluetooth.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum b {
        CONNECT_IDLE,
        CONNECT_CONNECTING,
        CONNECT_CONNECTED,
        CONNECT_FAILURE,
        CONNECT_DISCONNECT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleBluetooth.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a.this.H();
                    a.this.M();
                    a.this.C();
                    if (a.this.f36611m < com.clj.fastble.a.v().z()) {
                        com.clj.fastble.utils.a.b("Connect fail, try reconnect " + com.clj.fastble.a.v().A() + " millisecond later");
                        a.k(a.this);
                        Message obtainMessage = a.this.f36610l.obtainMessage();
                        obtainMessage.what = 3;
                        a.this.f36610l.sendMessageDelayed(obtainMessage, com.clj.fastble.a.v().A());
                        return;
                    }
                    a.this.f36606h = b.CONNECT_FAILURE;
                    com.clj.fastble.a.v().x().m(a.this);
                    int a4 = ((com.clj.fastble.data.a) message.obj).a();
                    if (a.this.f36599a != null) {
                        a.this.f36599a.c(a.this.f36608j, new ConnectException(a.this.f36609k, a4));
                        return;
                    }
                    return;
                case 2:
                    a.this.f36606h = b.CONNECT_DISCONNECT;
                    com.clj.fastble.a.v().x().l(a.this);
                    a.this.G();
                    a.this.M();
                    a.this.C();
                    a.this.S();
                    a.this.P();
                    a.this.B();
                    a.this.f36610l.removeCallbacksAndMessages(null);
                    com.clj.fastble.data.a aVar = (com.clj.fastble.data.a) message.obj;
                    boolean b4 = aVar.b();
                    int a5 = aVar.a();
                    if (a.this.f36599a != null) {
                        a.this.f36599a.e(b4, a.this.f36608j, a.this.f36609k, a5);
                        return;
                    }
                    return;
                case 3:
                    a aVar2 = a.this;
                    aVar2.E(aVar2.f36608j, false, a.this.f36599a, a.this.f36611m);
                    return;
                case 4:
                    if (a.this.f36609k != null) {
                        if (a.this.f36609k.discoverServices()) {
                            return;
                        }
                        Message obtainMessage2 = a.this.f36610l.obtainMessage();
                        obtainMessage2.what = 5;
                        a.this.f36610l.sendMessage(obtainMessage2);
                        return;
                    }
                    Message obtainMessage3 = a.this.f36610l.obtainMessage();
                    obtainMessage3.what = 5;
                    a.this.f36610l.sendMessage(obtainMessage3);
                    return;
                case 5:
                    a.this.H();
                    a.this.M();
                    a.this.C();
                    a.this.f36606h = b.CONNECT_FAILURE;
                    com.clj.fastble.a.v().x().m(a.this);
                    if (a.this.f36599a != null) {
                        a.this.f36599a.c(a.this.f36608j, new OtherException("GATT discover services exception occurred!"));
                        return;
                    }
                    return;
                case 6:
                    a.this.f36606h = b.CONNECT_CONNECTED;
                    a.this.f36607i = false;
                    com.clj.fastble.a.v().x().m(a.this);
                    com.clj.fastble.a.v().x().a(a.this);
                    int a6 = ((com.clj.fastble.data.a) message.obj).a();
                    if (a.this.f36599a != null) {
                        a.this.f36599a.d(a.this.f36608j, a.this.f36609k, a6);
                        return;
                    }
                    return;
                case 7:
                    a.this.H();
                    a.this.M();
                    a.this.C();
                    a.this.f36606h = b.CONNECT_FAILURE;
                    com.clj.fastble.a.v().x().m(a.this);
                    if (a.this.f36599a != null) {
                        a.this.f36599a.c(a.this.f36608j, new TimeoutException());
                        return;
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public a(BleDevice bleDevice) {
        this.f36608j = bleDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void C() {
        BluetoothGatt bluetoothGatt = this.f36609k;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void H() {
        BluetoothGatt bluetoothGatt = this.f36609k;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void M() {
        BluetoothGatt bluetoothGatt;
        try {
            Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
            if (method != null && (bluetoothGatt = this.f36609k) != null) {
                boolean booleanValue = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                com.clj.fastble.utils.a.c("refreshDeviceCache, is success:  " + booleanValue);
            }
        } catch (Exception e4) {
            com.clj.fastble.utils.a.c("exception occur while refreshing device: " + e4.getMessage());
            e4.printStackTrace();
        }
    }

    static /* synthetic */ int k(a aVar) {
        int i4 = aVar.f36611m + 1;
        aVar.f36611m = i4;
        return i4;
    }

    public synchronized void A(String str, k kVar) {
        this.f36604f.put(str, kVar);
    }

    public synchronized void B() {
        HashMap<String, e> hashMap = this.f36602d;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, z0.c> hashMap2 = this.f36603e;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        HashMap<String, k> hashMap3 = this.f36604f;
        if (hashMap3 != null) {
            hashMap3.clear();
        }
        HashMap<String, f> hashMap4 = this.f36605g;
        if (hashMap4 != null) {
            hashMap4.clear();
        }
    }

    public synchronized BluetoothGatt D(BleDevice bleDevice, boolean z3, z0.b bVar) {
        return E(bleDevice, z3, bVar, 0);
    }

    public synchronized BluetoothGatt E(BleDevice bleDevice, boolean z3, z0.b bVar, int i4) {
        com.clj.fastble.utils.a.c("connect device: " + bleDevice.g() + "\nmac: " + bleDevice.e() + "\nautoConnect: " + z3 + "\ncurrentThread: " + Thread.currentThread().getId() + "\nconnectCount:" + (i4 + 1));
        if (i4 == 0) {
            this.f36611m = 0;
        }
        u(bVar);
        this.f36606h = b.CONNECT_CONNECTING;
        if (Build.VERSION.SDK_INT >= 23) {
            this.f36609k = bleDevice.b().connectGatt(com.clj.fastble.a.v().getContext(), z3, this.f36612n, 2);
        } else {
            this.f36609k = bleDevice.b().connectGatt(com.clj.fastble.a.v().getContext(), z3, this.f36612n);
        }
        if (this.f36609k != null) {
            z0.b bVar2 = this.f36599a;
            if (bVar2 != null) {
                bVar2.f();
            }
            Message obtainMessage = this.f36610l.obtainMessage();
            obtainMessage.what = 7;
            this.f36610l.sendMessageDelayed(obtainMessage, com.clj.fastble.a.v().t());
        } else {
            H();
            M();
            C();
            this.f36606h = b.CONNECT_FAILURE;
            com.clj.fastble.a.v().x().m(this);
            z0.b bVar3 = this.f36599a;
            if (bVar3 != null) {
                bVar3.c(bleDevice, new OtherException("GATT connect exception occurred!"));
            }
        }
        return this.f36609k;
    }

    public synchronized void F() {
        this.f36606h = b.CONNECT_IDLE;
        H();
        M();
        C();
        N();
        S();
        P();
        B();
        this.f36610l.removeCallbacksAndMessages(null);
    }

    public synchronized void G() {
        this.f36607i = true;
        H();
    }

    public BluetoothGatt I() {
        return this.f36609k;
    }

    public BleDevice J() {
        return this.f36608j;
    }

    public String K() {
        return this.f36608j.d();
    }

    public com.clj.fastble.bluetooth.b L() {
        return new com.clj.fastble.bluetooth.b(this);
    }

    public synchronized void N() {
        this.f36599a = null;
    }

    public synchronized void O(String str) {
        if (this.f36603e.containsKey(str)) {
            this.f36603e.remove(str);
        }
    }

    public synchronized void P() {
        this.f36601c = null;
    }

    public synchronized void Q(String str) {
        if (this.f36602d.containsKey(str)) {
            this.f36602d.remove(str);
        }
    }

    public synchronized void R(String str) {
        if (this.f36605g.containsKey(str)) {
            this.f36605g.remove(str);
        }
    }

    public synchronized void S() {
        this.f36600b = null;
    }

    public synchronized void T(String str) {
        if (this.f36604f.containsKey(str)) {
            this.f36604f.remove(str);
        }
    }

    public synchronized void u(z0.b bVar) {
        this.f36599a = bVar;
    }

    public synchronized void v(String str, z0.c cVar) {
        this.f36603e.put(str, cVar);
    }

    public synchronized void w(z0.d dVar) {
        this.f36601c = dVar;
    }

    public synchronized void x(String str, e eVar) {
        this.f36602d.put(str, eVar);
    }

    public synchronized void y(String str, f fVar) {
        this.f36605g.put(str, fVar);
    }

    public synchronized void z(g gVar) {
        this.f36600b = gVar;
    }
}
