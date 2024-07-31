package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.p050a.C2576c;
import com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewPager2Delegate extends ViewPager2 implements InterfaceC2574a {

    /* renamed from: m */
    private static final String f8882m = "getScrollState";

    /* renamed from: n */
    private static final String f8883n = "getCurrentItem";

    /* renamed from: o */
    private static final String f8884o = "setCurrentItem";

    /* renamed from: p */
    private static final String f8885p = "setOrientation";

    /* renamed from: q */
    private static final String f8886q = "setAdapter";

    /* renamed from: r */
    private static final String f8887r = "setOffscreenPageLimit";

    /* renamed from: s */
    private static final String f8888s = "setUserInputEnabled";

    /* renamed from: t */
    private final C2576c f8889t;

    public ViewPager2Delegate(IAdInterListener iAdInterListener, Context context) {
        super(context);
        this.f8889t = C2576c.m51074a(iAdInterListener, this);
        setOnOverScrollListener(new ViewPager2.OnOverScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollEnd() {
                ViewPager2Delegate.this.f8889t.m51073a("onOverScrollEnd");
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollStart() {
                ViewPager2Delegate.this.f8889t.m51073a("onOverScrollStart");
            }
        });
        registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                ViewPager2Delegate.this.f8889t.m51072a("onPageScrollStateChanged", Integer.valueOf(i));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i, float f, int i2) {
                ViewPager2Delegate.this.f8889t.m51072a("onPageScrolled", Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                ViewPager2Delegate.this.f8889t.m51072a("onPageSelected", Integer.valueOf(i));
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f8889t.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f8889t.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f8889t.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f8889t.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f8889t.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f8889t.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f8882m.equals(str2)) {
            return Integer.valueOf(getScrollState());
        }
        if (f8883n.equals(str2)) {
            return Integer.valueOf(getCurrentItem());
        }
        if (f8884o.equals(str2) && C2576c.m51071a(objArr, Integer.class)) {
            setCurrentItem(((Integer) objArr[0]).intValue());
            return null;
        } else if (f8885p.equals(str2) && C2576c.m51071a(objArr, Integer.class)) {
            setOrientation(((Integer) objArr[0]).intValue());
            return null;
        } else if (f8886q.equals(str2) && C2576c.m51071a(objArr, RecyclerView.Adapter.class)) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        } else if (f8887r.equals(str2) && C2576c.m51071a(objArr, Integer.class)) {
            setOffscreenPageLimit(((Integer) objArr[0]).intValue());
            return null;
        } else if (f8888s.equals(str2) && C2576c.m51071a(objArr, Boolean.class)) {
            setUserInputEnabled(((Boolean) objArr[0]).booleanValue());
            return null;
        } else {
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f8889t.setTarget(obj);
    }
}
