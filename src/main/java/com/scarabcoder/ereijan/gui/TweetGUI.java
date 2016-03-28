package com.scarabcoder.ereijan.gui;

import java.io.IOException;

import com.scarabcoder.ereijan.Main;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatComponentText;

public class TweetGUI extends GuiScreen{

	private GuiTextField text;
	
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
		super.drawScreen(mouseX, mouseY, partialTicks);

        this.drawDefaultBackground();
        this.text.drawTextBox();

		
        this.fontRendererObj.drawString(this.text.getText().length() + "/240", this.width - 40,this.height/2-38, 0xFFFFFF);
        this.buttonList.clear();
        String name;
	     try{
	    name = " as " + Main.twitter.getScreenName();
	     }catch(Exception e){
	    	 name = "";
	     }
	    this.buttonList.add(new GuiButton(1, this.width / 2 - 80, this.height / 5, 160, 20, "Send Tweet" + name));
        super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui(){
		super.initGui();
        this.text = new GuiTextField(1, this.fontRendererObj, 15, this.height/2-46, this.width - 30, 20);
	     
        text.setMaxStringLength(140);
        text.setText("Hello Twitter!");
        this.text.setFocused(true);
        
	}
    protected void mouseClicked(int x, int y, int btn) {
        try {
			super.mouseClicked(x, y, btn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.text.mouseClicked(x, y, btn);
    }
	
	protected void keyTyped(char par1, int par2)
    {
        try {
			super.keyTyped(par1, par2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.text.textboxKeyTyped(par1, par2);
        if(par1 == '\r'){
        	sendTweet();
        }
        
    }
	
	public void sendTweet(){
		try{
    		Main.twitter.updateStatus(this.text.getText());
    		mc.thePlayer.addChatComponentMessage(new ChatComponentText("Sent following tweet:"));
    		mc.thePlayer.addChatComponentMessage(new ChatComponentText("@" + Main.twitter.getScreenName() + ": " + this.text.getText()));
    	}catch(Exception e){
    		mc.thePlayer.addChatComponentMessage(new ChatComponentText("Error sending tweet! Check logs for more information."));
    		e.printStackTrace();
    	}
    	mc.thePlayer.closeScreen();
	}
	protected void actionPerformed(GuiButton guibutton) {
        //id is the id you give your button
        switch(guibutton.id) {
        case 1:
        	sendTweet();
        	break;
        }
        
	}
	public void updateScreen()
    {
        super.updateScreen();
        this.text.updateCursorCounter();
    }
}
