package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class mu {

    /* renamed from: c  reason: collision with root package name */
    private static oh<String> f26771c = new oh<String>() { // from class: com.bytedance.embedapplog.mu.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.oh
        /* renamed from: xv */
        public String c(Object... objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            if (TextUtils.isEmpty(string)) {
                String uuid = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", uuid).apply();
                return uuid;
            }
            return string;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(SharedPreferences sharedPreferences) {
        return f26771c.w(sharedPreferences);
    }
}
