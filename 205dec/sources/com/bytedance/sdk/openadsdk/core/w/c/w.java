package com.bytedance.sdk.openadsdk.core.w.c;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {
    public w() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(Map<String, Object> map) {
        return !w(this.sr);
    }

    public boolean w(View view) {
        if (view == null || this.f35278c == null) {
            return true;
        }
        String valueOf = String.valueOf(view.getTag(2097610717));
        if (view.getTag(2097610717) != null && !TextUtils.isEmpty(valueOf)) {
            if ("click".equals(valueOf)) {
                return this.xv.sr();
            }
            return true;
        }
        Context context = this.f35279w;
        if (context == null) {
            context = ls.getContext();
        }
        return c(view, context) ? this.f35278c.n() != 1 || this.xv.sr() : this.f35278c.gb() != 1 || this.xv.sr();
    }

    public w(me meVar, Context context) {
        this.f35278c = meVar;
        this.f35279w = context;
    }

    public boolean c(View view, Context context) {
        int id = view.getId();
        List<Integer> p3 = this.xv.p();
        if (p3 != null && p3.size() == 0) {
            p3.add(2114387833);
            p3.add(2114387867);
            p3.add(2114387632);
            p3.add(2114387465);
            p3.add(2114387467);
            p3.add(2114387962);
            p3.add(2114387727);
            p3.add(2114387624);
        }
        return p3 != null && p3.contains(Integer.valueOf(id));
    }

    public boolean c(View view, Point point) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                View childAt = viewGroup.getChildAt(i5);
                Context context = this.f35279w;
                if (context == null) {
                    context = ls.getContext();
                }
                if (c(childAt, context)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    int i6 = point.x;
                    return i6 >= iArr[0] && i6 <= iArr[0] + childAt.getWidth() && (i4 = point.y) >= iArr[1] && i4 <= iArr[1] + childAt.getHeight();
                } else if (c(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
