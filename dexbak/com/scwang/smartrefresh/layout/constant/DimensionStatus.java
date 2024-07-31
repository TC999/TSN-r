package com.scwang.smartrefresh.layout.constant;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum DimensionStatus {
    DefaultUnNotify(false),
    Default(true),
    XmlWrapUnNotify(false),
    XmlWrap(true),
    XmlExactUnNotify(false),
    XmlExact(true),
    XmlLayoutUnNotify(false),
    XmlLayout(true),
    CodeExactUnNotify(false),
    CodeExact(true),
    DeadLockUnNotify(false),
    DeadLock(true);
    
    public final boolean notifyed;

    DimensionStatus(boolean z) {
        this.notifyed = z;
    }

    public boolean canReplaceWith(DimensionStatus dimensionStatus) {
        return ordinal() < dimensionStatus.ordinal() || ((!this.notifyed || CodeExact == this) && ordinal() == dimensionStatus.ordinal());
    }

    public boolean gteReplaceWith(DimensionStatus dimensionStatus) {
        return ordinal() >= dimensionStatus.ordinal();
    }

    public DimensionStatus notifyed() {
        return !this.notifyed ? values()[ordinal() + 1] : this;
    }

    public DimensionStatus unNotify() {
        if (this.notifyed) {
            DimensionStatus dimensionStatus = values()[ordinal() - 1];
            return !dimensionStatus.notifyed ? dimensionStatus : DefaultUnNotify;
        }
        return this;
    }
}
