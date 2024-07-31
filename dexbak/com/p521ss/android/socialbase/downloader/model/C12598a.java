package com.p521ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p555p.RunnableC12651a;
import com.umeng.analytics.pro.C13131bm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.ss.android.socialbase.downloader.model.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12598a implements Parcelable {

    /* renamed from: a */
    private int f35494a;

    /* renamed from: bl */
    private long f35495bl;

    /* renamed from: h */
    private int f35496h;

    /* renamed from: j */
    private int f35497j;

    /* renamed from: k */
    private List<C12598a> f35498k;

    /* renamed from: kf */
    private long f35499kf;

    /* renamed from: n */
    private long f35500n;

    /* renamed from: p */
    private AtomicInteger f35501p;

    /* renamed from: q */
    private long f35502q;

    /* renamed from: r */
    private C12598a f35503r;

    /* renamed from: rh */
    private AtomicBoolean f35504rh;

    /* renamed from: s */
    private AtomicLong f35505s;

    /* renamed from: t */
    private RunnableC12651a f35506t;

    /* renamed from: z */
    private boolean f35507z;

    /* renamed from: ok */
    private static final String f35493ok = C12598a.class.getSimpleName();
    public static final Parcelable.Creator<C12598a> CREATOR = new Parcelable.Creator<C12598a>() { // from class: com.ss.android.socialbase.downloader.model.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public C12598a createFromParcel(Parcel parcel) {
            return new C12598a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: ok */
        public C12598a[] newArray(int i) {
            return new C12598a[i];
        }
    };

    /* renamed from: com.ss.android.socialbase.downloader.model.a$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12600ok {

        /* renamed from: a */
        private long f35508a;

        /* renamed from: bl */
        private long f35509bl;

        /* renamed from: h */
        private long f35510h;

        /* renamed from: kf */
        private int f35511kf;

        /* renamed from: n */
        private long f35512n;

        /* renamed from: ok */
        private int f35513ok;

        /* renamed from: p */
        private C12598a f35514p;

        /* renamed from: s */
        private long f35515s;

        public C12600ok(int i) {
            this.f35513ok = i;
        }

        /* renamed from: a */
        public C12600ok m17016a(long j) {
            this.f35509bl = j;
            return this;
        }

        /* renamed from: bl */
        public C12600ok m17014bl(long j) {
            this.f35515s = j;
            return this;
        }

        /* renamed from: n */
        public C12600ok m17010n(long j) {
            this.f35510h = j;
            return this;
        }

        /* renamed from: ok */
        public C12600ok m17006ok(long j) {
            this.f35508a = j;
            return this;
        }

        /* renamed from: s */
        public C12600ok m17002s(long j) {
            this.f35512n = j;
            return this;
        }

        /* renamed from: ok */
        public C12600ok m17007ok(int i) {
            this.f35511kf = i;
            return this;
        }

        /* renamed from: ok */
        public C12600ok m17004ok(C12598a c12598a) {
            this.f35514p = c12598a;
            return this;
        }

        /* renamed from: ok */
        public C12598a m17008ok() {
            return new C12598a(this);
        }
    }

    /* renamed from: a */
    public int m17050a() {
        AtomicInteger atomicInteger = this.f35501p;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    /* renamed from: bl */
    public boolean m17046bl() {
        AtomicBoolean atomicBoolean = this.f35504rh;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: h */
    public List<C12598a> m17043h() {
        return this.f35498k;
    }

    /* renamed from: i */
    public long m17042i() {
        return this.f35500n;
    }

    /* renamed from: j */
    public long m17041j() {
        return this.f35495bl;
    }

    /* renamed from: k */
    public long m17040k() {
        C12598a c12598a = this.f35503r;
        if (c12598a != null && c12598a.m17043h() != null) {
            int indexOf = this.f35503r.m17043h().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.f35503r.m17043h().size(); i++) {
                C12598a c12598a2 = this.f35503r.m17043h().get(i);
                if (c12598a2 != null) {
                    if (z) {
                        return c12598a2.m17025rh();
                    }
                    if (indexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    /* renamed from: kf */
    public boolean m17039kf() {
        List<C12598a> list = this.f35498k;
        return list != null && list.size() > 0;
    }

    /* renamed from: n */
    public C12598a m17038n() {
        C12598a c12598a = !m17024s() ? this.f35503r : this;
        if (c12598a == null || !c12598a.m17039kf()) {
            return null;
        }
        return c12598a.m17043h().get(0);
    }

    /* renamed from: ok */
    public ContentValues m17037ok() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C13131bm.f37927d, Integer.valueOf(this.f35494a));
        contentValues.put("chunkIndex", Integer.valueOf(this.f35496h));
        contentValues.put("startOffset", Long.valueOf(this.f35495bl));
        contentValues.put("curOffset", Long.valueOf(m17025rh()));
        contentValues.put("endOffset", Long.valueOf(this.f35500n));
        contentValues.put("chunkContentLen", Long.valueOf(this.f35499kf));
        contentValues.put("hostChunkIndex", Integer.valueOf(m17050a()));
        return contentValues;
    }

    /* renamed from: p */
    public boolean m17028p() {
        C12598a c12598a = this.f35503r;
        if (c12598a == null) {
            return true;
        }
        if (c12598a.m17039kf()) {
            for (int i = 0; i < this.f35503r.m17043h().size(); i++) {
                C12598a c12598a2 = this.f35503r.m17043h().get(i);
                if (c12598a2 != null) {
                    int indexOf = this.f35503r.m17043h().indexOf(this);
                    if (indexOf > i && !c12598a2.m17027q()) {
                        return false;
                    }
                    if (indexOf == i) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: q */
    public boolean m17027q() {
        long j = this.f35495bl;
        if (m17024s()) {
            long j2 = this.f35502q;
            if (j2 > this.f35495bl) {
                j = j2;
            }
        }
        return m17025rh() - j >= this.f35499kf;
    }

    /* renamed from: r */
    public int m17026r() {
        return this.f35494a;
    }

    /* renamed from: rh */
    public long m17025rh() {
        if (m17024s() && m17039kf()) {
            long j = 0;
            for (int i = 0; i < this.f35498k.size(); i++) {
                C12598a c12598a = this.f35498k.get(i);
                if (c12598a != null) {
                    if (!c12598a.m17027q()) {
                        return c12598a.m17020z();
                    }
                    if (j < c12598a.m17020z()) {
                        j = c12598a.m17020z();
                    }
                }
            }
            return j;
        }
        return m17020z();
    }

    /* renamed from: s */
    public boolean m17024s() {
        return m17050a() == -1;
    }

    /* renamed from: t */
    public long m17023t() {
        long m17025rh = m17025rh() - this.f35495bl;
        if (m17039kf()) {
            m17025rh = 0;
            for (int i = 0; i < this.f35498k.size(); i++) {
                C12598a c12598a = this.f35498k.get(i);
                if (c12598a != null) {
                    m17025rh += c12598a.m17025rh() - c12598a.m17041j();
                }
            }
        }
        return m17025rh;
    }

    /* renamed from: td */
    public void m17022td() {
        this.f35502q = m17025rh();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f35494a);
        parcel.writeLong(this.f35495bl);
        AtomicLong atomicLong = this.f35505s;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.f35500n);
        parcel.writeLong(this.f35499kf);
        parcel.writeInt(this.f35496h);
        AtomicInteger atomicInteger = this.f35501p;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    /* renamed from: x */
    public long m17021x() {
        return this.f35499kf;
    }

    /* renamed from: z */
    public long m17020z() {
        AtomicLong atomicLong = this.f35505s;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    /* renamed from: zz */
    public int m17019zz() {
        return this.f35496h;
    }

    private C12598a(C12600ok c12600ok) {
        if (c12600ok == null) {
            return;
        }
        this.f35494a = c12600ok.f35513ok;
        this.f35495bl = c12600ok.f35508a;
        this.f35505s = new AtomicLong(c12600ok.f35509bl);
        this.f35500n = c12600ok.f35515s;
        this.f35499kf = c12600ok.f35512n;
        this.f35496h = c12600ok.f35511kf;
        this.f35502q = c12600ok.f35510h;
        this.f35501p = new AtomicInteger(-1);
        m17032ok(c12600ok.f35514p);
        this.f35504rh = new AtomicBoolean(false);
    }

    /* renamed from: a */
    public void m17047a(boolean z) {
        this.f35507z = z;
    }

    /* renamed from: bl */
    public void m17045bl(int i) {
        this.f35496h = i;
    }

    /* renamed from: a */
    public void m17049a(int i) {
        this.f35494a = i;
    }

    /* renamed from: bl */
    public long m17044bl(boolean z) {
        long m17025rh = m17025rh();
        long j = this.f35499kf;
        long j2 = this.f35502q;
        long j3 = j - (m17025rh - j2);
        if (!z && m17025rh == j2) {
            j3 = j - (m17025rh - this.f35495bl);
        }
        C12409ok.m17904a("DownloadChunk", "contentLength:" + this.f35499kf + " curOffset:" + m17025rh() + " oldOffset:" + this.f35502q + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    /* renamed from: a */
    public void m17048a(long j) {
        AtomicLong atomicLong = this.f35505s;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.f35505s = new AtomicLong(j);
        }
    }

    /* renamed from: ok */
    public void m17033ok(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.f35497j = 0;
        sQLiteStatement.clearBindings();
        int i = this.f35497j + 1;
        this.f35497j = i;
        sQLiteStatement.bindLong(i, this.f35494a);
        int i2 = this.f35497j + 1;
        this.f35497j = i2;
        sQLiteStatement.bindLong(i2, this.f35496h);
        int i3 = this.f35497j + 1;
        this.f35497j = i3;
        sQLiteStatement.bindLong(i3, this.f35495bl);
        int i4 = this.f35497j + 1;
        this.f35497j = i4;
        sQLiteStatement.bindLong(i4, m17025rh());
        int i5 = this.f35497j + 1;
        this.f35497j = i5;
        sQLiteStatement.bindLong(i5, this.f35500n);
        int i6 = this.f35497j + 1;
        this.f35497j = i6;
        sQLiteStatement.bindLong(i6, this.f35499kf);
        int i7 = this.f35497j + 1;
        this.f35497j = i7;
        sQLiteStatement.bindLong(i7, m17050a());
    }

    public C12598a(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f35494a = cursor.getInt(cursor.getColumnIndex(C13131bm.f37927d));
        this.f35496h = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f35495bl = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f35505s = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f35505s = new AtomicLong(0L);
        }
        this.f35500n = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f35501p = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f35501p = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f35499kf = cursor.getLong(columnIndex3);
        }
        this.f35504rh = new AtomicBoolean(false);
    }

    /* renamed from: ok */
    public void m17036ok(int i) {
        AtomicInteger atomicInteger = this.f35501p;
        if (atomicInteger == null) {
            this.f35501p = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    /* renamed from: ok */
    public void m17031ok(RunnableC12651a runnableC12651a) {
        this.f35506t = runnableC12651a;
        m17022td();
    }

    /* renamed from: ok */
    public void m17029ok(boolean z) {
        AtomicBoolean atomicBoolean = this.f35504rh;
        if (atomicBoolean == null) {
            this.f35504rh = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.f35506t = null;
    }

    protected C12598a(Parcel parcel) {
        this.f35494a = parcel.readInt();
        this.f35495bl = parcel.readLong();
        this.f35505s = new AtomicLong(parcel.readLong());
        this.f35500n = parcel.readLong();
        this.f35499kf = parcel.readLong();
        this.f35496h = parcel.readInt();
        this.f35501p = new AtomicInteger(parcel.readInt());
    }

    /* renamed from: ok */
    public void m17032ok(C12598a c12598a) {
        this.f35503r = c12598a;
        if (c12598a != null) {
            m17036ok(c12598a.m17019zz());
        }
    }

    /* renamed from: ok */
    public void m17030ok(List<C12598a> list) {
        this.f35498k = list;
    }

    /* renamed from: ok */
    public void m17034ok(long j) {
        this.f35499kf = j;
    }

    /* renamed from: ok */
    public List<C12598a> m17035ok(int i, long j) {
        C12598a c12598a;
        long m17042i;
        long j2;
        long j3;
        long j4;
        long j5;
        C12598a c12598a2 = this;
        int i2 = i;
        if (!m17024s() || m17039kf()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long m17020z = m17020z();
        long m17044bl = c12598a2.m17044bl(true);
        long j6 = m17044bl / i2;
        C12409ok.m17904a(f35493ok, "retainLen:" + m17044bl + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + c12598a2.f35496h);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                j3 = m17041j();
                j2 = (m17020z + j6) - 1;
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long m17042i2 = m17042i();
                    j4 = m17042i2 > m17020z ? (m17042i2 - m17020z) + 1 : m17044bl - (i4 * j6);
                    j5 = m17042i2;
                    j3 = m17020z;
                    long j7 = m17044bl;
                    long j8 = j5;
                    C12598a m17008ok = new C12600ok(c12598a2.f35494a).m17007ok((-i3) - 1).m17006ok(j3).m17016a(m17020z).m17010n(m17020z).m17014bl(j8).m17002s(j4).m17004ok(c12598a2).m17008ok();
                    C12409ok.m17904a(f35493ok, "divide sub chunk : " + i3 + " startOffset:" + j3 + " curOffset:" + m17020z + " endOffset:" + j8 + " contentLen:" + j4);
                    arrayList.add(m17008ok);
                    m17020z += j6;
                    i3++;
                    c12598a2 = this;
                    i2 = i;
                    m17044bl = j7;
                } else {
                    j2 = (m17020z + j6) - 1;
                    j3 = m17020z;
                }
            }
            j4 = j6;
            j5 = j2;
            long j72 = m17044bl;
            long j82 = j5;
            C12598a m17008ok2 = new C12600ok(c12598a2.f35494a).m17007ok((-i3) - 1).m17006ok(j3).m17016a(m17020z).m17010n(m17020z).m17014bl(j82).m17002s(j4).m17004ok(c12598a2).m17008ok();
            C12409ok.m17904a(f35493ok, "divide sub chunk : " + i3 + " startOffset:" + j3 + " curOffset:" + m17020z + " endOffset:" + j82 + " contentLen:" + j4);
            arrayList.add(m17008ok2);
            m17020z += j6;
            i3++;
            c12598a2 = this;
            i2 = i;
            m17044bl = j72;
        }
        long j9 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            C12598a c12598a3 = arrayList.get(size);
            if (c12598a3 != null) {
                j9 += c12598a3.m17021x();
            }
        }
        C12409ok.m17904a(f35493ok, "reuseChunkContentLen:" + j9);
        C12598a c12598a4 = arrayList.get(0);
        if (c12598a4 != null) {
            if (m17042i() == 0) {
                m17042i = j - m17041j();
            } else {
                m17042i = (m17042i() - m17041j()) + 1;
            }
            c12598a4.m17034ok(m17042i - j9);
            c12598a = this;
            c12598a4.m17045bl(c12598a.f35496h);
            RunnableC12651a runnableC12651a = c12598a.f35506t;
            if (runnableC12651a != null) {
                runnableC12651a.m16830ok(c12598a4.m17042i(), m17021x() - j9);
            }
        } else {
            c12598a = this;
        }
        c12598a.m17030ok(arrayList);
        return arrayList;
    }
}
