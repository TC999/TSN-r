package com.umeng.analytics.pro;

import android.text.TextUtils;

/* renamed from: com.umeng.analytics.pro.ai */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TimePeriodItem {

    /* renamed from: a */
    private String f37612a;

    /* renamed from: e */
    private boolean f37616e = false;

    /* renamed from: d */
    private int f37615d = -1;

    /* renamed from: c */
    private int f37614c = -1;

    /* renamed from: b */
    private int f37613b = -1;

    public TimePeriodItem(String str) {
        this.f37612a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m14752a();
    }

    /* renamed from: a */
    private void m14752a() {
        try {
            if (this.f37612a.contains("-")) {
                String[] split = this.f37612a.split("-");
                if (split.length == 2) {
                    this.f37613b = Integer.valueOf(split[0]).intValue();
                    int intValue = Integer.valueOf(split[1]).intValue();
                    this.f37614c = intValue;
                    if (this.f37613b < 1) {
                        this.f37613b = 1;
                    }
                    if (intValue > 24) {
                        this.f37614c = 24;
                    }
                }
                this.f37616e = true;
                return;
            }
            this.f37615d = Integer.valueOf(this.f37612a).intValue();
            this.f37616e = false;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public boolean m14751a(int i) {
        int i2;
        if (this.f37616e) {
            int i3 = this.f37613b;
            if (i3 != -1 && (i2 = this.f37614c) != -1 && i >= i3 && i <= i2) {
                return true;
            }
        } else {
            int i4 = this.f37615d;
            if (i4 != -1 && i == i4) {
                return true;
            }
        }
        return false;
    }
}
