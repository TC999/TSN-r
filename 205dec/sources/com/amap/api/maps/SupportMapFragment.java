package com.amap.api.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.amap.api.col.p0003l.c;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SupportMapFragment extends Fragment implements BaseMapView {
    private AMap aMap;
    private IMapFragmentDelegate mapFragmentDelegate;

    private IMapFragmentDelegate a() {
        return getMapFragmentDelegate(getActivity());
    }

    public static SupportMapFragment newInstance() {
        return newInstance(new AMapOptions());
    }

    public AMap getMap() {
        IMapFragmentDelegate a4 = a();
        if (a4 == null) {
            return null;
        }
        try {
            IAMap map = a4.getMap();
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

    protected IMapFragmentDelegate getMapFragmentDelegate(Context context) {
        IMapFragmentDelegate iMapFragmentDelegate = this.mapFragmentDelegate;
        if (iMapFragmentDelegate == null && iMapFragmentDelegate == null) {
            c cVar = new c(0);
            this.mapFragmentDelegate = cVar;
            cVar.setContext(context);
        }
        return this.mapFragmentDelegate;
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z3) {
        try {
            a().loadWorldVectorMap(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return a().onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        try {
            a().onDestroy();
            this.aMap = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            a().onDestroyView();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate(activity).onInflate(activity, new AMapOptions(), bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        try {
            a().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        try {
            a().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            a().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        try {
            a().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z3) {
        super.setUserVisibleHint(z3);
        if (z3) {
            a().setVisibility(0);
        } else {
            a().setVisibility(8);
        }
    }

    public static SupportMapFragment newInstance(AMapOptions aMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        try {
            Parcel obtain = Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }
}
