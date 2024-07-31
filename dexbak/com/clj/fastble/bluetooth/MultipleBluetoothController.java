package com.clj.fastble.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Build;
import com.clj.fastble.BleManager;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.utils.BleLruHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.clj.fastble.bluetooth.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MultipleBluetoothController {

    /* renamed from: a */
    private final BleLruHashMap<String, BleBluetooth> f22952a = new BleLruHashMap<>(BleManager.m36123v().m36122w());

    /* renamed from: b */
    private final HashMap<String, BleBluetooth> f22953b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultipleBluetoothController.java */
    /* renamed from: com.clj.fastble.bluetooth.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6521a implements Comparator<BleBluetooth> {
        C6521a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(BleBluetooth bleBluetooth, BleBluetooth bleBluetooth2) {
            return bleBluetooth.m36107K().compareToIgnoreCase(bleBluetooth2.m36107K());
        }
    }

    /* renamed from: a */
    public synchronized void m36045a(BleBluetooth bleBluetooth) {
        if (bleBluetooth == null) {
            return;
        }
        if (!this.f22952a.containsKey(bleBluetooth.m36107K())) {
            this.f22952a.put(bleBluetooth.m36107K(), bleBluetooth);
        }
    }

    /* renamed from: b */
    public synchronized BleBluetooth m36044b(BleDevice bleDevice) {
        BleBluetooth bleBluetooth;
        bleBluetooth = new BleBluetooth(bleDevice);
        if (!this.f22953b.containsKey(bleBluetooth.m36107K())) {
            this.f22953b.put(bleBluetooth.m36107K(), bleBluetooth);
        }
        return bleBluetooth;
    }

    /* renamed from: c */
    public synchronized void m36043c() {
        for (Map.Entry<String, BleBluetooth> entry : this.f22952a.entrySet()) {
            entry.getValue().m36112F();
        }
        this.f22952a.clear();
        for (Map.Entry<String, BleBluetooth> entry2 : this.f22953b.entrySet()) {
            entry2.getValue().m36112F();
        }
        this.f22953b.clear();
    }

    /* renamed from: d */
    public synchronized void m36042d(BleDevice bleDevice) {
        if (m36036j(bleDevice)) {
            m36040f(bleDevice).m36111G();
        }
    }

    /* renamed from: e */
    public synchronized void m36041e() {
        for (Map.Entry<String, BleBluetooth> entry : this.f22952a.entrySet()) {
            entry.getValue().m36111G();
        }
        this.f22952a.clear();
    }

    /* renamed from: f */
    public synchronized BleBluetooth m36040f(BleDevice bleDevice) {
        if (bleDevice != null) {
            if (this.f22952a.containsKey(bleDevice.m36018b())) {
                return this.f22952a.get(bleDevice.m36018b());
            }
        }
        return null;
    }

    /* renamed from: g */
    public synchronized List<BleBluetooth> m36039g() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f22952a.values());
        Collections.sort(arrayList, new C6521a());
        return arrayList;
    }

    /* renamed from: h */
    public synchronized List<BleDevice> m36038h() {
        ArrayList arrayList;
        m36035k();
        arrayList = new ArrayList();
        for (BleBluetooth bleBluetooth : m36039g()) {
            if (bleBluetooth != null) {
                arrayList.add(bleBluetooth.m36108J());
            }
        }
        return arrayList;
    }

    /* renamed from: i */
    public synchronized boolean m36037i(BluetoothDevice bluetoothDevice) {
        boolean z;
        if (bluetoothDevice != null) {
            BleLruHashMap<String, BleBluetooth> bleLruHashMap = this.f22952a;
            StringBuilder sb = new StringBuilder();
            sb.append(bluetoothDevice.getName());
            sb.append(bluetoothDevice.getAddress());
            z = bleLruHashMap.containsKey(sb.toString()) ? true : true;
        }
        z = false;
        return z;
    }

    /* renamed from: j */
    public synchronized boolean m36036j(BleDevice bleDevice) {
        boolean z;
        if (bleDevice != null) {
            z = this.f22952a.containsKey(bleDevice.m36018b()) ? true : true;
        }
        z = false;
        return z;
    }

    /* renamed from: k */
    public void m36035k() {
        if (Build.VERSION.SDK_INT >= 18) {
            List<BleBluetooth> m36039g = m36039g();
            for (int i = 0; m36039g != null && i < m36039g.size(); i++) {
                BleBluetooth bleBluetooth = m36039g.get(i);
                if (!BleManager.m36123v().m36175J(bleBluetooth.m36108J())) {
                    m36034l(bleBluetooth);
                }
            }
        }
    }

    /* renamed from: l */
    public synchronized void m36034l(BleBluetooth bleBluetooth) {
        if (bleBluetooth == null) {
            return;
        }
        if (this.f22952a.containsKey(bleBluetooth.m36107K())) {
            this.f22952a.remove(bleBluetooth.m36107K());
        }
    }

    /* renamed from: m */
    public synchronized void m36033m(BleBluetooth bleBluetooth) {
        if (bleBluetooth == null) {
            return;
        }
        if (this.f22953b.containsKey(bleBluetooth.m36107K())) {
            this.f22953b.remove(bleBluetooth.m36107K());
        }
    }
}
