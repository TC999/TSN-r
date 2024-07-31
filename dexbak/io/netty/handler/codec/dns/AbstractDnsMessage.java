package io.netty.handler.codec.dns;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeak;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.UShort;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractDnsMessage extends AbstractReferenceCounted implements DnsMessage {
    private static final int SECTION_COUNT = 4;
    private Object additionals;
    private Object answers;
    private Object authorities;

    /* renamed from: id */
    private short f40212id;
    private final ResourceLeak leak;
    private DnsOpCode opCode;
    private Object questions;
    private boolean recursionDesired;

    /* renamed from: z */
    private byte f40213z;
    private static final ResourceLeakDetector<DnsMessage> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DnsMessage.class);
    private static final int SECTION_QUESTION = DnsSection.QUESTION.ordinal();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDnsMessage(int i) {
        this(i, DnsOpCode.QUERY);
    }

    private static <T extends DnsRecord> T castRecord(Object obj) {
        return (T) obj;
    }

    private static DnsRecord checkQuestion(int i, DnsRecord dnsRecord) {
        if (i != SECTION_QUESTION || (ObjectUtil.checkNotNull(dnsRecord, "record") instanceof DnsQuestion)) {
            return dnsRecord;
        }
        throw new IllegalArgumentException("record: " + dnsRecord + " (expected: " + StringUtil.simpleClassName((Class<?>) DnsQuestion.class) + ')');
    }

    private static ArrayList<DnsRecord> newRecordList() {
        return new ArrayList<>(2);
    }

    private Object sectionAt(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return this.additionals;
                    }
                    throw new Error();
                }
                return this.authorities;
            }
            return this.answers;
        }
        return this.questions;
    }

    private static int sectionOrdinal(DnsSection dnsSection) {
        return ((DnsSection) ObjectUtil.checkNotNull(dnsSection, "section")).ordinal();
    }

    private void setSection(int i, Object obj) {
        if (i == 0) {
            this.questions = obj;
        } else if (i == 1) {
            this.answers = obj;
        } else if (i == 2) {
            this.authorities = obj;
        } else if (i == 3) {
            this.additionals = obj;
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        addRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage clear(DnsSection dnsSection) {
        clear(sectionOrdinal(dnsSection));
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int count(DnsSection dnsSection) {
        return count(sectionOrdinal(dnsSection));
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        clear();
        ResourceLeak resourceLeak = this.leak;
        if (resourceLeak != null) {
            resourceLeak.close();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DnsMessage) {
            DnsMessage dnsMessage = (DnsMessage) obj;
            if (mo12686id() != dnsMessage.mo12686id()) {
                return false;
            }
            if (this instanceof DnsQuery) {
                if (!(dnsMessage instanceof DnsQuery)) {
                    return false;
                }
            } else if (dnsMessage instanceof DnsQuery) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (mo12686id() * 31) + (!(this instanceof DnsQuery) ? 1 : 0);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    /* renamed from: id */
    public int mo12686id() {
        return this.f40212id & UShort.f40820c;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsOpCode opCode() {
        return this.opCode;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T recordAt(DnsSection dnsSection) {
        return (T) recordAt(sectionOrdinal(dnsSection));
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T removeRecord(DnsSection dnsSection, int i) {
        return (T) removeRecord(sectionOrdinal(dnsSection), i);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setId(int i) {
        this.f40212id = (short) i;
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setOpCode(DnsOpCode dnsOpCode) {
        this.opCode = (DnsOpCode) ObjectUtil.checkNotNull(dnsOpCode, "opCode");
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        setRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setRecursionDesired(boolean z) {
        this.recursionDesired = z;
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage setZ(int i) {
        this.f40213z = (byte) (i & 7);
        return this;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    /* renamed from: z */
    public int mo12685z() {
        return this.f40213z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDnsMessage(int i, DnsOpCode dnsOpCode) {
        this.leak = leakDetector.open(this);
        setId(i);
        setOpCode(dnsOpCode);
    }

    private void addRecord(int i, DnsRecord dnsRecord) {
        checkQuestion(i, dnsRecord);
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            setSection(i, dnsRecord);
        } else if (sectionAt instanceof DnsRecord) {
            ArrayList<DnsRecord> newRecordList = newRecordList();
            newRecordList.add(castRecord(sectionAt));
            newRecordList.add(dnsRecord);
            setSection(i, newRecordList);
        } else {
            ((List) sectionAt).add(dnsRecord);
        }
    }

    private int count(int i) {
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            return 0;
        }
        if (sectionAt instanceof DnsRecord) {
            return 1;
        }
        return ((List) sectionAt).size();
    }

    private <T extends DnsRecord> T recordAt(int i) {
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            return null;
        }
        if (sectionAt instanceof DnsRecord) {
            return (T) castRecord(sectionAt);
        }
        List list = (List) sectionAt;
        if (list.isEmpty()) {
            return null;
        }
        return (T) castRecord(list.get(0));
    }

    private <T extends DnsRecord> T removeRecord(int i, int i2) {
        Object sectionAt = sectionAt(i);
        if (sectionAt != null) {
            if (sectionAt instanceof DnsRecord) {
                if (i2 == 0) {
                    T t = (T) castRecord(sectionAt);
                    setSection(i, null);
                    return t;
                }
                throw new IndexOutOfBoundsException("index: " + i2 + " (expected: 0)");
            }
            return (T) castRecord(((List) sectionAt).remove(i2));
        }
        throw new IndexOutOfBoundsException("index: " + i2 + " (expected: none)");
    }

    private void setRecord(int i, DnsRecord dnsRecord) {
        clear(i);
        setSection(i, checkQuestion(i, dnsRecord));
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage clear() {
        for (int i = 0; i < 4; i++) {
            clear(i);
        }
        return this;
    }

    private void clear(int i) {
        Object sectionAt = sectionAt(i);
        setSection(i, null);
        if (sectionAt instanceof ReferenceCounted) {
            ((ReferenceCounted) sectionAt).release();
        } else if (sectionAt instanceof List) {
            List<Object> list = (List) sectionAt;
            if (list.isEmpty()) {
                return;
            }
            for (Object obj : list) {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage retain() {
        return (DnsMessage) super.retain();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage touch() {
        return (DnsMessage) super.touch();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public DnsMessage retain(int i) {
        return (DnsMessage) super.retain(i);
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T setRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        return (T) setRecord(sectionOrdinal(dnsSection), i, dnsRecord);
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsMessage touch(Object obj) {
        ResourceLeak resourceLeak = this.leak;
        if (resourceLeak != null) {
            resourceLeak.record(obj);
        }
        return this;
    }

    private <T extends DnsRecord> T setRecord(int i, int i2, DnsRecord dnsRecord) {
        checkQuestion(i, dnsRecord);
        Object sectionAt = sectionAt(i);
        if (sectionAt != null) {
            if (sectionAt instanceof DnsRecord) {
                if (i2 == 0) {
                    setSection(i, dnsRecord);
                    return (T) castRecord(sectionAt);
                }
                throw new IndexOutOfBoundsException("index: " + i2 + " (expected: 0)");
            }
            return (T) castRecord(((List) sectionAt).set(i2, dnsRecord));
        }
        throw new IndexOutOfBoundsException("index: " + i2 + " (expected: none)");
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public int count() {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += count(i2);
        }
        return i;
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public <T extends DnsRecord> T recordAt(DnsSection dnsSection, int i) {
        return (T) recordAt(sectionOrdinal(dnsSection), i);
    }

    private <T extends DnsRecord> T recordAt(int i, int i2) {
        Object sectionAt = sectionAt(i);
        if (sectionAt != null) {
            if (sectionAt instanceof DnsRecord) {
                if (i2 == 0) {
                    return (T) castRecord(sectionAt);
                }
                throw new IndexOutOfBoundsException("index: " + i2 + "' (expected: 0)");
            }
            return (T) castRecord(((List) sectionAt).get(i2));
        }
        throw new IndexOutOfBoundsException("index: " + i2 + " (expected: none)");
    }

    @Override // io.netty.handler.codec.dns.DnsMessage
    public DnsMessage addRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        addRecord(sectionOrdinal(dnsSection), i, dnsRecord);
        return this;
    }

    private void addRecord(int i, int i2, DnsRecord dnsRecord) {
        ArrayList<DnsRecord> newRecordList;
        checkQuestion(i, dnsRecord);
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            if (i2 == 0) {
                setSection(i, dnsRecord);
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i2 + " (expected: 0)");
        } else if (sectionAt instanceof DnsRecord) {
            if (i2 == 0) {
                newRecordList = newRecordList();
                newRecordList.add(dnsRecord);
                newRecordList.add(castRecord(sectionAt));
            } else if (i2 == 1) {
                newRecordList = newRecordList();
                newRecordList.add(castRecord(sectionAt));
                newRecordList.add(dnsRecord);
            } else {
                throw new IndexOutOfBoundsException("index: " + i2 + " (expected: 0 or 1)");
            }
            setSection(i, newRecordList);
        } else {
            ((List) sectionAt).add(i2, dnsRecord);
        }
    }
}
