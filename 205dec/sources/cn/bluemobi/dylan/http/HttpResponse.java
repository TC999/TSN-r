package cn.bluemobi.dylan.http;

import cn.bluemobi.dylan.http.download.ProgressResponseListener;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface HttpResponse extends ProgressResponseListener {
    void netOnFailure(Throwable th);

    void netOnFinish();

    void netOnOtherStatus(int i4, String str);

    void netOnOtherStatus(int i4, String str, Map<String, Object> map);

    void netOnStart();

    void netOnSuccess(Map<String, Object> map);

    void netOnSuccess(Map<String, Object> map, String str);

    void netOnSuccessServerError(int i4, String str);
}
