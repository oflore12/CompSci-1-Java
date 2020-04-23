
/** 
*The purpose of this class is to model a television
*Odalis Flores 04/23/2020
*/

public class Television {
	//declare private constant manufacturer
	private final String MANUFACTURER;
	//declare private constant screen_size
	private final int SCREEN_SIZE;
	//declare private boolean powerOn
	private boolean powerOn;
	//declare private integer channel
	private int channel;
	//declare private integer volume
	private int volume;
	
	//constructor for television that accepts string brand and integer size
	public Television(String brand, int size) {
		//initialize brand to manufacturer
		MANUFACTURER=brand;
		//initialize size to screen size
		SCREEN_SIZE=size;
		//initialize power on to false
		powerOn = false;
		//initialize volume to 20
		volume = 20;
		//initialize channel to 2
		channel=2;
	}
	//define method set channel that accepts argument station of type integer
	//and returns nothing
	public void setChannel(int station) {
		//initialize channel to station
		channel=station;
	}
	//define method power that changes the status of TV power and returns nothing 
	public void power() {
		//initialize power on to not power on
		powerOn=!powerOn;
	}
	//define method that increases volume and returns nothing
	public void increaseVolume() {
		//increase volume by 1
		volume=volume+1;
	}
	//define method that decreases volume and returns nothing
	public void decreaseVolume() {
		//decrease volume by 1
		volume=volume-1;	
	}
	//define method get channel that returns channel
	public int getChannel() {
		return channel;
	}
	//define method get volume that returns volume
	public int getVolume() {
		return volume;
	}
	//define method get manufacturer that returns manufacturer
	public String getManufacturer(){
		return MANUFACTURER;
	}
	//define method get screen size that returns screen size
	public int getScreenSize() {
		return SCREEN_SIZE;
	}
	

}
