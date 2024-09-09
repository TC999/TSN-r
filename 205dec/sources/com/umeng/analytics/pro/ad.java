package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: HourOnCondition.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ad implements aa {

    /* renamed from: a  reason: collision with root package name */
    private Set<Integer> f52500a;

    public ad(Set<Integer> set) {
        this.f52500a = null;
        this.f52500a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        Iterator<Integer> it;
        try {
            int i4 = Calendar.getInstance().get(11);
            Set<Integer> set = this.f52500a;
            if (set == null || !set.contains(Integer.valueOf(i4))) {
                String str = "";
                while (this.f52500a.iterator().hasNext()) {
                    str = str + it.next() + ",";
                }
                UMRTLog.i("MobclickRT", "HourOn skipped. hour of day: " + i4 + "; config: " + str);
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return 0L;
    }
}
