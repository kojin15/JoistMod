package kojin15.joistmod.item;

import kojin15.joistmod.JoistMod;
import kojin15.joistmod.JoistModRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by kojin15.
 */
public class ItemSaw extends ItemAxe {

    public ItemSaw(ToolMaterial toolMaterial, String name, String texturename) {
        super(toolMaterial);
        this.setCreativeTab(JoistModRegister.tabJoist);
        this.setUnlocalizedName(name);
        this.setTextureName(JoistMod.ModID + ":" + texturename);

    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int meta, float i, float j, float k) {
        if (world.getBlock(x, y, z) == JoistModRegister.VanilaWoodJoist){
            int blockmeta = world.getBlockMetadata(x, y, z);
            if (blockmeta < 6){
                world.setBlockMetadataWithNotify(x, y, z, blockmeta + 6, 2);
            }
            if (blockmeta >= 6){
                world.setBlockMetadataWithNotify(x, y, z, blockmeta - 6, 2);
            }
        }
        return super.onItemUse(itemStack, player, world, x, y, z, meta, i, j, k);
    }
}
