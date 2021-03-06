package kojin15.joistmod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import kojin15.joistmod.Render.RenderJoistBlock;
import kojin15.joistmod.Render.RenderSelectionBox;
import kojin15.joistmod.Render.RenderhalfR;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = JoistMod.ModID, version = JoistMod.Version, useMetadata = true)
public class JoistMod {
    public static final String ModID = "JoistMod";
    public static final String Version = "1.1.0-stable";

    public static int JoistRenderID;
    public static int halfRRenderID;

    @Mod.Metadata
    public ModMetadata metadate;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        JoistModRegister.RegisterPreinit(event);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            /*レンダーIDの設定。
			 * RenderingRegistry.getNextAvailableRenderId() で、未使用のレンダーIDを取得する。*/
            this.JoistRenderID = RenderingRegistry.getNextAvailableRenderId();
            this.halfRRenderID = RenderingRegistry.getNextAvailableRenderId();

			/*ブロックのレンダラ―を設定する。
			 *RenderingRegistry.registerBlockHandler(ISimpleBlockRenderingHandler); */
            RenderingRegistry.registerBlockHandler(new RenderJoistBlock());
            RenderingRegistry.registerBlockHandler(new RenderhalfR());

            MinecraftForge.EVENT_BUS.register(new RenderSelectionBox());


        }

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    public void loadMeta(ModMetadata meta) {
        meta.modId = ModID;
        meta.version = Version;
        meta.authorList.add("kojin15");
    }
}
