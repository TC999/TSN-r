package com.kwad.components.core.p287c;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.core.c.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8551e implements InterfaceC8556i {

    /* renamed from: IY */
    private static volatile C8551e f28093IY;
    @Nullable

    /* renamed from: IZ */
    private String f28094IZ;

    /* renamed from: Ja */
    private int f28095Ja = 0;

    /* renamed from: Jb */
    private int f28096Jb = 1;

    /* renamed from: Jc */
    private long f28097Jc = 1800;

    /* renamed from: Jd */
    private boolean f28098Jd = false;

    private C8551e() {
    }

    /* renamed from: a */
    public static synchronized List<C8551e> m30388a(Cursor cursor) {
        synchronized (C8551e.class) {
            if (cursor == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(m30386b(cursor));
                } catch (Exception e) {
                    C10331c.printStackTrace(e);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: aj */
    public static C8551e m30387aj(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j = adTemplate.posId;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        C8551e c8551e = new C8551e(j);
        AdInfo.AdBaseInfo adBaseInfo = m25641dQ.adBaseInfo;
        c8551e.f28095Ja = adBaseInfo.adCacheStrategy;
        c8551e.f28097Jc = adBaseInfo.adCacheSecond;
        c8551e.f28096Jb = adBaseInfo.adCacheSize;
        c8551e.f28098Jd = adBaseInfo.adCacheSwitch == 1;
        return c8551e;
    }

    /* renamed from: b */
    private static synchronized C8551e m30386b(Cursor cursor) {
        C8551e c8551e;
        synchronized (C8551e.class) {
            String string = cursor.getString(cursor.getColumnIndex("posId"));
            int i = cursor.getInt(cursor.getColumnIndex("strategyCode"));
            int i2 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
            long j = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
            boolean z = true;
            if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
                z = false;
            }
            c8551e = new C8551e();
            c8551e.f28094IZ = string;
            c8551e.f28095Ja = i;
            c8551e.f28096Jb = i2;
            c8551e.f28097Jc = j;
            c8551e.f28098Jd = z;
        }
        return c8551e;
    }

    @NonNull
    /* renamed from: mz */
    private static C8551e m30382mz() {
        if (f28093IY == null) {
            synchronized (C8551e.class) {
                if (f28093IY == null) {
                    f28093IY = new C8551e();
                }
            }
        }
        return f28093IY;
    }

    @NonNull
    @WorkerThread
    /* renamed from: s */
    public static C8551e m30381s(long j) {
        C8551e m30406X;
        return (C8544a.m30401mu() == null || (m30406X = C8544a.m30401mu().m30406X(String.valueOf(j))) == null) ? m30382mz() : m30406X;
    }

    public final boolean isDefault() {
        return equals(m30382mz());
    }

    public final boolean isEnable() {
        return this.f28098Jd;
    }

    /* renamed from: mA */
    public final int m30385mA() {
        return this.f28095Ja;
    }

    /* renamed from: mB */
    public final int m30384mB() {
        return this.f28096Jb;
    }

    /* renamed from: mC */
    public final long m30383mC() {
        return this.f28097Jc;
    }

    @Override // com.kwad.components.core.p287c.InterfaceC8556i
    /* renamed from: mD */
    public final ContentValues mo30359mD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.f28094IZ);
        contentValues.put("strategyCode", Integer.valueOf(this.f28095Ja));
        contentValues.put("cacheSize", Integer.valueOf(this.f28096Jb));
        contentValues.put("cacheSecond", Long.valueOf(this.f28097Jc));
        contentValues.put("enable", Integer.valueOf(this.f28098Jd ? 1 : 0));
        return contentValues;
    }

    private C8551e(long j) {
        this.f28094IZ = String.valueOf(j);
    }
}
