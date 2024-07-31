package cn.bluemobi.dylan.photoview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class HackyViewPager extends ViewPager {

    /* renamed from: a */
    private static final String f1860a = "HackyViewPager";

    public HackyViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException unused) {
            Log.e(f1860a, "hacky viewpager error2");
            return false;
        } catch (IllegalArgumentException unused2) {
            Log.e(f1860a, "hacky viewpager error1");
            return false;
        }
    }

    public HackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
