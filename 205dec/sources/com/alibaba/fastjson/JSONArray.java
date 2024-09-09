package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class JSONArray extends JSON implements List<Object>, Cloneable, RandomAccess, Serializable {
    private static final long serialVersionUID = 1;
    protected transient Type componentType;
    private final List<Object> list;
    protected transient Object relatedArray;

    public JSONArray() {
        this.list = new ArrayList();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Object> collection) {
        return this.list.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
    }

    public Object clone() {
        return new JSONArray(new ArrayList(this.list));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    public JSONArray fluentAdd(Object obj) {
        this.list.add(obj);
        return this;
    }

    public JSONArray fluentAddAll(Collection<? extends Object> collection) {
        this.list.addAll(collection);
        return this;
    }

    public JSONArray fluentClear() {
        this.list.clear();
        return this;
    }

    public JSONArray fluentRemove(Object obj) {
        this.list.remove(obj);
        return this;
    }

    public JSONArray fluentRemoveAll(Collection<?> collection) {
        this.list.removeAll(collection);
        return this;
    }

    public JSONArray fluentRetainAll(Collection<?> collection) {
        this.list.retainAll(collection);
        return this;
    }

    public JSONArray fluentSet(int i4, Object obj) {
        set(i4, obj);
        return this;
    }

    @Override // java.util.List
    public Object get(int i4) {
        return this.list.get(i4);
    }

    public BigDecimal getBigDecimal(int i4) {
        return TypeUtils.castToBigDecimal(get(i4));
    }

    public BigInteger getBigInteger(int i4) {
        return TypeUtils.castToBigInteger(get(i4));
    }

    public Boolean getBoolean(int i4) {
        Object obj = get(i4);
        if (obj == null) {
            return null;
        }
        return TypeUtils.castToBoolean(obj);
    }

    public boolean getBooleanValue(int i4) {
        Object obj = get(i4);
        if (obj == null) {
            return false;
        }
        return TypeUtils.castToBoolean(obj).booleanValue();
    }

    public Byte getByte(int i4) {
        return TypeUtils.castToByte(get(i4));
    }

    public byte getByteValue(int i4) {
        Object obj = get(i4);
        if (obj == null) {
            return (byte) 0;
        }
        return TypeUtils.castToByte(obj).byteValue();
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public Date getDate(int i4) {
        return TypeUtils.castToDate(get(i4));
    }

    public Double getDouble(int i4) {
        return TypeUtils.castToDouble(get(i4));
    }

    public double getDoubleValue(int i4) {
        Object obj = get(i4);
        if (obj == null) {
            return 0.0d;
        }
        return TypeUtils.castToDouble(obj).doubleValue();
    }

    public Float getFloat(int i4) {
        return TypeUtils.castToFloat(get(i4));
    }

    public float getFloatValue(int i4) {
        Object obj = get(i4);
        if (obj == null) {
            return 0.0f;
        }
        return TypeUtils.castToFloat(obj).floatValue();
    }

    public int getIntValue(int i4) {
        Object obj = get(i4);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.castToInt(obj).intValue();
    }

    public Integer getInteger(int i4) {
        return TypeUtils.castToInt(get(i4));
    }

    public JSONArray getJSONArray(int i4) {
        Object obj = this.list.get(i4);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        return (JSONArray) JSON.toJSON(obj);
    }

    public JSONObject getJSONObject(int i4) {
        Object obj = this.list.get(i4);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        return (JSONObject) JSON.toJSON(obj);
    }

    public Long getLong(int i4) {
        return TypeUtils.castToLong(get(i4));
    }

    public long getLongValue(int i4) {
        Object obj = get(i4);
        if (obj == null) {
            return 0L;
        }
        return TypeUtils.castToLong(obj).longValue();
    }

    public <T> T getObject(int i4, Class<T> cls) {
        return (T) TypeUtils.castToJavaBean(this.list.get(i4), cls);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public Short getShort(int i4) {
        return TypeUtils.castToShort(get(i4));
    }

    public short getShortValue(int i4) {
        Object obj = get(i4);
        if (obj == null) {
            return (short) 0;
        }
        return TypeUtils.castToShort(obj).shortValue();
    }

    public java.sql.Date getSqlDate(int i4) {
        return TypeUtils.castToSqlDate(get(i4));
    }

    public String getString(int i4) {
        return TypeUtils.castToString(get(i4));
    }

    public Timestamp getTimestamp(int i4) {
        return TypeUtils.castToTimestamp(get(i4));
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    @Override // java.util.List
    public Object set(int i4, Object obj) {
        if (i4 == -1) {
            this.list.add(obj);
            return null;
        } else if (this.list.size() <= i4) {
            for (int size = this.list.size(); size < i4; size++) {
                this.list.add(null);
            }
            this.list.add(obj);
            return null;
        } else {
            return this.list.set(i4, obj);
        }
    }

    public void setComponentType(Type type) {
        this.componentType = type;
    }

    public void setRelatedArray(Object obj) {
        this.relatedArray = obj;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.list.size();
    }

    @Override // java.util.List
    public List<Object> subList(int i4, int i5) {
        return this.list.subList(i4, i5);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    public <T> List<T> toJavaList(Class<T> cls) {
        ArrayList arrayList = new ArrayList(size());
        ParserConfig globalInstance = ParserConfig.getGlobalInstance();
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            arrayList.add(TypeUtils.cast(it.next(), (Class<Object>) cls, globalInstance));
        }
        return arrayList;
    }

    @Override // java.util.List
    public void add(int i4, Object obj) {
        this.list.add(i4, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i4, Collection<? extends Object> collection) {
        return this.list.addAll(i4, collection);
    }

    public JSONArray fluentAdd(int i4, Object obj) {
        this.list.add(i4, obj);
        return this;
    }

    public JSONArray fluentAddAll(int i4, Collection<? extends Object> collection) {
        this.list.addAll(i4, collection);
        return this;
    }

    public JSONArray fluentRemove(int i4) {
        this.list.remove(i4);
        return this;
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i4) {
        return this.list.listIterator(i4);
    }

    @Override // java.util.List
    public Object remove(int i4) {
        return this.list.remove(i4);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.list.toArray(tArr);
    }

    public JSONArray(List<Object> list) {
        this.list = list;
    }

    public JSONArray(int i4) {
        this.list = new ArrayList(i4);
    }
}
