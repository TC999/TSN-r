package com.clj.fastble.data;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BleDevice implements Parcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new C6524a();

    /* renamed from: a */
    private BluetoothDevice f22969a;

    /* renamed from: b */
    private byte[] f22970b;

    /* renamed from: c */
    private int f22971c;

    /* renamed from: d */
    private long f22972d;

    /* renamed from: com.clj.fastble.data.BleDevice$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6524a implements Parcelable.Creator<BleDevice> {
        C6524a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BleDevice createFromParcel(Parcel parcel) {
            return new BleDevice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BleDevice[] newArray(int i) {
            return new BleDevice[i];
        }
    }

    public BleDevice(BluetoothDevice bluetoothDevice) {
        this.f22969a = bluetoothDevice;
    }

    /* renamed from: a */
    public BluetoothDevice m36019a() {
        return this.f22969a;
    }

    /* renamed from: b */
    public String m36018b() {
        if (this.f22969a != null) {
            return this.f22969a.getName() + this.f22969a.getAddress();
        }
        return "";
    }

    /* renamed from: c */
    public String m36017c() {
        BluetoothDevice bluetoothDevice = this.f22969a;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getAddress();
        }
        return null;
    }

    /* renamed from: d */
    public String m36016d() {
        BluetoothDevice bluetoothDevice = this.f22969a;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getName();
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public int m36015e() {
        return this.f22971c;
    }

    /* renamed from: f */
    public byte[] m36014f() {
        return this.f22970b;
    }

    /* renamed from: g */
    public long m36013g() {
        return this.f22972d;
    }

    /* renamed from: h */
    public void m36012h(BluetoothDevice bluetoothDevice) {
        this.f22969a = bluetoothDevice;
    }

    /* renamed from: i */
    public void m36011i(int i) {
        this.f22971c = i;
    }

    /* renamed from: j */
    public void m36010j(byte[] bArr) {
        this.f22970b = bArr;
    }

    /* renamed from: k */
    public void m36009k(long j) {
        this.f22972d = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f22969a, i);
        parcel.writeByteArray(this.f22970b);
        parcel.writeInt(this.f22971c);
        parcel.writeLong(this.f22972d);
    }

    public BleDevice(BluetoothDevice bluetoothDevice, int i, byte[] bArr, long j) {
        this.f22969a = bluetoothDevice;
        this.f22970b = bArr;
        this.f22971c = i;
        this.f22972d = j;
    }

    protected BleDevice(Parcel parcel) {
        this.f22969a = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.f22970b = parcel.createByteArray();
        this.f22971c = parcel.readInt();
        this.f22972d = parcel.readLong();
    }
}
