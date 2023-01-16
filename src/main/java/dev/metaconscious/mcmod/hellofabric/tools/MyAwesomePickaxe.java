package dev.metaconscious.mcmod.hellofabric.tools;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class MyAwesomePickaxe extends PickaxeItem {
    public MyAwesomePickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
