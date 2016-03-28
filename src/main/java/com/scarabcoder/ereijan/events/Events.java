package com.scarabcoder.ereijan.events;

import com.scarabcoder.ereijan.gui.AuthGUI;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class Events {
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	
	@SubscribeEvent
	public void loadWorld(EntityJoinWorldEvent e){
		
		
	}
	
	
	
	@SubscribeEvent
	public void playerAttackEntity(AttackEntityEvent e){
		
	}
	
	@SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {
        if(KeyBindings.auth.isPressed())
    		mc.displayGuiScreen(new AuthGUI());
    }
	
	@SubscribeEvent
	public void onRenderOverlay(RenderGameOverlayEvent e){
		/*if(e.type == RenderGameOverlayEvent.ElementType.TEXT){
			NBTTagCompound tag = new NBTTagCompound();
			tag = mc.thePlayer.getEntityData();
			mc.thePlayer.writeToNBT(tag);
			int maxEssence;
			System.out.println(tag.hasKey("maxEssence"));
			if(tag.hasKey("maxEssence")){
				maxEssence = tag.getInteger("maxEssence");
			}else{
				maxEssence = -1;
			}
			mc.fontRendererObj.drawString(String.valueOf(tag.getInteger("maxEssence")), 50, 50,0xFFFFFF);
		}*/
	}
	
}
