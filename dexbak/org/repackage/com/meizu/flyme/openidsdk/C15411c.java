package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* renamed from: org.repackage.com.meizu.flyme.openidsdk.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C15411c {

    /* renamed from: a */
    String f44175a;

    /* renamed from: b */
    Boolean f44176b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2781a(boolean z) {
        this.f44176b = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m2780b() {
        return this.f44176b != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m2779c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f44175a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m2778d(String str) {
        this.f44175a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean m2777e() {
        Boolean bool = this.f44176b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
