package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class SerializeFilterable {
    protected List<BeforeFilter> beforeFilters = null;
    protected List<AfterFilter> afterFilters = null;
    protected List<PropertyFilter> propertyFilters = null;
    protected List<ValueFilter> valueFilters = null;
    protected List<NameFilter> nameFilters = null;
    protected List<PropertyPreFilter> propertyPreFilters = null;
    protected List<LabelFilter> labelFilters = null;
    protected List<ContextValueFilter> contextValueFilters = null;
    protected boolean writeDirect = true;

    public void addFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        if (serializeFilter instanceof PropertyPreFilter) {
            getPropertyPreFilters().add((PropertyPreFilter) serializeFilter);
        }
        if (serializeFilter instanceof NameFilter) {
            getNameFilters().add((NameFilter) serializeFilter);
        }
        if (serializeFilter instanceof ValueFilter) {
            getValueFilters().add((ValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof ContextValueFilter) {
            getContextValueFilters().add((ContextValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof PropertyFilter) {
            getPropertyFilters().add((PropertyFilter) serializeFilter);
        }
        if (serializeFilter instanceof BeforeFilter) {
            getBeforeFilters().add((BeforeFilter) serializeFilter);
        }
        if (serializeFilter instanceof AfterFilter) {
            getAfterFilters().add((AfterFilter) serializeFilter);
        }
        if (serializeFilter instanceof LabelFilter) {
            getLabelFilters().add((LabelFilter) serializeFilter);
        }
    }

    public boolean apply(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<PropertyFilter> list = jSONSerializer.propertyFilters;
        if (list != null) {
            for (PropertyFilter propertyFilter : list) {
                if (!propertyFilter.apply(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<PropertyFilter> list2 = this.propertyFilters;
        if (list2 != null) {
            for (PropertyFilter propertyFilter2 : list2) {
                if (!propertyFilter2.apply(obj, str, obj2)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public boolean applyName(JSONSerializer jSONSerializer, Object obj, String str) {
        List<PropertyPreFilter> list = jSONSerializer.propertyPreFilters;
        if (list != null) {
            for (PropertyPreFilter propertyPreFilter : list) {
                if (!propertyPreFilter.apply(jSONSerializer, obj, str)) {
                    return false;
                }
            }
        }
        List<PropertyPreFilter> list2 = this.propertyPreFilters;
        if (list2 != null) {
            for (PropertyPreFilter propertyPreFilter2 : list2) {
                if (!propertyPreFilter2.apply(jSONSerializer, obj, str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.afterFilters;
    }

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.beforeFilters;
    }

    public List<ContextValueFilter> getContextValueFilters() {
        if (this.contextValueFilters == null) {
            this.contextValueFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.contextValueFilters;
    }

    public List<LabelFilter> getLabelFilters() {
        if (this.labelFilters == null) {
            this.labelFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.labelFilters;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.nameFilters;
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.propertyFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.propertyPreFilters;
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.valueFilters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String processKey(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<NameFilter> list = jSONSerializer.nameFilters;
        if (list != null) {
            for (NameFilter nameFilter : list) {
                str = nameFilter.process(obj, str, obj2);
            }
        }
        List<NameFilter> list2 = this.nameFilters;
        if (list2 != null) {
            for (NameFilter nameFilter2 : list2) {
                str = nameFilter2.process(obj, str, obj2);
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object processValue(JSONSerializer jSONSerializer, BeanContext beanContext, Object obj, String str, Object obj2) {
        boolean z;
        if (obj2 != null) {
            if ((jSONSerializer.out.writeNonStringValueAsString || !(beanContext == null || (beanContext.getFeatures() & SerializerFeature.WriteNonStringValueAsString.mask) == 0)) && (((z = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                String str2 = null;
                if (z && beanContext != null) {
                    str2 = beanContext.getFormat();
                }
                if (str2 != null) {
                    obj2 = new DecimalFormat(str2).format(obj2);
                } else {
                    obj2 = obj2.toString();
                }
            } else if (beanContext != null && beanContext.isJsonDirect()) {
                obj2 = JSON.parse((String) obj2);
            }
        }
        List<ValueFilter> list = jSONSerializer.valueFilters;
        if (list != null) {
            for (ValueFilter valueFilter : list) {
                obj2 = valueFilter.process(obj, str, obj2);
            }
        }
        List<ValueFilter> list2 = this.valueFilters;
        if (list2 != null) {
            for (ValueFilter valueFilter2 : list2) {
                obj2 = valueFilter2.process(obj, str, obj2);
            }
        }
        List<ContextValueFilter> list3 = jSONSerializer.contextValueFilters;
        if (list3 != null) {
            for (ContextValueFilter contextValueFilter : list3) {
                obj2 = contextValueFilter.process(beanContext, obj, str, obj2);
            }
        }
        List<ContextValueFilter> list4 = this.contextValueFilters;
        if (list4 != null) {
            for (ContextValueFilter contextValueFilter2 : list4) {
                obj2 = contextValueFilter2.process(beanContext, obj, str, obj2);
            }
        }
        return obj2;
    }

    protected boolean writeDirect(JSONSerializer jSONSerializer) {
        return jSONSerializer.out.writeDirect && this.writeDirect && jSONSerializer.writeDirect;
    }
}
