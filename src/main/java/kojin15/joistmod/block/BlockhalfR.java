package kojin15.joistmod.block;


import kojin15.joistmod.JoistMod;
import kojin15.joistmod.JoistModRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by kojin15.
 */
public class BlockhalfR extends Block {

    public BlockhalfR(Material p_i45394_1_) {
        super(p_i45394_1_);
        this.setBlockTextureName("stone");
        this.setCreativeTab(JoistModRegister.tabJoist);
        this.setBlockName("Stone 1/2R");

    }

    @Override
    public int getRenderType(){
        return JoistMod.halfRRenderID;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() { return false; }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int x, int y, int z) {
        int meta = iBlockAccess.getBlockMetadata(x, y, z);
        switch (meta){
            case 0:
                this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 1:
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
                break;
            case 2:
                this.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
                break;
            case 3:
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
                break;
            case 4:
                this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 5:
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
        }

    }


    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
        switch (side){
            case 0:
                if (hitX >= 0.25F && hitX <= 0.75F && hitZ >= 0.25F && hitZ <= 0.75F){
                    return 0;
                }
                else if (hitZ > 0.75F){
                    return 2;
                }
                else if (hitZ < 0.25F){
                    return 3;
                }
                else if (hitX > 0.75F){
                    return 4;
                }
                else if (hitX < 0.25F){
                    return 5;
                }
            case 1:
                if (hitX >= 0.25F && hitX <= 0.75F && hitZ >= 0.25F && hitZ <= 0.75F){
                    return 1;
                }
                else if (hitZ > 0.75F){
                    return 2;
                }
                else if (hitZ < 0.25F){
                    return 3;
                }
                else if (hitX > 0.75F){
                    return 4;
                }
                else if (hitX < 0.25F){
                    return 5;
                }
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
        }
        return -1;
    }
}
