package dev.metaconscious.mcmod.hellofabric;

import dev.metaconscious.mcmod.hellofabric.items.RegisterItems;
import net.fabricmc.api.ModInitializer;

public class HelloFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        RegisterItems.register();
    }
}
