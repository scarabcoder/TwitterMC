package com.scarabcoder.ereijan.proxy;

import com.scarabcoder.ereijan.blocks.EreijanBlocks;
import com.scarabcoder.ereijan.items.EreijanItems;

public class ClientProxy extends CommonProxy{
	
	
	
	@Override
	public void registerRenders(){
		EreijanItems.registerRenders();
		EreijanBlocks.registerRenders();
	}
}
