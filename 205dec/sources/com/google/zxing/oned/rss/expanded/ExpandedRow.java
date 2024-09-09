package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class ExpandedRow {
    private final List<ExpandedPair> pairs;
    private final int rowNumber;
    private final boolean wasReversed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpandedRow(List<ExpandedPair> list, int i4, boolean z3) {
        this.pairs = new ArrayList(list);
        this.rowNumber = i4;
        this.wasReversed = z3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExpandedRow) {
            ExpandedRow expandedRow = (ExpandedRow) obj;
            return this.pairs.equals(expandedRow.getPairs()) && this.wasReversed == expandedRow.wasReversed;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ExpandedPair> getPairs() {
        return this.pairs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRowNumber() {
        return this.rowNumber;
    }

    public int hashCode() {
        return this.pairs.hashCode() ^ Boolean.valueOf(this.wasReversed).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEquivalent(List<ExpandedPair> list) {
        return this.pairs.equals(list);
    }

    boolean isReversed() {
        return this.wasReversed;
    }

    public String toString() {
        return "{ " + this.pairs + " }";
    }
}
