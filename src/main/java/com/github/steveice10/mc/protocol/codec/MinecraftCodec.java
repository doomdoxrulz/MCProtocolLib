package com.github.steveice10.mc.protocol.codec;

import com.github.steveice10.mc.protocol.data.ProtocolState;
import com.github.steveice10.mc.protocol.data.game.level.event.LevelEvent;
import com.github.steveice10.mc.protocol.data.game.level.sound.BuiltinSound;
import com.github.steveice10.mc.protocol.packet.handshake.serverbound.ClientIntentionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundAwardStatsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundBossEventPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundChangeDifficultyPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundCommandSuggestionsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundCommandsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundCooldownPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundCustomChatCompletionsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundCustomPayloadPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundDeleteChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundDisconnectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundDisguisedChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundKeepAlivePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundLoginPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundPingPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundPlayerChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundPlayerInfoRemovePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundPlayerInfoUpdatePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundRecipePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundResourcePackPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundRespawnPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundSelectAdvancementsTabPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundServerDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundSetCameraPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundSoundEntityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundStopSoundPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundSystemChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundTabListPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundUpdateAdvancementsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundUpdateEnabledFeaturesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundUpdateRecipesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundUpdateTagsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundAnimatePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundEntityEventPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundMoveEntityPosPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundMoveEntityPosRotPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundMoveEntityRotPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundMoveVehiclePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundRemoveEntitiesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundRemoveMobEffectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundRotateHeadPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundSetEntityDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundSetEntityLinkPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundSetEntityMotionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundSetEquipmentPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundSetPassengersPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundTakeItemEntityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundTeleportEntityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundUpdateAttributesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundUpdateMobEffectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundBlockChangedAckPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundPlayerAbilitiesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundPlayerCombatEndPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundPlayerCombatEnterPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundPlayerCombatKillPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundPlayerLookAtPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundPlayerPositionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundSetCarriedItemPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundSetExperiencePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.player.ClientboundSetHealthPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.spawn.ClientboundAddEntityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.spawn.ClientboundAddExperienceOrbPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.spawn.ClientboundAddPlayerPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundContainerClosePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundContainerSetContentPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundContainerSetDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundContainerSetSlotPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundHorseScreenOpenPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundMerchantOffersPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundOpenBookPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundOpenScreenPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundPlaceGhostRecipePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundBlockDestructionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundBlockEntityDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundBlockEventPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundBlockUpdatePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundExplodePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundForgetLevelChunkPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundGameEventPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundLevelChunkWithLightPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundLevelEventPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundLevelParticlesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundLightUpdatePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundMapItemDataPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundOpenSignEditorPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundSectionBlocksUpdatePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundSetChunkCacheCenterPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundSetChunkCacheRadiusPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundSetDefaultSpawnPositionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundSetSimulationDistancePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundSetTimePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundSoundPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundTagQueryPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.border.ClientboundInitializeBorderPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.border.ClientboundSetBorderCenterPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.border.ClientboundSetBorderLerpSizePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.border.ClientboundSetBorderSizePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.border.ClientboundSetBorderWarningDelayPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.border.ClientboundSetBorderWarningDistancePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.scoreboard.ClientboundSetDisplayObjectivePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.scoreboard.ClientboundSetObjectivePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.scoreboard.ClientboundSetPlayerTeamPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.scoreboard.ClientboundSetScorePacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.title.ClientboundClearTitlesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.title.ClientboundSetActionBarTextPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.title.ClientboundSetSubtitleTextPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.title.ClientboundSetTitleTextPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.title.ClientboundSetTitlesAnimationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChangeDifficultyPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatAckPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatCommandPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatSessionUpdatePacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundClientCommandPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundClientInformationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundCommandSuggestionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundCustomPayloadPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundKeepAlivePacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundLockDifficultyPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundPongPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundResourcePackPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundContainerButtonClickPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundContainerClickPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundContainerClosePacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundEditBookPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundPickItemPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundPlaceRecipePacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundRecipeBookChangeSettingsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundRecipeBookSeenRecipePacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundRenameItemPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundSeenAdvancementsPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundSelectTradePacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundSetBeaconPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundSetCommandBlockPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundSetCommandMinecartPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundSetCreativeModeSlotPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundSetJigsawBlockPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.inventory.ServerboundSetStructureBlockPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundAcceptTeleportationPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundBlockEntityTagQuery;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundEntityTagQuery;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundJigsawGeneratePacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundMoveVehiclePacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundPaddleBoatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundPlayerInputPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundSignUpdatePacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundTeleportToEntityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundInteractPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundMovePlayerPosPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundMovePlayerPosRotPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundMovePlayerRotPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundMovePlayerStatusOnlyPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundPlayerAbilitiesPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundPlayerActionPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundPlayerCommandPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundSetCarriedItemPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundSwingPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundUseItemOnPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundUseItemPacket;
import com.github.steveice10.mc.protocol.packet.login.clientbound.ClientboundCustomQueryPacket;
import com.github.steveice10.mc.protocol.packet.login.clientbound.ClientboundGameProfilePacket;
import com.github.steveice10.mc.protocol.packet.login.clientbound.ClientboundHelloPacket;
import com.github.steveice10.mc.protocol.packet.login.clientbound.ClientboundLoginCompressionPacket;
import com.github.steveice10.mc.protocol.packet.login.clientbound.ClientboundLoginDisconnectPacket;
import com.github.steveice10.mc.protocol.packet.login.serverbound.ServerboundCustomQueryPacket;
import com.github.steveice10.mc.protocol.packet.login.serverbound.ServerboundHelloPacket;
import com.github.steveice10.mc.protocol.packet.login.serverbound.ServerboundKeyPacket;
import com.github.steveice10.mc.protocol.packet.status.clientbound.ClientboundPongResponsePacket;
import com.github.steveice10.mc.protocol.packet.status.clientbound.ClientboundStatusResponsePacket;
import com.github.steveice10.mc.protocol.packet.status.serverbound.ServerboundPingRequestPacket;
import com.github.steveice10.mc.protocol.packet.status.serverbound.ServerboundStatusRequestPacket;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.util.HashMap;
import java.util.Map;

public class MinecraftCodec {
    private static final Int2ObjectMap<LevelEvent> LEVEL_EVENTS = new Int2ObjectOpenHashMap<>();
    private static final Map<String, BuiltinSound> SOUND_NAMES = new HashMap<>();

    static {
        for (LevelEvent levelEvent : LevelEvent.values()) {
            LEVEL_EVENTS.put(levelEvent.getId(), levelEvent);
        }

        for (BuiltinSound sound : BuiltinSound.values()) {
            SOUND_NAMES.put(sound.getName(), sound);
        }
    }

    public static final PacketCodec CODEC = PacketCodec.builder()
            .protocolVersion(761)
            .helper(() -> new MinecraftCodecHelper(LEVEL_EVENTS, SOUND_NAMES))
            .minecraftVersion("1.19.3")
            .state(ProtocolState.HANDSHAKE, PacketStateCodec.builder()
                    .registerServerboundPacket(0x00, ClientIntentionPacket.class, ClientIntentionPacket::new)
            )
            .state(ProtocolState.LOGIN, PacketStateCodec.builder()
                    .registerClientboundPacket(0x00, ClientboundLoginDisconnectPacket.class, ClientboundLoginDisconnectPacket::new)
                    .registerClientboundPacket(0x01, ClientboundHelloPacket.class, ClientboundHelloPacket::new)
                    .registerClientboundPacket(0x02, ClientboundGameProfilePacket.class, ClientboundGameProfilePacket::new)
                    .registerClientboundPacket(0x03, ClientboundLoginCompressionPacket.class, ClientboundLoginCompressionPacket::new)
                    .registerClientboundPacket(0x04, ClientboundCustomQueryPacket.class, ClientboundCustomQueryPacket::new)
                    .registerServerboundPacket(0x00, ServerboundHelloPacket.class, ServerboundHelloPacket::new)
                    .registerServerboundPacket(0x01, ServerboundKeyPacket.class, ServerboundKeyPacket::new)
                    .registerServerboundPacket(0x02, ServerboundCustomQueryPacket.class, ServerboundCustomQueryPacket::new)
            ).state(ProtocolState.STATUS, PacketStateCodec.builder()
                    .registerClientboundPacket(0x00, ClientboundStatusResponsePacket.class, ClientboundStatusResponsePacket::new)
                    .registerClientboundPacket(0x01, ClientboundPongResponsePacket.class, ClientboundPongResponsePacket::new)
                    .registerServerboundPacket(0x00, ServerboundStatusRequestPacket.class, ServerboundStatusRequestPacket::new)
                    .registerServerboundPacket(0x01, ServerboundPingRequestPacket.class, ServerboundPingRequestPacket::new)
            ).state(ProtocolState.GAME, PacketStateCodec.builder()
                    .registerClientboundPacket(0x00, ClientboundAddEntityPacket.class, ClientboundAddEntityPacket::new)
                    .registerClientboundPacket(0x01, ClientboundAddExperienceOrbPacket.class, ClientboundAddExperienceOrbPacket::new)
                    .registerClientboundPacket(0x02, ClientboundAddPlayerPacket.class, ClientboundAddPlayerPacket::new)
                    .registerClientboundPacket(0x03, ClientboundAnimatePacket.class, ClientboundAnimatePacket::new)
                    .registerClientboundPacket(0x04, ClientboundAwardStatsPacket.class, ClientboundAwardStatsPacket::new)
                    .registerClientboundPacket(0x05, ClientboundBlockChangedAckPacket.class, ClientboundBlockChangedAckPacket::new)
                    .registerClientboundPacket(0x06, ClientboundBlockDestructionPacket.class, ClientboundBlockDestructionPacket::new)
                    .registerClientboundPacket(0x07, ClientboundBlockEntityDataPacket.class, ClientboundBlockEntityDataPacket::new)
                    .registerClientboundPacket(0x08, ClientboundBlockEventPacket.class, ClientboundBlockEventPacket::new)
                    .registerClientboundPacket(0x09, ClientboundBlockUpdatePacket.class, ClientboundBlockUpdatePacket::new)
                    .registerClientboundPacket(0x0A, ClientboundBossEventPacket.class, ClientboundBossEventPacket::new)
                    .registerClientboundPacket(0x0B, ClientboundChangeDifficultyPacket.class, ClientboundChangeDifficultyPacket::new)
                    .registerClientboundPacket(0x0C, ClientboundClearTitlesPacket.class, ClientboundClearTitlesPacket::new)
                    .registerClientboundPacket(0x0D, ClientboundCommandSuggestionsPacket.class, ClientboundCommandSuggestionsPacket::new)
                    .registerClientboundPacket(0x0E, ClientboundCommandsPacket.class, ClientboundCommandsPacket::new)
                    .registerClientboundPacket(0x0F, ClientboundContainerClosePacket.class, ClientboundContainerClosePacket::new)
                    .registerClientboundPacket(0x10, ClientboundContainerSetContentPacket.class, ClientboundContainerSetContentPacket::new)
                    .registerClientboundPacket(0x11, ClientboundContainerSetDataPacket.class, ClientboundContainerSetDataPacket::new)
                    .registerClientboundPacket(0x12, ClientboundContainerSetSlotPacket.class, ClientboundContainerSetSlotPacket::new)
                    .registerClientboundPacket(0x13, ClientboundCooldownPacket.class, ClientboundCooldownPacket::new)
                    .registerClientboundPacket(0x14, ClientboundCustomChatCompletionsPacket.class, ClientboundCustomChatCompletionsPacket::new)
                    .registerClientboundPacket(0x15, ClientboundCustomPayloadPacket.class, ClientboundCustomPayloadPacket::new)
                    .registerClientboundPacket(0x16, ClientboundDeleteChatPacket.class, ClientboundDeleteChatPacket::new)
                    .registerClientboundPacket(0x17, ClientboundDisconnectPacket.class, ClientboundDisconnectPacket::new)
                    .registerClientboundPacket(0x18, ClientboundDisguisedChatPacket.class, ClientboundDisguisedChatPacket::new)
                    .registerClientboundPacket(0x19, ClientboundEntityEventPacket.class, ClientboundEntityEventPacket::new)
                    .registerClientboundPacket(0x1A, ClientboundExplodePacket.class, ClientboundExplodePacket::new)
                    .registerClientboundPacket(0x1B, ClientboundForgetLevelChunkPacket.class, ClientboundForgetLevelChunkPacket::new)
                    .registerClientboundPacket(0x1C, ClientboundGameEventPacket.class, ClientboundGameEventPacket::new)
                    .registerClientboundPacket(0x1D, ClientboundHorseScreenOpenPacket.class, ClientboundHorseScreenOpenPacket::new)
                    .registerClientboundPacket(0x1E, ClientboundInitializeBorderPacket.class, ClientboundInitializeBorderPacket::new)
                    .registerClientboundPacket(0x1F, ClientboundKeepAlivePacket.class, ClientboundKeepAlivePacket::new)
                    .registerClientboundPacket(0x20, ClientboundLevelChunkWithLightPacket.class, ClientboundLevelChunkWithLightPacket::new)
                    .registerClientboundPacket(0x21, ClientboundLevelEventPacket.class, ClientboundLevelEventPacket::new)
                    .registerClientboundPacket(0x22, ClientboundLevelParticlesPacket.class, ClientboundLevelParticlesPacket::new)
                    .registerClientboundPacket(0x23, ClientboundLightUpdatePacket.class, ClientboundLightUpdatePacket::new)
                    .registerClientboundPacket(0x24, ClientboundLoginPacket.class, ClientboundLoginPacket::new)
                    .registerClientboundPacket(0x25, ClientboundMapItemDataPacket.class, ClientboundMapItemDataPacket::new)
                    .registerClientboundPacket(0x26, ClientboundMerchantOffersPacket.class, ClientboundMerchantOffersPacket::new)
                    .registerClientboundPacket(0x27, ClientboundMoveEntityPosPacket.class, ClientboundMoveEntityPosPacket::new)
                    .registerClientboundPacket(0x28, ClientboundMoveEntityPosRotPacket.class, ClientboundMoveEntityPosRotPacket::new)
                    .registerClientboundPacket(0x29, ClientboundMoveEntityRotPacket.class, ClientboundMoveEntityRotPacket::new)
                    .registerClientboundPacket(0x2A, ClientboundMoveVehiclePacket.class, ClientboundMoveVehiclePacket::new)
                    .registerClientboundPacket(0x2B, ClientboundOpenBookPacket.class, ClientboundOpenBookPacket::new)
                    .registerClientboundPacket(0x2C, ClientboundOpenScreenPacket.class, ClientboundOpenScreenPacket::new)
                    .registerClientboundPacket(0x2D, ClientboundOpenSignEditorPacket.class, ClientboundOpenSignEditorPacket::new)
                    .registerClientboundPacket(0x2E, ClientboundPingPacket.class, ClientboundPingPacket::new)
                    .registerClientboundPacket(0x2F, ClientboundPlaceGhostRecipePacket.class, ClientboundPlaceGhostRecipePacket::new)
                    .registerClientboundPacket(0x30, ClientboundPlayerAbilitiesPacket.class, ClientboundPlayerAbilitiesPacket::new)
                    .registerClientboundPacket(0x31, ClientboundPlayerChatPacket.class, ClientboundPlayerChatPacket::new)
                    .registerClientboundPacket(0x32, ClientboundPlayerCombatEndPacket.class, ClientboundPlayerCombatEndPacket::new)
                    .registerClientboundPacket(0x33, ClientboundPlayerCombatEnterPacket.class, ClientboundPlayerCombatEnterPacket::new)
                    .registerClientboundPacket(0x34, ClientboundPlayerCombatKillPacket.class, ClientboundPlayerCombatKillPacket::new)
                    .registerClientboundPacket(0x35, ClientboundPlayerInfoRemovePacket.class, ClientboundPlayerInfoRemovePacket::new)
                    .registerClientboundPacket(0x36, ClientboundPlayerInfoUpdatePacket.class, ClientboundPlayerInfoUpdatePacket::new)
                    .registerClientboundPacket(0x37, ClientboundPlayerLookAtPacket.class, ClientboundPlayerLookAtPacket::new)
                    .registerClientboundPacket(0x38, ClientboundPlayerPositionPacket.class, ClientboundPlayerPositionPacket::new)
                    .registerClientboundPacket(0x39, ClientboundRecipePacket.class, ClientboundRecipePacket::new)
                    .registerClientboundPacket(0x3A, ClientboundRemoveEntitiesPacket.class, ClientboundRemoveEntitiesPacket::new)
                    .registerClientboundPacket(0x3B, ClientboundRemoveMobEffectPacket.class, ClientboundRemoveMobEffectPacket::new)
                    .registerClientboundPacket(0x3C, ClientboundResourcePackPacket.class, ClientboundResourcePackPacket::new)
                    .registerClientboundPacket(0x3D, ClientboundRespawnPacket.class, ClientboundRespawnPacket::new)
                    .registerClientboundPacket(0x3E, ClientboundRotateHeadPacket.class, ClientboundRotateHeadPacket::new)
                    .registerClientboundPacket(0x3F, ClientboundSectionBlocksUpdatePacket.class, ClientboundSectionBlocksUpdatePacket::new)
                    .registerClientboundPacket(0x40, ClientboundSelectAdvancementsTabPacket.class, ClientboundSelectAdvancementsTabPacket::new)
                    .registerClientboundPacket(0x41, ClientboundServerDataPacket.class, ClientboundServerDataPacket::new)
                    .registerClientboundPacket(0x42, ClientboundSetActionBarTextPacket.class, ClientboundSetActionBarTextPacket::new)
                    .registerClientboundPacket(0x43, ClientboundSetBorderCenterPacket.class, ClientboundSetBorderCenterPacket::new)
                    .registerClientboundPacket(0x44, ClientboundSetBorderLerpSizePacket.class, ClientboundSetBorderLerpSizePacket::new)
                    .registerClientboundPacket(0x45, ClientboundSetBorderSizePacket.class, ClientboundSetBorderSizePacket::new)
                    .registerClientboundPacket(0x46, ClientboundSetBorderWarningDelayPacket.class, ClientboundSetBorderWarningDelayPacket::new)
                    .registerClientboundPacket(0x47, ClientboundSetBorderWarningDistancePacket.class, ClientboundSetBorderWarningDistancePacket::new)
                    .registerClientboundPacket(0x48, ClientboundSetCameraPacket.class, ClientboundSetCameraPacket::new)
                    .registerClientboundPacket(0x49, ClientboundSetCarriedItemPacket.class, ClientboundSetCarriedItemPacket::new)
                    .registerClientboundPacket(0x4A, ClientboundSetChunkCacheCenterPacket.class, ClientboundSetChunkCacheCenterPacket::new)
                    .registerClientboundPacket(0x4B, ClientboundSetChunkCacheRadiusPacket.class, ClientboundSetChunkCacheRadiusPacket::new)
                    .registerClientboundPacket(0x4C, ClientboundSetDefaultSpawnPositionPacket.class, ClientboundSetDefaultSpawnPositionPacket::new)
                    .registerClientboundPacket(0x4D, ClientboundSetDisplayObjectivePacket.class, ClientboundSetDisplayObjectivePacket::new)
                    .registerClientboundPacket(0x4E, ClientboundSetEntityDataPacket.class, ClientboundSetEntityDataPacket::new)
                    .registerClientboundPacket(0x4F, ClientboundSetEntityLinkPacket.class, ClientboundSetEntityLinkPacket::new)
                    .registerClientboundPacket(0x50, ClientboundSetEntityMotionPacket.class, ClientboundSetEntityMotionPacket::new)
                    .registerClientboundPacket(0x51, ClientboundSetEquipmentPacket.class, ClientboundSetEquipmentPacket::new)
                    .registerClientboundPacket(0x52, ClientboundSetExperiencePacket.class, ClientboundSetExperiencePacket::new)
                    .registerClientboundPacket(0x53, ClientboundSetHealthPacket.class, ClientboundSetHealthPacket::new)
                    .registerClientboundPacket(0x54, ClientboundSetObjectivePacket.class, ClientboundSetObjectivePacket::new)
                    .registerClientboundPacket(0x55, ClientboundSetPassengersPacket.class, ClientboundSetPassengersPacket::new)
                    .registerClientboundPacket(0x56, ClientboundSetPlayerTeamPacket.class, ClientboundSetPlayerTeamPacket::new)
                    .registerClientboundPacket(0x57, ClientboundSetScorePacket.class, ClientboundSetScorePacket::new)
                    .registerClientboundPacket(0x58, ClientboundSetSimulationDistancePacket.class, ClientboundSetSimulationDistancePacket::new)
                    .registerClientboundPacket(0x59, ClientboundSetSubtitleTextPacket.class, ClientboundSetSubtitleTextPacket::new)
                    .registerClientboundPacket(0x5A, ClientboundSetTimePacket.class, ClientboundSetTimePacket::new)
                    .registerClientboundPacket(0x5B, ClientboundSetTitleTextPacket.class, ClientboundSetTitleTextPacket::new)
                    .registerClientboundPacket(0x5C, ClientboundSetTitlesAnimationPacket.class, ClientboundSetTitlesAnimationPacket::new)
                    .registerClientboundPacket(0x5D, ClientboundSoundEntityPacket.class, ClientboundSoundEntityPacket::new)
                    .registerClientboundPacket(0x5E, ClientboundSoundPacket.class, ClientboundSoundPacket::new)
                    .registerClientboundPacket(0x5F, ClientboundStopSoundPacket.class, ClientboundStopSoundPacket::new)
                    .registerClientboundPacket(0x60, ClientboundSystemChatPacket.class, ClientboundSystemChatPacket::new)
                    .registerClientboundPacket(0x61, ClientboundTabListPacket.class, ClientboundTabListPacket::new)
                    .registerClientboundPacket(0x62, ClientboundTagQueryPacket.class, ClientboundTagQueryPacket::new)
                    .registerClientboundPacket(0x63, ClientboundTakeItemEntityPacket.class, ClientboundTakeItemEntityPacket::new)
                    .registerClientboundPacket(0x64, ClientboundTeleportEntityPacket.class, ClientboundTeleportEntityPacket::new)
                    .registerClientboundPacket(0x65, ClientboundUpdateAdvancementsPacket.class, ClientboundUpdateAdvancementsPacket::new)
                    .registerClientboundPacket(0x66, ClientboundUpdateAttributesPacket.class, ClientboundUpdateAttributesPacket::new)
                    .registerClientboundPacket(0x67, ClientboundUpdateEnabledFeaturesPacket.class, ClientboundUpdateEnabledFeaturesPacket::new)
                    .registerClientboundPacket(0x68, ClientboundUpdateMobEffectPacket.class, ClientboundUpdateMobEffectPacket::new)
                    .registerClientboundPacket(0x69, ClientboundUpdateRecipesPacket.class, ClientboundUpdateRecipesPacket::new)
                    .registerClientboundPacket(0x6A, ClientboundUpdateTagsPacket.class, ClientboundUpdateTagsPacket::new)
                    .registerServerboundPacket(0x00, ServerboundAcceptTeleportationPacket.class, ServerboundAcceptTeleportationPacket::new)
                    .registerServerboundPacket(0x01, ServerboundBlockEntityTagQuery.class, ServerboundBlockEntityTagQuery::new)
                    .registerServerboundPacket(0x02, ServerboundChangeDifficultyPacket.class, ServerboundChangeDifficultyPacket::new)
                    .registerServerboundPacket(0x03, ServerboundChatAckPacket.class, ServerboundChatAckPacket::new)
                    .registerServerboundPacket(0x04, ServerboundChatCommandPacket.class, ServerboundChatCommandPacket::new)
                    .registerServerboundPacket(0x05, ServerboundChatPacket.class, ServerboundChatPacket::new)
                    .registerServerboundPacket(0x06, ServerboundClientCommandPacket.class, ServerboundClientCommandPacket::new)
                    .registerServerboundPacket(0x07, ServerboundClientInformationPacket.class, ServerboundClientInformationPacket::new)
                    .registerServerboundPacket(0x08, ServerboundCommandSuggestionPacket.class, ServerboundCommandSuggestionPacket::new)
                    .registerServerboundPacket(0x09, ServerboundContainerButtonClickPacket.class, ServerboundContainerButtonClickPacket::new)
                    .registerServerboundPacket(0x0A, ServerboundContainerClickPacket.class, ServerboundContainerClickPacket::new)
                    .registerServerboundPacket(0x0B, ServerboundContainerClosePacket.class, ServerboundContainerClosePacket::new)
                    .registerServerboundPacket(0x0C, ServerboundCustomPayloadPacket.class, ServerboundCustomPayloadPacket::new)
                    .registerServerboundPacket(0x0D, ServerboundEditBookPacket.class, ServerboundEditBookPacket::new)
                    .registerServerboundPacket(0x0E, ServerboundEntityTagQuery.class, ServerboundEntityTagQuery::new)
                    .registerServerboundPacket(0x0F, ServerboundInteractPacket.class, ServerboundInteractPacket::new)
                    .registerServerboundPacket(0x10, ServerboundJigsawGeneratePacket.class, ServerboundJigsawGeneratePacket::new)
                    .registerServerboundPacket(0x11, ServerboundKeepAlivePacket.class, ServerboundKeepAlivePacket::new)
                    .registerServerboundPacket(0x12, ServerboundLockDifficultyPacket.class, ServerboundLockDifficultyPacket::new)
                    .registerServerboundPacket(0x13, ServerboundMovePlayerPosPacket.class, ServerboundMovePlayerPosPacket::new)
                    .registerServerboundPacket(0x14, ServerboundMovePlayerPosRotPacket.class, ServerboundMovePlayerPosRotPacket::new)
                    .registerServerboundPacket(0x15, ServerboundMovePlayerRotPacket.class, ServerboundMovePlayerRotPacket::new)
                    .registerServerboundPacket(0x16, ServerboundMovePlayerStatusOnlyPacket.class, ServerboundMovePlayerStatusOnlyPacket::new)
                    .registerServerboundPacket(0x17, ServerboundMoveVehiclePacket.class, ServerboundMoveVehiclePacket::new)
                    .registerServerboundPacket(0x18, ServerboundPaddleBoatPacket.class, ServerboundPaddleBoatPacket::new)
                    .registerServerboundPacket(0x19, ServerboundPickItemPacket.class, ServerboundPickItemPacket::new)
                    .registerServerboundPacket(0x1A, ServerboundPlaceRecipePacket.class, ServerboundPlaceRecipePacket::new)
                    .registerServerboundPacket(0x1B, ServerboundPlayerAbilitiesPacket.class, ServerboundPlayerAbilitiesPacket::new)
                    .registerServerboundPacket(0x1C, ServerboundPlayerActionPacket.class, ServerboundPlayerActionPacket::new)
                    .registerServerboundPacket(0x1D, ServerboundPlayerCommandPacket.class, ServerboundPlayerCommandPacket::new)
                    .registerServerboundPacket(0x1E, ServerboundPlayerInputPacket.class, ServerboundPlayerInputPacket::new)
                    .registerServerboundPacket(0x1F, ServerboundPongPacket.class, ServerboundPongPacket::new)
                    .registerServerboundPacket(0x20, ServerboundChatSessionUpdatePacket.class, ServerboundChatSessionUpdatePacket::new)
                    .registerServerboundPacket(0x21, ServerboundRecipeBookChangeSettingsPacket.class, ServerboundRecipeBookChangeSettingsPacket::new)
                    .registerServerboundPacket(0x22, ServerboundRecipeBookSeenRecipePacket.class, ServerboundRecipeBookSeenRecipePacket::new)
                    .registerServerboundPacket(0x23, ServerboundRenameItemPacket.class, ServerboundRenameItemPacket::new)
                    .registerServerboundPacket(0x24, ServerboundResourcePackPacket.class, ServerboundResourcePackPacket::new)
                    .registerServerboundPacket(0x25, ServerboundSeenAdvancementsPacket.class, ServerboundSeenAdvancementsPacket::new)
                    .registerServerboundPacket(0x26, ServerboundSelectTradePacket.class, ServerboundSelectTradePacket::new)
                    .registerServerboundPacket(0x27, ServerboundSetBeaconPacket.class, ServerboundSetBeaconPacket::new)
                    .registerServerboundPacket(0x28, ServerboundSetCarriedItemPacket.class, ServerboundSetCarriedItemPacket::new)
                    .registerServerboundPacket(0x29, ServerboundSetCommandBlockPacket.class, ServerboundSetCommandBlockPacket::new)
                    .registerServerboundPacket(0x2A, ServerboundSetCommandMinecartPacket.class, ServerboundSetCommandMinecartPacket::new)
                    .registerServerboundPacket(0x2B, ServerboundSetCreativeModeSlotPacket.class, ServerboundSetCreativeModeSlotPacket::new)
                    .registerServerboundPacket(0x2C, ServerboundSetJigsawBlockPacket.class, ServerboundSetJigsawBlockPacket::new)
                    .registerServerboundPacket(0x2D, ServerboundSetStructureBlockPacket.class, ServerboundSetStructureBlockPacket::new)
                    .registerServerboundPacket(0x2E, ServerboundSignUpdatePacket.class, ServerboundSignUpdatePacket::new)
                    .registerServerboundPacket(0x2F, ServerboundSwingPacket.class, ServerboundSwingPacket::new)
                    .registerServerboundPacket(0x30, ServerboundTeleportToEntityPacket.class, ServerboundTeleportToEntityPacket::new)
                    .registerServerboundPacket(0x31, ServerboundUseItemOnPacket.class, ServerboundUseItemOnPacket::new)
                    .registerServerboundPacket(0x32, ServerboundUseItemPacket.class, ServerboundUseItemPacket::new)
            )
            .build();
}
