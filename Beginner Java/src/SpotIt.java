import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

public class SpotIt {
    public static void main(String[] args) {
        int n = 7;
        //File path = new File("/Users/gautamgupta/Downloads/110857-phone-icons/png");
        File path = new File("/Users/gautamgupta/Downloads/1742323-emojis/png");
        File outputPath = new File("/Users/gautamgupta/Documents/SpotTheDifference/Images");
        String fname = "10_07";

        //readFileNames(File dir);
        //mergeTwoImages(dir);
        String[] fileList = pickListOfNImagesRandom(n, path);
        ImageData[][] fileMatrix= createNXNMatrix(n,fileList, path);
        printMatrixImage(n,fileMatrix,path,fname, outputPath);
    }

    public static void readFileNames(File dir){
        for(String fname: dir.list()){
            System.out.println(fname);
        }
    }


    //Pick N images on random.
    public static String[] pickListOfNImagesRandom(int n, File dir ){
        String[] imageFileNameList = new String[n+5];
        String[] inputFileList = dir.list();
        for(int i =0; i < imageFileNameList.length; i++){
            int random = (int) getRandomIntegerBetweenRange(0,inputFileList.length-1);
            imageFileNameList[i] = inputFileList[random];
        }
        /*
        for(String imageFileNameListItem : imageFileNameList){
            System.out.println(imageFileNameListItem);
        }
        */
        return imageFileNameList;
    }

    //Create N*N matrix of images
    public static ImageData[][] createNXNMatrix(int n, String[] inputImages,File dir){
        ImageData[][] outputMatrix = new ImageData[n][n];
        int wIndex = 0;
        int hIndex = 0;
        BufferedImage image = null;
        try {
        for(int row = 0; row < n; row++){
            for (int column =0; column < n; column++) {
                int rand = (int) getRandomIntegerBetweenRange(0, n - 1);
                ImageData imageData = new ImageData();
                imageData.filename = inputImages[rand];
                outputMatrix[row][column] = new ImageData();
                outputMatrix[row][column].filename = imageData.filename;
                    image = ImageIO.read(new File(dir, imageData.filename));
                    outputMatrix[row][column].w = image.getWidth();
                    outputMatrix[row][column].wIndex = wIndex;
                    wIndex = wIndex + image.getWidth();
                    outputMatrix[row][column].h = image.getHeight();
                    outputMatrix[row][column].hIndex = hIndex;
                    //hIndex = hIndex + image.getHeight();
            }
            hIndex = hIndex + image.getHeight();
            wIndex = 0;
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Print Image FileNames
        for(int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print(outputMatrix[row][column] + " ,");
            }
            System.out.println("");
        }
        return outputMatrix;
    }


    public static void printMatrixImage(int n, ImageData[][] imageData, File path, String fname, File outputPath){
        BufferedImage image = null;
        int[] imageWidthHeight = getImageWidthHeight(imageData);
        BufferedImage combined = new BufferedImage(imageWidthHeight[0], imageWidthHeight[1], BufferedImage.TYPE_INT_ARGB);
        BufferedImage combinedFlip = new BufferedImage(imageWidthHeight[0], imageWidthHeight[1], BufferedImage.TYPE_INT_ARGB);
        BufferedImage combinedFlipRect = new BufferedImage(imageWidthHeight[0], imageWidthHeight[1], BufferedImage.TYPE_INT_ARGB);

        BufferedImage flipImage = null;
        int[] randomPoint = getRandomPointInMatrix(n);
        // paint both images, preserving the alpha channels
        Graphics g = combined.getGraphics();
        Graphics g2 = combinedFlip.getGraphics();
        Graphics g3 = combinedFlipRect.getGraphics();
        try {
            for (int row = 0; row < n; row++) {
                for (int column = 0; column < n; column++) {
                    ImageData imageDataItem = imageData[row][column];
                    image = ImageIO.read(new File(path, imageDataItem.filename));
                    g.drawImage(image,imageDataItem.wIndex ,imageDataItem.hIndex, null);
                    if (row == randomPoint[0] && column == randomPoint[1]){
                        image = flipImageHorizontally(image);
                        g3.setColor(Color.RED);
                        g3.fillRect(imageDataItem.wIndex ,imageDataItem.hIndex,imageDataItem.w,imageDataItem.h);
                    }
                    g2.drawImage(image,imageDataItem.wIndex ,imageDataItem.hIndex, null);
                    g3.drawImage(image,imageDataItem.wIndex ,imageDataItem.hIndex, null);
                }
            }

            g.dispose();
            g2.dispose();
            g3.dispose();
            // Save as new image
            ImageIO.write(combined, "PNG", new File(outputPath, fname+"_Orig.png"));
            ImageIO.write(combinedFlip, "PNG", new File(outputPath, fname+"_Flip.png"));
            ImageIO.write(combinedFlipRect, "PNG", new File(outputPath, fname+"FlipRect.png"));
        }   catch(IOException e){
            e.printStackTrace();
        }
    }


    //Pick a random number in N*N matrix
    //Change / Flip image in Random location
    //Mark the Random location with a Red Square.

    // Utils Methods

    public static int[] getImageWidthHeight(ImageData[][] imageData){
        ImageData lastImage = imageData[imageData.length-1][imageData.length-1];
        int wid = lastImage.w +lastImage.wIndex;
        int hei = lastImage.h + lastImage.hIndex;
        //Print Details
        System.out.println("Last ImageWidthHeight=== Width="+wid+" Height ="+hei);
        return new int[] {wid,hei};
    }

    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public static BufferedImage flipImageHorizontally(BufferedImage sprite){
            BufferedImage img = new BufferedImage(sprite.getWidth(),sprite.getHeight(),BufferedImage.TYPE_INT_ARGB);
            for(int xx = sprite.getWidth()-1;xx>0;xx--){
                for(int yy = 0;yy < sprite.getHeight();yy++){
                    img.setRGB(sprite.getWidth()-xx, yy, sprite.getRGB(xx, yy));
                }
            }
            return img;
    }

    public static boolean isImageSame(BufferedImage biA,BufferedImage biB){
            try {
                // take buffer data from botm image files //
                DataBuffer dbA = biA.getData().getDataBuffer();
                int sizeA = dbA.getSize();
                DataBuffer dbB = biB.getData().getDataBuffer();
                int sizeB = dbB.getSize();
                // compare data-buffer objects //
                if(sizeA == sizeB) {
                    for(int i=0; i<sizeA; i++) {
                        if(dbA.getElem(i) != dbB.getElem(i)) {
                            return false;
                        }
                    }
                    return true;
                }
                else {
                    return false;
                }
            }
            catch (Exception e) {
                System.out.println("Failed to compare image files ...");
                return  false;
            }
    }


    public static int[] getRandomPointInMatrix(int n){
        int[] point = new int[2];
        point[0] = getRandomIntegerBetweenRange(0,n-1);
        point[1] = getRandomIntegerBetweenRange(0,n-1);
        System.out.println("Random Point is:"+ point[0]+","+point[1]);
        return point;
    }
    /*
    public static void mergeTwoImages(File path){
        //File path =
        // load source images
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path, "cellphone-internet-connection.png"));

            BufferedImage overlay = ImageIO.read(new File(path, "broken-cellphone.png"));

            // create the new image, canvas size is the max. of both image sizes
            int w = image.getWidth()+ overlay.getWidth();
            int h = Math.max(image.getHeight(), overlay.getHeight());
            BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

            // paint both images, preserving the alpha channels
            Graphics g = combined.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.drawImage(overlay, image.getWidth(), 0, null);

            g.dispose();

            // Save as new image
            ImageIO.write(combined, "PNG", new File(path, "combined.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
}
