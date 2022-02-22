package frc.robot.Vision;
import java.util.ArrayList;

import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.links.SPILink;
import io.github.pseudoresonance.pixy2api.Pixy2Line;
import io.github.pseudoresonance.pixy2api.Pixy2Video;

public class VisionCamera {
    
    private static Pixy2 pixy;

	public static void initialize() {
	    pixy = Pixy2.createInstance(new SPILink()); // Creates a new Pixy2 camera using SPILink
		pixy.init(1); // Initializes the camera and prepares to send/receive data
		//pixy.setLamp((byte) 1, (byte) 1); // Turns the LEDs on
		pixy.setLED(255, 255, 255); // Sets the RGB LED to full white
	}

	public Block getBiggestBlock(byte signature) {
		// Gets the number of "blocks", identified targets, that match signature 1 on the Pixy2,
		// does not wait for new data if none is available,
		// and limits the number of returned blocks to 25, for a slight increase in efficiency
		int blockCount = pixy.getCCC().getBlocks(false, signature, 25);
		System.out.print("Found " + blockCount + " blocks!"); // Reports number of blocks found
		if (blockCount <= 0) {
			return null; // If blocks were not found, stop processing
		}
		ArrayList<Block> blocks = pixy.getCCC().getBlockCache(); // Gets a list of all blocks found by the Pixy2
		Block largestBlock = null;
		for (Block block : blocks) { // Loops through all blocks and finds the widest one
			if (largestBlock == null) {
				largestBlock = block;
			} else if (block.getWidth() > largestBlock.getWidth()) {
				largestBlock = block;
			}
		}
		return largestBlock;
	}
	public int getBlockCount() {
		int blockCount = pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);
		return blockCount;
	}
	public int getWidth() {
		pixy.getResolution();
		int width = pixy.getFrameWidth();
		return width;
	}
}