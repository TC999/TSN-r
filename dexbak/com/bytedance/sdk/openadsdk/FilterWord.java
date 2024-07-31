package com.bytedance.sdk.openadsdk;

import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface FilterWord {
    void addOption(FilterWord filterWord);

    String getId();

    boolean getIsSelected();

    String getName();

    List<FilterWord> getOptions();

    boolean hasSecondOptions();

    boolean isValid();

    void setIsSelected(boolean z);
}
