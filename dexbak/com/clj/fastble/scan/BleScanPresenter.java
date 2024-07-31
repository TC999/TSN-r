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
import com.clj.fastble.utils.BleLog;
import com.clj.fastble.utils.HexUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p589f0.BleScanPresenterImp;

@TargetApi(18)
/* renamed from: com.clj.fastble.scan.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class BleScanPresenter implements BluetoothAdapter.LeScanCallback {

    /* renamed from: a */
    private String[] f23011a;

    /* renamed from: b */
    private String f23012b;

    /* renamed from: c */
    private boolean f23013c;

    /* renamed from: d */
    private boolean f23014d;

    /* renamed from: e */
    private long f23015e;

    /* renamed from: f */
    private BleScanPresenterImp f23016f;

    /* renamed from: g */
    private List<BleDevice> f23017g = new ArrayList();

    /* renamed from: h */
    private Handler f23018h = new Handler(Looper.getMainLooper());

    /* renamed from: i */
    private HandlerThread f23019i;

    /* renamed from: j */
    private Handler f23020j;

    /* renamed from: k */
    private boolean f23021k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BleScanPresenter.java */
    /* renamed from: com.clj.fastble.scan.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6525a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ BleDevice f23022a;

        RunnableC6525a(BleDevice bleDevice) {
            this.f23022a = bleDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            BleScanPresenter.this.mo35965j(this.f23022a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BleScanPresenter.java */
    /* renamed from: com.clj.fastble.scan.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6526b implements Runnable {
        RunnableC6526b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BleScanner.m35971b().m35966g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BleScanPresenter.java */
    /* renamed from: com.clj.fastble.scan.a$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class RunnableC6527c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ BleDevice f23025a;

        RunnableC6527c(BleDevice bleDevice) {
            this.f23025a = bleDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            BleScanPresenter.this.mo35962m(this.f23025a);
        }
    }

    /* compiled from: BleScanPresenter.java */
    /* renamed from: com.clj.fastble.scan.a$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6528d implements Runnable {
        RunnableC6528d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BleScanner.m35971b().m35966g();
        }
    }

    /* compiled from: BleScanPresenter.java */
    /* renamed from: com.clj.fastble.scan.a$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6529e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f23028a;

        RunnableC6529e(boolean z) {
            this.f23028a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            BleScanPresenter.this.mo35963l(this.f23028a);
        }
    }

    /* compiled from: BleScanPresenter.java */
    /* renamed from: com.clj.fastble.scan.a$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6530f implements Runnable {
        RunnableC6530f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BleScanPresenter bleScanPresenter = BleScanPresenter.this;
            bleScanPresenter.mo35964k(bleScanPresenter.f23017g);
        }
    }

    /* compiled from: BleScanPresenter.java */
    /* renamed from: com.clj.fastble.scan.a$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static final class HandlerC6531g extends Handler {

        /* renamed from: a */
        private final WeakReference<BleScanPresenter> f23031a;

        HandlerC6531g(Looper looper, BleScanPresenter bleScanPresenter) {
            super(looper);
            this.f23031a = new WeakReference<>(bleScanPresenter);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BleDevice bleDevice;
            BleScanPresenter bleScanPresenter = this.f23031a.get();
            if (bleScanPresenter == null || message.what != 0 || (bleDevice = (BleDevice) message.obj) == null) {
                return;
            }
            bleScanPresenter.m35997f(bleDevice);
        }
    }

    /* renamed from: c */
    private void m36000c(BleDevice bleDevice) {
        int i;
        String[] strArr;
        if (TextUtils.isEmpty(this.f23012b) && ((strArr = this.f23011a) == null || strArr.length < 1)) {
            m35999d(bleDevice);
        } else if (TextUtils.isEmpty(this.f23012b) || this.f23012b.equalsIgnoreCase(bleDevice.m36017c())) {
            String[] strArr2 = this.f23011a;
            if (strArr2 != null && strArr2.length > 0) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                String[] strArr3 = this.f23011a;
                int length = strArr3.length;
                while (i < length) {
                    String str = strArr3[i];
                    String m36016d = bleDevice.m36016d();
                    if (m36016d == null) {
                        m36016d = "";
                    }
                    if (this.f23013c) {
                        i = m36016d.contains(str) ? 0 : i + 1;
                        atomicBoolean.set(true);
                    } else {
                        if (!m36016d.equals(str)) {
                        }
                        atomicBoolean.set(true);
                    }
                }
                if (!atomicBoolean.get()) {
                    return;
                }
            }
            m35999d(bleDevice);
        }
    }

    /* renamed from: d */
    private void m35999d(BleDevice bleDevice) {
        if (this.f23014d) {
            BleLog.m35958c("devices detected  ------  name:" + bleDevice.m36016d() + "  mac:" + bleDevice.m36017c() + "  Rssi:" + bleDevice.m36015e() + "  scanRecord:" + HexUtil.m35947j(bleDevice.m36014f()));
            this.f23017g.add(bleDevice);
            this.f23018h.post(new RunnableC6526b());
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (BleDevice bleDevice2 : this.f23017g) {
            if (bleDevice2.m36019a().equals(bleDevice.m36019a())) {
                atomicBoolean.set(true);
            }
        }
        if (atomicBoolean.get()) {
            return;
        }
        BleLog.m35958c("device detected  ------  name: " + bleDevice.m36016d() + "  mac: " + bleDevice.m36017c() + "  Rssi: " + bleDevice.m36015e() + "  scanRecord: " + HexUtil.m35946k(bleDevice.m36014f(), true));
        this.f23017g.add(bleDevice);
        this.f23018h.post(new RunnableC6527c(bleDevice));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m35997f(BleDevice bleDevice) {
        this.f23018h.post(new RunnableC6525a(bleDevice));
        m36000c(bleDevice);
    }

    /* renamed from: e */
    public BleScanPresenterImp m35998e() {
        return this.f23016f;
    }

    /* renamed from: g */
    public boolean m35996g() {
        return this.f23014d;
    }

    /* renamed from: h */
    public final void m35995h(boolean z) {
        this.f23017g.clear();
        m35992o();
        if (z && this.f23015e > 0) {
            this.f23018h.postDelayed(new RunnableC6528d(), this.f23015e);
        }
        this.f23018h.post(new RunnableC6529e(z));
    }

    /* renamed from: i */
    public final void m35994i() {
        this.f23021k = false;
        this.f23019i.quit();
        m35992o();
        this.f23018h.post(new RunnableC6530f());
    }

    /* renamed from: j */
    public abstract void mo35965j(BleDevice bleDevice);

    /* renamed from: k */
    public abstract void mo35964k(List<BleDevice> list);

    /* renamed from: l */
    public abstract void mo35963l(boolean z);

    /* renamed from: m */
    public abstract void mo35962m(BleDevice bleDevice);

    /* renamed from: n */
    public void m35993n(String[] strArr, String str, boolean z, boolean z2, long j, BleScanPresenterImp bleScanPresenterImp) {
        this.f23011a = strArr;
        this.f23012b = str;
        this.f23013c = z;
        this.f23014d = z2;
        this.f23015e = j;
        this.f23016f = bleScanPresenterImp;
        HandlerThread handlerThread = new HandlerThread(BleScanPresenter.class.getSimpleName());
        this.f23019i = handlerThread;
        handlerThread.start();
        this.f23020j = new HandlerC6531g(this.f23019i.getLooper(), this);
        this.f23021k = true;
    }

    /* renamed from: o */
    public final void m35992o() {
        this.f23018h.removeCallbacksAndMessages(null);
        this.f23020j.removeCallbacksAndMessages(null);
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (bluetoothDevice != null && this.f23021k) {
            Message obtainMessage = this.f23020j.obtainMessage();
            obtainMessage.what = 0;
            obtainMessage.obj = new BleDevice(bluetoothDevice, i, bArr, System.currentTimeMillis());
            this.f23020j.sendMessage(obtainMessage);
        }
    }
}
