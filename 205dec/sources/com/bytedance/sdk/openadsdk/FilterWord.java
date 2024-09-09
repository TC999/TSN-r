package com.bytedance.sdk.openadsdk;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface FilterWord {
    void addOption(FilterWord filterWord);

    String getId();

    boolean getIsSelected();

    String getName();

    List<FilterWord> getOptions();

    boolean hasSecondOptions();

    boolean isValid();

    void setIsSelected(boolean z3);
}
