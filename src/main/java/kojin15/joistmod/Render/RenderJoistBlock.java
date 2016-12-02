package kojin15.joistmod.Render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import kojin15.joistmod.JoistMod;
import kojin15.joistmod.JoistModRegister;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * Created by kojin15.
 */
public class RenderJoistBlock implements ISimpleBlockRenderingHandler {
    /**
     * インベントリ内でブロックをレンダリングするメソッド。もしshouldRender3DInInventoryがfalseなら空でもいいかも。
     **/
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        if (modelId == this.getRenderId()) {
            Tessellator tessellator = Tessellator.instance;
            renderer.setRenderBounds(0.25D, 0.25D, 0.25D, 0.75D, 0.75D, 0.75D);


            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, -1.0F, 0.0F);
            renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
            tessellator.draw();

            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 1.0F, 0.0F);
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
            tessellator.draw();

            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, -1.0F);
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
            tessellator.draw();

            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0F, 0.0F, 1.0F);
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
            tessellator.draw();

            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0F, 0.0F, 0.0F);
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
            tessellator.draw();

            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0F, 0.0F, 0.0F);
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
            tessellator.draw();

            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }
    }


    /**
     * ワールド内でブロックをレンダリングするメソッド
     **/
    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (modelId == this.getRenderId()) {

            renderer.setRenderBounds(0.25D, 0.25D, 0.25D, 0.75D, 0.75D, 0.75D);
            renderer.renderStandardBlock(block, x, y, z);

            if (world.getBlock(x, y + 1, z) == JoistModRegister.VanilaWoodJoist) {
                renderer.setRenderBounds(0.25D, 0.75D, 0.25D, 0.75D, 1.0D, 0.75D);
                renderer.renderStandardBlock(block, x, y, z);
            }

            if (world.getBlock(x, y - 1, z) == JoistModRegister.VanilaWoodJoist) {
                renderer.setRenderBounds(0.25D, 0.0D, 0.25D, 0.75D, 0.25D, 0.75D);
                renderer.renderStandardBlock(block, x, y, z);
            }

            if (world.getBlock(x + 1, y, z) == JoistModRegister.VanilaWoodJoist) {
                renderer.setRenderBounds(0.75D, 0.25D, 0.25D, 1.0D, 0.75D, 0.75D);
                renderer.renderStandardBlock(block, x, y, z);
            }

            if (world.getBlock(x - 1, y, z) == JoistModRegister.VanilaWoodJoist) {
                renderer.setRenderBounds(0.0D, 0.25D, 0.25D, 0.25D, 0.75D, 0.75D);
                renderer.renderStandardBlock(block, x, y, z);
            }

            if (world.getBlock(x, y, z + 1) == JoistModRegister.VanilaWoodJoist) {
                renderer.setRenderBounds(0.25D, 0.25D, 0.75D, 0.75D, 0.75D, 1.0D);
                renderer.renderStandardBlock(block, x, y, z);
            }

            if (world.getBlock(x, y, z - 1) == JoistModRegister.VanilaWoodJoist) {
                renderer.setRenderBounds(0.25D, 0.25D, 0.0D, 0.75D, 0.75D, 0.25D);
                renderer.renderStandardBlock(block, x, y, z);
            }

            return true;
        }
        return false;
    }

    @Override
    /**インベントリ内で3Dレンダリングするか否かを返すメソッド**/
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    /**
     * 自身のレンダーIDを返すメソッド
     **/
    @Override
    public int getRenderId() {

        return JoistMod.RenderID;
    }

}
