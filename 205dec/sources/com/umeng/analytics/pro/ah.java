package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TimePeriodChain.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    private String f52504a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<ai> f52505b = new ArrayList<>();

    public ah(String str) {
        this.f52504a = "";
        this.f52504a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        String[] split;
        try {
            if (this.f52504a.contains(",")) {
                for (String str : this.f52504a.split(",")) {
                    if (!TextUtils.isEmpty(str)) {
                        String trim = str.trim();
                        if (this.f52505b != null) {
                            this.f52505b.add(new ai(trim));
                        }
                    }
                }
                return;
            }
            String str2 = this.f52504a;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String trim2 = str2.trim();
            if (this.f52505b != null) {
                this.f52505b.add(new ai(trim2));
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i4) {
        try {
            ArrayList<ai> arrayList = this.f52505b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ai aiVar = this.f52505b.get(i5);
                    if (aiVar != null && aiVar.a(i4)) {
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
