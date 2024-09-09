package cn.bluemobi.dylan.photoview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class HackyViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1845a = "HackyViewPager";

    public HackyViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException unused) {
            Log.e("HackyViewPager", "hacky viewpager error2");
            return false;
        } catch (IllegalArgumentException unused2) {
            Log.e("HackyViewPager", "hacky viewpager error1");
            return false;
        }
    }

    public HackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
