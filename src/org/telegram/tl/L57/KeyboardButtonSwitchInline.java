package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class KeyboardButtonSwitchInline extends TLKeyboardButton {

    public static final int ID = 0x568a748;

    public int flags;
    public String text;
    public String query;

    public KeyboardButtonSwitchInline() {
    }

    public KeyboardButtonSwitchInline(int flags, String text, String query) {
        this.flags = flags;
        this.text = text;
        this.query = query;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        flags = buffer.readInt();
        text = buffer.readString();
        query = buffer.readString();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        setFlags();
        serializeTo(buffer);
        return buffer;
    }

    public void setFlags() {
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(flags);
        buff.writeString(text);
        buff.writeString(query);
    }

    public boolean is_same_peer() {
        return (flags & (1 << 0)) != 0;
    }

    public void set_same_peer(boolean v) {
        if (v) {
            flags |= (1 << 0);
        } else {
            flags &= ~(1 << 0);
        }
    }

    public int getConstructor() {
        return ID;
    }
}