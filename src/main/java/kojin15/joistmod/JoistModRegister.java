package kojin15.joistmod;


import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import kojin15.joistmod.block.BlockhalfR;
import kojin15.joistmod.block.JoistBlock;
import kojin15.joistmod.item.ItemSaw;
import kojin15.joistmod.item.MetaItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

    public static final Block StonehalfR = new BlockhalfR(Material.rock);

    public static final Item StoneSaw = new ItemSaw(Item.ToolMaterial.STONE, "StoneSaw", "stonesaw");
    public static final Item IronSaw = new ItemSaw(Item.ToolMaterial.IRON, "IronSaw", "ironsaw");
    public static final Item DiamondSaw = new ItemSaw(Item.ToolMaterial.EMERALD, "DiamondSaw", "diamondsaw");


    static void RegisterPreinit(FMLPreInitializationEvent event){

        GameRegistry.registerBlock(VanilaWoodJoist, MetaItemBlock.class ,"VanilaWoodJoist");

        GameRegistry.registerBlock(StonehalfR, "Stone 1/2 R");

        GameRegistry.registerItem(StoneSaw, "StoneSaw");
        GameRegistry.registerItem(IronSaw, "IronSaw");
        GameRegistry.registerItem(DiamondSaw, "DiamondSaw");

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

        GameRegistry.addRecipe(new ItemStack(JoistModRegister.StoneSaw, 1, 0),"  A"," B ","C  ",
                'A', Items.stone_axe, 'B',Blocks.cobblestone, 'C',Items.stick);
        GameRegistry.addRecipe(new ItemStack(JoistModRegister.IronSaw, 1, 0),"  A"," B ","C  ",
                'A', Items.iron_axe, 'B',Items.iron_ingot, 'C',Items.stick);
        GameRegistry.addRecipe(new ItemStack(JoistModRegister.DiamondSaw, 1, 0),"  A"," B ","C  ",
                'A', Items.diamond_axe, 'B',Items.diamond, 'C',Items.stick);

    }
}
