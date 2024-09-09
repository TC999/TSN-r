package com.bytedance.adsdk.ugeno.component.flexbox;

import android.view.View;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
interface a {
    int a(View view, int i4, int i5);

    int b(int i4, int i5, int i6);

    int c(View view);

    View c(int i4);

    void c(int i4, View view);

    boolean c();

    void d(View view, int i4, int i5, d dVar);

    int e(int i4, int i5, int i6);

    void f(d dVar);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<d> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    void setFlexLines(List<d> list);

    View w(int i4);
}
