package cn.bluemobi.dylan.http;

import cn.bluemobi.dylan.http.download.ProgressResponseListener;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface HttpResponse extends ProgressResponseListener {
    void netOnFailure(Throwable th);

    void netOnFinish();

    void netOnOtherStatus(int i, String str);

    void netOnOtherStatus(int i, String str, Map<String, Object> map);

    void netOnStart();

    void netOnSuccess(Map<String, Object> map);

    void netOnSuccess(Map<String, Object> map, String str);

    void netOnSuccessServerError(int i, String str);
}
