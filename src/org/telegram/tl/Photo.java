package org.telegram.tl;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.*;

public class Photo extends TLPhoto {

    public static final int ID = 0xcded42fe;

    public long id;
    public long access_hash;
    public int date;
    public TLVector<TLPhotoSize> sizes;

    public Photo() {
        this.sizes = new TLVector<>();
    }

    public Photo(long id, long access_hash, int date, TLVector<TLPhotoSize> sizes) {
        this.id = id;
        this.access_hash = access_hash;
        this.date = date;
        this.sizes = sizes;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        id = buffer.readLong();
        access_hash = buffer.readLong();
        date = buffer.readInt();
        sizes = (TLVector<TLPhotoSize>) buffer.readTLObject(APIContext.getInstance());
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeLong(id);
        buff.writeLong(access_hash);
        buff.writeInt(date);
        buff.writeTLObject(sizes);
    }

    public int getConstructor() {
        return ID;
    }
}