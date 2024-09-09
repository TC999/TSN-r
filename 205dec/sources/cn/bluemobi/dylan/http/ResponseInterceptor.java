package cn.bluemobi.dylan.http;

import android.content.Context;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface ResponseInterceptor {
    void onError(Context context, Throwable th);

    boolean onResponse(Context context, int i4, String str, Map<String, Object> map, String str2);

    boolean onResponseStart(Context context, String str, Map<String, Object> map, String str2, int i4);
}
