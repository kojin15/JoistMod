package kojin15.joistmod;


import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import kojin15.joistmod.block.JoistBlock;
import kojin15.joistmod.item.MetaItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class JoistModRegister {

    public static final CreativeTabs tabJoist = new CreativeTabs("joistmod") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(VanilaWoodJoist);
        }
    };

    public static final Block VanilaWoodJoist = new JoistBlock(Material.wood, 6);

    static void RegisterPreinit(FMLPreInitializationEvent event){

        GameRegistry.registerBlock(VanilaWoodJoist, MetaItemBlock.class ,"VanilaWoodJoist");

        GameRegistry.addRecipe(new ItemStack(JoistModRegister.VanilaWoodJoist,8,0),"A A","ABA","A A",
                'A',new ItemStack(Blocks.planks,1,0),'B',new ItemStack(Blocks.log,1,0));
        GameRegistry.addRecipe(new ItemStack(JoistModRegister.VanilaWoodJoist,8,1),"A A","ABA","A A",
                'A',new ItemStack(Blocks.planks,1,1),'B',new ItemStack(Blocks.log,1,1));
        GameRegistry.addRecipe(new ItemStack(JoistModRegister.VanilaWoodJoist,8,2),"A A","ABA","A A",
                'A',new ItemStack(Blocks.planks,1,2),'B',new ItemStack(Blocks.log,1,2));
        GameRegistry.addRecipe(new ItemStack(JoistModRegister.VanilaWoodJoist,8,3),"A A","ABA","A A",
                'A',new ItemStack(Blocks.planks,1,3),'B',new ItemStack(Blocks.log,1,3));
        GameRegistry.addRecipe(new ItemStack(JoistModRegister.VanilaWoodJoist,8,4),"A A","ABA","A A",
                'A',new ItemStack(Blocks.planks,1,4),'B',new ItemStack(Blocks.log2,1,0));
        GameRegistry.addRecipe(new ItemStack(JoistModRegister.VanilaWoodJoist,8,5),"A A","ABA","A A",
                'A',new ItemStack(Blocks.planks,1,5),'B',new ItemStack(Blocks.log2,1,1));

    }
}
