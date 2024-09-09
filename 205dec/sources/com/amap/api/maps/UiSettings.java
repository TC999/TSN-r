package com.amap.api.maps;

import com.autonavi.amap.mapcore.interfaces.IUiSettings;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class UiSettings {
    private final IUiSettings uiSettingsDelegate;

    public UiSettings(IUiSettings iUiSettings) {
        this.uiSettingsDelegate = iUiSettings;
    }

    public final float getLogoMarginRate(int i4) {
        try {
            return this.uiSettingsDelegate.getLogoMarginRate(i4);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final int getLogoPosition() {
        try {
            return this.uiSettingsDelegate.getLogoPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getZoomPosition() {
        try {
            return this.uiSettingsDelegate.getZoomPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 2;
        }
    }

    public final boolean isCompassEnabled() {
        try {
            return this.uiSettingsDelegate.isCompassEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isGestureScaleByMapCenter() {
        try {
            return this.uiSettingsDelegate.isGestureScaleByMapCenter();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isIndoorSwitchEnabled() {
        try {
            return this.uiSettingsDelegate.isIndoorSwitchEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    protected final boolean isLogoEnable() {
        try {
            return this.uiSettingsDelegate.isLogoEnable();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isMyLocationButtonEnabled() {
        try {
            return this.uiSettingsDelegate.isMyLocationButtonEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isRotateGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isRotateGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isScaleControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isScaleControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isScrollGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isScrollGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isTiltGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isTiltGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomControlsEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isZoomGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.isZoomGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final void setAllGesturesEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setAllGesturesEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCompassEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setCompassEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setGestureScaleByMapCenter(boolean z3) {
        try {
            this.uiSettingsDelegate.setGestureScaleByMapCenter(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setIndoorSwitchEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setIndoorSwitchEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoBottomMargin(int i4) {
        try {
            this.uiSettingsDelegate.setLogoBottomMargin(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoCenter(int i4, int i5) {
    }

    protected final void setLogoEnable(boolean z3) {
        try {
            this.uiSettingsDelegate.setLogoEnable(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoLeftMargin(int i4) {
        try {
            this.uiSettingsDelegate.setLogoLeftMargin(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoMarginRate(int i4, float f4) {
        try {
            this.uiSettingsDelegate.setLogoMarginRate(i4, f4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoPosition(int i4) {
        try {
            this.uiSettingsDelegate.setLogoPosition(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationButtonEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setMyLocationButtonEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotateGesturesEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setRotateGesturesEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScaleControlsEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setScaleControlsEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setScrollGesturesEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setScrollGesturesEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTiltGesturesEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setTiltGesturesEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomControlsEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setZoomControlsEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomGesturesEnabled(boolean z3) {
        try {
            this.uiSettingsDelegate.setZoomGesturesEnabled(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomInByScreenCenter(boolean z3) {
        try {
            this.uiSettingsDelegate.setZoomInByScreenCenter(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomPosition(int i4) {
        try {
            this.uiSettingsDelegate.setZoomPosition(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
