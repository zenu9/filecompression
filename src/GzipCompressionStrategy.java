import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompressionStrategy implements CompressionStrategy {
    @Override
    public void compressFile(String inputFile, String outputFile) {
        try {
            FileInputStream fileToCompress = new FileInputStream(inputFile);
            FileOutputStream compressedFile = new FileOutputStream(outputFile);
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(compressedFile);

            byte[] data = new byte[1024];
            int readBytes;
            while ((readBytes = fileToCompress.read(data)) >= 0) {
                gzipOutputStream.write(data, 0, readBytes);
            }

            fileToCompress.close();
            gzipOutputStream.close();
            compressedFile.close();

            System.out.println("File compressed using GZIP successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decompressFile(String inputFile, String outputFile) {
        try {
            FileInputStream fileToDecompress = new FileInputStream(inputFile);
            GZIPInputStream gzipInputStream = new GZIPInputStream(fileToDecompress);
            FileOutputStream decompressedFile = new FileOutputStream(outputFile);

            byte[] data = new byte[1024];
            int readBytes;
            while ((readBytes = gzipInputStream.read(data)) >= 0) {
                decompressedFile.write(data, 0, readBytes);
            }

            gzipInputStream.close();
            decompressedFile.close();
            fileToDecompress.close();

            System.out.println("File decompressed using GZIP successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
