package com.scarabcoder.ereijan.items;

import com.scarabcoder.ereijan.ScarabUtil.Strings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EreijanItems {
	public static void init(){
		//item = new Item(Material.carpet).setUnlocalizedName("item")
		
	}
	
	public static void register(){
		//registerItem(item var)
	}
	
	public static void registerRenders(){
		//registerRender(item var)
	}
	
	
	private static void registerItem(Item item){
		GameRegistry.registerItem(item, name(item));
	}
	
	
	private static String name(Item item){
		return item.getUnlocalizedName().substring(5);
	}
	
	
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Strings.id + ":" + name(item), "inventory"));
	}
}
