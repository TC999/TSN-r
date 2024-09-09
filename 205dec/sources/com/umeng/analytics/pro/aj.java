package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: WeekOnCondition.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class aj implements aa {

    /* renamed from: a  reason: collision with root package name */
    private Set<Integer> f52511a;

    public aj(Set<Integer> set) {
        this.f52511a = null;
        this.f52511a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        Iterator<Integer> it;
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int i4 = 7;
            int i5 = calendar.get(7) - 1;
            if (i5 != 0) {
                i4 = i5;
            }
            Set<Integer> set = this.f52511a;
            if (set == null || !set.contains(Integer.valueOf(i4))) {
                String str = "";
                while (this.f52511a.iterator().hasNext()) {
                    str = str + it.next() + ",";
                }
                UMRTLog.i("MobclickRT", "WeekOn skipped. day of week: " + i4 + "; config: " + str);
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
