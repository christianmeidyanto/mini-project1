package com.miniproject.QrCode;

import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class MyQr {

    // Create QRCode
    @SuppressWarnings({ "rawtypes", "deprecation" })
    public static void createQR(String data, String path, String charset, Map hashMap, int height, int width)
            throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));

        final BufferedImage image = ImageIO.read(new File(path));

        int x = image.getWidth();
        int y = image.getHeight();
        Graphics g = image.getGraphics();
        g.setFont(g.getFont().deriveFont(17f));
        g.setColor(Color.BLACK);
        g.drawString(data, x / 2, y / 6);
        g.dispose();

        ImageIO.write(image, "png", new File(path));

    }

    // Driver code
    // public static void main(String[] args) throws WriterException, IOException,
    // NotFoundException {
    // // The data that the QR code will contain
    // String data = qrCode.getUniquecode();

    // // The path where the image will get saved
    // String path = qrCode.getUniquecode() + ".png";

    // // Encoding charset
    // String charset = "UTF-8";

    // Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new
    // HashMap<EncodeHintType, ErrorCorrectionLevel>();

    // hashMap.put(EncodeHintType.ERROR_CORRECTION,
    // ErrorCorrectionLevel.L);

    // // Create the QR code and save
    // // in the specified folder
    // // as a jpg file
    // createQR(data, path, charset, hashMap, 200, 200);
    // System.out.println("QR Code Generated!!! ");
    // }

}
