package com.omicron.spectral_edge;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = SpectralEdgeMod.MODID, version = SpectralEdgeMod.VERSION)
public class SpectralEdgeMod
{
    public static final String MODID = "spectral_edge";
    public static final String VERSION = "1.0";

    public static Configuration config;

    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // some example code
        //System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
        ModEnchantments.init();
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "spectral_edge.cfg"));
        Config.readConfig();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        //System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // some example code
        //System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
        if (config.hasChanged()) {
            config.save();
        }
    }


}
