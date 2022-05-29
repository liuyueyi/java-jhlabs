package com.jhlabs.test;

import com.jhlabs.composite.ColorDodgeComposite;
import com.jhlabs.image.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @link code from <a href="https://blog.csdn.net/ailiana/article/details/108468349">https://blog.csdn.net/ailiana/article/details/108468349</a>
 * @link source imgs comes from <a href="https://www.pexels.com/zh-cn/photo/4252859/">https://www.pexels.com/zh-cn/photo/4252859/</a>
 * @link source imgs comes from <a href="https://www.pexels.com/zh-cn/photo/163036/">https://www.pexels.com/zh-cn/photo/163036/</a>
 * parse image to skecth
 */
public class Img2SketchTest {

    public static void main(String[] args) throws IOException {
        toSketch("cartoon.jpg", "assets/img/cartoon.png");
        toSketch("photo.jpg", "assets/img/photo.png");
    }


    private static void toSketch(String imgPath, String output) throws IOException {
        BufferedImage src = ImageIO.read(Objects.requireNonNull(Img2SketchTest.class.getClassLoader().getResourceAsStream(imgPath)));
        src = ImageUtils.convertImageToARGB(src);

        //图像灰度化
        PointFilter grayScaleFilter = new GrayscaleFilter();
        BufferedImage grayScale = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
        grayScaleFilter.filter(src, grayScale);

        //灰度图像反色
        BufferedImage inverted = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
        PointFilter invertFilter = new InvertFilter();
        invertFilter.filter(grayScale, inverted);

        //高斯模糊处理
        GaussianFilter gaussianFilter = new GaussianFilter(20);
        BufferedImage gaussianFiltered = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
        gaussianFilter.filter(inverted, gaussianFiltered);

        // 灰度图像和高斯模糊反向图混合
        ColorDodgeComposite cdc = new ColorDodgeComposite(1.0f);
        CompositeContext cc = cdc.createContext(inverted.getColorModel(), grayScale.getColorModel(), null);
        WritableRaster invertedR = gaussianFiltered.getRaster();
        WritableRaster grayScaleR = grayScale.getRaster();
        // 混合之后的就是我们希望的结果
        BufferedImage composite = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
        WritableRaster colorDodgedR = composite.getRaster();
        cc.compose(invertedR, grayScaleR, colorDodgedR);

        //输出做好的素描
        File outputfile = new File(output);
        ImageIO.write(composite, "png", outputfile);
    }

}
