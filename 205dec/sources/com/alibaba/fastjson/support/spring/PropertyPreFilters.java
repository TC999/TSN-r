package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PropertyPreFilters {
    private List<MySimplePropertyPreFilter> filters = new ArrayList();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class MySimplePropertyPreFilter extends SimplePropertyPreFilter {
        public MySimplePropertyPreFilter() {
            super(new String[0]);
        }

        public MySimplePropertyPreFilter addExcludes(String... strArr) {
            for (String str : strArr) {
                getExcludes().add(str);
            }
            return this;
        }

        public MySimplePropertyPreFilter addIncludes(String... strArr) {
            for (String str : strArr) {
                getIncludes().add(str);
            }
            return this;
        }

        public MySimplePropertyPreFilter(String... strArr) {
            super(strArr);
        }

        public MySimplePropertyPreFilter(Class<?> cls, String... strArr) {
            super(cls, strArr);
        }
    }

    public MySimplePropertyPreFilter addFilter() {
        MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter();
        this.filters.add(mySimplePropertyPreFilter);
        return mySimplePropertyPreFilter;
    }

    public List<MySimplePropertyPreFilter> getFilters() {
        return this.filters;
    }

    public void setFilters(List<MySimplePropertyPreFilter> list) {
        this.filters = list;
    }

    public MySimplePropertyPreFilter[] toFilters() {
        return (MySimplePropertyPreFilter[]) this.filters.toArray(new MySimplePropertyPreFilter[0]);
    }

    public MySimplePropertyPreFilter addFilter(String... strArr) {
        MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter(strArr);
        this.filters.add(mySimplePropertyPreFilter);
        return mySimplePropertyPreFilter;
    }

    public MySimplePropertyPreFilter addFilter(Class<?> cls, String... strArr) {
        MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter(cls, strArr);
        this.filters.add(mySimplePropertyPreFilter);
        return mySimplePropertyPreFilter;
    }
}
