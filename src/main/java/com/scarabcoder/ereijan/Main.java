package com.scarabcoder.ereijan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.scarabcoder.ereijan.ScarabUtil.ScarabUtil;
import com.scarabcoder.ereijan.ScarabUtil.Strings;
import com.scarabcoder.ereijan.blocks.EreijanBlocks;
import com.scarabcoder.ereijan.events.Events;
import com.scarabcoder.ereijan.events.KeyBindings;
import com.scarabcoder.ereijan.items.EreijanItems;
import com.scarabcoder.ereijan.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Mod(modid = Strings.id, name = Strings.name, version = Strings.version)
public class Main {
	@SidedProxy(clientSide = Strings.clientProxyClass, serverSide = Strings.commonProxyClass)
	public static CommonProxy proxy;

	public static boolean showChat = true;

	public static boolean isAuth = false;

	public static boolean isDoneAuth = false;

	public static Twitter twitter;

	public static String url = "";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		EreijanBlocks.init();
		EreijanBlocks.register();
		EreijanItems.init();
		EreijanItems.register();
		MinecraftForge.EVENT_BUS.register(new Events());
		KeyBindings.init();
	}



	@EventHandler
	public void init(FMLInitializationEvent event){
	}


	@EventHandler
	public void postInit(FMLPostInitializationEvent event) throws Exception{
	    
	}




	private void storeAccessToken(long id, AccessToken accessToken) {

	}

}
