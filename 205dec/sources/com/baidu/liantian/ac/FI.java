package com.baidu.liantian.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Pair;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface FI {
    byte[] ad(byte[] bArr, byte[] bArr2);

    byte[] ae(byte[] bArr, byte[] bArr2);

    boolean chh(Context context, String str);

    void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr);

    Pair<Integer, Object> cmsi(int i4, String str, Class<?>[] clsArr, Object... objArr);

    Map<Integer, String> gpd();

    String gs(String str);

    String p(String str);

    void r(String str, IntentFilter intentFilter, String str2, String str3);

    byte[] rd(byte[] bArr, byte[] bArr2);

    byte[] re(byte[] bArr, byte[] bArr2);

    void rf(Context context);

    void s(int i4, boolean z3);

    void sp(String str, boolean z3);

    void u(String str);

    void ur(String str, IntentFilter intentFilter, String str2, String str3);
}
