package dev.metaconscious.mcmod.hellofabric.tools;

import dev.metaconscious.mcmod.hellofabric.items.RegisterItems;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;

public class MyAwesomeToolMaterial implements ToolMaterial {

    public static final MyAwesomeToolMaterial INSTANCE = new MyAwesomeToolMaterial();

    @Override
    public int getDurability() {
        return ToolMaterials.NETHERITE.getDurability() + 100;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return ToolMaterials.NETHERITE.getMiningSpeedMultiplier() + 0.5f;
    }

    @Override
    public float getAttackDamage() {
        return ToolMaterials.NETHERITE.getAttackDamage() + 2.0f;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevels.NETHERITE;
    }

    @Override
    public int getEnchantability() {
        return ToolMaterials.NETHERITE.getEnchantability();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RegisterItems.MY_AWESOME_ITEM);
    }
}
