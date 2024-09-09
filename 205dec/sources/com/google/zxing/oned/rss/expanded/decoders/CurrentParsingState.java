package com.google.zxing.oned.rss.expanded.decoders;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class CurrentParsingState {
    private int position = 0;
    private State encoding = State.NUMERIC;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPosition() {
        return this.position;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void incrementPosition(int i4) {
        this.position += i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAlpha() {
        return this.encoding == State.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isIsoIec646() {
        return this.encoding == State.ISO_IEC_646;
    }

    boolean isNumeric() {
        return this.encoding == State.NUMERIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAlpha() {
        this.encoding = State.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNumeric() {
        this.encoding = State.NUMERIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPosition(int i4) {
        this.position = i4;
    }
}
