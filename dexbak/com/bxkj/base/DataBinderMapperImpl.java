package com.bxkj.base;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.databinding.NewPubTitleBindingImpl;
import com.bxkj.base.databinding.V2PubRecyclerviewWithEmptyViewBindingImpl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a */
    private static final int f14584a = 1;

    /* renamed from: b */
    private static final int f14585b = 2;

    /* renamed from: c */
    private static final SparseIntArray f14586c;

    /* renamed from: com.bxkj.base.DataBinderMapperImpl$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3799a {

        /* renamed from: a */
        static final SparseArray<String> f14587a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(4);
            f14587a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, TTDownloadField.TT_ACTIVITY);
            sparseArray.put(2, "isHideBack");
            sparseArray.put(3, "title");
        }

        private C3799a() {
        }
    }

    /* renamed from: com.bxkj.base.DataBinderMapperImpl$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3800b {

        /* renamed from: a */
        static final HashMap<String, Integer> f14588a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(2);
            f14588a = hashMap;
            hashMap.put("layout/new_pub_title_0", Integer.valueOf(C3801R.C3807layout.new_pub_title));
            hashMap.put("layout/v2_pub_recyclerview_with_empty_view_0", Integer.valueOf(C3801R.C3807layout.v2_pub_recyclerview_with_empty_view));
        }

        private C3800b() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f14586c = sparseIntArray;
        sparseIntArray.put(C3801R.C3807layout.new_pub_title, 1);
        sparseIntArray.put(C3801R.C3807layout.v2_pub_recyclerview_with_empty_view, 2);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return C3799a.f14587a.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = f14586c.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                if (i2 == 1) {
                    if ("layout/new_pub_title_0".equals(tag)) {
                        return new NewPubTitleBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for new_pub_title is invalid. Received: " + tag);
                } else if (i2 != 2) {
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
        if (str == null || (num = C3800b.f14588a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f14586c.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
