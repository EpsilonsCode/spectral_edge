package com.omicron.spectral_edge;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
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
        //System.out.println("enchantment_test");
    }

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event)
    {
        //System.out.println(event.isCancelable());

    }
}
