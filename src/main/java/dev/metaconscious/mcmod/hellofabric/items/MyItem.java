package dev.metaconscious.mcmod.hellofabric.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyItem extends Item {
    public MyItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.hello-fabric.my_item.tooltip_1"));
        tooltip.add(Text.translatable("item.hello-fabric.my_item.tooltip_2").formatted(Formatting.RED));
    }
}
