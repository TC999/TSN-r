package com.kwad.framework.filedownloader.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface b {
    void addHeader(String str, String str2);

    String bd(String str);

    void execute();

    InputStream getInputStream();

    int getResponseCode();

    Map<String, List<String>> vc();

    Map<String, List<String>> vd();

    void ve();
}
