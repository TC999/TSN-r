package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.umeng.analytics.pro.ad */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HourOnCondition implements ActionCondition {

    /* renamed from: a */
    private Set<Integer> f37606a;

    public HourOnCondition(Set<Integer> set) {
        this.f37606a = null;
        this.f37606a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: a */
    public boolean mo14750a() {
        Iterator<Integer> it;
        try {
            int i = Calendar.getInstance().get(11);
            Set<Integer> set = this.f37606a;
            if (set == null || !set.contains(Integer.valueOf(i))) {
                String str = "";
                while (this.f37606a.iterator().hasNext()) {
                    str = str + it.next() + ",";
                }
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "HourOn skipped. hour of day: " + i + "; config: " + str);
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: b */
    public boolean mo14749b() {
        return !mo14750a();
    }

    @Override // com.umeng.analytics.pro.ActionCondition
    /* renamed from: c */
    public long mo14748c() {
        return 0L;
    }
}
