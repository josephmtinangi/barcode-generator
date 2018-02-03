package io.github.josephmtinangi;

import java.io.File;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class App {

	public static void main(String[] args) {

		System.out.println("Generating bar code");

		String barCodeData = "JOSEPH PETER MTINANGI";
		String filePath = "QRCode.png";
		String charset = "UTF-8";

		try {
			try {
				createBarCode(barCodeData, filePath, charset, 50, 100);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (WriterException e) {

			e.printStackTrace();
		}

		System.out.println("Done");
	}

	private static void createBarCode(String barCodeData, String filePath,
			String charset, int barCodeheight, int barCodewidth)
			throws WriterException, IOException {

		BitMatrix matrix = new MultiFormatWriter().encode(new String(
				barCodeData.getBytes(charset), charset), BarcodeFormat.CODE_128,
				barCodewidth, barCodeheight);

		MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
				.lastIndexOf('.') + 1), new File(filePath));
	}

}
