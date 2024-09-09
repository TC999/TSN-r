package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.f.f;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private long afO;
    private long afP;
    private long afQ;
    private int id;
    private int index;

    public static long r(List<a> list) {
        long j4 = 0;
        for (a aVar : list) {
            j4 += aVar.wh() - aVar.getStartOffset();
        }
        return j4;
    }

    public final void Q(long j4) {
        this.afP = j4;
    }

    public final void R(long j4) {
        this.afQ = j4;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.afO;
    }

    public final void setId(int i4) {
        this.id = i4;
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }

    public final void setStartOffset(long j4) {
        this.afO = j4;
    }

    public final String toString() {
        return f.b("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.afO), Long.valueOf(this.afQ), Long.valueOf(this.afP));
    }

    public final long wh() {
        return this.afP;
    }

    public final long wi() {
        return this.afQ;
    }

    public final ContentValues wj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put("startOffset", Long.valueOf(this.afO));
        contentValues.put("currentOffset", Long.valueOf(this.afP));
        contentValues.put("endOffset", Long.valueOf(this.afQ));
        return contentValues;
    }
}
