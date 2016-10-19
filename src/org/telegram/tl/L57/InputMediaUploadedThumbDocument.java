package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class InputMediaUploadedThumbDocument extends org.telegram.tl.TLInputMedia {

    public static final int ID = 0x50d88cae;

    public int flags;
    public org.telegram.tl.TLInputFile file;
    public org.telegram.tl.TLInputFile thumb;
    public String mime_type;
    public TLVector<org.telegram.tl.TLDocumentAttribute> attributes;
    public String caption;
    public TLVector<org.telegram.tl.TLInputDocument> stickers;

    public InputMediaUploadedThumbDocument() {
        this.attributes = new TLVector<>();
        this.stickers = new TLVector<>();
    }

    public InputMediaUploadedThumbDocument(int flags, org.telegram.tl.TLInputFile file, org.telegram.tl.TLInputFile thumb, String mime_type, TLVector<org.telegram.tl.TLDocumentAttribute> attributes, String caption, TLVector<org.telegram.tl.TLInputDocument> stickers) {
        this.flags = flags;
        this.file = file;
        this.thumb = thumb;
        this.mime_type = mime_type;
        this.attributes = attributes;
        this.caption = caption;
        this.stickers = stickers;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        flags = buffer.readInt();
        file = (org.telegram.tl.TLInputFile) buffer.readTLObject(APIContext.getInstance());
        thumb = (org.telegram.tl.TLInputFile) buffer.readTLObject(APIContext.getInstance());
        mime_type = buffer.readString();
        attributes = (TLVector<org.telegram.tl.TLDocumentAttribute>) buffer.readTLObject(APIContext.getInstance());
        caption = buffer.readString();
        if ((flags & (1 << 0)) != 0) {
            stickers = (TLVector<org.telegram.tl.TLInputDocument>) buffer.readTLVector(org.telegram.tl.TLInputDocument.class);
        }
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(56);
        setFlags();
        serializeTo(buffer);
        return buffer;
    }

    public void setFlags() {
        if (stickers != null) {
            flags |= (1 << 0);
        }
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(flags);
        buff.writeTLObject(file);
        buff.writeTLObject(thumb);
        buff.writeString(mime_type);
        buff.writeTLObject(attributes);
        buff.writeString(caption);
        if ((flags & (1 << 0)) != 0) {
            buff.writeTLObject(stickers);
        }
    }


    public int getConstructor() {
        return ID;
    }
}