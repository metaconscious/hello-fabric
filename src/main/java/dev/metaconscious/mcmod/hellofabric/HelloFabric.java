package dev.metaconscious.mcmod.hellofabric;

import dev.metaconscious.mcmod.hellofabric.items.MyAwesomeItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HelloFabric implements ModInitializer {

    public static final Item MY_ITEM = new Item(new FabricItemSettings().maxCount(16));
    public static final Item MY_AWESOME_ITEM = new MyAwesomeItem(new FabricItemSettings());

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_item"), MY_ITEM);
        Registry.register(Registries.ITEM, new Identifier("hello-fabric", "my_awesome_item"), MY_AWESOME_ITEM);
    }
}
