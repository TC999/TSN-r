package com.scwang.smartrefresh.layout.constant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum RefreshState {
    None(0, false),
    PullDownToRefresh(1, true),
    PullToUpLoad(2, true),
    PullDownCanceled(1, false),
    PullUpCanceled(2, false),
    ReleaseToRefresh(1, true),
    ReleaseToLoad(2, true),
    ReleaseToTwoLevel(1, true),
    TwoLevelReleased(1, false),
    RefreshReleased(1, false),
    LoadReleased(2, false),
    Refreshing(1, false, true),
    Loading(2, false, true),
    TwoLevel(1, false, true),
    RefreshFinish(1, false),
    LoadFinish(2, false),
    TwoLevelFinish(1, false);
    
    public final boolean draging;
    public final boolean opening;
    private final int role;

    RefreshState(int i4, boolean z3) {
        this.role = i4;
        this.draging = z3;
        this.opening = false;
    }

    public boolean isFooter() {
        return this.role == 2;
    }

    public boolean isHeader() {
        return this.role == 1;
    }

    RefreshState(int i4, boolean z3, boolean z4) {
        this.role = i4;
        this.draging = z3;
        this.opening = z4;
    }
}
