package com.amap.api.maps.model;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class BasePointOverlay extends BaseOverlay {
    public BasePointOverlay(String str) {
        super(str);
    }

    public abstract void destroy();

    public abstract String getId();

    public abstract Object getObject();

    public abstract LatLng getPosition();

    public abstract float getRotateAngle();

    public abstract String getSnippet();

    public abstract String getTitle();

    public abstract boolean isInfoWindowEnable();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setAnimation(Animation animation);

    public abstract void setGeoPoint(IPoint iPoint);

    public abstract void setObject(Object obj);

    public abstract void setPosition(LatLng latLng);

    public abstract void setRotateAngle(float f4);

    public abstract void setSnippet(String str);

    public abstract void setTitle(String str);

    public abstract void setVisible(boolean z3);

    public abstract void showInfoWindow();

    public abstract boolean startAnimation();
}
