package net.dusterthefirst.simplespigot.util;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.io.FileInputStream;

import net.dusterthefirst.simplespigot.PluginClass;

public class NotifManager {
	
	public static enum NotifType{
		SOUND, TRAY, TRAYSOUND, DISABLED;
	}

	private static SystemTray tray;
	private static TrayIcon trayIcon;
	
	public static boolean traySupported(){
		return SystemTray.isSupported();
	}
	
	public static boolean createTrayIcon(){
		if(traySupported()){
	        trayIcon = new TrayIcon(PluginClass.window.getIconImage());
	        trayIcon.setImageAutoSize(true);
	        tray = SystemTray.getSystemTray();
	        try {
	            tray.add(trayIcon);
	        } catch (AWTException e) {
	            System.out.println("TrayIcon could not be added.");
	            return false;
	        }
	        alert(NotifType.TRAYSOUND, "Your Mother");
		}
		return traySupported();
	}
	
	public static void removeTrayIcon(){
		tray.remove(trayIcon);
	}
	
	public static void alert(NotifType type, String message){
		switch (type) {
		case SOUND:
			Toolkit.getDefaultToolkit().beep();
			break;
		case TRAY:
			trayIcon.displayMessage("Simple Spigot Notification", message, TrayIcon.MessageType.NONE);
			break;
		case TRAYSOUND:
			trayIcon.displayMessage("Simple Spigot Notification", message, TrayIcon.MessageType.NONE);
			 Toolkit.getDefaultToolkit().beep();
			break;
		case DISABLED:
			break;
		}
		
	}
	
	public static void main(String[] args) {
		 Toolkit.getDefaultToolkit().beep();
	}
	
}
