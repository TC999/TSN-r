package com.kwad.sdk.crash.p427b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.kwad.sdk.crash.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10667b {
    private Set<String> aFR = new HashSet();
    private Set<String> aFS = new HashSet();

    /* renamed from: HI */
    public final synchronized String[] m25203HI() {
        Set<String> set;
        set = this.aFR;
        return (String[]) set.toArray(new String[set.size()]);
    }

    /* renamed from: Hw */
    public final synchronized String[] m25202Hw() {
        Set<String> set;
        set = this.aFS;
        return (String[]) set.toArray(new String[set.size()]);
    }

    /* renamed from: a */
    public final synchronized void m25201a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.aFR.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.aFS.add(str2);
                }
            }
        }
    }
}
