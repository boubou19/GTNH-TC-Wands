package com.gtnewhorizons.tcwands.api.wandinfo;

import com.gtnewhorizons.tcwands.api.GTTier;
import gregtech.api.enums.Materials;
import net.minecraft.item.ItemStack;

public class WandDetails {
    private String name;
    private Materials material;
    private GTTier tier;
    private ItemStack conductor;
    private static Materials[] tieredMaterials;

    static {
        tieredMaterials = new Materials[GTTier.values().length];
        tieredMaterials[0] = GTTier.values()[1].getGregTier().getMaterial();
        tieredMaterials[1] = Materials.StainlessSteel;
        tieredMaterials[2] = Materials.EnergeticAlloy;
        tieredMaterials[3] = Materials.VibrantAlloy;
        tieredMaterials[4] = Materials.TungstenSteel;
        tieredMaterials[5] = Materials.Enderium;
        tieredMaterials[6] = Materials.Oriharukon;
        tieredMaterials[7] = Materials.Osmiridium;

        //fallback for any potential new tier in the GTTier enum
        for (int i=8; i<GTTier.values().length; i++){
            tieredMaterials[i] = GTTier.values()[i].getGregTier().getMaterial();
        }
    }

    public WandDetails(String name, GTTier tier, ItemStack conductor) {
        this.name = name;
        this.tier = tier;
        this.material = tieredMaterials[tier.getIndex()];
        this.conductor = conductor;
    }

    public ItemStack getConductor() {
        return conductor;
    }

    public String getName() {
        return name;
    }

    public Materials getMaterial() {
        return material;
    }

    public GTTier getTier() {
        return tier;
    }

    public String getScrew() {
        return "screw" + material.mName;//FIXME check
    }
}
