package tfar.tagtooltip;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Set;

@Mod("tagtooltip")
@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class TagTooltip {
  @SubscribeEvent
  public static void onTooltip(ItemTooltipEvent e) {
    if (!Screen.hasControlDown()) return;
    List<ITextComponent> tooltips = e.getToolTip();
    Set<ResourceLocation> tags = e.getItemStack().getItem().getTags();
    if (!tags.isEmpty()) {
      tooltips.add(new StringTextComponent("Item Tags:"));
      tags.stream().map(tag -> new StringTextComponent("#"+tag.toString()).applyTextStyle(TextFormatting.DARK_GRAY)).forEach(tooltips::add);
    }
  }
}