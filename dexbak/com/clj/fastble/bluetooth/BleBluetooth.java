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
import com.clj.fastble.BleManager;
import com.clj.fastble.data.BleConnectStateParameter;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleMsg;
import com.clj.fastble.exception.ConnectException;
import com.clj.fastble.exception.OtherException;
import com.clj.fastble.exception.TimeoutException;
import com.clj.fastble.utils.BleLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import p589f0.BleGattCallback;
import p589f0.BleIndicateCallback;
import p589f0.BleMtuChangedCallback;
import p589f0.BleNotifyCallback;
import p589f0.BleReadCallback;
import p589f0.BleRssiCallback;
import p589f0.BleWriteCallback;

@TargetApi(18)
/* renamed from: com.clj.fastble.bluetooth.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BleBluetooth {

    /* renamed from: a */
    private BleGattCallback f22923a;

    /* renamed from: b */
    private BleRssiCallback f22924b;

    /* renamed from: c */
    private BleMtuChangedCallback f22925c;

    /* renamed from: h */
    private EnumC6518b f22930h;

    /* renamed from: j */
    private BleDevice f22932j;

    /* renamed from: k */
    private BluetoothGatt f22933k;

    /* renamed from: d */
    private HashMap<String, BleNotifyCallback> f22926d = new HashMap<>();

    /* renamed from: e */
    private HashMap<String, BleIndicateCallback> f22927e = new HashMap<>();

    /* renamed from: f */
    private HashMap<String, BleWriteCallback> f22928f = new HashMap<>();

    /* renamed from: g */
    private HashMap<String, BleReadCallback> f22929g = new HashMap<>();

    /* renamed from: i */
    private boolean f22931i = false;

    /* renamed from: l */
    private HandlerC6519c f22934l = new HandlerC6519c(Looper.getMainLooper());

    /* renamed from: m */
    private int f22935m = 0;

    /* renamed from: n */
    private BluetoothGattCallback f22936n = new C6517a();

    /* compiled from: BleBluetooth.java */
    /* renamed from: com.clj.fastble.bluetooth.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6517a extends BluetoothGattCallback {
        C6517a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            Handler m12780a;
            Handler m12780a2;
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            for (Map.Entry entry : BleBluetooth.this.f22926d.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof BleNotifyCallback) {
                    BleNotifyCallback bleNotifyCallback = (BleNotifyCallback) value;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(bleNotifyCallback.m12779b()) && (m12780a2 = bleNotifyCallback.m12780a()) != null) {
                        Message obtainMessage = m12780a2.obtainMessage();
                        obtainMessage.what = 19;
                        obtainMessage.obj = bleNotifyCallback;
                        Bundle bundle = new Bundle();
                        bundle.putByteArray(BleMsg.f22996m, bluetoothGattCharacteristic.getValue());
                        obtainMessage.setData(bundle);
                        m12780a2.sendMessage(obtainMessage);
                    }
                }
            }
            for (Map.Entry entry2 : BleBluetooth.this.f22927e.entrySet()) {
                Object value2 = entry2.getValue();
                if (value2 instanceof BleIndicateCallback) {
                    BleIndicateCallback bleIndicateCallback = (BleIndicateCallback) value2;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(bleIndicateCallback.m12779b()) && (m12780a = bleIndicateCallback.m12780a()) != null) {
                        Message obtainMessage2 = m12780a.obtainMessage();
                        obtainMessage2.what = 35;
                        obtainMessage2.obj = bleIndicateCallback;
                        Bundle bundle2 = new Bundle();
                        bundle2.putByteArray(BleMsg.f23001r, bluetoothGattCharacteristic.getValue());
                        obtainMessage2.setData(bundle2);
                        m12780a.sendMessage(obtainMessage2);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Handler m12780a;
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            for (Map.Entry entry : BleBluetooth.this.f22929g.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof BleReadCallback) {
                    BleReadCallback bleReadCallback = (BleReadCallback) value;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(bleReadCallback.m12779b()) && (m12780a = bleReadCallback.m12780a()) != null) {
                        Message obtainMessage = m12780a.obtainMessage();
                        obtainMessage.what = 66;
                        obtainMessage.obj = bleReadCallback;
                        Bundle bundle = new Bundle();
                        bundle.putInt(BleMsg.f23009z, i);
                        bundle.putByteArray(BleMsg.f22975A, bluetoothGattCharacteristic.getValue());
                        obtainMessage.setData(bundle);
                        m12780a.sendMessage(obtainMessage);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Handler m12780a;
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            for (Map.Entry entry : BleBluetooth.this.f22928f.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof BleWriteCallback) {
                    BleWriteCallback bleWriteCallback = (BleWriteCallback) value;
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(bleWriteCallback.m12779b()) && (m12780a = bleWriteCallback.m12780a()) != null) {
                        Message obtainMessage = m12780a.obtainMessage();
                        obtainMessage.what = 50;
                        obtainMessage.obj = bleWriteCallback;
                        Bundle bundle = new Bundle();
                        bundle.putInt(BleMsg.f23005v, i);
                        bundle.putByteArray(BleMsg.f23006w, bluetoothGattCharacteristic.getValue());
                        obtainMessage.setData(bundle);
                        m12780a.sendMessage(obtainMessage);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            BleLog.m35958c("BluetoothGattCallback：onConnectionStateChange \nstatus: " + i + "\nnewState: " + i2 + "\ncurrentThread: " + Thread.currentThread().getId());
            BleBluetooth.this.f22933k = bluetoothGatt;
            BleBluetooth.this.f22934l.removeMessages(7);
            if (i2 == 2) {
                Message obtainMessage = BleBluetooth.this.f22934l.obtainMessage();
                obtainMessage.what = 4;
                BleBluetooth.this.f22934l.sendMessageDelayed(obtainMessage, 500L);
            } else if (i2 == 0) {
                if (BleBluetooth.this.f22930h == EnumC6518b.CONNECT_CONNECTING) {
                    Message obtainMessage2 = BleBluetooth.this.f22934l.obtainMessage();
                    obtainMessage2.what = 1;
                    obtainMessage2.obj = new BleConnectStateParameter(i);
                    BleBluetooth.this.f22934l.sendMessage(obtainMessage2);
                } else if (BleBluetooth.this.f22930h == EnumC6518b.CONNECT_CONNECTED) {
                    Message obtainMessage3 = BleBluetooth.this.f22934l.obtainMessage();
                    obtainMessage3.what = 2;
                    BleConnectStateParameter bleConnectStateParameter = new BleConnectStateParameter(i);
                    bleConnectStateParameter.m36004c(BleBluetooth.this.f22931i);
                    obtainMessage3.obj = bleConnectStateParameter;
                    BleBluetooth.this.f22934l.sendMessage(obtainMessage3);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            Handler m12780a;
            Handler m12780a2;
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            for (Map.Entry entry : BleBluetooth.this.f22926d.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof BleNotifyCallback) {
                    BleNotifyCallback bleNotifyCallback = (BleNotifyCallback) value;
                    if (bluetoothGattDescriptor.getCharacteristic().getUuid().toString().equalsIgnoreCase(bleNotifyCallback.m12779b()) && (m12780a2 = bleNotifyCallback.m12780a()) != null) {
                        Message obtainMessage = m12780a2.obtainMessage();
                        obtainMessage.what = 18;
                        obtainMessage.obj = bleNotifyCallback;
                        Bundle bundle = new Bundle();
                        bundle.putInt(BleMsg.f22995l, i);
                        obtainMessage.setData(bundle);
                        m12780a2.sendMessage(obtainMessage);
                    }
                }
            }
            for (Map.Entry entry2 : BleBluetooth.this.f22927e.entrySet()) {
                Object value2 = entry2.getValue();
                if (value2 instanceof BleIndicateCallback) {
                    BleIndicateCallback bleIndicateCallback = (BleIndicateCallback) value2;
                    if (bluetoothGattDescriptor.getCharacteristic().getUuid().toString().equalsIgnoreCase(bleIndicateCallback.m12779b()) && (m12780a = bleIndicateCallback.m12780a()) != null) {
                        Message obtainMessage2 = m12780a.obtainMessage();
                        obtainMessage2.what = 34;
                        obtainMessage2.obj = bleIndicateCallback;
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt(BleMsg.f23000q, i);
                        obtainMessage2.setData(bundle2);
                        m12780a.sendMessage(obtainMessage2);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            Handler m12780a;
            super.onMtuChanged(bluetoothGatt, i, i2);
            if (BleBluetooth.this.f22925c == null || (m12780a = BleBluetooth.this.f22925c.m12780a()) == null) {
                return;
            }
            Message obtainMessage = m12780a.obtainMessage();
            obtainMessage.what = 98;
            obtainMessage.obj = BleBluetooth.this.f22925c;
            Bundle bundle = new Bundle();
            bundle.putInt(BleMsg.f22982H, i2);
            bundle.putInt(BleMsg.f22983I, i);
            obtainMessage.setData(bundle);
            m12780a.sendMessage(obtainMessage);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            Handler m12780a;
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            if (BleBluetooth.this.f22924b == null || (m12780a = BleBluetooth.this.f22924b.m12780a()) == null) {
                return;
            }
            Message obtainMessage = m12780a.obtainMessage();
            obtainMessage.what = 82;
            obtainMessage.obj = BleBluetooth.this.f22924b;
            Bundle bundle = new Bundle();
            bundle.putInt(BleMsg.f22978D, i2);
            bundle.putInt(BleMsg.f22979E, i);
            obtainMessage.setData(bundle);
            m12780a.sendMessage(obtainMessage);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            super.onServicesDiscovered(bluetoothGatt, i);
            BleLog.m35958c("BluetoothGattCallback：onServicesDiscovered \nstatus: " + i + "\ncurrentThread: " + Thread.currentThread().getId());
            BleBluetooth.this.f22933k = bluetoothGatt;
            if (i == 0) {
                Message obtainMessage = BleBluetooth.this.f22934l.obtainMessage();
                obtainMessage.what = 6;
                obtainMessage.obj = new BleConnectStateParameter(i);
                BleBluetooth.this.f22934l.sendMessage(obtainMessage);
                return;
            }
            Message obtainMessage2 = BleBluetooth.this.f22934l.obtainMessage();
            obtainMessage2.what = 5;
            BleBluetooth.this.f22934l.sendMessage(obtainMessage2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BleBluetooth.java */
    /* renamed from: com.clj.fastble.bluetooth.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public enum EnumC6518b {
        CONNECT_IDLE,
        CONNECT_CONNECTING,
        CONNECT_CONNECTED,
        CONNECT_FAILURE,
        CONNECT_DISCONNECT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BleBluetooth.java */
    /* renamed from: com.clj.fastble.bluetooth.a$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public final class HandlerC6519c extends Handler {
        HandlerC6519c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    BleBluetooth.this.m36110H();
                    BleBluetooth.this.m36105M();
                    BleBluetooth.this.m36115C();
                    if (BleBluetooth.this.f22935m < BleManager.m36123v().m36119z()) {
                        BleLog.m35959b("Connect fail, try reconnect " + BleManager.m36123v().m36184A() + " millisecond later");
                        BleBluetooth.m36087k(BleBluetooth.this);
                        Message obtainMessage = BleBluetooth.this.f22934l.obtainMessage();
                        obtainMessage.what = 3;
                        BleBluetooth.this.f22934l.sendMessageDelayed(obtainMessage, BleManager.m36123v().m36184A());
                        return;
                    }
                    BleBluetooth.this.f22930h = EnumC6518b.CONNECT_FAILURE;
                    BleManager.m36123v().m36121x().m36033m(BleBluetooth.this);
                    int m36006a = ((BleConnectStateParameter) message.obj).m36006a();
                    if (BleBluetooth.this.f22923a != null) {
                        BleBluetooth.this.f22923a.m12776c(BleBluetooth.this.f22932j, new ConnectException(BleBluetooth.this.f22933k, m36006a));
                        return;
                    }
                    return;
                case 2:
                    BleBluetooth.this.f22930h = EnumC6518b.CONNECT_DISCONNECT;
                    BleManager.m36123v().m36121x().m36034l(BleBluetooth.this);
                    BleBluetooth.this.m36111G();
                    BleBluetooth.this.m36105M();
                    BleBluetooth.this.m36115C();
                    BleBluetooth.this.m36099S();
                    BleBluetooth.this.m36102P();
                    BleBluetooth.this.m36116B();
                    BleBluetooth.this.f22934l.removeCallbacksAndMessages(null);
                    BleConnectStateParameter bleConnectStateParameter = (BleConnectStateParameter) message.obj;
                    boolean m36005b = bleConnectStateParameter.m36005b();
                    int m36006a2 = bleConnectStateParameter.m36006a();
                    if (BleBluetooth.this.f22923a != null) {
                        BleBluetooth.this.f22923a.m12774e(m36005b, BleBluetooth.this.f22932j, BleBluetooth.this.f22933k, m36006a2);
                        return;
                    }
                    return;
                case 3:
                    BleBluetooth bleBluetooth = BleBluetooth.this;
                    bleBluetooth.m36113E(bleBluetooth.f22932j, false, BleBluetooth.this.f22923a, BleBluetooth.this.f22935m);
                    return;
                case 4:
                    if (BleBluetooth.this.f22933k != null) {
                        if (BleBluetooth.this.f22933k.discoverServices()) {
                            return;
                        }
                        Message obtainMessage2 = BleBluetooth.this.f22934l.obtainMessage();
                        obtainMessage2.what = 5;
                        BleBluetooth.this.f22934l.sendMessage(obtainMessage2);
                        return;
                    }
                    Message obtainMessage3 = BleBluetooth.this.f22934l.obtainMessage();
                    obtainMessage3.what = 5;
                    BleBluetooth.this.f22934l.sendMessage(obtainMessage3);
                    return;
                case 5:
                    BleBluetooth.this.m36110H();
                    BleBluetooth.this.m36105M();
                    BleBluetooth.this.m36115C();
                    BleBluetooth.this.f22930h = EnumC6518b.CONNECT_FAILURE;
                    BleManager.m36123v().m36121x().m36033m(BleBluetooth.this);
                    if (BleBluetooth.this.f22923a != null) {
                        BleBluetooth.this.f22923a.m12776c(BleBluetooth.this.f22932j, new OtherException("GATT discover services exception occurred!"));
                        return;
                    }
                    return;
                case 6:
                    BleBluetooth.this.f22930h = EnumC6518b.CONNECT_CONNECTED;
                    BleBluetooth.this.f22931i = false;
                    BleManager.m36123v().m36121x().m36033m(BleBluetooth.this);
                    BleManager.m36123v().m36121x().m36045a(BleBluetooth.this);
                    int m36006a3 = ((BleConnectStateParameter) message.obj).m36006a();
                    if (BleBluetooth.this.f22923a != null) {
                        BleBluetooth.this.f22923a.m12775d(BleBluetooth.this.f22932j, BleBluetooth.this.f22933k, m36006a3);
                        return;
                    }
                    return;
                case 7:
                    BleBluetooth.this.m36110H();
                    BleBluetooth.this.m36105M();
                    BleBluetooth.this.m36115C();
                    BleBluetooth.this.f22930h = EnumC6518b.CONNECT_FAILURE;
                    BleManager.m36123v().m36121x().m36033m(BleBluetooth.this);
                    if (BleBluetooth.this.f22923a != null) {
                        BleBluetooth.this.f22923a.m12776c(BleBluetooth.this.f22932j, new TimeoutException());
                        return;
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public BleBluetooth(BleDevice bleDevice) {
        this.f22932j = bleDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public synchronized void m36115C() {
        BluetoothGatt bluetoothGatt = this.f22933k;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public synchronized void m36110H() {
        BluetoothGatt bluetoothGatt = this.f22933k;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public synchronized void m36105M() {
        BluetoothGatt bluetoothGatt;
        try {
            Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
            if (method != null && (bluetoothGatt = this.f22933k) != null) {
                boolean booleanValue = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                BleLog.m35958c("refreshDeviceCache, is success:  " + booleanValue);
            }
        } catch (Exception e) {
            BleLog.m35958c("exception occur while refreshing device: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    static /* synthetic */ int m36087k(BleBluetooth bleBluetooth) {
        int i = bleBluetooth.f22935m + 1;
        bleBluetooth.f22935m = i;
        return i;
    }

    /* renamed from: A */
    public synchronized void m36117A(String str, BleWriteCallback bleWriteCallback) {
        this.f22928f.put(str, bleWriteCallback);
    }

    /* renamed from: B */
    public synchronized void m36116B() {
        HashMap<String, BleNotifyCallback> hashMap = this.f22926d;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, BleIndicateCallback> hashMap2 = this.f22927e;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        HashMap<String, BleWriteCallback> hashMap3 = this.f22928f;
        if (hashMap3 != null) {
            hashMap3.clear();
        }
        HashMap<String, BleReadCallback> hashMap4 = this.f22929g;
        if (hashMap4 != null) {
            hashMap4.clear();
        }
    }

    /* renamed from: D */
    public synchronized BluetoothGatt m36114D(BleDevice bleDevice, boolean z, BleGattCallback bleGattCallback) {
        return m36113E(bleDevice, z, bleGattCallback, 0);
    }

    /* renamed from: E */
    public synchronized BluetoothGatt m36113E(BleDevice bleDevice, boolean z, BleGattCallback bleGattCallback, int i) {
        BleLog.m35958c("connect device: " + bleDevice.m36016d() + "\nmac: " + bleDevice.m36017c() + "\nautoConnect: " + z + "\ncurrentThread: " + Thread.currentThread().getId() + "\nconnectCount:" + (i + 1));
        if (i == 0) {
            this.f22935m = 0;
        }
        m36077u(bleGattCallback);
        this.f22930h = EnumC6518b.CONNECT_CONNECTING;
        if (Build.VERSION.SDK_INT >= 23) {
            this.f22933k = bleDevice.m36019a().connectGatt(BleManager.m36123v().getContext(), z, this.f22936n, 2);
        } else {
            this.f22933k = bleDevice.m36019a().connectGatt(BleManager.m36123v().getContext(), z, this.f22936n);
        }
        if (this.f22933k != null) {
            BleGattCallback bleGattCallback2 = this.f22923a;
            if (bleGattCallback2 != null) {
                bleGattCallback2.m12773f();
            }
            Message obtainMessage = this.f22934l.obtainMessage();
            obtainMessage.what = 7;
            this.f22934l.sendMessageDelayed(obtainMessage, BleManager.m36123v().m36125t());
        } else {
            m36110H();
            m36105M();
            m36115C();
            this.f22930h = EnumC6518b.CONNECT_FAILURE;
            BleManager.m36123v().m36121x().m36033m(this);
            BleGattCallback bleGattCallback3 = this.f22923a;
            if (bleGattCallback3 != null) {
                bleGattCallback3.m12776c(bleDevice, new OtherException("GATT connect exception occurred!"));
            }
        }
        return this.f22933k;
    }

    /* renamed from: F */
    public synchronized void m36112F() {
        this.f22930h = EnumC6518b.CONNECT_IDLE;
        m36110H();
        m36105M();
        m36115C();
        m36104N();
        m36099S();
        m36102P();
        m36116B();
        this.f22934l.removeCallbacksAndMessages(null);
    }

    /* renamed from: G */
    public synchronized void m36111G() {
        this.f22931i = true;
        m36110H();
    }

    /* renamed from: I */
    public BluetoothGatt m36109I() {
        return this.f22933k;
    }

    /* renamed from: J */
    public BleDevice m36108J() {
        return this.f22932j;
    }

    /* renamed from: K */
    public String m36107K() {
        return this.f22932j.m36018b();
    }

    /* renamed from: L */
    public BleConnector m36106L() {
        return new BleConnector(this);
    }

    /* renamed from: N */
    public synchronized void m36104N() {
        this.f22923a = null;
    }

    /* renamed from: O */
    public synchronized void m36103O(String str) {
        if (this.f22927e.containsKey(str)) {
            this.f22927e.remove(str);
        }
    }

    /* renamed from: P */
    public synchronized void m36102P() {
        this.f22925c = null;
    }

    /* renamed from: Q */
    public synchronized void m36101Q(String str) {
        if (this.f22926d.containsKey(str)) {
            this.f22926d.remove(str);
        }
    }

    /* renamed from: R */
    public synchronized void m36100R(String str) {
        if (this.f22929g.containsKey(str)) {
            this.f22929g.remove(str);
        }
    }

    /* renamed from: S */
    public synchronized void m36099S() {
        this.f22924b = null;
    }

    /* renamed from: T */
    public synchronized void m36098T(String str) {
        if (this.f22928f.containsKey(str)) {
            this.f22928f.remove(str);
        }
    }

    /* renamed from: u */
    public synchronized void m36077u(BleGattCallback bleGattCallback) {
        this.f22923a = bleGattCallback;
    }

    /* renamed from: v */
    public synchronized void m36076v(String str, BleIndicateCallback bleIndicateCallback) {
        this.f22927e.put(str, bleIndicateCallback);
    }

    /* renamed from: w */
    public synchronized void m36075w(BleMtuChangedCallback bleMtuChangedCallback) {
        this.f22925c = bleMtuChangedCallback;
    }

    /* renamed from: x */
    public synchronized void m36074x(String str, BleNotifyCallback bleNotifyCallback) {
        this.f22926d.put(str, bleNotifyCallback);
    }

    /* renamed from: y */
    public synchronized void m36073y(String str, BleReadCallback bleReadCallback) {
        this.f22929g.put(str, bleReadCallback);
    }

    /* renamed from: z */
    public synchronized void m36072z(BleRssiCallback bleRssiCallback) {
        this.f22924b = bleRssiCallback;
    }
}
