package com.clj.fastble.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Build;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.utils.BleLruHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MultipleBluetoothController.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final BleLruHashMap<String, com.clj.fastble.bluetooth.a> f36628a = new BleLruHashMap<>(com.clj.fastble.a.v().w());

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, com.clj.fastble.bluetooth.a> f36629b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: MultipleBluetoothController.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class a implements Comparator<com.clj.fastble.bluetooth.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.clj.fastble.bluetooth.a aVar, com.clj.fastble.bluetooth.a aVar2) {
            return aVar.K().compareToIgnoreCase(aVar2.K());
        }
    }

    public synchronized void a(com.clj.fastble.bluetooth.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!this.f36628a.containsKey(aVar.K())) {
            this.f36628a.put(aVar.K(), aVar);
        }
    }

    public synchronized com.clj.fastble.bluetooth.a b(BleDevice bleDevice) {
        com.clj.fastble.bluetooth.a aVar;
        aVar = new com.clj.fastble.bluetooth.a(bleDevice);
        if (!this.f36629b.containsKey(aVar.K())) {
            this.f36629b.put(aVar.K(), aVar);
        }
        return aVar;
    }

    public synchronized void c() {
        for (Map.Entry<String, com.clj.fastble.bluetooth.a> entry : this.f36628a.entrySet()) {
            entry.getValue().F();
        }
        this.f36628a.clear();
        for (Map.Entry<String, com.clj.fastble.bluetooth.a> entry2 : this.f36629b.entrySet()) {
            entry2.getValue().F();
        }
        this.f36629b.clear();
    }

    public synchronized void d(BleDevice bleDevice) {
        if (j(bleDevice)) {
            f(bleDevice).G();
        }
    }

    public synchronized void e() {
        for (Map.Entry<String, com.clj.fastble.bluetooth.a> entry : this.f36628a.entrySet()) {
            entry.getValue().G();
        }
        this.f36628a.clear();
    }

    public synchronized com.clj.fastble.bluetooth.a f(BleDevice bleDevice) {
        if (bleDevice != null) {
            if (this.f36628a.containsKey(bleDevice.d())) {
                return this.f36628a.get(bleDevice.d());
            }
        }
        return null;
    }

    public synchronized List<com.clj.fastble.bluetooth.a> g() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f36628a.values());
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    public synchronized List<BleDevice> h() {
        ArrayList arrayList;
        k();
        arrayList = new ArrayList();
        for (com.clj.fastble.bluetooth.a aVar : g()) {
            if (aVar != null) {
                arrayList.add(aVar.J());
            }
        }
        return arrayList;
    }

    public synchronized boolean i(BluetoothDevice bluetoothDevice) {
        boolean z3;
        if (bluetoothDevice != null) {
            BleLruHashMap<String, com.clj.fastble.bluetooth.a> bleLruHashMap = this.f36628a;
            StringBuilder sb = new StringBuilder();
            sb.append(bluetoothDevice.getName());
            sb.append(bluetoothDevice.getAddress());
            z3 = bleLruHashMap.containsKey(sb.toString()) ? true : true;
        }
        z3 = false;
        return z3;
    }

    public synchronized boolean j(BleDevice bleDevice) {
        boolean z3;
        if (bleDevice != null) {
            z3 = this.f36628a.containsKey(bleDevice.d()) ? true : true;
        }
        z3 = false;
        return z3;
    }

    public void k() {
        if (Build.VERSION.SDK_INT >= 18) {
            List<com.clj.fastble.bluetooth.a> g4 = g();
            for (int i4 = 0; g4 != null && i4 < g4.size(); i4++) {
                com.clj.fastble.bluetooth.a aVar = g4.get(i4);
                if (!com.clj.fastble.a.v().J(aVar.J())) {
                    l(aVar);
                }
            }
        }
    }

    public synchronized void l(com.clj.fastble.bluetooth.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f36628a.containsKey(aVar.K())) {
            this.f36628a.remove(aVar.K());
        }
    }

    public synchronized void m(com.clj.fastble.bluetooth.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f36629b.containsKey(aVar.K())) {
            this.f36629b.remove(aVar.K());
        }
    }
}
