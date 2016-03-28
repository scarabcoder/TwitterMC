package com.scarabcoder.ereijan.gui;

import java.io.IOException;

import com.scarabcoder.ereijan.Main;
import com.scarabcoder.ereijan.ScarabUtil.ScarabUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatComponentText;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class AuthGUI extends GuiScreen{
	Minecraft mc = Minecraft.getMinecraft();

	private boolean showText = false;

	private GuiTextField text;


	public static final int GUI_ID = 20;


	public AuthGUI(){

	}

	public Twitter twitter;

	private AccessToken accessToken;

	private RequestToken requestToken;


	private boolean showTweet = false;

	private boolean showTweetBox;

	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){

        this.drawDefaultBackground();
		if(this.showText){
			this.text.drawTextBox();
		}
		if(!Main.isDoneAuth){
		this.fontRendererObj.drawString("Press get PIN, then in web browser authorize app.", this.width / 2 - 120, this.height / 2, 0xFFFFFF);
		this.fontRendererObj.drawString("Paste pin in text box and press enter.", this.width / 2 - 120, this.height / 2 + 20, 0xFFFFFF);
		}


			//this.text2 = new GuiTextField(2, this.fontRendererObj, 0, this.height/2-46, this.width, 20);


		this.buttonList.clear();
	     if(!Main.isDoneAuth){
				this.buttonList.add(new GuiButton(1,this.width / 2 - 68, this.height/5, 137, 20, "Get PIN"));
				}
				if(Main.isDoneAuth && !this.showTweet){
				this.buttonList.add(new GuiButton(2, 10, 10, 160, 20, "Send Tweet"));


				}
		if(this.showText){
			this.buttonList.add(new GuiButton(3, this.width / 2 - 70, this.height/6 * 4, 140, 20, "Authenticate"));
		}


		super.drawScreen(mouseX, mouseY, partialTicks);


	}

	@Override
	public void initGui(){
		super.initGui();
		 this.text = new GuiTextField(1, this.fontRendererObj, this.width / 2 - 68, this.height/2-46, 137, 20);

	     text.setMaxStringLength(7);
	     text.setText("");
	     this.text.setFocused(true);



	}
	public boolean doesGuiPauseGame()
    {
        return false;
    }
	protected void keyTyped(char par1, int par2)
    {
        try {
			super.keyTyped(par1, par2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println(par1);
        this.text.textboxKeyTyped(par1, par2);


        if(!Main.isDoneAuth){

        }

        //Pressed enter

    }
	  public void updateScreen()
	    {
	        super.updateScreen();
	        this.text.updateCursorCounter();

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

	    protected void actionPerformed(GuiButton guibutton) {
            //id is the id you give your button
            switch(guibutton.id) {
            case 1:
            	if(!Main.isAuth){
            	try{
            	this.twitter = TwitterFactory.getSingleton();
							//Consumer key + consumer secret here.
         	    twitter.setOAuthConsumer("####################", "#########################################");
         	    this.requestToken = twitter.getOAuthRequestToken();
         	    this.accessToken = null;
         	    Main.url = requestToken.getAuthorizationURL();
         	    Main.isAuth = true;
         	    this.showText = true;
            	}catch(Exception e){
         	    	e.printStackTrace();
         	    }
            	}
        		ScarabUtil.openWebpage(Main.url);

            	this.showText = true;

            	break;
            case 2:
            	mc.thePlayer.closeScreen();
            	mc.displayGuiScreen(new TweetGUI());
            	break;
            case 3:
            	if(this.text != null){
            	   try{
             	        accessToken = twitter.getOAuthAccessToken(requestToken, this.text.getText());
             	        System.out.println(twitter.getScreenName());
             	        mc.thePlayer.addChatComponentMessage(new ChatComponentText("Sucessfully connected to Twitter account \"" + twitter.getScreenName() + "\"!"));

             	        Main.isDoneAuth = true;
             	        Main.twitter = this.twitter;

             	      } catch (TwitterException te) {
             	    	mc.thePlayer.addChatComponentMessage(new ChatComponentText("Error connecting to Twitter! Try restarting Minecraft and trying again."));
             	        if(401 == te.getStatusCode()){
             	          System.out.println("Unable to get the access token.");
             	        }else{
             	          te.printStackTrace();
             	        }
             	      }

               	mc.thePlayer.closeScreen();
            	}
            	break;
            }



    }

}
