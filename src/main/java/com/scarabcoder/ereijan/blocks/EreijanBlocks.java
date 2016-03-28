package com.scarabcoder.ereijan.blocks;

import com.scarabcoder.ereijan.ScarabUtil.Strings;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EreijanBlocks {
	
	public static Block test;
	
	
	public static void init(){
		test = new TestBlock(Material.carpet).setUnlocalizedName("test");
	}
	
	
	private static String name(Block block){
		return block.getUnlocalizedName().substring(5);
	}
	
	
	private static String name(Item item){
		return item.getUnlocalizedName().substring(5);
	}
	

	public static void register(){
		//registerBlock(block var)
		registerBlock(test);
	}
	

	public static void registerRenders(){
		//registerRender(block var)
		registerRender(test);
	}
	

	

	private static void registerBlock(Block block){
		GameRegistry.registerBlock(block, name(block));
		
	}
	
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Strings.id + ":" + name(item), "inventory"));
	}
}
