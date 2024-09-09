package com.umeng.analytics.pro;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TimePeriodItem.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private String f52506a;

    /* renamed from: e  reason: collision with root package name */
    private boolean f52510e = false;

    /* renamed from: d  reason: collision with root package name */
    private int f52509d = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f52508c = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f52507b = -1;

    public ai(String str) {
        this.f52506a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (this.f52506a.contains("-")) {
                String[] split = this.f52506a.split("-");
                if (split.length == 2) {
                    this.f52507b = Integer.valueOf(split[0]).intValue();
                    int intValue = Integer.valueOf(split[1]).intValue();
                    this.f52508c = intValue;
                    if (this.f52507b < 1) {
                        this.f52507b = 1;
                    }
                    if (intValue > 24) {
                        this.f52508c = 24;
                    }
                }
                this.f52510e = true;
                return;
            }
            this.f52509d = Integer.valueOf(this.f52506a).intValue();
            this.f52510e = false;
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i4) {
        int i5;
        if (this.f52510e) {
            int i6 = this.f52507b;
            if (i6 != -1 && (i5 = this.f52508c) != -1 && i4 >= i6 && i4 <= i5) {
                return true;
            }
        } else {
            int i7 = this.f52509d;
            if (i7 != -1 && i4 == i7) {
                return true;
            }
        }
        return false;
    }
}
