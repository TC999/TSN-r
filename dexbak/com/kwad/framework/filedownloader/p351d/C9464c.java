package com.kwad.framework.filedownloader.p351d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.framework.filedownloader.p353f.C9501f;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.umeng.analytics.pro.C13131bm;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.kwad.framework.filedownloader.d.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9464c implements Parcelable {
    public static final Parcelable.Creator<C9464c> CREATOR = new Parcelable.Creator<C9464c>() { // from class: com.kwad.framework.filedownloader.d.c.1
        /* renamed from: bE */
        private static C9464c[] m28678bE(int i) {
            return new C9464c[i];
        }

        /* renamed from: c */
        private static C9464c m28677c(Parcel parcel) {
            return new C9464c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ C9464c createFromParcel(Parcel parcel) {
            return m28677c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ C9464c[] newArray(int i) {
            return m28678bE(i);
        }
    };

    /* renamed from: VM */
    private String f29476VM;
    private boolean ahE;
    private final AtomicInteger ahF;
    private final AtomicLong ahG;
    private long ahH;
    private String ahI;
    private String ahJ;
    private int ahK;
    private boolean ahr;
    private String filename;

    /* renamed from: id */
    private int f29477id;
    private String url;

    public C9464c() {
        this.ahG = new AtomicLong();
        this.ahF = new AtomicInteger();
    }

    /* renamed from: wn */
    private String m28681wn() {
        return this.ahI;
    }

    /* renamed from: S */
    public final void m28697S(long j) {
        this.ahG.set(j);
    }

    /* renamed from: T */
    public final void m28696T(long j) {
        this.ahG.addAndGet(j);
    }

    /* renamed from: U */
    public final void m28695U(long j) {
        this.ahr = j > 2147483647L;
        this.ahH = j;
    }

    /* renamed from: bD */
    public final void m28694bD(int i) {
        this.ahK = i;
    }

    /* renamed from: bn */
    public final void m28693bn(String str) {
        this.ahJ = str;
    }

    /* renamed from: bo */
    public final void m28692bo(String str) {
        this.ahI = str;
    }

    /* renamed from: bp */
    public final void m28691bp(String str) {
        this.filename = str;
    }

    /* renamed from: d */
    public final void m28689d(String str, boolean z) {
        this.f29476VM = str;
        this.ahE = z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getId() {
        return this.f29477id;
    }

    public final String getPath() {
        return this.f29476VM;
    }

    public final String getTargetFilePath() {
        return C9501f.m28521a(getPath(), m28688tR(), getFilename());
    }

    public final long getTotal() {
        return this.ahH;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isChunked() {
        return this.ahH == -1;
    }

    public final void setId(int i) {
        this.f29477id = i;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    /* renamed from: tR */
    public final boolean m28688tR() {
        return this.ahE;
    }

    /* renamed from: tV */
    public final byte m28687tV() {
        return (byte) this.ahF.get();
    }

    public final String toString() {
        return C9501f.m28515b("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f29477id), this.url, this.f29476VM, Integer.valueOf(this.ahF.get()), this.ahG, Long.valueOf(this.ahH), this.ahJ, super.toString());
    }

    /* renamed from: ub */
    public final boolean m28686ub() {
        return this.ahr;
    }

    /* renamed from: vD */
    public final String m28685vD() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return C9501f.m28508bt(getTargetFilePath());
    }

    /* renamed from: wj */
    public final ContentValues m28684wj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C13131bm.f37927d, Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put("path", getPath());
        contentValues.put("status", Byte.valueOf(m28687tV()));
        contentValues.put("sofar", Long.valueOf(m28683wl()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put("errMsg", m28681wn());
        contentValues.put(DownloadModel.ETAG, m28682wm());
        contentValues.put("connectionCount", Integer.valueOf(m28680wo()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(m28688tR()));
        if (m28688tR() && getFilename() != null) {
            contentValues.put("filename", getFilename());
        }
        return contentValues;
    }

    /* renamed from: wl */
    public final long m28683wl() {
        return this.ahG.get();
    }

    /* renamed from: wm */
    public final String m28682wm() {
        return this.ahJ;
    }

    /* renamed from: wo */
    public final int m28680wo() {
        return this.ahK;
    }

    /* renamed from: wp */
    public final void m28679wp() {
        this.ahK = 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f29477id);
        parcel.writeString(this.url);
        parcel.writeString(this.f29476VM);
        parcel.writeByte(this.ahE ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.ahF.get());
        parcel.writeLong(this.ahG.get());
        parcel.writeLong(this.ahH);
        parcel.writeString(this.ahI);
        parcel.writeString(this.ahJ);
        parcel.writeInt(this.ahK);
        parcel.writeByte(this.ahr ? (byte) 1 : (byte) 0);
    }

    /* renamed from: d */
    public final void m28690d(byte b) {
        this.ahF.set(b);
    }

    protected C9464c(Parcel parcel) {
        this.f29477id = parcel.readInt();
        this.url = parcel.readString();
        this.f29476VM = parcel.readString();
        this.ahE = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.ahF = new AtomicInteger(parcel.readByte());
        this.ahG = new AtomicLong(parcel.readLong());
        this.ahH = parcel.readLong();
        this.ahI = parcel.readString();
        this.ahJ = parcel.readString();
        this.ahK = parcel.readInt();
        this.ahr = parcel.readByte() != 0;
    }
}
