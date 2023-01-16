package dev.metaconscious.mcmod.hellofabric.items;

import dev.metaconscious.mcmod.hellofabric.armor.MyAwesomeArmorMaterial;
import dev.metaconscious.mcmod.hellofabric.tools.MyAwesomeAxe;
import dev.metaconscious.mcmod.hellofabric.tools.MyAwesomeHoe;
import dev.metaconscious.mcmod.hellofabric.tools.MyAwesomePickaxe;
import dev.metaconscious.mcmod.hellofabric.tools.MyAwesomeToolMaterial;
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
    public static final Item MY_AWESOME_HELMET = new ArmorItem(MyAwesomeArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings());
    public static final Item MY_AWESOME_CHESTPLATE = new ArmorItem(MyAwesomeArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings());
    public static final Item MY_AWESOME_LEGGINGS = new ArmorItem(MyAwesomeArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings());
    public static final Item MY_AWESOME_BOOTS = new ArmorItem(MyAwesomeArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings());

    public static final Item MY_AWESOME_SHOVEL = new ShovelItem(MyAwesomeToolMaterial.INSTANCE, 1.5f, -3.0f, new Item.Settings());
    public static final Item MY_AWESOME_SWORD = new SwordItem(MyAwesomeToolMaterial.INSTANCE, 3, -2.4f, new Item.Settings());

    public static final Item MY_AWESOME_PICKAXE = new MyAwesomePickaxe(MyAwesomeToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings());
    public static final Item MY_AWESOME_HOE = new MyAwesomeHoe(MyAwesomeToolMaterial.INSTANCE, 7, -3.2f, new Item.Settings());
    public static final Item MY_AWESOME_AXE = new MyAwesomeAxe(MyAwesomeToolMaterial.INSTANCE, 7.0f, -3.2f, new Item.Settings());

    public static void register() {
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_item"), MY_ITEM);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_item"), MY_AWESOME_ITEM);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_helmet"), MY_AWESOME_HELMET);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_chestplate"), MY_AWESOME_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_leggings"), MY_AWESOME_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_boots"), MY_AWESOME_BOOTS);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_shovel"), MY_AWESOME_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_sword"), MY_AWESOME_SWORD);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_pickaxe"), MY_AWESOME_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_hoe"), MY_AWESOME_HOE);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_axe"), MY_AWESOME_AXE);

        FuelRegistry.INSTANCE.add(MY_AWESOME_ITEM, 300);
        CompostingChanceRegistry.INSTANCE.add(MY_ITEM, 0.1f);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.add(MY_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(MY_AWESOME_ITEM);
            content.addAfter(MY_AWESOME_ITEM,
                    MY_AWESOME_HELMET,
                    MY_AWESOME_CHESTPLATE,
                    MY_AWESOME_LEGGINGS,
                    MY_AWESOME_BOOTS,
                    MY_AWESOME_AXE,
                    MY_AWESOME_HOE,
                    MY_AWESOME_PICKAXE,
                    MY_AWESOME_SHOVEL,
                    MY_AWESOME_SWORD);
        });
    }

}
