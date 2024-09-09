package com.bxkj.base;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.databinding.NewPubTitleBindingImpl;
import com.bxkj.base.databinding.V2PubRecyclerviewWithEmptyViewBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18101a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f18102b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f18103c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f18104a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(4);
            f18104a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "activity");
            sparseArray.put(2, "isHideBack");
            sparseArray.put(3, "title");
        }

        private a() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f18105a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(2);
            f18105a = hashMap;
            hashMap.put("layout/new_pub_title_0", Integer.valueOf(R.layout.new_pub_title));
            hashMap.put("layout/v2_pub_recyclerview_with_empty_view_0", Integer.valueOf(R.layout.v2_pub_recyclerview_with_empty_view));
        }

        private b() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f18103c = sparseIntArray;
        sparseIntArray.put(R.layout.new_pub_title, 1);
        sparseIntArray.put(R.layout.v2_pub_recyclerview_with_empty_view, 2);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i4) {
        return a.f18104a.get(i4);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i4) {
        int i5 = f18103c.get(i4);
        if (i5 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                if (i5 == 1) {
                    if ("layout/new_pub_title_0".equals(tag)) {
                        return new NewPubTitleBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for new_pub_title is invalid. Received: " + tag);
                } else if (i5 != 2) {
                    return null;
                } else {
                    if ("layout/v2_pub_recyclerview_with_empty_view_0".equals(tag)) {
                        return new V2PubRecyclerviewWithEmptyViewBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for v2_pub_recyclerview_with_empty_view is invalid. Received: " + tag);
                }
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f18105a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i4) {
        if (viewArr == null || viewArr.length == 0 || f18103c.get(i4) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
