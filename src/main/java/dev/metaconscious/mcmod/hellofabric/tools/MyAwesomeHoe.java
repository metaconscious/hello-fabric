package dev.metaconscious.mcmod.hellofabric.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class MyAwesomeHoe extends HoeItem {
    public MyAwesomeHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
