package mshower.insurance.utils.items;

import mshower.insurance.AllTags;
import net.minecraft.block.BlockState;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class HamdraxItem extends AxeItem {
    public HamdraxItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return state.isIn(AllTags.HAMDRAX_MINEABLE) ? this.miningSpeed : 1.0F;
    }
    @Override
    public boolean isSuitableFor(BlockState state) {
        return state.isIn(AllTags.HAMDRAX_MINEABLE);
    }
}
