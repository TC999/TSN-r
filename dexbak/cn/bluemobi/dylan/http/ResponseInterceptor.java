package cn.bluemobi.dylan.http;

import android.content.Context;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface ResponseInterceptor {
    void onError(Context context, Throwable th);

    boolean onResponse(Context context, int i, String str, Map<String, Object> map, String str2);

    boolean onResponseStart(Context context, String str, Map<String, Object> map, String str2, int i);
}
