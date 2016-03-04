import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class MyPlugIn_ implements PlugInFilter
{
    public int setup(String arg, ImagePlus imp)
    {
        return DOES_8G;
    }

    public void run(ImageProcessor ip)
    {
        byte[] pixels = (byte[]) ip.getPixels();

        // invert the pixel values
        for (int i = 0; i < pixels.length; i++)
        {
            pixels[i] = (byte) (255 - pixels[i]);
        }
    }
    
    public static void main(String[] args)
    {
        MyPlugIn_ plugin = new MyPlugIn_();

        ImagePlus im = new ImagePlus("../../Images/acc.png");
        im.show();

        plugin.setup("", im);
        plugin.run(im.getProcessor());
    }
}
