package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: com.umeng.analytics.pro.ah */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TimePeriodChain {

    /* renamed from: a */
    private String f37610a;

    /* renamed from: b */
    private ArrayList<TimePeriodItem> f37611b = new ArrayList<>();

    public TimePeriodChain(String str) {
        this.f37610a = "";
        this.f37610a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m14754a();
    }

    /* renamed from: a */
    private void m14754a() {
        String[] split;
        try {
            if (this.f37610a.contains(",")) {
                for (String str : this.f37610a.split(",")) {
                    if (!TextUtils.isEmpty(str)) {
                        String trim = str.trim();
                        if (this.f37611b != null) {
                            this.f37611b.add(new TimePeriodItem(trim));
                        }
                    }
                }
                return;
            }
            String str2 = this.f37610a;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String trim2 = str2.trim();
            if (this.f37611b != null) {
                this.f37611b.add(new TimePeriodItem(trim2));
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public boolean m14753a(int i) {
        try {
            ArrayList<TimePeriodItem> arrayList = this.f37611b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    TimePeriodItem timePeriodItem = this.f37611b.get(i2);
                    if (timePeriodItem != null && timePeriodItem.m14751a(i)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
