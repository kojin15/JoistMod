package kojin15.joistmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kojin15.joistmod.JoistMod;
import kojin15.joistmod.JoistModRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;


public class JoistBlock extends Block {

    private IIcon[] icons;

    public JoistBlock(Material p_i45394_1_, int maxMeta) {
        super(p_i45394_1_);
        icons = new IIcon[maxMeta * 2];
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setBlockName("VanilaWoodJoist");
        this.setCreativeTab(JoistModRegister.tabJoist);
        textureName = "joistmod" + ":" + "planks";
        //this.setBlockTextureName(textureName);
        this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);

    }
    @Override
    public int getRenderType(){
        return JoistMod.JoistRenderID;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock() { return false; }

    @Override
    public int damageDropped(int damage) {
        int meta;
        if(damage >= 6){
            meta = damage - 6;
        }
        else {
            meta = damage;
        }
        return meta;
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        for (int i = 0; i < icons.length / 2; i++) {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        for (int i = 0; i < icons.length / 2; i++){
            icons[i] = p_149651_1_.registerIcon(this.getTextureName()+"_"+i);
        }
        for (int i = 0; i < icons.length / 2; i++){
            icons[i + 6] = p_149651_1_.registerIcon(this.getTextureName()+"_"+i);
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return icons[p_149691_2_];
    }


}