package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ViewPager2Delegate extends ViewPager2 implements a {

    /* renamed from: m  reason: collision with root package name */
    private static final String f12683m = "getScrollState";

    /* renamed from: n  reason: collision with root package name */
    private static final String f12684n = "getCurrentItem";

    /* renamed from: o  reason: collision with root package name */
    private static final String f12685o = "setCurrentItem";

    /* renamed from: p  reason: collision with root package name */
    private static final String f12686p = "setOrientation";

    /* renamed from: q  reason: collision with root package name */
    private static final String f12687q = "setAdapter";

    /* renamed from: r  reason: collision with root package name */
    private static final String f12688r = "setOffscreenPageLimit";

    /* renamed from: s  reason: collision with root package name */
    private static final String f12689s = "setUserInputEnabled";

    /* renamed from: t  reason: collision with root package name */
    private final c f12690t;

    public ViewPager2Delegate(IAdInterListener iAdInterListener, Context context) {
        super(context);
        this.f12690t = c.a(iAdInterListener, this);
        setOnOverScrollListener(new ViewPager2.OnOverScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollEnd() {
                ViewPager2Delegate.this.f12690t.a("onOverScrollEnd");
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollStart() {
                ViewPager2Delegate.this.f12690t.a("onOverScrollStart");
            }
        });
        registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i4) {
                ViewPager2Delegate.this.f12690t.a("onPageScrollStateChanged", Integer.valueOf(i4));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i4, float f4, int i5) {
                ViewPager2Delegate.this.f12690t.a("onPageScrolled", Integer.valueOf(i4), Float.valueOf(f4), Integer.valueOf(i5));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i4) {
                ViewPager2Delegate.this.f12690t.a("onPageSelected", Integer.valueOf(i4));
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f12690t.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f12690t.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f12690t.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f12690t.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f12690t.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f12690t.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("getScrollState".equals(str2)) {
            return Integer.valueOf(getScrollState());
        }
        if ("getCurrentItem".equals(str2)) {
            return Integer.valueOf(getCurrentItem());
        }
        if ("setCurrentItem".equals(str2) && c.a(objArr, Integer.class)) {
            setCurrentItem(((Integer) objArr[0]).intValue());
            return null;
        } else if ("setOrientation".equals(str2) && c.a(objArr, Integer.class)) {
            setOrientation(((Integer) objArr[0]).intValue());
            return null;
        } else if ("setAdapter".equals(str2) && c.a(objArr, RecyclerView.Adapter.class)) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        } else if ("setOffscreenPageLimit".equals(str2) && c.a(objArr, Integer.class)) {
            setOffscreenPageLimit(((Integer) objArr[0]).intValue());
            return null;
        } else if ("setUserInputEnabled".equals(str2) && c.a(objArr, Boolean.class)) {
            setUserInputEnabled(((Boolean) objArr[0]).booleanValue());
            return null;
        } else {
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f12690t.setTarget(obj);
    }
}
