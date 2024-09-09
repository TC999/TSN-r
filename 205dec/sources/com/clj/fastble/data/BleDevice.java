package com.clj.fastble.data;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BleDevice implements Parcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private BluetoothDevice f36645a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f36646b;

    /* renamed from: c  reason: collision with root package name */
    private int f36647c;

    /* renamed from: d  reason: collision with root package name */
    private long f36648d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static class a implements Parcelable.Creator<BleDevice> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BleDevice createFromParcel(Parcel parcel) {
            return new BleDevice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BleDevice[] newArray(int i4) {
            return new BleDevice[i4];
        }
    }

    public BleDevice(BluetoothDevice bluetoothDevice) {
        this.f36645a = bluetoothDevice;
    }

    public BluetoothDevice b() {
        return this.f36645a;
    }

    public String d() {
        if (this.f36645a != null) {
            return this.f36645a.getName() + this.f36645a.getAddress();
        }
        return "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        BluetoothDevice bluetoothDevice = this.f36645a;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getAddress();
        }
        return null;
    }

    public String g() {
        BluetoothDevice bluetoothDevice = this.f36645a;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getName();
        }
        return null;
    }

    public int h() {
        return this.f36647c;
    }

    public byte[] i() {
        return this.f36646b;
    }

    public long j() {
        return this.f36648d;
    }

    public void k(BluetoothDevice bluetoothDevice) {
        this.f36645a = bluetoothDevice;
    }

    public void l(int i4) {
        this.f36647c = i4;
    }

    public void m(byte[] bArr) {
        this.f36646b = bArr;
    }

    public void n(long j4) {
        this.f36648d = j4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f36645a, i4);
        parcel.writeByteArray(this.f36646b);
        parcel.writeInt(this.f36647c);
        parcel.writeLong(this.f36648d);
    }

    public BleDevice(BluetoothDevice bluetoothDevice, int i4, byte[] bArr, long j4) {
        this.f36645a = bluetoothDevice;
        this.f36646b = bArr;
        this.f36647c = i4;
        this.f36648d = j4;
    }

    protected BleDevice(Parcel parcel) {
        this.f36645a = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.f36646b = parcel.createByteArray();
        this.f36647c = parcel.readInt();
        this.f36648d = parcel.readLong();
    }
}
