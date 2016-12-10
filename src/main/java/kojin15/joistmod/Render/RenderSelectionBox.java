package kojin15.joistmod.Render;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;
/**
 * Created by kojin15.
 */



@SideOnly(Side.CLIENT)
public class RenderSelectionBox {
    @SubscribeEvent
    public void onRenderSelectionBox(RenderWorldLastEvent event) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        World world = Minecraft.getMinecraft().theWorld;
        MovingObjectPosition MOP = Minecraft.getMinecraft().objectMouseOver;

        if ((player != null) && (world != null)) {

            ItemStack itemStack = player.getCurrentEquippedItem();
            // ItemBlockを持っていて、ブロックにポインタが行っている時
            if ((itemStack != null) && (itemStack.getItem() instanceof ItemBlock) && MOP.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {

                int side = MOP.sideHit;
                ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[side];
                ChunkPosition chunkPosition = new ChunkPosition(MOP.blockX + direction.offsetX, MOP.blockY + direction.offsetY, MOP.blockZ + direction.offsetZ);
                drawSelectionBox(player, chunkPosition, event.partialTicks);
            }
        }
    }

    private void drawSelectionBox(EntityPlayer player, ChunkPosition chunkPosition, float partialTicks) {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        // 線の色 (R, G, B, Alpha)
        GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
        //　線の太さ
        GL11.glLineWidth(2.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDepthMask(false);
        // 線の幅
        float lineWidth = 0.002F;

        if (chunkPosition != null) {
            double var8 = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTicks;
            double var10 = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTicks;
            double var12 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTicks;
            int x = chunkPosition.chunkPosX;
            int y = chunkPosition.chunkPosY;
            int z = chunkPosition.chunkPosZ;
            // 四角形の(始点 X, 始点 Y, 始点 Z, 終点 X, 終点 Y, 終点 Z)
            AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D);
            this.drawOutlinedBoundingBox(aabb.expand(lineWidth, lineWidth, lineWidth).getOffsetBoundingBox(-var8, -var10, -var12));
        }

        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }


    private void drawOutlinedBoundingBox(AxisAlignedBB par1AxisAlignedBB) {
        Tessellator var2 = Tessellator.instance;
        var2.startDrawing(3);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var2.draw();
        var2.startDrawing(3);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var2.draw();
        var2.startDrawing(1);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
        var2.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
        var2.draw();
    }
}

