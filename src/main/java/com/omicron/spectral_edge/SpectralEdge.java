package com.omicron.spectral_edge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class SpectralEdge extends EnchantmentDamage {

    protected static final UUID ATTACK_DAMAGE_MODIFIER = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");

    private static final int[] MIN_COST = new int[] {1, 5, 5};
    private static final int[] LEVEL_COST = new int[] {11, 8, 8};
    private static final int[] LEVEL_COST_SPAN = new int[] {20, 20, 20};
    public final int damageType = 2;
    private static final EntityEquipmentSlot[] slots = new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND};
    protected SpectralEdge() {
        super(Rarity.COMMON, 5, slots);
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel)
    {
        return MIN_COST[this.damageType] + (enchantmentLevel - 1) * LEVEL_COST[this.damageType];
    }

    public int getMaxEnchantability(int enchantmentLevel)
    {
        return this.getMinEnchantability(enchantmentLevel) + LEVEL_COST_SPAN[this.damageType];
    }

    public int getMaxLevel()
    {
        return 5;
    }

    /*
    public float calcDamageByCreature(int level, EnumCreatureAttribute creatureType)
    {
        EntityPlayerSP user = Minecraft.getMinecraft().player;
        AtomicReference<Float> damage = new AtomicReference<>((float) 0);
            user.getHeldItemMainhand().getAttributeModifiers(EntityEquipmentSlot.MAINHAND).forEach((string, attribute) -> {
                if(attribute.getID().equals(ATTACK_DAMAGE_MODIFIER))
                {
                    float essa =((float) (attribute.getAmount() + 1));
                    System.out.println(user.getHeldItemMainhand() + " " + essa);
                    damage.set((essa / 100) * Config.spectralEdgePercentileDamageModifier * level);
                }
            });
            //entitylivingbase.setHealth();

        return damage.get();
    }
    zzzzzzzzzzzzzzzzzzzzz
     */

    public String getName()
    {
        return "enchantment.damage." + "spectral";
    }

    public boolean canApplyTogether(Enchantment ench)
    {
        return !(ench instanceof EnchantmentDamage);
    }

    public boolean canApply(ItemStack stack)
    {
        return stack.getItem() instanceof ItemAxe ? true : super.canApply(stack);
    }


    public void onEntityDamaged(EntityLivingBase user, Entity target, int level)
    {
        if (target instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)target;

            user.getHeldItemMainhand().getAttributeModifiers(EntityEquipmentSlot.MAINHAND).forEach((string, attribute) -> {
                if(attribute.getID().equals(ATTACK_DAMAGE_MODIFIER))
                {
                    double damage = 1 + attribute.getAmount();
                    entitylivingbase.hurtResistantTime = 0;
                    entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(user), (float) ((damage / 100) * Config.spectralEdgePercentileDamageModifier * level));
                }
            });
            //entitylivingbase.setHealth();
        }
    }



}
