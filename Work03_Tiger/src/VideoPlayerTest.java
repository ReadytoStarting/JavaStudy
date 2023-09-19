interface Controllable{
	void play();
	void stop();
}
class VideoPlayer implements Controllable{
	public void play() {
		System.out.println("turn on");
	}
	public void stop() {
		System.out.println("turn off");
	}
}
public class VideoPlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VideoPlayer c=new VideoPlayer();
		c.play();
		c.stop();

	}

}
