package dev.metaconscious.mcmod.hellofabric.armor;

import dev.metaconscious.mcmod.hellofabric.items.RegisterItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class MyAwesomeArmorMaterial implements ArmorMaterial {

    public static final MyAwesomeArmorMaterial INSTANCE = new MyAwesomeArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[]{14, 16, 17, 12};
    private static final int[] PROTECTION_VALUES = new int[]{3, 6, 8, 3};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 37;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RegisterItems.MY_AWESOME_ITEM);
    }

    @Override
    public String getName() {
        return "my_awesome";
    }

    @Override
    public float getToughness() {
        return 4.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.8f;
    }
}
