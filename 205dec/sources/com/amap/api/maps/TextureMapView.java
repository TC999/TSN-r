package com.amap.api.maps;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.col.p0003l.c;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TextureMapView extends FrameLayout implements BaseMapView {
    private AMap aMap;
    private IMapFragmentDelegate mapFragmentDelegate;
    private int visibility;

    public TextureMapView(Context context) {
        super(context);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
    }

    public AMap getMap() {
        try {
            IAMap map = getMapFragmentDelegate().getMap();
            if (map == null) {
                return null;
            }
            if (this.aMap == null) {
                this.aMap = new AMap(map);
            }
            return this.aMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    protected IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.mapFragmentDelegate == null) {
            this.mapFragmentDelegate = new c(1);
        }
        return this.mapFragmentDelegate;
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z3) {
        try {
            getMapFragmentDelegate().loadWorldVectorMap(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        try {
            addView(getMapFragmentDelegate().onCreateView(null, null, bundle), new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
            this.aMap = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        getMapFragmentDelegate().setVisibility(i4);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }

    public TextureMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
    }
}
