package com.kwad.sdk.service.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface f {
    void a(String str, Map<String, String> map, String str2);

    boolean aF(AdTemplate adTemplate);

    String al(String str);

    String getApiVersion();

    int getApiVersionCode();

    String getAppId();

    String getAppName();

    Context getContext();

    String getSDKVersion();

    boolean oK();

    com.kwad.sdk.core.response.b.g tD();

    boolean yp();

    boolean yq();

    boolean yr();

    boolean ys();

    String yt();

    com.kwad.sdk.core.b yu();

    List<AdTemplate> yv();

    String yw();

    JSONObject yx();

    JSONObject yy();

    Map<String, String> yz();
}
