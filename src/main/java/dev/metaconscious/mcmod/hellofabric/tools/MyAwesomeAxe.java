package dev.metaconscious.mcmod.hellofabric.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class MyAwesomeAxe extends AxeItem {
    public MyAwesomeAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
