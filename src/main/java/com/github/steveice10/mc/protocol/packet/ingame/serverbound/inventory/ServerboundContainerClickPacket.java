package com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory;

import com.github.steveice10.mc.protocol.codec.MinecraftCodecHelper;
import com.github.steveice10.mc.protocol.codec.MinecraftPacket;
import com.github.steveice10.mc.protocol.data.MagicValues;
import com.github.steveice10.mc.protocol.data.game.entity.metadata.ItemStack;
import com.github.steveice10.mc.protocol.data.game.inventory.ClickItemAction;
import com.github.steveice10.mc.protocol.data.game.inventory.ContainerAction;
import com.github.steveice10.mc.protocol.data.game.inventory.ContainerActionType;
import com.github.steveice10.mc.protocol.data.game.inventory.CreativeGrabAction;
import com.github.steveice10.mc.protocol.data.game.inventory.DropItemAction;
import com.github.steveice10.mc.protocol.data.game.inventory.FillStackAction;
import com.github.steveice10.mc.protocol.data.game.inventory.MoveToHotbarAction;
import com.github.steveice10.mc.protocol.data.game.inventory.ShiftClickItemAction;
import com.github.steveice10.mc.protocol.data.game.inventory.SpreadItemAction;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.Data;
import lombok.NonNull;
import lombok.With;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

@Data
@With
public class ServerboundContainerClickPacket implements MinecraftPacket {
    public static final int CLICK_OUTSIDE_NOT_HOLDING_SLOT = -999;

    private final int containerId;
    private final int stateId;
    private final int slot;
    private final ContainerActionType action;
    private final ContainerAction param;
    private final ItemStack carriedItem;
    private final @NonNull Int2ObjectMap<ItemStack> changedSlots;

    public ServerboundContainerClickPacket(int containerId, int stateId, int slot, ContainerActionType action, ContainerAction param, ItemStack carriedItem, @NotNull Map<Integer, ItemStack> changedSlots) {
        this(containerId, stateId, slot, action, param, carriedItem, new Int2ObjectOpenHashMap<>(changedSlots));
    }

    public ServerboundContainerClickPacket(int containerId, int stateId, int slot, ContainerActionType action, ContainerAction param, ItemStack carriedItem, @NotNull Int2ObjectMap<ItemStack> changedSlots) {
        if ((param == DropItemAction.LEFT_CLICK_OUTSIDE_NOT_HOLDING || param == DropItemAction.RIGHT_CLICK_OUTSIDE_NOT_HOLDING)
                && slot != -CLICK_OUTSIDE_NOT_HOLDING_SLOT) {
            throw new IllegalArgumentException("Slot must be " + CLICK_OUTSIDE_NOT_HOLDING_SLOT
                    + " with param LEFT_CLICK_OUTSIDE_NOT_HOLDING or RIGHT_CLICK_OUTSIDE_NOT_HOLDING");
        }

        this.containerId = containerId;
        this.stateId = stateId;
        this.slot = slot;
        this.action = action;
        this.param = param;
        this.carriedItem = carriedItem;
        this.changedSlots = changedSlots;
    }

    public ServerboundContainerClickPacket(ByteBuf in, MinecraftCodecHelper helper) throws IOException {
        this.containerId = in.readByte();
        this.stateId = helper.readVarInt(in);
        this.slot = in.readShort();
        byte param = in.readByte();
        this.action = MagicValues.key(ContainerActionType.class, in.readByte());
        if (this.action == ContainerActionType.CLICK_ITEM) {
            this.param = MagicValues.key(ClickItemAction.class, param);
        } else if (this.action == ContainerActionType.SHIFT_CLICK_ITEM) {
            this.param = MagicValues.key(ShiftClickItemAction.class, param);
        } else if (this.action == ContainerActionType.MOVE_TO_HOTBAR_SLOT) {
            this.param = MagicValues.key(MoveToHotbarAction.class, param);
        } else if (this.action == ContainerActionType.CREATIVE_GRAB_MAX_STACK) {
            this.param = MagicValues.key(CreativeGrabAction.class, param);
        } else if (this.action == ContainerActionType.DROP_ITEM) {
            this.param = MagicValues.key(DropItemAction.class, param + (this.slot != -999 ? 2 : 0));
        } else if (this.action == ContainerActionType.SPREAD_ITEM) {
            this.param = MagicValues.key(SpreadItemAction.class, param);
        } else if (this.action == ContainerActionType.FILL_STACK) {
            this.param = MagicValues.key(FillStackAction.class, param);
        } else {
            throw new IllegalStateException();
        }

        int changedItemsSize = helper.readVarInt(in);
        this.changedSlots = new Int2ObjectOpenHashMap<>(changedItemsSize);
        for (int i = 0; i < changedItemsSize; i++) {
            int key = in.readShort();
            ItemStack value = helper.readItemStack(in);
            this.changedSlots.put(key, value);
        }

        this.carriedItem = helper.readItemStack(in);
    }

    @Override
    public void serialize(ByteBuf out, MinecraftCodecHelper helper) throws IOException {
        out.writeByte(this.containerId);
        helper.writeVarInt(out, this.stateId);
        out.writeShort(this.slot);

        int param = MagicValues.value(Integer.class, this.param);
        if (this.action == ContainerActionType.DROP_ITEM) {
            param %= 2;
        }

        out.writeByte(param);
        out.writeByte(MagicValues.value(Integer.class, this.action));

        helper.writeVarInt(out, this.changedSlots.size());
        for (Int2ObjectMap.Entry<ItemStack> pair : this.changedSlots.int2ObjectEntrySet()) {
            out.writeShort(pair.getIntKey());
            helper.writeItemStack(out, pair.getValue());
        }

        helper.writeItemStack(out, this.carriedItem);
    }
}
