package kr.co.exam03;

public class Speaker {
	private int volume;
	private boolean mute;
	private boolean power;
	
	public Speaker() { }
	public Speaker(int volume) {
		this(volume, false, false);
	}
	public Speaker(int volume, boolean mute) {
		this(volume, mute, false);
	}
	public Speaker(int volume, boolean mute, boolean power) {
		this.setVolume(volume);
		this.mute = mute;
		this.power = power;
	}
	
	private void setVolume(int volume) {
		if(volume >= 0 && volume <= 100) {
			this.volume = volume;
		} else {
			this.volume = 0;
		}
	}
	
	public void volumeUp() {
		if(this.volume + 5 <= 100) {
			this.volume += 5;
		} else {
			this.volume = 100;
		}
	}
	
	public void volumeDown() {
		if(this.volume - 5 >= 0)  {
			this.volume -= 5;
		} else {
			this.volume = 0;
		}
	}
	
	public void toggleMute() {
		this.mute = !this.mute;
	}
	
	public void togglePower() {
		this.power = !this.power;
	}
	
	public String getState() {
		String state = "";
		if(!this.power) {
			state = "전원 OFF";
		} else if(this.mute) {
			state = "음소거";
		} else {
			state = "음량 " + this.volume;
		}
		return state;
	}
}
