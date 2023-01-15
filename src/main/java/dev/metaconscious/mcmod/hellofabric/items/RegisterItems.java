package dev.metaconscious.mcmod.hellofabric.items;

import dev.metaconscious.mcmod.hellofabric.armor.MyAwesomeArmorMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterItems {

    public static final Item MY_ITEM = new MyItem(new FabricItemSettings().maxCount(16));
    public static final Item MY_AWESOME_ITEM = new MyAwesomeItem(new FabricItemSettings());
    public static final ItemGroup ITEM_GROUP = FabricItemGroup
            .builder(new Identifier("hello-fabric", "test_group"))
            .icon(() -> new ItemStack(MY_AWESOME_ITEM))
            .build();

    public static final ArmorMaterial MY_AWESOME_ARMOR_MATERIAL = new MyAwesomeArmorMaterial();
    public static final Item MY_AWESOME_HELMET = new ArmorItem(MY_AWESOME_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings());
    public static final Item MY_AWESOME_CHESTPLATE = new ArmorItem(MY_AWESOME_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings());
    public static final Item MY_AWESOME_LEGGINGS = new ArmorItem(MY_AWESOME_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings());
    public static final Item MY_AWESOME_BOOTS = new ArmorItem(MY_AWESOME_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings());

    public static void register() {
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_item"), MY_ITEM);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_item"), MY_AWESOME_ITEM);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_helmet"), MY_AWESOME_HELMET);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_chestplate"), MY_AWESOME_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_leggings"), MY_AWESOME_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_boots"), MY_AWESOME_BOOTS);

        FuelRegistry.INSTANCE.add(MY_AWESOME_ITEM, 300);
        CompostingChanceRegistry.INSTANCE.add(MY_ITEM, 0.1f);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.add(MY_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(MY_AWESOME_ITEM);
            content.addAfter(MY_AWESOME_ITEM,
                    MY_AWESOME_HELMET,
                    MY_AWESOME_CHESTPLATE,
                    MY_AWESOME_LEGGINGS,
                    MY_AWESOME_BOOTS);
        });
    }

}
