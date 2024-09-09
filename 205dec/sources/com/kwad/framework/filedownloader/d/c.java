package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.framework.filedownloader.f.f;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwad.framework.filedownloader.d.c.1
        private static c[] bE(int i4) {
            return new c[i4];
        }

        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i4) {
            return bE(i4);
        }
    };
    private String VM;
    private boolean ahE;
    private final AtomicInteger ahF;
    private final AtomicLong ahG;
    private long ahH;
    private String ahI;
    private String ahJ;
    private int ahK;
    private boolean ahr;
    private String filename;
    private int id;
    private String url;

    public c() {
        this.ahG = new AtomicLong();
        this.ahF = new AtomicInteger();
    }

    private String wn() {
        return this.ahI;
    }

    public final void S(long j4) {
        this.ahG.set(j4);
    }

    public final void T(long j4) {
        this.ahG.addAndGet(j4);
    }

    public final void U(long j4) {
        this.ahr = j4 > 2147483647L;
        this.ahH = j4;
    }

    public final void bD(int i4) {
        this.ahK = i4;
    }

    public final void bn(String str) {
        this.ahJ = str;
    }

    public final void bo(String str) {
        this.ahI = str;
    }

    public final void bp(String str) {
        this.filename = str;
    }

    public final void d(String str, boolean z3) {
        this.VM = str;
        this.ahE = z3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPath() {
        return this.VM;
    }

    public final String getTargetFilePath() {
        return f.a(getPath(), tR(), getFilename());
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

    public final void setId(int i4) {
        this.id = i4;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final boolean tR() {
        return this.ahE;
    }

    public final byte tV() {
        return (byte) this.ahF.get();
    }

    public final String toString() {
        return f.b("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.id), this.url, this.VM, Integer.valueOf(this.ahF.get()), this.ahG, Long.valueOf(this.ahH), this.ahJ, super.toString());
    }

    public final boolean ub() {
        return this.ahr;
    }

    public final String vD() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return f.bt(getTargetFilePath());
    }

    public final ContentValues wj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put("path", getPath());
        contentValues.put("status", Byte.valueOf(tV()));
        contentValues.put("sofar", Long.valueOf(wl()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put("errMsg", wn());
        contentValues.put(DownloadModel.ETAG, wm());
        contentValues.put("connectionCount", Integer.valueOf(wo()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(tR()));
        if (tR() && getFilename() != null) {
            contentValues.put("filename", getFilename());
        }
        return contentValues;
    }

    public final long wl() {
        return this.ahG.get();
    }

    public final String wm() {
        return this.ahJ;
    }

    public final int wo() {
        return this.ahK;
    }

    public final void wp() {
        this.ahK = 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.VM);
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

    public final void d(byte b4) {
        this.ahF.set(b4);
    }

    protected c(Parcel parcel) {
        this.id = parcel.readInt();
        this.url = parcel.readString();
        this.VM = parcel.readString();
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
