package com.kwad.components.offline.api.core.adlive;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IAdLiveEndRequest {
    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    String getUrl();

    Map<String, String> getUrlParam();
}
