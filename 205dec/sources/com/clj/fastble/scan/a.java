package com.clj.fastble.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.clj.fastble.data.BleDevice;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import z0.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: BleScanPresenter.java */
@TargetApi(18)
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class a implements BluetoothAdapter.LeScanCallback {

    /* renamed from: a  reason: collision with root package name */
    private String[] f36678a;

    /* renamed from: b  reason: collision with root package name */
    private String f36679b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f36680c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36681d;

    /* renamed from: e  reason: collision with root package name */
    private long f36682e;

    /* renamed from: f  reason: collision with root package name */
    private j f36683f;

    /* renamed from: g  reason: collision with root package name */
    private List<BleDevice> f36684g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private Handler f36685h = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    private HandlerThread f36686i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f36687j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f36688k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanPresenter.java */
    /* renamed from: com.clj.fastble.scan.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class RunnableC0541a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BleDevice f36689a;

        RunnableC0541a(BleDevice bleDevice) {
            this.f36689a = bleDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j(this.f36689a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanPresenter.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.clj.fastble.scan.c.b().g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanPresenter.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BleDevice f36692a;

        c(BleDevice bleDevice) {
            this.f36692a = bleDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.m(this.f36692a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanPresenter.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.clj.fastble.scan.c.b().g();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanPresenter.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f36695a;

        e(boolean z3) {
            this.f36695a = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.l(this.f36695a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanPresenter.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.k(aVar.f36684g);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: BleScanPresenter.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private static final class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<a> f36698a;

        g(Looper looper, a aVar) {
            super(looper);
            this.f36698a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BleDevice bleDevice;
            a aVar = this.f36698a.get();
            if (aVar == null || message.what != 0 || (bleDevice = (BleDevice) message.obj) == null) {
                return;
            }
            aVar.f(bleDevice);
        }
    }

    private void c(BleDevice bleDevice) {
        int i4;
        String[] strArr;
        if (TextUtils.isEmpty(this.f36679b) && ((strArr = this.f36678a) == null || strArr.length < 1)) {
            d(bleDevice);
        } else if (TextUtils.isEmpty(this.f36679b) || this.f36679b.equalsIgnoreCase(bleDevice.e())) {
            String[] strArr2 = this.f36678a;
            if (strArr2 != null && strArr2.length > 0) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                String[] strArr3 = this.f36678a;
                int length = strArr3.length;
                while (i4 < length) {
                    String str = strArr3[i4];
                    String g4 = bleDevice.g();
                    if (g4 == null) {
                        g4 = "";
                    }
                    if (this.f36680c) {
                        i4 = g4.contains(str) ? 0 : i4 + 1;
                        atomicBoolean.set(true);
                    } else {
                        if (!g4.equals(str)) {
                        }
                        atomicBoolean.set(true);
                    }
                }
                if (!atomicBoolean.get()) {
                    return;
                }
            }
            d(bleDevice);
        }
    }

    private void d(BleDevice bleDevice) {
        if (this.f36681d) {
            com.clj.fastble.utils.a.c("devices detected  ------  name:" + bleDevice.g() + "  mac:" + bleDevice.e() + "  Rssi:" + bleDevice.h() + "  scanRecord:" + com.clj.fastble.utils.b.j(bleDevice.i()));
            this.f36684g.add(bleDevice);
            this.f36685h.post(new b());
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (BleDevice bleDevice2 : this.f36684g) {
            if (bleDevice2.b().equals(bleDevice.b())) {
                atomicBoolean.set(true);
            }
        }
        if (atomicBoolean.get()) {
            return;
        }
        com.clj.fastble.utils.a.c("device detected  ------  name: " + bleDevice.g() + "  mac: " + bleDevice.e() + "  Rssi: " + bleDevice.h() + "  scanRecord: " + com.clj.fastble.utils.b.k(bleDevice.i(), true));
        this.f36684g.add(bleDevice);
        this.f36685h.post(new c(bleDevice));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(BleDevice bleDevice) {
        this.f36685h.post(new RunnableC0541a(bleDevice));
        c(bleDevice);
    }

    public j e() {
        return this.f36683f;
    }

    public boolean g() {
        return this.f36681d;
    }

    public final void h(boolean z3) {
        this.f36684g.clear();
        o();
        if (z3 && this.f36682e > 0) {
            this.f36685h.postDelayed(new d(), this.f36682e);
        }
        this.f36685h.post(new e(z3));
    }

    public final void i() {
        this.f36688k = false;
        this.f36686i.quit();
        o();
        this.f36685h.post(new f());
    }

    public abstract void j(BleDevice bleDevice);

    public abstract void k(List<BleDevice> list);

    public abstract void l(boolean z3);

    public abstract void m(BleDevice bleDevice);

    public void n(String[] strArr, String str, boolean z3, boolean z4, long j4, j jVar) {
        this.f36678a = strArr;
        this.f36679b = str;
        this.f36680c = z3;
        this.f36681d = z4;
        this.f36682e = j4;
        this.f36683f = jVar;
        HandlerThread handlerThread = new HandlerThread(a.class.getSimpleName());
        this.f36686i = handlerThread;
        handlerThread.start();
        this.f36687j = new g(this.f36686i.getLooper(), this);
        this.f36688k = true;
    }

    public final void o() {
        this.f36685h.removeCallbacksAndMessages(null);
        this.f36687j.removeCallbacksAndMessages(null);
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(BluetoothDevice bluetoothDevice, int i4, byte[] bArr) {
        if (bluetoothDevice != null && this.f36688k) {
            Message obtainMessage = this.f36687j.obtainMessage();
            obtainMessage.what = 0;
            obtainMessage.obj = new BleDevice(bluetoothDevice, i4, bArr, System.currentTimeMillis());
            this.f36687j.sendMessage(obtainMessage);
        }
    }
}
