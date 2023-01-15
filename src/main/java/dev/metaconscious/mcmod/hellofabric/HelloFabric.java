package dev.metaconscious.mcmod.hellofabric;

import dev.metaconscious.mcmod.hellofabric.items.MyAwesomeItem;
import dev.metaconscious.mcmod.hellofabric.items.MyItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HelloFabric implements ModInitializer {


    public static final Item MY_ITEM = new MyItem(new FabricItemSettings().maxCount(16));
    public static final Item MY_AWESOME_ITEM = new MyAwesomeItem(new FabricItemSettings());
    private static final ItemGroup ITEM_GROUP = FabricItemGroup
            .builder(new Identifier("hello-fabric", "test_group"))
            .icon(() -> new ItemStack(MY_ITEM))
            .build();

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_item"), MY_ITEM);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_item"), MY_AWESOME_ITEM);
        FuelRegistry.INSTANCE.add(MY_AWESOME_ITEM, 300);
        CompostingChanceRegistry.INSTANCE.add(MY_ITEM, 0.1f);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.add(MY_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> content.add(MY_AWESOME_ITEM));
    }
}
