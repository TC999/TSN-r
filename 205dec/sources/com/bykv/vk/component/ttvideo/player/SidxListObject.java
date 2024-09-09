package com.bykv.vk.component.ttvideo.player;

import java.util.ArrayList;
import java.util.List;

@JNINamespace("PLAYER")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SidxListObject extends NativeObject {
    private long mBitrate;
    private int mEndIndex;
    private String mFileId;
    private List<SidxItem> mItems = new ArrayList();
    private int mMediaType;
    private int mStartIndex;
    private int mTotalNum;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class SidxItem {
        private long mDuration;
        private int mIndex;
        private long mOffset;
        private long mSize;
        private long mTimestamp;

        public SidxItem(int i4, long j4, long j5, long j6, long j7) {
            this.mIndex = i4;
            this.mOffset = j4;
            this.mTimestamp = j5;
            this.mDuration = j6;
            this.mSize = j7;
        }

        public long getDuration() {
            return this.mDuration;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public long getOffset() {
            return this.mOffset;
        }

        public long getSize() {
            return this.mSize;
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }
    }

    @CalledByNative
    public SidxListObject(int i4, int i5, int i6, int i7, long j4, String str) {
        this.mMediaType = i4;
        this.mTotalNum = i5;
        this.mStartIndex = i6;
        this.mEndIndex = i7;
        this.mBitrate = j4;
        this.mFileId = str;
    }

    @CalledByNative
    public void addItem(int i4, long j4, long j5, long j6, long j7) {
        this.mItems.add(new SidxItem(i4, j4, j5, j6, j7));
    }

    public long getBitrate() {
        return this.mBitrate;
    }

    public int getEndIndex() {
        return this.mEndIndex;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public SidxItem getItem(int i4) {
        if (i4 < 0 || i4 >= this.mItems.size()) {
            return null;
        }
        return this.mItems.get(i4);
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }
}
