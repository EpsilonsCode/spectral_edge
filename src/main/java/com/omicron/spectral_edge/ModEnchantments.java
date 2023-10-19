package com.omicron.spectral_edge;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = SpectralEdgeMod.MODID)
public class ModEnchantments {
    public static Enchantment SPECTRAL_EDGE;

    public static void init()
    {
        SPECTRAL_EDGE = new SpectralEdge();
        SPECTRAL_EDGE.setName("spectral_edge");
        SPECTRAL_EDGE.setRegistryName(SpectralEdgeMod.MODID, "spectral_edge");
    }

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event)
    {
        event.getRegistry().register(SPECTRAL_EDGE);
    }
}
