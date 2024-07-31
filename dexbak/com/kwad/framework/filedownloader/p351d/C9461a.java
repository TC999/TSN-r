package com.kwad.framework.filedownloader.p351d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.util.List;

/* renamed from: com.kwad.framework.filedownloader.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9461a {
    private long afO;
    private long afP;
    private long afQ;

    /* renamed from: id */
    private int f29475id;
    private int index;

    /* renamed from: r */
    public static long m28709r(List<C9461a> list) {
        long j = 0;
        for (C9461a c9461a : list) {
            j += c9461a.m28705wh() - c9461a.getStartOffset();
        }
        return j;
    }

    /* renamed from: Q */
    public final void m28712Q(long j) {
        this.afP = j;
    }

    /* renamed from: R */
    public final void m28711R(long j) {
        this.afQ = j;
    }

    public final int getId() {
        return this.f29475id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.afO;
    }

    public final void setId(int i) {
        this.f29475id = i;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setStartOffset(long j) {
        this.afO = j;
    }

    public final String toString() {
        return C9501f.m28515b("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f29475id), Integer.valueOf(this.index), Long.valueOf(this.afO), Long.valueOf(this.afQ), Long.valueOf(this.afP));
    }

    /* renamed from: wh */
    public final long m28705wh() {
        return this.afP;
    }

    /* renamed from: wi */
    public final long m28704wi() {
        return this.afQ;
    }

    /* renamed from: wj */
    public final ContentValues m28703wj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f29475id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put("startOffset", Long.valueOf(this.afO));
        contentValues.put("currentOffset", Long.valueOf(this.afP));
        contentValues.put("endOffset", Long.valueOf(this.afQ));
        return contentValues;
    }
}
